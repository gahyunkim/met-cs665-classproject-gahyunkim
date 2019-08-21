# CS 665 Class Project

### Aircraft Maintenance Status 
Gahyun (Susie) Kim

## Task 1: Description & Design Pattern 

### Use Case Scenario
For the class project, I developed an Aircraft system designed for an aircraft’s maintenance, 
refueling, and mission tasking. Here I list the main features and design patterns used in 
implementation.

#### Specifications
Users can create an aircraft with a list of required specifications such as its parts, 
refueling rate, and model name. When users enter the parts, they also add in the part’s start 
date and expected life span. At a minimum, they are required to enter the aircraft’s engine and 
radar.

##### Design Pattern
In our use case, we assume that an aircraft can only be built with a list of required 
specifications. Since this is a lengthy list, I decided to use the **Builder** pattern to separate 
and break down its complex construction. In contrast, if we did not use this, we would have a 
very lengthy constructor that is difficult to use.  

#### Maintenance
Once the aircraft has been built, the system can use its parts information to assess its health. 
From this information, they can check to see if its status is healthy or has any warnings or 
critical notices. Based on this information, they can then perform a maintenance to get the 
aircraft back to a healthy state. 

##### Design Pattern
To represent the aircraft’s health state based on required maintenance, I used the **State** 
pattern. Based on the aircraft’s state of health, it can perform print appropriate assessment 
results and perform minimal, required maintenance if in warning or critical condition.  

#### Aerial Refueling
Users can refuel an aircraft with either a boom or probe-and-drogue method. 
By default, all aircraft are set to use drogue, but users can assign a different refueling method. 

##### Design Pattern 
Since aircraft can have different methods for refueling, I decided to use the **Strategy** pattern. 
Thus, refueling methods are interchangeable. This is important in aerial refueling as the 
receiver aircraft’s refueling method must be compatible with that of the tanker 
(larger aircraft that provides fuel). 

#### Mission Tasking
Users can add and remove pilots to the aircraft. Currently, the system contains Naval pilots and 
Air Force aviators. Users can then assign an aircraft a mission by specifying its type and bases 
for takeoff and landing. Once the aircraft has been tasked, users can then select to notify the 
assigned pilots. The pilots will then receive the mission type, objective description, and base 
information. 

##### Design Pattern
To notify the pilots, I used the **Observer** pattern. Typically, pilots have expertise in 
flying a certain aircraft. Thus, in our system, an aircraft can be assigned with a set of 
pilots. Once a mission has been set for the aircraft, the user can notify the assigned pilots. 
The pilots will receive the mission type, objective, and associated bases. 



### Software Design Concepts

#### Flexibility
##### Aircraft Parts | Creation · Modification · Addition · Removal
The Part interface ensures that any new part implemented consists of methods to set its 
lifespan and assess its health based on years left until required maintenance. It also 
includes methods to modify this information. By fulfilling the required methods, creating 
and adding a new Part type does not require modification or additional business logic in 
other classes. Adding and removing parts for an aircraft is handled by the aircraft’s 
PartsInventory object. The object also includes the methods to retrieve warning and critical 
parts based on its evaluation and assess overall inventory status.

##### Pilots | Creation · Addition · Removal
Similar to aircraft parts, the creation of any additional type of pilot has a simple Pilot 
interface needed for implementation. These required methods ensure that any new pilot is an 
observer in our system. The pilot receives updates on new missions tasked to the aircraft 
they are assigned to. Each aircraft can add or remove pilots, subscribers to mission notifications.

##### Mission | Creation · Modification · Addition · Removal
The system also defines a MissionType interface, which ensures that a detailed mission 
description is set and can be retrieved. Currently, our system consists of Attack, Cargo, 
Fighter, and Observation missions which consist of a more detailed objective. The Mission 
class contains a MissionType member variable along with takeoff and landing bases. Missions 
can be retrieved, modified, and removed from the aircraft. They can also be modified to 
change its type, name, and bases. 
 
##### Aerial Refueling | Creation · Interchangeability 
New refueling methods can also be easily defined by implementing the RefuelMethod, 
which includes a method to execute refueling. Our system defines methods for aerial refueling, 
which consists of boom and probe-and-drogue method. In our use case, we can get more specific 
by extending the probe-and-drogue method to specify the use of either a soft or hard basket. 
We can also add new types of refueling, such as non-aerial refueling. Furthermore, our system 
provides flexibility in changing an aircraft’s refueling method by using the strategy pattern.


#### Reusability
##### Refueling Compatibility
Our system’s aircraft and its refueling classes can be reused in another system that 
determines the refueling compatibility between two aircraft. The receiver and tanker 
aircraft’s compatibility is based on several factors, including method of refueling, nation, 
altitude, and speed. Currently, our system provides aerial refueling method and speed. 
The aircraft can easily be modified to add in other factors required to determine compatibility.

##### Mission Report & Analysis
Another system that focuses on gathering all tasked missions and performing analysis can 
reuse our Mission and MissionType classes. This system can add more detailed information 
regarding each mission. They can then add additional classes to process information of all 
missions and provide overall assessments. These can be used to provide better decision-making. 

#### Avoiding Duplicate Code
##### Part Maintenance
The aircraft parts have several methods in common. To avoid repeating the same calculations in 
all classes, I extracted these common functionalities out into a MaintenanceUtil class that is 
inherited by these parts. Thus, whenever one of these calculations needs to be modified, it 
only needs to be changed in this utility class and does not need to be repeated for every part. 

##### Mission Details
In our system, we have a Mission class that has a MissionType member variable. 
The Mission class contains details that are required regardless of its type, such as takeoff
 and landing bases. Its mission type variable consists of information that is only specific to 
 its type. By containing the more general mission specifications in the Mission class, we avoid 
 duplicating this information across each MissionType class. 
 
 
## Task 2 UML Diagram
![Alt text](aircraft_system.png?raw=true)

## Task 3: Java Solution Implementation
Same project structure and run process as class assignments.

To compile and run main script: 
`./run.sh`

## Task 4: Presentation Slides

Attached PDF in Blackboard submission.

Google Slides: 
https://docs.google.com/presentation/d/1RFLnD7ZVXQMEcErWDPfdsdhp-gpkv-1VSek5NNPfAe0/edit?usp=sharing

## Task 5: Recording

Attached MP4 in Blackboard submission.