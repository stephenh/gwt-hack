package com.bizo.gwthack.client.presenters;

import java.util.ArrayList;

import org.gwtmpv.GenPlace;
import org.gwtmpv.model.Dto;
import org.gwtmpv.model.Model;
import org.gwtmpv.model.properties.StringProperty;
import org.gwtmpv.widgets.IsCellTable;
import org.gwtmpv.widgets.cellview.BoundColumn;

import com.bizo.gwthack.client.AppRegistry;
import com.bizo.gwthack.client.messages.GetClientsAction;
import com.bizo.gwthack.client.messages.GetClientsResult;
import com.bizo.gwthack.client.model.GClientModel;
import com.bizo.gwthack.client.model.GClientModelBinding;
import com.bizo.gwthack.client.views.IsClientListView;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ClientListPresenter extends AbstractPresenter<IsClientListView> {

  private int lastColumn;
  private boolean lastAsc;
  private IsCellTable<GClientModel> table;

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

    async.execute(new GetClientsAction(0, 10), new OnClientsCallback());
  }

  private static <M extends Model<D>, D extends Dto<M>> ArrayList<M> toModels(ArrayList<D> dtos) {
    ArrayList<M> models = new ArrayList<M>();
    for (D dto : dtos) {
      models.add(dto.toModel());
    }
    return models;
  }

  private class OnClientsCallback implements AsyncCallback<GetClientsResult> {
    public void onSuccess(final GetClientsResult result) {
      table.setRowData(0, toModels(result.getClients()));
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
