package com.bizo.gwthack.client.app;

import org.gwtmpv.bus.EventBus;
import org.gwtmpv.place.PlaceRequest;
import org.gwtmpv.place.events.PlaceRequestEvent;
import org.gwtmpv.presenter.BasicPresenter;
import org.gwtmpv.presenter.Presenter;
import org.gwtmpv.presenter.Slot;

import com.bizo.gwthack.client.AppRegistry;
import com.bizo.gwthack.client.app.clients.ClientListPlace;
import com.bizo.gwthack.client.app.employees.EmployeeListPlace;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;

public class AppPresenter extends BasicPresenter<IsAppView> {

  private final Slot<Presenter> current = new Slot<Presenter>(this);

  public AppPresenter(final AppRegistry registry) {
    super(registry.getAppViews().getAppView(), registry.getEventBus());
  }

  @Override
  public void onBind() {
    super.onBind();
    registerHandler(register(eventBus, view.clientsAnchor(), ClientListPlace.request()));
    registerHandler(register(eventBus, view.employeesAnchor(), EmployeeListPlace.request()));
  }

  public void show(final Presenter presenter) {
    current.set(presenter);
    view.content().clear();
    view.content().add(presenter.getView());
  }

  /** Fires PlaceRequestEvent when {@code link} is clicked. */
  private HandlerRegistration register(final EventBus eventBus, final HasClickHandlers link, final PlaceRequest request) {
    return link.addClickHandler(new ClickHandler() {
      public void onClick(final ClickEvent event) {
        eventBus.fireEvent(new PlaceRequestEvent(request));
      }
    });
  }

}
