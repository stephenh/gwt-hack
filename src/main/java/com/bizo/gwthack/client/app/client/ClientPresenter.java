package com.bizo.gwthack.client.app.client;

import org.gwtmpv.model.properties.StringProperty;
import org.gwtmpv.model.values.DerivedValue;
import org.gwtmpv.place.events.PlaceRequestEvent;
import org.gwtmpv.presenter.util.RevealOnCallback;

import com.bizo.gwthack.client.AppRegistry;
import com.bizo.gwthack.client.app.AbstractPresenter;
import com.bizo.gwthack.client.app.clients.ClientListPlace;
import com.bizo.gwthack.client.model.GClientModel;
import com.bizo.gwthack.client.views.IsClientView;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ClientPresenter extends AbstractPresenter<IsClientView> {

  private final GClientModel client;
  private final StringProperty nameLeft;

  public ClientPresenter(final AppRegistry registry, final GClientModel client) {
    super(registry.getAppViews().getClientView(), registry);
    this.client = client;
    // need a better DSL here
    nameLeft = new StringProperty(new DerivedValue<String>() {
      @Override
      public String get() {
        return client.name.remaining().get() + " left";
      }
    }).depends(client.name);
  }

  @Override
  protected void onBind() {
    super.onBind();
    client.ensureLoaded(new RevealOnCallback<GClientModel>(this));
    binder.bind(client.name).to(view.name());
    binder.bind(nameLeft).toTextOf(view.nameLeft());
    binder.enhance(view.name());
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
