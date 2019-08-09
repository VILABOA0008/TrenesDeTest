package com.ctag.paperless.quality.domain.model.resulttype;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.spi.MappingContext;

import com.ctag.paperless.quality.domain.model.resulttype.ResultTypeId;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

@RunWith(MockitoJUnitRunner.class)
public class ResultTypeIdUnitTest {

  private static final Integer TEST_INTEGER = 1;

  @Mock
  private MappingContext<Integer, ResultTypeId> mockedMappingContext;

  private ResultTypeId underTest;

  @Before
  public void setUp() throws Exception {
    underTest = new ResultTypeId(TEST_INTEGER);
  }

  @Test
  public void testEmptyConstructor() throws Exception {
    new ResultTypeIdUnitTest();
  }

  @Test
  public void testEquals() {
    EqualsVerifier.forClass(ResultTypeId.class)
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