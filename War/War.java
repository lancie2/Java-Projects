
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
public class War
{
    public static void main(String[] args) {
        //crack open a fresh deck of cards
        Deck gameDeck = new Deck();
        //shuffle the deck
        gameDeck.shuffle();
        //hand objects to hold each player's hands
        Hand player1 = new Hand();
        Hand player2 = new Hand();
        //deal the cards, remember to alternate
        while(gameDeck.getTop() < gameDeck.getDeckSize()) {
            //deal a card to player 1
            Card dealerCard = gameDeck.dealCard();
            player1.addCard(dealerCard);
            //deal a card to player 2
            dealerCard = gameDeck.dealCard();
            player2.addCard(dealerCard);
        }
        //hands are ready, time to play
        playWar(player1, player2);
    }
    
    //the game of war
    public static void playWar(Hand player1, Hand player2) {
        //intro for the game:
        System.out.println("Playing War!");
        System.out.println("Cards dealt - here are the hands:");
        System.out.println("Player 1:");
        System.out.println(player1.toString());
        System.out.println("Player 2:");
        System.out.println(player2.toString());
        //counting variables for the program
        int rounds = 0;
        int wars = 0;
        //gameCards is a hand object that collects each card as it is played
        Hand gameCards = new Hand();
        //these card objects represent each players card in the game
        Card player1Card;
        Card player2Card;
        //crate a boolean object for the game
        boolean gameOn = true;
        //let's go to war
        while(gameOn) {
            //player 1 plays a card
            player1Card = player1.getNext();
            gameCards.addCard(player1Card);
            //player 2 plays a card
            player2Card = player2.getNext();
            gameCards.addCard(player2Card);
            //check for war
            if(player1Card.equals(player2Card) && player1.size() > 0 && player2.size() > 0) {
                //let loose the dogs of war
                wars++;
                //each player puts another card on the table
                gameCards.addCard(player1.getNext());
                gameCards.addCard(player2.getNext());
            }
            //check if player1 ... won
            if(player1Card.compareValue(player2Card)) {
                rounds++;
                while(gameCards.size() > 0) { player1.addCard(gameCards.getNext()); }
            }
            
            //check if player 2 won
            else {
                rounds++;
                while(gameCards.size() > 0) { player2.addCard(gameCards.getNext()); }
            }
            //check for endgame scenarios
            if(player1.isEmpty() || player2.isEmpty()) {
				gameOn = false;
			}
            if(rounds == 5000) {
				gameOn = false;
			}
        }
        //endgame readout
        System.out.println("Hands at the end of the game:");
        System.out.println("Player 1:");
        System.out.println(player1.toString());
        System.out.println("Player 2:");
        System.out.println(player2.toString());
        System.out.println("Results of the game:");
        //readout if draw
        if(rounds == 5000) {
            System.out.println("No winner.");
            System.out.println("Player 1 has " + player1.size() + " cards.");
            System.out.println("Player 2 has " + player2.size() + " cards.");
        }
        //readout if winner
        else {
            String winner = new String();
            if(player1.size() != 0) { winner = "Player 1"; }
            else { winner = "Player 2"; }
            System.out.println("Winner: " + winner);
            System.out.println("Number of rounds: " + rounds);
        }
            
        
    }
}
