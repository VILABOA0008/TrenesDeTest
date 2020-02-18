package aFACTORIO_TESTS;

import java.io.File;

public class Main {

  public static final String PACKAGE = "com.ctag.paperless.core.domain.model.";
  public static final String URL_FILES =
      "C:\\GIT\\paperless\\core\\core-specs\\src\\main\\java\\com\\ctag\\paperless\\core\\domain\\model";

  public static void main(String[] args) throws Exception {

    buscarAgregados();
    //    buscarFactoriesOld(packaje, urlFiles);
    // buscarAgregateIdOld(packaje, urlFiles);
    //    String key = "Representation";
    //    buscarFactoriesOld(packaje, urlFiles, key);

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
    String pack = "", clase;
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
              GetInfo.testRepresentationOld(url, pack, clase);

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

  public static void buscarAgregados() {
    String classPakage = "", clase;
    String bigPackage = PACKAGE;
    File files = new File(URL_FILES);

    for (File i : files.listFiles()) {
      classPakage = i.getName();
      for (File q : i.listFiles()) {
        if (q.getName().contains("Id")) {
          clase = q.getName().split("\\.")[0].replace("Id", "");
          try {
            GetInfo.testAgregados(bigPackage, classPakage, clase);
          } catch (Exception e) {
          }
        }
      }
    }
  }
}
