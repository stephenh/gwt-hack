package com.bizo.gwthack.client.app.clients;

import com.bizo.gwthack.client.AppRegistry;
import com.bizo.gwthack.client.app.AbstractPresenter;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class ClientListHeaderPresenter extends AbstractPresenter<IsClientListHeaderView> {

  private final ClientListPresenter parent;

  public ClientListHeaderPresenter(final AppRegistry registry, final ClientListPresenter parent) {
    super(registry.getAppViews().getClientListHeaderView(), registry);
    this.parent = parent;
  }

  @Override
  protected void onBind() {
    super.onBind();
    registerHandler(view.id().addClickHandler(new OnSortCallback(0)));
    registerHandler(view.name().addClickHandler(new OnSortCallback(1)));
  }

  private class OnSortCallback implements ClickHandler {
    private final int columnIndex;

    public OnSortCallback(final int columnIndex) {
      this.columnIndex = columnIndex;
    }

    public void onClick(final ClickEvent event) {
      parent.sort(columnIndex);
    }
  }

}
