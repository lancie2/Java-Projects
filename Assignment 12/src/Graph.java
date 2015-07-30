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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

/**
 * Models a graph. Edges can be weighted.
 * @author scottm, based on the Graph class from Weiss Algorithms and Data Structures
 *
 */
public class Graph {

    // used to indicate a vertex has not been visited and
    // that no path exists between current start vertex.
    private static final double INFINITY = Double.MAX_VALUE;

    private Map<String, Vertex> vertices;

    // path equal in length to diameter of graph
    private Path longest; 

    // flag to ensure all paths have been found
    private boolean allPathsFound;
    
    private String currentStartVertexName;

    /**
     * Create an empty graph.
     */
    public Graph() {
        vertices = new HashMap<String, Vertex>();
    }

    /**
     * Add an edge to this graph.
     * <br>pre: source != null, dest != null
     * @param source
     * @param dest
     * @param cost
     */
    public void addEdge(String source, String dest, double cost) {
        if(source == null || dest == null)
            throw new IllegalArgumentException("Violation of precondition. " +
            "Vertex names may not be null.");
        Vertex s = getVertex(source);
        Vertex d = getVertex(dest);
        s.adjacent.add(new Edge(d, cost));
    }
    
    
    public boolean edgeExists(String source, String dest) {
        return vertices.get(source).connectedTo(dest);
    }
    
    /**
     * Add a vertex with the given name to this Graph. 
     * The new vertex has no edges initially.
     * <br>pre: name != null
     * @param name The name of the new vertex.
     */
    public void addVertex(String name) {
        if(name == null)
            throw new IllegalArgumentException("Violation of precondition. " +
                    "Vertex name may not be null.");
        getVertex(name);
    }

    /**
     * Find all unweighted shortest paths from the Vertex startName
     * to other veritces in this Graph. After this method is called, 
     * call the printPath(String) method to get the path from startNode
     * to any other vertex in this Graph.
     * <br>pre: startName != null, containsVertex(startName) == true
     * @param startName The starting vertex. This method will find all the
     * unweighted shortest paths from the give vertex to all other vertices
     * in the graph.
     */
    public void findUnweightedShortestPath(String startName) {
        if(startName == null)
            throw new IllegalArgumentException("Violation of precondition. " +
            "Vertex name may not be null.");
        if(!containsVertex(startName))
            throw new NoSuchElementException("No Verex named " + startName + " exists in this Graph");

        currentStartVertexName = startName;
        clearAll();
        Vertex start = vertices.get(startName);
        start.weightedCostFromStartVertex = 0;
        start.numEdgesFromStartNode = 0;
        Queue<Vertex> q = new LinkedList<Vertex>();
        q.add(start);
        
        while(!q.isEmpty()) {
            Vertex current = q.remove();
            for(Edge e : current.adjacent) {
                Vertex neighberNode = e.dest;
                // Is this the first time I have seen this vertex?
                if(neighberNode.weightedCostFromStartVertex == INFINITY) {
                    // In an unweighted graph we treat
                    // the weighted cost and number of edges from start
                    // as the same.
                    neighberNode.weightedCostFromStartVertex = current.weightedCostFromStartVertex + 1;
                    neighberNode.numEdgesFromStartNode = current.numEdgesFromStartNode + 1;
                    neighberNode.prev = current;
                    q.add(neighberNode);
                }
            }
        }
    }


    /**
     * Find all weighted shortest paths from the Vertex startName
     * to other veritces in this Graph using dijkstra's algorithm. 
     * After this method is called, call
     * the printPath(String) method to get the path from startNode
     * to any other vertex in this Graph.
     * <br>pre: startName != null, containsVertex(startName) == true
     * @param startName The starting vertex. This method will find all the
     * weighted shortest paths from the given vertex to all other vertices
     * in the graph.
     */    
    public void dijkstra(String startName) {
        if(startName == null)
            throw new IllegalArgumentException("Violation of precondition. " +
            "Vertex name may not be null.");
        if(!containsVertex(startName))
            throw new NoSuchElementException("No Vertex named " + startName + " exists in this Graph");

        currentStartVertexName = startName;
        // CS314 STUDENTS - Complete this method
        
        clearAll();
        Vertex initial = vertices.get(startName);
        initial.weightedCostFromStartVertex = 0;
        
        PriorityQueue<Path> theQueue = new PriorityQueue<Path>();
        Path thePath = new Path(initial, 0);
        
        theQueue.add(thePath);
        
        int visitedNodes = 0;
        
        while(!theQueue.isEmpty() && visitedNodes < vertices.size()) {
        	
        	Path currentPath = theQueue.remove();
        	Vertex currentVertex = currentPath.dest;
        	
        	if(currentVertex.scratch == 0) {
        		
        		currentVertex.scratch = 1;
        		visitedNodes++;
        		
        		for(Edge currentEdge : currentVertex.adjacent) {
        			
        			Vertex tempVertex = currentEdge.dest;
        			double cost = currentEdge.cost;
        			
        			if(tempVertex.weightedCostFromStartVertex > currentVertex.weightedCostFromStartVertex + cost) {
        				
        				tempVertex.weightedCostFromStartVertex = currentVertex.weightedCostFromStartVertex + cost;
        				tempVertex.prev = currentVertex;
        				Path newPath = new Path(tempVertex, tempVertex.weightedCostFromStartVertex);
        				theQueue.add(newPath);
        				
        			}
        			
        		}
        	}
        }
        
        
    }



