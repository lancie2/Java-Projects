/*  Student information for assignment:
 *
 *  On my honor, <NAME>, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID:
 *  email address:
 *  Grader name:
 *  Number of slip days I am using:
 */

import java.util.Iterator;

public class LinkedList<E> implements IList<E> {
    // CS314 student. Add you instance variables here.
    // You decide what instance variables to use. 
    // Must adhere to assignment requirements. No ArrayLists or Java LinkedLists.
	private int size;
	private DoubleListNode<E> first;
	private DoubleListNode<E> last;
    
    private class LLIterator implements Iterator<E>{
    	
    	DoubleListNode<E> nextNode;
    	boolean remove;
    	int cursor;
    	
    	public LLIterator() {
    		nextNode = first;
    		cursor = -1;
    		remove = false;
    	}
    	
        public boolean hasNext() {
        	
        	return nextNode == null;
        }
        
        public E next() {
        	
        	if( !hasNext() ) {
        		throw new IllegalArgumentException("Out of Bounds.");
        	}
        	
        	DoubleListNode<E> initialValue = nextNode;
        	nextNode = nextNode.getNext();
    		remove = true;
        	cursor++;
        	
        	return initialValue.getData();
        }
        
        public void remove() {
        	
        	if(remove) {
        		LinkedList.this.remove( cursor );
        		remove = false;
        		cursor--;
        	}
        	
        }
    }
    
    /* @pre: item != null
     * @post: none
     * Adds an item to the list
     */
	public void add(E item){
		
		if(item == null) {
			throw new IllegalArgumentException("Violates Precondition: Item cannot be null.");
		}
		
		if(size == 0) {
			first = new DoubleListNode<E>( null, item, null );
			last = first;
			size++;
		}
		
		else {
			this.addLast( item );
		}

	}

	/*@pre: 0 <= pos <= size, item != null
	 * @post: size++, node @ pos == item, node @ pos-1 next --> item, node @ pos + 1 prev --> item
	 * inserts a node at the specified posistion
	 */
	public void insert(int pos, E item){
		
		if( pos > size || pos < 0 || item == null ) {
			throw new IllegalArgumentException("Violation of preconditions: 0 <= pos <= size, item != null");
		}
		
		DoubleListNode<E> targetPrev = nodeAtPos( pos );
		DoubleListNode<E> targetNext = targetPrev.getNext();
		DoubleListNode<E> target = new DoubleListNode<E>( targetPrev, item, targetNext );
		
		targetPrev.setNext( target );
		targetNext.setPrev ( target );
		
		size++;
	}

	
	public E set(int pos, E item){
		
		if( pos < 0 || pos > size || item == null ) {
			throw new IllegalArgumentException("Violation of preconditions.  0 < pos <= size or item != null.");
		}
		
		DoubleListNode<E> target = nodeAtPos( pos );
		E targetData = target.getData();
		target.setData( item );
		
		return targetData;
	}

	
	public E get(int pos){

		if( pos < 0 || pos > size ) {
			throw new IllegalArgumentException("Violation of preconditions.  0 < pos <= size.");
		}
		
		DoubleListNode<E> target = nodeAtPos( pos );
		
		return target.getData();
	}

	
	public E remove(int pos){
		
		if( pos < 0 || pos > size ) {
			throw new IllegalArgumentException("Violation of preconditions.  0 < pos <= size.");
		}
		
		DoubleListNode<E> target = nodeAtPos( pos );
		
		if( size == 1 ) {
			first = null;
			last = null;
		}
		
		else if( target == first ) {
			DoubleListNode<E> targetNext = target.getNext();
			targetNext.setPrev( null );
		}
		
		else if( target == last ) {
			DoubleListNode<E> targetPrev = target.getPrev();
			targetPrev.setNext( null );
		}
		
		else {
			DoubleListNode<E> targetPrev = target.getPrev();
			DoubleListNode<E> targetNext = target.getNext();
			targetPrev.setNext( targetNext );
			targetPrev.setNext( targetPrev );
		}
		
		size--;
		
		return target.getData();
		
	}

	
	public boolean remove(E obj){
		
		boolean found = false;
		int posistion = indexOf( obj );
		
		if( posistion != -1 ) {
			remove( posistion );
			found = true;
		}
		
		return found;
	}

	
	public IList<E> getSubList(int start, int stop){
		// TODO Auto-generated method stub
		
		LinkedList<E> result = new LinkedList<E>();
		
		for( int posistion = start; posistion < stop; posistion++ ) {
			result.add( nodeAtPos( posistion ).getData() );
		}
			
		return result;
	}

