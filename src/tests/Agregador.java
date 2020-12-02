package tests;

import java.util.ArrayList;
import java.util.List;

public class Agregador {

  public static void clase(
      String url,
      String clase,
      ArrayList<String> conId,
      ArrayList<String> sinId,
      ArrayList<String> sets,
      ArrayList<String> setsType,
      ArrayList<String> vars,
      ArrayList<String> varTypes,
      ArrayList<String> toString,
      ArrayList<String> toStringTypes) {
    // String urlSpecs="import com.ctag.paperless.core.domain.model.unit.";
    // String paquetes=urlSpecs+clase;

    String r =
        "package "
            + url
            + ";\r\n"
            + "\r\n"
            + ""
            + "import static org.assertj.core.api.Assertions.assertThat; \r\n"
            + "import static org.mockito.Mockito.mock;\r\n"
            + "import static org.mockito.Mockito.when;\r\n"
            + "\r\n"
            + "import org.apache.commons.lang3.builder.ToStringBuilder;"
            + "import java.lang.reflect.Field;\r\n"
            + "import java.util.Set;\r\n"
            + "\r\n"
            + "import org.junit.Before;\r\n"
            + "import org.junit.Test;\r\n"
            + "import org.mockito.internal.util.reflection.FieldSetter;\r\n"
            + "\r\n"
            + "import nl.jqno.equalsverifier.EqualsVerifier;\r\n"
            + "import nl.jqno.equalsverifier.Warning;\r\n"
            + "\r\n"
            + "public class "
            + clase
            + "UnitTest {\r\n"
            + "\r\n";

    if (varTypes.contains("Float")) {
      r += "  private static final Float TEST_FLOAT = 1f;\n";
    }
    if (varTypes.contains("Double")) {
      r += "  private static final Double TEST_DOUBLE = 1d;\n";
    }
    if (varTypes.contains("LocalDateTime")) {
      r += "  private static final LocalDateTime TEST_LOCALDATETIME = LocalDateTime.now();\n";
    }
    if (varTypes.contains("Short")) {
      r += "  private static final Short TEST_SHORT= 1;\n";
    }
    if (varTypes.contains("LocalDate")) {
      r += "  private static final LocalDate TEST_LOCALDATE= LocalDate.now();\n";
    }
    if (varTypes.contains("String")) {
      r += "  private static final String TEST_STRING = \"test\";";
    }

    // VARIABLE POR DEFECTO
    r +=
        "  private static final Integer TEST_INTEGER = 1;\r\n"
            + "\r\n"
            + "  private "
            + clase
            + " underTest;\r\n"
            + "\r\n"
            + "  @Before\n"
            + "  public void setUp() throws Exception {\r\n"
            + "    underTest = new "
            + clase
            + "();\r\n"
            + "    FieldSetter.setField(underTest, "
            + clase
            + ".class.getDeclaredField(\"id\"), TEST_INTEGER);\r\n"
            + "  }\r\n\n"
            + "  @Test\n"
            + "  public void testId() throws Exception {\r\n"
            + "    assertThat(underTest.getId().getId()).isNotNull().isEqualTo(TEST_INTEGER);\r\n"
            + "  }";

    String clases = "";

    //  CON ID
    //    for (int i = 0; i < sinId.size(); i++) {
    //      String clas = sinId.get(i).substring(0, 1).toUpperCase() + sinId.get(i).substring(1);
    //      clases += "\n\n"
    //          + "  @Test\n" +
    //          "  public void testGet" + clas + "() {\r\n" +
    //          "    "+clas+" mock = mock("+clas+".class);\r\n" +
    //          "    underTest.set"+clas+"(mock);\r\n" +
    //          "    assertThat(underTest.get"+clas+"()).isNotNull().isEqualTo(mock);\r\n" +
    //          "  }";
    //
    //    }

    for (int i = 0; i < conId.size(); i++) {
      String clas = conId.get(i).substring(0, 1).toUpperCase() + conId.get(i).substring(1);
      clases +=
          "\n\n"
              + "  @Test\n"
              + "  public void testSet"
              + BasicMethods.toMayusq(conId.get(i))
              + "() {\r\n"
              + "    underTest.set"
              + clas
              + "(new "
              + clas
              + "(TEST_INTEGER));\r\n"
              + "    assertThat(underTest.get"
              + clas
              + "().getId()).isNotNull().isEqualTo(TEST_INTEGER);\r\n"
              + "  }";
    }

    String Sets = "";
    if (!sets.isEmpty()) {

      Sets +=
          "\r\n"
              + "  private void setList(Set<?> set, String nameOfVariable) throws Exception {\r\n"
              + "    Field field = "
              + clase
              + ".class.getDeclaredField(nameOfVariable);\r\n"
              + "    field.setAccessible(true);\r\n"
              + "    field.set(underTest, set);\r\n"
              + "    field.setAccessible(false);\r\n"
              + "  }\n";

      for (int i = 0; i < sets.size(); i++) {
        String auxSet = sets.get(i).substring(0, 1).toUpperCase() + sets.get(i).substring(1);
        Sets +=
            "\n\n"
                + "    @Test\n"
                + "    public void test"
                + auxSet
                + "() throws Exception {\r\n"
                + "      Set<"
                + setsType.get(i)
                + "> mockedSet = mock(Set.class);\r\n"
                + "      when(mockedSet.size()).thenReturn(TEST_INTEGER);\r\n"
                + "      setList(mockedSet, \""
                + sets.get(i)
                + "\");\n"
                + "      assertThat(underTest.get"
                + auxSet
                + "().size()).isEqualTo(TEST_INTEGER);\r\n"
                + "    }\r\n"
                + "   \r\n"
                + "    @Test\n"
                + "    public void test"
                + auxSet
                + "Empty() throws Exception  {\r\n"
                + "      setList(Collections.emptySet(), \""
                + sets.get(i)
                + "\");\n"
                + "      assertThat(underTest.get"
                + auxSet
                + "()).isNotNull().isEmpty();\r\n"
                + "    }\r\n"
                + "   \r\n"
                + "    @Test\n"
                + "    public void test"
                + auxSet
                + "NotNull() throws Exception  {\r\n"
                + "      setList(null, \""
                + sets.get(i)
                + "\");\n"
                + "      assertThat(underTest.get"
                + auxSet
                + "()).isNotNull().isEmpty();\r\n"
                + "    }\r\n"
                + "   \r\n"
                + "";
      }
    }
    r += clases + "\n";

    r += Sets + "\n";
    r += Agregador.Simplevars(url, clase, vars, varTypes) + "\n";

    //    r += prefabEquals(clase, sinId, sets) + "\n";
    r += newEquals(clase) + "\n";

    r += toString(clase, vars, varTypes, conId);

    r += "}";
    System.err.println(r);
    url = url.split("\\.")[url.split("\\.").length - 1];
    ArrayList<String> clasess = new ArrayList<>();
    clasess.add("PartState");
    clasess.add("LineType");
    clasess.add("PsaShift");
    clasess.add("ParameterType");
    clasess.add("Parameter");
    clasess.add("SourceMaterialType");
    clasess.add("DeclarationType");
    clasess.add("ProcessVigilance");
    clasess.add("ProcessVigilanceVersion");
    clasess.add("ProcessVigilanceVersionParameter");
    clasess.add("ProcessVigilanceWarning");
    clasess.add("ProcessVigilanceState");
    clasess.add("ProcessLaunch");
    clasess.add("LaunchModifiedParameter");
    clasess.add("CoilLaunch");
    clasess.add("reworkBatch");
    for (String l : clasess) {
      if (l.equalsIgnoreCase(clase)) {
        //        Escribir2.escribir(url, r, clase);break;
      }
    }
  }

