package com.bizo.gwthack.client;

import org.gwtmpv.widgets.IsCellTable;
import org.gwtmpv.widgets.StubCellTable;

public class StubWidgets implements AppWidgets {

  @Override
  public <T> IsCellTable<T> newCellTable() {
    return new StubCellTable<T>();
  }

}
