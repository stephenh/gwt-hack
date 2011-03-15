package com.bizo.gwthack.client.presenters;

import static com.bizo.gwthack.client.views.AppViews.*;

import com.bizo.gwthack.client.*;
import com.bizo.gwthack.client.views.*;
import org.gwtmpv.presenter.*;

public class AppPresenter extends AbstractPresenter<IsAppView> {

  private final Slot<Presenter> current = new Slot<Presenter>(this);

  public AppPresenter(final AppRegistry registry) {
    super(newAppView(), registry);
  }

  @Override
  public void onBind() {
    super.onBind();
    registry.getAppResources().style().ensureInjected();
  }

  public void show(final Presenter presenter) {
    current.set(presenter);
    view.content().clear();
    view.content().add(presenter.getView());
  }

}
