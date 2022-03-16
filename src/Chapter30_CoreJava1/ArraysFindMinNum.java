package Chapter30_CoreJava1;

/**
 * Find the minimum number in the given array.
 */

public class ArraysFindMinNum {

    public static void main(String[] args) {

        int[][] arr = {{2, 4, 5}, {3, 4, 7}, {1, 2, 9}};
        int arrMinValue = arr[0][0]; // 2

        for (int i = 0; i < arr.length; i += 1) {
            for (int j = 0; j < arr[i].length; j += 1) {
                //System.out.println(arr[i][j]);
                if (arr[i][j] < arrMinValue) {
                    arrMinValue = arr[i][j];
                }
            }
        }

        System.out.printf("The smallest value in the array is: %d", arrMinValue).println();
    }
}
