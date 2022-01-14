package recursion;// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class CoinChange {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int Arr[] = new int[m];
            for (int i = 0; i < m; i++) Arr[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(Arr, m, n));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int S[], int m, int n) {
        long dp[][]= new long[m+1][n+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                dp[i][j]=-1;
            }
        }
        return count(0, S, n, dp);
    }


    public long count(int index, int coins[],int sum, long[][] dp){
        if(index==coins.length)
        {
            if(sum==0){
                return 1;
            }

            return 0;}

        if(dp[index][sum]!=-1)
            return dp[index][sum];

        long include=-1;
        long  notInclude;

        // sum is more coin is less
        if(sum>=coins[index]){
            include=count(index,coins,sum-coins[index],dp);
        }

        notInclude=count(index+1,coins,sum,dp);

        return dp[index][sum]=include!=-1?include+notInclude:notInclude;
    }


}