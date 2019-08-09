package com.ctag.paperless.quality.domain.model.controlplanpart;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.spi.MappingContext;

import com.ctag.paperless.quality.domain.model.controlplanpart.ControlPlanPartId;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

@RunWith(MockitoJUnitRunner.class)
public class ControlPlanPartIdUnitTest {

  private static final Integer TEST_INTEGER = 1;

  @Mock
  private MappingContext<Integer, ControlPlanPartId> mockedMappingContext;

  private ControlPlanPartId underTest;

  @Before
  public void setUp() throws Exception {
    underTest = new ControlPlanPartId(TEST_INTEGER);
  }

  @Test
  public void testEmptyConstructor() throws Exception {
    new ControlPlanPartIdUnitTest();
  }

  @Test
  public void testEquals() {
    EqualsVerifier.forClass(ControlPlanPartId.class)
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