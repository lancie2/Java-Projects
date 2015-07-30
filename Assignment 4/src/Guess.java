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

public class Guess {
	
	private ArrayList<Peg> guess;
	private int blacks;
	
	public Guess( Colors[] userGuess ) {
	
		guess = new ArrayList<Peg>( Game.PEGS );
	
		for( int index = 0; index < Game.PEGS; index++ ) {
			guess.add( new Peg( userGuess[ index ], index ) );
		}
		
		blacks = 0;
		
	}
	
	public String getFeedback( SecretCode code ) {
		
		boolean white = false;
		boolean black = false;
		
		int whiteCount = 0;
		int blackCount = 0;
		
		StringBuilder result = new StringBuilder();
		
		for( int indexGuess = 0; indexGuess < Game.PEGS; indexGuess++ ) {
			white = false;
			black = false;
			
			for( int indexCode = 0; indexCode < Game.PEGS; indexCode++ ) {
				if( guess.get( indexGuess ).color() == code.get( indexCode ).color() && !white && !black ) {
					white = true;
					if( indexGuess == indexCode ) {
						black = true;
					}
				}
			}
			
			if( black ) {
				result.append( " Black" );
			}
			
			if( white & !black ) {
				whiteCount++;
			}
			
		}
		
		blacks = blackCount;
		
		for( int index = 0; index < whiteCount; index++ ) {
			result.append( " White" );
		}
		
		if( whiteCount == 0 && !black ) {
			result = new StringBuilder( " No pegs" );
		}
		
		return result.toString();
			
	}
	
	public boolean winner() {
		
		return blacks == Game.PEGS;
		
	}
	

		
	
	public String toString() {
		
		StringBuilder result = new StringBuilder();
		
		for( int index = 0; index < guess.size(); index++ ) {
			result.append( guess.get( index ).color().toChar() );
		}
		
		return result.toString();
		
	}
}
