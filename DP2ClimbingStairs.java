package dp;
/*
 * Climbing Stairs
 * 
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
import java.util.Arrays;

public class DP2ClimbingStairs {
	/*
	 * Recusrsion approach
	 * T.C = o(2^n)
	 */
	public static int climb(int n) {
		 
		 if(n==0)
			 return 1;
		 if(n<0)
			 return 0;
		 return climb(n-1)+climb(n-2);
	 }
	
	 public static int climbStairs(int n) {
	        return climb(n);
	    }
	 
	
	/*
	 *  1. Assume n stairs as indexes from 0 to N.
		2. At a single time, we have 2 choices: Jump one step or jump two steps. We will try both of these options
		   at every index.
		3. We have to count total number of distinct ways, we will return the sum of all the choices in our 
		   recursive function.
		4. If you find the same recursive function in the subsequent calls, you can return dp[i] rather than 
		   performing the calculation again because we are using recursion and storing the result in the dp array.
		   
		   	Time complexity:
		   	O(n)

			Space complexity:
			O(n)+O(n) (for dp array+auxilary stack space) ~ O(n)
	 */
	 public static int climbStairs_mem(int n) {
	     int[] dp = new int[n+1];
	     Arrays.fill(dp,-1);
		 return climb(n,dp);
	    }
	 public static int climb(int i,int[] dp) {
		 
		 if(i==0)
			 return dp[i]=1;
		 if(i==1)
			 return dp[i] = 1;
		if(dp[i]!= -1)
			return dp[i];
		 return dp[i] = climb(i-1)+climb(i-2);
	 }
	 
	 /*
	  * Tabulation uses top - down approach.
	  * 1. Declare a dp[] array of size n+1.
	  * 2. First initialize the base condition values, i.e i=0 and i=1 of the dp array as 1.
	  * 3. Set an iterative loop that traverses the array( from index 2 to n) and for every index set its value 
	  *    as dp[i-1] + dp[i-2]. 
	  */
	 public static int climbStairs_tab(int n) {
		 int[] dp = new int[n+1];
		 dp[0]= 1;
		 dp[1]= 1;
		 
		 for(int i=2;i<=n;i++) {
			
			 dp[i]= dp[i-1]+dp[i-2];;
			 
		 }
		 return dp[n]; 
	 }
	 
	 
	 public static int climbStairs_spaceOpt(int n) {
		 if(n<=1)
			 return n;
		 int n1=1;
		 int n2=1;
		 int steps = 0;
		 for(int i=2;i<=n;i++) {
			steps = n1+n2;
			 n1=n2;
			 n2=steps;
		 }
		 return steps;
	 }
	 
	 public static void main(String args[]) {
		 int n=3;
		 System.out.println(climbStairs_mem(3));
	 }
	
}
