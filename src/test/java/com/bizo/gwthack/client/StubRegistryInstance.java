package com.bizo.gwthack.client;

import org.gwtmpv.bus.*;
import org.gwtmpv.dispatch.client.util.*;
import org.gwtmpv.place.*;
import org.gwtmpv.place.history.*;
import org.gwtmpv.place.tokenizer.*;

public class StubRegistryInstance implements AppRegistry {

  private final StubEventBus bus = new StubEventBus();
  private final AppViews appViews = new StubViews();
  private final Tokenizer tokenizer = new DefaultTokenizer();
  private final StubHistory history = new StubHistory();
  private final PlaceManager placeManager = new DefaultPlaceManager(bus, tokenizer, history);
  private final StubOutstandingDispatchAsync async = new StubOutstandingDispatchAsync(bus, new StubDispatchAsync());

  @Override
  public AppViews getAppViews() {
    return appViews;
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

}
