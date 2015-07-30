import java.awt.*;

/**
 * Author: Lancie Menchu
 * Date: 10/19/2012
 * CS 312 Assignment 5
 * 
 * EID: lam4356
 * Section: 52715
 * 
 * This is a simple program used to draw an image of an Android
 * 
 * Slip days used for this project: 0  Slip days used (total): 0
 * 
 */
 
public class Drawing1 {
    public static void main(String[] args) {
        DrawingPanel canvas = new DrawingPanel(700,700);
        Graphics pen = canvas.getGraphics();
        
        //define custom colors
        Color primaryGreen = new Color(153, 204, 0);
        Color secondaryGreen = new Color(102, 153, 0);
        Color primaryBlue = new Color(51, 181, 229);
        Color secondaryBlue = new Color(0, 153, 204);
        Color white = new Color(255, 255, 255);
        
        //draw androids!
        drawAndroid(65,50,pen,primaryGreen,white);
        drawAndroid(350,50,pen,secondaryGreen,white);
        drawAndroid(65,350,pen,primaryBlue,white);
        drawAndroid(350,350,pen,secondaryBlue,white);
        
    }
    
    //method combining methods used to draw each part of the Android
    public static void drawAndroid(int initialX, int initialY, Graphics pen, Color primary, Color secondary) {
        drawHead(initialX+35,initialY,pen,primary,secondary);
        drawBody(initialX+35,initialY+65,pen,primary);
        drawArm(initialX,initialY+65,pen,primary);
        drawArm(initialX+190,initialY+65,pen,primary);
        drawLeg(initialX+60,initialY+205,pen,primary);
        drawLeg(initialX+130,initialY+205,pen,primary);
    }
    
    //method used to draw the head of the Android
    public static void drawHead(int initialX, int initialY, Graphics pen, Color primary, Color secondary) {
        pen.setColor(primary);
        pen.fillOval(initialX,initialY,150,125);
        pen.setColor(secondary);
        pen.fillRect(initialX,initialY+60,150,150);
        pen.fillOval(initialX+30,initialY+30,12,12);
        pen.fillOval(initialX+110,initialY+30,12,12);
        drawAntenae(initialX+20, initialY-10, pen, primary);
    }
    
    //method used to draw the body of the Android
    public static void drawBody(int initialX, int initialY, Graphics pen, Color color) {
        pen.setColor(color);
        pen.fillRect(initialX,initialY,150,125);
        pen.fillRect(initialX+15,initialY+110,120,30);
        pen.fillOval(initialX+120,initialY+110,30,30);
        pen.fillOval(initialX,initialY+110,30,30);
    }
    
    //method used to draw the antenae of the Android
    public static void drawAntenae(int initialX, int initialY, Graphics pen, Color color) {
        pen.setColor(color);
        for(int index = 0; index < 4; index++) {
            pen.drawLine(initialX+index,initialY,initialX+20+index,initialY+40);
            pen.drawLine(initialX+110+index,initialY,initialX+90+index,initialY+40);
        }
    }

    //method used to draw the arms of the Android
    public static void drawArm(int initialX, int initialY, Graphics pen, Color color) {
        pen.setColor(color);
        pen.fillOval(initialX,initialY,30,30);
        pen.fillOval(initialX,initialY+75,30,30);
        pen.fillRect(initialX,initialY+15,30,75);
    }
    
    //method used to draw the legs of the Android
    public static void drawLeg(int initialX, int initialY, Graphics pen, Color color) {
        pen.setColor(color);
        pen.fillOval(initialX,initialY+25,30,30);
        pen.fillRect(initialX,initialY,30,40);
    }
}