// Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
//
//
// '.' Matches any single character.
// '*' Matches zero or more of the preceding element.
//
//
// The matching should cover the entire input string (not partial).
//
// Note:
//
//
// 	s could be empty and contains only lowercase letters a-z.
// 	p could be empty and contains only lowercase letters a-z, and characters like . or *.
//
//
// Example 1:
//
//
// Input:
// s = "aa"
// p = "a"
// Output: false
// Explanation: "a" does not match the entire string "aa".
//
//
// Example 2:
//
//
// Input:
// s = "aa"
// p = "a*"
// Output: true
// Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
//
//
// Example 3:
//
//
// Input:
// s = "ab"
// p = ".*"
// Output: true
// Explanation: ".*" means "zero or more (*) of any character (.)".
//
//
// Example 4:
//
//
// Input:
// s = "aab"
// p = "c*a*b"
// Output: true
// Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
//
//
// Example 5:
//
//
// Input:
// s = "mississippi"
// p = "mis*is*p*."
// Output: false
//
//


class Solution {
    public boolean isMatch(String s, String p) {
        if(s==null ||p==null)return false;
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for(int i=1;i<=p.length();i++){
            if(p.charAt(i-1)=='*'&& dp[0][i-2])//how to deal with *
                dp[0][i]=true;
        }
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.')//the i, j place
                    dp[i][j]=dp[i-1][j-1];
                if(p.charAt(j-1)=='*'){
                    if(p.charAt(j-2)!='.' && p.charAt(j-2)!=s.charAt(i-1)){
                        dp[i][j]=dp[i][j-2];
                    }
                    else{
                        dp[i][j]=(dp[i][j-1]||dp[i-1][j]||dp[i][j-2]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];//not return true here!!
    }
}
