package bSSEMBLER_TESTS;

public class Main {

  public static void main(String[] args) throws ClassNotFoundException {

    String paquete = "com.ctag.paperless.psa.fer.model.factorylayout.assembler.component";
    String clase = "ComponentAssemblerTest";

    Class leer = Class.forName(paquete + "." + clase);
    for (int i = 0; i < leer.getDeclaredFields().length; i++) {
      System.err.println(leer.getDeclaredFields()[i]);
      if (!leer.getDeclaredFields()[i]
          .getName()
          .contentEquals(leer.getDeclaredFields()[i].getName().toUpperCase())) {}
    }
  }
}
