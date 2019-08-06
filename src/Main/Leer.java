package Main;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Leer {

  public static void Leer()
      throws IOException {
    Integer cmetodos=0;
    String clase="";
    Map<String,Integer> clasMap = new HashMap<>();
    Map<Integer,ArrayList<Boolean>> consumesMap = new HashMap<>();
    Map<Integer,ArrayList<Boolean>> producesMap = new HashMap<>();
    Map<Integer,ArrayList<String>> refParamMap = new HashMap<>();
    Map<Integer,ArrayList<String>> refResponseMap = new HashMap<>();
    Map<Integer,ArrayList<String[]>> pcoMap = new HashMap<>();
     Map<Integer,ArrayList< ArrayList<String>>> nameMap = new HashMap<>();
     Map<Integer, ArrayList<ArrayList<String>>>  inMap = new HashMap<>();
     Map<Integer, ArrayList<ArrayList<String>>> typeMap= new HashMap<>();
     String lastPath="";
    boolean no = false;
    String cons="";
    // pass the path to the file as a parameter
    FileReader fr = new FileReader(
        "C:\\Users\\pabcos\\Documents\\FactorioTes\\src\\Main\\PageApi2.java");
    String oldMethod="";  String newMethod="";
    String oldPath="",newPath=null;
    boolean show = true;//para el principio
    int c = 0;
    int cc=-1;
    String a = "";
    
    int ii;
    while ((ii = fr.read()) != -1) {
      if (ii != '\n') {
        a += (char) ii;

      } else {
        //Que no enseñe el principio
        if (show == false) {
          if (a.contains("schemes:")) {
            a = "";
            show = true;
          }
        } else {
            cons+=a;
            if(a.contains(  "'/bom/{idBom}'")) {
              System.out.println("dsa" ); 
            }
            if (a.contains("  /")||a.contains(" '/")) {
              if(!a.contains(clase)) {

                newPath=a;
                a=a.substring(2);
                clase=oldPath.split(":")[0];
              }else {
                if(newPath==null) {newPath=a;oldPath=newPath;}
                newPath=a;
                
              }}else
            if(a.contains("definitions:")||a.contains("components:")) {
              oldMethod=newMethod;
              oldMethod=oldMethod.replace(":", "");
              
          cc=inside(cc,cons,newPath,oldMethod,clasMap,nameMap,inMap,typeMap,consumesMap,producesMap,pcoMap);
          System.out.println(cons+"\n\n FINNNNNNNNNNNNNNN\n\n\n"+c);
          Leer2.processing(clasMap,nameMap,inMap,typeMap,consumesMap,producesMap,pcoMap);

            }
            else if((a.contains("get:")||a.contains("post:")||a.contains("put:")||a.contains("delete:"))&&cons.length()>40) {
              oldMethod=newMethod;
              newMethod=a.replace(" ", "");
              if(oldMethod=="") {oldMethod=newMethod;}
              oldMethod=oldMethod.replace(":", "");
          cc=inside(cc,cons,oldPath,oldMethod,clasMap,nameMap,inMap,typeMap,consumesMap,producesMap,pcoMap);
          oldPath=newPath;
          c++; a=""; cons=a;
          }
            a = "";
        }
      }
    }
    Leer2.processing(clasMap,nameMap,inMap,typeMap,consumesMap,producesMap,pcoMap);
  }
  public static int inside(int cc,String cons,String clase,String method, 
      Map<String, Integer> clasMap,
      Map<Integer ,ArrayList<ArrayList<String>>> nameMap,
      Map<Integer ,ArrayList<ArrayList<String>>> inMap,
      Map<Integer,ArrayList<ArrayList<String>>>  typeMap,
      Map<Integer,ArrayList<Boolean>> consumesMap,
      Map<Integer,ArrayList<Boolean>> producesMap,
      Map<Integer,ArrayList<String[]>> pcoMap) {
    clase=clase.replace(" ", "");
    boolean response=false;
    final String  fName="- name:",fIn="in:",fType="type:",fOperation="operationId:",fref="$ref";
    ArrayList<String>nameArray = new ArrayList<>();
    ArrayList<String>inArray = new ArrayList<>();
    ArrayList<String>typeArray = new ArrayList<>();
    String operationId ="";
    String responseType ="";
    String stag="";
    boolean tag=false;
    String refParam=null,refResponse=null;
    boolean produces=false;
    boolean consumes=false;
    String[] lineas=cons.split("\r");
    
 for(String i:lineas) {
   if(tag) {stag=i.replace(" ", "").replace("-", "");tag=false;}
   if(!response) {
     if(i.contains("tags:")) {tag=true;}  
     
     //PARAMETERS
   if(i.contains("responses:")) {response=true;}   
   if(i.contains("produces:")) {produces=true;}
   if(i.contains("consumes:")) {consumes=true;}
   
 if(i.contains(fName)) {
   i=i.replace(fName, "");i= i.replace(" ", "");
   nameArray.add(i);   
 }
 if(i.contains(fIn)) {
   i=i.replace(fIn, "");i= i.replace(" ", "");
   inArray.add(i);   
 }
 if(i.contains(fType)) {
   i=i.replace(fType, ""); i=i.replace(" ", "");
   typeArray.add(i);
 }
 if(i.contains(fOperation)) {
   i=i.replace(fOperation, ""); i=i.replace(" ", "");
   operationId=i;}
   
   if(i.contains(fref)) {
     i=i.replace(fref, ""); i=i.replace(" ", "");
     refParam=i;}
   
 }else {
   //RESPONSE
   if(i.contains(fType)) {
     i=i.replace(fType, ""); i=i.replace(" ", "");
     responseType=i;
   }   
   if(i.contains(fref)) {
     i=i.replace(fref, ""); i=i.replace(" ", "");
     refResponse=i;}
   
   
 }
      
    }   
    System.out.println("\n\nSTART-----  "+clase+"\n"+cons+"\n\n FIN------");
    System.out.println("\n\n\nBODDY\n"+clase +"\n"+method+"\n"+stag+"\n"+operationId); 
    if(consumes) {System.out.println("Consumes Json" ); }
    if(produces) {System.out.println("Produces Json" ); }
    for(int i=0;i<nameArray.size();i++) {
      System.out.println(nameArray.get(i)+"    in  "+inArray.get(i) +"    in  "+typeArray.get(i) ); 
    }
    if(refResponse!=null) {System.out.println("$ref  "+refParam ); }  
    System.out.println("Response Type: "+responseType ); 
    if(refResponse!=null) {System.out.println("$ref  "+refResponse ); }
    System.out.println("\n\n" ); 
    clase=clase.replace(":", "").replace("\r", "").replace("'", "");
    Integer map=clasMap.get(stag);
    if(map == null) {
      cc++;
      clasMap.put(stag, cc);
      nameMap.put(cc, new ArrayList<>());
      nameMap.get(cc).add(nameArray);
      typeMap.put(cc, new ArrayList<>());
      typeMap.get(cc).add(typeArray);
      inMap.put(cc, new ArrayList<>());
      inMap.get(cc).add(inArray);
      consumesMap.put(cc, new ArrayList<>());
      consumesMap.get(cc).add(consumes);
      producesMap.put(cc, new ArrayList<>());
      producesMap.get(cc).add(produces);
      String[] pco= {clase,method,operationId};
      pcoMap.put(cc, new ArrayList<>());
      pcoMap.get(cc).add(pco);
    }else {
      nameMap.get(map).add(nameArray);
      typeMap.get(map).add(typeArray);
      inMap.get(map).add(inArray);
      consumesMap.get(map).add(consumes);
      producesMap.get(map).add(produces);
      String[] pco= {clase,method,operationId};
      pcoMap.get(cc).add(pco);
    }
    return cc;
  }
}


