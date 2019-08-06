package Main;

import java.util.ArrayList;
import java.util.Map;

public class Api {
  
  
  public static String  httpMethod(String clas,ArrayList<ArrayList<String>> nameMap,
      ArrayList<ArrayList<String>> inMap,
      ArrayList<ArrayList<String>>  typeMap,
      ArrayList<Boolean> consumesMap,
      ArrayList<Boolean> producesMap,
      ArrayList<String[]> pcoMap,
      Map<String,String>typeMapping){    
    String consumes="",produces="";
    String r="";
    for(int i=0;i<producesMap.size();i++) {
      String auxConstructor="";
      String auxReturn="";
if(!nameMap.get(i).isEmpty()) {
      for(int j=0;j<nameMap.get(i).size();j++) {
        auxReturn+=nameMap.get(i).get(j)+",";
        String in;
        if(inMap.get(i).get(j).equalsIgnoreCase("query")) {in="@QueryParam(\""+nameMap.get(i).get(j)+"\") ";}else if(inMap.get(i).get(j).equalsIgnoreCase("path")){
          in="@PathParam(\""+nameMap.get(i).get(j)+"\") ";}else {
          in="    ";
        }
        auxConstructor+= in+typeMapping.get(typeMap.get(i).get(j))+" "+nameMap.get(i).get(j)+",";
        
      }
      auxReturn=auxReturn.substring(0,auxReturn.length()-1);
      auxConstructor=auxConstructor.substring(0,auxConstructor.length()-1);}
      
      if(consumesMap.get(i)) {consumes=   "@Consumes(MediaType.APPLICATION_JSON)\n" ;}
      if(producesMap.get(i)) {produces=  "@Produces(MediaType.APPLICATION_JSON)\n";}
   
    
    r+="@"+pcoMap.get(i)[1].toUpperCase()+"\n"+
        "@Path(\""+pcoMap.get(i)[0]+"\")\n" + 
        produces+
        consumes+
        "public Response "+pcoMap.get(i)[2]+"("+auxConstructor+") {\n" + 
        "\n" + 
        "return delegate."+pcoMap.get(i)[2]+"("+auxReturn+");\n" + 
        "}\n\n";
    
  
  }
    return r;  
  }

  
  
  
}
