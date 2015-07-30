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
 * In this implementation of the ISet interface the elements in the Set are 
 * maintained in ascending order.
 * 
 * The data type for E must be a type that implements Comparable.
 * 
 * Students are to implement methods that were not implemented in AbstractSet 
 * and override methods that can be done more efficiently. An ArrayList must 
 * be used as the internal storage container. For methods involving two set, 
 * if that method can be done more efficiently if the other set is also a 
 * SortedSet do so.
 */
public class SortedSet<E extends Comparable<? super E>> extends AbstractSet<E> {

    private ArrayList<E> container;

    /**
     * create an empty SortedSet
     * O(1)
     */
    public SortedSet() {
    	
    	container = new ArrayList<E>();

    }

    /**
     * create a SortedSet out of an unsorted set. <br>
     * @param other != null
     */
    public SortedSet(ISet<E> other) {
    	container = new ArrayList<E>( other.size() );
    	
    	Iterator<E> listOther = other.iterator();
    	
    	while( listOther.hasNext() ) {
    		E value = listOther.next();
    		listOther.remove();
    		if( this.size() == 0 ) {
    			container.add( value );
    		}
    		else {
    			for( E thisValue : this ) {
    				if( thisValue.compareTo( value ) > 0 ) {
    					int index = container.indexOf( thisValue );
    					container.add( index, value);
    					break;
    				}
    				else {
    					container.add( value );
    				}
    			}
    		}
    	}
    	
    	
    }

    /**
     * Return the smallest element in this SortedSet.
     * <br> pre: size() != 0
     * @return the smallest element in this SortedSet.
     * Big O: O(1)
     */
    public E min() {
    	
    	Iterator<E> list = this.iterator();
    	
    	return list.next();

    }

    /**
     * Return the largest element in this SortedSet.
     * <br> pre: size() != 0
     * @return the largest element in this SortedSet.
     */
    public E max() {
    	
    	Iterator<E> list = this.iterator();
    	
    	int index = 0;
    	
    	while( index < this.size() - 1 ) {
    		list.next();
    		index++;
    	}
    	
    	return list.next();

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
		
		int originalSize = container.size();
		
		if( originalSize == 0 ) {
			container.add( item );
		}
		
		if( container.indexOf( item ) == -1 ) {
			ArrayList<Integer> temp = new ArrayList<Integer>( originalSize + 1 );
			for( E value : this ) {
				temp.add( value.compareTo( item ) );
			}
			System.out.println(temp);
			int index = temp.indexOf( 1 );
			if( index >= 0 ) {
				container.add( index, item );
			}
			else {
				container.add( item );
			}
		}
		
		return originalSize != container.size();
    
    }

	//ADD ALL
	
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
     * Determine if this set is equal to other.
     * Two sets are equal if they have exactly the same elements.
     * The order of the elements does not matter.
     * <br>pre: none
     * @param other the object to compare to this set 
     * @return true if other is a Set and has the same elements as this set
     * Big O: O(N)
     */
    public boolean equals( Object other ) {
    	
    	boolean good = false;
    	
    	if( other instanceof ISet<?> ) {
    		ISet<E> that = (ISet<E>) other;
    		
    		good = true;
    		Iterator<E> list1 = this.iterator();
    		Iterator<E> list2 = that.iterator();
    	
    		while( good && list1.hasNext() ) {
    			good = list1.next().equals( list2.next() );
    		}
    	}
    	
    	return good;
    	
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