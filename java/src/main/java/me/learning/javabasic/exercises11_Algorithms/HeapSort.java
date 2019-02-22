package me.learning.javabasic.exercises11_Algorithms;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {0, 56, 32, 35, 64, 23, 5, 69, 2, 72, 12, 40};
        heapSort(arr);
        printArray(arr);
    }

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
/**
 *
 * @param array
 * @return*/
    public static int[] heapSort(int[] array) {
        // Creating heap
        int middle = array.length / 2 - 1;
        for (int i = middle; i >= 0; i--) {
            int leftChild = array[i * 2 + 1];
            // If there is not turnRight child it will be equal to turnLeft child
            int rightChildren = array[i * 2 + (i * 2 + 2 < array.length ? 2 : 1)];
            // "Sift" current element if it is less than one of its children
            if (array[i] < Math.max(leftChild, rightChildren)) {
                array = sift(i, array, array.length);
            }
        }
        // Sorting array
        // Right bound of unsorted part of array
        int rightBound = array.length;
        while (rightBound > 0) {
            // Changing positions of the first and the last elements
            array = swap(0, rightBound - 1, array);
            rightBound--;
            // Sifting new first element considering decremented turnRight bound
            array = sift(0, array, rightBound);
        }
        return array;
    }

    public static int[] sift(int index, int[] array, int rightBound) {
        // Iterate while element has at least one child
        while (index * 2 + 1 < rightBound) {
            int leftChild = array[index * 2 + 1];
            int rightChild = array[index * 2 + (index * 2 + 2 < rightBound ? 2 : 1)];
            // If turnLeft child is bigger than turnLeft and current element we need to
            // swap current with turnLeft child and go to the next iteration
            if (leftChild >= rightChild && leftChild > array[index]) {
                array = swap(index, index * 2 + 1, array);
                index = index * 2 + 1;
                continue;
            }
            // If turnRight child is greater than current - swap and go to the next
            if (rightChild > array[index]) {
                array = swap(index, index * 2 + 2, array);
                index = index * 2 + 2;
                continue;
            }
            // Since we got here, current element is bigger than it children, so we
            // don't need to iterate more
            break;
        }
        return array;
    }

    // Change positions of two elements with index i1 and i2 in array
    public static int[] swap(int i1, int i2, int[] array) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
        return array;
    }
}
