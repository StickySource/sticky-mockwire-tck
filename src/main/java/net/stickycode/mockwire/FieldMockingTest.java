/**
 * Copyright (c) 2010 RedEngine Ltd, http://www.redengine.co.nz. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package net.stickycode.mockwire;

import static org.assertj.core.api.StrictAssertions.assertThat;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.stickycode.bootstrap.ComponentContainer;
import net.stickycode.mockwire.junit4.MockwireRunner;

@RunWith(MockwireRunner.class)
public class FieldMockingTest {

  @Controlled
  private Mockable mockable;

  // XXX so this is hard to do with jmockit as the value cant' exist until the expectation
  // and the use case is spurious
  // @Inject
  // private Mockable injected;

  @Inject
  ComponentContainer context;

  // FIXME with a proper lifecycle
  // @Before
  public void before() {
    assertThat(mockable).isNotNull();
  }

  @Test
  public void atMock() {
    assertThat(context.canFind(Mockable.class)).isTrue();
//    assertThat(injected).isNotNull();
    assertThat(mockable).isNotNull();
  }

  public void verifyMock() {
//    assertThat(injected.callme()).isEqualTo(true);
  }
}
