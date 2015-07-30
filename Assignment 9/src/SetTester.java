/*  Student information for assignment:
 *
 *  Number of slip days used:
 *
 *  Student 1 (Student whose turnin account is being used)
 *  UTEID: Lancie Menchu
 *  email address: lancie.menchu@utexas.edu
 *  Grader name: Chris
 *  Section number: 53229
 *  
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;





public class SetTester {
	
	private static int testNum = 1;

    public static void main(String[] args){

    	///SortedSet/////////////////////////////////////
    	
    		AbstractSet<String> s1 = new SortedSet<String>();
    		s1.add("g");
    		s1.add("t");
    		s1.add("a");
    		s1.add("e");
    		
    		
    		//add
    		//1
    		testFrame(s1.toString(), "(a, e, g, t)", "Add");
    		
    		//2
    		try {
    			s1.add(null);
    		} catch (IllegalArgumentException e) {
    			System.out.println("Test num: " + testNum + " - Add: Test Passed!");
    		} catch (Exception e) {
    			System.out.println("Test num: " + testNum + " - Add: *****Test Failed*****");
    		}
    		testNum++;
    		
    		//3
    		s1.add("g");
    		testFrame(s1.toString(), "(a, e, g, t)", "Add");
    		
    		//addAll
    		//4
    		AbstractSet<String> s2 = new SortedSet<String>();
    		s2.add("g");
    		s2.add("t");
    		s2.add("a");
    		s2.add("e");
    		
    		boolean res = s1.addAll(s2);
    		testFrame(res, false, "addAll");
    		
    		//5
    		s2.add("y");
    		res = s1.addAll(s2);
    		testFrame(res, true, "addAll");
    		
    		//5.1
    		res = s1.addAll(new SortedSet<String>());
    		testFrame(res, false, "addAll");
    		
    		//5.2
    		res = new SortedSet<String>().addAll(s1);
    		testFrame(res, true, "addAll");
    		
    		//clear
    		//6
    		s2.clear();
    		testFrame(s2.toString(), "()", "clear");
    		
    		
    		//contains
    		//7
    		res = s1.contains("a");
    		testFrame(res, true, "Contains");
    		
    		
    		//8
    		res = s1.contains("b");
    		testFrame(res, false, "contains");
    		
    		// containsAll
    		//9
    		res = s1.containsAll(s2);
    		testFrame(res, true, "containsAll");
    		//10
    		s2.addAll(s1);
    		res = s1.containsAll(s2);
    		testFrame(res, true, "containsAll");
    		//11
    		s2.add("z");
    		res = s1.containsAll(s2);
    		testFrame(res, false, "containsAll");
    		
    		//union 
    		//12
    		AbstractSet<String> s3 = new SortedSet<String>();
    		ISet<String> s4 = new SortedSet<String>();
    		s4 = s3.union(s3);
    		testFrame(s4.toString(), "()", "Union");
    		//13
    		s4 = s1.union(s2);
    		testFrame(s4.toString(), "(a, e, g, t, y, z)", "Union");
    		//14
    		s4 = s3.union(s1);
    		testFrame(s4.toString(), "(a, e, g, t, y)", "Union");
    		
    		// intersection 
    		//15
    		s4 = s3.intersection(s3);
    		testFrame(s4.toString(), "()", "Intersect");
    		//16
    		s4 = s2.intersection(s1);
    		testFrame(s4.toString(), "(a, e, g, t, y)", "Intersection");
    		//17
    		s4 = s3.intersection(s1);
    		testFrame(s4.toString(), "()", "Intersect");
    		
    		//Difference 
    		//18
    		s4 = s3.difference(s3);
    		testFrame(s4.toString(), "()", "Difference");
    		//19
    		s4 = s2.difference(s1);
    		testFrame(s4.toString(), "(z)", "Difference");
    		//20
    		s4 = s1.difference(s2);
    		testFrame(s4.toString(), "()", "Difference");
    		//21
    		s4 = s3.difference(s1);
    		testFrame(s4.toString(), "()", "Difference");
    		
    		//equals
    		//22
    		res = s3.equals(new SortedSet<String>());
    		testFrame(res, true, "equals");
    		
    		//23
    		s2.remove("z");
    		res = s2.equals(s1);
    		testFrame(res, true, "equals");
    		
    		//24
    		s2.add("i");
    		res = s1.equals(s2);
    		testFrame(res, false, "equals");
    		
    		//25
    		res = s2.equals(s2);
    		testFrame(res, true, "equals");
    		
    		//26
    		res = s2.equals("String");
    		testFrame(res, false, "equals");
    		
    		
    		//remove
    		//27
    		res = s4.remove("a");
    		testFrame(res, false, "remove");
    		//28
    		res = s2.remove("y");
    		testFrame(res, true, "remove");	
    		
    		//29
    		//min
    		SortedSet<String> s11 = (SortedSet<String>)s1;
    		testFrame(s11.min(), "a", "min");
    		
    		//30
    		//max
    		SortedSet<String> s22 = (SortedSet<String>)s1;
    		testFrame(s22.max(), "y", "max");
    		
    		
    		
    ///////////////////////////UNSORTED SET 
    		testNum = 1;
    		
    		s1 = new UnsortedSet<String>();
    		s1.add("g");
    		s1.add("t");
    		s1.add("a");
    		s1.add("e");
    		
    		
    		
    		//add
    		//1
    		testFrame(s1.toString(), "(g, t, a, e)", "Add");
    		
    		//2
    		try {
    			s1.add(null);
    		} catch (IllegalArgumentException e) {
    			System.out.println("Test num: " + testNum + " - Add: Test Passed!");
    		} catch (Exception e) {
    			System.out.println("Test num: " + testNum + " - Add: *****Test Failed*****");
    		}
    		testNum++;
    		
    		//3
    		s1.add("g");
    		testFrame(s1.toString(), "(g, t, a, e)", "Add");
    		
    		//addAll
    		//4
    		s2 = new SortedSet<String>();
    		s2.add("g");
    		s2.add("t");
    		s2.add("a");
    		s2.add("e");
    		
    		res = s1.addAll(s2);
    		testFrame(res, false, "addAll");
    		
    		//5
    		s2.add("y");
    		res = s1.addAll(s2);
    		testFrame(res, true, "addAll");
    		
    		//5.1
    		res = s1.addAll(new SortedSet<String>());
    		testFrame(res, false, "addAll");
    		
    		//5.2
    		res = new SortedSet<String>().addAll(s1);
    		testFrame(res, true, "addAll");
    		
    		//clear
    		//6
    		s2.clear();
    		testFrame(s2.toString(), "()", "clear");
    		
    		
    		//contains
    		//7
    		res = s1.contains("a");
    		testFrame(res, true, "Contains");
    		
    		
    		//8
    		res = s1.contains("b");
    		testFrame(res, false, "contains");
    		
    		// containsAll
    		//9
    		res = s1.containsAll(s2);
    		testFrame(res, true, "containsAll");
    		//10
    		s2.addAll(s1);
    		res = s1.containsAll(s2);
    		testFrame(res, true, "containsAll");
    		//11
    		s2.add("z");
    		res = s1.containsAll(s2);
    		testFrame(res, false, "containsAll");
    		
    		//union 
    		//12
    		s3 = new UnsortedSet<String>();
    		s4 = new UnsortedSet<String>();
    		s4 = s3.union(s3);
    		testFrame(s4.toString(), "()", "Union");
    		//13
    		s4 = s1.union(s2);
    		testFrame(s4.toString(), "(g, t, a, e, y, z)", "Union");
    		//14
    		s4 = s3.union(s1);
    		testFrame(s4.toString(), "(g, t, a, e, y)", "Union");
    		
    		// intersection 
    		//15
    		s4 = s3.intersection(s3);
    		testFrame(s4.toString(), "()", "Intersect");
    		//16
    		s4 = s2.intersection(s1);
    		testFrame(s4.toString(), "(a, e, g, t, y)", "Intersection");
    		//17
    		s4 = s3.intersection(s1);
    		testFrame(s4.toString(), "()", "Intersect");
    		
    		//Difference 
    		//18
    		s4 = s3.difference(s3);
    		testFrame(s4.toString(), "()", "Difference");
    		//19
    		s4 = s2.difference(s1);
    		testFrame(s4.toString(), "(z)", "Difference");
    		//20
    		s4 = s1.difference(s2);
    		testFrame(s4.toString(), "()", "Difference");
    		//21
    		s4 = s3.difference(s1);
    		testFrame(s4.toString(), "()", "Difference");
    		
    		//equals
    		//22
    		res = s3.equals(new SortedSet<String>());
    		testFrame(res, true, "equals");
    		
    		//23
    		s2.remove("z");
    		res = s2.equals(s1);
    		testFrame(res, true, "equals");
    		
    		//24
    		s2.add("i");
    		res = s1.equals(s2);
    		testFrame(res, false, "equals");
    		
    		//25
    		res = s2.equals(s2);
    		testFrame(res, true, "equals");
    		
    		//26
    		res = s2.equals("String");
    		testFrame(res, false, "equals");
    		
    		
    		//remove
    		//27
    		res = s4.remove("a");
    		testFrame(res, false, "remove");
    		//28
    		res = s2.remove("y");
    		testFrame(res, true, "remove");	
    		      

        // CS314 Students. Uncomment this section when ready to 
        // run your experiments
        //        try {
        //            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        //        }
        //        catch(Exception e) {
        //            System.out.println("Unable to change look and feel");
        //        }
        //		Scanner sc = new Scanner(System.in);
        //		String response = "";
        //		do {
        //			largeTest();
        //			System.out.print("Another file? Enter y to do another file: ");
        //			response = sc.next();
        //		} while( response != null && response.length() > 0 
        //              && response.substring(0,1).equalsIgnoreCase("y") );

    }

    /*
     * Method asks user for file and compares run times to add words from file to
     * various sets, including CS314 UnsortedSet and SortedSet and Java's
     * TreeSet and HashSet.
     */
    private static void largeTest(){
        System.out.println();
        System.out.println("Opening Window to select file. You may have to minimize other windows.");
        String text = convertFileToString();
        System.out.println();
        System.out.println("***** CS314 SortedSet: *****");
        processTextCS314Sets(new SortedSet<String>(), text);
        System.out.println("****** CS314 UnsortedSet: *****");
        processTextCS314Sets(new UnsortedSet<String>(), text);
        System.out.println("***** Java HashSet ******");
        processTextJavaSets( new HashSet<String>(), text);
        System.out.println("***** Java TreeSet ******");
        processTextJavaSets( new TreeSet<String>(), text);
    }

    
    /*
     * pre: set != null, text != null
     * Method to add all words in text to the given set. Words are delimited by
     * white space.
     * This version for CS314 sets.
     */
    private static void processTextCS314Sets(ISet<String> set, String text){
        Stopwatch s = new Stopwatch();
        Scanner sc = new Scanner(text);
        int totalWords = 0;
        s.start();
        while( sc.hasNext() ){
            totalWords++;
            set.add(sc.next());
        }
        s.stop();
        sc.close();

        showResultsAndWords(set, s, totalWords, set.size());
    }


    /*
     * pre: set != null, text != null
     * Method to add all words in text to the given set. Words are delimited by
     * white space.
     * This version for Java Sets.
     */
    private static void processTextJavaSets(Set<String> set, String text){
        Stopwatch s = new Stopwatch();
        Scanner sc = new Scanner(text);
        int totalWords = 0;
        s.start();
        while( sc.hasNext() ){
            totalWords++;
            set.add(sc.next());
        }
        s.stop();
        sc.close();

        showResultsAndWords(set, s, totalWords, set.size());
    }

    
    /*
     * Show results of add words to given set.
     */
    private static <E> void showResultsAndWords(Iterable<E> set, Stopwatch s, 
            int totalWords, int setSize) {

        System.out.println("Time to add the elements in the text to this set: " + s.toString() );
        System.out.println("Total number of words in text including duplicates: " + totalWords);
        System.out.println("Number of distinct words in this text " + setSize);


        System.out.print("Enter y to see the contents of this set: ");
        Scanner sc = new Scanner(System.in);
        String response = sc.next();

        if( response != null && response.length() > 0 && response.substring(0,1).equalsIgnoreCase("y") ){
            for(Object o : set)
                System.out.println(o);
        }	
        System.out.println();
    }


    /*
     * Ask user to pick a file via a file choosing window and
     * convert that file to a String. Since we are evalutatin the file
     * with many sets convert to string once instead of reading through
     * file multiple times.
     */
    private static String convertFileToString() {
        //create a GUI window to pick the text to evaluate
        JFileChooser chooser = new JFileChooser(".");
        StringBuilder text = new StringBuilder();
        int retval = chooser.showOpenDialog(null);

        chooser.grabFocus();

        //read in the file
        if (retval == JFileChooser.APPROVE_OPTION) {
            File source = chooser.getSelectedFile();
            try {
                Scanner s = new Scanner( new FileReader( source ) );

                while( s.hasNextLine() ) {
                    text.append( s.nextLine() );
                    text.append(" ");
                }

                s.close();
            }
            catch(IOException e) {
                System.out.println("An error occured while trying to read from the file: " + e);
            }
        }

        return text.toString();
    }
    
    public static void testFrame(String setString, String expectedString, String testing) {
		if (setString.equals(expectedString)) 
			System.out.println("Test num: " + testNum + " - " +testing + ": Test Passed!");
		else
			System.out.println("Test num: " + testNum + " - " +testing + ": *****Test Failed*****");
		testNum++;
	}
	
	public static void testFrame(boolean actual, boolean expected, String testing) {
		if (actual == expected) 
			System.out.println("Test num: " + testNum + " - " +testing + ": Test Passed!");
		else
			System.out.println("Test num: " + testNum + " - " +testing + ": *****Test Failed*****");
		testNum++;
	}
}