    /**
     * Find all shortest paths for all vertices in this graph.
     * 
     * <br><br>Each vertex shall store the number of vertices it is connect to,
     * the total unweighted path length of all its shortest paths and the
     * total weighted path length of all its shortest paths. 
     * 
     * <br><br>if weighted == true, use dykstra, otherwise, use unwieghted
     * shortest paths (equal to number of edges from startNode to a 
     * given node)
     * 
     * <br><br>
     * After this method is called the getAllPaths, getDiamter, and
     * get longest path methods may be called.
     * 
     * @param weighted If weighted == true use dijkstra's algorithm
     * otherwise use the unweighted shortest path algorithm.
     */
    public void findAllPaths(boolean weighted) {
        allPathsFound = true;
        longest = new Path();
        
        // CS314 STUDENTS - Complete this method
        
        Path previousPath = new Path();
        Path nextPath = new Path();
        
        if(weighted) {
        	
        	for( String initialName : vertices.keySet() ) {
        		
        		double total = 0;
        		
        		vertices.get( initialName ).clearPathInfo();
        		dijkstra( initialName );
        		
        		for( String finalName : vertices.keySet() ) {
        			
        			previousPath = getPath(finalName);
        			
        			if(vertices.get(finalName).weightedCostFromStartVertex != INFINITY && vertices.get(finalName).weightedCostFromStartVertex != 0) {
        				
        				vertices.get(initialName).numVertexConnected++;
        				total += vertices.get(finalName).weightedCostFromStartVertex;
        			}
        			vertices.get(initialName).totalWeightedPathLength = total;
        		}
        	}
        }
        
        else { //unweighted
        	
        	for( String initialName : vertices.keySet() ) {
        		
        		double total = 0;
        		
        		vertices.get( initialName ).clearPathInfo();
        		findUnweightedShortestPath( initialName );
        		
        		for( String finalName : vertices.keySet() ) {
        			
        			previousPath = getPath(finalName);
        			
        			if( previousPath.length() > nextPath.length() ) {
        				
        				nextPath = previousPath;
        			}
        			
        			if( vertices.get( finalName ).weightedCostFromStartVertex != INFINITY && vertices.get( finalName ).weightedCostFromStartVertex != 0) {
        				
        				vertices.get( initialName ).numVertexConnected++;
        				total += vertices.get( finalName ).weightedCostFromStartVertex;
        			}
        			
        			vertices.get( initialName ).totalWeightedPathLength = total;
        			vertices.get( initialName ).totalUnweightedPathLengh = total;
        		}
        		longest = nextPath;
        		longest.weightedCostOfPath = nextPath.length() - 1;
        	}
        }
        allPathsFound = true;
    }
    
    
    // helper to get path from current start node to dest
    private Path getPath(String dest) {
        Path result = new Path();
        Vertex end = vertices.get(dest);
        result.weightedCostOfPath = end.weightedCostFromStartVertex;
        if(end.weightedCostFromStartVertex != INFINITY)
            getPath(result, end);          
        return result;
    }
    
    // helper to get path
    private void getPath(Path result, Vertex end) {
        if(end.prev != null)
            getPath(result, end.prev);
        result.add(end);        
    }
    
    /**
     * Get the number of edges of the shortest path
     * from the current start
     * vertex to the given destination vertex. If there is
     * no path from the current start vertex to the given 
     * destiantion vertex -1 is returned.
     * <br><br>
     * pre: findUnweightedShortestPath or dijkstra called.
     * <tt>containsVertex(dest) == true<tt>
     * @param dest
     * @return the number of edges from the current start vertex 
     * to the destination vertex. returns -1 if no path
     * exists.
     * 
     */
    public int getNumEdgesFromStart(String dest) { 
        if(currentStartVertexName == null)
            throw new IllegalStateException("method " +
            		"findUnweigthedShortesPath or dijkstra must be " +
                    "called before calling this method.");
        else         if(!containsVertex(dest))
            throw new NoSuchElementException("No Vertex named " 
                    + dest + " exists in this Graph");
        
        int result = vertices.get(dest).numEdgesFromStartNode;
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }
    
