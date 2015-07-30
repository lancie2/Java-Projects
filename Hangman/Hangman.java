import java.io.*;
import java.util.*;
import java.awt.*;

/* author: Lancie Menchu
 * date: 11/30/2012
 * CS 312 Assignment 9
 * On my honor, Lancie Menchu, this programming assignmengt is my work, and mine alone.
 * 
 * EID: lam4356
 * Section: 56715
 * This program runs a game of hangman.
 * 
 * Slip Days I am using on this project: 0
 * Slip Days I have used this semester: 0
 */

public class Hangman {

    //Class constants for body parts
    public static final int HEAD = 0;
    public static final int BODY = 1;
    public static final int ARM1 = 2;
    public static final int ARM2 = 3;
    public static final int LEG1 = 4;
    public static final int LEG2 = 5;
    
    public static void main(String[] args) throws IOException {
        
        String word = pickWord("dictionary.txt");
        playGame(word);
        
    }
    
    //This method draws the next body part on the hangman.
    public static void draw(int part, Graphics g) {
        
        //code goes here
        
    }
    
    //This method returns a randomly chosen word from the file
    public static String pickWord(String f) throws IOException {
        
        //read in number of words in file
        Scanner read = new Scanner(new File(f));
        int wordCount = read.nextInt();
        read.next();
        
        //read each word as an element of a string array
        String[] words = new String[wordCount];
        for(int wordsIndex = 0; wordsIndex < wordCount; wordsIndex++) {
            words[wordsIndex] = read.nextLine();
        }
        
        Random rand = new Random();
        int num = rand.nextInt(wordCount);
        //String word = words[rand];
        //return a randomly chosen word from the string array
        return words[num];
        
    }      
        
    
    public static void playGame(String word) {
        
        //create grahics objects gto raw hangman
        DrawingPanel canvas = new DrawingPanel(500, 500);
        Graphics pen = canvas.getGraphics();
        
        //define flag for while loop
        boolean gameOver = false;
        
        //create a boolean array with elements equal to the number of letters to guess
        boolean[] letters = new boolean[word.length()];
        
        //Create a string that stores all letters that have been guessed
        String guesses = "";
        
        //create an int variable that stores the number of wrong guesses
        int wrongGuesses = 0;
        
        //create a scanner object that reads in user guesses.
        Scanner console = new Scanner(System.in);
        
        //meat of the game
        while(!gameOver) {
            
            //prompt user for a guess
            System.out.print("Guess a letter: ");
            char guess = Character.toLowerCase(console.next().charAt(0));
            
            
            //check to see if the user has guessed this letter before
            boolean freshGuess = true;
            for(int index = 0; index < guesses.length(); index++) {
                System.out.println("Guesses[i] = " + guesses.charAt(index) + ", Guess = " + guess);
                if(guess == guesses.charAt(index)) { 
                    freshGuess = false;
                }
            }
            
            //if the guess is fresh, check if it is correct
            boolean correctGuess = false;
            if(freshGuess) {
                
                for(int index = 0; index < word.length(); index++) {
                    if(guess == word.charAt(index)) { 
                        letters[index] = true;
                        correctGuess = true;
                    }
                }
                
                if(correctGuess) {
                    System.out.println("Good guess! The word is:");
                    gameOver = !printGuess(letters, word);
                }
                
                else{
                    System.out.println("Oops! Letter " + guess + " is not there.  Adding to hangman... ");
                    draw(wrongGuesses, pen);
                    wrongGuesses++;
                    if(wrongGuesses == 6) { gameOver = true; }
                }
                
                guesses += guess;
            }
            
            //report repeated guess
            else { 
                System.out.println("You have already guessed " + guess + ".");
            }
            
            
        }
        
        //The game is over
        System.out.println("Game Over!");
        
    }
    
    public static boolean printGuess(boolean[] letters, String word) {
        
        //create the display word based on the guesses made, then display it
        String displayWord = "";
        for(int index = 0; index < word.length(); index++) {
            if(letters[index]) { displayWord += word.charAt(index); }
            else { displayWord += '-'; }
        }
        System.out.println(displayWord);
        
        //check if there are still letters to guess
        for(int index = 0; index < letters.length; index++) {
            if(!letters[index]) { return true; }
        }
        
        //no more letters to guess!
        return false;
    }
    
}
