import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//  CodeCamp.java - CS314 Assignment 1 - Tester class

/*  Student information for assignment:
 *
 *  Name: Lancie Menchu
 *  email address: lancie.menchu@utexas.edu
 *  UTEID: lam4356
 *  Section 5 digit ID: 53315
 *  Grader name: Padmini
 *  Number of slip days used on this assignment: 2
 */


/* CS314 Students: place results of shared birthdays experiments in this comment.
 * The average number of matched birthdays after 1000000 experiments of 182 people in 365 days is: 45
 * Num people: 2, number of experiments with one or more shared birthday: 158, percentage: 0.32
 * Num people: 3, number of experiments with one or more shared birthday: 389, percentage: 0.78
 * Num people: 4, number of experiments with one or more shared birthday: 864, percentage: 1.73
 * Num people: 5, number of experiments with one or more shared birthday: 1396, percentage: 2.79
 * Num people: 6, number of experiments with one or more shared birthday: 2024, percentage: 4.05
 * Num people: 7, number of experiments with one or more shared birthday: 2889, percentage: 5.78
 * Num people: 8, number of experiments with one or more shared birthday: 3674, percentage: 7.35
 * Num people: 9, number of experiments with one or more shared birthday: 4809, percentage: 9.62
 * Num people: 10, number of experiments with one or more shared birthday: 5874, percentage: 11.75
 * Num people: 11, number of experiments with one or more shared birthday: 6962, percentage: 13.92
 * Num people: 12, number of experiments with one or more shared birthday: 8356, percentage: 16.71
 * Num people: 13, number of experiments with one or more shared birthday: 9818, percentage: 19.64
 * Num people: 14, number of experiments with one or more shared birthday: 11207, percentage: 22.41
 * Num people: 15, number of experiments with one or more shared birthday: 12719, percentage: 25.44
 * Num people: 16, number of experiments with one or more shared birthday: 14162, percentage: 28.32
 * Num people: 17, number of experiments with one or more shared birthday: 15754, percentage: 31.51
 * Num people: 18, number of experiments with one or more shared birthday: 17248, percentage: 34.50
 * Num people: 19, number of experiments with one or more shared birthday: 18869, percentage: 37.74
 * Num people: 20, number of experiments with one or more shared birthday: 20624, percentage: 41.25
 * Num people: 21, number of experiments with one or more shared birthday: 22206, percentage: 44.41
 * Num people: 22, number of experiments with one or more shared birthday: 23757, percentage: 47.51
 * Num people: 23, number of experiments with one or more shared birthday: 25275, percentage: 50.55
 * Num people: 24, number of experiments with one or more shared birthday: 27003, percentage: 54.01
 * Num people: 25, number of experiments with one or more shared birthday: 28322, percentage: 56.64
 * Num people: 26, number of experiments with one or more shared birthday: 29941, percentage: 59.88
 * Num people: 27, number of experiments with one or more shared birthday: 31413, percentage: 62.83
 * Num people: 28, number of experiments with one or more shared birthday: 32697, percentage: 65.39
 * Num people: 29, number of experiments with one or more shared birthday: 34062, percentage: 68.12
 * Num people: 30, number of experiments with one or more shared birthday: 35378, percentage: 70.76
 * Num people: 31, number of experiments with one or more shared birthday: 36424, percentage: 72.85
 * Num people: 32, number of experiments with one or more shared birthday: 37702, percentage: 75.40
 * Num people: 33, number of experiments with one or more shared birthday: 38699, percentage: 77.40
 * Num people: 34, number of experiments with one or more shared birthday: 39829, percentage: 79.66
 * Num people: 35, number of experiments with one or more shared birthday: 40665, percentage: 81.33
 * Num people: 36, number of experiments with one or more shared birthday: 41680, percentage: 83.36
 * Num people: 37, number of experiments with one or more shared birthday: 42450, percentage: 84.90
 * Num people: 38, number of experiments with one or more shared birthday: 43157, percentage: 86.31
 * Num people: 39, number of experiments with one or more shared birthday: 43876, percentage: 87.75
 * Num people: 40, number of experiments with one or more shared birthday: 44483, percentage: 88.97
 * Num people: 41, number of experiments with one or more shared birthday: 45286, percentage: 90.57
 * Num people: 42, number of experiments with one or more shared birthday: 45698, percentage: 91.40
 * Num people: 43, number of experiments with one or more shared birthday: 46405, percentage: 92.81
 * Num people: 44, number of experiments with one or more shared birthday: 46678, percentage: 93.36
 * Num people: 45, number of experiments with one or more shared birthday: 47049, percentage: 94.10
 * Num people: 46, number of experiments with one or more shared birthday: 47321, percentage: 94.64
 * Num people: 47, number of experiments with one or more shared birthday: 47735, percentage: 95.47
 * Num people: 48, number of experiments with one or more shared birthday: 48078, percentage: 96.16
 * Num people: 49, number of experiments with one or more shared birthday: 48304, percentage: 96.61
 * Num people: 50, number of experiments with one or more shared birthday: 48517, percentage: 97.03
 * Num people: 51, number of experiments with one or more shared birthday: 48696, percentage: 97.39
 * Num people: 52, number of experiments with one or more shared birthday: 48956, percentage: 97.91
 * Num people: 53, number of experiments with one or more shared birthday: 49089, percentage: 98.18
 * Num people: 54, number of experiments with one or more shared birthday: 49209, percentage: 98.42
 * Num people: 55, number of experiments with one or more shared birthday: 49318, percentage: 98.64
 * Num people: 56, number of experiments with one or more shared birthday: 49426, percentage: 98.85
 * Num people: 57, number of experiments with one or more shared birthday: 49528, percentage: 99.06
 * Num people: 58, number of experiments with one or more shared birthday: 49589, percentage: 99.18
 * Num people: 59, number of experiments with one or more shared birthday: 49671, percentage: 99.34
 * Num people: 60, number of experiments with one or more shared birthday: 49711, percentage: 99.42
 * Num people: 61, number of experiments with one or more shared birthday: 49747, percentage: 99.49
 * Num people: 62, number of experiments with one or more shared birthday: 49810, percentage: 99.62
 * Num people: 63, number of experiments with one or more shared birthday: 49834, percentage: 99.67
 * Num people: 64, number of experiments with one or more shared birthday: 49859, percentage: 99.72
 * Num people: 65, number of experiments with one or more shared birthday: 49886, percentage: 99.77
 * Num people: 66, number of experiments with one or more shared birthday: 49915, percentage: 99.83
 * Num people: 67, number of experiments with one or more shared birthday: 49930, percentage: 99.86
 * Num people: 68, number of experiments with one or more shared birthday: 49932, percentage: 99.86
 * Num people: 69, number of experiments with one or more shared birthday: 49940, percentage: 99.88
 * Num people: 70, number of experiments with one or more shared birthday: 49943, percentage: 99.89
 * Num people: 71, number of experiments with one or more shared birthday: 49971, percentage: 99.94
 * Num people: 72, number of experiments with one or more shared birthday: 49977, percentage: 99.95
 * Num people: 73, number of experiments with one or more shared birthday: 49981, percentage: 99.96
 * Num people: 74, number of experiments with one or more shared birthday: 49985, percentage: 99.97
 * Num people: 75, number of experiments with one or more shared birthday: 49984, percentage: 99.97
 * Num people: 76, number of experiments with one or more shared birthday: 49991, percentage: 99.98
 * Num people: 77, number of experiments with one or more shared birthday: 49994, percentage: 99.99
 * Num people: 78, number of experiments with one or more shared birthday: 49991, percentage: 99.98
 * Num people: 79, number of experiments with one or more shared birthday: 49994, percentage: 99.99
 * Num people: 80, number of experiments with one or more shared birthday: 49992, percentage: 99.98
 * Num people: 81, number of experiments with one or more shared birthday: 49999, percentage: 100.00
 * Num people: 82, number of experiments with one or more shared birthday: 49993, percentage: 99.99
 * Num people: 83, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 84, number of experiments with one or more shared birthday: 49999, percentage: 100.00
 * Num people: 85, number of experiments with one or more shared birthday: 49999, percentage: 100.00
 * Num people: 86, number of experiments with one or more shared birthday: 49999, percentage: 100.00
 * Num people: 87, number of experiments with one or more shared birthday: 49996, percentage: 99.99
 * Num people: 88, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 89, number of experiments with one or more shared birthday: 49999, percentage: 100.00
 * Num people: 90, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 91, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 92, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 93, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 94, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 95, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 96, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 97, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 98, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 99, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 100, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * You would need 23 people to have a 50% chance of there being a matched birthday
 */

 
