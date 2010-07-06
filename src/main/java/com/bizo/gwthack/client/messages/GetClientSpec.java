package com.bizo.gwthack.client.messages;

import org.gwtmpv.GenDispatch;

import com.bizo.gwthack.shared.model.GClientDto;

@GenDispatch
public class GetClientSpec {
  String in1id;

  GClientDto out1client;
}
