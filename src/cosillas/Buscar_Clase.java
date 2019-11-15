package cosillas;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Buscar_Clase {

  public static void main(String[] args) throws ClassNotFoundException {

    String json="{";
    String paquete = "com.ctag.paperless.rest.shiftsummary.";
    String clase = "ShiftSummaryRepresentation";
    
    ArrayList<String>basicos=new ArrayList<>(Arrays.asList("Integer","LocalDate"));
    Map<String, String> map=new HashMap<>();
    map.put("Integer", "1");
    map.put("LocalDate", "null");
    
    Class leer = Class.forName(paquete + clase);
    for (int i = 0; i < leer.getDeclaredFields().length; i++) {
      
      Field field = leer.getDeclaredFields()[i];
      String type = field.getType().getSimpleName();
      json+="\n\""+field.getName()+"\":";
      if(basicos.contains(type)) {
        
        json+=map.get(type);
      }else {
        json+="new"+field.getName();
        
      }
      json+=",";
//      System.err.print(leer.getDeclaredFields()[i].getName() ); 
//      System.err.println("   "+leer.getDeclaredFields()[i].getType().getSimpleName() ); 
      
    }

    json+="}";
    json=json.replace(",}", "\n}");
    
    Toolkit.getDefaultToolkit()
    .getSystemClipboard()
    .setContents(
            new StringSelection(json),
            null
    );
    System.err.println(json ); 
  }

  public static File buscar(String url, String clas) {

    File clases = new File(url);
    for (File file : new ArrayList<>(Arrays.asList(clases.listFiles()))) {
      if (file.getName().equalsIgnoreCase(clas)) {
        return file;
      }
    }

    return null;
  }
}
