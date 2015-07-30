/*  Student information for assignment:
 *
 *  On my honor, <Lancie Menchu>, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID:lam4356	
 *  email address:lancie.menchu@utexas.edu
 *  Grader name:Chris
 *  Number of slip days I am using:0
 */

import java.util.*;
/**
 * Shell for a binary search tree class.
 * @author scottm
 *
 */

public class BinarySearchTree<E extends Comparable<? super E>> {

    private BSTNode<E> root;
    // CS314 students. Add any other instance variables you want here
    
    int size;

    // CS314 students. Add a default contructor here.
    
    public BinarySearchTree() {
    	
    	size = 0;
    	
    }

    /**
     *  Add the specified item to this Binary Search Tree if it is not already present.
     *  <br>
     *  pre: <tt>value</tt> != null<br>
     *  post: Add value to this tree if not already present. Return true if this tree
     *  changed as a result of this method call, false otherwise.
     *  @param value the value to add to the tree
     *  @return false if an item equivalent to value is already present
     *  in the tree, return true if value is added to the tree and size() = old size() + 1
     *  FROM LECTURE
     */
    public boolean add(E value) {
    	
    	int oldSize = size;
    	root = addHelper(root, value);
        return oldSize != size;
        
    }
    
    public BSTNode<E> addHelper(BSTNode<E> n, E value) {
    	
    	if(n == null) {
    		size++;
    		return new BSTNode<E>(null, value, null);
    	}
    	
    	else {
    		int direction = value.compareTo(n.data);
    		if(direction < 0) {
    			n.left = addHelper(n.left, value);
    		}
    		else if(direction > 0) {
    			n.right = addHelper(n.right, value);
    		}
    		return n;
    	}
    	
    }

    /**
     *  Remove a specified item from this Binaray Search Tree if it is present.
     *  <br>
     *  pre: <tt>value</tt> != null<br>
     *  post: Remove value from the tree if present, return true if this tree
     *  changed as a result of this method call, false otherwise.
     *  @param value the value to remove from the tree if present
     *  @return false if value was not present
     *  returns true if value was present and size() = old size() - 1
     *  FROM LECTURE
     */
    public boolean remove(E value) {

    	int oldSize = size;
    	root = removeHelper(root, value);
        return oldSize != size;
        
    }


    private BSTNode<E> removeHelper(BSTNode<E> n, E value) {

    	//if n == null, value is not present.  Nothing to do!
    	
    	if(n != null) {
    		int direction = value.compareTo(n.data);
    		if(direction < 0) {
    			n.left = removeHelper(n.left, value);
    		}
    		else if(direction > 0) {
    			n.right = removeHelper(n.right, value);
    		}
    		else {
    			size--;
    			if(n.left == null) { //Covers both when n.right != null && n.right == null
    				n = n.right;
    			}
    			else if(n.right == null) {
    				n = n.left;
    			}
    			else {
    				int result = flipCoin();
    				E minOfRightOrMaxOfLeft;
    				if(result == 1) { //heads
    					minOfRightOrMaxOfLeft = min(n.right);
    					n.right = removeHelper(n.right, minOfRightOrMaxOfLeft);
    				}
    				else { //tails
    					minOfRightOrMaxOfLeft = max(n.left);
    					n.left = removeHelper(n.left, minOfRightOrMaxOfLeft);
    				}
    				n.data = minOfRightOrMaxOfLeft;	
    			}
    		}
    	}
    	
		return n;
		
	}



	/**
     *  Check to see if the specified element is in this Binary Search Tree.
     *  <br>
     *  pre: <tt>value</tt> != null<br>
     *  post: return true if value is present in tree, false otherwise
     *  @param value the value to look for in the tree
     *  @returns true if value is present in this tree, false otherwise
     */
    public boolean isPresent(E value) {
    	
    	BSTNode<E> temp = isPresentHelper(root, value);
    	return temp.data == value;
    	
    }


