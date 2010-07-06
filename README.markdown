

Clients
Employees

Client name, amount due
Employee name, title, date started

* Navbar of clients/employees
* Places of clients/client/employees/employee
* Table of clients, employees
* Editing of client/employee
* Reloading employee/client/etc. when you come back

Bonus:

* Employee tabs (overview, payroll, whatever) to get subviews
* Validate length of fields, update remaining chars on type
* Have one view that is a delayed load--blank out the target space and reveal after server-side result
* Multiple employee/client presenters at a time (with a place like tabIds=1,2,4)
* Whether the container presenter eager/lazy unbinds is based on ChildPresenter.isEagerlyUnbound()
* Validation errors are marked as claimed (property onError handlers first, then eventBus)
* Properties can be marked "currently changing"--some errors/updates may wait until not currently changing

* presenter <-> view method calls
* presenter <-> model method calls
* presenter <-> presenter event buss
* pass around presenters that we can eagerly/late bind/unbind with their view
* popping into view after async is mostly a child-only concern...empty container later has content
* singleton presenters is so incredibly stupid
* ChildPresener.getShouldEarlyUnbind so parents know to unbind
* Presenter.addOnUnbind event so places know to forget their cached version

---

MPV notes:

Model fields get wrapped as ValueAspectAdapters. Each presenter is given a single model, which for TextPresenter is a VAA.  Composite presenter directly instantiates child presenters, including TextPresenters.

ListModel for wrapping lists. Presenter subscribers to the events of other presenters (79). Presenter.onViewOpened.

Their tables had a getText(Row) method. Fine for text-only tables. What about complex tables that want basically presenters in them?

---

1 view template --> multiple views, e.g.

 <tr><td> --> td is a separate view

---

Gwt notes:

* Every place registers itself to listen for any PlaceRequestEvent--if it matches, it handles itself, plus PlaceRevealedEvent(this)
* On any PlaceRevealedEvent or PlaceChangedEvent, a new place.PlaceRequest is formatted and given to History.newItem
* PresenterPlace watches for PresenterChangedEvents and converts them into PlaceChangedEvents(place)
* PresenterPlace watches for PresenterRevealedEvents and converts them into PlaceRevealedEvents(place)
* When setting up two way, add an "ignore first" option


----

 * Need to think about:
 * 
 * 1) Has user touched our field yet? If their on field one and do something wrong, we don't want field four to suddenly
 * throw an error. Though if they click 'continue' then we do want all fields to pipe up.
 * 
 * 2) Is our field relevant to the object's current state? E.g. is the ad an image ad but our field is a text field.
 * 
 * 3) Is our field waiting for a server-side validation request? E.g. check that a name is unique. How do we say our
 * validatity is pending?
