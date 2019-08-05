package Main;

import java.util.ArrayList;
import java.util.Map;

public class ApiService {

  public static String Methods(
      String clas,
      ArrayList<ArrayList<String>> nameMap,
      ArrayList<ArrayList<String>> inMap,
      ArrayList<ArrayList<String>> typeMap,
      ArrayList<String[]> pcoMap,
      Map<String, String> typeMapping) {
    String ApiService = "\n\n  public abstract class " + clas + " {\n\n";
    for (int i = 0; i < inMap.size(); i++) {
      String auxConstructor = "";
      if (!nameMap.get(i).isEmpty()) {
        for (int j = 0; j < nameMap.get(i).size(); j++) {

          auxConstructor +=
              typeMapping.get(typeMap.get(i).get(j)) + " " + nameMap.get(i).get(j) + ",";
        }
        auxConstructor = auxConstructor.substring(0, auxConstructor.length() - 1);
      }

      ApiService +=
          "public abstract Response " + pcoMap.get(i)[2] + "(" + auxConstructor + ");\n\n";
    }

    ApiService += "\n}\n";

    return ApiService;
  }
}
