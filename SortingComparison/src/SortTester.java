public class SortTester {
    public static void main(String[] args){

        //int[] randArr = generateRandomArr(6);


        int[] randArr = new int[]{1, 7, 16, 7, 15, 11, };
        printArr(randArr);

        int[] sorted = Sorter.heapSort(randArr);
        printArr(sorted);
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
