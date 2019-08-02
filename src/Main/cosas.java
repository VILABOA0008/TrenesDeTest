package Main;

import java.util.ArrayList;
import java.util.Map;

public class cosas {

  public static String contains(String s,String ini,char f) {
    boolean inic=false;
    String r="";
    for(int i=0;i<s.length();i++) {
      if(inic==false) {r+=s.charAt(i);
      if(r.contains(ini)) {inic=true;r="";}}else {
        if(s.charAt(i)==f) {break;}else {
        r+=s.charAt(i);}
      }     
    }
    return r;
  }
  
  public static String eliminaralgo(String s,String x) {
    
    String r=s.replace(x, "");
    
    return r;
  }
  
  public static String limpiarlinea(String s) {
    String r="";
    boolean stop;
    for(int i=0;i<s.length();i++) {
      if(s.charAt(i)!=' ') {r=s.substring(i);break;}      
    }
    for(int i=r.length()-1;i>0;i--) {
      System.out.println("char"+r.charAt(i));
      if(r.charAt(i)!=' ') {r=r.substring(0,i);break;}      
    }
    return r;
  }
  public static void typeMapping(Map<String,String>typeMapping ,Map<Integer,ArrayList<ArrayList<String>>>  typeMap) {
    
    
    typeMapping.put("string", "String");
    typeMapping.put("binary", "Byte[]");
    typeMapping.put("bytearray", "Byte[]");
    typeMapping.put("boolean", "Boolean");
    typeMapping.put("integer", "Integer");
    typeMapping.put("float", "Decimal");
    typeMapping.put("long", "Long");
    typeMapping.put("double", "Double");
    typeMapping.put("number", "Double");
    typeMapping.put("datetime", "Date");
    typeMapping.put("date", "Date");
    typeMapping.put("file", "System.IO.Stream");
    typeMapping.put("array", "List");
    typeMapping.put("list", "List");
    typeMapping.put("map", "Dictionary");
    typeMapping.put("object", "Object");
    typeMapping.put("uuid", "Guid?");
    

  }
  
  
}
