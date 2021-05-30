package Chapter30;

public class ArraysIntro {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        /*for (int num : nums) {
            System.out.println(num);
        };*/
        /*for (int i = 0; i < nums.length; i += 1) {
            System.out.println(nums[i]);
        }*/

        String[] names = {"Max", "Leon", "Wiktor"};
        /*for (String name : names) {
            System.out.println(name);
        }*/

        /**
         * multidimensional arrays
         */

        /**
         * Two-dimensional array e.g
         *
         *      | column 0 | column 1
         * row 0| 2        | 4
         * row 1| 6        | 8
         */

        // 2D array declared by creating object of arrays

        int[][] arr2D = new int[2][2]; // 1st argument stand for rows, 2nd for columns: 2x2 = 4 value matrix
        arr2D[0][0] = 2;
        arr2D[0][1] = 4;
        arr2D[1][0] = 6;
        arr2D[1][1] = 8;

        // the same 2D array declared as array literal

        int[][] arr2D_1 = {{2, 4}, {6, 8}};
        //System.out.println(arr2D_1[1][1]);
        //System.out.println(arr2D_1[0].length);

        /**
         * excercise - wyprintować 2D arraye. pewnie za pomocą nested for loops
         */

        for (int i = 0; i < arr2D_1.length; i += 1) {
            //System.out.printf("\nIteration i: %d", i).println();
            for (int j = 0; j < arr2D_1[i].length; j += 1) {
                //System.out.printf("Iteration j: %d", j).println();
                System.out.println(arr2D_1[i][j]);
            }
        }
    }
}
