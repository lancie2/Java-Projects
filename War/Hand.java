
/**
*  author: Lancie Menchu
*  date:  12/07/2012
*  CS 312 Assignment 9
*  On my honor, Lancie Menchu, this programming assignment is my own work. 
*
*  EID: lam4356
*  Section: 52705
*
* This program simulates a card game known as war.
*
* Slip Days I am using on this project: 0
* Slip Days I have used this semester: 1
*/
public class Hand {

    private int size = 0;
    Card[] hand;
    
    //constructor, creates a new hand
    public Hand() {
        //this.size = 0;
        this.hand = new Card[1];
    }
    
    //returns the current size of the deck
    public int size() { return size; }
    
    //prints out the deck as a list of strings representing each card
    public String toString() {
        String deckString = new String();
        for(int index = 0; index < size; index++) {
            System.out.println(hand[index].toString());
        }
        return deckString;
    }
    
    //checks if the current hand is empty
    public boolean isEmpty() {
        if(size > 0) return false;
        return true;
    }
    
    //creates an exact copy of the current hand
    public Card[] clone() {
        Card[] copy = new Card[size];
        for(int index = 0; index < size; index++) {
            copy[index] = hand[index];
        }
        return copy;
    }
    
    //adds a card to the current hand
    public void addCard(Card c) {
        this.size++;
        Card[] temp = hand.clone();
        hand = new Card[size];
        for(int index = 0; index < size - 1; index++) {
            hand[index] = temp[index];
        }
        hand[size - 1] = c;
        
    }
    
    //deals a card from the current hand
    public Card getNext() {
        Card[] temp = hand.clone();
        Card returnCard =   temp[0].clone();
        size--;
        hand = new Card[size];
        for(int index = 0; index < size; index++) {
            hand[index] = temp[index + 1];
        }
        return returnCard;
    }
}
