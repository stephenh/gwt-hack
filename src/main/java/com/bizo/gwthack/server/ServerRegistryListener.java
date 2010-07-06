package com.bizo.gwthack.server;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServerRegistryListener implements ServletContextListener {

  private ServerRegistry registry;

  public static ServerRegistry getOrFail(final ServletContext context) {
    final ServerRegistry registry = (ServerRegistry) context.getAttribute("registry");
    if (registry == null) {
      throw new IllegalStateException("Registry is not available");
    }
    return registry;
  }

  @Override
  public void contextInitialized(final ServletContextEvent sce) {
    registry = new ServerRegistryInstance();
    sce.getServletContext().setAttribute("registry", registry);
  }

  @Override
  public void contextDestroyed(final ServletContextEvent sce) {
  }

}
