package com.bizo.gwthack.client;

import com.bizo.gwthack.client.presenters.*;
import com.google.gwt.core.client.*;
import com.google.gwt.user.client.ui.*;
import org.gwtmpv.place.*;

public class GwtHackApp implements EntryPoint {

  private AppPresenter appPresenter;

  public void onModuleLoad() {
    onModuleLoad(new AppRegistryInstance());
    RootPanel.get().add(appPresenter.getView().asWidget());
  }

  public void onModuleLoad(final AppRegistry registry) {
    appPresenter = new AppPresenter(registry);
    appPresenter.bind();

    final PlaceManager places = registry.getPlaceManager();
    places.registerPlace(new ClientPlace(registry, appPresenter));
    places.registerPlace(new ClientListPlace(registry, appPresenter));
    places.registerPlace(new EmployeeListPlace(registry, appPresenter));
    places.fireCurrentOr(ClientListPlace.newRequest());
  }

}
