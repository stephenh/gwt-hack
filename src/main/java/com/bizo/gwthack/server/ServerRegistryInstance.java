package com.bizo.gwthack.server;

import org.gwtmpv.dispatch.server.ActionDispatch;
import org.gwtmpv.dispatch.server.DefaultActionDispatch;

import com.bizo.gwthack.server.handlers.GetClientHandler;
import com.bizo.gwthack.server.handlers.GetClientsHandler;
import com.bizo.gwthack.server.handlers.SaveClientHandler;

public class ServerRegistryInstance implements ServerRegistry {

  private final DefaultActionDispatch dispatch;

  public ServerRegistryInstance() {
    dispatch = new DefaultActionDispatch();
    dispatch.addHandler(new GetClientHandler());
    dispatch.addHandler(new GetClientsHandler());
    dispatch.addHandler(new SaveClientHandler());
  }

  public ActionDispatch getDispatch() {
    return dispatch;
  }

}
