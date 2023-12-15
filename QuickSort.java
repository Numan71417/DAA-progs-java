import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    static int max = 2000;

    public static int partition(int[] a, int low, int high) {
        int p, i, j, temp;
        p = a[low];
        i = low + 1;
        j = high;
        while (low < high) {
            while (a[i] <= p && i < high)
                i++;
            while (a[j] > p)
                j--;
            if (i < j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            } else {
                temp = a[low];
                a[low] = a[j];
                a[j] = temp;
                return j;
            }
        }
        return j;
    }

    public static void sort(int[] a, int low, int high) {
        if (low < high) {
            int s = partition(a, low, high);
            sort(a, low, s - 1);
            sort(a, s + 1, high);
        }
    }

    public static void main(String[] args) {


        System.out.println("Enter the array size");
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();

            int[] a = new int[max];

            Random r = new Random();
            for (int i = 0; i < n; i++)
                a[i] = r.nextInt(20);

            System.out.println("Array before sorting");
            for (int i = 0; i < n; i++)
                System.out.print(a[i] + " ");


            long startTime = System.nanoTime();
            // QuickSort m = new QuickSort();
            sort(a, 0, n-1);
            long stopTime = System.nanoTime();
            long elapseTime = (stopTime - startTime);

            System.out.println("\nTime taken to sort array is:" + elapseTime + "nanoseconds");
            
            System.out.println("Sorted array is");

            for (int i = 0; i < n; i++)
                System.out.print(a[i]+" ");

            scan.close();
        }
    }

}

