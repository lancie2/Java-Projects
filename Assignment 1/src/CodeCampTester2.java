import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CodeCampTester2 {

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
    	
    	//Test 13 - mostValuablePlot
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