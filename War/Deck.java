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
public class Deck
{
   private Card[] deck = new Card[52];
   private int top;
   private int deckSize;
   
   //constructor, creates a new deck of 52 cards
   public Deck() {
       int index = 0;
       for(int suit = 0; suit <= 3; suit++) {
           for(int value = 1; value <= 13; value++) {
               deck[index] = new Card(suit, value);
               index++;
           }
       }
        
       top = 0;
       deckSize = 52;
   }
   //shuffles deck.  picks two random indecies and swaps them.
   public void shuffle() {     
       Random shuffler = new Random();
       for(int index = 0; index < 500; index++) {
           int card1Index = shuffler.nextInt(deckSize - top) + top;
           int card2Index = shuffler.nextInt(deckSize - top) + top;
           Card temp = deck[card1Index];
           deck[card1Index] = deck[card2Index];
           deck[card2Index] = temp;
       }
   }
   
   //deals the top card of the deck
   public Card dealCard() {
       Card dealtCard = deck[top];
       top++;
       return dealtCard;
   }
   
   //returns the value of top
   public int getTop() { return top; }
   
   //returns the deck size
   public int getDeckSize() { return deckSize; }
   
   //returns a represenatation of the decl as a string
   public String toString() {
       String deckString = new String();
       for(int index = 0; index < deckSize; index++) {
           deckString += deck[index].toString() + "\n";
       }
       return deckString;
   }
   
   //copies a card to a new deck
   public void setCard(Card card, int index) { this.deck[index] = card; }
   
   //creates a clone of the current deck 
   public Deck clone() {
       Deck newDeck = new Deck();
       for(int index = 0; index < deckSize; index++) {
           newDeck.setCard(deck[index], index);
       }
       return newDeck;
   }
               
}
