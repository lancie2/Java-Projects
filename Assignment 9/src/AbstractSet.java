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

/**
 * Students are to complete this class. 
 * Students should implement as many methods
 * as they can using the Iterator from the iterator 
 * method and the other methods. 
 *
 */
public abstract class AbstractSet<E> implements ISet<E> {

    /* NO INSTANCE VARIABLES ALLOWED.
     * NO DIRECT REFERENCE TO UnsortedSet OR SortedSet ALLOWED.
     * (In other words the data types UnsortedSet and SortedSet
     * will not appear any where in this class.)
     * Also no direct references to ArrayList or other Java Collections.
     */
     
      
    
    public String toString() {
    
        StringBuilder result = new StringBuilder();
        String seperator = ", ";
        result.append("(");

        Iterator<E> it = this.iterator();
        while (it.hasNext()) {
            result.append(it.next());
            result.append(seperator);
        }
        // get rid of extra separator
        if (this.size() > 0)
            result.setLength(result.length() - seperator.length());

        result.append(")");
        return result.toString();
    }
    
    /**
     * A union operation. Add all items of otherSet that are not already present in this set
     * to this set.
     * @param otherSet != null
     * @return true if this set changed as a result of this operation, false otherwise.
     */
    public boolean addAll( ISet<E> otherSet ) {

    	boolean modified = false;
    
    	for( E value : otherSet ) {
    		if( !this.contains( value ) ) {
    			this.add( value );
    			modified = true;
    		}
    	}
    	
    	return modified;
    	
    }
    
    /**
     * Determine if item is in this set. 
     * <br>pre: item != null
     * @param item element whose presence is being tested. Item may not equal null.
     * @return true if this set contains the specified item, false otherwise.
     */
    public boolean contains( E item ) {
    	
    	if( this.size() > 0 ) {
    		for( E value : this ) {
    			if( value.equals( item ) ) {
    				return true;
    			}
    		}
    	}
    	
    	return false;
    	
    }
    
    /**
     * Determine if all of the elements of otherSet are in this set.
     * <br> pre: otherSet != null
     * @param otherSet != null
     * @return true if this set contains all of the elements in otherSet, 
     * false otherwise.
     */
    public boolean containsAll( ISet<E> otherSet ) {
    	
    	//check preconditions
    	if( otherSet.equals( null ) ) {
    		throw new IllegalArgumentException( "otherSet cannot be null!" );
    	}
    
    	boolean containsAll = true;
    
    	for( E thatValue : otherSet ) {
    		if( !this.contains( thatValue ) ) {
    			containsAll = false;
    		}
    	}
    	
    	return containsAll;
    				
    }
    
    /**
     * Determine if this set is equal to other.
     * Two sets are equal if they have exactly the same elements.
     * The order of the elements does not matter.
     * <br>pre: none
     * @param other the object to compare to this set 
     * @return true if other is a Set and has the same elements as this set
     */
    public boolean equals( Object other ) {
    	
    	if( !( other instanceof ISet<?> ) ) {
    		return false;
    	}
    	
    	ISet<E> that = (ISet<E>) other;
    	
    	if( this.size() != that.size() ) {
    		return false;
    	}
    	
    	boolean condition1 = this.containsAll( that );
    	boolean condition2 = that.containsAll( this );
    	
    	return condition1 && condition2;
    	
    }
    	

    
		/**
     * Return the number of elements of this set.
     * pre: none
     * @return the number of items in this set
     */
//    public int size() {
//    
//    	int size = 0;
//    	
//    	for( E item : this ) {
//    		if( !item.equals( null ) ) {
//    			size++;
//    		}
//    	}
//    	
//    	return size;
//    
//    }

}
