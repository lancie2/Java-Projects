
/**
 * Author: Lancie Menchu
 * Date: 09/02/2012
 * CS 312 Assignment 1
 * 
 * EID: lam4356
 * Section: 52715
 * 
 * This program is at its heart a simple loop.  The programmer designated a sentinal value,
 * which is assigned to the integer LAST_NUMBER.  The for loop then repeats a set of commands
 * as a counter variable is increased from its initial value (in this case 1) until it reaches
 * the designated sentinal value.  For this program, the loop sums an initial value (0) with
 * the counter value of the for loop.  Once the loop has run its course, the program then
 * prints a line that reads the final, summed, value.
 * 
 * If the final value of the integer FINAL_NUMBER is changed from 30 to 50, then the only thing
 * that will change is the final value displayed in the program.  It will increase from 465 to 1275.
 * 
 * Slip days used for this project: 0  Slip days used (total): 0
 * 
 */

public class LittleLoop
{
    public static void main(String[] args)
    {
        final int LAST_NUMBER = 30;
        int result = 0;
        for(int i = 1; i <= LAST_NUMBER; i++)
        {
            result = result + i;
        }
        
        System.out.println("The sum is " + result);
    }
}
