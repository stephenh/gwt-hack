package com.bizo.gwthack.client;

import org.gwtmpv.place.PlaceManager;

import com.bizo.gwthack.client.app.AppPresenter;
import com.bizo.gwthack.client.app.client.ClientPlace;
import com.bizo.gwthack.client.app.clients.ClientListPlace;
import com.bizo.gwthack.client.app.employees.EmployeeListPlace;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class GwtHackApp implements EntryPoint {

  private AppPresenter appPresenter;

  public void onModuleLoad() {
    onModuleLoad(new AppRegistryInstance());
    RootPanel.get().add(appPresenter.getView().asWidget());
  }

  public void onModuleLoad(final AppRegistry registry) {
    appPresenter = registry.getAppPresenter();
    appPresenter.bind();

    final PlaceManager places = registry.getPlaceManager();
    places.registerPlace(new ClientPlace(registry, appPresenter));
    places.registerPlace(new ClientListPlace(registry, appPresenter));
    places.registerPlace(new EmployeeListPlace(registry, appPresenter));

    if (!places.fireCurrentPlace()) {
      appPresenter.revealDisplay();
    }
  }
}
