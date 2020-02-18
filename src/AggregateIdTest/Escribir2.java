package AggregateIdTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Escribir2 {

  public static void escribir(String ruta, String texto,String clase) {

    System.err.println(clase+"\n\n\n"+texto+"\n\n\n\n\n");
//    ruta="C:\\Users\\pabcos\\Documents\\FactorioTes\\src\\testsss";
    System.err.println(ruta);
    File archivo = new File(ruta);
    archivo.mkdir();
    archivo=new File(archivo.getPath()+"\\"+clase+".java");
    //       if(!archivo.exists()){
    try {
      FileWriter aWriter = new FileWriter(archivo, false);
//      aWriter.write(texto);
//      aWriter.flush();
//      aWriter.close();
      System.out.println("bien");
    } catch (IOException e) {
      System.out.println("Ruta Erronea Cambiela Plis.");
    }
    //   }else {System.out.println("existe");}

  }
}
