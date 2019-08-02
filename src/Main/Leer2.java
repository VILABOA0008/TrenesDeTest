package Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Leer2 {
  
  public static void processing(      Map<String, Integer> clasMap,
      Map<Integer ,ArrayList<ArrayList<String>>> nameMap,
      Map<Integer ,ArrayList<ArrayList<String>>> inMap,
      Map<Integer,ArrayList<ArrayList<String>>>  typeMap,
      Map<Integer,ArrayList<Boolean>> consumesMap,
      Map<Integer,ArrayList<Boolean>> producesMap,
      Map<Integer,ArrayList<String[]>> pcoMap) {
    
    clasMap.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
    String clas="Account";
    
    Map<String,String>typeMapping = new HashMap<String, String>();
    cosas.typeMapping(typeMapping,typeMap);
      for (Entry<Integer, ArrayList<ArrayList<String>>> entry : typeMap.entrySet()) {
        System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
      }
      String r="";
    for(int c=0;c<clasMap.size();c++) {
     r+=Cc.httpMethod(clas,nameMap.get(c),inMap.get(c),typeMap.get(c),consumesMap.get(c),producesMap.get(c),pcoMap.get(c),typeMapping);
    }
   Escribir.escribir(null, r); 
    
  }
  
  
  
  
}
