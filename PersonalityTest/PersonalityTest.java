import java.util.*;
import java.io.*;

/**
 * Author: Lancie Menchu
 * Date: 11/18/2012
 * CS 312 Assignment 7
 * On my honor, Lancie Menchu, this programming assignment is my own work. 
 * 
 * EID: lam4356
 * Section: 52715
 * 
 * This program reads the results of a personality test from a file, then analyzes and writes
 * those results to another file.
 * 
 * Slip days used for this project: 0  Slip days used (total): 0
 * 
 */
 
public class PersonalityTest {

    public static final int DIMENSIONS = 4;
    
    public static void main(String[] args) throws IOException {
        
        Scanner console = new Scanner(System.in);
        
        //Get input file name
        System.out.print("Input file name: ");
        File inFile = new File(console.next());
        
        //verify file exists, if not propmpt user again
        while(!inFile.exists()) {
            System.out.print("File not found.  Try again: ");
            inFile = new File(console.next());
        }
        
        //get output file name
        System.out.print("Output file name: ");
        File outFile = new File(console.next());
        
        //process data and write to <outFile>.txt
        processFile(inFile, outFile);
        
    }
    
    
    //This method accepts an inFile object and outFile object and processes all the data
    public static void processFile(File inFile, File outFile) throws IOException {
        
        //create objects
        Scanner read = new Scanner(inFile);
        PrintStream write = new PrintStream(outFile);
        String name = new String();
        String answers = new String();
        
        //read input file and process data
        while(read.hasNextLine()) {
            name = read.nextLine();
            //System.out.println("NAME: " + name);
            answers = read.nextLine();
            //System.out.println("ANSWERS: " + answers);
            int[] answersProcessed = new int[DIMENSIONS];
            String results = new String();
            results = processAnswers(answersProcessed, answers);
            //write to output file
            write.println(name + ": " + Arrays.toString(answersProcessed) + " = " + results);
        }
    }
    
    /*
     * This method accepts an int array which it also modifies, a string containing the answers for
     * each testee to the personality test, and a string containing each testee's answers
     */
    public static String processAnswers(int[] answersProcessed, String answers) {
        
        //create string to hold results from the test
        String results = new String();
        
        //these strngs contain the possible outcomes of each dimension of the test
        char[] resultsA = {'E', 'S', 'T', 'J'};
        char[] resultsB = {'I', 'N', 'F', 'P'};
        
        //Check answers for dimension 1        
        char[] answers1 = new char[answers.length() / 7];
        for(int i = 0; i < answers.length() / 7; i++) {
            answers1[i] = answers.charAt(i * 7);
        }
        answersProcessed[0] = processDimension(answers1);
        
        //Check answers for dimension 2
        int j = 0;
        char[] answers2 = new char[answers.length() / 7 * 2];
        for(int i = 0; i < answers.length() / 7 * 2; i += 2) {
            answers2[i] = answers.charAt(j * 7 + 1);
            answers2[i+1] = answers.charAt(j * 7 + 2);
            j++;
        }
        answersProcessed[1] = processDimension(answers2);
        
        //check answers for dimension 3
        j = 0;
        char[] answers3 = new char[answers.length() / 7 * 2];
        for(int i = 0; i < answers.length() / 7 * 2; i += 2) {
            answers3[i] = answers.charAt(j * 7 + 3);
            answers3[i+1] = answers.charAt(j * 7 + 4);
            j++;
        }
        answersProcessed[2] = processDimension(answers3);
        
        //check answers for dimension 4
        j = 0;
        char[] answers4 = new char[answers.length() / 7 * 2];
        for(int i = 0; i < answers.length() / 7 * 2; i += 2) {
            answers4[i] = answers.charAt(j * 7 + 5);
            answers4[i+1] = answers.charAt(j * 7 + 6);
            j++;
        }
        answersProcessed[3] = processDimension(answers4);
        
        //Process results string
        for(int i = 0; i < DIMENSIONS; i++) {
            if(answersProcessed[i] > 50) { results += resultsB[i]; }
            else if(answersProcessed[i] < 50) { results += resultsA[i]; }
            else { results += 'X'; }
        }
         
        //pass back results string
        return results;
    }
    
    /*
     * This method takes the testee's answers for each dimension of the personality test
     * and determines their answer for each question, totalling "A" answers and "B" answers.  
     * It then processes these into a percentage, and passes this value back.
     */
    public static int processDimension(char[] answers) {
        int a = 0;
        int b = 0;
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == 'A' || answers[i] == 'a') { a++; }
            if(answers[i] == 'B' || answers[i] == 'b') { b++; }
        }
        //System.out.println("a = " + a + ", b = " + b);
        double percentage = (double)b / ((double)a + b) * 100;
        int percent = (int)Math.round(percentage);
        return percent;
    }
}

/*
 * SAMPLE OUTPUT
 * JAVA:
 * Input file name: notfound.txt
 * File not found.  Try again: foo.txt
 * File not found.  Try again: personality.txt
 * Output file name: output.txt
 * output.txt:
 * Betty Boop: [90, 15, 10, 10] = ISTJ
 * Snoopy: [30, 45, 30, 70] = ESTP
 * Bugs Bunny: [20, 45, 15, 55] = ESTP
 * Daffy Duck: [100, 6, 20, 6] = ISTJ
 * The frumious bandersnatch: [86, 95, 75, 78] = INFP
 * Minnie Mouse: [67, 28, 32, 5] = ISTJ
 * Luke Skywalker: [89, 61, 26, 25] = INTJ
 * Han Solo: [80, 50, 45, 25] = IXTJ
 * Princess Leia: [80, 50, 50, 5] = IXXJ
 */