    private BSTNode<E> isPresentHelper(BSTNode<E> n, E value) {
    	
    	if(n!= null) {
    		int direction = value.compareTo(n.data);
    		if(direction < 0) {
    			n.left = isPresentHelper(n.left, value);
    		}
    		if(direction > 0) {
    			n.right = isPresentHelper(n.right, value);
    		}
    		else { //pass back a new node with value as its data
    			return new BSTNode<E>(null, value, null);
    		}
    	} //pass back a new node with null as its data
    	
    	
    	return new BSTNode<E>(null, null, null);
    }

	/**
     *  Return how many elements are in this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return the number of items in this tree
     *  @returns the number of items in this Binary Search Tree
     */
    public int size() {
        return size;
    }

    /**
     *  return the height of this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return the height of this tree.
     *  If the tree is empty return -1, otherwise return the
     *  height of the tree
     *  @returns the height of this tree or -1 if the tree is empty
     *  FROM LECTURE
     */
    public int height() {
    	
    	return heightHelper(root);

    }

    private int heightHelper(BSTNode<E> n) {

    	if(n == null) {
    		return -1;
    	}
    	
    	else {
    		return 1 + Math.max(heightHelper(n.left), heightHelper(n.right));
    	}
    	
	}

	/**
     *  Return a list of all the elements in this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return a List object with all data from the tree in ascending order. 
     *  If the tree is empty return an empty List
     *  @returns a List object with all data from the tree in sorted order
     *  if the tree is empty return an empty List
     */
    public List<E> getAll() {
    	
    	return getAllHelper(root);
        
    }



    private List<E> getAllHelper(BSTNode<E> n) {
		
    	List<E> result = new ArrayList<E>();
    	
    	if(n != null) {
    		getAllHelper(n.left);
    		result.add(n.data);
    		getAllHelper(n.right);
    	}
    	
		return result;
	}

	/**
     * return the maximum value in this binary search tree.
     * <br>
     * pre: <tt>size()</tt> > 0<br>
     * post: return the largest value in this Binary Search Tree
     * @return the maximum value in this tree
     * FROM LECTURE
     */
    public E max() {
    	
        return max(root);
        
    }
    
	private E max(BSTNode<E> n) {

		while(n.right != null) {
			n = n.right;
		}
		assert n.right == null;
		return n.data;
		
	}

    /**
     * return the minimum value in this binary search tree.
     * <br>
     * pre: <tt>size()</tt> > 0<br>
     * post: return the smallest value in this Binary Search Tree
     * @return the minimum value in this tree
     * FROM LECTURE
     */
    public E min() {
        return min(root);
    }
    
	private E min(BSTNode<E> n) {

		while(n.left != null) {
			n = n.left;
		}
		assert n.left == null;
		return n.data;
	}

    /**
     * An add method that implements the add algorithm iteratively instead of recursively.
     * <br>pre: data != null
     * <br>post: if data is not present add it to the tree, otherwise do nothing.
     * @param value the item to be added to this tree
     * @return true if data was not present before this call to add, false otherwise.
     * FROM LECTURE
     */
    public boolean iterativeAdd(E value) {
    	
    	int oldSize = size;
    	
    	if(root == null) {
    		root = new BSTNode<E>(null, value, null);
    		size++;
    	}
    	
    	else {
    		BSTNode<E> temp = root;
    		boolean done = false;
    		while(!done) {
    			int direction = value.compareTo(temp.data);
    			if(direction < 0 ) {
    				if(temp.left == null) {
    					temp.left = new BSTNode<E>(null, value, null);
    					size++;
    					done = true;
    				}
    				else {
    					temp = temp.left;
    				}
    			}
    			else if(direction > 0) {
    				if(temp.right == null) {
    					temp.right = new BSTNode<E>(null, value, null);
    					size++;
    					done = true;
    				}
    				else {
    					temp = temp.right;
    				}
    			}
    			else {
    				done = true;
    			}
    		}
    	}
        return oldSize != size;
    }


