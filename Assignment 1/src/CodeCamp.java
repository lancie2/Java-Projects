//  CodeCamp.java - CS314 Assignment 1

/*  Student information for assignment:
 * 
 * replace <NAME> with your name.
 *
 *  On my honor, LANCIE MENCHU, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name: Lancie Menchu
 *  email address: lancie.menchu@utexas.edu
 *  UTEID: lam4356
 *  Section 5 digit ID: 53315
 *  Grader name: Padmini
 *  Number of slip days used on this assignment: 2
 */

import java.util.Random;

public class CodeCamp {
  
    /**
     * Determine the Hamming distance between two arrays of ints. 
     * Neither the parameter <tt>aList</tt> or
     * <tt>bList</tt> are altered as a result of this method.<br>
     * @param aList != null, aList.length == bList.length
     * @param bList != null, bList.length == aList.length
     * @return the Hamming Distance between the two arrays of ints.
     */    
    public static int hammingDistance(int[] aList, int[] bList){
        // check preconditions
        if (aList == null || bList == null || aList.length != bList.length) 
            throw new IllegalArgumentException("Violation of precondition: " +
            		"hammingDistance. neither parameter may equal null, arrays" +
            		" must be equal length.");
        
        /*CS314 STUDENTS: INSERT YOUR CODE HERE*/
        
        int hamming = 0;
        
        for(int index = 0; index < aList.length; index++) {
        	if(aList[index] != bList[index]) { 
        		hamming++;
        	}
        }
        
        return hamming;
    }
    
    
    /**
     * Determine if one array of ints is a permutation of another.
     * Neither the parameter <tt>listA</tt> or 
     * the parameter <tt>listB</tt> are altered as a result of this method.<br>
     * @param listA != null
     * @param listB != null
     * @return <tt>true</tt> if listB is a permutation of listA, 
     * <tt>false</tt> otherwise
     * 
    */
    public static boolean isPermutation(int[] listA, int[] listB) {
        // check preconditions
        if (listA == null || listB == null) 
            throw new IllegalArgumentException("Violation of precondition: " +
            		"isPermutation. neither parameter may equal null.");
        /*CS314 STUDENTS: INSERT YOUR CODE HERE*/
        
        //if lists are not of same length, they aren't permutations.  Return false.
        if(listA.length != listB.length) return false;
        
        //flag array to indicate which elements have been inspected
        boolean[] checked = new boolean[listA.length];
        
        /* Grab a value from listA and compare with each value of listB.
         * If the value is found, mark it checked and found, then move on
         * to the next element in the array*/
        for(int indexA = 0; indexA < listA.length; indexA++) {
        	boolean found = false;
        	for(int indexB = 0; indexB < listB.length; indexB++) {
        		if(!checked[indexB]) {
        			if(listA[indexA] == listB[indexB]) {
        				checked[indexB] = true;
        				found = true;
        				break;
        			}
        		}
        	}
        	if(!found) return false; 
        }
        return true; 
    }
    
    
    /**
     * Determine the index of the String that 
     * has the largest number of vowels. 
     * Vowels are defined as <tt>'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 
     * 'U', and 'u'</tt>.
     * The parameter <tt>list</tt> is not altered as a result of this method.
     * <p>pre: <tt>list != null</tt>, <tt>list.length > 0</tt>, there is an least 1 non null element in list
     * <p>post: return the index of the non-null element in list that has the 
     * largest number of characters that are vowels.
     * If there is a tie return the index closest to zero. 
     * The empty String, "", has zero vowels.
     * It is possible for the maximum number of vowels to be 0.<br>
     * @param list the array to check
     * @return the index of the non-null element in list that has 
     * the largest number of vowels.
     */
    public static int mostVowels(String[] list) {
        // check preconditions
        if (list == null || list.length == 0 || !atLeastOneNonNull(list))  
            throw new IllegalArgumentException("Violation of precondition: " +
            		"mostVowels. parameter may not equal null and must contain " +
            		"at least one none null value.");
       

        // CS314 STUDENTS: ADD YOUR CODE HERE
        //  You can use all methods from the String class and native arrays.
        
        char[] vowelList = { 'a', 'e', 'i', 'o', 'u' };
        
        int[] vowelCounts = new int[list.length];
        
        int indexOfMax = 0;
        
        for(int index = 0; index < list.length; index++) {
        	int counter = 0;
        	//check for null elements
        	if(list[index] == null) {
        		vowelCounts[index] = -1;
        		continue;
        	}
    		String word = list[index].toLowerCase();
        	for(int token = 0; token < word.length(); token++) {
        		for(char vowel: vowelList) {
        			if(word.charAt(token) == vowel) {
        				counter++;
        			}
        		}
        	}
        	vowelCounts[index] = counter;	
        }
        
        for(int index = 1; index < vowelCounts.length; index++) {
        	if(vowelCounts[index] >= 0 && vowelCounts[index] > vowelCounts[index-1]) {
        		indexOfMax = index;
        	}
        }
        
        return indexOfMax;
    }
    

    
    /**
     * Perform an experiment simulating the birthday problem.
     * Pick random birthdays for the given number of people. 
     * Return the number of pairs of people that share the
     * same birthday.<br>
     * @param numPeople The number of people in the experiment.
     * This value must be > 0
     * @param numDaysInYear The number of days in the year for this experiement.
     * This value must be > 0
     * @return The number of pairs of people that share a birthday 
     * after running the simulation.
     */
    public static int sharedBirthdays(int numPeople, int numDaysInYear) {
        // check preconditions
        if (numPeople <= 0 || numDaysInYear <= 0)
            throw new IllegalArgumentException("Violation of precondition: " +
            		"sharedBirthdays. both parameters must be greater than 0. " +
                    "numPeople: " + numPeople + 
                    ", numDaysInYear: " + numDaysInYear);
        
        //CS314 STUDENTS: ADD YOUR CODE HERE
        
        Random generator = new Random();
        
        //an array of numPeople people
        int[] people = new int[numPeople];
        
        //generate birthdays for each person in the array
        for(int index = 0; index < numPeople; index++) {
        	people[index] = generator.nextInt(numDaysInYear);
        }
        
        int pairs = 0;
        
        //inspect each person and compare them with the rest to determine the number of pairs
        for(int index = 0; index < numPeople; index++) {
        	for(int indexPeople = index + 1; indexPeople < numPeople; indexPeople++) {
        		if(people[index] == people[indexPeople]) {
        			pairs++;
        		}
        	}
        }

        return pairs;
    }
    
