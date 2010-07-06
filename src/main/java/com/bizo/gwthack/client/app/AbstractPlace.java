package com.bizo.gwthack.client.app;

import org.gwtmpv.place.PresenterPlace;
import org.gwtmpv.presenter.Presenter;

import com.bizo.gwthack.client.AppRegistry;

public abstract class AbstractPlace<T extends Presenter> extends PresenterPlace<T> {

  protected final AppRegistry registry;

  public AbstractPlace(final AppRegistry registry, final String name) {
    super(registry.getEventBus(), name);
    this.registry = registry;
  }

}
