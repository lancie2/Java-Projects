/*  Student information for assignment:
 * 
 *  UTEID:
 *  email address:
 *  Grader name:
 *  Number of slip days I am using:
 */

// Experiment results. CS314 students, place your experiment
// results here:

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class LinkedListTester {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<String>();
        Object[] actual;
        Object[] expected;

        //test 0
        System.out.println("\nTest 0: initial list is empty");
        if( list.toString().equals("[]") )
            System.out.println("Passed test 0");
        else
            System.out.println("Failed test 0");

        //test 0.1
        System.out.println("\nTest 0.1: add to end");
        list.add("A");
        if( list.get(0).equals("A") )
            System.out.println("Passed test 0.1");
        else
            System.out.println("Failed test 0.1");  

        //test 0.2
        System.out.println("\nTest 0.2: size");
        if( list.size() == 1 )
            System.out.println("Passed test 0.2");
        else
            System.out.println("Failed test 0.2"); 

        //test 0.3
        System.out.println("\nTest 0.3: remove from position 0");
        String removed = list.remove(0);
        if(removed.equals("A"))
            System.out.println("Passed test 0.31");
        else
            System.out.println("Failed test 0.31");            

        System.out.println("\nTest 0.31: toStrin after remove");
        //test 0.31
        if( list.toString().equals("[]") )
            System.out.println("Passed test 0.3");
        else
            System.out.println("Failed test 0.3");  

        //test 0.4
        System.out.println("\nTest 0.4: size");
        if( list.size() == 0 )
            System.out.println("Passed test 0.4");
        else
            System.out.println("Failed test 0.4"); 

        //test 0.5
        System.out.println("\nTest 0.5: add and toString");
        list.add("A");
        list.add("B");
        if( list.toString().equals("[A, B]") )
            System.out.println("Passed test 0.5");
        else
            System.out.println("Failed test 0.5");  

        //test 0.6
        System.out.println("\nTest 0.6: size");
        if( list.size() == 2 )
            System.out.println("Passed test 0.6");
        else
            System.out.println("Failed test 0.6");


        //test 1
        System.out.println("\nTest 1: Adding at end");
        list = new LinkedList<String>();
        list.add("A");
        actual = toArray(list);
        expected = new Object[]{"A"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );		
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 1");
        else
            System.out.println("Failed test 1");


        //test 2
        System.out.println("\nTest 2: making empty");
        list.makeEmpty();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 2");
        else
            System.out.println("Failed test 2");


        //test 3
        System.out.println("\nTest 3: Adding at pos 0 in empty list");
        list.insert(0, "A");
        actual = toArray(list);
        expected = new Object[] {"A"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  		
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 3");
        else
            System.out.println("Failed test 3");



        //test 4
        System.out.println("\nTest 4: Adding at front");
        list = new LinkedList<String>();
        list.addFirst("A");
        actual = toArray(list);
        expected = new Object[] {"A"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 4");
        else
            System.out.println("Failed test 4");



        //test 5
        System.out.println("\nTest 5: Removing from front");
        list.removeFirst();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 5");
        else
            System.out.println("Failed test 5");


        //test 6
        list = new LinkedList<String>();
        System.out.println("\nTest 6: Adding at end");
        list.addLast("A");
        actual = toArray(list);
        expected = new Object[] {"A"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 6");
        else
            System.out.println("Failed test 6");


        //test 7
        System.out.println("\nTest 7: Removing from back");
        list.removeLast();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 7");
        else
            System.out.println("Failed test 7");

        //test 8
        System.out.println("\nTest 8: Adding at middle");
        list = new LinkedList<String>();
        list.add("A");
        list.add("C");
        list.insert(1, "B");
        actual = toArray(list);
        expected = new Object[] {"A", "B", "C"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 8");
        else
            System.out.println("Failed test 8");


        //test 9
        System.out.println("\nTest 9: Setting");
        list = new LinkedList<String>();
        list.add("A");
        list.add("D");
        list.add("C");
        String oldValue = list.set(1, "B");
        actual = toArray(list);
        expected = new Object[] {"A", "B", "C"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 9.1");
        else
            System.out.println("Failed test 9.1");
        if( oldValue.equals("D") )
            System.out.println("Passed test 9.2");
        else
            System.out.println("Failed test 9.2");


        //test 10
        System.out.println("\nTest 10: Removing");
        list = new LinkedList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.remove(0);
        list.remove( list.size() - 1 );
        actual = toArray(list);
        expected = new Object[] {"B", "C"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 10");
        else
            System.out.println("Failed test 10");
        
        //CS314 students. Add your tests here:

        // CS314 Students:
        // uncomment the following line to run tests comparing
        // your LinkedList class to the java ArrayList class.
        // comparison();
    }

    private static Object[] toArray(LinkedList<String> list) {
        Object[] result = new Object[list.size()];
        Iterator<String> it = list.iterator();
        int index = 0;
        while( it.hasNext() ){
            result[index] = it.next();
            index++;
        }
        return result;
    }

    //pre: none
    private static boolean arraysSame(Object[] one, Object[] two)  {
        boolean same;
        if( one == null || two == null ) {
            same = (one == two);
        }
        else {
            //neither one or two are null
            assert one != null && two != null;
            same = one.length == two.length;
            if( same ) {
                int index = 0;
                while( index < one.length && same ) {
                    same = ( one[index].equals(two[index]) );
                    index++;
                }
            }
        }
        return same;
    }

    // A method to be run to compare the LinkedList you are completing and the Java ArrayList class
    public static void comparison(){
        Stopwatch s = new Stopwatch();
        int initialN = 50000;
        int numTests = 5;


        addEndArrayList(s, initialN, numTests);
        addEndLinkedList(s, initialN, numTests);

        initialN = 10000;
        addFrontArrayList(s, initialN, numTests);
        addFrontLinkedList(s, initialN, numTests);

        removeFrontArrayList(s, initialN, numTests);
        removeFrontLinkedList(s, initialN, numTests);

        getRandomArrayList(s, initialN, numTests);
        getRandomLinkedList(s, initialN, numTests);

        getAllArrayListUsingIterator(s, initialN, numTests);
        getAllLinkedListUsingIterator(s, initialN, numTests);

        getAllArrayListUsingGetMethod(s, initialN, numTests);
        getAllLinkedListUsingGetMethod(s, initialN, numTests);

    }

    // These pairs of method illustarte a failure to use polymorphism
    // If the students had implemented the Java list interface there
    // could be a single method. Also we could use function objects to
    // reduce the awful repitition of code.
    public static void addEndArrayList(Stopwatch s, int initialN, int numTests){
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        System.out.println("Adding at end: ArrayList");
        int n = initialN;
        for(int i = 0; i < numTests; i++){
            System.out.print("Adding " + n + " elements to end of an ArrayList. ");
            s.start();
            for(int j = 0; j < n; j++)
                javaList.add(j);
            s.stop();
            System.out.println("Time to add: " + s);
            n *= 2;
        }
    }

    public static void addEndLinkedList(Stopwatch s, int initialN, int numTests){
        System.out.println("Adding at end: LinkedList");
        int n = initialN;
        LinkedList<Integer> studentList = new LinkedList<Integer>();
        for(int i = 0; i < numTests; i++){
            System.out.print("Adding " + n + " elements to end of a LinkedList. ");
            s.start();
            for(int j = 0; j < n; j++)
                studentList.add(j);
            s.stop();
            System.out.println("Time to add: " + s);
            n *= 2;
        }
    }

    public static void addFrontArrayList(Stopwatch s, int initialN, int numTests){
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        System.out.println("Adding at front: ArrayList");
        int n = initialN;
        for(int i = 0; i < numTests; i++){
            System.out.print("Adding " + n + " elements to front of an ArrayList. ");
            s.start();
            for(int j = 0; j < n; j++)
                javaList.add(0, j);
            s.stop();
            System.out.println("Time to add: " + s);
            n *= 2;
        }
    }

    public static void addFrontLinkedList(Stopwatch s, int initialN, int numTests){
        System.out.println("Adding at front: LinkedList");
        int n = initialN;
        LinkedList<Integer> studentList = new LinkedList<Integer>();
        for(int i = 0; i < numTests; i++){
            System.out.print("Adding " + n + " elements to front of a LinkedList. ");
            s.start();
            for(int j = 0; j < n; j++)
                studentList.insert(0, j);
            s.stop();
            System.out.println("Time to add: " + s);
            n *= 2;
        }
    }

    public static void removeFrontArrayList(Stopwatch s, int initialN, int numTests){
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        System.out.println("Removing from front: ArrayList");
        int n = initialN;
        for(int i = 0; i < numTests; i++){
            System.out.print("Removing " + n + " elements from front of an ArrayList. ");

            for(int j = 0; j < n; j++)
                javaList.add(j);
            s.start();
            while( !javaList.isEmpty())
                javaList.remove(0);
            s.stop();
            System.out.println("Time to add: " + s);
            n *= 2;
        }
    }

    public static void removeFrontLinkedList(Stopwatch s, int initialN, int numTests){
        System.out.println("removing from front: LinkedList");
        int n = initialN;
        LinkedList<Integer> studentList = new LinkedList<Integer>();
        for(int i = 0; i < numTests; i++){
            System.out.print("Removing " + n + " elements from front of a LinkedList. ");
            for(int j = 0; j < n; j++)
                studentList.add(j);
            s.start();
            while( studentList.size() != 0 )
                studentList.removeFirst();
            s.stop();
            System.out.println("Time to remove: " + s);
            n *= 2;
        }
    }

    public static void getRandomArrayList(Stopwatch s, int initialN, int numTests){
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        System.out.println("Getting random: ArrayList");
        int n = initialN;
        int total = 0;
        Random r = new Random();
        for(int i = 0; i < numTests; i++){
            System.out.print("Getting " + n + " elements from random locations in an ArrayList. ");

            for(int j = 0; j < n; j++)
                javaList.add(j);
            s.start();
            for(int j = 0; j < n; j++){
                total++;
                javaList.get( r.nextInt(n) );
            }
            s.stop();
            System.out.println("Time to get: " + s);
            n *= 2;
        }
    }

    public static void getRandomLinkedList(Stopwatch s, int initialN, int numTests){
        System.out.println("Getting random: LinkedList");
        int n = initialN;
        int total = 0;
        Random r = new Random();
        LinkedList<Integer> studentList = new LinkedList<Integer>();
        for(int i = 0; i < numTests; i++){
            System.out.print("Getting " + n + " elements from random locations in a LinkedList. ");
            for(int j = 0; j < n; j++)
                studentList.add(j);
            s.start();
            for(int j = 0; j < n; j++){
                total++;
                studentList.get( r.nextInt(n) );
            }
            s.stop();
            System.out.println("Time to get: " + s);
            n *= 2;
        }
    }

    public static void getAllArrayListUsingIterator(Stopwatch s, int initialN, int numTests){
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        System.out.println("Getting all using iterator: ArrayList");
        int n = initialN;
        int total = 0;
        for(int i = 0; i < numTests; i++){
            System.out.print("Getting all " + n + " elements from an ArrayList using the iterator. ");

            for(int j = 0; j < n; j++)
                javaList.add(j);

            Iterator<Integer> it = javaList.iterator();
            s.start();
            while( it.hasNext() ){
                total++;
                it.next();
            }        
            s.stop();
            System.out.println("Time to get: " + s);
            n *= 2;
        }
    }

    public static void getAllLinkedListUsingIterator(Stopwatch s, int initialN, int numTests){
        System.out.println("Getting all using iterator: LinkedList");
        int n = initialN;
        int total = 0;
        LinkedList<Integer> studentList = new LinkedList<Integer>();
        for(int i = 0; i < numTests; i++){
            System.out.print("Getting all " + n + " elements from LinkedList using the iterator. ");
            for(int j = 0; j < n; j++)
                studentList.add(j);
            Iterator<Integer> it = studentList.iterator();

            s.start();
            while(it.hasNext()){
                total++;
                it.next();
            }
            s.stop();
            System.out.println("Time to get: " + s);
            n *= 2;
        }
    }

    public static void getAllArrayListUsingGetMethod(Stopwatch s, int initialN, int numTests){
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        System.out.println("Getting all using get method: ArrayList");
        int n = initialN;
        for(int i = 0; i < numTests; i++){
            System.out.print("Getting all " + n + " elements from an ArrayList using the get method. ");

            for(int j = 0; j < n; j++)
                javaList.add(j);

            s.start();
            int x = 0;
            for(int j = 0; j < javaList.size(); j++){
                x += javaList.get(j);
            }
            s.stop();
            System.out.println("Time to get: " + s);
            n *= 2;
        }
    }

    public static void getAllLinkedListUsingGetMethod(Stopwatch s, int initialN, int numTests){
        System.out.println("Getting all using get method: LinkedList");
        int n = initialN;
        LinkedList<Integer> studentList = new LinkedList<Integer>();
        for(int i = 0; i < numTests; i++){
            System.out.print("Getting all " + n + " elements from LinkedList using get method. ");
            for(int j = 0; j < n; j++)
                studentList.add(j);

            s.start();
            int x = 0;
            for(int j = 0; j < studentList.size(); j++){
                x += studentList.get(j);
            }
            s.stop();
            System.out.println("Time to get: " + s);
            n *= 2;
        }
    }



}