package com.bizo.gwthack.client.presenters;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.gwtmpv.widgets.StubCellTable;
import org.gwtmpv.widgets.cellview.StubHyperlinkCell;
import org.junit.Test;

import com.bizo.gwthack.client.model.ClientModel;
import com.bizo.gwthack.client.views.StubClientListView;
import com.bizo.gwthack.shared.messages.GetClientsAction;
import com.bizo.gwthack.shared.messages.GetClientsResult;
import com.bizo.gwthack.shared.model.ClientDto;

public class ClientListPresenterTest extends AbstractPresenterTest {

  final ClientListPresenter p = bind(new ClientListPresenter(registry));
  final StubClientListView v = (StubClientListView) p.getView();
  final StubCellTable<ClientModel> table = (StubCellTable<ClientModel>) p.getTable();

  @Test
  public void twoClients() {
    p.bind();

    ArrayList<ClientDto> dtos = new ArrayList<ClientDto>();
    dtos.add(new ClientDto("1", "client a"));
    dtos.add(new ClientDto("2", "client b"));
    async.getCallback(GetClientsAction.class).onSuccess(new GetClientsResult(dtos));

    assertThat(table.getData().get(0).name.get(), is("client a"));
    assertThat(table.getData().get(1).name.get(), is("client b"));
  }

  @Test
  public void hyperlinkIsCorrect() {
    p.bind();

    ArrayList<ClientDto> dtos = new ArrayList<ClientDto>();
    dtos.add(new ClientDto("1", "client a"));
    dtos.add(new ClientDto("2", "client b"));
    async.getCallback(GetClientsAction.class).onSuccess(new GetClientsResult(dtos));

    assertThat(hyperlinkCell().getValue(0).href, is("#client;id=1"));
    assertThat(hyperlinkCell().getValue(0).content, is("view"));
  }

  private StubHyperlinkCell hyperlinkCell() {
    return (StubHyperlinkCell) table.getColumn(2).getCell();
  }

}
