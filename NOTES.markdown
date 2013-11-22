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

Need to think about:

1) Has user touched our field yet? If their on field one and do something wrong, we don't want field four to suddenly throw an error. Though if they click 'continue' then we do want all fields to pipe up.

2) Is our field relevant to the object's current state? E.g. is the ad an image ad but our field is a text field.

3) Is our field waiting for a server-side validation request? E.g. check that a name is unique. How do we say our validatity is pending?

4) What is the difference between a `Property<Boolean>` and a Rule? They both have true/false states that listeners will want to act on.