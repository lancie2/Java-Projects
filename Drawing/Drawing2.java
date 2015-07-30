import java.awt.*;
/**
 * Author: Lancie Menchu
 * Date: 10/19/2012
 * CS 312 Assignment 5
 * 
 * EID: lam4356
 * Section: 52715
 * 
 * This is a simple program used to draw a square filled with concentric circles
 * and patterns of said square
 * 
 * Slip days used for this project: 0  Slip days used (total): 0
 * 
 */
public class Drawing2
{
   public static void main(String[] args) {
       //create canvas
       DrawingPanel canvas = new DrawingPanel(550,450);
       Graphics pen = canvas.getGraphics();
       canvas.setBackground(Color.CYAN);
       
       //draw square patterns
       //pattern(initial x coordinate, initial y coordinate, width of square, number of circles within
       //and a graphics object
       pattern(0,0,100,10,1,pen);
       pattern(12,155,30,5,8,pen);
       pattern(305,10,48,6,4,pen);
       pattern(300,225,70,7,3,pen);
    }
    
    
    //This method draws each box within each pattern, takes initial x, initial y, and width in pixels; the number 
    //of circles within, and a graphics object
    public static void drawBox(int initialX, int initialY, int size, int circles, Graphics pen) {
        //set square background color and create background
        pen.setColor(Color.GREEN);
        pen.fillRect(initialX, initialY, size, size);
        
        //define overlay color and draw outside border
        pen.setColor(Color.BLACK);
        pen.drawRect(initialX, initialY, size, size);
        
        //variables used in for loop
        int multiple = size/(2*circles);
        int length = size/circles;
        
        //draw concentric circles
        for(int index = 0; index < circles; index++){
            pen.drawOval(initialX + multiple*index, initialY + multiple*index, size - length*index, size - length*index);
        }
    }
    
    //This method uses the method defined above and draws multiple instances in a square shape
    public static void pattern(int initialX, int initialY, int squareSize, int circles, int rowNum, Graphics pen) {
        for(int rows = 1; rows <= rowNum; rows++) {
            for(int index = initialX; index < initialX+squareSize*rowNum; index+=squareSize) {
                drawBox(index, initialY, squareSize, circles, pen);
            }
            initialY += squareSize;
        }
    }
}
