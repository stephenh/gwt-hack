package com.bizo.gwthack.client.widgets;

import java.util.ArrayList;
import java.util.List;

import org.gwtmpv.widgets.StubWidget;

import com.google.gwt.user.cellview.client.Column;

public class StubCellTable<T> extends StubWidget implements IsCellTable<T> {

  private final List<Column<T, ?>> columns = new ArrayList<Column<T, ?>>();
  private final List<T> data = new ArrayList<T>();

  @Override
  public void addColumn(Column<T, ?> col) {
    columns.add(col);
  }

  @Override
  public void setData(int start, int length, List<T> values) {
    for (int i = 0; i < length; i++) {
      data.add(start + i, values.get(i));
    }
  }

  public List<T> getData() {
    return data;
  }

}
