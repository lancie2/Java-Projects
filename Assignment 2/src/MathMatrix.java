import java.util.Arrays;

//  MathMatrix.java - CS314 Assignment 2

/*  Student information for assignment:
 *
 *  On my honor, LANCIE MENCHU, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: lam4356
 *  email address: lancie.menchu@utexas.edu
 *  Grader name: Chris
 *  Unique section number: 53329
 *  Number of slip days I am using: 1
 */


/**
 * A class that models systems of linear equations (Math Matrices)
 * as used in linear algebra.
 *
 * @version Skeleton file for students
 */
public class MathMatrix
{
	// instance variables
	/*CS314 STUDENTS: ADD YOUR CODE HERE*/
	
	private int rows;
	private int columns;
	private int[][] matrix;
	
	/**
	 * create a MathMatrix with cells equal to the values in mat.
	 * A "deep" copy of mat is made.
	 * Changes to mat after this constructor do not affect this
	 * Matrix and changes to this MathMatrix do not affect mat
	 * @param  mat  mat !=null, mat.length > 0, mat[0].length > 0,
	 * mat is a rectangular matrix
	 */
	public MathMatrix(int[][] mat) {
		// check the precondition. rectangularMatrix is a private method at end of Matrix class
		if((mat == null) || (mat.length == 0) || (mat[0].length == 0) || !rectangularMatrix(mat)) {
			throw new IllegalArgumentException("Violation of precondition: " + "int[][] Matrix constructor");
		}

		/*CS314 STUDENTS: ADD YOUR CODE HERE*/
		
		//get the size of the matrix
		this.rows = mat.length;
		this.columns = mat[0].length;
		
		//generate matrix to be a matrix of the same size as mat
		this.matrix = new int[rows][columns];
		
		//populate the elements of matrix with those of mat
		for(int row  = 0; row < mat.length; row++) {
			for(int column  = 0; column < mat[row].length; column++) {
				this.matrix[row][column] = mat[row][column];
			}
		}
				
	}


	/**
	 * create a MathMatrix of the specified size with all cells set to the intialValue.
	 * <br>pre: numRows > 0, numCols > 0
	 * <br>post: create a matrix with numRows rows and numCols columns. 
	 * All elements of this matrix equal initialVal.
	 * In other words after this method has been called getVal(r,c) = initialVal 
	 * for all valid r and c.
	 * @param numRows numRows > 0
	 * @param numCols numCols > 0
	 * @param initialVal all cells of this Matrix are set to initialVal
	 */
	public MathMatrix(int numRows, int numCols, int initialVal) {
		/*CS314 STUDENTS: ADD YOUR CODE HERE*/
		this(new int[numRows][numCols]);
		for(int row = 0; row < this.rows; row++) {
			Arrays.fill(this.matrix[row], initialVal);
		}
		
		
	}


	/**
	 * change the value of one of the cells in this MathMatrix.
	 * <br>pre: 0 <= row < numRows(), 0 <= col < numCols()
	 * <br>post: getVal(row, col) = newValue
	 * @param row 0 <= row < numRows()
	 * @param col 0 <= col < numCols()
	 */
	public void changeElement(int row, int col, int newValue) {
		/*CS314 STUDENTS: ADD YOUR CODE HERE*/
		//check for violation of preconditions
		if(row < 0 || col < 0) {
			throw new IllegalArgumentException
			("Violation of precondition: rows (" + row + ") and cols (" + col + ") must be greater than zero.");
		}
		
		matrix[row][col] = newValue;
	}


	/**
	 * Get the number of rows.
	 * @return the number of rows in this MathMatrix
	 */
	public int numRows() {
		/*CS314 STUDENTS: ADD YOUR CODE HERE*/
		return this.rows; // alter as necessary
	}


	/**
	 * Get the number of columns.
	 * @return the number of columns in this MathMatrix
	 */
	public int numCols() {
		/*CS314 STUDENTS: ADD YOUR CODE HERE*/
		return this.columns; // alter as necessary
	}


	/**
	 * get the value of a cell in this MathMatrix.
	 * <br>pre: row  0 <= row < numRows(), col  0 <= col < numCols()
	 * @param  row  0 <= row < numRows()
	 * @param  col  0 <= col < numCols()
	 * @return the value at the specified position
	 */
	public int getVal(int row, int col) {
		/*CS314 STUDENTS: ADD YOUR CODE HERE*/
		if(row < 0 || col < 0) {
			throw new IllegalArgumentException
			("Violation of precondition: rows (" + row + ") and cols (" + col + ") must be greater than zero.");
		}
		
		return this.matrix[row][col]; // alter as necessary
	}


