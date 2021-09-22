package com.mvvm.common.citypicker;

/**
 * @author : WinterSweett
 * @time : {DATE}
 */
public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        char[]X=text1.toCharArray();
        char[]Y=text2.toCharArray();
        int m=X.length;
        int n=Y.length;
        return LCS(X,Y,m,n);

    }

    public static int LCS(char[] X, char[] Y, int m, int n) {
        int[][]memo=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    memo[i][j]=0;
                }else if(X[i-1]==Y[j-1]){
                    memo[i][j]=memo[i-1][j-1]+1;
                }else{
                    memo[i][j]=Math.max(memo[i-1][j],memo[i][j-1]);
                }

            }
        }
        return memo[m][n];

    }
}
