package com.bizo.gwthack.client.app.clients;

import java.util.ArrayList;

import org.gwtmpv.presenter.BasicPresenter;

import com.bizo.gwthack.client.AppRegistry;
import com.bizo.gwthack.client.model.GClientModel;
import com.bizo.gwthack.client.model.GClientRepository;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ClientListPresenter extends BasicPresenter<IsClientListView> {

  private final AppRegistry registry;
  private final GClientRepository repository;
  private int lastColumn;
  private boolean lastAsc;

  public ClientListPresenter(final AppRegistry registry) {
    super(registry.getAppViews().getClientListView(), registry.getEventBus());
    this.registry = registry;
    repository = registry.getRepository();
  }

  @Override
  protected void onBind() {
    super.onBind();

    view.clients().addHeader(addPresenter(new ClientListHeaderPresenter(registry, this)).getView());
    repository.getClients(0, 10, new OnClientsCallback());
  }

  private class OnClientsCallback implements AsyncCallback<ArrayList<GClientModel>> {
    public void onSuccess(final ArrayList<GClientModel> clients) {
      for (final GClientModel client : clients) {
        view.clients().addRow(
            addPresenter(new ClientListRowPresenter(registry, ClientListPresenter.this, client)).getView());
      }
      revealDisplay();
    }

    @Override
    public void onFailure(final Throwable caught) {
      caught.printStackTrace();
    }
  }

  public void sort(final int column) {
    final boolean asc = column != lastColumn || !lastAsc;
    // view.sort(column, asc);
    lastColumn = column;
    lastAsc = asc;
  }

}
