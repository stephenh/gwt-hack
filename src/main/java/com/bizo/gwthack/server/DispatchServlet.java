package com.bizo.gwthack.server;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.gwtmpv.dispatch.server.ActionDispatch;
import org.gwtmpv.dispatch.server.ExecutionContext;
import org.gwtmpv.dispatch.server.SessionIdValidator;
import org.gwtmpv.dispatch.server.servlet.AbstractDispatchServiceServlet;

/** Just a wrapper for the Dispatcher servlet in order to log received actions. */
public class DispatchServlet extends AbstractDispatchServiceServlet {

  private static final long serialVersionUID = 1L;
  private ActionDispatch dispatch;

  @Override
  public void init(final ServletConfig config) throws ServletException {
    super.init(config);
    dispatch = ServerRegistryListener.getOrFail(config.getServletContext()).getDispatch();
  }

  @Override
  protected ActionDispatch getActionDispatch() {
    return dispatch;
  }

  @Override
  protected SessionIdValidator getSessionValidator() {
    return new SessionIdValidator() {
      @Override
      public String get(final ExecutionContext context) {
        return null;
      }
    };
  }

}
