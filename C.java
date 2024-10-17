import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class C {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int length = getInt();
        byte[][] byteMatrix = new byte[length][8];

        int i = 0;
        while (i < length) {
            byte[] currentBytes = new BigInteger(getString()).toByteArray();
            System.arraycopy(
                    currentBytes,
                    Math.max(currentBytes.length - 8, 0),
                    byteMatrix[i],
                    8 - Math.min(currentBytes.length, 8),
                    Math.min(currentBytes.length, 8));
            i++;
        }

        int j = 7;
        while (j >= 0) {
            sortCounting(byteMatrix, j);
            j--;
        }

        for (byte[] element : byteMatrix) {
            BigInteger output = new BigInteger(1, element);
            System.out.print(output + " ");
        }
    }

    private static void sortCounting(byte[][] matrix, int byteIndex) {
        int[] count = new int[256];

        int k = 0;
        while (k < matrix.length) {
            int value = matrix[k][byteIndex];
            if (value >= 0) {
                count[value] += 1;
            } else {
                count[256 + value] += 1;
            }
            k++;
        }

        for (int m = 1; m < 256; m++) {
            count[m] += count[m - 1];
        }

        byte[][] result = new byte[matrix.length][8];

        int n = matrix.length - 1;
        while (n >= 0) {
            byte[] byteValue = matrix[n];
            if (byteValue[byteIndex] >= 0) {
                result[count[byteValue[byteIndex]] - 1] = byteValue;
                count[byteValue[byteIndex]] -= 1;
            } else {
                result[count[256 + byteValue[byteIndex]] - 1] = byteValue;
                count[256 + byteValue[byteIndex]] -= 1;
            }
            n--;
        }

        int p = 0;
        while (p < matrix.length) {
            matrix[p] = result[p];
            p++;
        }
    }

    private static int getInt() throws Exception {
        return Integer.parseInt(getString());
    }

    private static String getString() throws Exception {
        return input.readLine().trim();
    }

    private static int[] getArraySingleLine(int length) throws Exception {
        String[] strArray = getString().split(" ");
        int[] result = new int[length];

        int q = 0;
        while (q < length) {
            result[q] = Integer.parseInt(strArray[q]);
            q++;
        }
        return result;
    }

    private static byte[] getArrayMultipleLines(int length) throws Exception {
        byte[] result = new byte[length];

        int r = 0;
        while (r < length) {
            result[r] = (byte) getInt();
            r++;
        }
        return result;
    }
}
