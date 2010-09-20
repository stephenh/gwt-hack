package com.bizo.gwthack.shared.model;

import org.bindgen.Bindable;
import org.gwtmpv.model.Dto;

import com.bizo.gwthack.client.model.GClientModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/** DTO sent to/from server. */
@Bindable
public class GClientDto implements IsSerializable, Dto<GClientModel> {

  public String id;
  public String name;

  public GClientDto() {
  }

  public GClientDto(final String id, final String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public GClientModel toModel() {
    return new GClientModel(this);
  }

}
