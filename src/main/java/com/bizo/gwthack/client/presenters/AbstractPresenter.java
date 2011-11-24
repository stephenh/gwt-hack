package com.bizo.gwthack.client.presenters;

import com.bizo.gwthack.client.*;
import com.google.web.bindery.event.shared.*;
import org.gwtmpv.dispatch.client.util.*;
import org.gwtmpv.model.dsl.*;
import org.gwtmpv.place.*;
import org.gwtmpv.presenter.*;
import org.gwtmpv.widgets.*;

public abstract class AbstractPresenter<D extends IsWidget> extends BasicPresenter<D> {

  protected final AppRegistry registry;
  protected final OutstandingDispatchAsync async;
  protected final Binder binder = new Binder();
  protected final EventBus eventBus;

  public AbstractPresenter(final D display, final AppRegistry registry) {
    super(display);
    this.registry = registry;
    async = registry.getAsync();
    eventBus = registry.getEventBus();
  }

  protected void goTo(PlaceRequest request) {
    eventBus.fireEvent(request.asEvent());
  }

}
