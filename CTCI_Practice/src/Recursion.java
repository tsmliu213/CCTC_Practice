
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
	
	// Calulate the number of ways to represent cents
	private int numOfChange(int amount, int coin){
		int nextCoin = 0;
		switch(coin){
			case 25:
				nextCoin = 10;
				break;
			case 10:
				nextCoin = 5;
				break;
			case 5:
				nextCoin = 1;
				break;
			case 1:
				return 1;
		}
		int ways = 0;
		for(int i = 0; i * coin < amount; i++) {
			ways += numOfChange(amount - i * coin, nextCoin);
		}
		return ways;
	}
}
