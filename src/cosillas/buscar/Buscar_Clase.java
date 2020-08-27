package cosillas.buscar;

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

  private static final int POST = 1;
  private static final int GET = 2;

  public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException {

    int testType = 1;
    int mode = GET;
    String clase = "WeekTemplateDayApiServiceImpl";

    String url =
        "C:\\GIT\\PEI-BE\\pei-rest\\src\\main\\java\\com\\ctag\\paperless\\psa\\rest";
    File buscar = buscar(url, clase + ".java");
    String paquete = getPackage(buscar);
    String clas = clase.substring(0, 1).toLowerCase() + clase.substring(1);
    clas = clas.replace("Representation", "");
    Class leer = Class.forName(paquete + clase);
    // System.err.println(clase.split("Api")[0]);

    switch (testType) {
      case 1:
        integrationTests(leer, clase.split("Api")[0]);
    }

    System.exit(1);
    String c = "\"";
    String cc = "\\\"";
    String json = c + "{" + c;

    ArrayList<String> basicos = new ArrayList<>(Arrays.asList("Integer", "LocalDate"));
    Map<String, String> map = new HashMap<>();
    map.put("Integer", "+1+");
    map.put("LocalDate", "null");

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
            json += c + "+ " + clas + ".get" + toMayusq(field.getName() + "()+ " + c);
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

  public static void integrationTests(Class leer, String clase) {
    ArrayList<String> methods = new ArrayList<>();
    for (int i = 0; i < leer.getDeclaredMethods().length; i++) {
      if (leer.getDeclaredMethods()[i].getReturnType().toString().contains("Response")) {
        String name = leer.getDeclaredMethods()[i].getName();
        name = "test" + name.substring(0, 1).toUpperCase() + name.substring(1);
        if(!name.contains("$")) {
        methods.add(name);}
        //        System.err.println(name );

      }
    }
    IntegrationSample.integrationTestClass(clase, methods);
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
