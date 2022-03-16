package Chapter30_CoreJava1;

public class b_NestedForLoopsPyramid {

    public static void main(String[] args) {

        /*for (int i = 1; i <= 4; i += 1) {
            System.out.printf("\nIteration i: %d\n", i).println();
            for (int j = 1; j <= 4; j += 1) {
                System.out.printf("Iteration j: %d", j).println();
            }
        }*/
        /**
         * 1 2 3 4
         * 5 6 7
         * 8 9
         * 10
         */
        int num = 1;
        /*for (int i = 0; i <= 3; i += 1) {
            //System.out.printf("\nIteration i: %d", i).println();
            String concatenatedNums = "";
            for (int j = 1; j <= 4 - i; j += 1) {
                //System.out.printf("Iteration j: %d", j).println();
                //System.out.println(num);
                concatenatedNums = concatenatedNums.concat(num + " ");
                num += 1;
            }
            System.out.println(concatenatedNums);
        }*/
        /**
         * 1
         * 2 3
         * 4 5 6
         * 7 8 9 10
         */
        /*for (int i = 3; i >= 0; i -= 1) {
            //System.out.printf("\nIteration i: %d", i).println();
            for (int j = 3; j >= 0 + i ; j -= 1) {
                //System.out.printf("Iteration j: %d", j).println();
                System.out.print(num);
                System.out.print(" ");
                num += 1;
            }
            System.out.println();
        }*/
        /**
         * simpler solution
         */
        /*for (int i = 1; i <= 4; i += 1) { // outer loop
            //System.out.printf("\nIteration i: %d", i).println();
            for (int j = 1; j <= i ; j += 1) { // inner loop
                //System.out.printf("Iteration j: %d", j).println();
                System.out.print(num);
                System.out.print(" ");
                num += 1;
            }
            System.out.println();
        }*/
        /**
         * 3
         * 6 9
         * 12 15 18
         */
        int numNew = 3;
        for (int i = 1; i <= 3; i += 1) {
            //System.out.printf("\nIteration i: %d", i).println();
            for (int j = 1; j <= i; j += 1) {
                //System.out.printf("\nIteration j: %d", j).println();
                System.out.printf("%d ", numNew);
                numNew += 3;
            }
            System.out.println();
        }
    }
}
