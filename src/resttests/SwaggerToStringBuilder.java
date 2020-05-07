package com.ctag.paperless.psa.totem.rest.button.buscar;

import java.util.Scanner;

public class SwaggerToStringBuilder {

  private static final boolean CREATE = false;

  public static void main(String[] args) {
    String claseUp = "Button";
    String tipo = "expected";
    String clase = claseUp.toLowerCase();
    String swaggerRepresentation =
        "  {\r\n"
            + "    \"idPage\": 0,\r\n"
            + "    \"name\": \"string\",\r\n"
            + "    \"x\": 0,\r\n"
            + "    \"y\": 0,\r\n"
            + "    \"w\": 0,\r\n"
            + "    \"h\": 0,\r\n"
            + "    \"heightIcon\": 0,\r\n"
            + "    \"active\": true,\r\n"
            + "    \"order\": 0,\r\n"
            + "    \"shortName\": \"string\",\r\n"
            + "    \"idButton\": 0,\r\n"
            + "    \"document\": \"string\",\r\n"
            + "    \"style\": {\r\n"
            + "      \"idStyle\": 0,\r\n"
            + "      \"name\": \"string\",\r\n"
            + "      \"styleClass\": \"string\"\r\n"
            + "    }\r\n"
            + "  },\r\n";
    swaggerRepresentation = swaggerRepresentation.replace(" ", "");
    if (CREATE) {
      tipo = "body";
      swaggerRepresentation = swaggerRepresentation.replace("0", "1");
    }
    String result = "StringBuilder " + tipo + "=new StringBuilder();\n";
    Scanner s = new Scanner(swaggerRepresentation);
    while (s.hasNext()) {
      String next = s.nextLine();
      if (!CREATE && next.contains("\"")) {
        String att = next.split("\"")[1];
        System.err.println(att);
        String replace =
            "kk+" + clase + ".get" + att.substring(0, 1).toUpperCase() + att.substring(1) + "()+kk";
        next = next.replace("string", replace);
        if(next.contains("true")||next.contains("false")) {
        next = next.replace("true", replace);
        next = next.replace("false", replace);
        next=next.replace("get", "is");
        }
        if (next.contains("0")) {
          if (att.contains("id")) {
            att = att.replace("id" + claseUp, "");
            att = att.replace("id", "");
            att += "Id";
            next = next.replace("0", "kk+" + clase + ".get" + att + "().getId()+kk");
          } else {
            next = next.replace("0", replace);
          }
        }
      }

      result +=
          tipo + ".append(\"" + next.replace("\"", "\\" + "\"").replace("kk", "\"") + "\");\n";
    }
    System.err.println(result);
  }
}
