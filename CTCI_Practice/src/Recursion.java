
public class Recursion {
	Recursion() { }
	
	public void run() {
		System.out.println("fib of 8 is " + fib(8));
	}
	
	public int fib(int n) {
		if(n < 2) {
			return n;
		}
		else {
			return fib(n-2) + fib(n-1);
		}
	}
	
	// Print all valid combinations of n-pairs of parenthesis
	private void nParens(int n) {
		if(n == 0) {
			return;
		}
		for(int i = 0; i < n/2; i++) {
			
		}
	}
}
