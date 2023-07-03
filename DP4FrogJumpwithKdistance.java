package dp;
/**
 * 
 * Frog Jump with k Distances
 * 
 * Problem Statement:

   This is a follow-up question to “Frog Jump” discussed in the previous article. In the previous question, 
   the frog was allowed to jump either one or two steps at a time. In this question, the frog is allowed to 
   jump up to ‘K’ steps at a time. If K=4, the frog can jump 1,2,3, or 4 steps at every index.
 */
import java.util.Arrays;

public class DP4FrogJumpwithKdistance {

	//Recursive appraoch
	public static int minimizeEnergy(int arr[], int N, int K) {
	
		int dp[] = new int[N];
		Arrays.fill(dp, -1);

		return minEnergy(N, arr, K);
	}

	public static int minEnergy(int step, int[] arr, int k) {
		if (step == 0) {
			return 0;
		}
		int minEner = (int) 1e8;
		for (int i = 1; i <= k; i++) {
			if (step - i >= 0) {
				minEner = Math.min(minEner, Math.abs(arr[step] - arr[step - i]) + minEnergy(step - i, arr, k));

			}
		}
		return minEner;
	}

	//Memoization appraoch
	public static int minimizeEnergy_mem(int arr[], int N, int K) {
		
		int dp[] = new int[N];
		Arrays.fill(dp, -1);

		return minEnergy(N-1, arr, K, dp);
	}

	public static int minEnergy(int step, int[] arr, int k, int[] dp) {
		//Base case
		if(step == 0)
			return 0 ;
		if(dp[step] != -1) {
			
			return dp[step];
		}
		int minEner = (int) 1e8;
		for (int i = 1; i <= k; i++) {
			if (step - i >= 0) {
				minEner = Math.min(minEner, Math.abs(arr[step] - arr[step - i]) + minEnergy(step - i, arr, k,dp));

			}
		}
		
		return dp[step] = minEner;
	}

	// Tabulation appraoch
	
	public static int minimizeEnergy_tab(int arr[], int N, int K) {
		
		int dp[] = new int[N];
		//base case
		dp[0] =0;
		int minEner;
		//loop
		for(int i=1;i<N;i++) {
			minEner =Integer.MAX_VALUE;
			//recursion code
			for (int j = 1; j <= K; j++) {
				if (i - j >= 0) {
					minEner = Math.min(minEner, Math.abs(arr[i] - arr[i-j]) + dp[i-j]);

				}
			}
			dp[i] = minEner;
		}
		return dp[N-1];
	}
	
	public static void main(String args[]) {
		int n = 5, k = 3;
		int[] heights = { 10, 30, 40, 50, 20};
		System.out.println(minimizeEnergy_tab(heights, n, k));
	}
}
