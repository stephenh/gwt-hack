package com.bizo.gwthack.client.presenters;

import static com.bizo.gwthack.client.views.AppViews.*;

import com.bizo.gwthack.client.*;
import com.bizo.gwthack.client.model.*;
import com.bizo.gwthack.client.views.*;
import com.bizo.gwthack.shared.messages.*;
import org.gwtmpv.*;
import org.gwtmpv.dispatch.client.*;
import org.gwtmpv.model.commands.*;
import org.gwtmpv.model.properties.*;
import org.gwtmpv.place.*;

public class ClientPresenter extends AbstractPresenter<IsClientView> {

  private final ClientModel client;

  @GenPlace(name = "client", async = false)
  public static void show(final AppRegistry registry, final AppPresenter app, PlaceRequest request) {
    final String id = request.getParameter("id", null);
    registry.getAsync().execute(new GetClientAction(id), new SuccessCallback<GetClientResult>() {
      public void onSuccess(GetClientResult result) {
        app.show(new ClientPresenter(registry, new ClientModel(result.getClient())));
      }
    });
  }

  public ClientPresenter(final AppRegistry registry, final ClientModel client) {
    super(newClientView(), registry);
    this.client = client;
  }

  @Override
  protected void onBind() {
    super.onBind();
    binder.bind(client.name).to(view.name());
    binder.bind(makeNameLeft()).toTextOf(view.nameLeft());
    binder.bind(saveCommand).to(view.submit());
    binder.enhance(view.name());
  }

  /** Saves the client and returns to the client list. */
  private final UiCommand saveCommand = new SaveClientCommand(async) {
    protected SaveClientAction createAction() {
      return new SaveClientAction(client.getDto());
    }

    protected void onResult(SaveClientResult result) {
      goTo(ClientListPlace.newRequest());
    }
  };

  /** @return a new property that says "X left" and updates when name changes. */
  private Property<String> makeNameLeft() {
    return client.name.remaining().formatted(new AbstractPropertyFormatter<Integer, String>() {
      public String format(Integer a) {
        return a + " left";
      }
    });
  }

}
