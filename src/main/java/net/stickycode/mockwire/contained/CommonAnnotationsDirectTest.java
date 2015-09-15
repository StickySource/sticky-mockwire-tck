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
package net.stickycode.mockwire.contained;


import static org.assertj.core.api.StrictAssertions.assertThat;

import org.junit.Test;

import net.stickycode.mockwire.Mockwire;
import net.stickycode.mockwire.MockwireConfigured;
import net.stickycode.mockwire.MockwireContainer;
import net.stickycode.mockwire.UnderTest;

@MockwireConfigured("beanWithLifecycle.value=something")
public class CommonAnnotationsDirectTest {

  @UnderTest
  BeanWithLifecycle target;

  @Test
  public void cycle() {
    MockwireContainer context = Mockwire.isolate(this);
    assertThat(target.initialised).isTrue();
    assertThat(target.value).isEqualTo("something");

    context.shutdown();
    assertThat(target.destroyed).isTrue();
  }

}
