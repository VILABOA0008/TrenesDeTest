package Main;

import java.util.ArrayList;
import java.util.Map;

public class Cc {
  
  
  public static String  httpMethod(String clas,ArrayList<ArrayList<String>> nameMap,
      ArrayList<ArrayList<String>> inMap,
      ArrayList<ArrayList<String>>  typeMap,
      ArrayList<Boolean> consumesMap,
      ArrayList<Boolean> producesMap,
      ArrayList<String[]> pcoMap) {    
    String consumes="",produces="";
    String r="";
    for(int i=0;i<producesMap.size();i++) {
      if(consumesMap.get(i)) {consumes=   "@Consumes(MediaType.APPLICATION_JSON)\n" ;}
      if(producesMap.get(i)) {produces=  "@Produces(MediaType.APPLICATION_JSON)\n";}
   
    
    r+="@"+pcoMap.get(i)[1].toUpperCase()+"\n"+
        "@Path("+pcoMap.get(i)[0]+")\n" + 
        produces+
        consumes+
        "public Response "+pcoMap.get(i)[2]+"(@PathParam(ID_PAGE) Integer id, final PageDto pageRepresentation) {\n" + 
        "\n" + 
        "return delegate.updatePage(id, pageRepresentation);\n" + 
        "}\n\n";
    
  
  }
    return r;  
  }
  public static String  a(String s) {    
    String r="";
    
    return r;    
  }  
  public static String  b(String s) {    
    String r="";
    
    return r;    
  }
  
  public static String  c(String s) {    
    String r="";
    
    return r;    
  }
  
  
  
  
}
