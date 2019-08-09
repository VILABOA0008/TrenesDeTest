package com.ctag.paperless.quality.domain.model.controltriggerdefinition;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.spi.MappingContext;

import com.ctag.paperless.quality.domain.model.controltriggerdefinition.ControlTriggerDefinitionId;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

@RunWith(MockitoJUnitRunner.class)
public class ControlTriggerDefinitionIdUnitTest {

  private static final Integer TEST_INTEGER = 1;

  @Mock
  private MappingContext<Integer, ControlTriggerDefinitionId> mockedMappingContext;

  private ControlTriggerDefinitionId underTest;

  @Before
  public void setUp() throws Exception {
    underTest = new ControlTriggerDefinitionId(TEST_INTEGER);
  }

  @Test
  public void testEmptyConstructor() throws Exception {
    new ControlTriggerDefinitionIdUnitTest();
  }

  @Test
  public void testEquals() {
    EqualsVerifier.forClass(ControlTriggerDefinitionId.class)
        .withRedefinedSuperclass()
        .suppress(Warning.SURROGATE_KEY)
        .usingGetClass()
        .verify();
  }

  @Test
  public void testId() {
    Assertions.assertThat(underTest.getId()).isNotNull().isEqualTo(TEST_INTEGER);
  }
}