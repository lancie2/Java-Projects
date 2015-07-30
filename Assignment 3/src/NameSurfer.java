/*  Student information for assignment:
 *
 *  On my honor, Lancie Menchu, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: lam4356	
 *  email address: lancie.menchu@utexas.edu
 *  Grader name: Chris
 *  Number of slip days I am using: 2
 */

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class NameSurfer {

	// constants for menu choices
	public static final int SEARCH = 1;
	public static final int ONE_NAME = 2;
	public static final int APPEAR_ONCE = 3;
	public static final int APPEAR_ALWAYS = 4;
	public static final int MORE_POPULAR = 5;
	public static final int LESS_POPULAR = 6;
	public static final int ADAM_EVE = 7;
	public static final int QUIT = 8;
	
	// CS314 students, explain your menu option 7 here:
	
	/* this method searches for names that contain "adam" or "eve"
	 * that have gotten more popular through the decades to see if
	 * the names of our alleged predeccesors have survived the eons */
	
	public ArrayList<String> adamEve(Names n) {
		if(n.equals(null)) {
			throw new IllegalArgumentException("Names cannot be null.");
		}
		
		ArrayList<String> result = new ArrayList();
		
		ArrayList<NameRecord> namesWithAdam = n.containsSubstring("adam");
		ArrayList<NameRecord> namesWithEve = n.containsSubstring("eve");
		
		for(int index = 0; index < namesWithAdam.size(); index++) {
			if(namesWithAdam.get(index).upwardTrend()) {
				result.add(namesWithAdam.get(index).name());
			}
		}
		
		for(int index = 0; index < namesWithEve.size(); index++) {
			if(namesWithEve.get(index).upwardTrend()) {
				result.add(namesWithEve.get(index).name());
			}
		}
		
		return result;
	}
	
	// CS314 students, Explain your interesting search / trend here:
	
	/* I found it interesting that the name Kareem jumped from being unranked to being 
	 * ranked 486th in the 1970s.  From then on Kareem dropped steadily in popularity
	 * every decade.  Here is the breakdown for Kareem:
	 * 
	 * Kareem 0 0 0 0 0 0 0 486 519 598 620
	 * 
	 * Kareem Abdul-Jabbar was an incredibly popular basketball player in the 1970s
	 * which would most likely account for the sudden influx in popularity
	 */
	
	// CS314 students, add test code for NameRecord class here:
	public void testingNameRecord() {
		String[] name = {"Bruce", "Clark", "Hal", "Diana", "Barry", "Arthur"};
		
		int[][] ranks = {{  0,985,768,254,231,198,125,100, 95, 14,  1}, // continuous growth
						 {  1, 14, 95,100,125,198,231,254,768,985,  0}, // continuous decline
						 { 25, 47, 32,945,251,487,652,421, 45, 74, 78}, // ranked every decade
						 {  0, 41,978,621,132,  1,458,  2,  0,  0, 21}, // random growth and decline
						 {  0,  0,  0,  0,  0,369,  0,  0,  0,  0,  0}, // only once ranked
						 {  0,  0, 27,245,196,243,892,777,  4,  2,   }};// not enough elements
		
		//static variables to refer to each name
		final int BRUCE  = 0;
		final int CLARK  = 1;
		final int HAL    = 2;
		final int DIANA  = 3;
		final int BARRY  = 4;
		final int ARTHUR = 5;
		
		//create NameRecord objects
		ArrayList<NameRecord> justiceLeague = new ArrayList(6);
		
		for(int index = 0; index < justiceLeague.size(); index++) {
			justiceLeague.add(new NameRecord(name[index], ranks[index]));
		}
		
		final int EXPECTED = 0;
		final int ACTUAL = 1;
		
		Object[][] testValues = {{ "Bruce", justiceLeague.get(BRUCE).name() },
								 { "Diana", justiceLeague.get(DIANA).name() },
								 { (int)125, justiceLeague.get(CLARK).getRank(4) },
								 { (int)27, justiceLeague.get(ARTHUR).getRank(2) },
								 { (int)2000, justiceLeague.get(BRUCE).bestRank() },
								 { (int)1900, justiceLeague.get(HAL).bestRank() },
								 { (int)10, justiceLeague.get(CLARK).numRanked() },
								 { (int)1, justiceLeague.get(BARRY).numRanked() },
								 { (boolean)true, justiceLeague.get(BRUCE).allRanked() },
								 { (boolean)false, justiceLeague.get(BARRY).allRanked() },
								 { (boolean)true, justiceLeague.get(BARRY).oneRanked() },
								 { (boolean)false, justiceLeague.get(ARTHUR).oneRanked() },
								 { (boolean)true, justiceLeague.get(BRUCE).upwardTrend() },
								 { (boolean)false, justiceLeague.get(CLARK).upwardTrend() },
								 { (boolean)true, justiceLeague.get(CLARK).downwardTrend() },
								 { (boolean)false, justiceLeague.get(BRUCE).downwardTrend() }};

		for(int test = 1; test <= testValues.length; test++) {
			testing(testValues[test][EXPECTED], testValues[test][ACTUAL], test);
		}
	}
	
	public void testing(Object expected, Object actual, int testNO) {
		System.out.println("Test " + testNO + " - testing name() method:");
		System.out.println("\texpected value: " + expected);
		System.out.println("\tactual value: " + actual);

		if(expected.equals(actual)) {
			System.out.println("\tTest Passed");
		}

		else {
			System.out.println("\t*** TEST FAILED ***");
		}
	}
	
	// main method. Driver for the whole program
	public static void main(String[] args) {
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
		    System.out.println("Unable to set look at feel to local settings. " +
		    		"Continuing with default Java look and feel.");
		}
	    try {
		    System.out.println("Opening GUI to choose file with names data...");
	        // next line for GUI
		    // Scanner fileScanner = new Scanner(getFile());
		    
		    // next line to skip GUI
		    Scanner fileScanner = new Scanner(new File("names.txt"));
			Names n = new Names(fileScanner);
			fileScanner.close();
			int choice;
			Scanner keyboard = new Scanner(System.in);
			do {
				showMenu();
				choice = getChoice(keyboard);
				if( choice == SEARCH)
					search(n, keyboard);
				else if( choice == ONE_NAME )
					oneName(n, keyboard);
				else if( choice == APPEAR_ONCE )
					appearOnce(n);
				else if( choice == APPEAR_ALWAYS )
					appearAlways(n);
				else
					System.out.println("\n\nGoodbye.");

			} while( choice != QUIT);
		}
		catch(FileNotFoundException e) {
			System.out.println("Problem reading the data file. Exiting the program." + e);
		}
	}

	// method that shows names that have appeared in ever decade
	// pre: n != null
	// post: print out names that have appeared in ever decade
	private static void appearAlways(Names n) {
		//compare arguments with conditions
		if(n.equals(null)) {
			throw new IllegalArgumentException("Names cannot be null.");
		}
		
		ArrayList<String> result = n.rankedEveryDecade();
		System.out.println(result.size() + " names appear in every decade. The names are:");
		
		for(int index = 0; index < n.size(); index++) {
			System.out.println(result.get(index) + "\n");
		}

	}

	// method that shows names that have appeared in only one decade
	// pre: n != null
	// post: print out names that have appeared in only one decade
	private static void appearOnce(Names n) {
		//check arguments against preconditions
		if(n.equals(null)) {
			throw new IllegalArgumentException("Names cannot be null.");
		}
		
		ArrayList<String> result = n.rankedOnlyOneDecade();
		System.out.println(result.size() + " names appear in exactly one decade. The names are:");
		
		for(int index = 0; index < n.size(); index++) {
			System.out.println(result.get(index) + "\n");
		}

	}

	// method that shows data for one name, or states that name has never been ranked
	// pre: n != null, keyboard != null and is connected to System.in
	// post: print out the data for n or a message that n has never been in the top 1000 for any decade
	private static void oneName(Names n, Scanner keyboard) {
		//check arguments against preconditions
		if(n.equals(null)) {
			throw new IllegalArgumentException("Names cannot be null.");
		}
		
		System.out.print("Enter a name: ");
		String name = keyboard.next();
		
		NameRecord current = n.find(name);
		
		if(current.equals(null)) {
			System.out.println(name + " does not appear in any decade.");
		}
		
		else {
			System.out.print(current.name() + ", ranks:");
			for(int decade = 0; decade < 11; decade++) {
				System.out.print(" " + current.getRank(decade));
			}
			for(int decade = 0; decade < 11; decade++) {
				System.out.print("\n" + current.decade(decade) + ": " + current.getRank(decade));
			}
		}
	}

	// method that shows all names that contain a substring from the user
	// and the decade they were most popular in
	// pre: n != null, keyboard != null and is connected to System.in
	// post: show the correct data		
	private static void search(Names n, Scanner keyboard) {
		//check arguments against conditions
		if(n.equals(null)) {
			throw new IllegalArgumentException("Names cannot be null.");
		}
		
		System.out.println("Enter a partial name: ");
		String input = keyboard.next();
		
		ArrayList<NameRecord> result = n.containsSubstring(input);
		
		System.out.println("There are " + result.size() + " matches for " + input + "\n");
		System.out.println("The matches with their highest ranking decade are:");
		
		for(int index = 0; index < result.size(); index++) {
			NameRecord current = result.get(index);
			System.out.print(current.name() + " " + current.decade(current.indexOfBestDecade()));
			
		}
			
	}

	// get choice from the user
	// keyboard != null and is connected to System.in
	// return an int that is >= SEARCH and <= QUIT
	private static int getChoice(Scanner keyboard) {
		int choice = getInt(keyboard, "Enter choice: ");
		keyboard.nextLine();
		while( choice < SEARCH || choice > QUIT){
			System.out.println("\n" + choice + " is not a valid choice");
			choice = getInt(keyboard, "Enter choice: ");
			keyboard.nextLine();
		}
		return choice;
	}
	
	// ensure an int is entered from the keyboard
	// pre: s != null and is connected to System.in
    private static int getInt(Scanner s, String prompt) {
        System.out.print(prompt);
        while( !s.hasNextInt() ){
            s.next();
            System.out.println("That was not an int.");
            System.out.print(prompt);
        }
        return s.nextInt();
    }

    // show the user the menu
	private static void showMenu() {
		System.out.println("\nOptions:");
		System.out.println("Enter " + SEARCH + " to search for names.");
		System.out.println("Enter " + ONE_NAME + " to display data for one name.");
		System.out.println("Enter " + APPEAR_ONCE+ " to display all names that appear in only one decade.");
		System.out.println("Enter " + APPEAR_ALWAYS + " to display all names that appear in all decades.");
		// CS314 students fill in other options
		System.out.println("Enter " + MORE_POPULAR + " to display all names that have gotten more popular every decade.");
		System.out.println("Enter " + LESS_POPULAR + " to display all names that have gotten less popular every decade.");
		System.out.println("Enter " + ADAM_EVE + " to display all names that contain \"Adam\" or \"Eve\" and have gotten more popular every decade.");
		System.out.println("Enter " + QUIT + " to quit.\n");
	}

	/** Method to choose a file using a traditional window.
     * @return the file chosen by the user. Returns null if no file picked.
     */ 
    public static File getFile() {
        // create a GUI window to pick the text to evaluate
        JFileChooser chooser = new JFileChooser(".");
        chooser.setDialogTitle("Select File With Baby Names Data.");
        int retval = chooser.showOpenDialog(null);
        File f =null;
        chooser.grabFocus();
        if (retval == JFileChooser.APPROVE_OPTION)
           f = chooser.getSelectedFile();
        return f;
    }

}