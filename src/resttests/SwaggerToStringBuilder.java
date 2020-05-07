package com.ctag.paperless.psa.totem.rest.button.buscar;

import java.util.Scanner;

public class SwaggerToStringBuilder {

  private static final boolean CREATE = false;

  public static void main(String[] args) {
    String claseUp = "Style";
    String tipo="expected";
//    String clase = claseUp.toLowerCase();
    String swaggerRepresentation =
        "  "
            + "     {\r\n"
            + "    \"idStyle\": 0,\r\n"
            + "    \"name\": \"string\",\r\n"
            + "    \"styleClass\": \"string\"\r\n"
            + "  }";
    swaggerRepresentation = swaggerRepresentation.replace(" ", "");
    if (CREATE) {
      tipo="body";
      swaggerRepresentation = swaggerRepresentation.replace("0", "1");
    }
    String result = "StringBuilder "+tipo+"=new StringBuilder();\n";

    Scanner s = new Scanner(swaggerRepresentation);
    while (s.hasNext()) {
      String next = s.nextLine();
      if (!CREATE && next.contains("\"")) {
        String att = next.split("\"")[1];
        next =
            next.replace(
                "string",
                "kk+style.get" + att.substring(0, 1).toUpperCase() + att.substring(1) + "()+kk");
        att = att.replace("id" + claseUp, "");
        att = att.replace("id", "");
        att += "Id";
        next = next.replace("0", "kk+style.get" + att + "().getId()+kk");
      }
      result += tipo+".append(\"" + next.replace("\"", "\\" + "\"").replace("kk", "\"") + "\");\n";
    }
    System.err.println(result);
  }
}
