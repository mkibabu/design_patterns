THE ARMY PROJECT
================
An attempt to show the composite design pattern.

Composite Design Pattern
------------------------

The composite design pattern is used to create systems that can easily be 
represented via a hierarchical structure. If a system consists of both complex
and simple parts that have uniform operations and attributes, having part-whole
hierarchies allows both the branch and the leaf nodes to be treated uniformly. 
This greatly reduces the complexity of the design.

The composite pattern is an example of a structural pattern.

The Army Project
----------------

The Army project gives an example of the composite pattern by simulating a 
militia. Specifically, it attempts to solve the problem of distributing 
ammunition to the soldiers in the army. 

### Structure
The program supports two different types, a spy and a foot soldier, each of 
which has its own default attributes. The army is arranged such that soldiers 
can be grouped into different divisions. Those divisions, in turn, can be 
grouped with other soldiers into larger divisions, until we have constructed
one large grouping that contains the entire hierarchical structure of the army.
When adding ammunition to the army, we don't want to have to care about whether
or not we are adding ammo to a single soldier or an entire division.

The project is arranged as follows:

#### Militia
An abstract class from which both the Division (branch of our tree) and soldier
(leaf) inherit from. It contains accounting methods common to both groups, i.e.
keeping track of the ammo.

#### SoldierFactory
Creates a foot soldier or a spy, depending on the type parameter given.

#### Division
A Division represents a group of soldiers. It inherits from the Militia class.

#### Soldier
Acts as a super-class for both kinds of Soldier objects (Foot Soldier vs Spy).

#### Spy
Type (and subclass) of Soldier.

#### FootSoldier
Type (and subclass) of Soldier.






