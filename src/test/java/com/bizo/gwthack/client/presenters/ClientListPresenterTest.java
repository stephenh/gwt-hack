package com.bizo.gwthack.client.presenters;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.gwtmpv.widgets.StubCellTable;
import org.junit.Test;

import com.bizo.gwthack.client.model.ClientModel;
import com.bizo.gwthack.client.views.StubClientListView;
import com.bizo.gwthack.shared.messages.GetClientsAction;
import com.bizo.gwthack.shared.messages.GetClientsResult;
import com.bizo.gwthack.shared.model.ClientDto;

public class ClientListPresenterTest extends AbstractPresenterTest {

  private final ClientListPresenter p = bind(new ClientListPresenter(registry));
  private final StubClientListView v = (StubClientListView) p.getView();

  @Test
  public void twoClients() {
    p.bind();

    ArrayList<ClientDto> dtos = new ArrayList<ClientDto>();
    dtos.add(new ClientDto("1", "client a"));
    dtos.add(new ClientDto("2", "client b"));
    async.getCallback(GetClientsAction.class).onSuccess(new GetClientsResult(dtos));

    StubCellTable<ClientModel> table = (StubCellTable<ClientModel>) p.getTable();
    assertThat(table.getData().get(0).name.get(), is("client a"));
    assertThat(table.getData().get(1).name.get(), is("client b"));
  }

}
