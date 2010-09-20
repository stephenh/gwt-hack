package com.bizo.gwthack.client.app.clients;

import org.gwtmpv.model.properties.StringProperty;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

public final class StringPropertyCell extends AbstractCell<StringProperty> {

  @Override
  public void render(StringProperty value, Object viewData, SafeHtmlBuilder sb) {
    sb.appendEscaped(value.get());
  }

}
