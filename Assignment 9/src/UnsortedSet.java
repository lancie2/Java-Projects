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

import java.util.Iterator;
import java.util.ArrayList;

/**
 * A simple implementation of an ISet. 
 * Elements are not in any particular order.
 * Students are to implement methods that 
 * were not implemented in AbstractSet and override
 * methods that can be done more efficiently. 
 * An ArrayList must be used as the internal storage container.
 *
 */
public class UnsortedSet<E> extends AbstractSet<E> {
	
	private ArrayList<E> container;
	
	//constructor
	public UnsortedSet() {
		container = new ArrayList<E>();
	}
	
	/**
     * Add an item to this set.
     * <br> item != null
     * @param item the item to be added to this set. item may not equal null.
     * @return true if this set changed as a result of this operation, false otherwise.
     * Big O: O(N)
     */
	public boolean add( E item ) {
		
		// Check preconditions
		if( item.equals( null ) ) {
			throw new IllegalArgumentException("Item cannot be null");
		}
		
		boolean modified = false;
		
		// Add item to ArrayList if it isn't already present
		if( !this.contains( item ) ) {
			container.add( item );
			modified = true;
		}
		
    	return modified;
    
    }
    
	/**
     * Make this set empty.
     * <br>pre: none
     * <br>post: size() = 0
     */
    public void clear() {
    
    	container = new ArrayList<E>();
    
    }
    
    /**
     * Create a new set that is the difference of this set and otherSet. Return an ISet of 
     * elements that are in this Set but not in otherSet. Also called
     * the relative complement. 
     * <br>Example: If ISet A contains [X, Y, Z] and ISet B contains [W, Z] then
     * A.difference(B) would return an ISet with elements [X, Y] while
     * B.difference(A) would return an ISet with elements [W]. 
     * <br>pre: otherSet != null
     * <br>post: returns a set that is the difference of this set and otherSet.
     * Neither this set or otherSet are altered as a result of this operation.
     * <br> pre: otherSet != null
     * @param otherSet != null
     * @return a set that is the difference of this set and otherSet
     * Big O: O(N^2)
     */
    public ISet<E> difference( ISet<E> otherSet ) {
    	
    	//check preconditions
    	if( otherSet.equals( null ) ) {
    		throw new IllegalArgumentException( "otherSet cannot be null!");
    	}
    	
    	ISet<E> result = new UnsortedSet<E>();
    
    	for( E thisData : this ) {
    		if( !otherSet.contains( thisData ) ) {
    			result.add( thisData );
    		}
    	}
    		
    	return result;    		
    
    }
    
    /**
     * create a new set that is the intersection of this set and otherSet.
     * <br>pre: otherSet != null<br>
     * <br>post: returns a set that is the intersection of this set and otherSet.
     * Neither this set or otherSet are altered as a result of this operation.
     * <br> pre: otherSet != null
     * @param otherSet != null
     * @return a set that is the intersection of this set and otherSet
     * Big O: O(N^2)
     */
    public ISet<E> intersection( ISet<E> otherSet ) {
    
    	//check preconditions
    	if( otherSet.equals( null ) ) {
    		throw new IllegalArgumentException( "otherSet cannot be null!");
    	}
    	
    	ISet<E> result = new UnsortedSet<E>();
    	
    	for( E value : this ) {
    		if( otherSet.contains( value ) ) {
    			result.add( value );
    		}
    	}
    	
    	return result;
    	
    }
    
    /**
     * Return an Iterator object for the elements of this set.
     * pre: none
     * @return an Iterator object for the elements of this set
     * Big O: O(1)
     */
    public Iterator<E> iterator() {
    
    	return container.iterator();
    	
    }
    
    /**
     * Remove the specified item from this set if it is present.
     * pre: item != null
     * @param item the item to remove from the set. item may not equal null.
     * @return true if this set changed as a result of this operation, false otherwise
     * Big O: O(N)
     */
    public boolean remove( E item ) {
    	
    	boolean modified = false;
    	
    	if( this.contains( item ) ) {
    		modified = true;
    		int itemIndex = container.indexOf( item );
    		container.remove( itemIndex );
    	}
    
    	return modified;
    
    }
    
    /**
     * Return the number of elements of this set.
     * pre: none
     * @return the number of items in this set
     * Big O: O(1)
     */
    public int size() {
    
    	return container.size();
    
    }
    
    /**
     * Create a new set that is the union of this set and otherSet.
     * <br>pre: otherSet != null
     * <br>post: returns a set that is the union of this set and otherSet.
     * Neither this set or otherSet are altered as a result of this operation.
     * <br> pre: otherSet != null
     * @param otherSet != null
     * @return a set that is the union of this set and otherSet
     * Big O: O(N^2)
     */
    public ISet<E> union( ISet<E> otherSet ) {
    	
    	if( otherSet.equals( null ) ) {
    		throw new IllegalArgumentException("otherSet cannot be null!");
    	}
    	
    	ISet<E> result = new UnsortedSet<E>();
    	
    	result.addAll( this );
    	result.addAll( otherSet );
    
    	return result;
    	
    }

}
