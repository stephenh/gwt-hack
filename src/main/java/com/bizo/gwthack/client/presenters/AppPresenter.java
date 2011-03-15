package com.bizo.gwthack.client.presenters;

import static com.bizo.gwthack.client.views.AppViews.*;

import com.bizo.gwthack.client.*;
import com.bizo.gwthack.client.views.*;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.shared.*;
import org.gwtmpv.place.*;
import org.gwtmpv.presenter.*;

public class AppPresenter extends AbstractPresenter<IsAppView> {

  private final Slot<Presenter> current = new Slot<Presenter>(this);

  public AppPresenter(final AppRegistry registry) {
    super(newAppView(), registry);
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
