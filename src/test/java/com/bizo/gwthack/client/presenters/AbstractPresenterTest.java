package com.bizo.gwthack.client.presenters;

import com.bizo.gwthack.client.*;
import org.tessell.bus.*;
import org.tessell.dispatch.client.util.*;
import org.tessell.presenter.*;
import org.tessell.widgets.*;
import org.tessell.widgets.cellview.*;

public abstract class AbstractPresenterTest {

  static {
    StubWidgetsProvider.install();
    StubCellsProvider.install();
    StubGWTBridge.install();
  }

  protected final StubRegistryInstance registry = new StubRegistryInstance();
  protected final StubOutstandingDispatchAsync async = registry.getAsync();
  protected final StubEventBus bus = registry.getEventBus();

  protected <P extends Presenter> P bind(P presenter) {
    presenter.bind();
    return presenter;
  }

}
