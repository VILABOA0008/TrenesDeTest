package Main;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import tests.Test;

public class Factorio_Test_Main {

  public static void main(String[] args) throws Exception {
//       Leer.Leer();
    
//    Test.tests();
    
    Class leer = Class.forName("com.ctag.paperless.core.domain.model.bomdefinition.BomDefinition");
    for (int i=0;i<leer.getDeclaredFields().length;i++) {
      if(!leer.getDeclaredFields()[i].getName().contentEquals(leer.getDeclaredFields()[i].getName().toUpperCase())) {
     System.err.println(leer.getDeclaredFields()[i].getType().getModifiers()+"   "+leer.getDeclaredFields()[i].getName());
     }
      }
    System.err.println("\n");
    for (Method q : leer.getDeclaredMethods()) {
      if(q.getModifiers()==1) {
      System.err.println(q.getName()+"  "+q.getModifiers());
      for (Parameter x : q.getParameters()) {
        System.err.print("   "+x.getName());}
      }
    }
      
    
  }
}
