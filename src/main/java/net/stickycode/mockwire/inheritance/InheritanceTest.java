package net.stickycode.mockwire.inheritance;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.stickycode.mockwire.UnderTest;
import net.stickycode.mockwire.junit4.MockwireRunner;

@RunWith(MockwireRunner.class)
public class InheritanceTest {

  public static interface SuperSuper {
  }

  public static interface Super
      extends SuperSuper {
  }

  public static class ParentParent {
  }

  public static interface SuperParent {
  }

  public static class Parent
      extends ParentParent
      implements SuperParent {
  }

  public static class Concrete
      extends Parent
      implements Super {
  }

  @UnderTest
  Concrete concrete;

  @Inject
  SuperSuper superSuper;

  @Inject
  Super souper;

  @Inject
  SuperParent superParent;

  @Inject
  ParentParent parentParent;

  @Inject
  Parent parent;

  @Test
  public void inheritededInjection() {
    assertThat(concrete).isNotNull();
    assertThat(parent).isNotNull();
    assertThat(parentParent).isNotNull();
    assertThat(souper).isNotNull();
    assertThat(superParent).isNotNull();
    assertThat(superSuper).isNotNull();
  }
}
