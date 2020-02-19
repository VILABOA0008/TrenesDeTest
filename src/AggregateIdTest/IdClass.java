package AggregateIdTest;

public class IdClass {

  public static void Id(String clase, String id) {

    String test = "package com.ctag.paperless.quality.domain.model." + clase.toLowerCase() + ";\n"
        + "\r\n" +
        "import org.assertj.core.api.Assertions;\r\n"
        + "import static org.assertj.core.api.Assertions.assertThat; " +
        "import org.junit.Before;\r\n" +
        "import org.junit.Test;\r\n" +
        "import org.junit.runner.RunWith;\r\n" +
        "import org.mockito.Mock;\r\n" +
        "import org.mockito.junit.MockitoJUnitRunner;\r\n" +
        "\r\n" +
        "import com.ctag.paperless.quality.domain.model." + clase + "." + id + ";\r\n" +
        "\r\n" +
        "import nl.jqno.equalsverifier.EqualsVerifier;\r\n" +
        "import nl.jqno.equalsverifier.Warning;\r\n" +
        "\r\n" +
        "@RunWith(MockitoJUnitRunner.class)\r\n" +
        "public class " + id + "UnitTest {\r\n" +
        "\r\n" +
        "  private static final Integer TEST_INTEGER = 1;\r\n" +
        "\r\n" +
        "  private " + id + " underTest;\r\n" +
        "\r\n" +
        "  @Before\r\n" +
        "  public void setUp() throws Exception {\r\n" +
        "    underTest = new " + id + "(TEST_INTEGER);\r\n" +
        "  }\r\n" +
        "\r\n" +
        "  @Test\r\n" +
        "  public void testEmptyConstructor() throws Exception {\r\n" +
        "    new " + id + "();\r\n" +
        "  }\r\n" +
        "\r\n" +
        "  @Test\r\n" +
        "  public void testEquals() {\r\n" +
        "    EqualsVerifier.forClass(" + id + ".class)\r\n" +
        "        .withRedefinedSuperclass()\r\n" +
        "        .suppress(Warning.SURROGATE_KEY)\r\n" +
        "        .usingGetClass()\r\n" +
        "        .verify();\r\n" +
        "  }\r\n" +
        "\r\n" +
        "  @Test\r\n" +
        "  public void testId() {\r\n" +
        "    Assertions.assertThat(underTest.getId()).isNotNull().isEqualTo(TEST_INTEGER);\r\n" +
        "  }\r\n" +
        "  \n@Test\r\n" +
        "  public void testOptional() throws Exception {\r\n" +
        "\r\n" +
        "    assertThat(" + id + ".getOptional(TEST_INTEGER))\r\n" +
        "        .isNotNull()\r\n" +
        "        .isEqualTo(Optional.of(new " + id + "(TEST_INTEGER)));\r\n" +
        "\r\n" +
        "    assertThat(" + id + ".getOptional(null)).isNotNull().isEqualTo(Optional.empty());\r\n"
        +
        "  }\n" +
        "}";

    Escribir2.escribir(
        "C:\\GIT\\PSA\\Totem\\backend\\totem-specs\\src\\test\\java\\ut\\com\\ctag\\paperless\\psa\\totem\\domain\\model"
            + clase,
        test,
        id + "UnitTest");

  }

}