/*
   public static void inside(String cons,String clase,String method) {
    clase=clase.replace(" ", "");
    ArrayList<String>nameArray = new ArrayList<>();
    ArrayList<String>inArray = new ArrayList<>();
    ArrayList<String>operationArray = new ArrayList<>();
    boolean name=false, in=false;
    String auxprin="", sname="", sin="";
    for(int i=0;i<cons.length();i++) {
      
      if(auxprin.contains("operationId:")) {
        operationArray.add(auxprin);        
      }
      
      if(in) {
        if(cons.charAt(i)=='\r') {
          sin=sin.replace("in:", "");
          sin=sin.replace(" ", "");
          inArray.add(sin);in=false;
          auxprin="";
          }else {
        sin+=cons.charAt(i);}
      }else {
      if(name) {
        if(cons.charAt(i)=='\r') {
          nameArray.add(sname);name=false;in=true;sin="";
          }else {
        sname+=cons.charAt(i);}}
      
      else {
      if(auxprin.contains("- name: ")){auxprin="";name=true;sname="";sname+=cons.charAt(i);}else {
      auxprin+=cons.charAt(i);}}}
      
      
    }   
    System.out.println("\n\nSTART-----  "+clase+"\n"+cons+"\n\n FIN------");
    System.out.println("\n\n\nBODDY\n"+clase +"\n"+method); 
    for(int i=0;i<nameArray.size();i++) {
      System.out.println(nameArray.get(i)+"    in  "+inArray.get(i) ); 
    }
    System.out.println("\n\n" ); 
  }
  */
