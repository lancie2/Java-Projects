public class TestingStuffs {

	public static void main(String[] args) {
	
		char val = 'a';
		
		System.out.println(val);
		
		val++;
		
		System.out.println(val);
		
		int[] array = { 1, 2, 3, 4, 5 };
		
		arrString(array);
		
		array[3]++;
		
		arrString(array);
		
		String tester = "This Is A String";
	
		while(tester.length() > 0) {
	
			System.out.println(tester.length() + ": " + tester);
			tester = tester.substring(1);
			
		}
		
		LetterInventory testOne = new LetterInventory("\"Stanford University\"!! Jr<>(())G");
		
		System.out.println(testOne.toString());
		
	
	}
	
	public static void arrString( int[] arr ) {
	
		System.out.print("[" + arr[0]);
	
		for( int index = 1; index < arr.length; index++) {
			
			System.out.print(", " + arr[index]);
			
		}
		
		System.out.println("]");
		
	}
	
}
