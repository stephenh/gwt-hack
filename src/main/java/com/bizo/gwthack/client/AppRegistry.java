package com.bizo.gwthack.client;

import com.google.gwt.event.shared.*;
import org.gwtmpv.dispatch.client.util.*;
import org.gwtmpv.place.*;
import org.gwtmpv.place.tokenizer.*;

public interface AppRegistry {

  AppViews getAppViews();

  Tokenizer getTokenizer();

  PlaceManager getPlaceManager();

  EventBus getEventBus();

  OutstandingDispatchAsync getAsync();

}
