/*  Student information for assignment:
 *
 *  On my honor, <Lancie Menchu>, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: lam4356	
 *  email address: lancie.menchu@utexas.edu
 *  Grader name: Chris	
 *  Number of slip days I am using: 0
 */

/*
 * Question. The assignment presents three ways to rank teams using graphs.
 * The results, especially for the last two methdos are reasonable. 
 * However if all results from all college football teams are included 
 * some unexpected results occur. 
 * 
 * Suggest another way of method of ranking teams using the results 
 * from the graph. Thouroughly explain your method. The method can build 
 * on one of the three existing algroithms.
 * 
 * We already have sets of teams with conferences.  You could take the average
 * ranking of each team and use that as the rank for the conference.  Then, the highest
 * ranked team of the highest ranked conference becomes the top ranked team.  Then, the highest ranked
 * team of the second highest ranked conference becomes the second highest ranked team and so on until
 * all conferences are accounted for.
 * 
 */

public class GraphAndRankTester {
    
    public static void main(String[] args)  {
        String actual = "2008ap_poll.txt";
        String gameResults = "div12008.txt";
        
        FootballRanker ranker = new FootballRanker(gameResults, actual);
        
        ranker.doUnweighted(true);
        ranker.doWeighted(true);
        ranker.doWeightedAndWinPercentAdjusted(true);
        
        System.out.println();
        doRankTests(ranker);
        
        System.out.println();
        testGraph();
        System.out.println();
        testGraph2();
        System.out.println();
        testGraph3();
    }
    
    public static void doRankTests(FootballRanker ranker) {
        double actualError = ranker.doUnweighted(false);
        if(actualError == 13.7)
            System.out.println("Passed unweighted test");
        else
            System.out.println("FAILED UNWEIGHTED ROOT MEAN SQUARE ERROR TEST. Expected 13.7, actual: " + actualError);
        
        actualError = ranker.doWeighted(false);
        if(actualError == 12.6)
            System.out.println("Passed weigthed test");
        else
            System.out.println("FAILED WEIGHTED ROOT MEAN SQUARE ERROR TEST. Expected 12.6, actual: " + actualError);
        
        
        actualError = ranker.doWeightedAndWinPercentAdjusted(false);
        if(actualError == 6.3)
            System.out.println("Passed unweighted win percent test");
        else
            System.out.println("FAILED WEIGHTED  AND WIN PERCENT ROOT MEAN SQUARE ERROR TEST. Expected 6.3, actual: " + actualError);       
    }
    
    public static void testGraph() {
        String [][] edges = 
               {{"A", "B", "1"},
                {"B", "C", "3"},
                {"B", "D", "12"},
                {"C", "F", "3"},
                {"A", "G", "7"},
                {"D", "F", "4"},
                {"D", "G", "5"},
                {"D", "E", "6"}};
        
        Graph g = new Graph();
        for(String[] edge : edges) {
            g.addEdge(edge[0], edge[1], Integer.parseInt(edge[2]));
            g.addEdge(edge[1], edge[0], Integer.parseInt(edge[2]));
        }
        
        g.findAllPaths(false);
        int actual = g.getDiameter();
        if(actual == 3)
            System.out.println("Passed diameter test.");
        else
            System.out.println("Failed diameter test. Expected 3 got " + actual);
        
        g.dijkstra("A");
        String actualPath = g.findPath("E").toString();
        String expected = "[A, B, C, F, D, E]";
        if(actualPath.equals(expected))
            System.out.println("Passed dijkstra path test.");
        else
            System.out.println("Failed dijkstra path test. Expected: " + expected + " actual " + actualPath);        
        
        
    }
    
    public static void testGraph2() {
        String [][] edges = 
               {{"A", "B", "1"},
                {"A", "C", "3"},
                {"A", "D", "12"},
                {"D", "F", "3"},
                {"F", "G", "7"},
                {"G", "A", "6"}};
        
        Graph g = new Graph();
        for(String[] edge : edges) {
            g.addEdge(edge[0], edge[1], Integer.parseInt(edge[2]));
        }
        
        g.dijkstra("A");
        String actualPath = g.findPath("G").toString();
        String expected = "[A, D, F, G]";
        if(actualPath.equals(expected))
            System.out.println("Passed dijkstra path test.");
        else
            System.out.println("Failed dijkstra path test. Expected: " + expected + " actual " + actualPath); 
        
        g.findAllPaths(false);
        int actual = g.getDiameter();
        if(actual == 4)
            System.out.println("Passed diameter test.");
        else
            System.out.println("Failed diameter test. Expected 4 got " + actual);
          
    }
    
    public static void testGraph3() {
        String [][] edges = 
               {{"A", "B", "1"},
                {"B", "C", "3"},
                {"C", "D", "12"},
                {"D", "E", "3"},
                {"E", "F", "7"},
                {"F", "G", "4"},
                {"G", "A", "5"},};
        
        Graph g = new Graph();
        for(String[] edge : edges) {
            g.addEdge(edge[0], edge[1], Integer.parseInt(edge[2]));  
        }
       
        g.dijkstra("A");
        String actualPath = g.findPath("G").toString();
        String expected = "[A, B, C, D, E, F, G]";
        if(actualPath.equals(expected))
            System.out.println("Passed dijkstra path test.");
        else
            System.out.println("Failed dijkstra path test. Expected: " + expected + " actual " + actualPath); 
        
        g.findAllPaths(false);
        int actual = g.getDiameter();
        if(actual == 6)
            System.out.println("Passed diameter test.");
        else
            System.out.println("Failed diameter test. Expected 6 got " + actual);
          
    }
}