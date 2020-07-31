package tests;

import java.util.ArrayList;
import java.util.Arrays;

public class Representation {

  public static void RepresentaionTest(
      String pack, String claseRepresentation, String[] types, String vars[]) {
    if (claseRepresentation.equalsIgnoreCase("PartBomRepresentation")) {}
    String clase = claseRepresentation.replace("Representation", "");
    String b = "", c = "", d = "";

    String toString1 = "";
    String toString3 = "";

    for (int i = 0; i < types.length; i++) {
      String value;
      String var = vars[i];
      switch (types[i]) {
        case "String":
          value = "\"" + vars[i] + "\"";
          break;
        case "boolean":
          value = "true";
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
      String varcap =
          vars[i]
                  .substring(0, 1)
                  .replace(vars[i].substring(0, 1), vars[i].substring(0, 1).toUpperCase())
              + vars[i].substring(1);
      var = var.toUpperCase();
      if (var.contains("ID")) {
        if (var.substring(0, 2).contains("ID")) {
          var = var.replace("ID", "ID_");
        } else {
          var = var.replace("ID", "_ID");
        }
        c +=
            "  @Test\r\n"
                + "  public void test"
                + varcap
                + "() {\r\n"
                + "    underTest.set"
                + varcap
                + "("
                + var
                + ");\r\n"
                + "    assertThat(underTest.get"
                + varcap
                + "()).isNotNull().isEqualTo("
                + var
                + ");\r\n"
                + "  }\n\n";
      } else {
        c +=
            "  @Test\r\n"
                + "  public void test"
                + varcap
                + "() {\r\n"
                + "    underTest.set"
                + varcap
                + "("
                + var
                + ");\r\n"
                + "    assertThat(underTest.get"
                + varcap
                + "()).isNotNull().isEqualTo("
                + var
                + ");\r\n"
                + "  }\n\n";
      }
      b += "  private static final " + types[i] + " " + var + " = " + value + ";\n";
      d += var + ",";
    }
    String toString =
        Agregador.toString(
            clase,
            new ArrayList(Arrays.asList(vars)),
            new ArrayList(Arrays.asList(types)),
            new ArrayList<>());

    String equals = Agregador.oldEquals(claseRepresentation);

    d = d.substring(0, d.length() - 1);
    String representation =
        "package "
            + pack
            + ";\r\n"
            + "\r\n"
            + "import static org.assertj.core.api.Assertions.assertThat; \r\n"
            + "\r\n"
            + "import org.junit.Before;\r\n"
            + "import org.junit.Test;\r\n"
            + "\r\n"
            + "import nl.jqno.equalsverifier.EqualsVerifier;\r\n"
            + "import nl.jqno.equalsverifier.Warning;\n\n"
            + "public class "
            + claseRepresentation
            + "UnitTest {\r\n"
            + "\r\n"
            + b
            + "\r\n"
            + "  private "
            + claseRepresentation
            + " underTest;\r\n"
            + "\r\n"
            + "  @Before\r\n"
            + "  public final void setUp() {\r\n"
            + "    underTest = new "
            + clase
            + "Representation();\r\n"
            + "  }\r\n"
            + c
            + " \n\n"
            + equals
            + "\r\n"
            + " "
            + toString
            + "\n}\r\n"
            + "\r\n"
            + "";
    System.err.println(representation);
    //    ArrayList<String> clases = new ArrayList<>();
    //    //      clases.add("PartState");
    //    //      clases.add("LineType");
    //    //      clases.add("PsaShift");
    //    //      clases.add("ParameterType");
    //    //      clases.add("Parameter");
    //    //      clases.add("SourceMaterialType");
    //    //      clases.add("DeclarationType");
    //    //      clases.add("ProcessVigilance");
    //    //      clases.add("ProcessVigilanceVersion");
    //    //      clases.add("ProcessVigilanceVersionParameter");
    //    //      clases.add("ProcessVigilanceWarning");
    //    //      clases.add("ProcessVigilanceState");
    //    //      clases.add("ProcessLaunch");
    //    //      clases.add("LaunchModifiedParameter");
    //    //      clases.add("CoilLaunch");
    //    //      clases.add("reworkBatch");
    //    clases.add("PartSimple");
    //
    //    for (String l : clases) {
    //      if (l.equalsIgnoreCase(clase)) {
    //        Escribir2.escribir("", a, claseRepresentation);
    //        break;
    //      }
    //    }
  }
}
