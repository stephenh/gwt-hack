package com.bizo.gwthack.client.presenters;

import static com.bizo.gwthack.client.views.AppViews.*;
import static org.tessell.model.Models.*;
import static org.tessell.widgets.Widgets.*;
import static org.tessell.widgets.cellview.Cells.*;

import com.bizo.gwthack.client.*;
import com.bizo.gwthack.client.model.*;
import com.bizo.gwthack.client.views.*;
import com.bizo.gwthack.shared.messages.*;
import org.tessell.*;
import org.tessell.dispatch.client.*;
import org.tessell.widgets.*;
import org.tessell.widgets.cellview.*;
import org.tessell.widgets.cellview.IsHyperlinkCell.Data;

public class ClientListPresenter extends AbstractPresenter<IsClientListView> {

  private final IsCellTable<ClientModel> table = newCellTable();

  @GenPlace(name = "clients", async = false)
  public static void show(final AppRegistry registry, final AppPresenter appPresenter) {
    appPresenter.show(new ClientListPresenter(registry));
  }

  public ClientListPresenter(final AppRegistry registry) {
    super(newClientListView(), registry);
  }

  @Override
  protected void onBind() {
    super.onBind();

    ClientModelBinding cb = new ClientModelBinding();
    table.addColumn(newColumn(boundProperty(cb.id()), newTextCell()), newTextHeader("Id"));
    table.addColumn(newColumn(boundProperty(cb.name()), newTextCell()), newTextHeader("Name"));
    table.addColumn(newColumn(new ClientHyperlinkValue(), newHyperlinkCell()), newTextHeader("Actions"));
    view.clientsPanel().add(table);

    async.execute(new GetClientsAction(0, 10), new OnClientsCallback());
  }

  /** Makes hyperlink data for each client row--would be nice to have this come from a place/something. */
  private class ClientHyperlinkValue extends ColumnValue<ClientModel, IsHyperlinkCell.Data> {
    public Data get(ClientModel client) {
      return new Data("#client;id=" + client.id.get(), "view");
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
