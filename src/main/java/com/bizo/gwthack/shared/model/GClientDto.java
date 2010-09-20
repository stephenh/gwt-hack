package com.bizo.gwthack.shared.model;

import java.io.Serializable;

import org.bindgen.Bindable;
import org.gwtmpv.model.Dto;

import com.bizo.gwthack.client.model.GClientModel;

/** DTO sent to/from server. */
@Bindable
public class GClientDto implements Serializable, Dto<GClientModel> {

  private static final long serialVersionUID = 1L;
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
