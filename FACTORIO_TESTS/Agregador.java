package com.ctag.paperless.psa.totem.FACTORIO_TESTS;

import java.util.ArrayList;

public class Agregador {

  public static void clase(String url, String clase, ArrayList<String> conId,
      ArrayList<String> sinId, ArrayList<String> sets, ArrayList<String> setsType,
      ArrayList<String> vars, ArrayList<String> varTypes,
      ArrayList<String> toString, ArrayList<String> toStringTypes) {
    // String urlSpecs="import com.ctag.paperless.core.domain.model.unit.";
    // String paquetes=urlSpecs+clase;

    String r = "package " + url + ";\r\n" +
        "\r\n"
        + "" +
        "import static org.assertj.core.api.Assertions.assertThat; \r\n" +
        "import static org.mockito.Mockito.mock;\r\n" +
        "import static org.mockito.Mockito.when;\r\n" +
        "\r\n"+
        "import org.apache.commons.lang3.builder.ToStringBuilder;" +
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
    for (int i = 0; i < sinId.size(); i++) {
      String clas = sinId.get(i).substring(0, 1).toUpperCase() + sinId.get(i).substring(1);
      equals += ".withPrefabValues(" + clas + ".class, mock(" + clas + ".class), mock(" + clas
          + ".class))\n";
    }

    if (!sets.isEmpty()) {
      equals += ".withPrefabValues(Set.class, mock(Set.class),mock(Set.class))\n";
    }

    equals += "        .usingGetClass()\r\n" +
        "        .suppress(Warning.SURROGATE_KEY)\r\n" +
        "        .withRedefinedSuperclass()\r\n" +
        "        .verify();\r\n" +
        "  \n}";

    String Sets = "";
    for (int i = 0; i < sets.size(); i++) {
      String auxSet = sets.get(i).substring(0, 1).toUpperCase() + sets.get(i).substring(1);
      clases += "\n\n"
          + "    @Test\r\n" +
          "    @SuppressWarnings(\"unchecked\")\r\n" +
          "    public void testGet" + auxSet + "() throws Exception {\r\n" +
          "      Set<" + setsType.get(i) + "> mockedSet = mock(Set.class);\r\n" +
          "      when(mockedSet.size()).thenReturn(TEST_INTEGER);\r\n" +
          "      testSet" + auxSet + "(mockedSet);\r\n" +
          "      assertThat(underTest.get" + auxSet + "().size()).isEqualTo(TEST_INTEGER);\r\n" +
          "    }\r\n" +
          "   \r\n" +
          "    @Test\r\n" +
          "    public void testIs" + auxSet + "Empty() {\r\n" +
          "      assertThat(underTest.get" + auxSet + "()).isEmpty();\r\n" +
          "    }\r\n" +
          "   \r\n" +
          "   \r\n" +
          "    private void testSet" + auxSet + "(Set<" + setsType.get(i) + ">" + sets.get(i)
          + ") throws Exception {\r\n" +
          "      Field " + sets.get(i) + "Field = " + clase + ".class.getDeclaredField(\""
          + sets.get(i) + "\");\r\n" +
          "      " + sets.get(i) + "Field.setAccessible(true);\r\n" +
          "      " + sets.get(i) + "Field.set(underTest, " + sets.get(i) + ");\r\n" +
          "      " + sets.get(i) + "Field.setAccessible(false);\r\n" +
          "    }\r\n" +
          "    ";

    }

    // System.err.println("sadsa");

    r += clases + "\n";

    r += Sets + "\n";
    r += Agregador.Simplevars(url, clase, vars, varTypes);

    r += equals + "\n";
    r += toString(url, clase, vars, varTypes);
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
      if (type.equalsIgnoreCase("Boolean")) {
        r += "  @Test\r\n" +
            "  public void testIs" + var + "() throws Exception {\r\n" +
            "    underTest.set" + var + "(true);\r\n" +
            "    assertThat(underTest.is" + var + "()).isNotNull().isEqualTo(true);\r\n" +
            "  }\n";
      } else {

        r += "  @Test\r\n" +
            "  public void testGet" + var + "() throws Exception {\r\n" +
            "    underTest.set" + var + "(TEST_" + type.toUpperCase() + ");\r\n" +
            "    assertThat(underTest.get" + var + "()).isNotNull().isEqualTo(TEST_"
            + type.toUpperCase() + ");\r\n" +
            "  }\n";
      }

    }
    System.err.println("FIN");
    return r;

  }

  public static String toString(String url, String clase, ArrayList<String> vars,
      ArrayList<String> varsTypes) {
    System.err.println("\n ATRIBUTOS");
    vars.forEach(n -> System.err.println(n + "  " + clase));
    System.err.println("FIN");

    String r = "  @Test\r\n" +
        "  public void testToString() throws Exception {\n\n"
        + "    FieldSetter.setField(underTest, " + clase + ".class.getDeclaredField(\"id\"), TEST_INTEGER);\n";
    for (int i = 0; i < vars.size(); i++) {
      String name = vars.get(i).substring(0, 1).toUpperCase() + vars.get(i).substring(1);
      String type = varsTypes.get(i);

      r += "    underTest.set" + name;
      if(type.equalsIgnoreCase("String")) {r+="(\"test" + name + "\");\n";}else if(type.equalsIgnoreCase("Boolean")){ 
        r+="("+true+");\n";}else if(type.equalsIgnoreCase("Integer")){ 
          r+="("+1+");\n";
        }
      
    }

    r += "    assertThat(underTest.toString()).isEqualTo(\r\n" +
        "        new ToStringBuilder(underTest)\n"
        + "        .append(\"id\", 1)\n";

    for (int i = 0; i < vars.size(); i++) {
      String name = vars.get(i).substring(0, 1).toUpperCase() + vars.get(i).substring(1);
      String type = varsTypes.get(i);
      
      r += "            .append(\"" + vars.get(i) + "\", ";
      
      if(type.equalsIgnoreCase("String")) {r+= "\"test" + name + "\")\n";}else if(type.equalsIgnoreCase("Boolean")){ 
        r+=true+")\n";}else if(type.equalsIgnoreCase("Integer")){ 
          r+=1+")\n";}
      
    }
    r += "            .toString());\n}\n";
    return r;
  }
}
