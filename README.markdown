Example Tessell Application 
==================================

Tessell is a GWT application framework that follows a Model View Presenter architecture. The example application implements these features:

* Navbar of clients/employees
* Places of clients/client/employees/employee
* Table of clients, employees
* Editing of client/employee
* Reloading employee/client/etc. when you come back

Setup
==============

* Clone the `gwt-hack` repository
* Install IvyDE in Eclipse
* Import the project into Eclipse
* Run the gwt-hack launch and it should start up

Capabilities of Tessell 
==============

* Employee tabs (overview, payroll, whatever) to get subviews
* Validate length of fields, update remaining chars on type
* Have one view that is a delayed load--blank out the target space and reveal after server-side result
* Multiple employee/client presenters at a time (with a place like tabIds=1,2,4)
* Whether the container presenter eager/lazy unbinds is based on ChildPresenter.isEagerlyUnbound()
* Validation errors are marked as claimed (property onError handlers first, then eventBus)
* Properties can be marked "currently changing"--some errors/updates may wait until not currently changing

* presenter <-> view method calls
* presenter <-> model method calls
* presenter <-> presenter event bus (originally...still the goal?)
* pass around presenters that we can eagerly/late bind/unbind with their view
* popping into view after async is mostly a child-only concern...empty container later has content. what about slide in/out?
* ChildPresener.getShouldEarlyUnbind so parents know to unbind
* Presenter.addOnUnbind event so places know to forget their cached version

What is Model View Presenter?
==============

Model fields get wrapped as ValueAspectAdapters. Each presenter is given a single model, which for TextPresenter is a VAA.  Composite presenter directly instantiates child presenters, including TextPresenters.

ListModel for wrapping lists. Presenter subscribers to the events of other presenters (79). Presenter.onViewOpened.

Their tables had a getText(Row) method. Fine for text-only tables. What about complex tables that want basically presenters in them?

1 view template --> multiple views, e.g.

 <tr><td> --> td is a separate view





