import java.util.Scanner;
import java.util.Random;

public class MergeSortExp {
    public static void mergeSort(int[] a, int low, int high) {
        int N = high - low;
        if (N <= 1)
            return;
        int mid = low + (N / 2);
        mergeSort(a, low, mid);
        mergeSort(a, mid, high);
        int[] temp = new int[N];
        int i = low, j = mid;
        for (int k = 0; k < N; k++) {
            if (i == mid)
                temp[k] = a[j++];
            else if (j == high)
                temp[k] = a[i++];
            else if (a[j] < a[i])
                temp[k] = a[j++];
            else
                temp[k] = a[i++];
        }
        for (int k = 0; k < N; k++)
            a[low++] = temp[k];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i;
        Random r = new Random();
        System.out.println("Merge Sort\nEnter the Number of times the algorithm should Run");
        int times = scan.nextInt();
        double totaldur = 0;
        for (int j = 0; j < times; j++) {
            System.out.println("Random Number Generated are at POS " + j + " as follows : ");
            int[] a = new int[10];
            for (i = 0; i < 10; i++) {
                a[i] = r.nextInt(1000);
                System.out.print(a[i] + " ");
            }
            System.out.println("");
            long StartTime = System.nanoTime();
            mergeSort(a, 0, 10);
            double EndTime = System.nanoTime();
            double duration = (EndTime - StartTime);
            System.out.println("Elements after Sorting are");
            for (i = 0; i < 10; i++)
                System.out.print(a[i] + " ");
            System.out.println("");
            totaldur = totaldur + duration;
        }
        System.out.println("\nTotal time taken to Sort is :" + totaldur + " Nano Seconds");
        double miliseconds = (totaldur / 1000000);
        System.out.println("\nTotal time taken to Sort is :" + miliseconds + "Mili Seconds");
        double avg = totaldur / times;
        System.out.println("The Average time Spend by the System is : " + avg + " Nano Second");
        double miliavg = (avg / 1000000);
        System.out.println("The Avergae time Spend by the System is : " + miliavg + " Mili Seconds");
        scan.close();
    }
}