    /**
     * Get the total weighted cost of the shortest path
     * from the current start
     * vertex to the given destination vertex. If there is
     * no path from the current start vertex to the given 
     * destiantion vertex -1 is returned.
     * <br><br>
     * pre: findUnweightedShortestPath or dijkstra called.
     * <tt>containsVertex(dest) == true<tt>
     * @param dest
     * @return the total cost of the shortest path
     *  from the current start vertex 
     * to the destination vertex. returns -1 if no path
     * exists.
     * 
     */   
    public double getWeightedCostFromStart(String dest) {
        if(currentStartVertexName == null)
            throw new IllegalStateException("method " +
                    "findUnweigthedShortesPath or dijkstra must be " +
                    "called before calling this method.");
        else         if(!containsVertex(dest))
            throw new NoSuchElementException("No Vertex named " 
                    + dest + " exists in this Graph");
        
        return vertices.get(dest).weightedCostFromStartVertex;
    }
    
    
    /**
     * Get all path statistics for all vertices in this graph that are
     * connected to one or more other vertices. 
     * <br>pre: findAllPaths has been called.
     * @return
     */
    public TreeSet<AllPathsInfo> getAllPaths() {
        if(!allPathsFound)
            throw new IllegalStateException("The method findAllPaths must be called before calling this method. ");
        
        TreeSet<AllPathsInfo> result = new TreeSet<AllPathsInfo>();
        for(Vertex v : vertices.values()) {
            if(v.numVertexConnected > 0) {
                AllPathsInfo temp = new AllPathsInfo(v.name, v.numVertexConnected, v.totalWeightedPathLength );
                boolean added = result.add(temp);
                assert added : "Did not add path info for " + v +". Why not?";

            }
        }
        return result;
    }
    
    
    /**
     * Check if a vertex with the given name is present in this graph.
     * <br>pre: name != null
     * @param name The name of the vertex to check.
     * @return true if a vertex with name is present in this Grapg, false otherwise.
     */
    public boolean containsVertex(String name) {
        return vertices.containsKey(name);
    }
    

    /**
     * Return the name of the current start vertex.
     * <br><br> 
     * pre: findUnweightedShortestPath or dijkstra called.
     * @return
     */
    public String getCurrentStartVertex() {
        if(currentStartVertexName == null)
            throw new IllegalStateException("method findUnweigthedShortesPath or dijkstra must be " +
                    "called before calling this method.");
        return this.currentStartVertexName;
    }

    
    /**
     * Alternative to printPath that returns an List containing the path from the
     * current start vertex to the vertex named destName. If no path exists
     * an empty List is returned.
     * <br>pre: destName != null, containsVertex(destName) == true, the startNode has
     * been set by calling findUnweigthedShortesPath or dijkstra.
     * @param destName The destination vertex
     * @return A list with the path from the current start vertex to the vertex with destName.
     * start vertex will be at index 0 and destName will be at index list.size() - 1 unless there
     * is no path from the start vertex to destName in which case an emtpy list is returned.
     */
    public List<String> findPath(String destName) {
        if(currentStartVertexName == null)
            throw new IllegalStateException("method findUnweigthedShortesPath or dijkstra must be " +
                    "called before calling this method.");
        if(destName == null)
            throw new IllegalArgumentException("Violation of precondition. " +
            "Vertex name may not be null.");
        if(!containsVertex(destName)) 
            throw new NoSuchElementException("No Vertex named " + destName + " exists in this Graph"); 
        

        
        List<String> result = new LinkedList<String>();
        Vertex end = vertices.get(destName);
   
        if(end.weightedCostFromStartVertex != INFINITY)
            findPath(result, end);          
        return result;
    }

    
    // helper method to find path.
    private void findPath(List<String> result, Vertex end) {
        if(end.prev != null)
            findPath(result, end.prev);
        result.add(end.name);
    }
    
    /**
     * Print the path from the current start vertex to the vertex with name destName
     * <br>pre: destName != null, containsVertex(destName) == true, the startNode has
     * been set by calling findUnweigthedShortesPath or dijkstra.
     * @param destName The destination vertex
     * @return A list with the path from the current start vertex to the vertex with destName.
     * start vertex will be at index 0 and destName will be at index list.size() - 1 unless there
     * is no path from the start vertex to destName in which case an emtpy list is returned.
     */
    public void printPath(String destName) {
        Vertex end = vertices.get(destName);
        if(end == null) 
            throw new NoSuchElementException("No Node named " + destName + " exists in this Graph");    
        else if(end.weightedCostFromStartVertex == INFINITY)
            System.out.println("no path to " + destName);
        else {
            System.out.println("Cost is " + end.weightedCostFromStartVertex);
            printPath(end);
            System.out.println();
        }
    }
    
