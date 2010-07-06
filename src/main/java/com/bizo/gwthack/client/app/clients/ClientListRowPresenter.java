package com.bizo.gwthack.client.app.clients;

import org.gwtmpv.place.tokenizer.Tokenizer;

import com.bizo.gwthack.client.AppRegistry;
import com.bizo.gwthack.client.app.AbstractPresenter;
import com.bizo.gwthack.client.app.client.ClientPlace;
import com.bizo.gwthack.client.model.GClientModel;

public class ClientListRowPresenter extends AbstractPresenter<IsClientListRowView> {

  private final Tokenizer tokenizer;
  private final GClientModel client;

  public ClientListRowPresenter(final AppRegistry registry, final ClientListPresenter parent, final GClientModel client) {
    super(registry.getAppViews().getClientListRowView(), registry);
    tokenizer = registry.getTokenizer();
    this.client = client;
  }

  @Override
  protected void onBind() {
    super.onBind();
    view.id().setText(client.id.get());
    view.name().setText(client.name.get());
    view.viewLink().setText("View");
    view.viewLink().setTargetHistoryToken(tokenizer.toHistoryToken(ClientPlace.request(client)));
  }
}
