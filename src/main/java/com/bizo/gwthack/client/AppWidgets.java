package com.bizo.gwthack.client;

import com.bizo.gwthack.client.widgets.IsCellTable;

public interface AppWidgets {

  <T> IsCellTable<T> newCellTable();

}
