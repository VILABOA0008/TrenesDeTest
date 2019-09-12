package FACTORIO_TESTS;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

public class GetInfo {
  
  
  public static void testFactories(String url, String pack, String clase) throws Exception {

//    System.err.println("URL           " + url + "\nPACKAGE     " + pack + "\nCLASE         " + clase);
    System.err.println("\n\n\nCLASE         " + clase);
    url = url + pack;
    Class leer = Class.forName(url + "." + clase);
    Method m=null;
    Method[]methods=leer.getDeclaredMethods();
    if(methods.length==2) {
      if(methods[0].getParameterCount()>methods[1].getParameterCount()) {
        m=methods[0];}else {m=methods[1];}
      }else if(methods.length==1) {
        
        m=methods[0];
        
      }else {
        
        System.err.println(clase+"  +de 2 methodos");
      }
    
    if(m!=null) {
      String types[]=new String[m.getParameterCount()];
      String vars[]=new String[m.getParameterCount()];
      System.err.println(m.toGenericString());
      int c=-1;
    for(Parameter g:m.getParameters()) {
      c++;
      types[c]=g.getType().getSimpleName();
      vars[c]=g.getName();
      System.err.println(g.getType().getSimpleName()+"  "+g.getName());
      
    }
      Factory.FactoryTest(pack, clase, types, vars);
    }
  }

  
  public static void testAgregados(String url, String pack, String clase) throws Exception {
    // Class leer =
    // Class.forName("com.ctag.paperless.core.domain.model.bomdefinition.BomDefinition");
    ArrayList<String> conId = new ArrayList<>();
    ArrayList<String> sinId = new ArrayList<>();
    ArrayList<String> sets = new ArrayList<>();
    ArrayList<String> setsType = new ArrayList<>();
    ArrayList<String> toString = new ArrayList<>();
    ArrayList<String> toStringTypes = new ArrayList<>();
    ArrayList<String> vars = new ArrayList<>();
    ArrayList<String> varsTypes = new ArrayList<>();
    url = url + pack;
    // System.err.println(url+"."+clase);
    Class leer = Class.forName(url + "." + clase);
    for (int i = 0; i < leer.getDeclaredFields().length; i++) {
      // remove Static Strings

      System.err.println(leer.getDeclaredFields()[i].getName() + "  "
          + leer.getDeclaredFields()[i].getType().getModifiers() + "  " +
          leer.getDeclaredFields()[i].getType().getSimpleName());
      if (!leer.getDeclaredFields()[i].getName()
          .contentEquals(leer.getDeclaredFields()[i].getName().toUpperCase())) {

        // to string
        if (leer.getDeclaredFields()[i].getType().getModifiers() == 17
            || leer.getDeclaredFields()[i].getName().contains("Id")) {

          toString.add(leer.getDeclaredFields()[i].getName());
          toStringTypes.add(leer.getDeclaredFields()[i].getType().getSimpleName());
          if (!leer.getDeclaredFields()[i].getName().equalsIgnoreCase("id")) {

            // Simple vars Integer Boolean Instant String
            if (leer.getDeclaredFields()[i].getType().getModifiers() == 17) {
              vars.add(leer.getDeclaredFields()[i].getName());
              varsTypes.add(leer.getDeclaredFields()[i].getType().getSimpleName());
            }

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
          String type = leer.getDeclaredFields()[i].getGenericType().getTypeName().split(
              "\\.")[leer.getDeclaredFields()[i].getGenericType().getTypeName().split("\\.").length
                  - 1];
          type = type.replace(">", "");
          setsType.add(type);
          // System.err.println(leer.getDeclaredFields()[i].getType().getModifiers()+"
          // "+leer.getDeclaredFields()[i].getType()+" "+leer.getDeclaredFields()[i].getName());
        }
      }
    }
    Agregador.clase(url, clase, conId, sinId, sets, setsType, vars,
        varsTypes,toString,toStringTypes);

  }
}
