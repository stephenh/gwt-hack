package com.bizo.gwthack.client.app.employees;

import com.bizo.gwthack.client.AppRegistry;
import com.bizo.gwthack.client.app.AbstractPresenter;
import com.bizo.gwthack.client.views.IsEmployeeListView;

public class EmployeeListPresenter extends AbstractPresenter<IsEmployeeListView> {

  public EmployeeListPresenter(final AppRegistry registry) {
    super(registry.getAppViews().getEmployeeListView(), registry);
  }

}