	/*@pre: none
	 * @post: none
	 * returns the size of the linked list
	 */
	public int size(){
		return size;
	}

	
	public int indexOf(E item) {
		
		return this.indexOf( item, 1 );
	}

	
	public int indexOf(E item, int pos){

		int posistion = pos;
		boolean found = false;
		
		while( !found ) {
			DoubleListNode<E> target = nodeAtPos( posistion );
			if( target.equals( item ) ) {
				found = true;
			}
			posistion++;
		}
		
		if( found ) {
			return posistion;
		}
		
		else {
			return -1;
		}

	}

	
	public void makeEmpty(){

		first = null;
		last = null;
		size = 0;

	}

	
	public Iterator<E> iterator(){
		// TODO Auto-generated method stub
		return new LLIterator();
	}
	
	/* @pre: 0 <= start < size(), start <= stop <= size()
	 */
    public void removeRange(int start, int stop) {
    	
    	if( 0 > start || start > size() || start > stop || stop > size() ) {
    		throw new IllegalArgumentException("Illegal Argument Exception: 0 <= start < size(), start <= stop <= size().");
    	}
    	
    	DoubleListNode<E> targetStart = nodeAtPos( start );
    	DoubleListNode<E> targetStop = nodeAtPos( stop );
    	
    	if( targetStart == first ) {
    		if( targetStop == last ) {
    			makeEmpty();
    		}
    		
    		else {
    			targetStop.getNext().setPrev( null );
    		}
    		
    	}
    	
    	else if( targetStop == last ) {
    		targetStart.getPrev().setNext( null );
    	}
    	
    	else {
    		targetStart.getPrev().setNext( targetStop.getNext() );
    		targetStop.getNext().setPrev( targetStart.getPrev() );
    	}
    }
	
	/**
	 * add item to the front of the list.
	 * <br>pre: item != null
	 * <br>post: size() = old size() + 1, get(0) = item
	 * @param item the data to add to the front of this list
	 */
	public void addFirst(E item) {
		
		if( item == null ) {
			throw new IllegalArgumentException("The item cannot be null.");
		}
		
		DoubleListNode<E> newNode = new DoubleListNode<E>( null, item, first );
		first.setPrev( newNode );
		first = newNode;
		
		size++;
	}


	/**
	 * add item to the end of the list.
	 * <br>pre: item != null
	 * <br>post: size() = old size() + 1, get(size() -1) = item
	 * @param item the data to add to the end of this list
	 */
	public void addLast(E item){
		
		if( item == null ) {
			throw new IllegalArgumentException("The item cannot be null.");
		}
		
		DoubleListNode<E> newNode = new DoubleListNode<E>( last, item, null );
		last.setNext( newNode );
		last = newNode;
		
		size++;
	}


	/**
	 * remove and return the first element of this list.
	 * <br>pre: size() > 0
	 * <br>post: size() = old size() - 1
	 * @return the old first element of this list
	 */
	public E removeFirst() {	
		
		if( size == 0 ) {
			throw new IllegalArgumentException("Size must be greater than 0: " + size);
		}
		
		DoubleListNode<E> target = first;
		
		remove( 1 );
		
	    return target.getData();
	}


	/**
	 * remove and return the last element of this list.
	 * <br>pre: size() > 0
	 * <br>post: size() = old size() - 1
	 * @return the old last element of this list
	 */
	public E removeLast(){	
		
		if( size == 0 ) {
			throw new IllegalArgumentException("Size must be greater than 0: " + size);
		}
		
		DoubleListNode<E> target = last;
		
		remove( size - 1 );
		
	    return target.getData();
	}


	public String toString() {	
		
		StringBuilder result = new StringBuilder();
		
		result.append( "[" );
		
		if( size > 0 ) {
			for( int index = 0; index < size - 1; index++ ) {
				result.append( get(index) );
				result.append( ", " );
			}
		
			result.append( get( size - 1 ) );
		}
		
		result.append("]");
		
	    return result.toString();
	}


	/**
	 * check if this list is equal to another Object.
	 * <br>pre: none
	 * @return true if other is a non null LinkedList object
	 * with the same elements as this LinkedList in the same
	 * order.
	 */
	public boolean equals(Object other){
		
		boolean equal = false;
		
	    if( this.getClass() == other.getClass() ) {
	    	equal = true;
	    	for( int index = 0; index < size; index++ ) {
	    		if( !this.get( index ).equals( ( ( LinkedList<E>) other ).get( index ) ) ){
	    			equal = false;
	    		}
	    	}
	    }
	    
	    return equal;
	}
	
	/*@pre: none, pos checked in caling method
	 * @post: none
	 */
	private DoubleListNode<E> nodeAtPos( int pos ) {
		
		DoubleListNode<E> target = first;
		
		for( int index = 0; index < pos; index++ ) {
			target = target.getNext();
		}
			
		return target;
	}

}