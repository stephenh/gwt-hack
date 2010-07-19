package com.bizo.gwthack.client.app.clients;

import org.gwtmpv.model.properties.StringProperty;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;

public final class StringPropertyCell implements Cell<StringProperty> {

  @Override
  public boolean consumesEvents() {
    return false;
  }

  @Override
  public boolean dependsOnSelection() {
    return false;
  }

  @Override
  public Object onBrowserEvent(Element parent, StringProperty value, Object viewData, NativeEvent event, ValueUpdater<StringProperty> valueUpdater) {
    return null;
  }

  @Override
  public void render(StringProperty value, Object viewData, StringBuilder sb) {
    sb.append(value.get());
  }

  @Override
  public void setValue(Element parent, StringProperty value, Object viewData) {
  }

}
