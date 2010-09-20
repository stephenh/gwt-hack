package com.bizo.gwthack.client.messages;

import org.gwtmpv.GenDispatch;
import org.gwtmpv.In;
import org.gwtmpv.Out;

import com.bizo.gwthack.shared.model.ClientDto;

@GenDispatch
public class GetClientSpec {
  @In(1)
  String id;
  @Out(1)
  ClientDto client;
}
