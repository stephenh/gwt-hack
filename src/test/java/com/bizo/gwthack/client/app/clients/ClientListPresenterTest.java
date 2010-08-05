package com.bizo.gwthack.client.app.clients;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.gwtmpv.widgets.StubCellTable;
import org.junit.Test;

import com.bizo.gwthack.client.app.AbstractPresenterTest;
import com.bizo.gwthack.client.messages.GetClientsAction;
import com.bizo.gwthack.client.messages.GetClientsResult;
import com.bizo.gwthack.client.model.GClientModel;
import com.bizo.gwthack.shared.model.GClientDto;

public class ClientListPresenterTest extends AbstractPresenterTest {

  private final ClientListPresenter p = new ClientListPresenter(registry);
  private final StubClientListView v = (StubClientListView) p.getView();

  @Test
  public void twoClients() {
    p.bind();

    ArrayList<GClientDto> dtos = new ArrayList<GClientDto>();
    dtos.add(new GClientDto("1", "client a"));
    dtos.add(new GClientDto("2", "client b"));
    async.getCallback(GetClientsAction.class).onSuccess(new GetClientsResult(dtos));

    StubCellTable<GClientModel> table = (StubCellTable<GClientModel>) p.getTable();
    assertThat(table.getData().get(0).name.get(), is("client a"));
    assertThat(table.getData().get(1).name.get(), is("client b"));
  }

}
