package com.bizo.gwthack.server;

import com.bizo.gwthack.server.handlers.*;
import org.gwtmpv.dispatch.server.*;

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
