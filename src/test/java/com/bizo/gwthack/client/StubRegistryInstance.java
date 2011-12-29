package com.bizo.gwthack.client;

import com.bizo.gwthack.client.resources.*;
import com.bizo.gwthack.client.views.*;
import org.tessell.bus.*;
import org.tessell.dispatch.client.*;
import org.tessell.dispatch.client.util.*;
import org.tessell.place.*;
import org.tessell.place.history.*;
import org.tessell.place.tokenizer.*;
import org.tessell.widgets.*;

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
