package Main;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class leer {

  public static void Leer()
      throws IOException {
    Integer cmetodos=0;
    String clase="";
     Map<Integer, String> metodos = new HashMap<Integer, String>();
     String lastPath="";
    boolean no = false;
    String cons="";
    // pass the path to the file as a parameter
    FileReader fr = new FileReader(
        "C:\\Users\\pabcos\\Documents\\FactorioTes\\src\\Main\\PageApi.java");
    String oldMethod="";  String newMethod="";
    String oldPath="",newPath="";
    boolean show = true;//para el principio
    int c = 0;
    String a = "";
    
    int ii;
    while ((ii = fr.read()) != -1) {
      if (ii != '\n') {
        a += (char) ii;

      } else {
        //Que no ense�e el principio
        if (show == false) {
          if (a.contains("schemes:")) {
            a = "";
            show = true;
          }
        } else {

            cons+=a;
            //que detecete la siguiente url para salir y cuantos parametros tiene el metodo
            if (a.contains("  /")||a.contains("  '/")) {
              if(!a.contains(clase)) {

//                System.out.println(cons+"\n\n OTHER PATH \n\n\n");
                oldPath=newPath;
                newPath=a;
                a=a.substring(2);
                clase=a.split(":")[0];
//                method=false;
              }else {
//              System.out.println(cons+"\n\n FIN ROOT PATHHH  \n"+clase+"\n\n" );
                oldPath=newPath;
                newPath=a;
              
              }}else
            if(a.contains("definitions:")) {
              System.out.println(cons+"\n\n FINNNNNNNNNNNNNNN\n\n\n"+c);System.exit(1);
            }
            else if((a.contains("get:")||a.contains("post:")||a.contains("put:")||a.contains("delete:"))&&cons.length()>40) {
              oldMethod=newMethod;
              newMethod=a.replace(" ", "");
          inside(cons,oldPath,oldMethod);
          c++;
//              System.out.println("\nSTART\n"+cons+"\n\n FIN HTTP METHOD \n\n\n");
          a="";
              cons=a;
          }
            a = "";
        }
      }
    }
    System.out.println("");
    for(int i=0;i<metodos.size();i++) {
      System.out.println(metodos.get(i));
  }}
  
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
}
