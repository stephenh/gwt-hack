package com.bizo.gwthack.server.handlers;

import org.gwtmpv.dispatch.server.*;
import org.gwtmpv.dispatch.server.handlers.*;
import org.gwtmpv.dispatch.shared.*;

/** Basic implementation of {@link ActionHandler}. */
public abstract class AbstractHandler<A extends Action<R>, R extends Result> implements ActionHandler<A, R> {

  /** A simpler method for subclasses that don't use {@link ExecutionContext}. */
  public abstract R execute(A action);

  @Override
  public R execute(final A action, final ExecutionContext context) {
    return execute(action);
  }

}
