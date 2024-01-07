//WATCHOVER: The Tamagotchi Game Final Version - Users will be able to take care of their own pet of their choosing
// and take care of it with different command options like eat, sleep, play, nurture, etc.
//Text-Based Pet Adventure featuring ASCII ART (Credit to: https://www.asciiart.eu/text-to-ascii-art)
//Prob gonna add leveling system, inventory and money system, dress up option, more weird pets, etc. for fun
//November 27, 2023
//Programmed by Tierra Doughty
//Dedicated to J.L. because you really helped me alot :DDDD

//Everything I am importing for this program although some are not used right now:
	import java.util.*;
	import java.util.Scanner;
	import java.time.format.DateTimeFormatter;  
	import java.time.LocalDateTime;
	import java.io.*;
    import java.util.Random;

//Tried to be ambitious and use an enum to store the pet types and modified stats (made my own data type):
enum petStats {
	
		// Lists each of the following pet types and the modified stats that will be applied to the array petLevels
		// Each number in the initialized enum is not the starting stat itself but modifiers that will adjust, based on the starting pet of choice
		// Each number will be added on or subtracted from a starting stat of 10
		    DOG(-5, 0, -10, -3, -12, 2, 1, 1, 1, 1),
		    CAT(-8, 0, -3, -18, 0, 2, 1, 1, 2, 1),
		    DRAGON(-8, 0, -7, -6, 0, 3, 1, 4, 1, 2),
		    BLACKVOID(-13, -17, -7, -3, -11, 5, 1, 1, 1, 1),
			BIRB(-9, -8, -14, -2, 0, 1, 1, 2, 2, 2),
			HAMSTER(-2, -18, -9, -1, -5, 3, 3, 2, 2, 1);

		//Initialized all the private stat variables (ints) for each pet alongside their rate of decay (doubles):
		    private final int hunger;
		    private final int sleepiness;
		    private final int cleanliness;
		    private final int nurture;
		    private final int fun;

		  //Decay Rates:
		    private final int hungerDecay;
		    private final int cleanlinessDecay;
		    private final int sleepinessDecay;
		    private final int funDecay;
		    private final int nurtureDecay;
		    
		    //petStats which utilizes all the stats and decay rates established:
		    petStats(int hunger, int sleepiness, int cleanliness, int nurture, int fun, int hungerDecay, int cleanlinessDecay, int sleepinessDecay, int funDecay, int nurtureDecay) {
		        this.hunger = hunger;
		        this.sleepiness = sleepiness;
		        this.cleanliness = cleanliness;
		        this.nurture = nurture;
		        this.fun = fun;
		        this.hungerDecay = hungerDecay;
		        this.cleanlinessDecay = cleanlinessDecay;
		        this.sleepinessDecay = sleepinessDecay;
		        this.funDecay = funDecay;
		        this.nurtureDecay = nurtureDecay;
		    }
		    
		    //Getter for hunger:
		    public int getHunger() {
		        return hunger;
		    }

		    //Getter for sleep:
		    public int getSleepiness() {
		        return sleepiness;
		    }
		    
		    //Getter for clean:
		    public int getCleanliness() {
		        return cleanliness;
		    }

		    //Getter for nurture:
		    public int getNurture() {
		        return nurture;
		    }

		    //Getter for fun:
		    public int getFun() {
		        return fun;
		    }
		    
		    //Getter for Hunger Decay:
		    public int getHungerDecay() {
		        return hungerDecay;
		    }

		    //Getter for Sleep Decay:
		    public int getSleepinessDecay() {
		        return sleepinessDecay;
		    }

		    //Getter for Clean Decay:
		    public int getCleanlinessDecay() {
		        return cleanlinessDecay;
		    }

		    //Getter for Nurture Decay:
		    public int getNurtureDecay() {
		        return nurtureDecay;
		    }

		    //Getter for Fun Decay:
		    public int getFunDecay() {
		        return funDecay;
		    }
		} // End Enum

