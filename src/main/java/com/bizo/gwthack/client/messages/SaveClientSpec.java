package com.bizo.gwthack.client.messages;

import java.util.ArrayList;

import org.gwtmpv.GenDispatch;
import org.gwtmpv.In;
import org.gwtmpv.Out;

import com.bizo.gwthack.shared.model.ClientDto;

@GenDispatch
public class SaveClientSpec {
  @In(1)
  ClientDto client;
  @Out(1)
  // somehow drop into the Repository/UoW?
  ArrayList<String> messages;
}
