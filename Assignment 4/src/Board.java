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

public class Board {
	
	private String[][] guesses;
	private String blankGuess;
	private SecretCode code;
	
	
	public Board( SecretCode newCode ) {
		
		guesses = new String[ Game.GUESSES_ALLOWED + 1 ][ 2 ];
		blankGuess = generateBlankGuess();
		code = newCode;
		
		for( int index = 0; index <= Game.GUESSES_ALLOWED; index++ ) {
			guesses[ index ][ 0 ] = ( blankGuess );
			guesses[ index ][ 1 ] = " ";
		}
		
		guesses[ 0 ][ 1 ] = "Secret Code";
		
	}
	
	public boolean addGuess( Guess guess, int currentGuess ) {
		
		guesses[ currentGuess + 1 ][ 0 ] = guess.toString();
		guesses[ currentGuess + 1 ][ 1 ] = "Result:" + guess.getFeedback( code );
		
		
		currentGuess++;
		
		boolean gameOver;
		
		if( guess.winner() ) {
			gameOver = true;
		}
		
		else {
			gameOver = false;
		}
		
		return gameOver;
		
	}
	
	public void display() {
		
		StringBuilder result = new StringBuilder();
		
		for( int index = 0; index < Game.GUESSES_ALLOWED; index++ ) {
			result.append( guesses[ index ][ 0 ] + " ");
			result.append( guesses[ index ][ 1 ] + "\n");
		}
		
		System.out.println(result);
	}
	
	private String generateBlankGuess() {
		
		StringBuilder result = new StringBuilder();
		
		for( int index = 0; index < Game.PEGS; index++ ) {
			result.append( '.' );
		}
		
		return result.toString();
		
	}
}
