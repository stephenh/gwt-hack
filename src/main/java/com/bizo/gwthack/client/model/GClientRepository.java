package com.bizo.gwthack.client.model;

import java.util.ArrayList;

import org.gwtmpv.dispatch.client.DispatchAsync;
import org.gwtmpv.model.repository.AbstractRepository;

import com.bizo.gwthack.client.messages.GetClientAction;
import com.bizo.gwthack.client.messages.GetClientResult;
import com.bizo.gwthack.client.messages.GetClientsAction;
import com.bizo.gwthack.client.messages.GetClientsResult;
import com.bizo.gwthack.client.messages.SaveClientAction;
import com.bizo.gwthack.client.messages.SaveClientResult;
import com.bizo.gwthack.shared.model.GClientDto;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GClientRepository extends AbstractRepository<String, GClientDto, GClientModel> {

  public GClientRepository(final DispatchAsync async) {
    super(async);
  }

  public void getClient(final String id, final AsyncCallback<GClientModel> callback) {
    final GClientModel m = get(id);
    if (m.isLoaded()) {
      callback.onSuccess(m);
    } else {
      async.execute(new GetClientAction(id), new AsyncCallback<GetClientResult>() {
        @Override
        public void onSuccess(final GetClientResult result) {
          m.merge(result.getClient());
          callback.onSuccess(m);
        }

        @Override
        public void onFailure(final Throwable caught) {
          // TODO Auto-generated method stub
        }
      });
    }
  }

  public void saveClient(final GClientModel client, final AsyncCallback<SaveClientResult> callback) {
    async.execute(new SaveClientAction(client.getDto()), callback);
  }

  /** Translate the GClientDtos -> GClientModels. */
  public void getClients(final Integer start, final Integer end, final AsyncCallback<ArrayList<GClientModel>> callback) {
    async.execute(new GetClientsAction(start, end), new AsyncCallback<GetClientsResult>() {
      @Override
      public void onSuccess(final GetClientsResult result) {
        final ArrayList<GClientModel> list = new ArrayList<GClientModel>();
        for (final GClientDto dto : result.getClients()) {
          list.add(merge(dto.id, dto));
        }
        callback.onSuccess(list);
      }

      @Override
      public void onFailure(final Throwable caught) {
        callback.onFailure(caught);
      }
    });
  }

  @Override
  protected GClientModel newModel(final String id, GClientDto dto) {
    if (dto == null) {
      dto = new GClientDto();
      dto.id = id;
    } else {
      assert id.equals(dto.id);
    }
    return new GClientModel(this, dto);
  }
}
