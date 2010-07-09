package com.bizo.gwthack.client.app.client;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.bizo.gwthack.client.TestRegistryInstance;
import com.bizo.gwthack.client.model.GClientModel;
import com.bizo.gwthack.shared.model.GClientDto;

public class ClientPresenterTest {

  private final TestRegistryInstance registry = new TestRegistryInstance();
  private final GClientDto dto = new GClientDto();
  private final GClientModel client = new GClientModel(registry.getRepository(), dto);
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

}
