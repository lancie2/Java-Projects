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

public enum Colors {
	// All non-guessable colors (ie: feedback pegs) must be listed first
	W (false, "White",	'W'),
	K (false, "Black",	'K'),
	B (true,  "Blue" ,	'B'),
	G (true,  "Green",  'G'),
	O (true,  "Orange", 'O'),
	P (true,  "Purple", 'P'),
	R (true,  "Red",    'R'), 
	Y (true,  "Yellow", 'Y');
	
	private static int NUM_COLORS = 8; // tracked manually, keep in sync with actual value
	private final boolean guessable;
	private final String fullName;
	private final char shortName;
	
	Colors( boolean guessable, String fullName, char shortName ) {
	
		this.guessable = guessable;
		this.fullName = fullName;
		this.shortName = shortName;
		
	}
	
	// Returns true if color is able to be used in a guess
	public boolean isGuessable() {
		
		return guessable;
		
	}
	
	// Returns the number of colors able to be used in a guess
	public static int numGuessable() {
	
		int counter = 0;
		
		for( Colors current : Colors.values() ) {
			if( current.isGuessable() ) {
				counter++;
			}
		}
		
		return counter;
		
	}
	
	// Returns the color as a string
	public String toString() {
	
		return fullName;
		
	}
	
	// Return the color as a char
	public char toChar() {
	
		return shortName;
		
	}
	
	public static Colors getColor( char input ) {
			
			switch( input ) {
				case 'B' : return Colors.B;
				case 'G' : return Colors.G;
				case 'O' : return Colors.O;
				case 'P' : return Colors.P;
				case 'R' : return Colors.R;
				case 'Y' : return Colors.Y;
				default : return null;
			}
	}
        		
        
	
	// Checks to see if color 
	public static boolean validColor( char input ) {
	
		boolean valid = false;
		
		for( Colors current : Colors.values() ) {
			if( input == current.toChar() ) {
				valid = true;
			}
		}
		
		return valid;
	}
	
}
