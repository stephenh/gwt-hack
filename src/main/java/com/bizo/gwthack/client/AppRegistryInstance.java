package com.bizo.gwthack.client;

import org.gwtmpv.dispatch.client.util.OutstandingDispatchAsync;
import org.gwtmpv.place.DefaultPlaceManager;
import org.gwtmpv.place.PlaceManager;
import org.gwtmpv.place.history.GwtHistory;
import org.gwtmpv.place.tokenizer.DefaultTokenizer;
import org.gwtmpv.place.tokenizer.Tokenizer;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;

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
