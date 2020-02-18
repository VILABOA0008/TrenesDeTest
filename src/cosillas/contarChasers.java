package cosillas;

import java.util.Scanner;

public class contarChasers {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String contado =
        " {  \"idCreator\": 1,  \"idType\": 1,  \"idConversation\": 1,  \"idState\": 1,  \"creation\": \"2019-04-04T14:46:25Z,  \"messages\": [    {      \"idMessage\": 1001,     \"idAuthor\": 1,      \"idMessageState\": 1,      \"postTime\": \"2019-10-22T14:53:01.325Z\",      \"editTime\": \"2019-10-22T14:53:01.325Z\",      \"message\": \"thisMessage\"    }  ";
    int contador = 22;

System.err.println(contado.subSequence(contador-10, contador+10));
System.err.println("\n                       "+contado.charAt(contador));
  }
}
