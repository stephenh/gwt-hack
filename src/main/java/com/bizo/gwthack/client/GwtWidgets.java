package com.bizo.gwthack.client;

import com.bizo.gwthack.client.widgets.GwtCellTable;
import com.bizo.gwthack.client.widgets.IsCellTable;

public class GwtWidgets implements AppWidgets {

  @Override
  public <T> IsCellTable<T> newCellTable() {
    return new GwtCellTable<T>();
  }

}