//Class Pet - Holds all private variables having to do with the pet itself and its stats:
class Pet {
    private String name;
    private int hunger;
    private int cleanliness;
    private int sleepiness;
    private int fun;
    private int nurture;
    private int happiness;
    private final int MAX_STATS = 20;
    private int timeCycle;
    private int timeCycletemp;    
    private int hungerDecay;
    private int cleanlinessDecay;
    private int sleepinessDecay;
    private int funDecay;
    private int nurtureDecay;
    private Scanner asciiArt;
   final private int playerLevelMax = 50;
   private int level;
   

   

	//"throws FileNotFoundException" is just a safety guard against the program possibly not finding the file I want it to because Eclipse doesn't like me ;-;
    public Pet(String name, petStats petType) throws FileNotFoundException {
        this.name = name;
        
       //Gets the unique modifiers from petStats Enum:
        this.hunger = 20 + petType.getHunger() ;
        this.cleanliness = 20 + petType.getCleanliness();
        this.sleepiness = 20 + petType.getSleepiness();
        this.fun = 20 +petType.getFun();
        this.nurture = 20 + petType.getNurture();
        this.happiness = hunger + cleanliness + sleepiness + fun + nurture;
        
        //Gets decay modifiers from petStats enum:
        this.hungerDecay = 1 + petType.getHungerDecay();
        this.cleanlinessDecay = 1 + petType.getCleanlinessDecay();
        this.sleepinessDecay = 1 + petType.getSleepinessDecay();
        this.funDecay = 1 + petType.getFunDecay();
        this.nurtureDecay = 1 + petType.getNurtureDecay();
        
        //Keeps track of all actions made so "time can pass and things can decrement so user has something to do", initialized at 0:
        this.timeCycle = 0;
        this.timeCycletemp = 0;
        
        //Gets specific ASCII art based on what pet the user chooses:
    	this.asciiArt = new Scanner(new File("asciiart/" + petType + ".txt"));
    }

    //All getters and setters:
    public String getName() {
        return name;
    }
    
    public void setName(String newName) {
    	this.name = newName;
    }
    
    public void asciiArt() {
    	while (asciiArt.hasNextLine()){
    	   System.out.println(asciiArt.nextLine());
    	}
    }
    

    public void statDecay() {
    	if (timeCycletemp - timeCycle <= -10) {
    		hunger -= 2 * hungerDecay;
    		cleanliness -= 2 * cleanlinessDecay;
    		sleepiness -= 2 * sleepinessDecay;
    		fun -= 2* funDecay;
    		nurture -= 2* nurtureDecay;
    		level++;
    		
    		//Assigns new time cycle:
    		timeCycletemp = timeCycle; 
    	}
    }
    
    //All methods used for the various stats:
    public void feed() {
    	
        hunger += 3;
        cleanliness -= 2;
        if (hunger > MAX_STATS) {
            hunger = MAX_STATS;
            System.out.println("Looks like " + name + " ate up everything they could! They look satisfied!");
        } else {
        	System.out.println(name + " enjoyed a nice, warm meal. Looks tasty!");
        }
        timeCycle += 2;
    }

    public void rest() {
        sleepiness += 3;
        nurture += 2;
        if (sleepiness < MAX_STATS) {
            sleepiness = MAX_STATS;
            System.out.println(name + " woke up feeling well rested. Looks like they've got a lot of energy now!");
            nurture += 2;
        } else {
        	System.out.println(name + " took a nice nap. Seems like they don't wanna get up...");
        }
        timeCycle += 5;
    }

    public void clean() {
        cleanliness += 3;
        nurture += 2;
        fun -= 3;
        if (cleanliness > MAX_STATS) {
        	System.out.println(name +" is squeaky clean. It almost looks like they're glowing!");
            cleanliness = MAX_STATS;
        } else {
        	System.out.println(name + " is feeling refreshed. Looks like they enjoyed their bath.");
        }
        timeCycle += 3;
    }

    public void nurture() {
        nurture += 4;
        cleanliness += 2;
        if (nurture > MAX_STATS) {
        	System.out.println(name + " is thoroughly nurtured and their eyes glow a soft white like fresh eggshells. They feel safe in your massive arms!");
            nurture = MAX_STATS;
        } else {
        	System.out.println(name + " is properly cared for. They give you a blinding smile and a thumbs up.");
        }
        timeCycle += 3;
    }

