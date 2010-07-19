package com.bizo.gwthack.client.widgets;

import java.util.List;

import org.gwtmpv.widgets.IsWidget;

import com.google.gwt.user.cellview.client.Column;

public interface IsCellTable<T> extends IsWidget {

  void addColumn(Column<T, ?> col);

  void setData(int start, int length, List<T> values);

}
