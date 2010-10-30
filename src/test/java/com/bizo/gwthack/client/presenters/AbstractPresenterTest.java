package com.bizo.gwthack.client.presenters;

import org.gwtmpv.bus.StubEventBus;
import org.gwtmpv.dispatch.client.util.StubOutstandingDispatchAsync;
import org.gwtmpv.presenter.Presenter;
import org.gwtmpv.widgets.StubWidgetsProvider;

import com.bizo.gwthack.client.StubRegistryInstance;

public class AbstractPresenterTest {

  static {
    StubWidgetsProvider.install();
  }

  protected final StubRegistryInstance registry = new StubRegistryInstance();
  protected final StubOutstandingDispatchAsync async = registry.getAsync();
  protected final StubEventBus bus = registry.getEventBus();

  protected <P extends Presenter> P bind(P presenter) {
    presenter.bind();
    return presenter;
  }

}
