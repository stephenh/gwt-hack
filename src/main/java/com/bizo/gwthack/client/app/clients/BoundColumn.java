package com.bizo.gwthack.client.app.clients;

import org.bindgen.BindingRoot;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.user.cellview.client.Column;

public final class BoundColumn<R, P> extends Column<R, P> {

  private final BindingRoot<R, P> binding;

  public static <R, P> BoundColumn<R, P> of(BindingRoot<R, P> binding, Cell<P> cell) {
    return new BoundColumn<R, P>(binding, cell);
  }

  public BoundColumn(BindingRoot<R, P> binding, Cell<P> cell) {
    super(cell);
    this.binding = binding;
  }

  @Override
  public P getValue(R object) {
    return binding.getWithRoot(object);
  }

}
