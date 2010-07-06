package com.bizo.gwthack.server.handlers;

import com.bizo.gwthack.client.messages.GetClientAction;
import com.bizo.gwthack.client.messages.GetClientResult;
import com.bizo.gwthack.server.data.Clients;
import com.bizo.gwthack.shared.model.GClientDto;

public class GetClientHandler extends AbstractHandler<GetClientAction, GetClientResult> {

  @Override
  public GetClientResult execute(final GetClientAction action) {
    final GClientDto dto = Clients.get(action.getId());
    return new GetClientResult(dto); // could be null
  }

  @Override
  public Class<GetClientAction> getActionType() {
    return GetClientAction.class;
  }

}
