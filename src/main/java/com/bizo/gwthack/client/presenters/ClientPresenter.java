package com.bizo.gwthack.client.presenters;

import org.gwtmpv.GenPlace;
import org.gwtmpv.dispatch.client.SuccessCallback;
import org.gwtmpv.model.commands.DispatchUiCommand;
import org.gwtmpv.model.commands.UiCommand;
import org.gwtmpv.model.properties.IntegerProperty;
import org.gwtmpv.model.properties.StringProperty;
import org.gwtmpv.model.values.DerivedValue;
import org.gwtmpv.place.PlaceRequest;

import com.bizo.gwthack.client.AppRegistry;
import com.bizo.gwthack.client.messages.GetClientAction;
import com.bizo.gwthack.client.messages.GetClientResult;
import com.bizo.gwthack.client.messages.SaveClientAction;
import com.bizo.gwthack.client.messages.SaveClientResult;
import com.bizo.gwthack.client.model.ClientModel;
import com.bizo.gwthack.client.views.IsClientView;

public class ClientPresenter extends AbstractPresenter<IsClientView> {

  private final ClientModel client;
  private final StringProperty nameLeft;

  @GenPlace(value = "client", async = false)
  public static void show(final AppRegistry registry, final AppPresenter app, PlaceRequest request) {
    final String id = request.getParameter("id", null);
    registry.getAsync().execute(new GetClientAction(id), new SuccessCallback<GetClientResult>() {
      public void onSuccess(GetClientResult result) {
        app.show(new ClientPresenter(registry, new ClientModel(result.getClient())));
      }
    });
  }

  public ClientPresenter(final AppRegistry registry, final ClientModel client) {
    super(registry.getAppViews().getClientView(), registry);
    this.client = client;
    nameLeft = makeNameLeft();
  }

  @Override
  protected void onBind() {
    super.onBind();
    binder.bind(client.name).to(view.name());
    binder.bind(nameLeft).toTextOf(view.nameLeft());
    binder.bind(saveCommand).to(view.submit());
    binder.enhance(view.name());
  }

  /** Saves the client and returns to the client list. */
  private final UiCommand saveCommand = new DispatchUiCommand<SaveClientAction, SaveClientResult>(async) {
    protected SaveClientAction createAction() {
      return new SaveClientAction(client.getDto());
    }

    protected void onResult(SaveClientResult result) {
      goTo(ClientListPlace.newRequest());
    }
  };

  /** @return a new property that says "X left" and updates when name changes. */
  private StringProperty makeNameLeft() {
    final IntegerProperty remaining = client.name.remaining();
    return new StringProperty(new DerivedValue<String>() {
      public String get() {
        return remaining.get() + " left";
      }
    }).depends(remaining);
  }

}
