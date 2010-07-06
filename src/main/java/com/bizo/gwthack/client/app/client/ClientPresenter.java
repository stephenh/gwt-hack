package com.bizo.gwthack.client.app.client;

import org.gwtmpv.model.util.Listen;
import org.gwtmpv.place.events.PlaceRequestEvent;
import org.gwtmpv.presenter.util.RevealOnCallback;

import com.bizo.gwthack.client.AppRegistry;
import com.bizo.gwthack.client.app.AbstractPresenter;
import com.bizo.gwthack.client.app.clients.ClientListPlace;
import com.bizo.gwthack.client.model.GClientModel;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ClientPresenter extends AbstractPresenter<IsClientView> {

  private final GClientModel client;

  public ClientPresenter(final AppRegistry registry, final GClientModel client) {
    super(registry.getAppViews().getClientView(), registry);
    this.client = client;
  }

  @Override
  protected void onBind() {
    super.onBind();
    client.ensureLoaded(new RevealOnCallback<GClientModel>(this));
    registerHandlers(Listen.bothWays(view.name(), client.name));
    registerHandlers(Listen.listenIntently(view.name(), client.name));
    registerHandlers(Listen.updateOnChanged(client.name.remaining(), view.nameLeft(), "{} left"));
    registerHandlers(client.saveOn(view.submit(), new OnSaveResult()));
  }

  public GClientModel getClient() {
    return client;
  }

  private class OnSaveResult implements AsyncCallback<GClientModel> {
    public void onSuccess(final GClientModel result) {
      eventBus.fireEvent(new PlaceRequestEvent(ClientListPlace.request()));
    }

    public void onFailure(final Throwable caught) {
      // do nothing? should have errors pushed to us?
    }
  }

}
