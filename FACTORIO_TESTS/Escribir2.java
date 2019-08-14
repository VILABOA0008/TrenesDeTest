package com.ctag.paperless.psa.totem.FACTORIO_TESTS;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Escribir2 {

  public static void escribir(String ruta, String texto,String clase) {

    ruta="C:\\GIT\\PSA\\Totem\\backend\\totem-specs\\src\\test\\java\\ut\\com\\ctag\\paperless\\psa\\totem\\FACTORIO_TESTS\\escribir\\TESTS_GENERADOS";
//    ruta="C:\\GIT\\paperless\\quality\\quality-specs\\src\\test\\java\\ut\\com\\ctag\\paperless\\quality\\domain\\model\\"+ruta;
    File archivo = new File(ruta);
//    archivo.mkdir();
//    System.err.println(archivo.getPath());
//    System.err.println(archivo.list()[0]);
    archivo=new File(archivo.getPath()+"\\"+clase+"UnitTest.java");
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
