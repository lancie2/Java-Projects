import java.util.*;

/*  Student information for assignment:
 *
 *  UTEID: lam4356	
 *  email address: lancie.menchu@utexas.edu
 *  Grader name: Chris
 *  Number of slip days I am using: 1
 */



/* CS314 Students. Put your experiment results and
* answers to questions here.
* 
* Experiment 1: A 1300 x 1300 matrix took an average of 0.010 seconds after 1000 trials.
* Experiment 1: A 2600 x 2600 matrix took an average of 0.038 seconds after 1000 trials.
* 
* Experiment 2: A 180 x 180 matrix took an average of 0.026 seconds after 1000 trials.
* Experiment 2: A 360 x 360 matrix took an average of 0.265 seconds after 1000 trials.
* 
* Question 1: About 4x as long
* Question 2: I would say O(N^2).  This is supported in that it took about 4x as long between trials.
* Question 3: About 10x as long
* Question 4: O(N^3)
* Question 5: 12,000 for heap error. 
* 
*/

/**
 * A class to run tests on the MathMatrix class
 */
public class MathMatrixTester
{

    /**
     * main method that runs simple test on the MathMatrix class
     *
     * @param args not used
     */
	public static void main(String[] args) {
    	//Test all qualifying methods for IllegalArgumentExceptions
    	//Test 1 - Constructor that takes in 2dArray
		//experiment1();
		//experiment2();
		
    	int testNum = 0;
    	testNum++;
    	printTestIntro(testNum, "(MathMatrix(vals) for IllegalArgumentException)");
    	try {
    		MathMatrix mat = new MathMatrix(null);
    	}
    	catch(NullPointerException NPE) {
    	    System.out.println("Test ****FAILED****");
    	}
    	catch(IllegalArgumentException i) {
    		System.out.println("Test Passed!");
    	}
    	
    	//Test 2 - Constructor that takes in values for rows, cols, and initialVal
    	testNum++;
    	printTestIntro(testNum, "(MathMatrix(rows, cols, val)  " +
    			"for IllegalArgumentException)");
    	try {
    		MathMatrix mat = new MathMatrix(-8, 0, 200);
    	}
    	catch(NegativeArraySizeException n) {
    		System.out.println("Test ****FAILED****");
    	}    	
    	catch(IllegalArgumentException i) {
    		System.out.println("Test Passed!");
    	}
    	int[][] d1 = { {1, 2, 3}, {4,5,6}, {7,8,9} };
    	MathMatrix mat1 = new MathMatrix(d1);
    	
    	//Test 3 - changeElement() method
    	testNum++;
    	printTestIntro(testNum, "(changeElement(row, col, newVal)  " +
    			"for IllegalArgumentException)");
    	try {
    		mat1.changeElement(-1, 3, 5);
    	}
    	catch(ArrayIndexOutOfBoundsException n) {
    		System.out.println("Test ****FAILED****");
    	}    	
    	catch(IllegalArgumentException i) {
    		System.out.println("Test Passed!");
    	}
    	
    	//Test 4 - getVal() method
    	testNum++;
    	printTestIntro(testNum, "(getVal(row, col)  " +
    			"for IllegalArgumentException)");
    	try {
    		mat1.getVal(-1, 3);
    	}
    	catch(ArrayIndexOutOfBoundsException n) {
    		System.out.println("Test ****FAILED****");
    	}    	
    	catch(IllegalArgumentException i) {
    		System.out.println("Test Passed!");
    	}
    	
    	int[][] d2 = { {1, 2}, {4,5}, {7,8} };
    	MathMatrix mat2 = new MathMatrix(d2);
    	//Test 5 - add() method
    	testNum++;
    	printTestIntro(testNum, "(add(mat2)  " +
    			"for IllegalArgumentException)");
    	try {
    		MathMatrix mat3 = mat1.add(mat2);
    	}
    	catch(ArrayIndexOutOfBoundsException n) {
    		System.out.println("Test ****FAILED****");
    	}    	
    	catch(IllegalArgumentException i) {
    		System.out.println("Test Passed!");
    	}
    	
    	//Test 6 - subtract() method
    	testNum++;
    	printTestIntro(testNum, "(subtract(mat2)  " +
    			"for IllegalArgumentException)");
    	try {
    		MathMatrix mat3 = mat1.subtract(mat2);
    	}
    	catch(ArrayIndexOutOfBoundsException n) {
    		System.out.println("Test ****FAILED****");
    	}    	
    	catch(IllegalArgumentException i) {
    		System.out.println("Test Passed!");
    	}
    	
    	d2 = new int[][]{ {1, 2}, {4,5} };
    	mat2 = new MathMatrix(d2);
    	//Test 7 - multiply() method
    	testNum++;
    	printTestIntro(testNum, "(multiply(mat2)  " +
    			"for IllegalArgumentException)");
    	try {
    		MathMatrix mat3 = mat1.multiply(mat2);
    	}
    	catch(ArrayIndexOutOfBoundsException n) {
    		System.out.println("Test ****FAILED****");
    	}    	
    	catch(IllegalArgumentException i) {
    		System.out.println("Test Passed!");
    	}
    	
    	//Test 8 - multiply() method
    	testNum++;
    	printTestIntro(testNum, "(multiply(mat2)  " +
    			"for IllegalArgumentException)");
    	try {
    		MathMatrix mat3 = mat1.multiply(mat2);
    	}
    	catch(ArrayIndexOutOfBoundsException n) {
    		System.out.println("Test ****FAILED****");
    	}    	
    	catch(IllegalArgumentException i) {
    		System.out.println("Test Passed!");
    	}
    	
    	d2 = new int[][]{ {1, 2}, {4,5}, {7, 8} };
    	mat2 = new MathMatrix(d2);
    	//Test 9 - isUpperTriangular() method
    	testNum++;
    	printTestIntro(testNum, "(isUpperTriangular()  " +
    			"for IllegalArgumentException)");
    	try {
    		mat2.isUpperTriangular();
    		System.out.println("Test ****FAILED****");
    	}   	
    	catch(IllegalArgumentException i) {
    		System.out.println("Test Passed!");
    	}
    	
    	//Test 10 - MathMatrix(2dArr) method
    	testNum++;
    	printTestIntro(testNum, "(MathMatrix(vals) for deep copy)");
    	mat1.changeElement(0, 0, 2);
    	int[][] exp = { {1, 2, 3}, {4,5,6}, {7,8,9} };
    	printTestResult(d1, exp);
    	
    	//Test 11 - MathMatrix() method
    	testNum++;
    	printTestIntro(testNum, "(MathMatrix(rows, cols, initialVal) for correctiveness)");
    	mat2 = new MathMatrix(2, 2, 0);
    	d2 = get2DArray(mat2);
    	int[][] exp2 = new int[2][2];
    	printTestResult(d2, exp2);
    	
    	//Test 12 - changeElement() method
    	testNum++;
    	printTestIntro(testNum, "(changeElement(row, col, val) for correctiveness)");
    	mat1.changeElement(0, 0, 5);
    	d1 = get2DArray(mat1);
    	exp[0][0] = 5;
    	printTestResult(d1, exp);
    	
    	//Test 13 - numRows() method
    	testNum++;
    	printTestIntro(testNum, "(numRows() for correctiveness)");
    	int intExp = 3;
    	int actual = mat1.numRows();
    	System.out.println(intExp == actual ? "Test passed!" : "Test ****FAILED****");
    	
    	//Test 14 - numRows() method
    	testNum++;
    	printTestIntro(testNum, "(numRows() for correctiveness)");
    	intExp = 2;
    	actual = mat2.numRows();
    	System.out.println(intExp == actual ? "Test passed!" : "Test ****FAILED****");
    	
    	//Test 15 - numCols() method
    	testNum++;
    	printTestIntro(testNum, "(numCols() for correctiveness)");
    	intExp = 3;
    	actual = mat1.numCols();
    	System.out.println(intExp == actual ? "Test passed!" : "Test ****FAILED****");
    	
    	//Test 16 - numCols() method
    	testNum++;
    	printTestIntro(testNum, "(numCols() for correctiveness)");
    	intExp = 2;
    	actual = mat2.numCols();
    	System.out.println(intExp == actual ? "Test passed!" : "Test ****FAILED****");
    	
    	//Test 17 - getVal() method
    	testNum++;
    	printTestIntro(testNum, "(getVal(row, col) for correctiveness)");
    	intExp = 5;
    	actual = mat1.getVal(1, 1);
    	System.out.println(intExp == actual ? "Test passed!" : "Test ****FAILED****");
    	
    	//Test 18 - getVal() method
    	testNum++;
    	printTestIntro(testNum, "(getVal(row, col) for correctiveness)");
    	intExp = 5;
    	actual = mat1.getVal(0, 0);
    	System.out.println(intExp == actual ? "Test passed!" : "Test ****FAILED****");
    	
    	//Test 19 - add() method
    	d1 = new int[][] { {1, 2, 3, 4, 5, 6},
    				        {17, 18, 20, 32, 21, 14},
    				        {10, -12, 13, -1, 0, 10} };
    	
    	d2 = new int[][] { {10, 15, 12, 8, -2, 7},
    	                    {8, 15, 99, 100, 208, -1000},
    	                    {17, -2, 0, 11, 15, 99} };
    	mat1 = new MathMatrix(d1);
    	mat2 = new MathMatrix(d2);
    	MathMatrix mat3 = mat1.add(mat2);
    	exp = new int[][] { {11, 17, 15, 12, 3, 13},
    			             {25, 33, 119, 132, 229, -986},
    			             {27, -14, 13, 10, 15, 109} };
    	
    	int[][] act = get2DArray(mat3);
    	testNum++;
    	printTestIntro(testNum, "(add(mat2) for correctiveness)");
    	printTestResult(act, exp);
    	
    	//Test20 - subtract() method
    	exp = new int[][] { {-9, -13, -9, -4, 7, -1},
	                       {9, 3, -79, -68, -187, 1014},
	                       {-7, -10, 13, -12, -15, -89} };
    	mat3 = mat1.subtract(mat2);
    	act = get2DArray(mat3);
    	testNum++;
    	printTestIntro(testNum, "(subtract(mat2) for correctiveness)");
    	printTestResult(act, exp);
    	
    	//Test21 - multiply() method
    	testNum++;
    	d1 = new int[][] { {3, 7, 9, 2, 1, 8, 9},
    					    {1, 3, 9, 1, 3, 8, 3},
    					    {0, 2, 8, 2, 4, 7, 7},
    					    {7, 1, 2, 3, 4, 6, 3} };
    	mat1 = new MathMatrix(d1);
    	d2 = new int[][] { {7, 7, 8},
    			            {8, 4, 9},
    			            {2, 3, 9},
    			            {1, 2, 0},
    			            {3, 1, 0},
    			            {2, 2, 2},
    			            {4, 1, 1} };
    	mat2 = new MathMatrix(d2);
    	mat3 = mat1.multiply(mat2);
    	exp = new int[][] { {152, 106, 193},
    					     {87, 70, 135},
    					     {88, 61, 111},
    					     {100, 84, 98} };
    	act = get2DArray(mat3);
    	printTestIntro(testNum, "(multiply(mat2) for correctiveness)");
    	printTestResult(act, exp);
    	
    	//Test 22 - scale()
    	testNum++;
    	mat3.scale(3);
    	exp = new int[][] { {456, 318, 579},
			                 {261, 210, 405},
			                 {264, 183, 333},
			                 {300, 252, 294} };
    	act = get2DArray(mat3);
    	printTestIntro(testNum, "(scale(factor) for correctiveness)");
    	printTestResult(act, exp);
    	
    	//Test 23 - scale()
    	testNum++;
    	mat3.scale(3);
    	exp = new int[][] { {1368, 954, 1737},
			                 {783, 630, 1215},
			                 {792, 549, 999},
			                 {900, 756, 882} };
    	act = get2DArray(mat3);
    	printTestIntro(testNum, "(scale(factor) for correctiveness)");
    	printTestResult(act, exp);
    	
    	//Test 24 - getTranspose()
    	testNum++;
    	mat3 = mat1.getTranspose();
    	exp = new int[][] { {3, 1, 0, 7},
    						 {7, 3, 2, 1},
    						 {9, 9, 8, 2},
    						 {2, 1, 2, 3},
    						 {1, 3, 4, 4},
    						 {8, 8, 7, 6},
    						 {9, 3, 7, 3} };
    	act = get2DArray(mat3);
    	printTestIntro(testNum, "(getTranspose() for correctiveness)");
    	printTestResult(act, exp);
    	
    	//Test 25 - getTranspose()
    	testNum++;
    	mat3 = mat2.getTranspose();
    	exp = new int[][] { {7, 8, 2, 1, 3, 2, 4},
    						 {7, 4, 3, 2, 1, 2 ,1},
    						 {8, 9, 9, 0, 0, 2, 1} };
    	act = get2DArray(mat3);
    	printTestIntro(testNum, "(getTranspose() for correctiveness)");
    	printTestResult(act, exp);
    	
    	//Test 26 - equals()
    	testNum++;
    	printTestIntro(testNum, "(equals() different size vals of two MathMatrix objects)");
    	d1 = new int[100][100];
    	mat1 = new MathMatrix(d1);
    	System.out.println(!mat1.equals(mat2) ? "Test passed!" : "Test ****FAILED****");
    	
    	//Test 27 - equals()
    	testNum++;
    	printTestIntro(testNum, "(equals() two MathMatrix objects that do equal)");
    	d1 = new int[100][100];
    	mat1 = new MathMatrix(d1);
    	mat2 = new MathMatrix(d1);
    	mat1.changeElement(2, 2, 100);
    	mat2.changeElement(2, 2, 100);
    	System.out.println(mat1.equals(mat2) ? "Test passed!" : "Test ****FAILED****");
    	
    	//Test 28 - toString()
    	testNum++;
    	d1 = new int[][] { {1, 2, 3}, 
    			            {4, 5, 6}, 
    			            {7, 8, 9} };
    	mat1 = new MathMatrix(d1);
    	String sExp = "| 1 2 3|\n| 4 5 6|\n| 7 8 9|\n";
    	printTestIntro(testNum, "(toString() for correctiveness)");
    	System.out.println(sExp.equals(mat1.toString()) ? "Test passed!" : "Test ****FAILED****");
    	
    	//Test 29 - toString()
    	testNum++;
    	d1 = new int[][] { {-10000, 2, 3}, 
	                        {4, 5, 6}, 
	                        {7, 8, 9} };
    	mat1 = new MathMatrix(d1);
    	sExp = "| -10000      2      3|\n|      4      5      6|\n|      7      8      9|\n";
    	printTestIntro(testNum, "(toString() for correctiveness)");
    	System.out.println(sExp.equals(mat1.toString()) ? "Test passed!" : "Test ****FAILED****");
    	
    	//Test 30 FINALLY isUpperTriangular
    	testNum++;
    	d1 = new int[][] { {7, 1, 1, 1, 2, 3,}, 
	                        {0, 3, 2, 4, 5, 6}, 
	                        {0, 0, 3, 7, 8, 9}, 
	                        {0, 0, 0, 1, 2, 3}, 
	                        {0, 0, 0, 0, 5, 6}, 
	                        {0, 0, 0, 0, 0, 9} };
    	mat1 = new MathMatrix(d1);
    	printTestIntro(testNum, "(isUpperTriangular() for correctiveness)");
    	System.out.println(mat1.isUpperTriangular() ? "Test passed!" : "Test ****FAILED****");
    	
    	
    	
    	
    }
    private static void printTestIntro(int testNum, String testName) {
    	System.out.println( "Test: " + testNum  + " " + testName);
    }
    private static void printTestResult(int[][] data1, int[][] data2) {
                String result = equals(data1, data2) ? "Test passed!" : "Test ****FAILED****";
        System.out.println( result );
    }

