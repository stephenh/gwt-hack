Example Tessell Application 
==================================

Tessell is a GWT application framework that follows a Model View Presenter architecture. The example application shows reloaded, editable
Client and Employee tables that the user can navigate between.

Setup
==============

* Clone the `gwt-hack` repository
* Install [IvyDE](http://ant.apache.org/ivy/ivyde/) in Eclipse
* Import the project into Eclipse
* Launch gwt-hack

Capabilities of Tessell 
==============

* Subviews
* Length validation of fields
* One view with a delayed load
* Multiple presenters at a time
* Possible for container presenter to do eager or lazy unbinds 
* Validation errors are marked
* Properties can be marked "currently changing"
* Presenter <-> View method calls
* Presenter <-> Model method calls
* Presenter <-> Presenter event bus 
* Pass around presenters that can eagerly/late bind or unbind with their view
* Popping into view after async is mostly a child-only concern







