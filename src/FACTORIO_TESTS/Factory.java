package FACTORIO_TESTS;

import java.util.ArrayList;

public class Factory {

  public static void FactoryTest(String pack, String claseFactory, String[] types, String vars[]) {
    claseFactory = claseFactory.replace("Default", "");
    String clase = claseFactory.replace("Factory", "");
    claseFactory = clase + "Factory";
    String b = "", c = "", d = "";
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
        System.err.println(vars[i] + "  hmm");
        c += "    assertThat(test.get"
            + vars[i].substring(0, 1).replace(vars[i].substring(0, 1),
                vars[i].substring(0, 1).toUpperCase())
            + vars[i].substring(1) + "().getId()).isNotNull().isEqualTo(" + var + ");\n";
        System.err.println(c + "mmh");
      } else {
        c += "    assertThat(test.get"
            + vars[i].substring(0, 1).replace(vars[i].substring(0, 1),
                vars[i].substring(0, 1).toUpperCase())
            + vars[i].substring(1) + "()).isNotNull().isEqualTo(" + var + ");\r\n";

      }
      b += "  private static final " + types[i] + " " + var + " = " + value + ";\n";
      d += var + ",";

    }
    d = d.substring(0, d.length() - 1);
    String a = "package com.ctag.paperless.domain.model." + pack + ";\r\n" +
        "\r\n" +
        "import static org.assertj.core.api.Assertions.assertThat; \r\n" +
        "\r\n" +
        "import org.junit.Before;\r\n" +
        "import org.junit.Test;\r\n" +
        "\r\n" +
        "public class " + claseFactory + "UnitTest {\r\n" +
        "\r\n" +
        b +
        "\r\n" +
        "  private " + claseFactory + " underTest;\r\n" +
        "\r\n" +
        "  @Before\r\n" +
        "  public final void setUp() {\r\n" +
        "    underTest = new " + clase + "Default();\r\n" +
        "  }\r\n" +
        "\r\n" +
        "  @Test\r\n" +
        "  public final void testCreate" + clase + "() {\r\n" +
        "\r\n" +
        "    final " + clase + " test = underTest.create" + clase + "(" + d + ");\r\n" +
        "    assertThat(test).isNotNull();\r\n" +
        c +
        "  }\r\n" +
        "}\r\n" +
        "";
    ArrayList<String> clases = new ArrayList<>();
    clases.add("PartState");
    clases.add("LineType");
    clases.add("PsaShift");
    clases.add("ParameterType");
    clases.add("Parameter");
    clases.add("SourceMaterialType");
    clases.add("DeclarationType");
    clases.add("ProcessVigilance");
    clases.add("ProcessVigilanceVersion");
    clases.add("ProcessVigilanceVersionParameter");
    clases.add("ProcessVigilanceWarning");
    clases.add("ProcessVigilanceState");
    clases.add("ProcessLaunch");
    clases.add("LaunchModifiedParameter");
    clases.add("CoilLaunch");
    clases.add("reworkBatch");
    for (String l : clases) {
      if (l.equalsIgnoreCase(clase)) {
        Escribir2.escribir("", a, claseFactory);
        break;
      }
    }
  }

  public static void RepresentaionTest(String pack, String claseRepresentation, String[] types,
      String vars[]) {
    String clase = claseRepresentation.replace("Representation", "");
    String b = "", c = "", d = "";

    String toString1 = "";
    String toString3 = "";

    for (int i = 0; i < types.length; i++) {
      String value;
      System.err.println("press2s");
      String var = vars[i];
      System.err.println("press");
      switch (types[i]) {
      case "String":
        value = "\"" + vars[i] + "\"";
        break;
      case "boolean":
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
        String varcap = vars[i].substring(0, 1).replace(vars[i].substring(0, 1),
            vars[i].substring(0, 1).toUpperCase()) + vars[i].substring(1);
        var = var.toUpperCase();
        if (var.contains("ID")) {
          if (var.substring(0, 2).contains("ID")) {
            var = var.replace("ID", "ID_");
          } else {
            var = var.replace("ID", "_ID");
          }
          toString1 += "    underTest.set" + varcap + "(" + var + ");\r\n";
          toString3 += "    " + varcap + "=\" + " + var + "+ \",";
          c += "  @Test\r\n" +
              "  public void test" + varcap + "() {\r\n" +
              "    underTest.set" + varcap + "(" + var + ");\r\n" +
              "    assertThat(underTest.get" + varcap + "()).isNotNull().isEqualTo(" + var
              + ");\r\n" +
              "  }\n\n";
        } else {
          toString1 += "    underTest.set" + varcap + "(" + var + ");\r\n";
          toString3 += "    " + varcap + "=\" + " + var + "+ \",";
          c += "  @Test\r\n" +
              "  public void test" + varcap + "() {\r\n" +
              "    underTest.set" + varcap + "(" + var + ");\r\n" +
              "    assertThat(underTest.get" + varcap + "()).isNotNull().isEqualTo(" + var
              + ");\r\n" +
              "  }\n\n";

        }
        b += "  private static final " + types[i] + " " + var + " = " + value + ";\n";
        d += var + ",";
      
      }
      String toString0 = "  @Test\r\n" +
          "  public void testToString() {";

      String toString2 = "    assertThat(underTest.toString()).isEqualTo(\r\n" +
          "            \"" + clase + "Representation [";

      String toString = toString0 + toString1 + toString2
          + toString3.substring(0, toString3.length() - 1) + "]\");";

      String equals = "  @Test\r\n" +
          "  public final void testEqualsObject() {\r\n" +
          "    EqualsVerifier.forClass("+ clase + "Representation.class)\r\n" +
          "        .suppress(Warning.NONFINAL_FIELDS)\r\n" +
          "        .usingGetClass()\r\n" +
          "        .verify();\r\n" +
          "  }";

      d = d.substring(0, d.length() - 1);
      String a = "package com.ctag.paperless.rest." + pack + ";\r\n" +
          "\r\n" +
          "import static org.assertj.core.api.Assertions.assertThat; \r\n" +
          "\r\n" +
          "import org.junit.Before;\r\n" +
          "import org.junit.Test;\r\n" +
          "\r\n" +
          "import nl.jqno.equalsverifier.EqualsVerifier;\r\n" +
          "import nl.jqno.equalsverifier.Warning;\n\n" +
          "public class " + claseRepresentation + "UnitTest {\r\n" +
          "\r\n" +
          b +
          "\r\n" +
          "  private " + claseRepresentation + " underTest;\r\n" +
          "\r\n" +
          "  @Before\r\n" +
          "  public final void setUp() {\r\n" +
          "    underTest = new " + clase + "Representation();\r\n" +
          "  }\r\n" +
          c +
          " \n\n" + equals + "\r\n" +
//          " " + toString + "\r\n" +
          "\r\n" +
          "  }\r\n" +
          "\r\n" +
          "";
      ArrayList<String> clases = new ArrayList<>();
      clases.add("PartState");
      clases.add("LineType");
      clases.add("PsaShift");
      clases.add("ParameterType");
      clases.add("Parameter");
      clases.add("SourceMaterialType");
      clases.add("DeclarationType");
      clases.add("ProcessVigilance");
      clases.add("ProcessVigilanceVersion");
      clases.add("ProcessVigilanceVersionParameter");
      clases.add("ProcessVigilanceWarning");
      clases.add("ProcessVigilanceState");
      clases.add("ProcessLaunch");
      clases.add("LaunchModifiedParameter");
      clases.add("CoilLaunch");
      clases.add("reworkBatch");
      for (String l : clases) {
        if (l.equalsIgnoreCase(clase)) {
          Escribir2.escribir("", a, claseRepresentation);
          break;
        }
      }
    
  }
}
