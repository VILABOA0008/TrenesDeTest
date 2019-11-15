package cosillas;

import java.awt.Toolkit;
  import java.awt.datatransfer.StringSelection;
  import java.io.File;
  import java.io.FileNotFoundException;
  import java.lang.reflect.Field;
  import java.util.ArrayList;
  import java.util.Arrays;
  import java.util.HashMap;
  import java.util.Map;
  import java.util.Scanner;

  public class Buscar_Clase {

    public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException {

      String url =
          "C:\\GIT\\PAPERLESS_old\\PDV_EMB\\PDV_EMB\\paperless\\paperless-seed\\src\\main\\java\\com\\ctag\\paperless";
      String clase = "ShiftSummaryRepresentation";

      File buscar = buscar(url, clase + ".java");
      String paquete = getPackage(buscar);
      String clas = clase.substring(0, 1).toLowerCase() + clase.substring(1);
      clas = clas.replace("Representation", "");

      String c = "\"";
      String cc = "\\\"";
      String json = c + "{" + c;

      ArrayList<String> basicos = new ArrayList<>(Arrays.asList("Integer", "LocalDate"));
      Map<String, String> map = new HashMap<>();
      map.put("Integer", "1");
      map.put("LocalDate", "null");

      int mode = 1;

      Class leer = Class.forName(paquete + clase);
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
              json += c + "+ " + clas + ".get ";
              if (i != leer.getDeclaredFields().length - 1) {
                json += "+ " + c;
              }
              break;
          }

        } else {
          switch (mode) {
            case 1:
              json += cc + "new" + field.getName() + cc;
              break;
            case 2:
              json += c + "+ " + clas + ".get ";
              if (i != leer.getDeclaredFields().length - 1) {
                json += "+ " + c;
              }
              break;
          }
        }
        if (i != leer.getDeclaredFields().length - 1) {
          json += "," + c;
        }
        //      System.err.print(leer.getDeclaredFields()[i].getName() );
        //      System.err.println("   "+leer.getDeclaredFields()[i].getType().getSimpleName() );

      }

      json += "\n+" + c + "}" + c;

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
  }
