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

public class MastermindDriver {

    public static void main(String[] args){
        Game g = new Game(true);
        g.runGames();
        g = new Game(false);
        g.runGames();
    }

}
