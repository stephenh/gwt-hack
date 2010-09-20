package com.bizo.gwthack.client.model;

import static org.gwtmpv.model.properties.NewProperty.stringProperty;

import org.bindgen.Bindable;
import org.gwtmpv.model.AbstractModel;
import org.gwtmpv.model.properties.StringProperty;

import com.bizo.gwthack.shared.model.GClientDto;
import com.bizo.gwthack.shared.model.GClientDtoBinding;

/** Fun model stuff around the {@link GClientDto}. */
@Bindable
public class GClientModel extends AbstractModel<GClientDto> {

  private final GClientDtoBinding b = new GClientDtoBinding();
  public final StringProperty id = stringProperty(b.id());
  public final StringProperty name = stringProperty(b.name()).max(50);

  /** Made by the {@link GClientRepository}. */
  public GClientModel(final GClientDto dto) {
    b.set(dto);
  }

  /** Called by the {@link GClientRepository}. */
  @Override
  public void merge(final GClientDto dto) {
    id.set(dto.id);
    name.set(dto.name);
  }

  public GClientDto getDto() {
    return b.get();
  }

}
