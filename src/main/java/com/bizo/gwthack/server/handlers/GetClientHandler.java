package com.bizo.gwthack.server.handlers;

import com.bizo.gwthack.server.data.*;
import com.bizo.gwthack.shared.messages.*;
import com.bizo.gwthack.shared.model.*;

public class GetClientHandler extends AbstractHandler<GetClientAction, GetClientResult> {

  @Override
  public GetClientResult execute(final GetClientAction action) {
    final ClientDto dto = Clients.get(action.getId());
    return new GetClientResult(dto); // could be null
  }

  @Override
  public Class<GetClientAction> getActionType() {
    return GetClientAction.class;
  }

}
