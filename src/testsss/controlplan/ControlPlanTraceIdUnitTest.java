package com.ctag.paperless.quality.domain.model.controlplan;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.spi.MappingContext;

import com.ctag.paperless.quality.domain.model.controlplan.ControlPlanTraceId;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

@RunWith(MockitoJUnitRunner.class)
public class ControlPlanTraceIdUnitTest {

  private static final Integer TEST_INTEGER = 1;

  @Mock
  private MappingContext<Integer, ControlPlanTraceId> mockedMappingContext;

  private ControlPlanTraceId underTest;

  @Before
  public void setUp() throws Exception {
    underTest = new ControlPlanTraceId(TEST_INTEGER);
  }

  @Test
  public void testEmptyConstructor() throws Exception {
    new ControlPlanTraceIdUnitTest();
  }

  @Test
  public void testEquals() {
    EqualsVerifier.forClass(ControlPlanTraceId.class)
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