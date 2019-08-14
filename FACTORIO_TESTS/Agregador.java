package com.ctag.paperless.psa.totem.FACTORIO_TESTS;

import java.util.ArrayList;

public class Agregador {

  public static void clase(String url, String clase, ArrayList<String> conId,
      ArrayList<String> sinId, ArrayList<String> sets,
      ArrayList<String> toString, ArrayList<String> toStringTypes,
      ArrayList<String> vars, ArrayList<String> varTypes) {
    // String urlSpecs="import com.ctag.paperless.core.domain.model.unit.";
    // String paquetes=urlSpecs+clase;

    String r = "package " + url + ";\r\n" +
        "\r\n"
        + "" +
        "import static org.assertj.core.api.Assertions.assertThat; \r\n" +
        "import static org.mockito.Mockito.mock;\r\n" +
        "import static org.mockito.Mockito.when;\r\n" +
        "\r\n" +
        "import java.lang.reflect.Field;\r\n" +
        "import java.util.Set;\r\n" +
        "\r\n" +
        "import org.junit.Before;\r\n" +
        "import org.junit.Test;\r\n" +
        "import org.mockito.internal.util.reflection.FieldSetter;\r\n" +
        "\r\n" +
        "import nl.jqno.equalsverifier.EqualsVerifier;\r\n" +
        "import nl.jqno.equalsverifier.Warning;\r\n" +
        "\r\n" +
        "public class " + clase + "UnitTest {\r\n" +
        "\r\n" +

        // VARIABLE POR DEFECTO
        "  private static final Integer TEST_INTEGER = 1;\r\n"
        + "  private static final String TEST_STRING = \"test\";\n" +

        "\r\n" +
        "  private " + clase + " underTest;\r\n" +
        "\r\n" +

        "  @Before\r\n" +
        "  public void setUp() throws Exception {\r\n" +
        "    underTest = new " + clase + "();\r\n" +
        "    FieldSetter.setField(underTest, " + clase
        + ".class.getDeclaredField(\"id\"), TEST_INTEGER);\r\n" +
        "  }\r\n\n" +
        "  @Test\r\n" +
        "  public void testId() throws Exception {\r\n" +
        "    assertThat(underTest.getId().getId()).isEqualTo(TEST_INTEGER);\r\n" +
        "  }";

    String clases = "";
    String equals = "";


      equals = "  \n @Test\r\n" +
          "    public void testEquals() throws Exception {\r\n";

      for (int i = 0; i < sinId.size(); i++) {
        String clas = sinId.get(i).substring(0, 1).toUpperCase() + sinId.get(i).substring(1);
        clases += "\n\n"
            + "  @Test\r\n" +
            "  public void testGet" + clas + "() {\r\n" +
            "    assertThat(underTest.get" + clas + "()).isNull();\r\n" +
            "  }";

      }

      for (int i = 0; i < conId.size(); i++) {
        String clas = conId.get(i).substring(0, 1).toUpperCase() + conId.get(i).substring(1);
        clases += "\n\n"
            + "  @Test\r\n" +
            "  public void testGet" + conId.get(i) + "() {\r\n" +
            "    underTest.set" + clas + "(new " + clas + "(TEST_INTEGER));\r\n" +
            "    assertThat(underTest.get" + clas
            + "().getId()).isNotNull().isEqualTo(TEST_INTEGER);\r\n" +
            "  }";

      }

      equals += "EqualsVerifier.forClass(" + clase + ".class)\n";
      for (int i = 0; i < conId.size(); i++) {
        String clas = conId.get(i).substring(0, 1).toUpperCase() + conId.get(i).substring(1);
        equals += ".withPrefabValues(" + clas + ".class, mock(" + clas + ".class), mock(" + clas
            + ".class))\n";
      }

      if (!sets.isEmpty()) {
        equals += ".withPrefabValues(Set.class, mock(Set.class),mock(Set.class))\n";
      }

      equals += "        .usingGetClass()\r\n" +        
          "        .suppress(Warning.ALL_FIELDS_SHOULD_BE_USED)\r\n" +
          "        .withRedefinedSuperclass()\r\n" +
          "        .verify();\r\n" +
          "  \n}";

    

    r += clases + "\n";

  r+=Agregador.Simplevars(url, clase, vars, varTypes);
//   Agregador.toString(url, clase, toString,toStringTypes);

    r += equals + "\n";
    r += "}";

    url = url.split("\\.")[url.split("\\.").length - 1];
    System.err.println(url);

    Escribir2.escribir(url, r, clase);
  }

  public static String Simplevars(String url, String clase, ArrayList<String> vars,
      ArrayList<String> varsTypes) {
    System.err.println("\n ATRIBUTOS");

    String r = "";
    for (int i = 0; i < varsTypes.size(); i++) {
      String var = vars.get(i).substring(0, 1).toUpperCase() + vars.get(i).substring(1);
      String type = varsTypes.get(i);

      System.err.println(type + "  " + var);
      if(type.equalsIgnoreCase("Boolean")) {
        r += "  @Test\r\n" +
            "  public void testIs" + var + "() throws Exception {\r\n" +
            "    underTest.set" + var + "(true);\r\n" +
            "    assertThat(underTest.is" + var + "()).isNotNull().isEqualTo(true);\r\n" +
            "  }\n";
      }else {
      
      r += "  @Test\r\n" +
          "  public void testGet" + var + "() throws Exception {\r\n" +
          "    underTest.set" + var + "(TEST_" + type.toUpperCase() + ");\r\n" +
          "    assertThat(underTest.get" + var + "()).isNotNull().isEqualTo(TEST_"
          + type.toUpperCase() + ");\r\n" +
          "  }\n";}

    }
    System.err.println("FIN");
    return r;

  }

  public static void toString(String url, String clase, ArrayList<String> toString,
      ArrayList<String> toStringTypes) {
    System.err.println("\n ATRIBUTOS");
    toString.forEach(n -> System.err.println(n));
    System.err.println("FIN");

    String r = "  @Test\r\n" +
        "  public void testToString() throws Exception {\n\n";
    for (int i = 0; i < toString.size(); i++) {
      String name = toString.get(i);
      String type = toStringTypes.get(i);

      if (type.contains("Id")) {
        r += "   " + type + " " + name + " = new " + type + "(TEST_INTEGER);\n";

      } else {

        r += "   underTest.set" + name.substring(0, 1).toUpperCase() + name.substring(1) + "(TEST_"
            + type.toUpperCase() + ");\n";
      }
    }
    r += "   assertThat(underTest.toString())\n"
        + "        .isEqualTo(";

    for (int i = 0; i < toString.size(); i++) {
      String name = toString.get(i);
      String type = toStringTypes.get(i);

      if (type.contains("Id")) {
        r += "   " + type + " " + name + " = new " + type + "(TEST_INTEGER);\n";

      } else {

        r += "   underTest.set" + name.substring(0, 1).toUpperCase() + name.substring(1) + "(TEST_"
            + type.toUpperCase() + ");\n";
      }
    }

    Escribir2.escribir(url, r, clase);
  }
}
