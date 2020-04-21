package classification.datastructure;

public class HeapSort {

    private void sort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length - 1);
        }
        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            adjustHeap(array, 0, i - 1);
        }
    }

    private void adjustHeap(int[] array, int index, int maxIndex) {
        int temp = array[index];
        for (int i = index * 2 + 1; i <= maxIndex; i = i * 2 + 1) {
            if (i + 1 <= maxIndex && array[i + 1] > array[i]) {
                i = i + 1;
            }
            if (temp < array[i]) {
                array[index] = array[i];
                index = i;
            } else {
                break;
            }
        }
        array[index] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[] {9, 8, 7, 6, 5, 4, 3, 2};
        new HeapSort().sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
