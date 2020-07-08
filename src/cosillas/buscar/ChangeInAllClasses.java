package cosillas.buscar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ChangeInAllClasses {


  public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException {

    String url =
        "C:\\GIT\\PEI-BE\\psa-pei-specs\\src\\main\\java\\com\\ctag\\paperless\\psa\\domain\\model";

    SubClass(url);

  }


  public static String getPackage(File file) throws FileNotFoundException {

    Scanner sc = new Scanner(file);

    while (sc.hasNextLine()) {
      String nextLine = sc.nextLine();
      if (nextLine.contains("package")) {
        nextLine = nextLine.replace(" ", "");
        nextLine = nextLine.replace("package", "");
        nextLine = nextLine.replace(";", "");
        sc.close();
        return nextLine + ".";
      }
    }
    sc.close();

    return null;
  }

  public static void SubClass(String url) throws FileNotFoundException {
    File found = null;
    File clases = new File(url);

    for (File file : new ArrayList<>(Arrays.asList(clases.listFiles()))) {
      if (file.isDirectory()) {
        SubClass(file.getAbsolutePath());
      } else {
        Scanner s = new Scanner(file);
        while (s.hasNext()) {
          if (s.nextLine().contains("@EmbeddedId")) {
            System.err.println(file.getName());
            //            modifyFile(
            //                file.getAbsolutePath(), "private static final String KEY_VAL =
            // \"KeyVal\";", "");
            //            modifyFile(file.getAbsolutePath(), "private static final String ID =
            // \"id\"; ", "");
            //            modifyFile(
            //                file.getAbsolutePath(), "private static final String SEQUENCE =
            // \"SEQUENCE\";", "");
            //            modifyFile(file.getAbsolutePath(), " SEQUENCE,", "Constants.SEQUENCE,");
            //            modifyFile(file.getAbsolutePath(), " VALUE,", "Constants.VALUE,");
            //            modifyFile(file.getAbsolutePath(), " KEY_VAL,", "Constants.KEY_VAL,");
            modifyFile(file.getAbsolutePath(), "@EmbeddedId", "@Embedded");
          }
        }
        s.close();
      }
    }
  }

  public static String toMayusq(String a) {

    return a.substring(0, 1).toUpperCase() + a.substring(1);
  }

  static void modifyFile(String filePath, String oldString, String newString) {
    File fileToBeModified = new File(filePath);

    String oldContent = "";

    BufferedReader reader = null;

    FileWriter writer = null;

    try {
      reader = new BufferedReader(new FileReader(fileToBeModified));

      // Reading all the lines of input text file into oldContent

      String line = reader.readLine();

      while (line != null) {
        oldContent = oldContent + line + System.lineSeparator();

        line = reader.readLine();
      }

      // Replacing oldString with newString in the oldContent
      String newContent = oldContent.replace(oldString, newString);

      // Rewriting the input text file with newContent

      writer = new FileWriter(fileToBeModified);

      writer.write(newContent);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        // Closing the resources

        reader.close();

        writer.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
