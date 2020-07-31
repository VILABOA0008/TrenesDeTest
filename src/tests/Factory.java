package tests;

import java.util.ArrayList;

public class Factory {

  public static void FactoryTest(
      String pack, String claseFactory, String[] types, String vars[], String nameMethod) {
    System.err.println(" asdasd   "+claseFactory ); 
    String claseFactoryDefault=claseFactory;
    claseFactory = claseFactory.replace("Default", "");
    String clase = claseFactory.replace("Factory", "");
    claseFactory = clase + "Factory";
    String b = "", asserts = "", d = "";
    for (int i = 1; i < types.length; i++) {
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
        case "LocalDateTime":
          value = "LocalDateTime.now();";
          break;
        case "LocalDate":
          value = "LocalDate.now();";
          break;
        default:
          value = "1";
      }
      var = var.toUpperCase();
      if (var.contains("ID")) {
        if (var.substring(0, 2).contains("ID")) {
          var = var.replace("ID", "ID_");
        } else {
          var = var.replace("ID", "_ID");
        }
        asserts +=
            "    assertThat(test.get"
                + vars[i]
                    .substring(0, 1)
                    .replace(vars[i].substring(0, 1), vars[i].substring(0, 1).toUpperCase())
                + vars[i].substring(1)
                + "().getId()).isNotNull().isEqualTo("
                + var
                + ");\n";
      } else {
        asserts +=
            "    assertThat(test.get"
                + vars[i]
                    .substring(0, 1)
                    .replace(vars[i].substring(0, 1), vars[i].substring(0, 1).toUpperCase())
                + vars[i].substring(1)
                + "()).isNotNull().isEqualTo("
                + var
                + ");\r\n";
      }
      b += "  private static final " + types[i] + " " + var + " = " + value + ";\n";
      d += var + ",";
    }
    d = d.substring(0, d.length() - 1);
    String a =
        "package com.ctag.paperless.domain.model."
            + pack
            + ";\r\n"
            + "\r\n"
            + "import static org.assertj.core.api.Assertions.assertThat; \r\n"
            + "\r\n"
            + "import org.junit.Before;\r\n"
            + "import org.junit.Test;\r\n"
            + "\r\n"
            + "public class "
            + claseFactory
            + "UnitTest {\r\n"
            + "\r\n"
            + b
            + "\r\n"
            + "  private "
            + claseFactory
            + " underTest;\r\n"
            + "\r\n"
            + "  @Before\r\n"
            + "  public final void setUp() {\r\n"
            + "    underTest = new "
            + claseFactoryDefault+ "();\r\n"
            + "  }\r\n"
            + "\r\n"
            + "  @Test\r\n"
            + "  public final void testCreate"
            + clase
            + "() {\r\n"
            + "\r\n"
            + "    final "
            + clase
            + " test = underTest."
            + nameMethod
            + "("
            + d
            + ");\r\n"
            + "    assertThat(test).isNotNull();\r\n"
            + asserts
            + "  }\r\n"
            + "}\r\n"
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
