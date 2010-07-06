package com.bizo.gwthack.client.app.employees;

import org.gwtmpv.place.PlaceRequest;

import com.bizo.gwthack.client.AppRegistry;
import com.bizo.gwthack.client.app.AbstractPlace;
import com.bizo.gwthack.client.app.AppPresenter;

public class EmployeeListPlace extends AbstractPlace<EmployeeListPresenter> {

  private static final String name = "employees";
  private final AppPresenter appPresenter;

  public static PlaceRequest request() {
    return new PlaceRequest(name);
  }

  public EmployeeListPlace(final AppRegistry registry, final AppPresenter appPresenter) {
    super(registry, name);
    this.appPresenter = appPresenter;
  }

  @Override
  public void handleRequest(final PlaceRequest request) {
    currentPresenter = new EmployeeListPresenter(registry);
    appPresenter.show(currentPresenter);
    currentPresenter.revealDisplay(); // needed?
  }

}
