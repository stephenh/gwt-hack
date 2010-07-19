package com.bizo.gwthack.client.widgets;

import org.gwtmpv.widgets.GwtElement;
import org.gwtmpv.widgets.IsElement;
import org.gwtmpv.widgets.IsStyle;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Widget;

public class GwtCellTable<T> extends CellTable<T> implements IsCellTable<T> {

  @Override
  public Widget asWidget() {
    return this;
  }

  @Override
  public IsElement getIsElement() {
    return new GwtElement(getElement());
  }

  @Override
  public IsStyle getStyle() {
    return getIsElement().getStyle();
  }

}
