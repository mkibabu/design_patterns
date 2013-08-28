THE BUTTONS PROJECT
===================
An attempt to model the proxy and flyweight design patterns.

Proxy Design Pattern
--------------------
The proxy design pattern is used to delay instantiating resource-hungry
objects until a client actually requests them. Until an object is actually
needed, the system uses a proxy that presents the same interface as the
actual object.

Flyweight Design Pattern
------------------------
The flyweight design pattern is used when a system requires a large number of
resource-hungry objects that have some shared state. Each flyweight object
consists of two states:
1. The intrinsic state, which is unique to the particular instance of the
object in question.
2. The extrinsic state, which can be shared between many different objects.
The extrinsic state is stored or computed in client objects and passed to the
flyweight when its methods are invoked.


The Buttons Project
-------------------
A window is created that contains a large grid of buttons. When the user 
left-clicks on a button, button-specific information is computed. Specifically,
we compute the Euclidean distance between the (X, Y) coordinates of the button 
and the origin of the window (0, 0). This computation is performed on a remote 
server process, so a network request is issued, and a reply is returned. When 
the user right-clicks on a button, we compute the square of the value displayed
in that button's label. The first time the square is computed for a particular 
value, a network request is issued, a reply is received, and the answer is 
cached in the ServerProxy. Subsequent requests for the square of that value 
from any other button of that same value will simply be returned from the 
cache.


