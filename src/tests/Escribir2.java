package tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Escribir2 {

  public static void escribir(String ruta, String texto,String clase) {

//    ruta="C:\\Users\\pabcos\\Documents\\FactorioTes\\src\\Main\\test.java";
    
    File archivo = new File(ruta);
    archivo.mkdir();
    archivo=new File(archivo.getPath()+"\\"+clase+".java");
    //       if(!archivo.exists()){
    try {
      FileWriter aWriter = new FileWriter(archivo, false);
      aWriter.write(texto);
      aWriter.flush();
      aWriter.close();
      System.out.println("bien");
    } catch (IOException e) {
      System.out.println("Ruta Erronea Cambiela Plis.");
    }
    //   }else {System.out.println("existe");}

  }
}
