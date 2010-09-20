package com.bizo.gwthack.client.presenters;

import org.gwtmpv.GenPlace;
import org.gwtmpv.model.properties.StringProperty;
import org.gwtmpv.model.values.DerivedValue;
import org.gwtmpv.place.PlaceRequest;

import com.bizo.gwthack.client.AppRegistry;
import com.bizo.gwthack.client.messages.GetClientAction;
import com.bizo.gwthack.client.messages.GetClientResult;
import com.bizo.gwthack.client.model.GClientModel;
import com.bizo.gwthack.client.views.IsClientView;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ClientPresenter extends AbstractPresenter<IsClientView> {

  private final GClientModel client;
  private final StringProperty nameLeft;

  @GenPlace(value = "client", async = false)
  public static void show(final AppRegistry registry, final AppPresenter app, PlaceRequest request) {
    final String id = request.getParameter("id", null);
    registry.getAsync().execute(new GetClientAction(id), new AsyncCallback<GetClientResult>() {
      @Override
      public void onSuccess(GetClientResult result) {
        ClientPresenter p = new ClientPresenter(registry, new GClientModel(result.getClient()));
        app.show(p);
      }

      @Override
      public void onFailure(Throwable arg0) {
      }
    });
  }

  public ClientPresenter(final AppRegistry registry, final GClientModel client) {
    super(registry.getAppViews().getClientView(), registry);
    this.client = client;
    // need a better DSL here
    nameLeft = new StringProperty(new DerivedValue<String>() {
      @Override
      public String get() {
        return client.name.remaining().get() + " left";
      }
    }).depends(client.name);
  }

  @Override
  protected void onBind() {
    super.onBind();
    binder.bind(client.name).to(view.name());
    binder.bind(nameLeft).toTextOf(view.nameLeft());
    binder.enhance(view.name());
    // registerHandlers(client.saveOn(view.submit(), new OnSaveResult()));
  }

  public GClientModel getClient() {
    return client;
  }

}
