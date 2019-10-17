package cosillas;

import java.util.Scanner;

public class contarChasers {

  public static void main(String[] args) {
    Scanner s=new  Scanner(System.in);
    String contado="[  {\r\n" + 
        "    \"code\": \"string\",\r\n" + 
        "    \"idDesign\": 1,\r\n" + 
        "    \"idPartType\": 2,\r\n" + 
        "    \"name\": \"TAPA\",\r\n" + 
        "    \"idPart\": 1,\r\n" + 
        "    \"revision\": 1,\r\n" + 
        "    \"state\": 1,\r\n" + 
        "    \"idVersion\": PartVersionId[id=1],\r\n" + 
        "    \"design\": {\r\n" + 
        "      \"code\": \"CTAG\",\r\n" + 
        "      \"name\": \"CTAG-Design\",\r\n" + 
        "      \"idDesign\": 1\r\n" + 
        "    },\r\n" + 
        "    \"partType\": {\r\n" + 
        "      \"idPartType\": 2,\r\n" + 
        "      \"name\": \"Producto\"\r\n" + 
        "    }\r\n" + 
        "  },  {\r\n" + 
        "    \"code\": \"string\",";
    int contador=178;
    
System.err.println(contado.subSequence(contador-10, contador+10));
System.err.println("\n                       "+contado.charAt(contador));
  }
}
