/*  Student information for assignment:
 *
 *  On my honor, <NAME>, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name: Lancie Menchu	
 *  email address: lancie.menchu@utexas.edu
 *  UTEID: lam4356
 *  Section 5 digit ID: 53315
 *  Grader name:CHris
 *  Number of slip days used on this assignment: 2
 */

// add imports as necessary

import java.util.*;

public class HangmanManager {
	
	private static char BLANK = '-';

    // instance vars
	
	ArrayList<String> applicableWords;
	ArrayList<String> dictionary;
	ArrayList<Character> guesses;
	private String pattern;
	private int wordLength;
	private int guessesLeft;
	private int guessCount;
	private int difficulty;
    
	//constructor:  creates an arraylist of strings with all the words in the dictionary
    public HangmanManager(List<String> words) {
    	
    	dictionary = new ArrayList<String>();
    	
    	for(int index = 0; index < words.size(); index++) {
    		dictionary.add(words.get(index));
    	}

    }
    
    
    // pre: none
    // post: return the number of words in the original Dictionary with the given length
    public int numWords(int length) {
    	
    	int count = 0;
    	
    	for( int index = 0; index < dictionary.size(); index++ ) {
    		
    		if( dictionary.get( index ).length() == length ) {
    			count++;
    		}
    	}
    	
        return count;
    }


    // pre: numWords(wordLen) > 0, numGuesses >= 1, diff = HangmanMain.EASY, HangmanMain.MEDIUM, or HangmanMain.HARD
    public void prepForRound(int wordLen, int numGuesses, int diff) {
    	
    	if( wordLen <= 0 || numGuesses < 1 ) {
    		throw new IllegalArgumentException("Violation of Preconditions");
    	}
    	
    	wordLength = wordLen;
    	guessesLeft = numGuesses;
    	difficulty = diff;
    	guessCount = 0;
    	applicableWords = new ArrayList<String>();
    	
    	//create the blank pattern
    	StringBuilder patternBuilder = new StringBuilder();
    	
    	for(int index = 0; index < wordLength; index++) {
    		patternBuilder.append(BLANK);
    	}
    	
    	pattern = patternBuilder.toString();
    	
    	//get all applicable words
    	for(int index = 0; index < dictionary.size(); index++) {
    		
    		String currentWord = dictionary.get(index);
    		
    		if(currentWord != null && currentWord.length() == wordLength) {
    			applicableWords.add(currentWord);
    		}
    	}
    	
    	//generate a blank character array for players guesses
    	guesses = new ArrayList<Character>();
    }
    
    
    // pre: none
    // return the number of words that are still possibilities
    public int numWordsCurrent() {
    	
       return applicableWords.size();
    }
    
    
    // pre: none
    // return number of wrong guesses left in this game
    public int getGuessesLeft() {
    	
        return guessesLeft;
    }
    
    
    // pre: none
    // post: return a String version of the guesses made so far
    public String getGuessesMade() {
    	
        return guesses.toString();
    }
    
    
    // pre: none
    // post: return true if guess has already been used, false otherwise
    public boolean alreadyGuessed(char guess) {
    	
    	//boolan flag
    	boolean guessed = false;

    	if(guesses.contains(guess)) {
    		guessed = true;
    	}
    	
        return guessed;
    }
    
    
    // get the current pattern. (In other words the revealed characters and '-'s
    // for characters not yet revealed.
    public String getPattern() {
    	
        return pattern;
    }
    
    
    // pre: !alreadyGuessed(ch)
    // post: return a tree map with the resulting patterns and the number of
    // words in each of the new patterns.
    // the return value is for testing and debugging purposes
    public TreeMap<String, Integer> makeGuess(char guess) {
    	
    	if(alreadyGuessed(guess)) {
    		throw new IllegalStateException("You've already guessed " + guess);
    	}
        
    	//add guess to list of guesses then sort the guesses
    	guesses.add(guess);
    	Collections.sort(guesses);
    	
    	guessCount++;
    	
    	String originalPattern = pattern;
    	
    	TreeMap<String, ArrayList<String>> patternSet = new TreeMap<String, ArrayList<String>>();
    	TreeMap<String, Integer> patternCount = new TreeMap<String, Integer>();
    	
    	ArrayList<String> uniquePatterns = uniquePatterns(guess);
    	
    	for(int currentPattern = 0; currentPattern < uniquePatterns.size(); currentPattern++) {
        	
        	ArrayList<String> matchingWords = new ArrayList<String>();
        	String uniquePattern = uniquePatterns.get(currentPattern);
    		
    		for(int currentWord = 0; currentWord < applicableWords.size(); currentWord++) {
    			
    			String tempPattern = getPattern(applicableWords.get(currentWord), guess);
    			String word = applicableWords.get(currentWord);
    			
    			if(uniquePatterns.get(currentPattern).equalsIgnoreCase(tempPattern)) {
    				matchingWords.add(word);
    			}
    		}
    		
    		patternSet.put(uniquePattern, matchingWords);
    		patternCount.put( uniquePattern, matchingWords.size() );
    		
    	}
    	
    	int ultimatePatternCount = 0;			//pattern with highest value
    	int penultimatePatternCount = 0;		//pattern with second highest value
    	
    	String ultimatePattern = new String();
    	String penultimatePattern = new String();
    	
    	for( String currentPattern : patternSet.keySet() ) {
    		
    		if( patternCount.get(currentPattern) > ultimatePatternCount ) {
    			ultimatePatternCount = patternCount.get(currentPattern);
    			ultimatePattern = currentPattern;
    		}
    		
    		else if( patternCount.get(currentPattern) > penultimatePatternCount ) {
    			penultimatePatternCount = patternCount.get(currentPattern);
    			penultimatePattern = currentPattern;
    		}	
    	}
    		
    	if( ultimatePatternCount == penultimatePatternCount ) {
    		this.pattern = match( ultimatePattern, penultimatePattern );
    		applicableWords = patternSet.get( this.pattern );
    	}
    	
    	else {
    		applicableWords = difficultyModifier( ultimatePattern, penultimatePattern, patternSet );
    	}
    		
    	if( originalPattern.equalsIgnoreCase( this.pattern ) ) {
    		guessesLeft--;
    	}
    		
        return patternCount;
    }
    
