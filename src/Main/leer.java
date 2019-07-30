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
     Map<Integer, String> metodos = new HashMap<Integer, String>();

    boolean no = false;
    String cons="";
    // pass the path to the file as a parameter
    FileReader fr = new FileReader(
        "C:\\Users\\pabcos\\Documents\\FactorioTes\\src\\Main\\PageApi.java");
    boolean method = false;
    boolean show = false;
    int c = 0;
    String a = "";
    
    int ii;
    while ((ii = fr.read()) != -1) {
      if (ii != '\n') {
        a += (char) ii;

      } else {
        //Que no enseñe el principio
        if (show == false) {
          if (a.contains("}")) {
            a = "";
            show = true;
          }
        } else {
          //si no esta dentro de un metodo
          if (!method) {
            //que detecte el nombre
            if (a.contains("public Response")) {
              method = true;
            }
          }

          if (method) {
            cons+=a;
            //que detecete el return para salir y cuantos parametros tiene el metodo
            if (a.contains("return")) {

              if(a.contains("()")){c=0;}else {
              c=a.split(",").length;}
              
              String contains = cosas.contains(a, "delegate.", '(');
              metodos.put(cmetodos, contains+c);
              cmetodos++;

              
              cons=cosas.contains(cons, "Response", '{');
              cons=cons.replace("\n", "");
              cons=cons.replace("\r", "");
              cons=cosas.limpiarlinea(cons);
              System.out.println("\n\ncons \n"+cons+"\n cons\n\n");
              

              
              method = false;
            }
            
//            System.out.print(a);
            a = "";
            
          } else {
            a = "";
          }

        }

        // String[] r=a.split(" ");
        // for(String q:r) {
        // System.out.println(q);
        // }
      }

    }
    System.out.println("");
    for(int i=0;i<metodos.size();i++) {
      System.out.println(metodos.get(i));
  }}
}