    public void play() {
        fun += 8;
        hunger -= 2;
        cleanliness -= 2;
        sleepiness -= 2;
        if (fun > MAX_STATS) {
        	fun = MAX_STATS;
        	System.out.println(name + " is having a blast! They love spending time with you!");
        	
        } else {
        	System.out.println(name + " seems to be having a lot of fun, they looks so happy!");
        }
        timeCycle += 2;
       }
    
    public void look() {
    	asciiArt();
    	displayStats();
    	System.out.println("You take a good look at your buddy, " + name + ". They look back at you, probably.");
    	timeCycle += 5;
    }
    
    public void playerLevel() {
        if (happiness >= 75 && level < playerLevelMax) {
        	 level++;
         System.out.println("Congratulations! You have reached Level " + level);
          
            // Initialized at 0 while max is 50
            if (level == 5) {
                System.out.println("You have now unlocked the Dress Up option under the Play Action.");
                System.out.println("The more your player level increases, the more outfits you can unlock.");
            }

            if (level >= playerLevelMax) {
                level = playerLevelMax;
                System.out.println("Congratulations! You have reached Level " + playerLevelMax + ", max level achieved!");
            }
        }
    }
     
    	
    public void dressUp() {
        // Check if the player has reached the required level to unlock Dress Up
    	  if (level >= 5) {
              System.out.println("You can now dress up your character!");
              // Implement the logic to choose outfits here
              String[] petOutfits = {"Red Beret (common)", " Red Sunglasses (common)","Blue Sunglasses (common)", "Green Sunglasses (common)","Yellow Sunglasses (common)", "Purple Sunglasses (common)", "Golden Leash (uncommon)", "Flower Crown (common)", "24k crown (rare), Pearl Necklace (rare)"};
              
              String randomOutfit = getRandomOutfit(petOutfits);

              // Print result
              System.out.println(randomOutfit + " has been added to your wardrobe. Every time you level up, you will receive an outfit. Outfits range from common to rare!");
              
             // String[] Wardrobe = {};
          } else {
              System.out.println("\nYou need to reach Level 5 to unlock the Dress Up option.");
          }
    }

    //get outfits
    private String getRandomOutfit(String[] outfits) {
    	 if (outfits == null || outfits.length == 0) {
             return null;
         }
    	
        Random random = new Random();
        int randomIndex = random.nextInt(outfits.length);
        return outfits[randomIndex];
    }

    
//Method Displays Current Stats:
    public void displayStats() {
    	
    //Cute little borders for organizational purposes:
		System.out.println("\n<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3\n");
    	
    	//Displays current pet stats:
        System.out.println("Pet: " + name);
        asciiArt();
        System.out.println("\nHunger: " + hunger);
        System.out.println("\nCleanliness: " + cleanliness);
        System.out.println("\nSleepiness: " + sleepiness);
        System.out.println("\nFun: " + fun);
        System.out.println("\nNurture: " + nurture);
        System.out.println("\nHappiness: " + happiness);
        
        //Cute little borders for organizational purposes:
		System.out.println("\n<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3\n");
    }
    
    public void checkStats() {
    	//Updates Happiness stat
    	happiness = hunger + cleanliness + sleepiness + fun + nurture;
    	//Prints if happiness is 100:
        if(happiness == 100 ) {
	    	System.out.println("Happiness all maxed out. It looks like " + name + "is in pristine, top-notch shape. You're a natural at this!");
	    }
	    
       //Prints if at least one stat is equaled to 10:
	    if(hunger==10 || sleepiness==10 || cleanliness==10 || nurture==10 || fun==10) {
	    	System.out.println("It looks like " + name + " needs your attention. Try looking at their stats to determine what " + name +  " needs.\n");
	    }
	    
	   //Prints if at least one stat is equaled to 5:
	    if(hunger==5 || sleepiness==5 || cleanliness==5 || nurture==5 || fun==5) {
	    	System.out.println("It looks like " + name + " really needs your attention. Please try looking at their stats to determine what " + name +  " needs.");
	    }
	    
	   //Prints if at least one stat is equaled to 0:
	    if(hunger==0 || sleepiness==0 || cleanliness==0 || nurture==0 || fun==0) {
	    	System.out.println(name + " needs your attention. Try looking at their stats to determine what " + name +  " needs.");
	    }
	    
	    //If Statement if ALL petLevels are 0 - GAME OVER:
	    if(happiness <= 0) {
	    	happiness = 0;
	    	System.out.println(name + " has been neglected. " + name + "'s eyes turn bright red while you begin to levitate in the air and feel the world around you turn cold. Game over! ");
	    	System.exit(-1);
	    }
    }
}

