package com.bizo.gwthack.client.presenters;

import com.bizo.gwthack.client.*;
import com.bizo.gwthack.client.views.*;
import org.gwtmpv.*;

public class EmployeeListPresenter extends AbstractPresenter<IsEmployeeListView> {

  @GenPlace(value = "employees", async = false)
  public static void show(final AppRegistry registry, final AppPresenter appPresenter) {
    appPresenter.show(new EmployeeListPresenter(registry));
  }

  public EmployeeListPresenter(final AppRegistry registry) {
    super(registry.getAppViews().newEmployeeListView(), registry);
  }

}
