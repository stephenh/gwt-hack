package com.bizo.gwthack.client.presenters;

import org.gwtmpv.bus.StubEventBus;
import org.gwtmpv.dispatch.client.util.StubOutstandingDispatchAsync;

import com.bizo.gwthack.client.StubRegistryInstance;

public class AbstractPresenterTest {

  protected final StubRegistryInstance registry = new StubRegistryInstance();
  protected final StubOutstandingDispatchAsync async = registry.getAsync();
  protected final StubEventBus bus = registry.getEventBus();

}