public class CodeCampTester {

	 public static void main(String[] args){
	    	Object expected;
	    	Object actual;
	    	int testNum = 0;
	    	//Tests
	    	
	    	//Test 1 - hammingDistance
	    	testNum++;
	    	System.out.println("Test: " + testNum + " (Hamming Distance - No Match)");
	    	int[] list1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 10, 10};
	    	int[] list2 = {1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
	    	expected = 6;
	    	actual = CodeCamp.hammingDistance(list1, list2);
	    	checkTest(actual, expected);
	    	
	    	//Test 2 - hammingDistance
	    	testNum++;
	    	System.out.println("Test: " + testNum + " (Hamming Distance - Match)");
	    	list2 = list1;
	    	expected = 0;
	    	actual = CodeCamp.hammingDistance(list1, list2);
	    	checkTest(actual, expected);
	    	
	    	//Test 3 - isPermutation comprehensive test that IS a match
	    	testNum++;
	    	System.out.println("Test: " + testNum + " (isPermutation - Match)");
	    	Random ranGen = new Random();
	    	int temp;
	    	List<Integer> ranList = new ArrayList<Integer>();
	    	List<Integer> ranListShuffled = new ArrayList<Integer>();
	    	for(int i = 0; i < 100000; i++) {
	    		temp = ranGen.nextInt();
	    		ranList.add(temp);
	    		ranListShuffled.add(temp);
	    	}
	    	//shuffle second list
	    	Collections.shuffle(ranListShuffled);
	    	//turn lists into Arrays
	    	int[] rArr = new int[ranList.size()];
	    	int[] rSArr = new int[ranList.size()];
	    	for(int j = 0; j < ranList.size(); j++) {
	    		rArr[j] = ranList.get(j);
	    		rSArr[j] = ranListShuffled.get(j);
	    	}
	    	//FINALLY...check your method!
	    	expected = true;
	    	actual = CodeCamp.isPermutation(rArr, rSArr);
	    	checkTest(actual, expected);
	    	
	    	//Test 4 - isPermutation comprehensive test that is NOT a match
	    	testNum++;
	    	System.out.println("Test: " + testNum + " (is Permuation - No Match");
	    	rSArr[5533] = 0; //change an arbitrary index in one of the arrays so it is no longer a permutation
	    	expected = false;
	    	actual = CodeCamp.isPermutation(rArr, rSArr);
	    	checkTest(actual, expected);
	    	
	    	//Test 5 - is Permutation - arraysize does not match!
	    	testNum++;
	    	System.out.println("Test: " + testNum + " (isPermutation - different sizes!)");
	    	int[] testArr = new int[10];
	    	expected = false;
	    	actual = CodeCamp.isPermutation(rArr, testArr);
	    	checkTest(actual, expected);
	    	
	    	//Test 6 - mostVowels
	    	testNum++;
	    	System.out.println("Test: " + testNum + " (mostVowels - cheeses)");
	    	String[] cheese = {"pArmesan", "bleu", "goat", "stringed", "strung?", "AsIago", "Two Gate Proxy"};
	    	expected = 5;
	    	actual = CodeCamp.mostVowels(cheese);
	    	checkTest(actual, expected);
	    	
	    	//Test 7 - mostVowels
	    	testNum++;
	    	System.out.println("Test: " + testNum + " (mostVowels - cheeses)");
	    	cheese[6] = "Two Gate Proxyed";
	    	actual = CodeCamp.mostVowels(cheese);
	    	expected = 6;
	    	checkTest(actual, expected);
	    	
	    	//Test 8 - mostVowels
	    	testNum++;
	    	String[] testString = {"", "234", "$#$$#"};
	    	System.out.println("Test: " + testNum + " (mostVowels - emptryString at beginning)");
	    	expected = 0;
	    	actual = CodeCamp.mostVowels(testString);
	    	checkTest(actual, expected);
	    	
	    	//Test 9 - sharedBirthdays - //not much you can do with this since we are relying random data
	    	testNum++;
	    	System.out.println("Test: " + testNum + " (sharedBirthdays - one day)");
	    	expected = 19900;
	    	actual = CodeCamp.sharedBirthdays(200, 1);
	    	checkTest(actual, expected);
	    	
	    	//Test 10 - sharedBirthdays
	    	testNum++;
	    	System.out.println("Test: " + testNum + " (sharedBirthdays - house always wins...)");
	    	System.out.println("Expected Result: something close to 1 if you're off by one or two this is fine!");
	    	int act = CodeCamp.sharedBirthdays(24, 365);
	    	System.out.println("Actual Result: " + act);
	    	if(act >= 0 && act <= 2)
	    	    System.out.println("Test Passed!");
	    	else
	    	    System.out.println("****TEST FAILED****");
	    	System.out.println();
	    	
	    	//Test 11 - queensAreSafe
	    	testNum++;
	    	System.out.println("Test: " + testNum + " (standard board - safe)");
	    	char[][] board = { {'.', '.','.', '.', '.', 'q', '.', '.'},
	                           {'.', '.','.', 'q', '.', '.', '.', '.'},
	                           {'.', '.','.', '.', '.', '.', 'q', '.'},
	                           {'q', '.','.', '.', '.', '.', '.', '.'},
	                           {'.', '.','.', '.', '.', '.', '.', 'q'},
	                           {'.', 'q','.', '.', '.', '.', '.', '.'},
	                           {'.', '.','.', '.', 'q', '.', '.', '.'},
	                           {'.', '.','q', '.', '.', '.', '.', '.'} };
	    	expected = true;
	    	actual = CodeCamp.queensAreSafe(board);
	    	checkTest(actual, expected);
	    	
	    	//Test 12 - queensAreSafe
	    	testNum++;
	    	System.out.println("Test: " + testNum + " (standard board - NOT safe)");
	    	char[][] board2 = { {'.', '.','.', '.', '.', 'q', '.', '.'},
	                            {'.', '.','.', '.', 'q', '.', '.', '.'},
	                            {'.', '.','.', '.', '.', '.', 'q', '.'},
	                            {'q', '.','.', '.', '.', '.', '.', '.'},
	                            {'.', '.','.', '.', '.', '.', '.', 'q'},
	                            {'.', 'q','.', '.', '.', '.', '.', '.'},
	                            {'.', '.','.', '.', 'q', '.', '.', '.'},
	                            {'.', '.','q', '.', '.', '.', '.', '.'} };
	    	expected = false;
	    	actual = CodeCamp.queensAreSafe(board2);
	    	checkTest(actual, expected);
	    	
	    	//Test 13 - mostValuablePlot
	    	testNum++;
	    	System.out.println("Test: " + testNum + " (MVP! - corner checks)");
	    	int[][] city = { {0, -2, -7, 0, -1},
	                         {-5, 2, -6, 2, 0},
	                         {-4, 1, -4, 1, 0},
	                         {-1, 4, 0, -2, 1},
	                         {-10, 2, 1, -5, -6},
	                         {15, 3, 1, -1, -2}};
	    	expected = 19;
	    	actual = CodeCamp.getValueOfMostValuablePlot(city);
	    	checkTest(actual, expected);
	    	
	    	//Test 14 - MVP
	    	testNum++;
	    	System.out.println("Test: " + testNum + " (MVP! - corner checks)");
	    	city = new int[][] { {-10, -10, -23, -5},
	                             {-2, -15, -10, -10},
	                             {-5, -10, 10, -5},
	                             {-5, -5, -4, 10}};
	    	expected = 11;
	    	actual = CodeCamp.getValueOfMostValuablePlot(city);
	    	checkTest(actual, expected);
	    	
	    	//Test 15 - MVP
	    	testNum++;
	    	System.out.println("Test: " + testNum + " (MVP! - entire line checks, column)");
	    	city = new int[][] { {-10, 1, -23, -5},
	                             {-2, 0, -10, -10},
	                             {-5, 0, -10, -5},
	                             {-5, 1, -4, -10}};
	    	expected = 2;
	    	actual = CodeCamp.getValueOfMostValuablePlot(city);
	    	checkTest(actual, expected);
	    	
	    	//Test 16 - MVP
	    	testNum++;
	    	System.out.println("Test: " + testNum + " (MVP! - entire line checks, row)");
	    	city = new int[][] { {-10, -1, -23, -5},
	                             {-2, 0, -10, -10},
	                             {3, 0, 0, 3},
	                             {-5, -10, -4, -10}};
	    	expected = 6;
	    	actual = CodeCamp.getValueOfMostValuablePlot(city);
	    	checkTest(actual, expected);
	    	
	    	//Test 17 - mostValuablePlot
	    	testNum++;
	    	System.out.println("Test: " + testNum + " (MVP! - center)");
	    	city = new int[][] { {0, -2, -7, 0, -1},
	                             {-5, 2, -6, -2, 0},
	                             {-4, 1, 3, 1, 0},
	                             {-1, -4, 2, -2, 1},
	                             {-2, 2, -1, -5, -6},
	                             {0, -3, -1, -1, -2}};
	    	expected = 5;
	    	actual = CodeCamp.getValueOfMostValuablePlot(city);
	    	checkTest(actual, expected);
	    	
	    	
		}

		private static void checkTest(Object actual, Object expected) {
			System.out.println("Expected Result: " + expected);
			System.out.println("Actual Result: " + actual);
			if (expected.equals(actual))
				System.out.println("Test Passed!\n");
			else
				System.out.println("****TEST FAILED****\n");
		}

	}