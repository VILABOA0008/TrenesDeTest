package AggregateIdTest;

import java.io.File;

public class Main {

  public static void main(String[] args) throws Exception {
    String s; 
    String url="C:\\GIT\\paperless\\quality\\quality-specs\\src\\main\\java\\com\\ctag\\paperless\\quality\\domain\\model";
    File a=new File(url);
   for (File i : a.listFiles()) {   
      for (File q : i.listFiles()) {   
        if(q.getName().contains("Id")) {
       s=q.getName().split("\\.")[0];IdClass.Id(i.getName(),s);
        System.err.println(s);}
    }
    
  }
    
    
    String test="";
    
    buscar(url);
  }
  
  public static void buscar(String url) {
    
    
    File a=new File(url);
   for (File i : a.listFiles()) {   
    System.err.println("\n\n");
    
    for (File q : i.listFiles()) {   
      if(q.getName().contains("Id")) {
      System.err.println(q.getName().split("\\.")[0]);}
    }
    
  }

  
  }
  
}
