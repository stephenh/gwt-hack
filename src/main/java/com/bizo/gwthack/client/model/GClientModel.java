package com.bizo.gwthack.client.model;

import static org.gwtmpv.model.properties.NewProperty.stringProperty;

import org.gwtmpv.model.AbstractModel;
import org.gwtmpv.model.properties.StringProperty;

import com.bizo.gwthack.client.messages.SaveClientResult;
import com.bizo.gwthack.shared.model.GClientDto;
import com.bizo.gwthack.shared.model.GClientDtoBinding;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;

/** Fun model stuff around the {@link GClientDto}. */
public class GClientModel extends AbstractModel<GClientDto> {

  private final GClientRepository repo;
  private final GClientDtoBinding b = new GClientDtoBinding();
  public final StringProperty id = stringProperty(b.id());
  public final StringProperty name = stringProperty(b.name()).max(50);
  private boolean loaded;

  /** Made by the {@link GClientRepository}. */
  GClientModel(final GClientRepository repo, final GClientDto dto) {
    this.repo = repo;
    b.set(dto);
  }

  /** If we were created with just an id, fills in the data then calls the callback. */
  public void ensureLoaded(final AsyncCallback<GClientModel> callback) {
    if (loaded) {
      callback.onSuccess(this);
    } else {
      repo.getClient(getDto().id, callback);
    }
  }

  /** Called by the {@link GClientRepository}. */
  @Override
  public void merge(final GClientDto dto) {
    loaded = true; // preset so we can use Property.set
    id.set(dto.id);
    name.set(dto.name);
  }

  /** Called by the {@link GClientRepository}. */
  GClientDto getDto() {
    return b.get();
  }

  public HandlerRegistration saveOn(final HasClickHandlers hasClick, final AsyncCallback<GClientModel> callback) {
    return hasClick.addClickHandler(new ClickHandler() {
      public void onClick(final ClickEvent event) {
        repo.saveClient(GClientModel.this, new OnSaveResult(callback));
      }
    });
  }

  private class OnSaveResult implements AsyncCallback<SaveClientResult> {
    private final AsyncCallback<GClientModel> other;

    public OnSaveResult(final AsyncCallback<GClientModel> other) {
      this.other = other;
    }

    @Override
    public void onSuccess(final SaveClientResult result) {
      other.onSuccess(GClientModel.this); // watch for messages
    }

    @Override
    public void onFailure(final Throwable caught) {
      other.onFailure(caught);
    }
  }

  public boolean isLoaded() {
    return loaded;
  }
}
