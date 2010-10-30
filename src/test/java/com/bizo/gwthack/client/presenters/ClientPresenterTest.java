package com.bizo.gwthack.client.presenters;

import static org.gwtmpv.testing.MpvMatchers.hasPlaceRequests;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.bizo.gwthack.client.messages.SaveClientAction;
import com.bizo.gwthack.client.messages.SaveClientResult;
import com.bizo.gwthack.client.model.ClientModel;
import com.bizo.gwthack.client.views.StubClientView;
import com.bizo.gwthack.shared.model.ClientDto;

public class ClientPresenterTest extends AbstractPresenterTest {

  private final ClientDto dto = new ClientDto();
  private final ClientModel client = new ClientModel(dto);
  private final ClientPresenter p = new ClientPresenter(registry, client);
  private StubClientView v;

  @Test
  public void fillsInFieldsOnBind() {
    dto.name = "foo";
    bind();
    assertThat(v.name.getText(), is("foo"));
    assertThat(v.nameLeft.getText(), is("47 left"));
  }

  @Test
  public void keyUpChangesNameLeft() {
    dto.name = "foo";
    bind();
    assertThat(v.name.getText(), is("foo"));
    assertThat(v.nameLeft.getText(), is("47 left"));

    v.name.press('b');
    assertThat(v.nameLeft.getText(), is("46 left"));
  }

  @Test
  public void saving() {
    dto.name = "foo";
    bind();
    v.name.type("bar");
    v.submit.click();

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
