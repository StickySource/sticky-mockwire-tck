package net.stickycode.mockwire.junit4;

import static org.assertj.core.api.StrictAssertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;

import net.stickycode.mockwire.MockwireSingleLifecycle;
import net.stickycode.mockwire.UnderTest;

@RunWith(MockwireRunner.class)
@MockwireSingleLifecycle
public class SingleLifecyleTest {

  @UnderTest
  SingleLifecyle cycle;

  static List<List<String>> seen = new ArrayList<>();

  @Rule
  public TestName name = new TestName();

  @Test
  public void one() {
    cycle.seen(name.getMethodName());
  }

  @Test
  public void two() {
    cycle.seen(name.getMethodName());
  }

  @Test
  public void three() {
    cycle.seen(name.getMethodName());
  }

  @After
  public void after() {
    assertThat(cycle).isNotNull();
    seen.add(new ArrayList(cycle.seen));
  }

  @AfterClass
  static public void afterClass() {
    assertThat(seen.size()).isEqualTo(3);
  }
}
