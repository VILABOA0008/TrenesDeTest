package AaTEEST;

import java.util.ArrayList;

import AaTEEST.escribir.Escribir2;

public class Agregador {

  public static void clase(String url, String clase, ArrayList<String> conId,
      ArrayList<String> sinId, ArrayList<String> sets) {
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
        "import com.ctag.paperless.core.domain.model.bomdefinition.BomDefinition;\r\n" +
        "import com.ctag.paperless.core.domain.model.input.Input;\r\n" +
        "import com.ctag.paperless.core.domain.model.output.Output;\r\n" +
        "\r\n" +
        "import nl.jqno.equalsverifier.EqualsVerifier;\r\n" +
        "import nl.jqno.equalsverifier.Warning;\r\n" +
        "\r\n" +
        "public class " + clase + "UnitTest {\r\n" +
        "\r\n" +

        // VARIABLE POR DEFECTO
        "  private static final Integer TEST_INTEGER = 1;\r\n" +

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

    if (!sinId.isEmpty()) {
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

    }

    System.err.println("sadsa");

    r += clases + "\n";
    r += equals + "\n";
    r += "}";

    url = url.split("\\.")[url.split("\\.").length - 1];
    System.err.println(url);

    Escribir2.escribir(url, r, clase);
  }

  public static void toString(String url, String clase, ArrayList<String> toString,
      ArrayList<String> toStringTypes) {
    System.err.println("\n ATRIBUTOS");
    toString.forEach(n -> System.err.println(n));
    System.err.println("FIN");

    // underTest.setActive(TEST_BOOLEAN);
    // Bom mockedBom = mock(Bom.class);
    // setBom(mockedBom);
    // BomId bomId = new BomId(TEST_INTEGER);
    // underTest.setBomId(bomId);
    // underTest.setUsual(TEST_BOOLEAN);
    // Cell mockedCell = mock(Cell.class);
    // setCell(mockedCell);
    // CellId cellId = new CellId(TEST_INTEGER);
    // underTest.setCellId(cellId);
    // underTest.lockBomDefinition();
    // assertThat(underTest.toString())
    // .isEqualTo(
    // "BomDefinition [active="
    // + TEST_BOOLEAN
    // + ", bom="
    // + mockedBom
    // + ", bomId="
    // + bomId
    // + ", id="
    // + TEST_INTEGER
    // + ", isUsual="
    // + TEST_BOOLEAN
    // + ", cell="
    // + mockedCell
    // + ", cellId="
    // + cellId
    // + ", locked="
    // + TEST_BOOLEAN
    // + "]");
    // }

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