	/**
	 * implements MathMatrix addition, (this MathMatrix) + rightHandSide.
	 * <br>pre: rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
	 * <br>post: This method does not alter the calling object or rightHandSide
	 * @param rightHandSide rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
	 * @return a new MathMatrix that is the result of adding this Matrix to rightHandSide.
	 * The number of rows in the returned Matrix is equal to the number of rows in this MathMatrix.
	 * The number of columns in the returned Matrix is equal to the number of columns in this MathMatrix.
	 */
	public MathMatrix add(MathMatrix rightHandSide) {
		/*CS314 STUDENTS: ADD YOUR CODE HERE*/
		
		//check to make sure the matrices are of the same size
		if(rightHandSide.rows != this.rows || rightHandSide.columns != this.columns) {
			throw new IllegalArgumentException("The Matricies are not of the same size");
		}
		
		MathMatrix temp = new MathMatrix(this.matrix);
				
		//add the value of each cell
		for(int row = 0; row < this.rows; row++) {
			for(int column = 0; column < this.columns; column++) {
				temp.changeElement(row, column, this.getVal(row, column) + rightHandSide.getVal(row, column));
			}
		}
		
		return temp; // alter as necessary
	}


	/**
	 * implements MathMatrix subtraction, (this MathMatrix) - rightHandSide.
	 * <br>pre: rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
	 * <br>post: This method does not alter the calling object or rightHandSide
	 * @param rightHandSide rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
	 * @return a new MathMatrix that is the result of subtracting rightHandSide from this MathMatrix.
	 * The number of rows in the returned MathMatrix is equal to the number of rows in this MathMatrix.
	 * The number of columns in the returned MathMatrix is equal to the number of columns in this MathMatrix.
	 */
	public MathMatrix subtract(MathMatrix rightHandSide) {
		/*CS314 STUDENTS: ADD YOUR CODE HERE*/
		
		//ensure the matrices are of the same size
		if(this.rows != rightHandSide.rows || this.columns != rightHandSide.columns) {
			throw new IllegalArgumentException("The matrices are not of the same size");
		}
		
		//create temporary matrices for each matrix
		MathMatrix temp = new MathMatrix(this.matrix);
		MathMatrix tempRightHandSide = new MathMatrix(rightHandSide.matrix);
		
		//multiply the values of tempRightHandSide by -1
		tempRightHandSide.scale(-1);
		
		//add the values of tempRightHandSide to temp
		temp.add(tempRightHandSide);
		
		return temp; // alter as necessary
	}


	/**
	 * implements matrix multiplication, (this MathMatrix) * rightHandSide.
	 * <br>pre: rightHandSide.numRows() = numCols()
	 * <br>post: This method should not alter the calling object or rightHandSide
	 * @param rightHandSide rightHandSide.numRows() = numCols()
	 * @return a new MathMatrix that is the result of multiplying this MathMatrix and rightHandSide.
	 * The number of rows in the returned MathMatrix is equal to the number of rows in this MathMatrix.
	 * The number of columns in the returned MathMatrix is equal to the number of columns in rightHandSide.
	 */
	public MathMatrix multiply(MathMatrix rightHandSide) {
		/*CS314 STUDENTS: ADD YOUR CODE HERE*/
		
		if(this.columns != rightHandSide.rows) {
			throw new IllegalArgumentException
				("Violation of precondition: the number of columns of matrix rightHandSide " +
				 "must equal the number of rows of the existing matrix");
		}
		
		//create the new matrix to hold the multiplied values
		MathMatrix temp = new MathMatrix(this.rows, rightHandSide.columns, 0);
		
		// Cycle through the array multiplying the values of each row of Matrix A
		// by all the values of each column of Matrix B
		for(int rowA = 0; rowA < this.rows; rowA++) {
			for(int colB = 0; colB < rightHandSide.numCols(); colB++) {
				int sum = 0;
				for(int rowB = 0; rowB < this.columns; rowB++) {
					sum += this.getVal(rowA, rowB) * rightHandSide.getVal(rowB, colB);
				}
				temp.changeElement(rowA, colB, sum);
			}
			
		}

		return temp; // alter as necessary
	} 


	/**
	 * Multiply all elements of this MathMatrix by factor.
	 * <br>pre: none
	 * <br>post: all elements in this matrix have been multiplied by factor. 
	 * In other words after this method has been called getVal(r,c) = old getVal(r, c) * factor
	 * for all valid r and c.
	 * @param factor the value to multipy every cell in this Matrix by.
	 */
	public void scale(int factor) {
		/*CS314 STUDENTS: ADD YOUR CODE HERE*/
		
		//multiply each element of the matrix by the factor
		for(int row = 0; row < this.rows; row++) {
			for(int column = 0; column < this.columns; column++) {
				this.matrix[row][column] *= factor;
			}
		}
	}


