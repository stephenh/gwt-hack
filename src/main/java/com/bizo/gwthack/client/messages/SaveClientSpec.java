package com.bizo.gwthack.client.messages;

import java.util.List;

import org.gwtmpv.GenDispatch;

import com.bizo.gwthack.shared.model.GClientDto;

@GenDispatch
public class SaveClientSpec {
  GClientDto in1client;
  // somehow drop into the Repository/UoW?
  List<String> out1messages;
}
