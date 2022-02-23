package Practice;

import java.util.*;

public class Sort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        QuickSort sort = new QuickSort();
        Random rand = new Random();

        int n = 100000;
        int a[] = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = rand.nextInt();
        }

        long start = System.currentTimeMillis();
        sort.qSort(a, 0, n - 1);
        long end = System.currentTimeMillis();
        System.out.println("Time for quick sort 100000 elements: "+ (end - start) + "ms");


//        for(int i = 0; i < n; i++){
//            System.out.print(a[i] + " ");
//        }
    }
}

class QuickSort {
    static Random rand = new Random();

    void swap(int a[], int l, int r){
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }

    public int partition(int a[], int l, int r) {
        int p = rand.nextInt(r - l + 1) + l;

        int pivot = a[p];

        swap(a, p, r);

        int i = l - 1;
        for(int j = l; j < r; j++) {
            if(a[j] <= pivot){
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);

        return i + 1;
    }

    public void qSort(int a[], int l, int r) {
        if(l >= r) return;

        int piv = partition(a, l, r);
        qSort(a, l, piv - 1);
        qSort(a, piv + 1, r);
    }
}