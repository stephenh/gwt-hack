package com.bizo.gwthack.client.model;

import static org.tessell.model.properties.NewProperty.*;

import com.bizo.gwthack.shared.model.*;
import org.tessell.model.*;
import org.tessell.model.properties.*;

/** Fun model stuff around the {@link ClientDto}. */
public class ClientModel extends AbstractModel<ClientDto> {

  private final ClientDtoBinding b = new ClientDtoBinding();
  public final StringProperty id = stringProperty(b.id());
  public final StringProperty name = stringProperty(b.name()).max(50);

  /** Made by the {@link GClientRepository}. */
  public ClientModel(final ClientDto dto) {
    b.set(dto);
  }

  /** Called by the {@link GClientRepository}. */
  @Override
  public void merge(final ClientDto dto) {
    id.set(dto.id);
    name.set(dto.name);
  }

  public ClientDto getDto() {
    return b.get();
  }

}
