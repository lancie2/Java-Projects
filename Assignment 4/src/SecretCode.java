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

public class SecretCode {

	private ArrayList<Peg> secretCode;
	private int size;
	
	public SecretCode() {
	
		secretCode = new ArrayList<Peg>();
		size = Game.PEGS;
		
		Random generator = new Random();
		
		for( int index = 0; index < Game.PEGS; index++ ) {
			int colorSelect = generator.nextInt( Colors.numGuessable() ) + 2;
			Colors randomColor = Colors.values()[ colorSelect ];
			secretCode.add(new Peg( randomColor, index ) );
		}
		
	}

	public int size() {
	
		return secretCode.size();
		
	}
	
	public Peg get( int posistion ) {
		
		return secretCode.get( posistion );
		
	}
	
	public String toString() {
		
		StringBuilder result = new StringBuilder();
		
		for( int index = 0; index < size; index++ ) {
			result.append( secretCode.get( index ).color().toChar() );
		}
		
		return result.toString();
		
	}
	
}

