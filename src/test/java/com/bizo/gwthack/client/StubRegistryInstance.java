package com.bizo.gwthack.client;

import com.bizo.gwthack.client.resources.*;
import com.bizo.gwthack.client.views.*;
import org.gwtmpv.bus.*;
import org.gwtmpv.dispatch.client.*;
import org.gwtmpv.dispatch.client.util.*;
import org.gwtmpv.place.*;
import org.gwtmpv.place.history.*;
import org.gwtmpv.place.tokenizer.*;
import org.gwtmpv.widgets.*;

public class StubRegistryInstance implements AppRegistry {

  private final StubEventBus bus = new StubEventBus();
  private final Tokenizer tokenizer = new DefaultTokenizer();
  private final StubHistory history = new StubHistory();
  private final PlaceManager placeManager = new DefaultPlaceManager(bus, tokenizer, history);
  private final StubOutstandingDispatchAsync async = new StubOutstandingDispatchAsync(bus, new StubDispatchAsync());
  private final AppResources resources = new StubAppResources();

  public StubRegistryInstance() {
    StubWidgetsProvider.install();
    StubViewsProvider.install();
  }

  @Override
  public Tokenizer getTokenizer() {
    return tokenizer;
  }

  @Override
  public PlaceManager getPlaceManager() {
    return placeManager;
  }

  @Override
  public StubEventBus getEventBus() {
    return bus;
  }

  @Override
  public StubOutstandingDispatchAsync getAsync() {
    return async;
  }

  @Override
  public AppResources getAppResources() {
    return resources;
  }

}
