package dp;

import java.util.Arrays;

/*
 * House Robber
 * 
 * A thief needs to rob money in a street. The houses in the street are arranged in a circular manner. 
 * Therefore the first and the last house are adjacent to each other. The security system in the street is
 * such that if adjacent houses are robbed, the police will get notified.
 * 
 * Intution:
 * The main condition is we should not rob from the adjacent houses and  houses are in circular. So take either
 * 1st house or last house and calculate the maxSum in two cases. The answer is max of two cases.
 * 
 */
public class DP6HouseRobber {
	 public static int FindMaxSum(int arr[], int n)
	    {
	        // Your code here
		 if(n==1)
			 return arr[0];
		 	int[] arr1 = new int[n-1];
		 	int[] arr2 = new int[n-1];
		 	int j=0,k=0;
		 	for(int i=0;i<n;i++) {
		 		if(i==0)
		 			arr1[j++] = arr[i];
		 		else if(i==n-1)
		 			arr2[k++] = arr[i];
		 		else {
		 			arr1[j++] = arr[i];
		 			arr2[k++] = arr[i];
		 		}
		 	}
		 	System.out.println(Arrays.toString(arr1));
		 	System.out.println(Arrays.toString(arr2));
		 	int[] dp = new int[n-1];
		 	Arrays.fill(dp, -1);
		 	int first = maxSum(n-2,arr1,dp);
		 	System.out.println(Arrays.toString(dp) );
			Arrays.fill(dp, -1);
		 	int last = maxSum(n-2,arr2,dp);
		 	System.out.println(Arrays.toString(dp) );
		 	return Math.max(first,last);
		 
		 
	    }
	 
	 public static int maxSum(int ind,int[] arr,int[] dp) {
		 if(ind < 0)
				return 0;
			if(dp[ind] != -1)
				return dp[ind];
			if(ind == 0 )
				return dp[ind];
			
			
			int pick = arr[ind]+maxSum(ind-2,arr,dp);
			int notpick = maxSum(ind-1,arr,dp);
			return dp[ind] =  Math.max(pick, notpick);
	 }
	 
	 
	 
	 public static void main(String args[]) {
		 int n = 3;
		 int arr[] = {2,3,2};
		 int money = FindMaxSum(arr,n);
		 System.out.println(money);
	 }
}
