public class charTests {

    public static void main(String[] args) {
        char ch = 'A';
        int ascii = ch;
        for(int index = 0; index < 26; index++) {
            System.out.print(ascii);
            ascii++;
        }
    }
}