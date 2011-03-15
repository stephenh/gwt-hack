package com.bizo.gwthack.client.presenters;

import com.bizo.gwthack.client.*;
import org.gwtmpv.bus.*;
import org.gwtmpv.dispatch.client.util.*;
import org.gwtmpv.presenter.*;
import org.gwtmpv.widgets.*;
import org.gwtmpv.widgets.cellview.*;

public abstract class AbstractPresenterTest {

  static {
    StubWidgetsProvider.install();
    StubCellsProvider.install();
  }

  protected final StubRegistryInstance registry = new StubRegistryInstance();
  protected final StubOutstandingDispatchAsync async = registry.getAsync();
  protected final StubEventBus bus = registry.getEventBus();

  protected <P extends Presenter> P bind(P presenter) {
    presenter.bind();
    return presenter;
  }

}
