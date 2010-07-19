package com.bizo.gwthack.client;

import com.bizo.gwthack.client.widgets.IsCellTable;
import com.bizo.gwthack.client.widgets.StubCellTable;

public class StubWidgets implements AppWidgets {

  @Override
  public <T> IsCellTable<T> newCellTable() {
    return new StubCellTable<T>();
  }

}
