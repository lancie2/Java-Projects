import java.util.*;

public class randomTestStuff {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        double minValue = 0;
        double maxValue = 0;
        double sum = 0;
        
        for(int index = 0; index < 100; index++) {
            System.out.print("Enter a floating point value: ");
            double userInput = read.nextDouble();
            maxValue = Math.max(userInput, maxValue);
            minValue = Math.min(userInput, minValue);
            sum += userInput;
        }
            
        System.out.println("Max Value: " + maxValue + "\nMin Value: " + minValue + "\nAverage: " + sum/100.0);
    }
}