    /** 
     * Perform an experiment using the shardBirthdays method.
     * Perform 1,000,000 experiments with 365 days per year and 182 people per experiment.
     * @param None This method takes no parameters
     * @return This method displays the average number of shared birthdays,
     * however it does not return any actual values
     * 
     */
    
    
    
    /**
     * Determine if the chess board represented by board is a safe set up.
     * <p>pre: board != null, board.length > 0, board is a square matrix.
     * (In other words all rows in board have board.length columns.),
     * all elements of board == 'q' or '.'. 'q's represent queens, '.'s
     * represent open spaces.<br>
     * <p>post: return true if the configuration of board is safe,
     * that is no queen can attack any other queen on the board.
     * false otherwise.
     * the parameter <tt>board</tt> is not altered as a result of 
     * this method.<br>
     * @param board the chessboard
     * @return true if the configuration of board is safe,
     * that is no queen can attack any other queen on the board.
     * false otherwise.
    */
    public static boolean queensAreSafe(char[][] board) {
        char[] validChars = {'q', '.'};
        // check preconditions
        if (board == null || board.length == 0 || !isSquare(board) 
                || !onlyContains(board, validChars))
            throw new IllegalArgumentException("Violation of precondition: " +
            		"queensAreSafe. The board may not be null, must be square, " +
            		"and may only contain 'q's and '.'s");        
                
      //CS314 STUDENTS: ADD YOUR CODE HERE
        
        int boardSize = board.length;
        //check rows and columns for queens.  If more than one is found, queens are not safe
        for(int indexA = 0; indexA < boardSize; indexA++) {
        	int queensRow = 0;
            int queensColumn = 0;
        	for(int indexB = 0; indexB < boardSize; indexB++) {
        		//check for multiple queens in a row
        		if(board[indexA][indexB] == 'q') {
        			queensRow++;
        		}
        		//check for multiple queens in a column
        		if(board[indexB][indexA] == 'q') {
        			queensColumn++;
        		}
        	}
        	if(queensRow > 1 || queensColumn > 1) {
        		return false;
        	}
        }
        
        //check diagonals
        int totalDiagonals = 4 * boardSize - 6;
        int queens = 0;
        int row = 0;
        int column = 0;
        int end = 0;
               
        for(int count = 0; count < totalDiagonals / 2; count++) {
        	queens = 0;
        	if(count < boardSize - 1) {
        		row = 1 + count;
        		column = 0;
        	}
        	else {
        		end++;
        		row = boardSize - 1;
        		column = end;
        	}
        	//System.out.print("Now inspecting space: ");
        	while(row >= end) {
        		//System.out.print("(" + row + ", " + column + ")");
        		if(board[row][column] == 'q') {
        			queens++;
        		}
        		row--;
        		column++;
        		if(queens > 1) {
        			return false;
        		}
        	}
        	//System.out.println();
        	
    	}
        
        for(int count = 0; count < totalDiagonals / 2; count++) {
        	queens = 0;
        	if(count < boardSize - 1) {
        		row = 1 + count;
        		column = boardSize - 1;
        		end = 0;
        	}
        	else {
        		row = boardSize - 1;
        		column = boardSize - end - 2;
        		end++;
        	}
        	//System.out.print("Now inspecting space: ");
        	while(row >= end) {
        		//System.out.print("(" + row + ", " + column + ")");
        		if(board[row][column] == 'q') {
        			queens++;
        		}
        		row--;
        		column--;
        		if(queens > 1) {
        			return false;
        		}
        	}
        	//System.out.println();
    	}
        
        return true;
    }
    
    
    /**
     * Given a 2D array of ints return the value of the
     * most valuable contiguous sub rectangle in the 2D array.
     * The sub rectangle must be at least 1 by 1. 
     * <p>pre: <tt>mat != null, mat.length > 0, mat[0].length > 0,
     * mat</tt> is a rectangular matrix.
     * <p>post: return the value of the most valuable contigous sub rectangle
     * in <tt>city</tt>.<br>
     * @param city The 2D array of ints representing the value of
     * each block in a portion of a city.
     * @return return the value of the most valuable contigous sub rectangle
     * in <tt>city</tt>.
     */
    public static int getValueOfMostValuablePlot(int[][] city) {
        // check preconditions
        if (city == null || city.length == 0 || city[0].length == 0 
                || !isRectangular(city) )
            throw new IllegalArgumentException("Violation of precondition: " +
            		"getValueOfMostValuablePlot. The parameter may not be null," +
            		" must value at least one row and at least" +
                    " one column, and must be rectangular."); 
        

        //CS314 STUDENTS: ADD YOUR CODE HERE
        
        int maxValue = city[0][0];
        
        //System.out.println(maxValue);
        
        //Check for all negative values        
        boolean allNegative = true;
        
        for(int row = 0; row < city.length; row++) {
        	
        	for(int column = 0; column < city[row].length; column++) {
        		
        		if(city[row][column] >= 0) {
        			allNegative = false;
        		}
        		
        		if(city[row][column] > maxValue) {
        			maxValue = city[row][column];
        		}
        	}
        }
        
        if(allNegative) {
        	return maxValue;
        }
        
        /* 
         * The following four loops cycle through a 2D array.
         * yInitial and xInitial are the starting elements of a sub-rectangle.
         * yFinal and xFinal are the ending elements of a sub-rectangle.
         */
        		
        for(int yInitial = 0; yInitial < city.length; yInitial++) {
        	
        	for(int xInitial = 0; xInitial < city[yInitial].length; xInitial++) {
        		
        		for(int yFinal = 0; yFinal < city.length; yFinal++) {
        			
        			for(int xFinal = 0; xFinal < city[yInitial].length; xFinal++) {
        				
        				maxValue = Math.max(blockValue(city, yInitial, yFinal, xInitial, xFinal), maxValue);
        				//System.out.println(maxValue);
        			}
        		}
        	}
        }
        				
        //System.out.println(maxValue);
        return maxValue;
    }
    
