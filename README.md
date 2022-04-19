# GoFo
Class User:
	Create new user Admin, Player or Owner and contain abstract homescreen and it controls the eWallet and allow user to
	do operations withdraw and deposit

Class Admin:
	Inherits from class User an admin recive new playgrounds requests list from the playground owners and choose to give
	it permission or not no playground can be activated without the admin permission after permission playground added to
	allowed list and player can book it

Class Owner:
	Inherits from class User represent the playground owner who can create new playground and add timeslots and add it to the
	playground requests list and wait for the admin to give it permission after permission playground added to his playgrounds.
	Owner can also recive booking request from players and choose to accept or reject it.

Class Player:
    	Controls of all players and their books and requests.

class Playground:
    	in this class we can make a new object of type playground to hold information about a playground
    	And control its attributes.

Class Timeslot:
   	This class is used to generate a time slote used later by Playground objects so users can see the available slots
   	Of a playground and is used also by Request Class to specifiy which timeslot the player wishes to book.

Class Request:
    	This Class is used to generate requests between (player and owner) or (owner and admin) in the first case there is
    	A timeslot specified by the player to book the playground and the other one there is no timeslot needed as the owner 
    	just wants to Admin to approve their playground to be shown.

Class List:
    	Works like a data base for the program.
    	It stores all information of players, owners, playgrounds and requests and return them if needed.

Class WelcomeScreen:
    	To start the program and return to welcome screen if needed.


we used intellij with JDK version 16 to develope this program
