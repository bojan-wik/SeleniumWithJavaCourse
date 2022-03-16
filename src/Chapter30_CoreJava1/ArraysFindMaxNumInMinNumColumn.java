package Chapter30_CoreJava1;

/**
 * Find the minimum number in the given array,
 * identify the column of the minimum number,
 * find the maximum number in identified column.
 */

public class ArraysFindMaxNumInMinNumColumn {

    public static void main(String[] args) {

        /**
         * 2 4 5
         * 3 2 10
         * 1 2 0
         */
        int[][] theArr = {{2, 4, 5}, {3, 2, 10}, {1, 2, 0}};
        int minNumInArr = theArr[0][0];
        int minNumColumnIdentifier = 0;

        for (int i = 0; i < theArr.length; i += 1) {
            for (int j = 0; j < theArr[i].length; j += 1) {
                //System.out.println(theArr[i][j]);
                if (theArr[i][j] < minNumInArr) {
                    minNumInArr = theArr[i][j];
                    minNumColumnIdentifier = j;
                }
            }
        }
        System.out.printf("\nThe smallest number in the array is: %d", minNumInArr).println();

        /**
         * My solution
         */
        /*int[] arrMinNumColumn = new int[theArr.length];
        for (int i = 0; i < theArr.length; i += 1) {
            //System.out.println(theArr[i][minNumColumnIdentifier]);
            arrMinNumColumn[i] = theArr[i][minNumColumnIdentifier];
        }
        System.out.printf("The column of the smallest number in the array is: %s",
                Arrays.toString(arrMinNumColumn)).println();

        int maxNumInMinNumColumn = arrMinNumColumn[0];
        for (int i = 0; i < arrMinNumColumn.length; i += 1) {
            //System.out.println(arrMinNumColumn[i]);
            if (arrMinNumColumn[i] > maxNumInMinNumColumn) {
                maxNumInMinNumColumn = arrMinNumColumn[i];
            }
        }
        System.out.printf("The biggest number in this column is: %d\n", maxNumInMinNumColumn);*/

        /**
         * Solution proposed in the course
         */
        int maxNumInMinNumColumn = theArr[0][minNumColumnIdentifier];
        int whileLoopCounter = 0;
        while (whileLoopCounter < theArr.length) {
            if (theArr[whileLoopCounter][minNumColumnIdentifier] > maxNumInMinNumColumn) {
                maxNumInMinNumColumn = theArr[whileLoopCounter][minNumColumnIdentifier];
            }
            whileLoopCounter += 1;
        }
        System.out.printf("The biggest number in identified column is: %d\n", maxNumInMinNumColumn);
    }
}
