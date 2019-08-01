package Main;

import java.util.ArrayList;
import java.util.Map;

public class Leer2 {
  
  public static void processing(      Map<String, Integer> clasMap,
      Map<Integer ,ArrayList<ArrayList<String>>> nameMap,
      Map<Integer ,ArrayList<ArrayList<String>>> inMap,
      Map<Integer,ArrayList<ArrayList<String>>>  typeMap,
      Map<Integer,ArrayList<Boolean>> consumesMap,
      Map<Integer,ArrayList<Boolean>> producesMap,
      Map<Integer,ArrayList<String[]>> pcoMap) {
    
    clasMap.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
    int c=4;
    String clas="client";
    String r=Cc.httpMethod(clas,nameMap.get(c),inMap.get(c),typeMap.get(c),consumesMap.get(c),producesMap.get(c),pcoMap.get(c));
    
   Escribir.escribir(null, r); 
    
  }
  
  
  
  
}
