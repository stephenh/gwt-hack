package com.bizo.gwthack.client.presenters;

import org.gwtmpv.dispatch.client.util.OutstandingDispatchAsync;
import org.gwtmpv.model.dsl.Binder;
import org.gwtmpv.place.PlaceRequest;
import org.gwtmpv.presenter.BasicPresenter;
import org.gwtmpv.widgets.IsWidget;

import com.bizo.gwthack.client.AppRegistry;
import com.google.gwt.event.shared.EventBus;

public abstract class AbstractPresenter<D extends IsWidget> extends BasicPresenter<D> {

  protected final AppRegistry registry;
  protected final OutstandingDispatchAsync async;
  protected final Binder binder = new Binder(this);
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
