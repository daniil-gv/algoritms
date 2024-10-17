import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[][] A = new int[n][l];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < l; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] B = new int[m][l];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < l; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int q = Integer.parseInt(reader.readLine());
        int[][] arrayQ = new int[q][2];
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(reader.readLine());
            arrayQ[i][0] = Integer.parseInt(st.nextToken()) - 1;
            arrayQ[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }
        for (int i = 0; i < q; i++) {
            int left = 0;
            int right = l - 1;
            while (left < right) {
                int mid = (right + left) / 2;
                if (A[arrayQ[i][0]][mid] < B[arrayQ[i][1]][mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (right - 1 < 0) {
                System.out.println(1);
            } else if (A[arrayQ[i][0]][right] > B[arrayQ[i][1]][right - 1]) {
                System.out.println(right);
            } else {
                System.out.println(right + 1);
            }
        }
    }
}
