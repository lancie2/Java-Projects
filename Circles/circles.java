import java.awt.*;

/**
 * Author: Lancie Menchu
 * Date: <DATE>
 * CS 312 Assignment <#>
 * 
 * EID: lam4356
 * Section: 52715
 * 
 * This is a non-assignment used to experiment with graphics methods and objects.
 * 
 * Slip days used for this project: 0  Slip days used (total): 0
 * 
 */
 
public class circles {
    public static void main(String[] args) {
    
        DrawingPanel canvas = new DrawingPanel(500, 500);
        Graphics g = canvas.getGraphics();
        Color blueHighlight = new Color(51, 181, 229);
        Color blueLowlight = new Color(0, 153, 204);
        
        for(int circles = 0; circles < 10; circles++) {
            int xBorder = 0 + 25 * circles;
            int yBorder = 0 + 25 * circles;
            int xLength = 500 - 50 * circles;
            int yLength = xLength;
            
            if(circles % 2 == 0) { g.setColor(blueHighlight); }
            if(circles % 2 != 0) { g.setColor(blueLowlight); }
            
            g.fillOval(xBorder, yBorder, xLength, yLength);
        }
    }
    

}
