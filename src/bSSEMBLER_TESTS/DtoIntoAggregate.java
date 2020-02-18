package bSSEMBLER_TESTS;

public class DtoIntoAggregate {

  public static void main(String[] args) {

    String clase = "Component";
    clase = clase.toLowerCase();
    String pre =
        "    "
            + "    targetAggregate.setComponentTypeId(new ComponentTypeId(sourceDto.getIdComponentType()));\r\n"
            + "    targetAggregate.setName(sourceDto.getName());\r\n"
            + "    targetAggregate.setShortName(sourceDto.getShortName());\r\n"
            + "    targetAggregate.setStateId(new FactoryLayoutStateId(sourceDto.getState()));\r\n"
            + "    targetAggregate.setStationId(new StationId(sourceDto.getIdStation()));";

    String pos =
        "    "
            + "    assertThat(component.getComponentTypeId().getId()).isEqualTo(ID);\r\n"
            + "    assertThat(component.getStationId().getId()).isEqualTo(ID);\r\n"
            + "    assertThat(component.getStateId().getId()).isEqualTo(ID);\r\n"
            + "    assertThat(component.getName()).isEqualTo(TEST_STRING);\r\n"
            + "    assertThat(component.getShortName()).isEqualTo(TEST_STRING);";

    String p = pre.replace("targetAggregate.s", "assertThat(" + clase + ".g");
    p = p.replace("(sourceAggregate", "()).isEqualTo(" + clase + "");

    System.err.println(p);
  }
}