    //helper method for getGuess that finds unique patterns for each guess
    private ArrayList<String> uniquePatterns(char guess) {
    	
    	ArrayList<String> result = new ArrayList<String>();
    	
    	for(int wordIndex = 0; wordIndex < applicableWords.size(); wordIndex++) {
    		String currentWord = applicableWords.get(wordIndex);
    		char[] temp = this.pattern.toCharArray();
    		
    		//inspect the word and check if it contains the guessed char
    		for(int index = 0; index < currentWord.length(); index++) {
    			if(currentWord.charAt(index) == guess) {
    				temp[index] = guess;
    			}
    		}
    		
    		String pattern = new String(temp);
    		
    		//if the pattern has not been added already, add it to the result
    		if(!result.contains(pattern)) {
    			result.add(pattern);
    		}
    	}
    	
    	return result;
    }
    
    //helper method for getGuess that finds the occurrences of a char in a word
    private String getPattern(String word, char guess) {
    	
    	char[] temp = pattern.toCharArray();
    	
    	for(int index = 0; index < word.length(); index++) {
    		if(word.charAt(index) == guess) {
    			temp[index] = guess;
    		}
    	}
    	
    	return new String(temp);
    }
    
    //helper method for getGuess that determines the results of a match
    private String match(String pattern1, String pattern2) {
    	
    	int blankCount1 = 0;
    	int blankCount2 = 0;
    	String result = "";
    	
    	for(int index = 0; index < pattern1.length(); index++) {
    		
    		if( pattern1.charAt(index) == BLANK ) {
    			blankCount1++;
    		}
    		
    		if( pattern2.charAt(index) == BLANK ) {
    			blankCount2++;
    		}
    	}
    	
    	if( blankCount1 == blankCount2 ) {
    		result = anotherMatch( pattern1, pattern2 );
    	}
    	
    	if( blankCount1 > blankCount2 ) {
    		result = pattern1;
    	}
    	
    	else {
    		result = pattern2;
    	}
    	
    	return result;
    }
    
    //helper method for match that breaks a second tie
    private String anotherMatch(String pattern1, String pattern2) {
    	
    	String result = "";
    	
    	if( pattern1.compareTo(pattern2) > 0 ) {
    		result = pattern1;
    	}
    	
    	else {
    		result = pattern2;
    	}
    	
    	return result;
    }
    
    //helper method for getGuess that determines which list to use based on the chosen difficulty
    private ArrayList<String> difficultyModifier ( String hardPattern, String lessHardPattern, TreeMap<String, ArrayList<String>> wordSet ) {
    	
    	ArrayList<String> result = new ArrayList<String>();
    	
    	if( difficulty ==  HangmanMain.HARD ) {
    		result = wordSet.get(hardPattern);
    		this.pattern = hardPattern;
    	}
    	else if ( difficulty == HangmanMain.MEDIUM ) {
    		
    		if( guessCount % 4 == 0 ) {
    			result = wordSet.get(lessHardPattern);
    			this.pattern = lessHardPattern;
    		}
    		
    		else {
    			result = wordSet.get(hardPattern);
    			this.pattern = hardPattern;
    		}
    	}
    	
    	else {
    		
    		if( guessCount % 2 == 0 ) {
    			result = wordSet.get(lessHardPattern);
    			this.pattern = lessHardPattern;
    		}
    		
    		else {
    			result = wordSet.get(hardPattern);
    			this.pattern = hardPattern;
    		}
    		
    	}
    		
    	return result;
    }
    
    // pre: numWordsCurrent() > 0
    // return the secret word the manager picked 
    // if there is more than one word left, pick one at random
    public String getSecretWord() {
    	
    	String result = new String();
    	
    	if( applicableWords.size() > 1 ) {

        	Random generator = new Random();
        	
        	result = applicableWords.get( generator.nextInt( applicableWords.size() ) );
    	}
    	
    	else {
    		
    		result = applicableWords.get(0);
    	}
    	
    	return result;
    }
}
