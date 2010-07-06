package com.bizo.gwthack.client.app.client;

import org.gwtmpv.place.PlaceRequest;
import org.gwtmpv.place.PlaceRequestFactory;
import org.gwtmpv.place.tokenizer.Tokenizer;
import org.gwtmpv.presenter.util.RevealOnCallback;

import com.bizo.gwthack.client.AppRegistry;
import com.bizo.gwthack.client.app.AbstractPlace;
import com.bizo.gwthack.client.app.AppPresenter;
import com.bizo.gwthack.client.model.GClientModel;

public class ClientPlace extends AbstractPlace<ClientPresenter> {

  private static final String name = "client";
  private final AppPresenter appPresenter;

  public static PlaceRequest request(final GClientModel client) {
    return new PlaceRequest(name).with("id", client.id.get());
  }

  public ClientPlace(final AppRegistry registry, final AppPresenter appPresenter) {
    super(registry, name);
    this.appPresenter = appPresenter;
  }

  @Override
  protected PlaceRequest prepareRequest(final PlaceRequest request, final ClientPresenter clientPresenter) {
    return request.with("id", clientPresenter.getClient().id.get());
  }

  @Override
  public void handleRequest(final PlaceRequest request) {
    final String id = request.getParameter("id", null);
    final GClientModel client = registry.getRepository().get(id);

    currentPresenter = new ClientPresenter(registry, client);
    appPresenter.show(currentPresenter);
    // should we display a white page until this comes back?
    registry.getRepository().getClient(id, new RevealOnCallback<GClientModel>(currentPresenter));
  }

  public static class ClientPlaceRequestFactory implements PlaceRequestFactory<GClientModel> {
    private final Tokenizer tokenizer;

    public ClientPlaceRequestFactory(final Tokenizer tokenizer) {
      this.tokenizer = tokenizer;
    }

    public String make(final GClientModel m) {
      return tokenizer.toHistoryToken(request(m));
    }
  }

}
