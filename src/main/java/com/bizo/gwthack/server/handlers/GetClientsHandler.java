package com.bizo.gwthack.server.handlers;

import com.bizo.gwthack.server.data.*;
import com.bizo.gwthack.shared.messages.*;
import com.bizo.gwthack.shared.model.*;
import java.util.*;

public class GetClientsHandler extends AbstractHandler<GetClientsAction, GetClientsResult> {

  @Override
  public GetClientsResult execute(final GetClientsAction arg0) {
    final ArrayList<ClientDto> clients = new ArrayList<ClientDto>();
    for (int i = arg0.getStart(); i < arg0.getEnd(); i++) {
      clients.add(Clients.get().get(i));
    }
    return new GetClientsResult(clients);
  }

  @Override
  public Class<GetClientsAction> getActionType() {
    return GetClientsAction.class;
  }

}
