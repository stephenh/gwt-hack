package com.bizo.gwthack.shared.model;

import java.io.Serializable;

import org.bindgen.Bindable;

/** DTO sent to/from server. */
@Bindable
public class GClientDto implements Serializable {

  private static final long serialVersionUID = 1L;
  public String id;
  public String name;

  public GClientDto() {
  }

  public GClientDto(final String id, final String name) {
    this.id = id;
    this.name = name;
  }
}
