import java.util.Random;

public class SortTester {
    public static void main(String args[]){

        int[] randArr = generateRandomArr(10);
        printArr(randArr);

        int[] insertionSorted = Sorter.insertionSort(randArr);
        printArr(randArr);

        randArr = generateRandomArr(10);
        printArr(randArr);

        int[] bubbleSorted = Sorter.bubbleSort(randArr);
        printArr(bubbleSorted);
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
        Random rand = new Random();

        for (int i = 0; i < length; i++){

            randArr[i] = getRandomNumber(0,20);
        }

        return randArr;
    }

    public static int getRandomNumber(int min, int max) {

        return (int) ((Math.random() * (max - min)) + min);
    }
}
