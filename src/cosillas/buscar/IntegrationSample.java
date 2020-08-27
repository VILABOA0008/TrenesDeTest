package cosillas.buscar;

import java.util.ArrayList;

public class IntegrationSample {
  public static void integrationTestClass(String clase, ArrayList<String> methods) {

//        System.err.println(response.getBody().asString()); 

    String testMethods = "";
    String j="\n";

    for (String method : methods) {
      String status = "OK";
      String petition = "get(url + API);";
      String contains = "";
      String body = "";
      String expected = "";
      testMethods += "@Test\r\n" + "    public void " + method + "() {\n";

      if (method.contains("dd") || method.contains("reate")||method.contains("pdate")) {
        testMethods += "String body = \"\";"+j;
        expected += "String expected = \"\";"+j;
        body=".body(body)";
        status = "CREATED";
         petition = "post(url + API );";
         contains = "expected";
        if(method.contains("pdate")){
          expected = "";
           petition = "put(url + API+\"/\"+ID);";
          status = "OK";
          contains = "body";
        }
      } else if (method.contains("ecords")) {
        petition = "get(url + URL_RECORDS);";
        contains = "\"1\"";
      } else if (method.equals("testGet"+clase)) {
        petition = "get(url + API+\"/\"+ID);";
        expected = "System.err.println(response.getBody().asString() ); "+j;
      } else {

      }
      testMethods +=
          "Response response = given()"+body+".contentType(\"application/json\").when()."
              + petition+j;
      testMethods += "response.then().statusCode(Status." + status + ".getStatusCode());"+j;
      testMethods+=expected;

      testMethods += "assertThat(response.getBody().asString())" +j
          + ".contains("+contains+");\n";

      testMethods += "}"+j+j;
    }

    String test =
        "\r\n"
            + "import static io.restassured.RestAssured.given; \r\n" + 
            "import static org.assertj.core.api.Assertions.assertThat;\r\n" + 
            "\r\n" + 
            "import javax.transaction.Transactional;\r\n" + 
            "import javax.ws.rs.core.Response.Status;\r\n" + 
            "\r\n" + 
            "import org.junit.Test;\r\n" + 
            "import org.junit.runner.RunWith;\r\n" + 
            "import org.seedstack.jpa.JpaUnit;\r\n" + 
            "import org.seedstack.seed.Configuration;\r\n" + 
            "import org.seedstack.seed.testing.LaunchMode;\r\n" + 
            "import org.seedstack.seed.testing.LaunchWith;\r\n" + 
            "import org.seedstack.seed.testing.junit4.SeedITRunner;\r\n" + 
            "import org.seedstack.seed.undertow.internal.UndertowLauncher;\r\n" + 
            "\r\n" + 
            "import io.restassured.response.Response;"
            + "\n\n@JpaUnit\r\n"
            + "@Transactional\r\n"
            + "@RunWith(SeedITRunner.class)\r\n"
            + "@LaunchWith(mode = LaunchMode.PER_TEST, value = UndertowLauncher.class)\r\n"
            + "public class "
            + clase
            + "ApiServiceIntegrationTest {\r\n"
            + "\r\n"
            + "  @Configuration(\"runtime.web.baseUrlSlash\")\r\n"
            + "  private String url;\r\n"
            + "  private static final int ID = 1;\r\n"
            + "  private static final String API = \"api/"
            + IntegrationSample.formatToUrl(clase)
            + "\";\n"
            + "  private static final String URL_RECORDS = API + \"/count\";"
            + " \r\n"
            + testMethods
            + "}\r\n";

    System.err.println(test);
  }

  public static String formatToUrl(String string) {

    for (int i = 1; i < string.length(); i++) {
      String substring = string.substring(i, i + 1);
      if (substring.equals(substring.toUpperCase())) {
        string = string.substring(0, i) + "-" + string.substring(i);
        i++;
      }
    }

    return string.toLowerCase();
  }
}
