
/**
 * Author: Lancie Menchu
 * Date: 09/09/2012
 * CS 312 Assignment 2
 * 
 * EID: lam4356
 * Section: 52715
 * 
 * This is a simple program that will display the song, "The Twelve Days of Christmas."  
 * The assignment is designed to show the benefit of using static methods.
 * 
 * Slip days used for this project: 0  Slip days used (total): 0
 * 
 */

public class Song
{
    public static void main(String[] args)
    {
        //code goes here
        System.out.println("On the first day of Christmas,\nMy True Love sent to me");
        verseOne();
        
        System.out.println("On the second day of Christmas,\nMy True Love sent to me");
        verseTwo();
        
        System.out.println("On the third day of Christmas,\nMy True Love sent to me");
        verseThree();
        
        System.out.println("On the fourth day of Christmas,\nMy True Love sent to me");
        verseFour();
        
        System.out.println("On the fifth day of Christmas,\nMy True Love sent to me");
        verseFive();
        
        System.out.println("On the sixth day of Christmas,\nMy True Love sent to me");
        verseSix();
        
        System.out.println("On the seventh day of Christmas,\nMy True Love sent to me");
        verseSeven();
        
        System.out.println("On the eighth day of Christmas,\nMy True Love sent to me");
        verseEight();
        
        System.out.println("On the ninth day of Christmas,\nMy True Love sent to me");
        verseNine();
        
        System.out.println("On the tenth day of Christmas,\nMy True Love sent to me");
        verseTen();
        
        System.out.println("On the eleventh day of Christmas,\nMy True Love sent to me");
        verseEleven();
        
        System.out.println("On the twelfth day of Christmas,\nMy True Love sent to me");
        verseTwelve();
    }
    
    public static void verseOne() 
    {
        lineOne();
        System.out.println();
    }
    
    public static void verseTwo() 
    {
        lineTwo();
        verseOne();
    }
    
    public static void verseThree() 
    {
        lineThree();
        verseTwo();
    }
    
    public static void verseFour() 
    {
        lineFour();
        verseThree();
    }
    
    public static void verseFive() 
    {
        lineFive();
        verseFour();
    }
    
    public static void verseSix() 
    {
        lineSix();
        verseFive();
    }
    
    public static void verseSeven() 
    {
        lineSeven();
        verseSix();
    }
    
    public static void verseEight() 
    {
        lineEight();
        verseSeven();
    }
    
    public static void verseNine() 
    {
        lineNine();
        verseEight();
    }
    
    public static void verseTen() 
    {
        lineTen();
        verseNine();
    }
    
    public static void verseEleven() 
    {
        lineEleven();
        verseTen();
    }
    
    public static void verseTwelve() 
    {
        lineTwelve();
        verseEleven();
    }
    
    public static void lineOne()
    {
        System.out.println("A partridge in a pear tree.");
    }
    
    public static void lineTwo()
    {
        System.out.println("Two turtle-doves and");
    }
    
    public static void lineThree()
    {
        System.out.println("Three French hens,");
    }
    
    public static void lineFour()
    {
        System.out.println("Four calling birds,");
    }
    
    public static void lineFive()
    {
        System.out.println("Five golden rings,");
    }
    
    public static void lineSix()
    {
        System.out.println("Six geese a-laying,");
    }
    
    public static void lineSeven()
    {
        System.out.println("Seven swans a-swimming,");
    }
    
    public static void lineEight()
    {
        System.out.println("Eight maids a milking,");
    }
    
    public static void lineNine()
    {
        System.out.println("Nine ladies dancing,");
    }
    
    public static void lineTen()
    {
        System.out.println("Ten lords a-leaping,");
    }
    
    public static void lineEleven()
    {
        System.out.println("Eleven pipers piping,");
    }
    
    public static void lineTwelve()
    {
        System.out.println("Twelve drummers drummings,");
    }
    
    //modified later
    public static String(int day) {
        System.out.println("On the " +
}