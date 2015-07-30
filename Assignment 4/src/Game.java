import java.util.*;

/*  Student information for assignment:
*
*  On my honor, Lancie Menchu, this programming assignment is my own work
*  and I have not provided this code to any other student.
*
*  Number of slip days used: 1
*
*  UTEID: lam4356
*  email address: lancie.menchu@utexas.edu
*  Grader name: Chris
*  Section number: 53329
*  
*/

public class Game {
	
	public static final int PEGS = 4;		// The number of peg options
	public static final int GUESSES_ALLOWED = 12;	// The total number of allowable guesses	
	//to add additional colors, see the Colors enum class

	// if showCode is true then the secret code is revealed before
	// the gane starts. This will be used by graders of the program
	// to test the feedback of guesses
    private boolean showCode;
	private SecretCode code;

    public Game( boolean easy ) {
    	
        showCode = easy;
        
    }

    public void runGames() {
        
    	Scanner keyboard = new Scanner( System.in );
    	newGame( keyboard );
    	
    	System.out.print("Enter Y for another game or anything else to quit: ");
    	String input = keyboard.next();
    	while( input.equalsIgnoreCase( "Y" ) ) {
    		System.out.print("Enter Y for another game or anything else to quit: ");
        	input = keyboard.next();
    	}
	
    }
    
    private void newGame( Scanner keyboard ) {
    	
    	code = new SecretCode();
        Board gameBoard = new Board( code );
        boolean gameOver = false;
        
    	
    	this.intro();
    	
    	for( int guess = 0; guess < GUESSES_ALLOWED; guess++ ) {
    		
    		if( gameOver ) {
    			System.out.println("You solved the puzzle! Good job.");
    			break;
    		}
    		
    		System.out.println("You have " + ( GUESSES_ALLOWED - guess ) + " guesses left.\n" );
    		gameOver = gameBoard.addGuess( getGuess( keyboard ), guess );
    		System.out.println();
    		displayCode();
    		System.out.println(); 
    		gameBoard.display();
    		System.out.println();    		
    		
    	}
    	
    	if( !gameOver ) {
    		
    		System.out.println( "You did not solve the puzzle. Too bad." );
    		
    	}
    	
    }
    
    private void intro() {
    	
    	String intro =
    			"Welcome to Mastermind.\n" +
    			"\n" +
    			"This is a text version of the classic board game Mastermind.\n" +
    			"The computer will think of a secret code.\n" +
    			"The code consists of 4 colored pegs.\n" +
    			"The pegs may be one of six colors: blue, green , orange, purple, red, or yellow.\n" +
    			"A color may appear more than once in the code.\n" +
    			"\n" +
				"You try to guess what colored pegs are in the code and what order they are in\n" +
				"After making a guess the result will be displayed.\n" +
				"A result consists of a black peg for each peg you have exactly correct (color and position) in your guess.\n" +
				"For each peg in the guess that is the correct color, but is out of position, you get a white peg.\n" +
				"\n" +
				"Only the first letter of the color is displayed. B for Blue, R for Red, and so forth.\n" +
				"When entering guesses you only need to enter the first character of the color as a capital letter.\n" +
				"\n" +
				"You have 12 to guess the answer or you lose the game.\n";
    	
    	System.out.println(intro);
    	System.out.println( "Generating secret code ...." );
    	displayCode();
        
    	
    	
    }
    
    private void displayCode() {
    	
    	if( showCode ) {
    		System.out.println( "The secret code is " + code.toString() );
    	}
    	
    }
    
    private Guess getGuess( Scanner keyboard ) {
    	
    	Colors[] result = new Colors[ PEGS ];
    	
        System.out.println("What is your next guess?");
        System.out.println("Type in the characters for your guess and press enter.");
        System.out.print("Enter guess: ");
    	
        String guess = keyboard.next();
        char[] modGuess = guess.toCharArray();
        
        while( !validGuess( modGuess ) ) {
        	System.out.println("\nWhat is your next guess?");
            System.out.println("Type in the characters for your guess and press enter.");
            System.out.print("Enter guess: ");
        }
        
        for( int index = 0; index < PEGS; index++ ) {
        	result[ index ] = Colors.getColor( modGuess [ index ] );
        }
        return new Guess( result );
        
    }
    
	public boolean validGuess( char[] input ) {
		
		boolean valid = true;
		
		if( input.length != Game.PEGS ) {
			valid = false;
		}
		
		for( char current : input ) {
			if( Colors.validColor( current ) ) {
				valid = true;
				break;
			}
		}
		
		return valid;
		
	}
    		
    	
}