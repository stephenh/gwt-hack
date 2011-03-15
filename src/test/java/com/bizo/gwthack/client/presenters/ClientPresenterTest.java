package com.bizo.gwthack.client.presenters;

import static org.gwtmpv.testing.MpvMatchers.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.bizo.gwthack.client.model.*;
import com.bizo.gwthack.client.views.*;
import com.bizo.gwthack.shared.messages.*;
import com.bizo.gwthack.shared.model.*;
import java.util.*;
import org.junit.*;

public class ClientPresenterTest extends AbstractPresenterTest {

  private final ClientDto dto = new ClientDto();
  private final ClientModel client = new ClientModel(dto);
  private final ClientPresenter p = new ClientPresenter(registry, client);
  private StubClientView v;

  @Test
  public void fillsInFieldsOnBind() {
    dto.name = "foo";
    bind();
    assertThat(v.name().getText(), is("foo"));
    assertThat(v.nameLeft().getText(), is("47 left"));
  }

  @Test
  public void keyUpChangesNameLeft() {
    dto.name = "foo";
    bind();
    assertThat(v.name().getText(), is("foo"));
    assertThat(v.nameLeft().getText(), is("47 left"));

    v.name().press('b');
    assertThat(v.nameLeft().getText(), is("46 left"));
  }

  @Test
  public void saving() {
    dto.name = "foo";
    bind();
    v.name().type("bar");
    v.submit().click();

    // save on the server is successful
    assertThat(async.getAction(SaveClientAction.class).getClient().name, is("bar"));

    doSaveClientResult(true);
    assertThat(bus, hasPlaceRequests("clients"));
  }

  private void bind() {
    p.bind();
    v = (StubClientView) p.getView();
  }

  private void doSaveClientResult(boolean success, String... messages) {
    async.getCallback(SaveClientAction.class).onSuccess(//
      new SaveClientResult(success, new ArrayList<String>(Arrays.asList(messages))));
  }

}
