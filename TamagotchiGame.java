//Tamagotchi Game - Users will be able to take care of their own pet of their choosing
// and take care of it with different command options like eat, sleep, dress up, and play
//Text-Based Pet Adventure
//Programmed by Tierra Doughty

//Everything I am importing for this program:
	import java.util.*;
	import java.util.Scanner;
	import java.time.format.DateTimeFormatter;  
	import java.time.LocalDateTime;    

public class TamagotchiGame {
	//Initialize all the pet stats that will increment and decrement based on how well the player takes care of their pet, happiness initialized at 50/100
			// Other ones equal to 20:
			public int happiness = 100;
			public int hunger, sleep, clean, nurture, fun = 20;
			public final int MAX_STATS = 100;

			//These outside methods do not need to take methods nor does it return anything:
			//Reminder of global variables private int happiness = 100;
			//private int hunger, sleep, clean, nurture, fun = 20;
			//private final int MAX_STATS = 100;
			//all stats max =20;
			
			
				public void feed() {
					//Decrements pet's hunger stat by 5 as time passes
					hunger -= 5;
					//Simple If statement to set a boundary of 0, if hunger stat goes below 0
					if(hunger<0) {
						hunger = 0;
					}
					
				}
				
				public void rest() {
					happiness += 3;
					
				}
				
				public void clean() {
					clean = 20;
					
				}
				
				public void nurture() {
					happiness += 5;
					
					 if(happiness > 100) {
						 happiness = 100;
					 }
					
				}
				
				public void play() {
					happiness += 3;
					 sleep -= 2;
					
					 if(happiness > 100) {
						 happiness = 100;
					 }
					 
					 if(sleep > 100) {
						 sleep = 100;
						 
					 }
				}

				public String getMood() {
					
					if(sleep == 0) {
						return "asleep";
					} else if(sleep <= 10 ) {
						return "tired";
					} else if (hunger <= 10) {
						return "hungry";
					} else if(clean <= 10) {
						return "dirty";
						
					} else if (happiness >= 85) {
						return "happy";
					} else if (happiness < 85 && happiness >= 50) {
						return "okay";
						
					} else {
						return "sad";
					}
				}
				
