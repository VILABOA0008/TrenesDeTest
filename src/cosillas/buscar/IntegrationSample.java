package cosillas.buscar;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class IntegrationSample {
  public static void integrationTestClass(String clase, ArrayList<String> methods) {

    ArrayList<String> testMethods = new ArrayList<>();
    String testeos = methods.stream().map(
        method ->
                "@Test\r\n"
                    + "    public void "
                    + method
                    + "() {\r\n"
                    + "      \r\n"
                    + "      \r\n"
                    + "    }\n").collect(Collectors.joining());
    String test =
        "\r\n"
            + "import static io.restassured.RestAssured.given; \r\n"
            + "import static io.restassured.RestAssured.when;\r\n"
            + "import static org.assertj.core.api.Assertions.assertThat;\r\n"
            + "\r\n"
            + "import java.util.Optional;\r\n"
            + "\r\n"
            + "import javax.inject.Inject;\r\n"
            + "import javax.persistence.EntityManager;\r\n"
            + "import javax.ws.rs.core.MediaType;\r\n"
            + "\r\n"
            + "import org.junit.After;\r\n"
            + "import org.junit.Before;\r\n"
            + "import org.junit.Test;\r\n"
            + "import org.junit.runner.RunWith;\r\n"
            + "import org.mockito.internal.util.reflection.FieldSetter;\r\n"
            + "import org.seedstack.business.domain.Repository;\r\n"
            + "import org.seedstack.jpa.JpaUnit;\r\n"
            + "import org.seedstack.seed.Configuration;\r\n"
            + "import org.seedstack.seed.testing.LaunchMode;\r\n"
            + "import org.seedstack.seed.testing.LaunchWith;\r\n"
            + "import org.seedstack.seed.testing.junit4.SeedITRunner;\r\n"
            + "import org.seedstack.seed.transaction.Transactional;\r\n"
            + "import org.seedstack.seed.undertow.LaunchWithUndertow;\r\n"
            + "import org.seedstack.seed.undertow.internal.UndertowLauncher;\r\n"
            + "@JpaUnit\r\n"
            + "@Transactional\r\n"
            + "@RunWith(SeedITRunner.class)\r\n"
            + "@LaunchWith(mode = LaunchMode.PER_TEST, value = UndertowLauncher.class)\r\n"
            + "public class "
            + clase
            + "IntegrationTest {\r\n"
            + "\r\n"
            + "  @Configuration(\"runtime.web.baseUrlSlash\")\r\n"
            + "  private String baseUrl;\r\n"
            + "  @Inject\r\n"
            + "  private  "
            + clase
            + "Repository repository;\r\n"
            + " \r\n"
            + testeos
            + "}\r\n";
    
    System.err.println(test ); 
  }
}
