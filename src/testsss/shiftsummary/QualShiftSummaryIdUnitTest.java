package com.ctag.paperless.quality.domain.model.shiftsummary;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.spi.MappingContext;

import com.ctag.paperless.quality.domain.model.shiftsummary.QualShiftSummaryId;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

@RunWith(MockitoJUnitRunner.class)
public class QualShiftSummaryIdUnitTest {

  private static final Integer TEST_INTEGER = 1;

  @Mock
  private MappingContext<Integer, QualShiftSummaryId> mockedMappingContext;

  private QualShiftSummaryId underTest;

  @Before
  public void setUp() throws Exception {
    underTest = new QualShiftSummaryId(TEST_INTEGER);
  }

  @Test
  public void testEmptyConstructor() throws Exception {
    new QualShiftSummaryIdUnitTest();
  }

  @Test
  public void testEquals() {
    EqualsVerifier.forClass(QualShiftSummaryId.class)
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