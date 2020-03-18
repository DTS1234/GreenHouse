# GreenHouse
 Application that regulates the temperature and humidity in a greenhouse - programming excersice

Each temperature sensor is reading temperature while each humidity sensor is reading humidity of the greenhouse periodically,
it feeds it back to the application giving it temperature or humidity awareness.

Then, the application can order open or close actions upon doors to mitigate hot/cold. 
It acts on the irrigation system as well, to mitigate high/low humidity in order to maintain adequate levels.

Besides, it checks the quality of the electronic devices in the greenhouse (sensors and automatic doors) in
order to monitor correct operation.

Temperature control :

 Controlling the temperature involves opening or closing doors when the temperature goes outside the assigned range
 (between 18 and 22 degrees). 

 When the average temperature read from the sensors exceeds the upper limit (22 degrees), 10% of the existing doors will be 
 opened per each degree over the upper limit (if there are not enough doors to open, all possible doors must be opened). 

 In the same way, if the temperature does not reach the lower limit (18 degrees), 10% of the doors will 
 be closed per each degree below the lower limit (or all possible doors that can be closed).

As mentioned before, the greenhouse has temperature and door sensors.

Doors :

 There are two door models: automatic and manual. 
 Both have the same operations. They are carried in a different way, though. 
 For manual doors and the open operation, the operator is warned in the console to go and open the
 door, while for the automatic doors just a message in the console telling that the door is opening is displayed. Same
 thing is done for the close operation.
 Each door has two operations: open and close, and a state that can be queried (it indicates if the door is open or closed).

Temperature Sensors : 

 Each temperature sensor has an operation that returns the temperature measured in that moment. This operation is
 simulated returning a random number between 5 and 40 degrees.

Quality check of the electronic devices : 

 To assure the correct operation of the greenhouse, we have a scanner (electronic device) that checks if the devices
 are working correctly, reporting the failure of damaged sensors by displaying a message. This test is performed
 periodically.
 
 The electronic devices in the greenhouse are : 
  - the temperature sensors 
  - the humidity sensors 
  - the automatic doors.
  
The scanner checks them all, and reports the failing ones. In our case, the checking operation will return true or false
(with a 5% probability).

Humidity control : 

 The greenhouse also performs a humidity control, using the data from the humidity sensors to compute the average
 humidity in the greenhouse and acting upon the irrigation system.
 
 Humidity must be somewhere between 20 and 70. Average humidity must be checked as regularly as temperature,
 and act according the following rules:
 
   - Just after checking humidity, must print the message: “Right now, average humidity is <value here>”
   - If the average humidity is within the allowed values, no action is necessary. Print the message “Humidity is
    right”
   - If the average humidity too high, that is, it is 20% over the upper limit, then, set off the irrigation system.
   - If the average humidity too low, that is, it is 20% below the lower limit, then, put the irrigation system up to
    high (maximum position).
   - In other case, just go the irrigation system up or down one level.
 
Irrigation System : 
 
 Each time irrigation system level is changed, the message is shons reporting the actual level of irrigation