  public static String newEquals(String clase) {
    String equals =
        "  @Test\n"
            + "  public final void testEquals()  throws Exception {\r\n"
            + "  "
            + clase
            + " compareEquals = new "
            + clase
            + "();\n"
            + "    FieldSetter.setField(compareEquals, "
            + clase
            + ".class.getDeclaredField(\"id\"),"
            + " TEST_INTEGER);\n"
            + "    assertThat(underTest).isNotNull().isEqualTo(compareEquals);\r\n"
            + "  }\r\n"
            + "\r\n"
            + "  @Test\n"
            + "  public final void testEqualsDifferentsObjects() {\r\n"
            + "    final Object obj = new Object();\r\n"
            + "    assertThat(underTest).isNotNull().isNotEqualTo(obj);\r\n"
            + "  }\n"
            + "\r\n"
            + "  @Test\n"
            + "  public final void testEqualsNull() {\r\n"
            + "    assertThat(underTest).isNotNull().isNotEqualTo(null);\r\n"
            + "  }\r\n"
            + "";

    return equals;
  }

  public static String prefabEquals(String clase, List<String> sinId, List<String> sets) {

    String equals = "  \n @Test\n" + "    public void testEquals() throws Exception {\r\n";
    equals += "    EqualsVerifier.forClass(" + clase + ".class)\n";
    for (int i = 0; i < sinId.size(); i++) {
      if (!sinId.get(i).equalsIgnoreCase("id")) {
        String clas = sinId.get(i).substring(0, 1).toUpperCase() + sinId.get(i).substring(1);
        equals +=
            ".withPrefabValues("
                + clas
                + ".class, mock("
                + clas
                + ".class), mock("
                + clas
                + ".class))\n";
      }
    }

    if (!sets.isEmpty()) {
      equals += ".withPrefabValues(Set.class, mock(Set.class),mock(Set.class))\n";
    }

    equals +=
        "        .usingGetClass()\r\n"
            + "        .suppress(Warning.SURROGATE_KEY)\r\n"
            + "        .withRedefinedSuperclass()\r\n"
            + "        .verify();\r\n"
            + "  \n}";

    return equals;
  }

