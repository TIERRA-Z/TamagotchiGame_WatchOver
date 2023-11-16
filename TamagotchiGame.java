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

				public int displayStats() {
					return hunger;
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
    	
    //do - while loop that keeps the program running and remains true until the program exits
    	do {
    	
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
		
		System.out.println("Hi " + userName + ", Welcome to the WATCHOVER pet shop!\n");
		System.out.println("My name is Tee and I work here! Let me tell you a little bit about this quirky place. We offer a variety of animals to choose from at no cost. \n\nThese are not just special animals "
				+ "however, but animals that will be train to grow up one day and become superheroes...or supervillians. \nWe, haha, have had quite of villians lately. "
				+ "\n\nAnyways- we are looking for responsible individuals that will do their best to nurture these animals as they begin growing and discovering their abilities. "
				+ "\nThis responsibility is not for the faint of heart, as these sweetiepies can be a handful.");
		
		//Array for pet list
		String[] petList = new String [6];
		petList[0] = "Dog";
	    petList[1] = "Cat";
	    petList[2] = "Hamster";
	    petList[3] = "Dragon";
	    petList[4] = "BlackVoid";
	    petList[5] = "Birb";

	   
    	System.out.println("\nSo! What are you waiting for, go ahead and pick your poison...uh I mean pet!\n");
    	
    	System.out.println("1.) Dog\n"); 
    	System.out.println("2.) Cat\n");
    	System.out.println("3.) Hamster\n");
    	System.out.println("4.) Dragon\n");
    	System.out.println("5.) Black Void\n");
    	System.out.println("6.) Birb\n");
    	System.out.println("Type " + EXIT + " to exit the program.\n"); //utilizes exit code to stop the entire program
    	
		System.out.println("<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3\n");
    	System.out.println("Enter your choice here: ");
    	
    //Scanner looking for an integer that relates to command options:
    	userChoice = input.nextInt(); 
    	input.nextLine(); //Next line so enter does not take over
    	
    //Simple If Statement for when the user decides to exit the game:
    	if(userChoice == EXIT) {
        	System.out.println("/nAwwwww, leaving the game so soon. Goodbye!");
        	
    		System.out.println("\n<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3\n");
    		
    		input.close();
    		programOn = false;
    		
    		//Terminates entire program
        	System.exit(EXIT);	
        	
    	} //end If Statement
    		
    	// String Variable chosenPet that gets the user pet based on the pet's placement in the array
    	 String chosenPet = petList[userChoice-1];
    	 
    	 System.out.println("You have chosen a " + chosenPet + "!\n");
    	 
    	 System.out.println("Pwease name your " + chosenPet + ": \n");
         String petName = input.nextLine();
         
         System.out.println("\nYour " + chosenPet + "'s name is " + petName + ". Congratulations!");
         System.out.println("Every pet has stats that contribute to their overall happiness. \nIf you take care of your pet, the stats will remain high and their happiness will max out at 100.");
         System.out.println("However, if you neglect your pet, their happiness will decrease until"
         		+ " you ultimately face their wrath. \nPlease take care of " + petName + " and good luck!");
         
 		System.out.println("\n<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3\n");

      //Array that will store unique stats and levels that strictly apply to if the chosenPet = Dog:
       String[] dogStats = new String [6];
 		dogStats[0] = "Happiness";
 	    dogStats[1] = "Hunger";
 	    dogStats[2] = "Sleep";
 	    dogStats[3] = "Clean";
 	    dogStats[4] = "Nurture";
 	    dogStats[5] = "Fun";
 	    
 	   int dogLevels [] = new int[6];
 	    dogLevels[0] = 75;
	    dogLevels[1] = 15;
	    dogLevels[2] = 20;
	    dogLevels[3] = 10;
	    dogLevels[4] = 17;
	    dogLevels[5] = 8;
	    
	   //Prints starting stats and levels for chosenPet:
	    
        System.out.println("Here is " + petName + "'s current stats and overall mood: \n");
        for (int i = 0; i < 6; i++) {
            System.out.println(dogStats[i] + ": " + dogLevels[i] + "\n");
        }

        if(dogLevels[0]== 100 || dogLevels[0] > 100) {
	    	System.out.println("Happiness all maxed out. It looks like " + petName + "is in pristine, top-notch shape. You're a natural at this!");
	    	String mood = "Happy";
	    	System.out.print(mood);
	    }
	    
	    if(dogLevels[1]==10 || dogLevels[2]==10 || dogLevels[3]==10 || dogLevels[4]==10 || dogLevels[5]==10) {
	    	System.out.println("It looks like " + petName + " needs your attention. Try looking at their stats to determine what " + petName +  " needs.\n");
	    }
	    
	    if(dogLevels[1]==5 || dogLevels[2]==5 || dogLevels[3]==5 || dogLevels[4]==5 || dogLevels[5]==5) {
	    	System.out.println("It looks like " + petName + " really needs your attention. Please try looking at their stats to determine what " + petName +  " needs.");
	    }
	    
	    if(dogLevels[1]==0 || dogLevels[2]==0 || dogLevels[3]==0 || dogLevels[4]==0 || dogLevels[5]==0) {
	    	dogLevels[0] = 80;
	    	System.out.println(petName + " needs your attention. Try looking at their stats to determine what " + petName +  " needs.");
	    }
	    
	    //If Statement if ALL dogLevels are 0- GAME OVER
	    if(dogLevels[1]==0 && dogLevels[2]==0 && dogLevels[3]==0 && dogLevels[4]==0 && dogLevels[5]==0) {
	    	dogLevels[0] = 0;
	    	System.out.println(petName + "has been neglected. " + petName + "'s eyes turn red while you begin to levitate in the air. Game over! ");
	    	System.exit(EXIT);
	    }

	    
	    //Starting Cat Stats:
	    String[] catStats = new String [6];
 		catStats[0] = "Happiness";
 	    catStats[1] = "Hunger";
 	    catStats[2] = "Sleep";
 	    catStats[3] = "Clean";
 	    catStats[4] = "Nurture";
 	    catStats[5] = "Fun";
 	    
 	    int catLevels [] = new int[6];
 	    catLevels[0] = 80;
	    catLevels[1] = 15;
	    catLevels[2] = 20;
	    catLevels[3] = 20;
	    catLevels[4] = 12;
	    catLevels[5] = 13;
	    
	    
	    //Hamster Stats and Levels:
	    String[] hamsterStats = new String [6];
 		hamsterStats[0] = "Happiness";
 	    hamsterStats[1] = "Hunger";
 	    hamsterStats[2] = "Sleep";
 	    hamsterStats[3] = "Clean";
 	    hamsterStats[4] = "Nurture";
 	    hamsterStats[5] = "Fun";
 	    
 	   int hamsterLevels [] = new int[6];
 	   hamsterLevels[0] = 80;
 	   hamsterLevels[1] = 15;
 	   hamsterLevels[2] = 20;
 	   hamsterLevels[3] = 20;
 	   hamsterLevels[4] = 12;
 	   hamsterLevels[5] = 13;
 	   
 	   
 	//Dragon Stats and Level
 	 String[] dragonStats = new String [6];
 	 dragonStats[0] = "Happiness";
 	 dragonStats[1] = "Hunger";
 	 dragonStats[2] = "Sleep";
 	 dragonStats[3] = "Clean";
 	 dragonStats[4] = "Nurture";
 	 dragonStats[5] = "Fun";
	    
	 int dragonLevels[] = new int[6];
	   dragonLevels[0] = 80;
	   dragonLevels[1] = 15;
	   dragonLevels[2] = 20;
	   dragonLevels[3] = 20;
	   dragonLevels[4] = 12;
	   dragonLevels[5] = 13;
	   
	   
	   //Black Void Stats and Levels:
	   String[] blackVoidStats = new String [6];
	   blackVoidStats[0] = "Happiness";
	   blackVoidStats[1] = "Hunger";
	   blackVoidStats[2] = "Sleep";
	   blackVoidStats[3] = "Clean";
	   blackVoidStats[4] = "Nurture";
	   blackVoidStats[5] = "Fun";
		    
		 int blackVoidLevels[] = new int[6];
		 blackVoidLevels[0] = 80;
		 blackVoidLevels[1] = 15;
		 blackVoidLevels[2] = 20;
		 blackVoidLevels[3] = 20;
		 blackVoidLevels[4] = 12;
		 blackVoidLevels[5] = 13;
 	   
		 
 	   //Birb Stats and Levels:
		 String[] birbStats = new String [6];
		 birbStats[0] = "Happiness";
		 birbStats[1] = "Hunger";
		 birbStats[2] = "Sleep";
		 birbStats[3] = "Clean";
		 birbStats[4] = "Nurture";
		 birbStats[5] = "Fun";
			    
		 int birbLevels[] = new int[6];
			 birbLevels[0] = 80;
			 birbLevels[1] = 15;
			 birbLevels[2] = 20;
			 birbLevels[3] = 20;
			 birbLevels[4] = 12;
			 birbLevels[5] = 13;
 	   
			 
			 
			//Array for petMenu:
			String[] petMenu = new String[7];
			petMenu[0] = "Feed";
			petMenu[1] = "Rest";
			petMenu[2] = "Clean";
			petMenu[3] = "Nurture";
			petMenu[4] = "Play";
			petMenu[5] = "Dress Up";
			petMenu[6] = "Exit";


			System.out.println("<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3\n");
			
			    System.out.println("\nWhat would like you like to do with " + petName + "?\n");
		    	
		    	System.out.println("1.) Feed\n"); 
		    	System.out.println("2.) Rest\n");
		    	System.out.println("3.) Clean\n");
		    	System.out.println("4.) Nurture\n");
		    	System.out.println("5.) Play\n");
		    	System.out.println("6.) *Dress Up*\n");
		    	System.out.println("7.) Exit\n");
		    	
				System.out.println("<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3\n");
		    	System.out.println("Enter your choice here: ");
		    	
		    //Scanner looking for an integer that relates to command options:
		    	userChoice = input.nextInt(); 
		    	
		    	input.nextLine(); //Next line so enter does not take over
		    	
		    	  //Simple If Statement for when the user decides to exit the game:
		    	if(userChoice == EXIT || userChoice == 7) {
		        	System.out.println("\nAwwwww, leaving the game so soon. Goodbye!");
		        	
		    		System.out.println("\n<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3\n");
		    		
		    		input.close();
		    		programOn = false;
		    		
		    		//Terminates entire program
		        	System.exit(EXIT);	
		        	
		    	} //end If Statement
			 
		   
		    	
		    	
 	   //Arrays for userCommands:
			 String petOptions = petMenu[userChoice-1];
			 
	    	 System.out.println("You have chosen to " + petOptions + " " + petName + "!\n");

	if(userChoice == 1) {
	
		    		
		    	}
			
    	
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

	} 
    while(programOn==true || userChoice != EXIT);//while loop
	
}//end main
	
}//end TamagotchiGame