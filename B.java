import java.util.Scanner;

public class B {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        int totalCount = inputScanner.nextInt();
        long targetIndex = inputScanner.nextLong() - 1;
        long[] numbers = new long[totalCount];
        numbers[0] = inputScanner.nextLong();
        numbers[1] = inputScanner.nextLong();

        int index = 2;
        while (index < totalCount) {
            numbers[index] = computeElement(numbers[index - 1], numbers[index - 2]);
            index++;
        }

        quickSort(numbers, 0, totalCount - 1);
        System.out.println(numbers[(int) targetIndex]);
    }

    public static long computeElement(long previous, long secondPrevious) {
        return (long) ((previous * 123 + secondPrevious * 45) % (Math.pow(10, 7) + 4321));
    }

    public static void quickSort(long[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    public static int partition(long[] array, int low, int high) {
        long pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    public static void swap(long[] array, int i, int j) {
        long temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
