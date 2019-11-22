package cosillas;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Crear_Clase_de_Test {

  private static final int POST = 1;
  private static final int GET = 2;

  public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException {

    int mode = POST;
    String clase = "PartVersionResource";

    String url =
        "C:\\GIT\\PAPERLESS_old\\PDV_EMB\\PDV_EMB\\paperless\\paperless-seed\\src\\main\\java\\com\\ctag\\paperless";

    File buscar = buscar(url, clase + ".java");
    String paquete = getPackage(buscar);
    String clas = clase.substring(0, 1).toLowerCase() + clase.substring(1);
    clas = clas.replace("Representation", "");

    String c = "\"";
    String cc = "\\\"";
    String json = c + "{" + c;

    ArrayList<String> basicos = new ArrayList<>(Arrays.asList("Integer", "LocalDate"));
    Map<String, String> map = new HashMap<>();
    map.put("Integer", "+1+");
    map.put("LocalDate", "null");

    Class leer = Class.forName(paquete + clase);

    for (int i = 0; i < leer.getMethods().length; i++) {
//    System.err.println(leer.getMethods()[i] );
      System.err.println( ); 
    for (int j = 0; j < leer.getMethods()[i].getAnnotations().length; j++) {
      Annotation nota=leer.getMethods()[i].getDeclaredAnnotations()[j];
//      if(nota.toString().contains("POST")||nota.toString().contains("PUT")||nota.toString().contains("GET")) {
//      System.err.println(leer.getMethods()[i].getAnnotations()[j] ); 
//    System.err.println(leer.getMethods()[i].getDeclaredAnnotations()[j] ); 
      Annotation[][] parameterAnnotations = leer.getMethods()[i].getParameterAnnotations();
    System.err.println(parameterAnnotations ); 
    }
    }    
    
    System.exit(1);
    for (int i = 0; i < leer.getDeclaredFields().length; i++) {
      Field field = leer.getDeclaredFields()[i];
      String type = field.getType().getSimpleName();
      json += "\n +" + c + cc + field.getName() + cc + ":";
      if (basicos.contains(type)) {

        switch (mode) {
          case 1:
            json += c + map.get(type) + c;
            break;
          case 2:
            json += c + "+ " + clas + ".get" + toMayusq(field.getName() + "()+ "+c);
            break;
        }

      } else {
        switch (mode) {
          case 1:
            json += cc + "new" + field.getName() + cc;
            break;
          case 2:
            String aux = "";
            if (type.equalsIgnoreCase("string")) {
              aux = cc;
            }

            json += aux + c + "+ " + clas + ".get" + toMayusq(field.getName()) + "()+ " + c + aux;
            break;
        }
      }
      if (i != leer.getDeclaredFields().length - 1) {
        json += ",";
      }
      json += c;
    }

    json += "\n+" + c + "}" + c + ";";

    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(json), null);
    System.err.println(json);
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

  public static String toMayusq(String a) {

    return a.substring(0, 1).toUpperCase() + a.substring(1);
  }
}
