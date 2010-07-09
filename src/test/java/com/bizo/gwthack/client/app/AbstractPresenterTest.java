package com.bizo.gwthack.client.app;

import org.gwtmpv.bus.StubEventBus;
import org.gwtmpv.dispatch.client.util.StubOutstandingDispatchAsync;

import com.bizo.gwthack.client.TestRegistryInstance;

public class AbstractPresenterTest {

  protected final TestRegistryInstance registry = new TestRegistryInstance();
  protected final StubOutstandingDispatchAsync async = registry.getAsync();
  protected final StubEventBus bus = registry.getEventBus();

}
