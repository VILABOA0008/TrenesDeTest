package cosillas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ToSwagger {

  public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException {
    
    String clase = "UnitRepresentation";

    String url =
        "C:\\GIT\\PAPERLESS_old\\PDV_EMB\\PDV_EMB\\paperless\\paperless-seed\\src\\main\\java\\com\\ctag\\paperless";

    File buscar = buscar(url, clase + ".java");
    String paquete = getPackage(buscar);
    String clas = clase.substring(0, 1).toLowerCase() + clase.substring(1);
    clas = clas.replace("Representation", "");

    Class leer = Class.forName(paquete + clase);
    

    Map<String, String> toSwaggerType = new HashMap<>();
    toSwaggerType.put("String", "          type: string");
    toSwaggerType.put("Integer", "          format: int32\r\n" + "          type: integer");
    toSwaggerType.put("Instant", "          format: date-time\r\n" + "          type: string");
    toSwaggerType.put("BigDecimal", "          format: double\r\n" + "          type: number");
    toSwaggerType.put("LocalDate", "          format: date\r\n" + "          type: string");
    toSwaggerType.put("LocalDateTime", "          format: date\r\n" + "          type: string");
    toSwaggerType.put("Boolean", "          type: boolean");

    ArrayList<String> sinId = new ArrayList<>();
    ArrayList<String> onSwagger = new ArrayList<>();
    ArrayList<String> required = new ArrayList<>();
    ArrayList<String> toString = new ArrayList<>();
    ArrayList<String> toStringTypes = new ArrayList<>();
    ArrayList<String> vars = new ArrayList<>();
    ArrayList<String> varsTypes = new ArrayList<>();

    for (int i = 0; i < leer.getDeclaredFields().length; i++) {

      if (!leer.getDeclaredFields()[i]
          .getName()
          .contentEquals(leer.getDeclaredFields()[i].getName().toUpperCase())) {

        // to string
        if (leer.getDeclaredFields()[i].getType().getModifiers() == 17
            || leer.getDeclaredFields()[i].getName().contains("Id")) {

          toString.add(leer.getDeclaredFields()[i].getName());
          toStringTypes.add(leer.getDeclaredFields()[i].getType().getSimpleName());
          if (!leer.getDeclaredFields()[i].getName().equalsIgnoreCase("id")) {

            // Simple vars Integer Boolean Instant String...
            if (leer.getDeclaredFields()[i].getType().getModifiers() == 17) {
              vars.add(leer.getDeclaredFields()[i].getName());
              varsTypes.add(leer.getDeclaredFields()[i].getType().getSimpleName());
            }
          }
        }

        // classes
        if (leer.getDeclaredFields()[i].getType().getModifiers() == 1) {
          String name = leer.getDeclaredFields()[i].getName();
          name = name.toUpperCase().substring(0, 1) + name.substring(1);
          if (name.contains("Id")) {
          } else {
            sinId.add("id" + name);
          }
        }
      }
    }

    sinId.forEach(
        n -> {
          required.add("\n        - "+n);
          onSwagger.add(
              "\n        "
                  + n
                  + ": \r\n"
                  + "          description: \""
                  + n.substring(0, 2)
                  + " "
                  + n.substring(2)
                  + "\"\r\n"
                  + "          format: int32\r\n"
                  + "          type: integer");
        });

    vars.forEach(
        n -> {
          int c = 0;
          required.add("\n        - "+n);
          onSwagger.add("\n        "+n+": \r\n" + 
              "          description: \""+n+" of "+clase+"\"\n"+toSwaggerType.get(varsTypes.get(c)));
//          System.err.println(varsTypes.get(c) + "  we  " + n);
          c++;
        });
    
 


    String a =
        "    "+clase+"Create: \r\n"
            + "      description: \"This contains values to create a "
            + clase
            + "\"\r\n"
            + "      properties: "
            +onSwagger
            + "\n      required: "
            +required+"\n"
            + "      type: object   ";
    
    a=a.replace(",", "");
    a=a.replace("[", "");
    a=a.replace("]", "");
    System.err.println(a ); 
  
  String b="    "+clase+":\r\n" + 
      "      allOf: \r\n" + 
      "        - $ref: \"#/components/schemas/"+clase+"Create\"\r\n" + 
      "        - description: \"This contains values to update a "+clase+"\"\r\n" + 
      "          properties: \r\n" + 
      "            id"+clase+": \r\n" + 
      "              description: \"id "+clase+"\"\r\n" + 
      "              format: int32\r\n" + 
      "              type: integer\r\n" + 
      "          required: \r\n" + 
      "            - id"+clase+"\r\n" + 
      "          type: object";

  System.err.println("\n"+b);
  
  }
  
  
  
  public static File buscar(String url, String clas) {
    File found = null;
    File clases = new File(url);

    for (File file : new ArrayList<>(Arrays.asList(clases.listFiles()))) {
      if (file.isDirectory()) {
        found = buscar(file.getAbsolutePath(), clas);
        if (found != null) {
          return found;
        }
      } else {
        if (file.getName().equalsIgnoreCase(clas)) {
          return file;
        }
      }
    }

    return found;
  }

  public static String getPackage(File file) throws FileNotFoundException {

    Scanner sc = new Scanner(file);

    while (sc.hasNextLine()) {
      String nextLine = sc.nextLine();
      if (nextLine.contains("package")) {
        nextLine = nextLine.replace(" ", "");
        nextLine = nextLine.replace("package", "");
        nextLine = nextLine.replace(";", "");
        sc.close();
        return nextLine + ".";
      }
    }
    sc.close();

    return null;
  }

  
  
}