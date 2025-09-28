// Aim: Implement Longest Repeating Subsequence (LRS) using LCS framework
// LRS finds the longest subsequence that appears at least twice in the string

public class LRS {
    
    public static void main(String[] args) {
        String s = "AABCBDC";
        int n = s.length();
        ArrayPair result = lrs(s);
        int[][] b = result.array1;
        int[][] c = result.array2;
        
        System.out.println("Input string: " + s);
        System.out.println("Cost matrix:");
        for(int i=1;i<=n;i++){
            for(int j = 1;j<=n;j++){
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\nLength of LRS: " + c[n][n]);
        System.out.println("LONGEST REPEATING SUBSEQUENCE:");
        char[] S = s.toCharArray();
        printLRS(b, S, n, n);
    }
    
    static ArrayPair lrs(String s) {
        int n = s.length();
        char[] S = s.toCharArray();
        int[][] b = new int[n+1][n+1];
        int[][] c = new int[n+1][n+1];
        
      
        for(int i=0;i<=n;i++){
            c[i][0] = 0;
        }
        for(int j=0;j<=n;j++){
            c[0][j] = 0;
        }
        
        // Fill the DP table
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
             
                if(S[i-1]==S[j-1] && i!=j){
                    c[i][j] = c[i-1][j-1]+1;
                    b[i][j] = 1; 
                }
                else if(c[i-1][j]>=c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    b[i][j] = 2; 
                }
                else{
                    c[i][j] = c[i][j-1];
                    b[i][j] = 3; 
                }
            }
        }
        return new ArrayPair(b,c);
    }
    
    static void printLRS(int[][] b, char[] s, int i, int j) {
        if(i==0 || j==0){
            return;
        }
        if(b[i][j] == 1){
            printLRS(b, s, i-1, j-1);
            System.out.print(s[i-1]);
        }
        else if(b[i][j]==2){
            printLRS(b, s, i-1, j);
        }
        else{
            printLRS(b, s, i, j-1);
        }
    }
}
