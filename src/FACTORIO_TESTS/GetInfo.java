package FACTORIO_TESTS;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

public class GetInfo {

  public static void testAgregadoIdOld(String url, String pack, String clase) throws Exception {

    System.err.println(url + "   " + pack + "   " + clase);
    String claseSinId = clase.replace("Id", "");

    String a = "package com.ctag.paperless.domain.model." + pack + ";\r\n" +
        "\r\n" +
        "import static org.assertj.core.api.Assertions.assertThat;\r\n" +
        "\r\n" +
        "import org.junit.Before;\r\n" +
        "import org.junit.Test;\r\n" +
        "import org.junit.runner.RunWith;\r\n" +
        "import org.mockito.Mock;\r\n" +
        "import org.mockito.MockitoAnnotations;\r\n" +
        "import org.mockito.runners.MockitoJUnitRunner;\r\n" +
        "import org.modelmapper.spi.MappingContext;\r\n" +
        "\r\n" +
        "@RunWith(MockitoJUnitRunner.class)\r\n" +
        "public class " + claseSinId + "IdUnitTest {\r\n" +
        "\r\n" +
        "  @Mock\r\n" +
        "  MappingContext<Integer, " + claseSinId + "Id> mappingContextMock;\r\n" +
        "  private " + claseSinId + "Id compareEquals;\r\n" +
        "  private " + claseSinId + "Id underTest;\r\n" +
        "\r\n" +
        "  @Before\r\n" +
        "  public void setUp() throws Exception {\r\n" +
        "    MockitoAnnotations.initMocks(this);\r\n" +
        "    underTest = new " + claseSinId + "Id();\r\n" +
        "    compareEquals = new " + claseSinId + "Id();\r\n" +
        "  }\r\n" +
        "\r\n" +
        "  @Test\r\n" +
        "  public final void testEquals() {\r\n" +
        "\r\n" +
        "    assertThat(underTest).isNotNull().isEqualTo(compareEquals);\r\n" +
        "  }\r\n" +
        "\r\n" +
        "  @Test\r\n" +
        "  public final void testEqualsDifferents() {\r\n" +
        "    compareEquals = new " + claseSinId + "Id(1);\r\n" +
        "    assertThat(underTest).isNotNull().isNotEqualTo(compareEquals);\r\n" +
        "  }\r\n" +
        "\r\n" +
        "  @Test\r\n" +
        "  public final void testEqualsDifferentsObjects() {\r\n" +
        "    final Object obj = new Object();\r\n" +
        "    assertThat(underTest).isNotNull().isNotEqualTo(obj);\r\n" +
        "  }\r\n" +
        "\r\n" +
        "  @Test\r\n" +
        "  public final void testEqualsNull() {\r\n" +
        "\r\n" +
        "    assertThat(underTest).isNotNull().isNotEqualTo(null);\r\n" +
        "  }\r\n" +
        "\r\n" +
        "  @Test\r\n" +
        "  public final void testHashcode() {\r\n" +
        "\r\n" +
        "    final int oneCode = underTest.hashCode();\r\n" +
        "    assertThat(oneCode).isNotNull().isEqualTo(underTest.hashCode());\r\n" +
        "    assertThat(oneCode).isNotNull().isEqualTo(compareEquals.hashCode());\r\n" +
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
      if (l.equalsIgnoreCase(claseSinId)) {
        Escribir2.escribir("", a, clase);
        break;
      }

    }

  }

  public static void testFactoriesOld(String url, String pack, String clase) throws Exception {

    // System.err.println("URL " + url + "\nPACKAGE " + pack + "\nCLASE " + clase);
    System.err.println("\n\n\nCLASE         " + clase);
    url = url + pack;
    Class leer = Class.forName(url + "." + clase);
    Method m = null;
    Method[] methods = leer.getDeclaredMethods();
    if (methods.length == 2) {
      if (methods[0].getParameterCount() > methods[1].getParameterCount()) {
        m = methods[0];
      } else {
        m = methods[1];
      }
    } else if (methods.length == 1) {

      m = methods[0];

    } else {

      System.err.println(clase + "  +de 2 methodos");
    }

    if (m != null) {
      String types[] = new String[m.getParameterCount()];
      String vars[] = new String[m.getParameterCount()];
      System.err.println(m.toGenericString());
      int c = -1;
      for (Parameter g : m.getParameters()) {
        c++;
        types[c] = g.getType().getSimpleName();
        vars[c] = g.getName();
        System.err.println(g.getType().getSimpleName() + "  " + g.getName());

      }
      Factory.FactoryTest(pack, clase, types, vars);
    }
  }

  public static void testRepresentationOld(String url, String pack, String clase) throws ClassNotFoundException {
System.err.println(clase);
     System.err.println("URL " + url + "\nPACKAGE " + pack + "\nCLASE " + clase);
    System.err.println("\n\n\nCLASE         " + clase);
    url = url + pack;
    Class leer = Class.forName(url + "." + clase);
    Field[] declaredFields = leer.getDeclaredFields();
    Method[] methods = leer.getDeclaredMethods();
    String types[] = new String[declaredFields.length];
    String vars[] = new String[declaredFields.length];
    int c = -1;
    for (Field field : declaredFields) {
      c++;
      types[c] = field.getType().getSimpleName();
      vars[c] = field.getName();
      System.err.println(field.getName());
    }
    for (Method method : methods) {
      if (method.getName().substring(0, 3).equalsIgnoreCase("get")) {
//        System.err.println(method.getName() + "  " + method.getReturnType());
      }
      if (method.getName().substring(0, 3).equalsIgnoreCase("set")) {
        Parameter parameter = method.getParameters()[0];
//        System.err.println(method.getName() + "  " + parameter.getType().getSimpleName() + "  "
//            + parameter.getName());
      }
    }
    
Factory.RepresentaionTest(pack, clase, types, vars);
  }

  public static void testAgregados(String url, String pack, String clase) throws Exception {
    // Class leer =
    // Class.forName("com.ctag.paperless.core.domain.model.bomdefinition.BomDefinition");
    ArrayList<String> conId = new ArrayList<>();
    ArrayList<String> sinId = new ArrayList<>();
    ArrayList<String> sets = new ArrayList<>();
    ArrayList<String> setsType = new ArrayList<>();
    ArrayList<String> toString = new ArrayList<>();
    ArrayList<String> toStringTypes = new ArrayList<>();
    ArrayList<String> vars = new ArrayList<>();
    ArrayList<String> varsTypes = new ArrayList<>();
    url = url + pack;
    // System.err.println(url+"."+clase);
    Class leer = Class.forName(url + "." + clase);
    for (int i = 0; i < leer.getDeclaredFields().length; i++) {
      // remove Static Strings

      System.err.println(leer.getDeclaredFields()[i].getName() + "  "
          + leer.getDeclaredFields()[i].getType().getModifiers() + "  " +
          leer.getDeclaredFields()[i].getType().getSimpleName());
      if (!leer.getDeclaredFields()[i].getName()
          .contentEquals(leer.getDeclaredFields()[i].getName().toUpperCase())) {

        // to string
        if (leer.getDeclaredFields()[i].getType().getModifiers() == 17
            || leer.getDeclaredFields()[i].getName().contains("Id")) {

          toString.add(leer.getDeclaredFields()[i].getName());
          toStringTypes.add(leer.getDeclaredFields()[i].getType().getSimpleName());
          if (!leer.getDeclaredFields()[i].getName().equalsIgnoreCase("id")) {

            // Simple vars Integer Boolean Instant String
            if (leer.getDeclaredFields()[i].getType().getModifiers() == 17) {
              vars.add(leer.getDeclaredFields()[i].getName());
              varsTypes.add(leer.getDeclaredFields()[i].getType().getSimpleName());
            }

          }
        }

        // classes
        if (leer.getDeclaredFields()[i].getType().getModifiers() == 1) {
          String name = leer.getDeclaredFields()[i].getName();
          if (name.contains("Id")) {
            conId.add(name);
          } else {
            sinId.add(name);
          }

          // sets
        } else if (leer.getDeclaredFields()[i].getType().getModifiers() == 1537) {
          sets.add(leer.getDeclaredFields()[i].getName());
          String type = leer.getDeclaredFields()[i].getGenericType().getTypeName().split(
              "\\.")[leer.getDeclaredFields()[i].getGenericType().getTypeName().split("\\.").length
                  - 1];
          type = type.replace(">", "");
          setsType.add(type);
          // System.err.println(leer.getDeclaredFields()[i].getType().getModifiers()+"
          // "+leer.getDeclaredFields()[i].getType()+" "+leer.getDeclaredFields()[i].getName());
        }
      }
    }
    Agregador.clase(url, clase, conId, sinId, sets, setsType, vars,
        varsTypes, toString, toStringTypes);

  }
}
