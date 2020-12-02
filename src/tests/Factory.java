package tests;

import java.util.ArrayList;

public class Factory {

  public static void FactoryTest(
      String url,String pack, String claseFactory, String[] types, String vars[], String nameMethod) {
    claseFactory = claseFactory.replace("Default", "");
    String clase = claseFactory.replace("Factory", "");
    claseFactory = clase + "Factory";
    String b = "", asserts = "", d = "";
    for (int i = 0; i < types.length; i++) {
      String value;
      String var = vars[i];
      switch (types[i]) {
        case "String":
          value = "\"" + vars[i] + "\"";
          break;
        case "boolean":
          value = "true";
          break;
        case "Boolean":
          value = "true";
          break;
        case "Double":
          value = "1D";
          break;
        case "Instant":
          value = "Instant.now()";
          break;
        case "Float":
          value = "1f";
          break;
        case "LocalDateTime":
          value = "LocalDateTime.now()";
          break;
        case "LocalDate":
          value = "LocalDate.now()";
          break;
        default:
          value = "1";
          if (types[i].contains("Id")) {
            value = "new " + types[i] + "(1)";
          }
      }
      String upper=var;
      for (int j = 0; j < upper.length(); j++) {
        if(upper.substring(j, j+1).equals(upper.substring(j, j+1).toUpperCase())) {
          upper=upper.substring(0,j)+"_"+upper.substring(j);
          j++;
        }
        
      }
      
      var = upper.toUpperCase();
      if (var.contains("ID")) {
//        if (var.substring(0, 2).contains("ID")) {
//          var = var.replace("ID", "ID_");
//        } else {
//          var = var.replace("ID", "_ID");
//        }
        asserts +=
            "    assertThat(object.get"
                + vars[i]
                    .substring(0, 1)
                    .replace(vars[i].substring(0, 1), vars[i].substring(0, 1).toUpperCase())
                + vars[i].substring(1)
                + "()).isNotNull().isEqualTo("
                + var
                + ");\n";
      } else {
        asserts +=
            "    assertThat(object.get"
                + vars[i]
                    .substring(0, 1)
                    .replace(vars[i].substring(0, 1), vars[i].substring(0, 1).toUpperCase())
                + vars[i].substring(1)
                + "()).isNotNull().isEqualTo("
                + var
                + ");\n";
      }
      b += "  private static final " + types[i] + " " + var + " = " + value + ";\n";
      d += var + ",";
    }
    d = d.substring(0, d.length() - 1);
    String a =
        "package "
            + url
            + ";\n"
            + "\n"
            + "import static org.assertj.core.api.Assertions.assertThat; \n"
            + "import javax.inject.Inject;\n"
            + "import javax.transaction.Transactional;\n"
            + "\n"
            + "import org.junit.Before;\n"
            + "import org.junit.Test;\n"
            + "\n"
            + "@RunWith(SeedITRunner.class)\n"
            + "@Transactional\n"
            + "@JpaUnit\n"
            + "public class "
            + claseFactory
            + "IT {\n"
            + "\n"
            + b
            + "\n"
            + "\n"
            + "@Inject private "
            + claseFactory
            + " factory;\n"
            +"  @Inject private "+clase+"Repository repo;" 
            + "\n\n"
            + "private "+clase+" object; \n"
            +"\n" + 
            "  @After\n" + 
            "  public void tearDown() throws Exception {\n" + 
            "    if (object != null) {\n" + 
            "      try {\n" + 
            "        repo.remove(object.getId());\n" + 
            "      } catch (AggregateNotFoundException | EntityNotFoundException e) {\n" + 
            "        // launched when object not exists in repo\n" + 
            "      }\n" + 
            "    }\n" + 
            "  }\n"
            + "  @Test\n"
            +"  public void testCreate"
            + clase
            + "() throws Exception {\n"
            + "\n"
            + " object = factory."
            + nameMethod
            + "("
            + d
            + ");\n"
            + "    assertThat(object).isNotNull();\n"
            + asserts
            + "\n" 
            +"    "+clase+" repoObject = repo.get(object.getId()).get();\n" 
            +"    assertThat(object.getId()).isNotNull().isEqualTo(repoObject.getId());\n" 
            + "}\n"
            + "}\n"
            + "";
    ArrayList<String> clases = new ArrayList<>();
    clases.add("PartState");
    clases.add("LineType");
    System.err.println(a);
    for (String l : clases) {
      if (l.equalsIgnoreCase(clase)) {
        //        Escribir2.escribir("", a, claseFactory);
        break;
      }
    }
  }
}
