package com.bizo.gwthack.client;

import org.gwtmpv.place.PlaceManager;

import com.bizo.gwthack.client.presenters.AppPresenter;
import com.bizo.gwthack.client.presenters.ClientListPlace;
import com.bizo.gwthack.client.presenters.ClientPlace;
import com.bizo.gwthack.client.presenters.EmployeeListPlace;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

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

    if (!places.fireCurrentPlace()) {
      appPresenter.revealDisplay();
    }
  }
}
