import java.util.*;

public class Blackjack {

    public static void main(String args[]) {

        Scanner scanny = new Scanner(System.in);    //user input for choosing from menu
        Scanner aceScan = new Scanner(System.in);	//user input for choosing which value an ace holds
        int choice = 0;                             //hit, stand, shows stats, or exit based on input
        int aceChoose = 0;							//determine whether an ace counts as a 1 or 11
        double gameNumber = 1;                      //number shown in "START GAME #X"
        double playerWins = 0;                      //number of times the player wins
        int dealerWins = 0;                         //number of times the dealer wins
        int tieGames = 0;                           //number of tied games
        int playerHand = 0;                         //Sum of cards in player's current hand
        boolean success = false;					//allows for error checking when choosing the value of an ace

        while (true) {  //allows for successive games

            Random randomNumber1 = new Random();					//creates random number object used for the rest of the game
            System.out.println("START GAME #" + (int)gameNumber);
            System.out.println("");
            playerHand = randomNumber1.nextInt(13 - 1 + 1) + 1; 	//starting card #

            switch (playerHand) {   //in case of each card number        

                case 1: {			//user must choose whether to count the ace as a 1 or an 11
                	
                	success = false;					
                    System.out.println("Your card is an ACE!");
                    System.out.print("Enter 1 or 11 to choose which value your ace will hold: ");
                    
                    while (!success) {	//will exit while loop when user enters a 1 or an 11
                    try {
                        aceChoose = aceScan.nextInt();
                        success = true;

                    } catch (InputMismatchException e) {	//catches any input that is not an integer and allows the user to select again

                    	System.out.println("Invalid input!");
                    	System.out.print("Please enter either 1 or 11 as your selection: ");
                    	aceScan.nextLine();
                    	continue;

                    }
                 
                    if (aceChoose == 11) {					//if user chooses to count the ace as an 11
                    	playerHand = 11;
                    	System.out.println("Okay, your ace is an 11!");
                    	System.out.println();
                    	break;
                    }
                    
                    else if (aceChoose == 1) {				//if user chooses to count the ace as a 1
                    	playerHand = 1;
                    	System.out.println("Okay, your ace is a 1!");
                    	System.out.println();
                    	break;
                    }
                    
                    else {									//if the user enters an integer that is not a 1 or an 11
                    	System.out.println("Invalid input!");
                    	System.out.print("Please enter either 1 or 11 as your selection: ");
                    	aceScan.nextLine();
                    	success = false;					//restarts the while loop
                    	continue;
                    }
               }  
                    break;
          }                  
                case 2: {
                    System.out.println("Your card is a 2!");
                    break;
                }
                case 3: {
                    System.out.println("Your card is a 3!");
                    break;
                }
                case 4: {
                    System.out.println("Your card is a 4!");
                    break;
                }
                case 5: {
                    System.out.println("Your card is a 5!");
                    break;
                }
                case 6: {
                    System.out.println("Your card is a 6!");
                    break;
                }
                case 7: {
                    System.out.println("Your card is a 7!");
                    break;
                }
                case 8: {
                    System.out.println("Your card is a 8!");
                    break;
                }
                case 9: {
                    System.out.println("Your card is a 9!");
                    break;
                }
                case 10: {
                    System.out.println("Your card is a 10!");
                    break;
                }
                case 11: {
                    playerHand = 10;
                    System.out.println("Your card is a JACK!");
                    break;
                }
                case 12: {
                    playerHand = 10;
                    System.out.println("Your card is a QUEEN!");
                    break;
                }
                case 13: {
                    playerHand = 10;
                    System.out.println("Your card is a KING!");
                    break;
                }

            }

            System.out.println("Your hand is : " + playerHand); 
            Menu();

            while (true) {    //allows for successive moves in 1 game

                try {							//catches input that is not an integer
                    choice = scanny.nextInt();

                } catch (InputMismatchException e) {

                	System.out.println("");
                    System.out.println("Invalid input!\nPlease enter an integer value between 1 and 4.");
                    Menu();
                    scanny.nextLine();
                    continue;

                }

                if (choice == 1) {      //user chooses to hit
                    Random randomNumber2 = new Random();
                    int hit = randomNumber2.nextInt(13 - 1 + 1) + 1; //randomly chooses next card

                    switch (hit) {      		//in case of each number generated for next hit
                    
                        case 1: {				//operates exactly like the first one, except for adding the value of the card
                        	success = false;	//to the player's hand instead of replacing it		
                        	System.out.println("Your card is an ACE!");
                            System.out.print("Enter 1 or 11 to choose which value your ace will hold: ");
                            
                            while (!success) {
                            try {
                                aceChoose = aceScan.nextInt();
                                success = true;

                            } catch (InputMismatchException e) {

                            	System.out.println("Invalid input!");
                            	System.out.print("Please enter either 1 or 11 as your selection: ");
                            	aceScan.nextLine();
                            	continue;

                            }
                         
                            if (aceChoose == 11) {
                            	playerHand += 11;	//difference from the first version of the choice
                            	System.out.println("Okay, your ace is an 11!");
                            	System.out.println();
                            	break;
                            }
                            
                            else if (aceChoose == 1) {
                            	playerHand += 1;	//difference
                            	System.out.println("Okay, your ace is a 1!");
                            	System.out.println();
                            	break;
                            }
                            
                            else {
                            	System.out.println("Invalid input!");
                            	System.out.print("Please enter either 1 or 11 as your selection: ");
                            	aceScan.nextLine();
                            	success = false;
                            	continue;
                            }
                       }  
                            break;
                  }
                        case 2: {
                            playerHand += hit;
                            System.out.println("\nYour card is a 2!");
                            break;
                        }
                        case 3: {
                            playerHand += hit;
                            System.out.println("\nYour card is a 3!");
                            break;
                        }
                        case 4: {
                            playerHand += hit;
                            System.out.println("\nYour card is a 4!");
                            break;
                        }
                        case 5: {
                            playerHand += hit;
                            System.out.println("\nYour card is a 5!");
                            break;
                        }
                        case 6: {
                            playerHand += hit;
                            System.out.println("\nYour card is a 6!");
                            break;
                        }
                        case 7: {
                            playerHand += hit;
                            System.out.println("\nYour card is a 7!");
                            break;
                        }
                        case 8: {
                            playerHand += hit;
                            System.out.println("\nYour card is a 8!");
                            break;
                        }
                        case 9: {
                            playerHand += hit;
                            System.out.println("\nYour card is a 9!");
                            break;
                        }
                        case 10: {
                            playerHand += hit;
                            System.out.println("\nYour card is a 10!");
                            break;
                        }
                        case 11: {
                            playerHand += 10;
                            System.out.println("\nYour card is a JACK!");
                            break;
                        }
                        case 12: {
                            playerHand += 10;
                            System.out.println("\nYour card is a QUEEN!");
                            break;
                        }
                        case 13: {
                            playerHand += 10;
                            System.out.println("\nYour card is a KING!");
                            break;
                        }
                    }
                    
                    if (playerHand > 21) {  //dealer wins because player busted
                        System.out.println("Your hand is: " + playerHand + "\nYou exceeded 21!  You lose :(");
                        gameNumber = ++gameNumber;	//increase the amount of games by one
                        dealerWins = ++dealerWins;	//increase the amount of dealer wins by one
                        break;
                    }
                    if (playerHand == 21) { //player has 21
                        System.out.println("Your hand is: " + playerHand + "\nBLACKJACK! You win!");
                        gameNumber = ++gameNumber;	//increase the amount of games by one
                        playerWins = ++playerWins;	//increase the amount of player wins by one
                        break;
                    }
                    if (playerHand < 21) {	//nobody has won yet, player must make another choice
                        System.out.println("Your hand is : " + playerHand); //menu after each hit
                        Menu();
                    }
                } 
                
                else if (choice == 2) {	//user chooses to stand
                    int dealerHand = randomNumber1.nextInt((26 - 16) + 1) + 16; //creates dealer hand
                    System.out.println("");
                    System.out.println("Dealer's hand: " + dealerHand);
                    System.out.println("Your hand is: " + playerHand);

                    if (dealerHand > playerHand && dealerHand <= 21) {  //dealer wins because they are closer to 21
                        System.out.println("");
                        System.out.println("Dealer wins!");
                        System.out.println("");
                        gameNumber = ++gameNumber;      //increments gameNumber for next game
                        dealerWins = ++dealerWins;      //increments dealerWins for stats
                        break;
                    }
                    if (dealerHand == playerHand) {     //tie
                        System.out.println("");
                        System.out.println("It's a tie! No one wins!");
                        System.out.println("");
                        gameNumber = ++gameNumber;      //increments gameNumber for next game
                        tieGames = ++tieGames;          //increments tieGames for stats
                        break;
                    }
                    if (dealerHand > 21) {      //player wins because dealer busts
                        System.out.println("");
                        System.out.println("You win!");
                        System.out.println("");
                        gameNumber = ++gameNumber;  //increments gameNumber for next game
                        playerWins = ++playerWins;  //increments playerWins for stats
                        break;
                    }
                    if (playerHand > dealerHand) {  //dealer wins because player busts
                        System.out.println("");
                        System.out.println("You win!");
                        System.out.println("");
                        gameNumber = ++gameNumber;  //increments gameNumber for next game
                        playerWins = ++playerWins;  //increments playerWins for stats
                        break;
                    }
                    break;
                } 
                
                else if (choice == 3) {      //shows stats of games
                	
                	int statGameNum = (tieGames + (int)playerWins + dealerWins);		//number of games used for calculations and game stats
                    double percentPlayerWins = ((playerWins / statGameNum) * 100);		//calculates the percent of player wins
                    System.out.println("");
                    System.out.println("Number of Player wins: " + (int)playerWins);	//shows player wins
                    System.out.println("Number of Dealer wins: " + dealerWins);			//shows dealer wins
                    System.out.println("Number of tie games: " + tieGames);				//shows tie games
                    System.out.println("Total # of games played is: " + statGameNum);	//shows the total number of games played
                    System.out.print("Percentage of Player wins: ");	
                    System.out.printf("%.1f", (double) (percentPlayerWins));			//shows the percentage of player wins to the tenths place
                    System.out.println("%");
                    Menu();
                    continue;
                } 
                
                else if (choice == 4) {  //exits game
                    System.exit(1);
                    break;
                } 
                
                else  {     //if non-valid integer is entered for choice
                    System.out.println("Invalid input!\nPlease enter an integer value between 1 and 4.");
                    Menu();
                }
            }
        }
    }
    
    public static void Menu() {	//this method prints the game's menu
    	System.out.println("");
        System.out.println("1. Get another card");
        System.out.println("2. Hold hand");
        System.out.println("3. Print statistics");
        System.out.println("4. Exit");
        System.out.println("");
        System.out.print("Choose another option: ");
    }
}