package Recursion_Memoization;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		fib(10);
	}

	public static int fib(int n) {

		if (n < 0) {
			throw new IllegalArgumentException("Index was negative. No such thing as a negative index in a series.");
		}

		// base cases
		if (n == 0 || n == 1) {
			return n;
		}

		System.out.printf("computing fib(%d)\n", n);
		return fib(n - 1) + fib(n - 2);
	}
	
	private static Map<Integer,Integer> memo = new HashMap<>();
	
	public static int fib1(int n) {
		if (n < 0) {
            throw new IllegalArgumentException(
                "Index was negative. No such thing as a negative index in a series.");

        // base cases
        } else if (n == 0 || n == 1) {
            return n;
        }
        
		// See if we have already calculated this
		if(memo.containsKey(n)) {
			System.out.printf("grabbing memo[%d]\n", n);
			return memo.get(n);
		}
		System.out.printf("computinh fib(%d)\n",n);
		int result = fib(n-1)+fib(n-2);
		
		//memoization
		memo.put(n,result);
		return result;
	}

}
