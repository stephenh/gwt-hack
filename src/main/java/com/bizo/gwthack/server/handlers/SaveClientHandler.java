package com.bizo.gwthack.server.handlers;

import java.util.ArrayList;

import com.bizo.gwthack.client.messages.SaveClientAction;
import com.bizo.gwthack.client.messages.SaveClientResult;
import com.bizo.gwthack.server.data.Clients;
import com.bizo.gwthack.shared.model.GClientDto;

public class SaveClientHandler extends AbstractHandler<SaveClientAction, SaveClientResult> {

  @Override
  public SaveClientResult execute(final SaveClientAction action) {
    final GClientDto ours = Clients.get(action.getClient().id);
    ours.name = action.getClient().name;
    return new SaveClientResult(new ArrayList<String>());
  }

  @Override
  public Class<SaveClientAction> getActionType() {
    return SaveClientAction.class;
  }

}