    // Find the max value of a box x by y large
    public static int blockValue(int[][] array, int yi, int yf, int xi, int xf) {
    	
    	int total = 0;
    	
    	for(int row = yi; row <= yf; row++) {
    		
    		for(int column = xi; column <= xf; column++) {
    			
    			total += array[row][column];
    		}
    	}
    	
    	return total;
    }
    	
    
    
    // !!!!! ***** !!!!! ***** !!!!! ****** !!!!! ****** !!!!! ****** !!!!!!
    // CS314 STUDENTS: Put your birthday problem experiement code here:
    
    public static void experiments() {
    	
    	int sum = 0;
    	int runs = 1000000;
    	
    	for(int run = 0; run < runs; run++) {
    		sum += sharedBirthdays(182, 365);
    	}
    	
    	System.out.println("The average after " + runs + " runs is: " + (sum/runs));
    	runs = 50000;
    	
    	for(int people = 2; people < 101; people++) {
    		
    		sum = 0;
    		for(int run = 0; run < runs; run++) {
    			
    			int pairs = sharedBirthdays(people, 365);
    			if(pairs > 0) {
    				
    				sum++;
    			}
    		}
    		
    		System.out.print("Num people: " + people + ", number of experiments with one or more shared birthday: " + sum + ", percentage: ");
    		System.out.printf("%.2f", (double)sum / runs * 100.0);
    		System.out.println();
    	}
    }
    
    
    // pre: list != null
    // post: return true if at least one element in list is null
    // otherwise return false.
    private static boolean atLeastOneNonNull(String[] list) {
        // check precondition
        if(list == null)
            throw new IllegalArgumentException("Violation of precondition: " +
            		"atLeastOneNonNull. parameter may not equal null.");
        
        boolean foundNonNull = false;
        int i = 0;
        while( !foundNonNull && i < list.length ){
            foundNonNull = list[i] != null;
            i++;
        }
        return foundNonNull;
    }
    
    
    /* pre: mat != null
    post: return true if mat is a square matrix, false otherwise
     */
    private static boolean isSquare(char[][] mat) {
        if(mat == null)
            throw new IllegalArgumentException("Violation of precondition: " +
            		"isSquare. paremeter may not be null.");

        final int numRows = mat.length;
        int row = 0;
        boolean isSquare = true;
        while( isSquare && row < numRows ) {
            isSquare = ( mat[row] != null) && (mat[row].length == numRows);
            row++;
        }
        return isSquare;
    }
    
    
    /* pre: mat != null, valid != null
    post: return true if all elements in mat are one of the characters in valid
     */
    private static boolean onlyContains(char[][] mat, char[] valid) {
        // check preconditions
        if(mat == null || valid == null)
            throw new IllegalArgumentException("Violation of precondition: " +
            		"onlyContains. paremeters may not be null.");
        
        int row = 0;
        boolean correct = true;
        while( correct && row < mat.length) {
            int col = 0;
            while(correct && col < mat[row].length) {
                correct = contains(valid, mat[row][col]);
                col++;
            }
            row++;
        }
        return correct;
    }
    
    
    /*  pre: list != null
        post: return true if c is in list
     */
    private static boolean contains(char[] list, char tgtChar) {
        // check preconditions
        if(list == null)
            throw new IllegalArgumentException("Violation of precondition: " +
            		"contains. paremeter may not be null.");

        boolean found = false;
        int index = 0;
        while( !found && index < list.length) {
            found = list[index] == tgtChar;
            index++;
        }
        return found;
    }
   
    
     // pre: mat != null, mat.length > 0
     // post: return true if mat is rectangular
    private static boolean isRectangular(int[][] mat) {
        // check preconditions
        if(mat == null || mat.length == 0)
            throw new IllegalArgumentException("Violation of precondition: " +
            		"isRectangular. paremeter may not be null and must contain" +
            		" at least one row.");

        boolean correct = mat[0] != null;
        int row = 0;
        while(correct && row < mat.length) {
            correct = (mat[row] != null) && (mat[row].length == mat[0].length);
            row++;
        }
        return correct;
    }
    
    // make constructor pirvate so no instances of CodeCamp can be created
    private CodeCamp() {
        
    }
}