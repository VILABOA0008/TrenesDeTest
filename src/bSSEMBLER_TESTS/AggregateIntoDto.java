package bSSEMBLER_TESTS;

import java.time.ZoneOffset;

public class AggregateIntoDto {

  public static void main(String[] args) {

    final String TARGET = "targetDto";
    final String NEW_TARGET = "dto";
    final String SOURCE = "sourceAggregate";
    String clase = "defect";
    String pre =
        "    "+
"    targetDto.setIdBasicGroup(sourceAggregate.getBasicGroupId().getId());\r\n" + 
"    targetDto.setIdDefect(sourceAggregate.getId().getId());\r\n" + 
"    targetDto.setName(sourceAggregate.getName());\r\n" + 
"    targetDto.setState(sourceAggregate.getStateId().getId());";

    String pos =
        "    "
            + "    assertThat(dto.getIdComponent()).isEqualTo(component.getId().getId());\r\n"
            + "    assertThat(dto.getIdComponentType()).isEqualTo(component.getComponentTypeId().getId());\r\n"
            + "    assertThat(dto.getIdStation()).isEqualTo(component.getStationId().getId());\r\n"
            + "    assertThat(dto.getState()).isEqualTo(component.getStateId().getId());\r\n"
            + "    assertThat(dto.getName()).isEqualTo(component.getName());\r\n"
            + "    assertThat(dto.getShortName()).isEqualTo(component.getShortName());";

    String p = pre.replace("" + TARGET + ".s", "assertThat(" + NEW_TARGET + ".g");
    p = p.replace("(" + SOURCE + ".g", "()).isEqualTo(" + clase + ".g");

    System.err.println(p);
  }
}
