import java.util.*;

/*  Student information for assignment:
*
*  On my honor, Lancie Menchu, this programming assignment is my own work
*  and I have not provided this code to any other student.
*
*  UTEID: lam4356	
*  email address: lancie.menchu@utexas.edu
*  Grader name: Chris
*  Number of slip days I am using: 2
*/


public class Names {
	
	//instance variables
	private ArrayList<NameRecord> names;
	private int baseDecade;
	private int ranksPerName;
	private int size;
	
	//constructor - reads a file and builds an ArrayList containing all names
	public Names(Scanner read) {
	    this.baseDecade = read.nextInt();
		this.ranksPerName = read.nextInt();
		this.size = 0;
		this.names = new ArrayList();
		int[] ranks = new int[ranksPerName];
		while(read.hasNextLine()){
		    String line = read.nextLine();
		    String[] parsedData = line.split("\\s+");
		    //System.out.println("Name: " + parsedData[0]);
		    // only accept lines with 11 decades
		    if(parsedData.length == this.ranksPerName + 1) {
		    	//System.out.println("\tcontains 11 ranks");
		    	for(int index = 1; index <= this.ranksPerName; index++) {
		    		//System.out.print("\trank " + index + ": " + parsedData[index]);
		    		ranks[index - 1] = Integer.parseInt(parsedData[index]);
		    		//System.out.println("\trank: " + ranks[index-1]);
		    	}
		    	this.size++;
		    	
		    	this.names.ensureCapacity(this.size);
		    	System.out.println("Name: " + parsedData[0] + ", ranks: " + Arrays.toString(ranks));
		    	this.names.add(new NameRecord(parsedData[0], ranks));
		    }		
		}
	}
	
	//looks for names that contain a specific substring		
	public ArrayList<NameRecord> containsSubstring (String substr) {
		ArrayList<NameRecord> namesWithSubstring = new ArrayList();
		int substringStart = substr.length() - 1;
		for(int index = 0; index < this.names.size(); index++) {
			String currentName = this.names.get(index).name();
			for(int currentIndex = substringStart; currentIndex < currentName.length(); currentIndex++) {
				if(substr.equalsIgnoreCase(currentName.substring(currentIndex - substringStart, currentIndex))) {
					namesWithSubstring.add(this.names.get(index));
				}
			}
		}
		return namesWithSubstring;
	}
	
	//returns the given namerecord given a name
	public NameRecord find(String userName) {
		for(int index = 0; index < this.names.size(); index++) {
			if(userName.equalsIgnoreCase(this.names.get(index).name())) {
				return this.names.get(index);
			}
		}
		return null;
	}
	
	//returns a list of names that have been ranked every decade
	public ArrayList<String> rankedEveryDecade() {
		ArrayList<String> rankedNames = new ArrayList();
		for(int index = 0; index < this.names.size(); index++) {
			if(this.names.get(index).allRanked()) {
				rankedNames.add(this.names.get(index).name());
			}
		}
		return rankedNames;
	}
	
	//returns a list of names that have only been ranked once
	public ArrayList<String> rankedOnlyOneDecade() {
		ArrayList<String> rankedOnce = new ArrayList();
		for(int index = 0; index < this.names.size(); index++) {
			if(this.names.get(index).oneRanked()) {
				rankedOnce.add(this.names.get(index).name());
			}
		}
		return rankedOnce;
	}
	
	//returns a list of names that have continuously grown more popular
	public ArrayList<String> alwaysMorePopular() {
		ArrayList<String> trendingUp = new ArrayList();
		for(int index = 0; index < this.names.size(); index++) {
			if(this.names.get(index).upwardTrend()) {
				trendingUp.add(this.names.get(index).name());
			}
		}
		return trendingUp;
	}
	
	//returns a list of names that have continuously grown less popular
	public ArrayList<String> alwaysLessPopular() {
		ArrayList<String> trendingDown = new ArrayList();
		for(int index = 0; index < this.names.size(); index++) {
			if(this.names.get(index).downwardTrend()) {
				trendingDown.add(this.names.get(index).name());
			}
		}
		return trendingDown;
	}
	
	public int size() {
		return this.size;
	}
	
}
