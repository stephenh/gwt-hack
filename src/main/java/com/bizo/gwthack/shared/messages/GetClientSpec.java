package com.bizo.gwthack.shared.messages;

import com.bizo.gwthack.shared.model.*;
import org.gwtmpv.*;

@GenDispatch
public class GetClientSpec {
  @In(1)
  String id;
  @Out(1)
  ClientDto client;
}
