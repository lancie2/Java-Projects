
/**
 * Author: Lancie Menchu
 * Date: 09/22/2012
 * CS 312 Assignment 3
 * 
 * EID: lam4356
 * Section: 52715
 * 
 * This program draws a rocket ship using a generalized set of static methods, 
 * using a single constant for reference.
 * 
 * Slip days used for this project: 0  Slip days used (total): 0
 */

public class RocketShip
{

    //Define Constants
    public static final int HEIGHT = 3;

    public static void main(String[] args) {
        
        drawRocket();
    }
    
    public static void drawRocket() {
        drawCone();
        drawSeperator();
        drawDiamondUpper();
        drawDiamondLower();
        drawSeperator();
        drawDiamondLower();
        drawDiamondUpper();
        drawSeperator();
        drawCone();
    }
    
    //This method draws the upper pointed portion of the diamond pattern of the rocket
    public static void drawDiamondUpper() {
        
        for(int index = 1; index <= HEIGHT; index++) {
            //draw left side border
            System.out.print("|");
            //pattern is always doubled
            for(int repeat = 1; repeat <= 2; repeat++) {
                //draw dots preceding diamond shape
                for(int dotIndex = 1; dotIndex <= HEIGHT - index; dotIndex++) {
                    System.out.print(".");
                }
                //draw diamond shape
                for(int slashIndex = 1; slashIndex <= index; slashIndex++) {
                    System.out.print("/\\");
                }
                //draw dots the follow diamond shape
                for(int dotIndex = 1; dotIndex <= HEIGHT - index; dotIndex++) {
                    System.out.print(".");
                }
            
            }
            //draw right side border
            System.out.print("|");
            //advance to next line
            System.out.println();
        }
    }
    
    //This method draws the lower pointed portion of the diamond pattern of the rocket
    public static void drawDiamondLower() {
        
        for(int index = 1; index <= HEIGHT; index++) {
            //draw left side border
            System.out.print("|");
            //pattern is always doubled
            for(int repeat = 1; repeat <= 2; repeat++) {
                //draw dots preceding diamond shape
                for(int dotIndex = 1; dotIndex < index; dotIndex++) {
                    System.out.print(".");
                }
                //draw diamond shape
                for(int slashIndex = 0; slashIndex <= HEIGHT - index; slashIndex++) {
                    System.out.print("\\/");
                }
                //draw dots the follow diamond shape
                for(int dotIndex = 1; dotIndex < index; dotIndex++) {
                    System.out.print(".");
                }
            
            }
            //draw right side border
            System.out.print("|");
            //advance to next line
            System.out.println();
        }
    }
    
    //This method draws the cone shapes that make the cone and engine of the rocket
    public static void drawCone() {
        
        for(int index = 1; index < HEIGHT * 2; index++) {
            //print white space
            for(int spaceIndex = 1; spaceIndex <= HEIGHT * 2 - index; spaceIndex++) {
                System.out.print(" ");
            }
            //print left side slope
            for(int slashIndex = 1; slashIndex <= index; slashIndex++) {
                System.out.print("/");
            }
            //print divider
            System.out.print("**");
            //print right side slope
            for(int slashIndex = 1; slashIndex <= index; slashIndex++) {
                System.out.print("\\");
            }
            //advance to next line
            System.out.println();
        }
    }
    
    //This method draws the distinctive border between each section of the rocket
    public static void drawSeperator() {
        //draw left side border
        System.out.print("+");
        //draw seperator pattern
        for(int index = 1; index <= HEIGHT * 2; index++) {
            System.out.print("=*");
        }
        //draw right side border
        System.out.print("+");
        //advance to next line
        System.out.println();
    }
             
}
        
/** Sample Output
 *  HEIGHT set at 3

     /**\
    //**\\
   ///**\\\
  ////**\\\\
 /////**\\\\\
+=*=*=*=*=*=*+
|../\..../\..|
|./\/\../\/\.|
|/\/\/\/\/\/\|
|\/\/\/\/\/\/|
|.\/\/..\/\/.|
|..\/....\/..|
+=*=*=*=*=*=*+
|\/\/\/\/\/\/|
|.\/\/..\/\/.|
|..\/....\/..|
|../\..../\..|
|./\/\../\/\.|
|/\/\/\/\/\/\|
+=*=*=*=*=*=*+
     /**\
    //**\\
   ///**\\\
  ////**\\\\
 /////**\\\\\
 
 * HEIGHT set to 7

             /**\
            //**\\
           ///**\\\
          ////**\\\\
         /////**\\\\\
        //////**\\\\\\
       ///////**\\\\\\\
      ////////**\\\\\\\\
     /////////**\\\\\\\\\
    //////////**\\\\\\\\\\
   ///////////**\\\\\\\\\\\
  ////////////**\\\\\\\\\\\\
 /////////////**\\\\\\\\\\\\\
+=*=*=*=*=*=*=*=*=*=*=*=*=*=*+
|....../\............/\......|
|...../\/\........../\/\.....|
|..../\/\/\......../\/\/\....|
|.../\/\/\/\....../\/\/\/\...|
|../\/\/\/\/\..../\/\/\/\/\..|
|./\/\/\/\/\/\../\/\/\/\/\/\.|
|/\/\/\/\/\/\/\/\/\/\/\/\/\/\|
|\/\/\/\/\/\/\/\/\/\/\/\/\/\/|
|.\/\/\/\/\/\/..\/\/\/\/\/\/.|
|..\/\/\/\/\/....\/\/\/\/\/..|
|...\/\/\/\/......\/\/\/\/...|
|....\/\/\/........\/\/\/....|
|.....\/\/..........\/\/.....|
|......\/............\/......|
+=*=*=*=*=*=*=*=*=*=*=*=*=*=*+
|\/\/\/\/\/\/\/\/\/\/\/\/\/\/|
|.\/\/\/\/\/\/..\/\/\/\/\/\/.|
|..\/\/\/\/\/....\/\/\/\/\/..|
|...\/\/\/\/......\/\/\/\/...|
|....\/\/\/........\/\/\/....|
|.....\/\/..........\/\/.....|
|......\/............\/......|
|....../\............/\......|
|...../\/\........../\/\.....|
|..../\/\/\......../\/\/\....|
|.../\/\/\/\....../\/\/\/\...|
|../\/\/\/\/\..../\/\/\/\/\..|
|./\/\/\/\/\/\../\/\/\/\/\/\.|
|/\/\/\/\/\/\/\/\/\/\/\/\/\/\|
+=*=*=*=*=*=*=*=*=*=*=*=*=*=*+
             /**\
            //**\\
           ///**\\\
          ////**\\\\
         /////**\\\\\
        //////**\\\\\\
       ///////**\\\\\\\
      ////////**\\\\\\\\
     /////////**\\\\\\\\\
    //////////**\\\\\\\\\\
   ///////////**\\\\\\\\\\\
  ////////////**\\\\\\\\\\\\
 /////////////**\\\\\\\\\\\\\

 
 */