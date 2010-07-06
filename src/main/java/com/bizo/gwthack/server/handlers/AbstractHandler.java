package com.bizo.gwthack.server.handlers;

import org.gwtmpv.dispatch.server.ExecutionContext;
import org.gwtmpv.dispatch.server.handlers.ActionHandler;
import org.gwtmpv.dispatch.shared.Action;
import org.gwtmpv.dispatch.shared.Result;

/** Basic implementation of {@link ActionHandler}. */
public abstract class AbstractHandler<A extends Action<R>, R extends Result> implements ActionHandler<A, R> {

  /** A simpler method for subclasses that don't use {@link ExecutionContext}. */
  public abstract R execute(A action);

  @Override
  public R execute(final A action, final ExecutionContext context) {
    return execute(action);
  }

}
