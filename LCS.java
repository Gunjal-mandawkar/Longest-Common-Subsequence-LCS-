// Aim: Implement a dynamic algorithm for Longest Common Subsequence (LCS) to find the
// length and LCS for DNA sequences.

public class LCS {
    public static void main(String[] args) {
        String x = "AGCCCTAAGGGCTACCTAGCTT";
        int m = x.length();

        String y = "GACAGCCTACAAGCGTTAGCTTG";
        int n = y.length();
        ArrayPair a = new ArrayPair(null, null);
        a = lcs(x, y);
        int[][] b = a.array1;  
        int[][] c = a.array2;  
        System.out.println("Cost matrix:");
        for(int i=1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\nLength of LCS: " + c[m][n]);
        char[] C = x.toCharArray();
        System.out.println("LONGEST COMMON SUBSEQUENCE:");
        Printlcs(b, C, m, n);
        
    }
    


    static ArrayPair lcs(String x, String y){
        int m = x.length();
        int n = y.length();
        char[] X = x.toCharArray();
        char[] Y = y.toCharArray();
        int[][] b = new int[m+1][n+1];
        int[][] c = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            c[i][0] = 0;
        }

        for(int j = 0;j<=n;j++){
            c[0][j] = 0;
        }
        
        for(int i=1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(X[i-1]==Y[j-1]){
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

    static void Printlcs(int[][] b, char[] x,int i,int j){
        
        if(i==0 || j==0){
            return;
        }
        if(b[i][j] == 1){
            Printlcs(b,x,i-1,j-1);
            System.out.print(x[i-1]);
        }
        else if(b[i][j]==2){
            Printlcs(b,x,i-1,j);
        }
        else{
            Printlcs(b,x,i,j-1);
        }
    }
}
