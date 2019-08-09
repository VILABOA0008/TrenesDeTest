package tests;

import java.io.File;

public class Test {

  public static String tests(String s) {
    
    File a=new File("C:\\GIT\\paperless\\quality\\quality-specs\\src\\main\\java\\com\\ctag\\paperless\\quality\\domain\\model");
   for (File i : a.listFiles()) {   
      for (File q : i.listFiles()) {   
        if(q.getName().contains("Id")) {
       s=q.getName().split("\\.")[0];Clases.Id(i.getName(),s);
        System.err.println(s);}
    }
    
  }
    
    
    String test="";
    
//    buscar();
    return test;
  }
  
  public static void buscar() {
    
    
    File a=new File("C:\\GIT\\paperless\\quality\\quality-specs\\src\\main\\java\\com\\ctag\\paperless\\quality\\domain\\model");
   for (File i : a.listFiles()) {   
    System.err.println("\n\n");
    
    for (File q : i.listFiles()) {   
      if(q.getName().contains("Id")) {
      System.err.println(q.getName().split("\\.")[0]);}
    }
    
  }

  
  }
  
}
