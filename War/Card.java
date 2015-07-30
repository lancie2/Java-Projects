import java.util.*;

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
public class Card {

    //card attributes
    private int suit;
    private int value;
    
    //define suits
    private final int SPADES = 3;
    private final int HEARTS = 2;
    private final int DIAMONDS = 1;
    private final int CLUBS = 0;
    
    //define face cards
    private final int ACE = 1;
    private final int JACK = 11;
    private final int QUEEN = 12;
    private final int KING = 13;
    
    //default cnstructor, creates a random card
    public Card() {
        Random generator = new Random();
        //generate suit
        suit = generator.nextInt(4);    
        //generate value
        value = generator.nextInt(13) + 1;
    }
    
    //specific constructor, creates a specific card
    public Card(int suit, int value) {
        //assign given values
        this.suit = suit;
        this.value = value;
    }
        
    //returns true if the current card's value is greater than the one passed in
    public boolean compareValue(Card other) {
        if(this.value > other.value) return true;
        return false;
    }
    
    //returns a new card object identical to the current card
    public Card clone() {  return new Card(this.suit, this.value); }
    
    //compares the value of the current card with another, returns true if they are equal
    public boolean equals(Card other)  { return this.value == other.value; }
    
    //Retrun a string representing the card's suit, returns "??" if invalid
    public String getSuitAsString() { 
        switch(suit) {
            case SPADES:    return "Spades";
            case HEARTS:    return "Hearts";
            case DIAMONDS:  return "Diamonds";
            case CLUBS:     return "clubs";
            default:        return "??";
        }
    }
    
    //return  string representing the card's value, return "??" if invalid
    public String getValueAsString() {
        switch(value) {
            case ACE:   return "Ace";
            case 2:     return "2";
            case 3:     return "3";
            case 4:     return "4";
            case 5:     return "5";
            case 6:     return "6";
            case 7:     return "7";
            case 8:     return "8";
            case 9:     return "9";
            case 10:    return "10";
            case JACK:  return "Jack";
            case QUEEN: return "Queen";
            case KING:  return "King";
            default:    return "??";
        }
    }
    
    //return a string representation fo the card
    public String toString() { return getValueAsString() + " of " + getSuitAsString(); }
}
