package tests;

import java.io.File;

public class Main {
  
  public static final String PACK = "realtimesystemmonitoring";
  public static final String CLASE = "RealTimeSystemMonitoringFactory";
  public static final String PACKAGE = "com.ctag.paperless.psa.domain.model."+PACK;
  public static final String URL_FILES =
      "C:\\GIT\\PEI-BE\\pei-specs\\src\\main\\java\\com\\ctag\\paperless\\psa\\domain\\model\\"+PACK;

  public static void main(String[] args) throws Exception {

    buscarAgregados(CLASE);

    //        buscarFactoriesOld(packaje, urlFiles);
    //     buscarAgregateIdOld(packaje, urlFiles);
    //    String key = "Representation";
    //    buscarFactoriesOld(packaje, urlFiles, key);

  }

  public static void buscarAgregados(String clase) {
    String classPakage = "";
    String bigPackage = PACKAGE;
    File files = new File(URL_FILES);

    try {

      for (File i : files.listFiles()) {
        classPakage = i.getName();
        if (clase != null) {
          classPakage = classPakage.toLowerCase().replace(".java", "");
//                      GetInfo.testAgregados(bigPackage, classPakage, clase);
                      GetInfo.testFactoriesOld(bigPackage, classPakage, clase);
//                      GetInfo.testAgregadoIdOld(bigPackage, classPakage, clase);
//                      GetInfo.testRepresentationOld(bigPackage, clase);
        }
        for (File q : i.listFiles()) {
          if (q.getName().contains("Id")) {
            clase = q.getName().split("\\.")[0].replace("Id", "");

            GetInfo.testAgregados(bigPackage, classPakage, clase);
          }
        }
      }
    } catch (Exception e) {
    }
  }

  public static void buscarAgregateIdOld(String packaje, String urlFile) {
    String pack = "", clase;
    String url = packaje;
    File files = new File(urlFile);

    for (File i : files.listFiles()) {
      pack = i.getName();
      for (File q : i.listFiles()) {
        if (q.getName().contains("Id")) {
          clase = q.getName().split("\\.")[0];
          // System.err.println(url + pack + " " + clase);
          try {
            //            GetInfo.testAgregadoIdOld(url, pack, clase);
          } catch (Exception e) {
            System.err.println(e);
          }
        }
      }
    }
  }

  public static void buscarFactoriesOld(String packaje, String urlFile, String key) {
    String pack = "";
    String clase;
    String url = packaje;
    File files = new File(urlFile);

    for (File i : files.listFiles()) {
      pack = i.getName();
      for (File q : i.listFiles()) {

        if (q.getName().contains(key)) {
          clase = q.getName().split("\\.")[0];
          // System.err.println(url + pack + " " + clase);
          try {
            if (key.equalsIgnoreCase("representation")) {
              GetInfo.testRepresentationOld(pack, clase);

            } else {
              //            GetInfo.testFactoriesOld(url, pack, clase);
            }
          } catch (Exception e) {
            System.err.println(e);
          }
        }
      }
    }
  }
}
