package com.bizo.gwthack.client.app.clients;

import org.gwtmpv.place.PlaceRequest;

import com.bizo.gwthack.client.AppRegistry;
import com.bizo.gwthack.client.app.AbstractPlace;
import com.bizo.gwthack.client.app.AppPresenter;

public class ClientListPlace extends AbstractPlace<ClientListPresenter> {

  private static final String name = "clients";
  private final AppPresenter appPresenter;

  public static PlaceRequest request() {
    return new PlaceRequest(name);
  }

  public ClientListPlace(final AppRegistry registry, final AppPresenter appPresenter) {
    super(registry, name);
    this.appPresenter = appPresenter;
  }

  @Override
  public void handleRequest(final PlaceRequest request) {
    currentPresenter = new ClientListPresenter(registry);
    appPresenter.show(currentPresenter);
    currentPresenter.revealDisplay(); // needed?
  }

}
