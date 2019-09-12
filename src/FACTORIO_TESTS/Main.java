package FACTORIO_TESTS;

import java.io.File;

public class Main {

  public static void main(String[] args) throws Exception {

    String packaje = "com.ctag.paperless.domain.model.";
    String urlFiles = "C:\\GIT\\PAPERLESS_old\\PDV_EMB\\PDV_EMB\\paperless\\paperless-seed\\src\\main\\java\\com\\ctag\\paperless\\domain\\model";
//    buscarAgregados(packaje, urlFiles);
    buscarFactoriesOld(packaje, urlFiles);
    
    
    

  }
  
  public static void buscarFactoriesOld(String packaje, String urlFile) {
    String pack = "", clase;
    String url = packaje;
    File files = new File(urlFile);

    for (File i : files.listFiles()) {
      pack = i.getName();
      for (File q : i.listFiles()) {
        if (q.getName().contains("Default")) {
          clase = q.getName().split("\\.")[0];
//          System.err.println(url + pack + "  " + clase);
          try {
            GetInfo.testFactories(url, pack, clase);
          } catch (Exception e) {
            System.err.println(e);
          }
        }
      }

    }

  }
  
  
  public static void buscarAgregados(String packaje, String urlFile) {
    String pack = "", clase;
    String url = packaje;
    File files = new File(urlFile);

    for (File i : files.listFiles()) {
      System.err.println("\n");
      pack = i.getName();
      for (File q : i.listFiles()) {
        if (q.getName().contains("Id")) {
          clase = q.getName().split("\\.")[0].replace("Id", "");
          System.err.println(url + pack + "  " + clase);
          try {
            System.err.println("url  " + url + "\n Package:  " + pack + "\n Clase: " + clase);
            GetInfo.testAgregados(url, pack, clase);
          } catch (Exception e) {
            System.err.println(e);
          }
        }
      }

    }

  }
}
