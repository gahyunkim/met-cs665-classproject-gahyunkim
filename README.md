# Assignment 6

#### Clean Your Code: Refactoring
Gahyun (Susie) Kim

## Review Code and Identify Refactoring Points

The assignment I chose to review for refactor is Assignment #1: 
Fully Automatic Beverage Vending Machine. The main reason I selected this project 
is that I did not use any design patterns and did not do much refactoring after the initial 
implementation. Using design pattern goals, I was able to identify refactor areas and apply 
design patterns to simplify my implementation. 

### Refactoring Points

#### #1: Bloated Methods 
When reviewing the application, I first read through the BeverageVendingMachine. Here, I found 
a couple bloaters in my brew and serve methods. The body of these methods included condition 
checks to evaluate the machine state and determine if it was valid to execute the appropriate 
actions. As a result, there were several if/else statements that potentially add logical 
complexity for new engineers understanding the application. 

#### #2: Replace Data Value for Object
Following on the first problem of inefficient state management of the machine, the state 
information was ineffectively tracked by storing this information as boolean member variables. 
Using boolean variables to track the machine’s initialization, ready, and brewing status was 
tiresome and added logical complexity when implementing the methods. In the brew method, I used 
two of the member variables to check if the machine was initialized and ready. 

Ideally, at most, I would at most only want to check that the machine is ready. However, since the 
machine can be in any state for this method in this class, I needed to place an extra check as it 
could be called without initialization (proper setup).

#### #3: Replace Array with Object
Lastly, I noticed that the array of beverages stored in the machine may be inflexible and 
inefficient as demand for functionality increases. For example, the application may need to 
keep inventory of the beverages and other details about each beverage. If we kept the way we 
stored details about the beverage as an array, we may need to add more business logic onto 
many methods in the vending machine, creating further complexity.

### Refactor Strategy
To resolve these identified refactoring points, I first applied the State pattern to tackle the 
first two points that related to how the machine’s state was stored and processed in the methods. 
By using this pattern, this would remove many of the condition checks in the machine’s methods 
and move this responsibility to the different states to execute the appropriate state transition. 
This enhances readability substantially. Furthermore, the machine would can use just one member 
variable to keep track of its state, instead of several boolean variables. 

I created a MachineState interface that includes initialize, brew, serve, and get. Then, I created 
three classes to implement these methods: UninitializedMachineState, ReadyMachineState, and 
BrewingMachineState. These classes only needed minimal checks using the machine’s information, 
such as its default price. Since these classes are only used when it is in its appropriate state, 
much of the initial duplicated logic is removed.

Finally, to resolve the third point, I replaced the beverages array with its own inventory class 
object that would handle more sophisticated business logic. I created the BeverageInventory class 
and as an example, added a capability to track the amount of beverages available and restock. 
By creating a more customized container for the offered beverages, we have more flexibility in 
adding more functionality and avoid adding more responsibilities and bloated methods to the 
vending machine.

_**Note_: for the simplicity of the refactored machine system’s UML, I did not include the beverage subclasses and its implementations

## Solution Description and Code Change

### Refactored UML
![Alt text](refactor_uml.png?raw=true)

### Original UML
![Alt text](original_uml.png?raw=true)