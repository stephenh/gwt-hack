package com.bizo.gwthack.client.presenters;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.gwtmpv.place.events.PlaceRequestEvent;
import org.junit.Test;

import com.bizo.gwthack.client.messages.GetClientAction;
import com.bizo.gwthack.client.messages.GetClientResult;
import com.bizo.gwthack.client.messages.SaveClientAction;
import com.bizo.gwthack.client.messages.SaveClientResult;
import com.bizo.gwthack.client.model.ClientModel;
import com.bizo.gwthack.client.presenters.ClientPresenter;
import com.bizo.gwthack.client.views.StubClientView;
import com.bizo.gwthack.shared.model.ClientDto;

public class ClientPresenterTest extends AbstractPresenterTest {

  private final ClientDto dto = new ClientDto();
  private final ClientModel client = new ClientModel(dto);
  private final ClientPresenter p = new ClientPresenter(registry, client);
  private final StubClientView v = (StubClientView) p.getView();

  @Test
  public void fillsInFieldsOnBind() {
    dto.name = "foo";
    p.bind();
    assertThat(v.name.getText(), is("foo"));
    assertThat(v.nameLeft.getText(), is("47 left"));
  }

  @Test
  public void keyUpChangesNameLeft() {
    dto.name = "foo";
    p.bind();
    assertThat(v.name.getText(), is("foo"));
    assertThat(v.nameLeft.getText(), is("47 left"));

    v.name.press('b');
    assertThat(v.nameLeft.getText(), is("46 left"));
  }

  @Test
  public void saving() {
    dto.name = "foo";
    p.bind();
    v.name.type("bar");
    v.submit.click();

    // this should have been needed for the other tests too...
    async.getCallback(GetClientAction.class).onSuccess(new GetClientResult(dto));

    // save on the server is successful
    assertThat(async.getAction(SaveClientAction.class).getClient().name, is("bar"));
    async.getCallback(SaveClientAction.class).onSuccess(new SaveClientResult(new ArrayList<String>()));

    assertThat(bus.getEvents(PlaceRequestEvent.class).size(), is(1));
    assertThat(bus.getEvent(PlaceRequestEvent.class, 0).getRequest().getName(), is("clients"));
  }

}
