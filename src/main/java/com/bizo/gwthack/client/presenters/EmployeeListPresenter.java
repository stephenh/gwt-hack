package com.bizo.gwthack.client.presenters;

import org.gwtmpv.GenPlace;

import com.bizo.gwthack.client.AppRegistry;
import com.bizo.gwthack.client.views.IsEmployeeListView;

public class EmployeeListPresenter extends AbstractPresenter<IsEmployeeListView> {

  @GenPlace(value = "employees", async = false)
  public static void show(final AppRegistry registry, final AppPresenter appPresenter) {
    appPresenter.show(new EmployeeListPresenter(registry));
  }

  public EmployeeListPresenter(final AppRegistry registry) {
    super(registry.getAppViews().getEmployeeListView(), registry);
  }

}
