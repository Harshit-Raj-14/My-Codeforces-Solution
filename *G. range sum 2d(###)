import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt(), m = in.nextInt(), q = in.nextInt();
        long[][] v = new long[n + 1][m + 1];
        v[0][0] = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                v[i][j] = in.nextInt();
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                v[i][j] += v[i][j - 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                v[j][i] += v[j - 1][i];

        while (q-- > 0) {
            int l1 = in.nextInt(), r1 = in.nextInt(), l2 = in.nextInt(), r2 = in.nextInt();
            if (l1 == 1 && r1 == 1) out.println(v[l2][r2]);

            else out.println(v[l2][r2] - v[l2][r1 - 1] - v[l1 - 1][r2] + v[l1 - 1][r1 - 1]);

        }
        out.close();
    }


    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
