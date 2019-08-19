package AaTEEST;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.time.Instant;
import java.util.Set;

import com.ctag.paperless.core.domain.model.unit.Unit;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TEEEEEEEEEEEEEEEEEEEETST {

  private static final String TEST_STRING = "test";
  private static final Instant TEST_INSTANT = Instant.now();

  // @Test
  public void testGetUpperTolerance() throws Exception {
    underTest.setUpperTolerance(TEST_FLOAT);
    assertThat(underTest.getUpperTolerance()).isNotNull().isEqualTo(TEST_FLOAT);
  }

  // @Test
  public void testControlGroup() {
    assertThat(underTest.getControlGroup()).isNull();
  }

  // @Test
  public void testGet() throws Exception {
    assertThat(underTest.get).isEmpty();
  }

  // @Test
  public void testGet() {
    underTest.set(TEST_INTEGER);
    assertThat(underTest.get).isNotNull().isEqualTo(TEST_INTEGER);
  }

  // @Test
  public void testGet() {
    underTest.set(TEST_STRING);
    assertThat(underTest.get).isNotNull().isEqualTo(TEST_STRING);
  }

  // @Test
  public void testGet() {
    underTest.set(TEST_INSTANT);
    assertThat(underTest.get).isNotNull().isEqualTo(TEST_INSTANT);
  }

  // @Test
  public void testEquals() throws Exception {
    EqualsVerifier.forClass(CataloguedControl.class)
        .withPrefabValues(Unit.class, mock(Unit.class), mock(Unit.class))
        .withPrefabValues(Set.class, mock(Set.class), mock(Set.class))
        .usingGetClass()
        .suppress(Warning.SURROGATE_KEY)
        .withRedefinedSuperclass()
        .verify();

  }
}
