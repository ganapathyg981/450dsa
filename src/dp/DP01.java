package dp;// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class DP01 {
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

        long[][] dp= new long[m+1][n+1];

        for(int i=0;i<dp.length;i++)
            for(int j=0;j<dp[i].length;j++){
                if(i==0)
                    dp[i][j]=0;
                if(j==0)
                    dp[i][j]=1;


                if(i>0&&j>0){

                    long inclusion=-1;
                    if(j-S[i-1]>=0)
                        inclusion=dp[i][j-S[i-1]];
                    dp[i][j]=inclusion!=-1?dp[i-1][j]+inclusion:dp[i-1][j];

                }

            }

        return dp[m][n];




    }

}