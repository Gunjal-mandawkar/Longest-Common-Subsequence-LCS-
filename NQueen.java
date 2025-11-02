import java.util.*;

public class NQueen {
    static int n;
    static int[] x;

    static boolean place(int k, int i) {
        for (int j = 1; j < k; j++) {
            if (x[j] == i || Math.abs(x[j] - i) == Math.abs(j - k))
                return false;
        }
        return true;
    }

    static void nQueen(int k, int n) {
        for (int i = 1; i <= n; i++) {
            if (place(k, i)) {
                x[k] = i;
                if (k == n) {
                    for (int m = 1; m <= n; m++)
                        System.out.print(x[m] + " ");
                    System.out.println();
                } else
                    nQueen(k + 1, n);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = new int[n + 1];
        nQueen(1, n);
    }
}