    // pre: m != null, m is at least 1 by 1 in size
    private static int[][] get2DArray(MathMatrix m) {
        //check precondition
        assert ( m != null ) && ( m.numRows() > 0 ) && ( m.numCols()> 0 )
                : "Violation of precondition: get2DArray";

        int[][] result = new int[m.numRows()][m.numCols()];
        for(int r = 0; r < result.length; r++)
        {   for(int c = 0; c < result[0].length; c++)
            {   result[r][c] = m.getVal(r,c);
            }
        }
        return result;
    }

    // pre: data1 != null, data2 != null, data1 and data2 are at least 1 by 1 matrices
    //      data1 and data2 are rectangular matrices
    // post: return true if data1 and data2 are the same size and all elements are
    //      the same
    private static boolean equals(int[][] data1, int[][] data2) {
       //check precondition
        if( ( data1 == null ) || ( data1.length == 0 )
               || ( data1[0].length == 0 ) || !rectangularMatrix(data1)
               ||  ( data2 == null ) || ( data2.length == 0 )
               || ( data2[0].length == 0 ) || !rectangularMatrix(data2))
                throw new IllegalArgumentException( "Violation of precondition: equals check on 2d arrays of ints");
        
        if(data1.length == data2.length || data1[0].length == data2[0].length) {
        	for(int r = 0; r < data1.length; r++) {
        		for(int c = 0; c < data2[0].length; c++) {
        			if(data1[r][c] != data2[r][c])
        				return false;
        		}
        	}
        	return true;
        }
        return false;
    }


