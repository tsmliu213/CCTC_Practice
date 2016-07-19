
public class Array_and_strings {
	Array_and_strings() {
		
	}
	
	public void run() {
		System.out.println(uniqueChar("test"));
		System.out.println(uniqueChar("abcdefgh"));
	}
	
	// Implement an algorithm to determine if a string has all unique characters 
	// What if you can not use additional data structures?
	private boolean uniqueChar(String str) {
		boolean[] charSet = new boolean[256];
		for(int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if(charSet[val]) {
				return false;
			}
			charSet[val] = true;
		}
		return true;
	}
	
}
