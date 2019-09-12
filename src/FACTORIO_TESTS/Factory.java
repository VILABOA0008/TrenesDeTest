package FACTORIO_TESTS;

public class Factory {
  
  public static void FactoryTest(String pack,String claseFactory,String[] types,String vars[]) {
    claseFactory=claseFactory.replace("Default", "");
    String clase=claseFactory.replace("Factory", "");
    String b="",c="",d="";
    for(int i=1;i<types.length;i++) {
      String value;
      String var=vars[i];
      switch(types[i]){
      case "String": value="\""+vars[i]+"\""; break;
      case "boolean": value="true";  break;
      case "Double": value="1D"; break;
      case "LocalDateTime": value="LocalDateTime.now();"; break;
      default: value="1";
      }
      var=var.toUpperCase();
      if(var.contains("ID")) {
        var=var.replace("ID", "_ID"); 
        c+="    assertThat(test.get"+vars[i].replace(vars[i].substring(0,1), vars[i].substring(0,1).toUpperCase())+"().getId()).isNotNull().isEqualTo("+var+");\n";
      }else {
        c+=        "    assertThat(test.get"+vars[i].replace(vars[i].substring(0,1), vars[i].substring(0,1).toUpperCase())+"()).isNotNull().isEqualTo("+var+");\r\n" ;
        
      }
      b+="  private static final "+types[i]+" "+var+" = "+value+";\n";
      d+=var+",";
      
    }
    d=d.substring(0,d.length());
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
        "    underTest = new "+claseFactory+"Default();\r\n" + 
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
    
    System.err.println(a);
    
  }

}
