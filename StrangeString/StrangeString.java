import java.util.*;

public class StrangeString {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String input = read.nextLine();
        modifyString(input);
    }

    public static void modifyString(String s) {
        for(int index = 0; index < s.length(); index += 2) {
            System.out.print(s.charAt(index));
        }
        System.out.println();
    }
} 