//TamagotchiExample Class and main method:
public class TamagotchiExample {
    public static void main(String[] args) throws FileNotFoundException {
    	
    	//intialized as true until player exits game:
    			boolean programOn = true; 
    	    	int userChoice;
    	    	
    	    //exit code so the user can type this to end the program:
    	    	int EXIT = -1; 

    	//Create a Scanner called scanner to get user input:
        Scanner input = new Scanner(System.in);
    	
        //Cute little borders for organizational purposes:
		System.out.println("\n<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3\n");
		
		//Painful to implement but this displays the title text screen:
		String filePath = "asciiart/title.txt";

		//Exception Handling for ASCII Art:
		
		// Defines a block of code to be tested for errors while it is being executed
        try {
            //Create a Scanner to read the contents of the text file:
            Scanner asciiArtScanner = new Scanner(new File(filePath));

            //Print each line from the file:
            while (asciiArtScanner.hasNextLine()) {
                String line = asciiArtScanner.nextLine();
                System.out.println(line);
            }
            asciiArtScanner.close();
            
            //Defines a block of code to be executed, if an error occurs in the try block:
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
   

        //Print lines for a welcome banner, message and introduction:
        	System.out.println("\nHello, welcome to WATCHOVER, the totally not copyrighted name from another game,\nnot Pokemon-like, "
        			+ "and definitely unique version of the iconic Tamagotchi game from the 90s!");

        	
        	System.out.println("\nThis game allows you to choose a pet of your own and take care of it! Yay, responsibility!");
        	
        //The One and Only:
        	System.out.println("\nProgrammed by: Tierra Doughty (Tee)\n");
        	        	
        //Dedication to my helper <3
        	System.out.println("Dedicated to J.L.\n");

        	
        //Tamagotchi's usually have the real time and date that constantly updates so I added it for aesthetic purposes and immersion:
        	System.out.println("The local date and time is currently: ");
        	java.util.Date date = new java.util.Date();    
        	System.out.println(date);
        	
        //Cute little borders for organizational purposes:
    		System.out.println("\n<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3\n");

    		System.out.println("\nPlease enter your name to begin: ");
        	String userName = input.nextLine();
        
       //Cute little borders for organizational purposes:
    		System.out.println("\n<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3\n");
    		
    		System.out.println("Hi " + userName + ", Welcome to the WATCHOVER pet shop!\n");
    		System.out.println("My name is Tee and I work here! Let me tell you a little bit about this quirky place. \nWe offer a variety of animals to choose from at no cost. \n\nThese are not just special animals "
    				+ "however, but animals that will be train to grow up one day and become superheroes...or supervillians. \nWe, haha, have had quite of villians lately. "
    				+ "\n\nAnyways- we are looking for responsible individuals that will do their best to nurture these animals \nas they begin growing and discovering their abilities. "
    				+ "\n\nThis responsibility is not for the faint of heart, as these sweetiepies can be a handful.");
    		
        	
        //Create an array of pets from the pets class which takes the data from the petStats enum:
        Pet[] pets = {
                new Pet("Dog\n", petStats.DOG),
                new Pet("Cat\n", petStats.CAT),
                new Pet("Hamster\n", petStats.HAMSTER),
                new Pet("Dragon\n", petStats.DRAGON),
                new Pet("BlackVoid\n", petStats.BLACKVOID),
                new Pet("Birb\n", petStats.BIRB)
                
        };

     //Displays the type of pets a user can choose from for six iterations using a for loop:
    	System.out.println("\nSo! What are you waiting for, go ahead and pick your poison...uh I mean pet!\n");
        for (int i = 0; i < pets.length; i++) {
            System.out.println((i + 1) + ".) " + pets[i].getName());

        }
        
      //Utilizes exit code to terminate the entire program:
    	System.out.println("Type " + EXIT + " to exit the program.\n"); 
    	
        //Cute little borders for organizational purposes:
		System.out.println("\n<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3\n");

		System.out.println("Enter your choice here: ");
        userChoice = input.nextInt();
        
   	  //Simple If Statement for when the user decides to exit the game:
        if(userChoice == EXIT || userChoice == 7) {
  				System.out.println("\nAwwwww, leaving the game so soon. Goodbye!");
        	
  		        //Cute little borders for organizational purposes:
  				System.out.println("\n<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3\n");
    		
  				input.close();
  				programOn = false;
    		
  				//Terminates entire program:
  				System.exit(EXIT);	
        	
    	} //end If Statement
  			
  
        if (userChoice >= 1 && userChoice <= pets.length) {

            // User selected a valid pet:
            Pet selectedPet = pets[userChoice - 1];        	

            // Interaction loop:
            boolean exit = false;
            	System.out.println("Pwease name your pet: \n");
            	
            	// Prompts the user to name their pet in addition to another input.nextLine() which does not eat the space character
            	input.nextLine();  
            	String petName = input.nextLine();
            
                
                System.out.println("\nYour pet's name is " + petName + ". Congratulations!\n");
                
             //Cute little borders for organizational purposes:
        		System.out.println("\n<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3\n");
                System.out.println("Every pet has stats that contribute to their overall happiness.\nIf you take care of your pet, the stats will remain high and their happiness will max out at 100.");
                System.out.println("\nHowever, if you neglect your pet, their happiness will decrease until"
                		+ " you ultimately face their wrath. \nPlease take care of " + petName + ", " + userName + " and good luck!");
                
                selectedPet.setName(petName);
                
            //While Loop to keep the actions a user can do ongoing until they exit the game:
                while (!exit) {
                
            //Cute little borders for organizational purposes:
            System.out.println("\n<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3\n");

                System.out.println("Now, what would you like to do with " + petName + " (Choose an action): \n");
                System.out.println("1.) Feed\n");
                System.out.println("2.) Rest\n");
                System.out.println("3.) Clean\n");
                System.out.println("4.) Nurture\n");
                System.out.println("5.) Play\n");
                System.out.println("6.) Display Stats\n");
                System.out.println("7.) Admire Pet\n");
                System.out.println("8.) Exit\n");

                int action = input.nextInt();
                
                //Switch for all actions:
                switch (action) {
                    case 1:
                        selectedPet.feed();
                        break;
                    case 2:
                        selectedPet.rest();
                        break;
                    case 3:
                        selectedPet.clean();
                        break;
                    case 4:
                        selectedPet.nurture();
                        break;
                    case 5:
                        selectedPet.play();
                        selectedPet.dressUp();
                        break;
                    case 6:
                        selectedPet.displayStats();
                        break;
                    case 7:
                    	selectedPet.look();
                    	break;
                    case 8:	
                        exit = true;
          				System.out.println("\nAwwwww, leaving the game so soon. Goodbye!");
          	        	
          		    //Cute little borders for organizational purposes:
          				System.out.println("\n<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3===<3\n");
            		
          		      //Close Scanner to save resources:
          				input.close();
          				
          				programOn = false;
            		
          				//Terminates the entire program:
          				System.exit(EXIT);	
                        break;
                    default:
                        System.out.println("Invalid action. Please choose a valid action.");
                } 
                selectedPet.checkStats();
                selectedPet.playerLevel();
                selectedPet.statDecay();
            }
        } else {
            System.out.println("Invalid choice. Please choose a pet from the list.");
        }

      //Close Scanner to save resources:
        input.close();
        
    }//end main

}//end TamagotchiExample