  public static String Simplevars(
      String url, String clase, ArrayList<String> vars, ArrayList<String> varsTypes) {
    String r = "";
    for (int i = 0; i < varsTypes.size(); i++) {
      String var = vars.get(i).substring(0, 1).toUpperCase() + vars.get(i).substring(1);
      String type = varsTypes.get(i);

      if (type.equalsIgnoreCase("Boolean")) {
        r +=
            "  @Test\n"
                + "  public void testIs"
                + var
                + "() throws Exception {\r\n"
                + "    underTest.set"
                + var
                + "(true);\r\n"
                + "    assertThat(underTest.is"
                + var
                + "()).isNotNull().isEqualTo(true);\r\n"
                + "  }\n";
      } else {

        r +=
            "  @Test\n"
                + "  public void testSet"
                + var
                + "() throws Exception {\r\n"
                + "    underTest.set"
                + var
                + "(TEST_"
                + type.toUpperCase()
                + ");\r\n"
                + "    assertThat(underTest.get"
                + var
                + "()).isNotNull().isEqualTo(TEST_"
                + type.toUpperCase()
                + ");\r\n"
                + "  }\n";
      }
    }
    return r;
  }

  public static String toString(
      String clase, ArrayList<String> vars, ArrayList<String> varsTypes, ArrayList<String> conId) {

    String r = "  @Test\n" + "  public void testToString() throws Exception {\n\n";
    //        + "    FieldSetter.setField(underTest, " + clase + ".class.getDeclaredField(\"id\"),
    // TEST_INTEGER);\n";
    for (int i = 0; i < vars.size(); i++) {
      String name = vars.get(i).substring(0, 1).toUpperCase() + vars.get(i).substring(1);
      String type = varsTypes.get(i);

      r += "    underTest.set" + name;
      switch (type) {
        case "Boolean":
          r += "(true);\n";
          break;
        case "String":
          r += "(\"test" + name + "\");\n";
          break;
        case "Integer":
          r += "(TEST_INTEGER);\n";
          break;
        case "Float":
          r += "(TEST_FLOAT);\n";
          break;
        case "Double":
          r += "(TEST_DOUBLE);\n";
          break;
        case "LocalDateTime":
          r += "(TEST_LOCALDATETIME);\n";
          break;
        case "Short":
          r += "(TEST_SHORT);\n";
          break;
        case "LocalDate":
          r += "(TEST_LOCALDATE);\n";
          break;
      }
    }
    for (int i = 0; i < conId.size(); i++) {
      String mayusq = BasicMethods.toMayusq(conId.get(i));
      r += "    underTest.set" + mayusq + "(new " + mayusq + "(TEST_INTEGER));\n";
    }

    r += "    assertThat(underTest.toString()).contains(\"id=\"+TEST_INTEGER);\n";
    for (int i = 0; i < vars.size(); i++) {
      String name = vars.get(i).substring(0, 1).toUpperCase() + vars.get(i).substring(1);
      String type = varsTypes.get(i);

      r += "    assertThat(underTest.toString()).contains(\"" + vars.get(i) + "=";
      switch (type) {
        case "Boolean":
          r += "true\");\n";
          break;
        case "String":
          r += "test" + name + "\");\n";
          break;
        case "Integer":
          r += "\"+TEST_INTEGER);\n";
          break;
        case "Float":
          r += "\"+TEST_FLOAT);\n";
          break;
        case "LocalDateTime":
          r += "\"+TEST_LOCALDATETIME);\n";
          break;
        case "Double":
          r += "\"+TEST_DOUBLE);\n";
          break;
        case "Short":
          r += "\"+TEST_SHORT);\n";
          break;
        case "LocalDate":
          r += "\"+TEST_LOCALDATE);\n";
          break;
      }
    }
    for (int i = 0; i < conId.size(); i++) {
      String mayusq = BasicMethods.toMayusq(conId.get(i));
      r +=
          "    assertThat(underTest.toString()).contains(\""
              + conId.get(i)
              + "="
              + mayusq
              + "[id=\"+TEST_INTEGER+\"]\");\n";
    }

    r += "\n}\n";
    return r;
  }
}
