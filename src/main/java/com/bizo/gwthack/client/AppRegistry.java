package com.bizo.gwthack.client;

import org.gwtmpv.bus.EventBus;
import org.gwtmpv.dispatch.client.DispatchAsync;
import org.gwtmpv.place.PlaceManager;
import org.gwtmpv.place.tokenizer.Tokenizer;
import org.gwtmpv.widgets.Widgets;

import com.bizo.gwthack.client.app.AppViews;

public interface AppRegistry {

  Widgets getWidgets();

  AppViews getAppViews();

  Tokenizer getTokenizer();

  PlaceManager getPlaceManager();

  EventBus getEventBus();

  DispatchAsync getAsync();

}
