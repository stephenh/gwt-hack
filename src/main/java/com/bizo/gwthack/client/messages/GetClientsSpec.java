package com.bizo.gwthack.client.messages;

import java.util.ArrayList;

import org.gwtmpv.GenDispatch;
import org.gwtmpv.In;
import org.gwtmpv.Out;

import com.bizo.gwthack.shared.model.ClientDto;

@GenDispatch
public class GetClientsSpec {
  @In(1)
  Integer start;
  @In(2)
  Integer end;
  @Out(1)
  ArrayList<ClientDto> clients;
}
