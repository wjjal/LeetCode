//Given a string S and a string T, count the number of distinct subsequences of T in S.
//
//A subsequence of a string is a new string which is formed from the original 
//string by deleting some (can be none) of the characters without 
//disturbing the relative positions of the remaining characters. 
//(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
//
//Here is an example:
//S = "rabbbit", T = "rabbit"
//
//Return 3.

public class DistinctSubsequences {
	public class Solution {
	    public int numDistinct(String S, String T) {
	        int M = S.length();
	        int N = T.length();
	        if (M == 0 && N == 0)
	            return 1;
	        else if (M < N)
	            return 0;
	        int dp[][] = new int[M+1][N+1];
	        for(int i = 0;i<M;i++){
	            dp[i][0] = 1;
	        }
	        for(int i = 1; i <= M; i++){
	            for(int j = 1; j <= N; j++){
	                dp[i][j] = dp[i-1][j];
	                if(S.charAt(i-1) == T.charAt(j-1))
	                   dp[i][j] += dp[i-1][j-1];
	            }
	        }
	        return dp[M][N];
	    }
	}
	
	public class Solution2 {
	    public int numDistinct(String S, String T) {
	        int M = S.length();
	        int N = T.length();
	        if (M == 0 && N == 0)
	            return 1;
	        else if (M < N)
	            return 0;
	        int F[] = new int[M+1];
	        F[0] = 1;
	        for(int i = 1; i <= M; i++){
	            for(int j = N; j>=1; j--){
	                if (S.charAt(i-1) == T.charAt(j-1))
	                    F[j] = F[j-1] + F[j];
	            }
	        }
	        return F[N];
	    }
	}
}
