import java.util.*;
/**
 * Author: Lancie Menchu
 * Date: 10/25/2012
 * CS 312 Assignment #6
 * 
 * EID: lam4356
 * Section: 52715
 * 
 * This program is designed to play a game of Rock Paper Scissors.
 * 
 * Slip days used for this project: 0  Slip days used (total): 0
 * 
 */


 
public class RockPaperScissors {
    
    //declare static global constants to be used throughout program
    public static final int rock = 1;
    public static final int paper = 2;
    public static final int scissors = 3;

    public static void main(String[] args) {
        runGame();
    }
    
    public static void runGame() {
        //create objects to be used in the game
        Scanner read = new Scanner(System.in);
        Random generator = new Random();
        
        //get username
        String userName = getUserName(read);

        //get number of rounds
        int rounds = getRounds(read, userName);
        
        //play the game!
        playGame(read, generator, userName, rounds);
    }

    
    //intro to the game and prompt for username, returns username as a string
    public static String getUserName(Scanner read) {
        System.out.println("Welcome to Rock Paper Scissors. I, the computer, will be your opponent.");
        System.out.print("Please type in your name and press return: ");
        return read.nextLine();
    }
    
    //prompt for number of rounds, return as an int
    public static int getRounds(Scanner read, String userName) {
        System.out.println("\nWelcome " + userName);
        System.out.println("All right " + userName + ". How many games would you like to play?");
        System.out.print("Enter the number of rounds you want to play and press return: ");
        return read.nextInt();
    }
    
    //the actual game
    public static void playGame(Scanner read, Random generator, String userName, int rounds) {
        //declare variables
        int playerChoice;
        int cpuChoice;
        int decision;
        int cpuWins = 0;
        int playerWins = 0;
        int draws = 0;
        
        //loop, one iteration for each round
        for(int round = 1; round <= rounds; round++) {
            //announce round
            System.out.println("\n\nRound " + round + ".");
            //prompt for user selection
            System.out.println(userName + ", please enter your choice for this round.");
            System.out.print("1 for rock, 2 for paper, and 3 for scissors: ");
            playerChoice = read.nextInt();
            //generate cpu selection
            cpuChoice = generator.nextInt(3) + 1;
            //display choices
            System.out.println("Computer picked " + choiceType(cpuChoice) + ", " + userName + " picked " + choiceType(playerChoice) +".");
            //determine winner
            decision = determineWin(cpuChoice, playerChoice);
            //display if round is draw
            if(decision == 0) {
                System.out.println("This round is a draw.");
                draws++;
            }
            
            //display if cpu wins
            if(decision == 1) {
                System.out.println(winType(cpuChoice, playerChoice) + "I win.");
                cpuWins++;
            }
            
            //display if player wins
            if(decision == 2) {
                System.out.println(winType(cpuChoice, playerChoice) + "You win.");
                playerWins++;
            }
        }
        
        //display stats of all rounds
        displayStats(draws, cpuWins, playerWins, rounds, userName);
    }
    
    //takes in either cpu or player selection as an int and returns their selection type as a string
    public static String choiceType(int choice) {
        String type = new String();
        switch(choice) {
            case rock: type = "rock"; break;
            case paper: type = "paper"; break;
            case scissors: type = "scissors"; break;
        }
        return type;
    }
    
    //determins a win, returns 0 for draw, 1 for cpu win, 2 for player win
    public static int determineWin(int cpuChoice, int playerChoice) {
        //check for a draw
        if(cpuChoice == playerChoice) {
            return 0;
        }
        //check for cpu win
        if(cpuChoice == rock) {
            if(playerChoice == scissors) return 1;
        }
        if(cpuChoice == paper) {
            if(playerChoice == rock) return 1;
        }
        if(cpuChoice == scissors) {
            if(playerChoice == paper) return 1;
        }
        //if not a draw or cpu win, player wins
        return 2;
    }
    
    //determines how a win occured, ie paper breaks scissors, etc.
    public static String winType(int cpuChoice, int playerChoice) {
        boolean rockTest = false;
        boolean paperTest = false;
        boolean scissorsTest = false;
        
        //There are only four possible outcomes, each assigned to the following strings
        String outcomeDraw = "This round is a draw. ";
        String outcomeRockPaper = "Paper covers rock. ";
        String outcomeRockScissors = "Rock breaks scissors. ";
        String outcomeScissorsPaper = "Scissors cut paper. ";
        
        //verify no draw, then verify which weapons were chosen
        if(cpuChoice != playerChoice) {
            if(cpuChoice == rock || playerChoice == rock) {
                rockTest = true;
            }
            if(cpuChoice == paper || playerChoice == paper) {
                paperTest = true;
            }
            if(cpuChoice == scissors || playerChoice == scissors) {
                scissorsTest = true;
            }
            //knowing which weapons were chosen, choose appropriate outcome
            if(rockTest && paperTest) return outcomeRockPaper;
            if(rockTest && scissorsTest) return outcomeRockScissors;
            if(scissorsTest && paperTest) return outcomeScissorsPaper;
        }
        //if a draw, return nothing.
        return "";
    }
    
    //This method displays the stats of the game, called at end of playGame method
    public static void displayStats(int draws, int cpuWins, int playerWins, int rounds, String userName) {
        if(rounds == 1) {
            System.out.println("\n\nWe played " + rounds + " game of Rock Paper Scissors.");
        }
        
        else {
            System.out.println("\n\nWe played " + rounds + " games of Rock Paper Scissors.");
        }
        //Display final stats of all rounds, note the check for grammar!
        if(cpuWins == 1) {
            System.out.println("The computer won " + cpuWins + " time.");
        }
        else {
            System.out.println("The computer won " + cpuWins + " times.");
        }
        if(playerWins == 1) {
            System.out.println(userName + " won " + playerWins + " time.");
        }
        else {
            System.out.println(userName + " won " +  playerWins + " times.");
        }
         if(draws == 1) {
            System.out.println("There was " + draws + " draw.");
        }
        else {
            System.out.println("There were " + draws + " draws.");
        }
        
        //if player is better than cpu
        if(playerWins > cpuWins) {
            System.out.println("You are a master at Rock, Paper, Scissors.");
        }
        
        //if cpu is better than player
        if(cpuWins > playerWins) {
            System.out.println("I am a master at Rock, Paper, Scissors.");
        }
        
        //if cpu and player are evenly matched
        if(playerWins == cpuWins) {
            System.out.println("We are evenly matched at this game.");
        }
    }
}
