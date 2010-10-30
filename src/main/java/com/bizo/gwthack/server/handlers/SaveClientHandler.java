package com.bizo.gwthack.server.handlers;

import java.util.ArrayList;

import com.bizo.gwthack.server.data.Clients;
import com.bizo.gwthack.shared.messages.SaveClientAction;
import com.bizo.gwthack.shared.messages.SaveClientResult;
import com.bizo.gwthack.shared.model.ClientDto;

public class SaveClientHandler extends AbstractHandler<SaveClientAction, SaveClientResult> {

  @Override
  public SaveClientResult execute(final SaveClientAction action) {
    final ClientDto ours = Clients.get(action.getClient().id);
    ours.name = action.getClient().name;
    return new SaveClientResult(true, new ArrayList<String>());
  }

  @Override
  public Class<SaveClientAction> getActionType() {
    return SaveClientAction.class;
  }

}
