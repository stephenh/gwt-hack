package com.bizo.gwthack.client.presenters;

import static com.bizo.gwthack.client.views.AppViews.*;

import com.bizo.gwthack.client.*;
import com.bizo.gwthack.client.views.*;
import com.bizo.gwthack.shared.model.*;
import org.tessell.*;

public class EmployeeListPresenter extends AbstractPresenter<IsEmployeeListView> {

  @GenPlace(name = "employees", async = false)
  public static void show(final AppRegistry registry, final AppPresenter appPresenter) {
    appPresenter.show(new EmployeeListPresenter(registry));
  }

  public EmployeeListPresenter(final AppRegistry registry) {
    super(newEmployeeListView(), registry);
  }

  @Override
  public void onBind() {
    super.onBind();

    view.rowTable().addHeader(newEmployeeListHeaderView());
    for (int i = 0; i < 5; i++) {
      EmployeeDto e = new EmployeeDto("ee " + i, "description " + i);
      EmployeeRowPresenter p = addPresenter(new EmployeeRowPresenter(registry, e));
      view.rowTable().addRow(p.getView());
    }
  }

  /** Handles manipulating each employee in the table. */
  private class EmployeeRowPresenter extends AbstractPresenter<IsEmployeeListRowView> {
    private final EmployeeDto employee;

    public EmployeeRowPresenter(AppRegistry registry, EmployeeDto employee) {
      super(newEmployeeListRowView(), registry);
      this.employee = employee;
    }

    @Override
    public void onBind() {
      super.onBind();
      view.name().setText(employee.name);
      view.description().setText(employee.description);
    }
  }

}
