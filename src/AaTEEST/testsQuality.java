package AaTEEST;

import java.io.File;
import java.util.ArrayList;

public class testsQuality {

  public static void main(String[] args) throws Exception {

    buscar();

  }

  public static void test(String url, String pack, String clase) throws Exception {
    // Class leer =
    // Class.forName("com.ctag.paperless.core.domain.model.bomdefinition.BomDefinition");
    ArrayList<String> conId = new ArrayList<>();
    ArrayList<String> sinId = new ArrayList<>();
    ArrayList<String> sets = new ArrayList<>();
    ArrayList<String> toString = new ArrayList<>();
    ArrayList<String> toStringTypes = new ArrayList<>();
    url = url + pack;
    // System.err.println(url+"."+clase);
    Class leer = Class.forName(url + "." + clase);
    for (int i = 0; i < leer.getDeclaredFields().length; i++) {
      // remove Static Strings
      if (!leer.getDeclaredFields()[i].getName()
          .contentEquals(leer.getDeclaredFields()[i].getName().toUpperCase())) {

        // to string
        if (leer.getDeclaredFields()[i].getType().getModifiers() == 17
            || leer.getDeclaredFields()[i].getName().contains("Id")) {

          System.err.println(leer.getDeclaredFields()[i].getName() + "  "
              + leer.getDeclaredFields()[i].getType().getModifiers() + "  " +
              leer.getDeclaredFields()[i].getType().getSimpleName());
          if (!leer.getDeclaredFields()[i].getName().equalsIgnoreCase("id")) {
            toString.add(leer.getDeclaredFields()[i].getName());
            toStringTypes.add(leer.getDeclaredFields()[i].getType().getSimpleName());
          }
        }

        // classes
        if (leer.getDeclaredFields()[i].getType().getModifiers() == 1) {
          String name = leer.getDeclaredFields()[i].getName();
          if (name.contains("Id")) {
            conId.add(name);
          } else {
            sinId.add(name);
          }

          // sets
        } else if (leer.getDeclaredFields()[i].getType().getModifiers() == 1537) {
          sets.add(leer.getDeclaredFields()[i].getName());

          // System.err.println(leer.getDeclaredFields()[i].getType().getModifiers()+"
          // "+leer.getDeclaredFields()[i].getType()+" "+leer.getDeclaredFields()[i].getName());
        }
      }
    }
    Agregador.toString(url, clase, toString, toStringTypes);
    // Agregador.clase(url, clase,conId,sinId,sets);

    // System.exit(1);
    // System.err.println("\n");
    // for (Method q : leer.getDeclaredMethods()) {
    // if(q.getModifiers()==1) {
    // System.err.println(q.getName()+" "+q.getModifiers());
    // for (Parameter x : q.getParameters()) {
    // System.err.print(" "+x.getName());}
    // }
    // }

  }

  public static void buscar() {
    String url = "com.ctag.paperless.quality.domain.model.";
    String pack = "", clase;
    File a = new File(
        "C:\\GIT\\paperless\\quality\\quality-specs\\src\\main\\java\\com\\ctag\\paperless\\quality\\domain\\model");
    for (File i : a.listFiles()) {
      System.err.println("\n");
      pack = i.getName();
      for (File q : i.listFiles()) {
        if (q.getName().contains("Id")) {
          clase = q.getName().split("\\.")[0].replace("Id", "");
          System.err.println(url + pack + "  " + clase);
          try {
            test(url, pack, clase);
          } catch (Exception e) {
          }
        }
      }

    }

  }
}
