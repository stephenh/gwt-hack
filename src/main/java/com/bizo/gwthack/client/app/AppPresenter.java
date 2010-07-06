package com.bizo.gwthack.client.app;

import org.gwtmpv.presenter.BasicPresenter;
import org.gwtmpv.presenter.Presenter;
import org.gwtmpv.presenter.Slot;
import org.gwtmpv.util.PlaceOnClick;

import com.bizo.gwthack.client.AppRegistry;
import com.bizo.gwthack.client.app.clients.ClientListPlace;
import com.bizo.gwthack.client.app.employees.EmployeeListPlace;

public class AppPresenter extends BasicPresenter<IsAppView> {

  private final Slot<Presenter> current = new Slot<Presenter>(this);

  public AppPresenter(final AppRegistry registry) {
    super(registry.getAppViews().getAppView(), registry.getEventBus());
  }

  @Override
  public void onBind() {
    super.onBind();
    registerHandler(PlaceOnClick.register(eventBus, view.clientsAnchor(), ClientListPlace.request()));
    registerHandler(PlaceOnClick.register(eventBus, view.employeesAnchor(), EmployeeListPlace.request()));
  }

  public void show(final Presenter presenter) {
    current.set(presenter);
    view.content().clear();
    view.content().add(presenter.getView());
  }

}
