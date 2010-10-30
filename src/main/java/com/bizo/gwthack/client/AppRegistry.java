package com.bizo.gwthack.client;

import org.gwtmpv.dispatch.client.util.OutstandingDispatchAsync;
import org.gwtmpv.place.PlaceManager;
import org.gwtmpv.place.tokenizer.Tokenizer;

import com.google.gwt.event.shared.EventBus;

public interface AppRegistry {

  AppViews getAppViews();

  Tokenizer getTokenizer();

  PlaceManager getPlaceManager();

  EventBus getEventBus();

  OutstandingDispatchAsync getAsync();

}