	/**
	 * accessor: get a transpose of this MathMatrix. 
	 * This Matrix is not changed.
	 * <br>pre: none
	 * @return a transpose of this MathMatrix
	 */
	public MathMatrix getTranspose() {
		/*CS314 STUDENTS: ADD YOUR CODE HERE*/
		
		//create a new matrix with the dimensions reversed
		MathMatrix temp = new MathMatrix(this.columns, this.rows, 0);
		
		//fill the new matrix with the values from the original matrix
		for(int i = 0; i < this.rows; i++) {
			for(int j = 0; j < this.columns; j++) {
				temp.matrix[j][i] = this.matrix[i][j];
			}
		}
		
		return temp; // alter as necessary
	}


	/**
	 * override equals.
	 * @return true if rightHandSide is the same size as this MathMatrix and all values in the
	 * two MathMatrix objects are the same, false otherwise
	 */
	public boolean equals(Object rightHandSide) {
		/* CS314 Students. The following is standard equals
		 * method code. We will learn about it in a few weeks.
		 */
		boolean result = false;
		if( rightHandSide != null && this.getClass() == rightHandSide.getClass()){
			// rightHandSide is a non null MathMatrix
			MathMatrix otherMatrix = (MathMatrix)rightHandSide;

			// cs314 students: determine if otherMatrix is equal
			// to this MathMatrix and set result to true if they are.

			/*CS314 STUDENTS: ADD YOUR CODE HERE*/
			
			//if the matrices are different sizes, they cannot be equal
			if(this.rows != otherMatrix.rows || this.columns != otherMatrix.columns) {
				return result; //result is false
			}
			
			//check each element in the arrays to ensure they're equal
			for(int row = 0; row < this.rows; row++) {
				for(int column = 0; column < this.columns; column++) {
					if(this.matrix[row][column] != otherMatrix.matrix[row][column]) {
						return result; //result is false
					}
				}
			}
			
			result = true;

		}
		return result;
	}


	/**
	 * override toString.
	 * @return a String with all elements of this MathMatrix. 
	 * Each row is on a seperate line.
	 * Spacing based on longest element in this Matrix.
	 * Each row stats and ends with a vertical bar: '|'
	 */
	public String toString(){
		/*CS314 STUDENTS: ADD YOUR CODE HERE*/
		StringBuilder temp = new StringBuilder();
				
		//get the size of the largest element
		int maxLength = 0;
		int lengthOfX;
		for(int row = 0; row < this.rows; row++) {
			for(int column = 0; column < this.columns; column++) {
				lengthOfX = ("" + this.getVal(row, column)).length();
				maxLength = Math.max(maxLength,lengthOfX);
			}
		}
		
		//format the string to have padding equal to maxLength plus 1
		String form = "%1$" + (maxLength + 1) + "d";
		
		//cycle through the matrix and grab each element, format it, and add it to the string
		for(int row = 0; row < this.rows; row++) {
			temp.append("|");
			for(int column = 0; column < this.columns; column++) {
				temp.append(String.format(form, this.getVal(row, column)));
			}
			temp.append("|\n");
		}
		return temp.toString(); // alter as necessary
	}

	/**
	 * Return true if this MathMatrix is upper triangular. To
	 * be upper triangular all elements below the main 
	 * diagonal must be 0.<br>
	 * pre: this is a square matrix. numRows() == numCols()  
	 * @return <tt>true</tt> if this MathMatrix is upper triangular,
	 * <tt>false</tt> otherwise. 
	 */
	public boolean isUpperTriangular() {
		/*CS314 STUDENTS: ADD YOUR CODE HERE*/
		
		//ensure the matrix is a square matrix
		if(this.rows != this.columns) {
			throw new IllegalArgumentException
					("The " + this.rows + " x " + this.columns + " matrix is not a square matrix");
		}
		
		//check the elements below the main diagonal to ensure they are zero
		for(int row = 1; row < this.rows; row++) {
			for(int column = 0; column < row; column++) {
				if(this.getVal(row, column) != 0) {
					return false;
				}
			}
		}
		
		
		return true; // alter as necessary
	}

	// method to ensure mat is rectangular
	// pre: mat != null
	public static boolean rectangularMatrix(int[][] mat) {
		if(mat == null)
			throw new IllegalArgumentException("Violation of precondition: "
					+ " Parameter mat may not be null");
		boolean isRectangular = true;
		int row = 1;
		final int COLUMNS = mat[0].length;

		while( isRectangular && row < mat.length ) {
			isRectangular = ( mat[row].length == COLUMNS );
			row++;
		}

		return isRectangular;
	}
}