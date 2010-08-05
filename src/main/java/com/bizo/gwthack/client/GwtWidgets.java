package com.bizo.gwthack.client;

import org.gwtmpv.widgets.GwtCellTable;
import org.gwtmpv.widgets.IsCellTable;

public class GwtWidgets implements AppWidgets {

  @Override
  public <T> IsCellTable<T> newCellTable() {
    return new GwtCellTable<T>();
  }

}
