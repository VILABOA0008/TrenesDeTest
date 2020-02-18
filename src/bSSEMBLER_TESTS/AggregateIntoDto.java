package bSSEMBLER_TESTS;

public class AggregateIntoDto {

  public static void main(String[] args) {

    String clase = "Component";
    clase = clase.toLowerCase();
    String pre =
        "    "
            + "    targetDto.setIdComponent(sourceAggregate.getId().getId());\r\n"
            + "    targetDto.setIdComponentType(sourceAggregate.getComponentTypeId().getId());\r\n"
            + "    targetDto.setIdStation(sourceAggregate.getStationId().getId());\r\n"
            + "    targetDto.setState(sourceAggregate.getStateId().getId());\r\n"
            + "    targetDto.setName(sourceAggregate.getName());\r\n"
            + "    targetDto.setShortName(sourceAggregate.getShortName());";

    String pos =
        "    "
            + "    assertThat(dto.getIdComponent()).isEqualTo(component.getId().getId());\r\n"
            + "    assertThat(dto.getIdComponentType()).isEqualTo(component.getComponentTypeId().getId());\r\n"
            + "    assertThat(dto.getIdStation()).isEqualTo(component.getStationId().getId());\r\n"
            + "    assertThat(dto.getState()).isEqualTo(component.getStateId().getId());\r\n"
            + "    assertThat(dto.getName()).isEqualTo(component.getName());\r\n"
            + "    assertThat(dto.getShortName()).isEqualTo(component.getShortName());";

    String p = pre.replace("targetDto.s", "assertThat(dto.g");
    p = p.replace("(sourceAggregate", "()).isEqualTo(" + clase + "");
    
    System.err.println(p ); 
    
  }
}
