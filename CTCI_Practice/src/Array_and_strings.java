import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Array_and_strings {
	Array_and_strings() {
		
	}
	
	public void run() {
		System.out.println(uniqueChar("test"));
		System.out.println(uniqueChar("abcdefgh"));
		System.out.println(isAnagram("hello", "lleoh"));
		System.out.println(isAnagram("hello", "test"));
		System.out.println(reverse("hello world"));
		System.out.println(reverse2("hello world"));
		System.out.println(sumFile("numbers.txt"));
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
	
	private boolean isAnagram(String str1, String str2) {
		char[] c_str1 = str1.toCharArray();
		char[] c_str2 = str2.toCharArray();
		Arrays.sort(c_str1);
		Arrays.sort(c_str2);
		String str1_sorted = new String(c_str1);
		String str2_sorted = new String(c_str2);
		return str1_sorted.equals(str2_sorted);
	}
	
	private String reverse(String str) {
		StringBuilder sb = new StringBuilder();
		char[] strAsChar = str.toCharArray();
		int len = str.length() - 1;
		for(int i = 0; i <= len; i++) {
			int pos = len - i;
			sb.append(strAsChar[pos]);
		}
		String reversedString = sb.toString();
		return reversedString;
	}
	
	private String reverse2(String str) {
		int len = str.length();
		int end = len -1;
		char[] strArray = str.toCharArray();
		for(int i = 0; i < len/2; i ++) {
			char temp = strArray[i];
			strArray[i] = strArray[end-i];
			strArray[end-i] = temp;
		}
		return new String(strArray);
	}
	
	private int sumFile(String file) {
		int sum = 0;
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);		
			for(String num = br.readLine(); num != null; num = br.readLine()) {
				sum += Integer.parseInt(num);
			}
			
			br.close();
			return sum;	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return sum;
	}
	
}