    // helper to print path
    private void printPath(Vertex dest) {
        if(dest.prev != null) {
            printPath(dest.prev);
        }
        System.out.println(dest.name);
    }
    
    /**
     * Return the diameter of this graph.
     * <br>pre: findAllPaths has been called.
     * @return the diameter of this graph.
     */
    public int getDiameter() {
        if(!allPathsFound)
            throw new IllegalStateException("The method findAllPaths must be called before calling this method. ");
        return longest.length() - 1;
    }
    
    /**
     * Return a path equal to the diamter of this graph.
     * <br>pre: findAllPaths has been called.
     * @return the names of the vertices in a path equal to the diamter in this graph. If there
     * is more than one longest path one is arbitrarily chosen.
     */
    public String getLongestPath() {
        return longest.toString();
    }

    
    // helper. If name not present create new vertex.
    // return vertx with given name
    private Vertex getVertex(String name) {
        Vertex v = vertices.get(name);
        if(v == null) {
            v = new Vertex(name);
            vertices.put(name, v);
        }
        return v;
    }


    // reset all vertices to set new start vertex and find all paths
    // from new start
    private void clearAll() {
        for(Vertex v : vertices.values()) 
            v.reset();  
    }
    
    // not expected to use on A12
    public void showAll() {
        for(Vertex v : vertices.values())
            System.out.println(v);
    }
    
 // not expected to use on A12
    public List<String> getConnections(String name) {
        List<String> result = new ArrayList<String>();
        Vertex v = vertices.get(name);
        if(v != null) {
           for(Edge e : v.adjacent) 
               result.add(e.dest.name);
        }
        return result;
    }
    


    // model edge between two vertices
    private static class Edge {
        private Vertex dest;
        private double cost;

        public Edge(Vertex d, double c) {
            dest = d;
            cost = c;
        }

        public String toString() {
            return "(" + dest.name + " " + cost + ")";
        }
    }

    // model a vertex. uses adjacency list
    private static class Vertex {
        
        private String name;
        private List<Edge> adjacent;

        // number of other vertices this vertex is connected to
        private int numVertexConnected;
        
        // sum of all unweighted shortest paths from this vertex to other vertices
        private double totalUnweightedPathLengh;
        
        // sum of all weighted shortest paths from this vertex to other vertices
        private double totalWeightedPathLength;

        // for algorithms
        private double weightedCostFromStartVertex;
        private int numEdgesFromStartNode;
        private Vertex prev; 
        private int scratch;

        public Vertex(String n) {
            name = n;
            adjacent = new LinkedList<Edge>();
            reset();
        }

        public void reset() {
            weightedCostFromStartVertex = INFINITY;
            numEdgesFromStartNode = Integer.MAX_VALUE;
            prev = null;
            scratch = 0;
        }

        public void clearPathInfo() {
            numVertexConnected = 0;
            totalUnweightedPathLengh = 0;
            totalWeightedPathLength = 0;
        }

        public String toString() {
            return "{" + name + ", " + ", connected to: " + numVertexConnected + "adjacent: " + adjacent + "}";
        }
        

        public boolean equals(Object other) {
            boolean result = other instanceof Vertex;
            if(result){
                result = name.equals(((Vertex) other).name);
            }
            return result;
        }
        
        public boolean connectedTo(String dest) {
            for(Edge e : adjacent)
                if(e.dest.name.equals(dest))
                    return true;
            return false;
        }
        
    }

    // model a path. Best not to try and store all paths for any but small graphs.
    private static class Path implements Comparable<Path> {

        private List<Vertex> verticesInPath; // .size() == num edges in path
        private double weightedCostOfPath;
        private Vertex dest;

        public Path() {
            verticesInPath = new LinkedList<Vertex>();
        }

        public Path(Vertex v, double c) {
            dest = v;
            weightedCostOfPath = c;
        }

        public void add(Vertex v) {
            verticesInPath.add(v);
        }

        // return unweighted path length
        public int length() {
            return verticesInPath.size();
        }

        // return weighted cost of path
        public double weightedCost() {
            return weightedCostOfPath;
        }

        public String toString() {
            StringBuilder result = new StringBuilder();
            result.append("[");
            for(Vertex v : verticesInPath) {
                result.append(v.name);
                result.append(", ");
            }
            if(length() > 0) {
                result.delete(result.length() - 2, result.length());
            }
            result.append("]");
            if(length() > 0) {
                result.append(" cost: ");
                result.append(weightedCostOfPath);
            }
            return result.toString();
        }

        public int compareTo(Path other) {
            return weightedCostOfPath < other.weightedCostOfPath ? -1 : weightedCostOfPath > other.weightedCostOfPath ? 1 :0;
        }
    }
}