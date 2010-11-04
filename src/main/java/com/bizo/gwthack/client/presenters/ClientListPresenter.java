package com.bizo.gwthack.client.presenters;

import static org.gwtmpv.model.Models.toModels;
import static org.gwtmpv.widgets.Widgets.newCellTable;
import static org.gwtmpv.widgets.cellview.Cells.boundProperty;
import static org.gwtmpv.widgets.cellview.Cells.newColumn;
import static org.gwtmpv.widgets.cellview.Cells.newHyperlinkCell;
import static org.gwtmpv.widgets.cellview.Cells.newTextCell;

import org.gwtmpv.GenPlace;
import org.gwtmpv.dispatch.client.SuccessCallback;
import org.gwtmpv.widgets.IsCellTable;
import org.gwtmpv.widgets.cellview.ColumnValue;
import org.gwtmpv.widgets.cellview.IsHyperlinkCell;
import org.gwtmpv.widgets.cellview.IsHyperlinkCell.Data;

import com.bizo.gwthack.client.AppRegistry;
import com.bizo.gwthack.client.model.ClientModel;
import com.bizo.gwthack.client.model.ClientModelBinding;
import com.bizo.gwthack.client.views.IsClientListView;
import com.bizo.gwthack.shared.messages.GetClientsAction;
import com.bizo.gwthack.shared.messages.GetClientsResult;

public class ClientListPresenter extends AbstractPresenter<IsClientListView> {

  private final IsCellTable<ClientModel> table = newCellTable();

  @GenPlace(value = "clients", async = false)
  public static void show(final AppRegistry registry, final AppPresenter appPresenter) {
    appPresenter.show(new ClientListPresenter(registry));
  }

  public ClientListPresenter(final AppRegistry registry) {
    super(registry.getAppViews().newClientListView(), registry);
  }

  @Override
  protected void onBind() {
    super.onBind();

    ClientModelBinding cb = new ClientModelBinding();
    table.addColumn(newColumn(boundProperty(cb.id()), newTextCell()));
    table.addColumn(newColumn(boundProperty(cb.name()), newTextCell()));
    table.addColumn(newColumn(new ClientHyperlinkValue(), newHyperlinkCell()));
    view.clientsPanel().add(table);

    async.execute(new GetClientsAction(0, 10), new OnClientsCallback());
  }

  /** Makes hyperlink data for each client row--would be nice to have this come from a place/something. */
  private class ClientHyperlinkValue extends ColumnValue<ClientModel, IsHyperlinkCell.Data> {
    public Data get(ClientModel client) {
      return new Data("#client;id=" + client.id, "view");
    }
  }

  /** We have the client data. */
  private class OnClientsCallback implements SuccessCallback<GetClientsResult> {
    public void onSuccess(final GetClientsResult result) {
      table.setRowData(0, toModels(result.getClients()));
    }
  }

  // for testing
  IsCellTable<ClientModel> getTable() {
    return table;
  }
}
