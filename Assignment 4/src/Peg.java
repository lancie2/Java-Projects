
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

public class Peg {
	
	private Colors color;
	private int posistion;
	
	// Create a Peg of a color defined by the user
	public Peg( Colors userColor, int userPosistion ) {
		
		color = userColor;
		posistion = userPosistion;
		
	}
	
	// Return the color of the peg
	public Colors color() {  
		
		return color;
		
	}
	
	// Returns the posistion of the peg
	public int posistion() {
	
		return posistion;
		
	}
}
