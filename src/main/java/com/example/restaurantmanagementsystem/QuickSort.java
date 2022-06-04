package com.example.restaurantmanagementsystem;

class QuickSort{
    int partition(int[] arr, int low, int high, boolean dec){

        int pivot = arr[high];
        int i = (low-1); // index of smaller element

        for (int j=low; j<high; j++){
            // If current element is smaller than or
            // equal to pivot
            if (( !dec && arr[j] <= pivot ) || ( dec && arr[j] > pivot)  ){
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    void sort(int[] arr, int low, int high, boolean dec){
        if (low < high){
			/* pi is partitioning index, arr[pi] is
			now at right place */
            int pi = partition(arr, low, high, dec);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1, dec);
            sort(arr, pi+1, high, dec);
        }
    }

    // String Quick Sort
    String[] names;
    int length;

    void sort(String[] array, boolean dec) {
        if (array == null || array.length == 0)
            return;

        this.names = array;
        this.length = array.length;
        quickSort(0, length - 1, dec);
    }

    void quickSort(int lowerIndex, int higherIndex, boolean dec) {
        int i = lowerIndex;
        int j = higherIndex;
        String pivot = this.names[lowerIndex + (higherIndex - lowerIndex) / 2];

        while (i <= j) {
            if (dec){
                while (this.names[i].compareToIgnoreCase(pivot) > 0)
                    i++;
                while (this.names[j].compareToIgnoreCase(pivot) < 0)
                    j--;
            }else {
                while (this.names[i].compareToIgnoreCase(pivot) < 0)
                    i++;
                while (this.names[j].compareToIgnoreCase(pivot) > 0)
                    j--;
            }


            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        //call quickSort recursively
        if (lowerIndex < j) {
            quickSort(lowerIndex, j, dec);
        }
        if (i < higherIndex) {
            quickSort(i, higherIndex, dec);
        }
    }

    void swap(int i, int j) {
        String temp = this.names[i];
        this.names[i] = this.names[j];
        this.names[j] = temp;
    }


    static void printArray(int[] arr){
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }
}