    // method to ensure mat is rectangular
    // pre: mat != null, mat is at least 1 by 1
    private static boolean rectangularMatrix( int[][] mat ) {
        if(mat == null || mat.length == 0 || mat[0].length == 0)
            throw new IllegalArgumentException("Violation of precondition: "
                    + " Parameter mat may not be null" 
                    + " and must be at least 1 by 1");
        return MathMatrix.rectangularMatrix(mat);
    }
    
    //method that performs experiment 1
    private static void experiment1() {
    	
    	int runs = 1000;
    	
    	Stopwatch timer = new Stopwatch();
    	
    	Random generator = new Random();
    	
    	int matrixSize = 5200;
    	
    	int value1 = generator.nextInt();
    	int value2 = generator.nextInt();
    	
    	MathMatrix matrix1 = new MathMatrix(matrixSize, matrixSize, value1);
    	MathMatrix matrix2 = new MathMatrix(matrixSize, matrixSize, value2);
    	
    	double duration = 0;
    	
    	for(int run = 0; run < runs; run++) {
    		timer.start();
    		matrix1.add(matrix2);
    		timer.stop();
    		duration += timer.time();
    	}
    	
    	duration /= (double)runs;
    	
    	System.out.print("Experiment 1: A " + matrixSize + " x " + matrixSize +  
    			" matrix took an average of ");
    	System.out.printf("%4.3f", duration);
    	System.out.print(" seconds after 1000 trials.\n");
    	
    	
    	
    }
    
    private static void experiment2() {
    	
    	int runs = 1000;
    	
    	Stopwatch timer = new Stopwatch();
    	
    	Random generator = new Random();
    	
    	int matrixSize = 10000;
    	
    	int value1 = 2;
    	int value2 = 2;
    	
    	MathMatrix matrix1 = new MathMatrix(matrixSize, matrixSize, value1);
    	MathMatrix matrix2 = new MathMatrix(matrixSize, matrixSize, value2);
    	
    	double duration = 0;
    	
    	for(int run = 0; run < runs; run++) {
    		timer.start();
    		matrix1.multiply(matrix2);
    		timer.stop();
    		duration += timer.time();
    	}
    	
    	duration /= (double)runs;
    	
    	System.out.print("Experiment 2: A " + matrixSize + " x " + matrixSize +  
    			" matrix took an average of ");
    	System.out.printf("%4.3f", duration);
    	System.out.print(" seconds after 1000 trials.\n");
    	
    	
    	
    }
}
