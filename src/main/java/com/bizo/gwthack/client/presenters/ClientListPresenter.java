package com.bizo.gwthack.client.presenters;

import static org.gwtmpv.model.Models.toModels;
import static org.gwtmpv.widgets.Widgets.newCellTable;

import org.gwtmpv.GenPlace;
import org.gwtmpv.dispatch.client.SuccessCallback;
import org.gwtmpv.model.properties.StringProperty;
import org.gwtmpv.widgets.IsCellTable;
import org.gwtmpv.widgets.cellview.BoundColumn;

import com.bizo.gwthack.client.AppRegistry;
import com.bizo.gwthack.client.model.ClientModel;
import com.bizo.gwthack.client.model.ClientModelBinding;
import com.bizo.gwthack.client.views.IsClientListView;
import com.bizo.gwthack.shared.messages.GetClientsAction;
import com.bizo.gwthack.shared.messages.GetClientsResult;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

public class ClientListPresenter extends AbstractPresenter<IsClientListView> {

  private int lastColumn;
  private boolean lastAsc;
  private IsCellTable<ClientModel> table;

  @GenPlace(value = "clients", async = false)
  public static void show(final AppRegistry registry, final AppPresenter appPresenter) {
    appPresenter.show(new ClientListPresenter(registry));
  }

  public ClientListPresenter(final AppRegistry registry) {
    super(registry.getAppViews().getClientListView(), registry);
  }

  @Override
  protected void onBind() {
    super.onBind();

    ClientModelBinding cb = new ClientModelBinding();
    table = newCellTable();
    table.addColumn(BoundColumn.ofStringProperty(cb.id()));
    table.addColumn(BoundColumn.ofStringProperty(cb.name()));
    table.addColumn(BoundColumn.of(cb.id(), new AbstractCell<StringProperty>() {
      @Override
      public void render(StringProperty value, Object viewData, SafeHtmlBuilder sb) {
        sb.appendHtmlConstant("<a href=\"#client;id=" + value.get() + "\">view</a>");
      }
    }));
    view.clientsPanel().add(table);

    async.execute(new GetClientsAction(0, 10), new OnClientsCallback());
  }

  private class OnClientsCallback implements SuccessCallback<GetClientsResult> {
    public void onSuccess(final GetClientsResult result) {
      table.setRowData(0, toModels(result.getClients()));
    }
  }

  public void sort(final int column) {
    final boolean asc = column != lastColumn || !lastAsc;
    // view.sort(column, asc);
    lastColumn = column;
    lastAsc = asc;
  }

  // for testing
  IsCellTable<ClientModel> getTable() {
    return table;
  }
}
