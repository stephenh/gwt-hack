package com.bizo.gwthack.client;

import com.bizo.gwthack.client.resources.*;
import com.google.web.bindery.event.shared.*;
import org.gwtmpv.dispatch.client.util.*;
import org.gwtmpv.place.*;
import org.gwtmpv.place.tokenizer.*;

public interface AppRegistry {

  AppResources getAppResources();

  Tokenizer getTokenizer();

  PlaceManager getPlaceManager();

  EventBus getEventBus();

  OutstandingDispatchAsync getAsync();

}