				public void passTime() {
					hunger++;
					clean--;
					
					if(sleep == 10) {
						sleep = 0;
					} else {
						sleep++;
					}
					
					
					if(hunger >= 7) {
						happiness--;
					}
					if(clean < 3) {
						happiness--;
					}
					
					if(hunger > 10) {
						hunger = 20;
					}
					
					if(clean < 0) {
						clean = 0;
					}
					
					if (happiness < 0) {
						happiness = 0;
					}
					
				}
			
			
			
			
			
			
//Main Method:
	public static void main(String[] args) {
		
	//intialized as true until player exits game:
		boolean programOn = true; 
    	int userChoice;
    	int numOfServers;
    	
    //exit code so the user can type this to end the program:
    	int EXIT = -1; 
    	
    //while loop that keeps the program running and remains true until the program exits
    	while(programOn==true) {
    	
    	Scanner input = new Scanner(System.in); //initialize new scanner called input to get user input
    	
    //Cute little borders for organizational purposes:
		System.out.println("<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3\n");

    //Print lines for a welcome banner, message and introduction
		
    	System.out.println("Hello, welcome to WATCHOVER, the totally not copyrighted name from another game,\n not Pokemon-like, "
    			+ "and definitely unique version of the iconic Tamagotchi game from the 90s!");

    	
    	
    	
    	System.out.println("This game allows you to choose a pet of your own and take care of it! Yay, responsibility!");
    	
    //The One and Only:
    	System.out.println("\nProgrammed by: Tierra Doughty (Tee)\n");
    	
    //Tamagotchi's usually have the real time and date that constantly updates so I added it for aesthetic purposes and immersion:
    	System.out.println("The local date and time is currently: ");
    	java.util.Date date = new java.util.Date();    
    	System.out.println(date);
    	
    //Cute little borders for organizational purposes:
		System.out.println("\n<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3\n");

    	
    //get user's name from input
    	System.out.println("\nPlease enter your name to begin: ");
    	String userName = input.nextLine();
    	
    //Cute little borders for organizational purposes:
		System.out.println("<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3\n");
		
		System.out.println("Hi " + userName + ", Welcome to the WATCHOVER pet shop!");
		System.out.println("My name is Tee and I work here! Let me tell you a little about this quirky place. We offer a variety of animals to choose from at no cost. \nThese are not just special animals "
				+ "however, but animals that will be train to grow up one day and become superheroes...or supervillians. We, haha, have had quite of villians lately. "
				+ "\nAnyways- we are looking for responsible individuals that will do their best to nurture these animals as they begin growing and discovering their abilities. "
				+ "This responsibility is not for the faint of heart, these sweetiepies can be a handful.");
		
		//Array for pet list
		String[] petList = new String [6];
		petList[0] = "Dog";
	    petList[1] = "Cat";
	    petList[2] = "Hamster";
	    petList[3] = "Dragon";
	    petList[4] = "BlackVoid";
	    petList[5] = "Birb";

	   
    	System.out.println("So! What are you waiting for, go ahead and pick your poison...uh I mean pet!\n");
    	System.out.println("1.) Dog\n"); 
    	System.out.println("2.) Cat\n");
    	System.out.println("3.) Hamster\n");
    	System.out.println("4.) Dragon\n");
    	System.out.println("5.) Black Void\n");
    	System.out.println("6.) Birb\n");
    	System.out.println("Type " + EXIT + " to exit the program.\n"); //utilizes exit code to stop the entire program
		System.out.println("<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3\n");
    	System.out.println("Enter your choice here: ");
    	userChoice = input.nextInt(); //Scanner looking for an integer that relates to command options
    	input.nextLine(); //Next line so enter does not take over
    	
    //Simple If Statement for when the user decides to exit the game:
    	if(userChoice == EXIT) {
        	System.out.println("/nAwwwww, leaving the game so soon. Goodbye!");
        	
    		System.out.println("\n<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3\n");
    		
    		input.close();
    		programOn = false;
    		
    		//Terminates program
        	System.exit(EXIT);	
    	} //end If Statement
    		
    	 String chosenPet = petList[userChoice-1];
    	 System.out.println("You have chosen " + chosenPet + " *ARF ARF ARF*\n");
    	
    	//Switch for user's choice of pet (Dog, Cat, Hamster, Dragon, Black Void, Birb):
   /* 	switch (userChoice) {
        case 1:
            System.out.println("You have chosen a Dog. *ARF ARF ARF*\n");
        
            System.out.println("Pwease name your dog: \n");
           String petName = input.nextLine();
           
           System.out.println("Your dog's name is " + petName + ". Congratulations!");
           System.out.println("Every pet has stats that contribute to their overall happiness. If you take care of your pet, the stats will remain high and their happiness will max out.");
           System.out.println("However, if you neglect your pet, their happiness will decrease until"
           		+ "you ultimately face their wrath. Please take care of " + petName + " and good luck!");
           
         //want to display all stats:
           System.out.println("Here is " + petName + "'s current stats and overall mood:");
           
           
         //Initialize all the pet stats that will increment and decrement based on how well the player takes care of their pet, happiness initialized at 50/100
   		// Other ones equal to 20:
   		
    int  happiness = 100;
   	int	hunger = 20;
   	int sleep = 17;
   	int clean = 20; 
   	int nurture = 20;
   	int fun = 20;
   	int MAX_STATS = 100;
           
           System.out.println("Hunger: " + hunger);
           System.out.println("Sleep: " + sleep);
           System.out.println("Clean: " + clean);
           System.out.println("Nurture: " + nurture);
           System.out.println("Fun: " + fun);
           System.out.println(" Overall Happiness: " + happiness);

            break;

        case 2:
            System.out.println("You have a CAT now. *mew meow MEOWWWWW uwu*\n");
            System.out.println("Pwease name your cat: \n");
            petName = input.nextLine();
           
            System.out.println("Your cat's name is " + petName + ". Congratulations!");
            System.out.println("Every pet has stats that contribute to their overall happiness. If you take care of your pet, the stats will remain high and their happiness will max out.");
            System.out.println("However, if you neglect your pet, their happiness will decrease until"
            		+ "you ultimately face their wrath. Please take care of " + petName + " and good luck!");
            
 //want to display options
            System.out.println("Here is " + petName + "'s current stats and overall mood:");
            
            break;

        case 3:
            System.out.println("Hamster\n");
            // Implement the logic for stopping a server here.
            break;

        case 4:
            System.out.println("Dragon\n");
            // Implement the logic for deleting a server here.
            break;

        case 5:
            System.out.println("Black Void\n");
            // Implement the logic for finding a server here.
            break;

        case 6:
            System.out.println("Birb\n");
            // Implement the logic for listing all servers here.
            break;

        default:
            System.out.println("Error: Please try typing the number corresponding to the options above or type -1 to exit WATCHOVER.\n");
    } */

	} //while loop
	
}//end main
	
}//end TamagotchiGame