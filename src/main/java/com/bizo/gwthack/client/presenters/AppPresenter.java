package com.bizo.gwthack.client.presenters;

import org.gwtmpv.place.PlaceRequest;
import org.gwtmpv.presenter.Presenter;
import org.gwtmpv.presenter.Slot;

import com.bizo.gwthack.client.AppRegistry;
import com.bizo.gwthack.client.views.IsAppView;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;

public class AppPresenter extends AbstractPresenter<IsAppView> {

  private final Slot<Presenter> current = new Slot<Presenter>(this);

  public AppPresenter(final AppRegistry registry) {
    super(registry.getAppViews().getAppView(), registry);
  }

  @Override
  public void onBind() {
    super.onBind();
    registerHandler(register(eventBus, view.clientsAnchor(), ClientListPlace.newRequest()));
    registerHandler(register(eventBus, view.employeesAnchor(), EmployeeListPlace.newRequest()));
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
        eventBus.fireEvent(request.asEvent());
      }
    });
  }

}
