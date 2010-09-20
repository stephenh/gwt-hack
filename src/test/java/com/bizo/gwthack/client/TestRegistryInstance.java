package com.bizo.gwthack.client;

import org.gwtmpv.bus.StubEventBus;
import org.gwtmpv.dispatch.client.util.StubDispatchAsync;
import org.gwtmpv.dispatch.client.util.StubOutstandingDispatchAsync;
import org.gwtmpv.place.DefaultPlaceManager;
import org.gwtmpv.place.PlaceManager;
import org.gwtmpv.place.history.StubHistory;
import org.gwtmpv.place.tokenizer.DefaultTokenizer;
import org.gwtmpv.place.tokenizer.Tokenizer;

import com.bizo.gwthack.client.AppRegistry;
import com.bizo.gwthack.client.AppWidgets;
import com.bizo.gwthack.client.StubWidgets;
import com.bizo.gwthack.client.app.AppViews;
import com.bizo.gwthack.client.app.StubViews;

public class TestRegistryInstance implements AppRegistry {

  private final StubEventBus bus = new StubEventBus();
  private final AppViews appViews = new StubViews();
  private final AppWidgets widgets = new StubWidgets();
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

  @Override
  public AppWidgets getAppWidgets() {
    return widgets;
  }

}
