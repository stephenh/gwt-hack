package com.bizo.gwthack.client;

import com.google.gwt.event.shared.*;
import org.gwtmpv.dispatch.client.util.*;
import org.gwtmpv.place.*;
import org.gwtmpv.place.history.*;
import org.gwtmpv.place.tokenizer.*;

public class AppRegistryInstance implements AppRegistry {

  private final EventBus eventBus;
  private final PlaceManager placeManager;
  private final OutstandingDispatchAsync async;
  private final Tokenizer tokenizer;
  private final AppViews views;

  public AppRegistryInstance() {
    eventBus = new SimpleEventBus();
    async = new OutstandingDispatchAsync(eventBus);
    tokenizer = new DefaultTokenizer();
    placeManager = new DefaultPlaceManager(eventBus, tokenizer, new GwtHistory());
    views = new GwtViews();
  }

  @Override
  public OutstandingDispatchAsync getAsync() {
    return async;
  }

  @Override
  public PlaceManager getPlaceManager() {
    return placeManager;
  }

  @Override
  public EventBus getEventBus() {
    return eventBus;
  }

  @Override
  public Tokenizer getTokenizer() {
    return tokenizer;
  }

  @Override
  public AppViews getAppViews() {
    return views;
  }

}
