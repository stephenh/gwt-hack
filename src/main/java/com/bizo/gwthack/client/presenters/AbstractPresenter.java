package com.bizo.gwthack.client.presenters;

import org.gwtmpv.dispatch.client.DispatchAsync;
import org.gwtmpv.model.dsl.Binder;
import org.gwtmpv.presenter.BasicPresenter;
import org.gwtmpv.widgets.IsWidget;

import com.bizo.gwthack.client.AppRegistry;

public abstract class AbstractPresenter<D extends IsWidget> extends BasicPresenter<D> {

  protected final AppRegistry registry;
  protected final DispatchAsync async;
  protected final Binder binder = new Binder(this);

  public AbstractPresenter(final D display, final AppRegistry registry) {
    super(display, registry.getEventBus());
    this.registry = registry;
    async = registry.getAsync();
  }

}
