package FACTORIO_TESTS;

import java.util.ArrayList;

public class Factory {
  
  public static void FactoryTest(String pack,String claseFactory,String[] types,String vars[]) {
    claseFactory=claseFactory.replace("Default", "");
    String clase=claseFactory.replace("Factory", "");
    claseFactory=clase+"Factory";
    String b="",c="",d="";
    for(int i=1;i<types.length;i++) {
      String value;
      String var=vars[i];
      switch(types[i]){
      case "String": value="\""+vars[i]+"\""; break;
      case "boolean": value="true";  break;
      case "Double": value="1D"; break;
      case "LocalDateTime": value="LocalDateTime.now();"; break;
      case "LocalDate": value="LocalDate.now();"; break;
      default: value="1";
      }
      var=var.toUpperCase();
      if(var.contains("ID")) {
        if(var.substring(0, 2).contains("ID")){var=var.replace("ID", "ID_"); }else {
        var=var.replace("ID", "_ID"); 
        }
        System.err.println(vars[i]+"  hmm");
        c+="    assertThat(test.get"+vars[i].substring(0,1).replace(vars[i].substring(0,1), vars[i].substring(0,1).toUpperCase())+vars[i].substring(1)+"().getId()).isNotNull().isEqualTo("+var+");\n";
        System.err.println(c+"mmh");
      }else {
        c+=        "    assertThat(test.get"+vars[i].substring(0,1).replace(vars[i].substring(0,1), vars[i].substring(0,1).toUpperCase())+vars[i].substring(1)+"()).isNotNull().isEqualTo("+var+");\r\n" ;
        
      }
      b+="  private static final "+types[i]+" "+var+" = "+value+";\n";
      d+=var+","; 
      
    }
    d=d.substring(0,d.length()-1);
    String a="package com.ctag.paperless.domain.model."+pack+";\r\n" + 
        "\r\n" + 
        "import static org.assertj.core.api.Assertions.assertThat; \r\n" + 
        "\r\n" + 
        "import org.junit.Before;\r\n" + 
        "import org.junit.Test;\r\n" + 
        "\r\n" + 
        "public class "+claseFactory+"UnitTest {\r\n" + 
        "\r\n" + 
          b+
        "\r\n" + 
        "  private "+claseFactory+" underTest;\r\n" + 
        "\r\n" + 
        "  @Before\r\n" + 
        "  public final void setUp() {\r\n" + 
        "    underTest = new "+clase+"Default();\r\n" + 
        "  }\r\n" + 
        "\r\n" + 
        "  @Test\r\n" + 
        "  public final void testCreate"+clase+"() {\r\n" + 
        "\r\n" + 
        "    final "+clase+" test = underTest.create"+clase+"("+d+");\r\n" + 
        "    assertThat(test).isNotNull();\r\n" + 
        c+
        "  }\r\n" + 
        "}\r\n" + 
        "";
    ArrayList<String>clases=new ArrayList<>();
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
    for(String l:clases) {
      if(l.equalsIgnoreCase(clase)) {
        Escribir2.escribir("", a, claseFactory);break;
      }
      
    }

//    System.err.println(a);
    
  }

}
