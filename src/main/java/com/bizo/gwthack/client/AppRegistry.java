package com.bizo.gwthack.client;

import com.bizo.gwthack.client.resources.*;
import com.google.web.bindery.event.shared.*;
import org.tessell.dispatch.client.util.*;
import org.tessell.place.*;
import org.tessell.place.tokenizer.*;

public interface AppRegistry {

  AppResources getAppResources();

  Tokenizer getTokenizer();

  PlaceManager getPlaceManager();

  EventBus getEventBus();

  OutstandingDispatchAsync getAsync();

}
