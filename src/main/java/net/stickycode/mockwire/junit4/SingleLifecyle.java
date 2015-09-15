package net.stickycode.mockwire.junit4;

import java.util.ArrayList;
import java.util.List;

import net.stickycode.stereotype.StickyComponent;

@StickyComponent
public class SingleLifecyle {

  List<String> seen = new ArrayList<>();

  public void seen(String methodName) {
    seen.add(methodName);
  }

}
