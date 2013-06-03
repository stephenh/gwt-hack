package com.bizo.gwthack.shared.model;

import com.bizo.gwthack.client.model.*;
import org.bindgen.*;

/** DTO sent to/from server. */
@Bindable
public class ClientDto {

  public String id;
  public String name;

  public ClientDto() {
  }

  public ClientDto(final String id, final String name) {
    this.id = id;
    this.name = name;
  }

  public ClientModel toModel() {
    return new ClientModel(this);
  }

}