    /**
     * Return the "kth" largest element in this Binary Search Tree. If kth = 0 the 
     * smalles value (minimum) is returned. If kth = 1 the second smallest value is
     * returned, and so forth.
     * <br>pre: 0 <= kth < size()
     * @param kth indicates the rank of the element to get
     * @return the kth largest value in this Bianry Search Tree
     */
    public E get(int kth) {
    	
    	if(kth == 0) {
			return this.min();
		}
    	
    	else if(kth == size - 1) {
    		return this.max();
    	}
    	
    	else {
    		return getHelper(new int[]{0}, kth, root);
    	}
    }

    private E getHelper(int[] count, int kth, BSTNode<E> n) {
    	
    	if(n != null && count[0] <= kth) {
    		getHelper(count, kth, n.left);
    		count[0]++;
    		getHelper(count, kth, n.right);
    	}
    	
		return n.data;
	}

	/**
     * Return a List with all values in this Binary Search Tree that are less than
     * the parameter <tt>value</tt>.
     * <tt>value</tt> != null<br>
     * @param value the cutoff value
     * @return a List with all values in this tree that are less than the parameter value. If there are
     * no values in this tree less than value return an empty list. The elements of the list are in ascending order.
     */
    public List<E> getAllLessThan(E value) {
        return null;
    }


    /**
     * Return a List with all values in this Binary Search Tree that are greater than
     * the parameter <tt>value</tt>.
     * <tt>value</tt> != null<br>
     * @param value the cutoff value
     * @return a List with all values in this tree that are greater than the parameter value. If there are
     * no values in this tree greater than value return an empty list. The elements of the list are in ascending order.
     */
    public List<E> getAllGreaterThan(E value) {
        return null;
    }



    /**
     * Find the number of nodes in this tree at the specified depth.
     * <br>pre: none
     * @param d The target depth.
     * @return The number of nodes in this tree at a depth equal to
     * the parameter d.
     */
    public int numNodesAtDepth(int d) {
        return -1;
    }
    
    //returns a 1 or a 0 randomly
    private int flipCoin() {
    	Random coin = new Random();
    	return coin.nextInt(2);
    }
    	

    /**
     * Prints a vertical representation of this tree.
     * The tree has been rotated counter clockwise 90
     * degrees. The root is on the left. Each node is printed
     * out on its own row. A node's children wil not necessarily
     * be at the rows directly above and below a row. They will
     * be indented three spaces from the parent. Nodes indented the
     * same amount are at the same depth.
     * pre: none
     */
    public void printTree() {
        printTree(root, "");
    }

    private void printTree(BSTNode<E> n, String spaces) {
        if(n != null){
            printTree(n.getRight(), spaces + "  ");
            System.out.println(spaces + n.getData());
            printTree(n.getLeft(), spaces + "  ");
        }
    }

    private static class BSTNode<E extends Comparable<? super E>> {
        private E data;
        private BSTNode<E> left;
        private BSTNode<E> right;

        public BSTNode() {
            this(null);
        }

        public BSTNode(E initValue) {
            this(null, initValue, null); 
        }

        public BSTNode(BSTNode<E> initLeft, E initValue, BSTNode<E> initRight) {
            data = initValue; 
            left = initLeft; 
            right = initRight; 
        }

        public E getData() { 
            return data; 
        }

        public BSTNode<E> getLeft() { 
            return left;
        }

        public BSTNode<E> getRight() { 
            return right; 
        }

        public void setData(E theNewValue) { 
            data = theNewValue; 
        }

        public void setLeft(BSTNode<E> theNewLeft) { 
            left = theNewLeft; 
        }

        public void setRight(BSTNode<E> theNewRight) { 
            right = theNewRight; 
        }    
    }
}