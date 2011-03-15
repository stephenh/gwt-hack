package com.bizo.gwthack.shared.model;

import com.google.gwt.user.client.rpc.*;

public class EmployeeDto implements IsSerializable {

  public String name;
  public String description;

  EmployeeDto() {
  }

  public EmployeeDto(String name, String description) {
    this.name = name;
    this.description = description;
  }

}
