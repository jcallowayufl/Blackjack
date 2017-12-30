import java.util.*;

public class Blackjack {

    public static void main(String args[]) {

        Scanner scanny = new Scanner(System.in);    //user input for choosing from menu
        Scanner aceScan = new Scanner(System.in);	//user input for choosing which value an ace holds
        int choice = 0;                             //hit, stay, shows stats, or exit based on input
        int aceChoose = 0;							//determine whether an ace counts as a 1 or 11
        double gameNumber = 1;                      //Number shown in "START GAME #X"
        double playerWins = 0;                      //Number of times the player wins
        int dealerWins = 0;                         //Number of times the dealer wins
        int tieGames = 0;                           //Number of tied games
        int playerHand = 0;                         //Sum of cards in player's current hand
        boolean success1 = false;					//allows for repeated try-catch when determining the value of an ace for the first round
        boolean success2 = false;					//allows for repeated try-catch when determining the value of an ace for the second round and after


        while (true) {  //allows for successive games

            Random randomNumber1 = new Random();
            System.out.println("START GAME #" + (int)gameNumber);
            System.out.println("");
            playerHand = randomNumber1.nextInt(13 - 1 + 1) + 1; //starting card #
            playerHand = 1;

            switch (playerHand) {   //in case of each card number

                case 1: {
                    System.out.println("Your card is an ACE!");
                    System.out.print("Enter 1 or 11 to choose which value your ace will hold: ");
                    
                    while (!success1) {
                    try {
                        aceChoose = aceScan.nextInt();
                        success1 = true;

                    } catch (InputMismatchException e) {

                    	System.out.println("Invalid input!");
                    	System.out.print("Please enter either 1 or 11 as your selection: ");
                    	aceScan.nextLine();
                    	continue;

                    }
                 
                    if (aceChoose == 11) {
                    	playerHand = 11;
                    	System.out.println("Okay, your ace is an 11!");
                    	System.out.println();
                    	break;
                    }
                    
                    else if (aceChoose == 1) {
                    	playerHand = 1;
                    	System.out.println("Okay, your ace is a 1!");
                    	System.out.println();
                    	break;
                    }
                    
                    else {
                    	System.out.println("Invalid input!");
                    	System.out.print("Please enter either 1 or 11 as your selection: ");
                    	aceScan.nextLine();
                    	success1 = false;
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

                try {
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
                    //int hit = randomNumber2.nextInt(13 - 1 + 1) + 1; //new card
                    int hit = 1;	//FIXME: used to practice aces

                    switch (hit) {      //in case of each number generated for next hit

                        case 1: {
                        	System.out.println("Your card is an ACE!");
                            System.out.print("Enter 1 or 11 to choose which value your ace will hold: ");
                            aceChoose = aceScan.nextInt();
                            
                            if (aceChoose == 1) {
                            	playerHand += 1;
                            	System.out.println("Okay, your ace is a 1!");
                            	System.out.println();
                            }
                            
                            else if (aceChoose == 11) {
                            	playerHand += 11;
                            	System.out.println("Okay, your ace is an 11!");
                            	System.out.println();
                            }
                            
                            else {
                            	System.out.println("Invalid input!\nPlease enter either 1 or 11 as your selection.");
                            	aceScan.nextLine();
                                continue;
                            }
                            break;
                        }
                        case 2: {
                            playerHand = hit + playerHand;
                            System.out.println("");
                            System.out.println("\nYour card is a 2!");
                            break;
                        }
                        case 3: {
                            playerHand = hit + playerHand;
                            System.out.println("\nYour card is a 3!");
                            break;
                        }
                        case 4: {
                            playerHand = hit + playerHand;
                            System.out.println("\nYour card is a 4!");
                            break;
                        }
                        case 5: {
                            playerHand = hit + playerHand;
                            System.out.println("\nYour card is a 5!");
                            break;
                        }
                        case 6: {
                            playerHand = hit + playerHand;
                            System.out.println("\nYour card is a 6!");
                            break;
                        }
                        case 7: {
                            playerHand = hit + playerHand;
                            System.out.println("");
                            System.out.println("\nYour card is a 7!");
                            break;
                        }
                        case 8: {
                            playerHand = hit + playerHand;
                            System.out.println("\nYour card is a 8!");
                            break;
                        }
                        case 9: {
                            playerHand = hit + playerHand;
                            System.out.println("\nYour card is a 9!");
                            break;
                        }
                        case 10: {
                            playerHand = hit + playerHand;
                            System.out.println("\nYour card is a 10!");
                            break;
                        }
                        case 11: {
                            playerHand = 10 + playerHand;
                            System.out.println("\nYour card is a JACK!");
                            break;
                        }
                        case 12: {
                            playerHand = 10 + playerHand;
                            System.out.println("\nYour card is a QUEEN!");
                            break;
                        }
                        case 13: {
                            playerHand = 10 + playerHand;
                            System.out.println("\nYour card is a KING!");
                            break;
                        }
                    }
                    if (playerHand > 21) {  //dealer wins because player busted
                        System.out.println("Your hand is: " + playerHand + "\nYou exceeded 21!  You lose :(");
                        gameNumber = ++gameNumber;
                        dealerWins = ++dealerWins;
                        break;
                    }
                    if (playerHand == 21) { //player BLACKJACK
                        System.out.println("Your hand is: " + playerHand + "\nBLACKJACK! You win!");
                        gameNumber = ++gameNumber;
                        playerWins = ++playerWins;
                        break;
                    }
                    if (playerHand < 21) {
                        System.out.println("Your hand is : " + playerHand); //menu after each hit
                        Menu();
                    }
                } 
                
                else if (choice == 2) {
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
                    double percentPlayerWins = ((playerWins / gameNumber) * 100);
                    System.out.println("");
                    System.out.println("Number of Player wins: " + (int)playerWins);
                    System.out.println("Number of Dealer wins: " + dealerWins);
                    System.out.println("Number of tie games: " + tieGames);
                    System.out.println("Total # of games played is: " + (int)gameNumber);
                    System.out.print("Percentage of Player wins: ");
                    System.out.printf("%.1f", (double) (percentPlayerWins));
                    System.out.println("%");
                    Menu();
                    continue;
                } 
                
                else if (choice == 4) {  //exits game
                    System.exit(1);
                    break;
                } 
                
                else  {     //if non-valid integer is entered
                    System.out.println("Invalid input!\nPlease enter an integer value between 1 and 4.");
                    Menu();
                }
            }
        }
    }
    
    public static void Menu() {	//method prints the menu
    	System.out.println("");
        System.out.println("1. Get another card");
        System.out.println("2. Hold hand");
        System.out.println("3. Print statistics");
        System.out.println("4. Exit");
        System.out.println("");
        System.out.print("Choose another option: ");
    }
}