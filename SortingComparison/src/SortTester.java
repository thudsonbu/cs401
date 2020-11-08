import java.util.Random;

public class SortTester {
    public static void main(String[] args){

        int[] randArr = generateRandomArr(10);
        printArr(randArr);

        int[] insertionSorted = Sorter.insertionSort(randArr);
        printArr(insertionSorted);

        randArr = generateRandomArr(10);
        int[] bubbleSorted = Sorter.bubbleSort(randArr);
        printArr(bubbleSorted);

        randArr = generateRandomArr(10);
        int[] shellSorted = Sorter.shellSort(randArr, 10);
        printArr(shellSorted);

        randArr = generateRandomArr(20);
        printArr(randArr);

        int[] mergeSorted = Sorter.mergeSort(randArr);
        printArr(mergeSorted);

        randArr = generateRandomArr(20);
        printArr(randArr);

        int[] heapSorted = Sorter.heapSort(randArr);
        printArr(heapSorted);
    }

    public static void printArr(int[] arr){

        for (int j : arr) {

            System.out.print(j);
            System.out.print(" ");
        }

        System.out.println(";");
    }

    public static int[] generateRandomArr(int length){

        int[] randArr = new int[length];

        for (int i = 0; i < length; i++){

            randArr[i] = getRandomNumber(0,20);
        }

        return randArr;
    }

    public static int getRandomNumber(int min, int max) {

        return (int) ((Math.random() * (max - min)) + min);
    }
}
