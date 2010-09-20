package com.bizo.gwthack.shared.model;

import org.bindgen.Bindable;
import org.gwtmpv.model.Dto;

import com.bizo.gwthack.client.model.ClientModel;

/** DTO sent to/from server. */
@Bindable
public class ClientDto implements Dto<ClientModel> {

  public String id;
  public String name;

  public ClientDto() {
  }

  public ClientDto(final String id, final String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public ClientModel toModel() {
    return new ClientModel(this);
  }

}
