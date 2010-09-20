package com.bizo.gwthack.client.app.clients;

import java.util.ArrayList;

import org.gwtmpv.model.properties.StringProperty;
import org.gwtmpv.presenter.BasicPresenter;
import org.gwtmpv.widgets.IsCellTable;
import org.gwtmpv.widgets.cellview.BoundColumn;

import com.bizo.gwthack.client.AppRegistry;
import com.bizo.gwthack.client.model.GClientModel;
import com.bizo.gwthack.client.model.GClientModelBinding;
import com.bizo.gwthack.client.model.GClientRepository;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ClientListPresenter extends BasicPresenter<IsClientListView> {

  private final AppRegistry registry;
  private final GClientRepository repository;
  private int lastColumn;
  private boolean lastAsc;
  private IsCellTable<GClientModel> table;

  public ClientListPresenter(final AppRegistry registry) {
    super(registry.getAppViews().getClientListView(), registry.getEventBus());
    this.registry = registry;
    repository = registry.getRepository();
  }

  @Override
  protected void onBind() {
    super.onBind();

    GClientModelBinding cb = new GClientModelBinding();
    table = registry.getAppWidgets().newCellTable();
    table.addColumn(BoundColumn.ofStringProperty(cb.id()));
    table.addColumn(BoundColumn.ofStringProperty(cb.name()));
    table.addColumn(BoundColumn.of(cb.id(), new AbstractCell<StringProperty>() {
      @Override
      public void render(StringProperty value, Object viewData, SafeHtmlBuilder sb) {
        sb.appendHtmlConstant("<a href=\"#client;id=" + value.get() + "\">view</a>");
      }
    }));
    view.clientsPanel().add(table);

    repository.getClients(0, 10, new OnClientsCallback());
  }

  private class OnClientsCallback implements AsyncCallback<ArrayList<GClientModel>> {
    public void onSuccess(final ArrayList<GClientModel> clients) {
      table.setRowData(0, clients);
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

  // for testing
  IsCellTable<GClientModel> getTable() {
    return table;
  }
}
