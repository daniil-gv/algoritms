import java.util.Scanner;

public class A {
    public static int[][] merge(int[][] a, int[][] b, int[][] to) {
        int i = 0;
        int j = 0;
        int n = a.length;
        int m = b.length;
        while (i < n && j < m) {
            if (a[i][0] <= b[j][0]) {
                to[i + j] = a[i];
                i++;
            } else {
                to[i + j] = b[j];
                j++;
            }
        }
        while (i < n) {
            to[i + j] = a[i];
            i++;
        }
        while (j < m) {
            to[i + j] = b[j];
            j++;
        }
        return to;
    }

    public static int[][] sort(int[][] a) {
        int n = a.length;
        if (n <= 1) {
            return a;
        }
        int k = n / 2;
        int[][] l = new int[k][2];
        int[][] r = new int[n - k][2];
        for (int i = 0; i < k; i++) {
            l[i] = a[i];
        }
        for (int i = 0; i < n - k; i++) {
            r[i] = a[k + i];
        }
        sort(l);
        sort(r);
        return merge(l, r, a);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        sort(array);
        int cnt = 0;
        int[][] result = new int[n][2];
        int start = array[0][0];
        int end = array[0][1];
        for (int i = 1; i < n; i++) {
            if (end >= array[i][0]) {
                end = Math.max(end, array[i][1]);
            } else {
                int[] segment = {start, end};
                result[cnt++] = segment;
                start = array[i][0];
                end = array[i][1];
            }
        }
        int[] segment = {start, end};
        result[cnt++] = segment;
        System.out.println(cnt);
        for (int i = 0; i < cnt; i++) {
            System.out.printf("%d %d \n", result[i][0], result[i][1]);
        }
    }
}
