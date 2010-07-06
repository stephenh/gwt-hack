package com.bizo.gwthack.client.messages;

import java.util.List;

import org.gwtmpv.GenDispatch;

import com.bizo.gwthack.shared.model.GClientDto;

@GenDispatch
public class GetClientsSpec {
  Integer in1start;
  Integer in2end;

  List<GClientDto> out1clients;
}
