package dp;
/*
 * Given an array Arr of size N containing positive integers. Find the maximum sum of a subsequence such that
 * no two numbers in the sequence should be adjacent in the array.
 * 
 * Solved in 3 different approaches
 */
import java.util.Arrays;

public class DP5SumOfNonAdjElements {
	
	//1. Recursion
	static int  findMaxSum(int arr[], int n) {
        // code here
		return maxSum(n-1,arr);
    }
	
	static int maxSum(int ind,int[] arr) {
		if(ind == 0 || ind ==1)
			return arr[ind];
		
		int pick = arr[ind]+maxSum(ind-2,arr);
		int notpick = maxSum(ind-1,arr);
		return Math.max(pick, notpick);
		
	}
	
	
	//memoization
	static int  findMaxSum_mem(int arr[], int n) {
        // code here
		int dp[] = new int[n];
		for(int i=0;i<n;i++)
			dp[i] = -1;
		return maxSum(n-1,arr,dp);
    }
	
	static int maxSum(int ind,int[] arr,int[] dp) {
		if(ind < 0)
			return 0;
		if(dp[ind] != -1)
			return dp[ind];
		if(ind == 0 )
			return arr[ind];
		
		
		int pick = arr[ind]+maxSum(ind-2,arr,dp);
		int notpick = maxSum(ind-1,arr,dp);
		return dp[ind] =  Math.max(pick, notpick);
		
	}
	
	//Tabulation
	static int maxSum_tab(int n,int[] arr) {
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		//base case
		dp[0] =  arr[0];
		
		for(int i=1;i<n;i++) {
			int pick = arr[i];
			if(i>1)
			   pick += dp[i-2];
			int notpick = dp[i-1];
			dp[i] = Math.max(pick, notpick);
		}
		return dp[n-1];
	}
	
	public static void main(String args[]) {
		int n =6;
		int[] arr = {5, 5, 10, 100, 10, 5};
		System.out.println(maxSum_tab(n,arr));
	}
}
