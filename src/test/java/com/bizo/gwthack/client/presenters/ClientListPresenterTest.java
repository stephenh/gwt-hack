package com.bizo.gwthack.client.presenters;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.tessell.widgets.Widgets.*;

import com.bizo.gwthack.client.model.*;
import com.bizo.gwthack.client.views.*;
import com.bizo.gwthack.shared.messages.*;
import com.bizo.gwthack.shared.model.*;
import java.util.*;
import org.junit.*;
import org.tessell.widgets.*;
import org.tessell.widgets.cellview.*;

public class ClientListPresenterTest extends AbstractPresenterTest {

  final ClientListPresenter p = bind(new ClientListPresenter(registry));
  final StubClientListView v = (StubClientListView) p.getView();
  final StubCellTable<ClientModel> table = (StubCellTable<ClientModel>) p.getTable();

  @Test
  public void twoClients() {
    newSimplePanel();

    p.bind();

    ArrayList<ClientDto> dtos = new ArrayList<ClientDto>();
    dtos.add(new ClientDto("1", "client a"));
    dtos.add(new ClientDto("2", "client b"));
    async.getCallback(GetClientsAction.class).onSuccess(new GetClientsResult(dtos));

    assertThat(table.getVisibleItem(0).name.get(), is("client a"));
    assertThat(table.getVisibleItem(1).name.get(), is("client b"));
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
