package VariousTopics;

public class EdabitExcercises {

    public int convertMinutesToSeconds(int minutes) {
        return minutes * 60;
    }

    public boolean isSameNum(int num1, int num2) {
        return num1 == num2;
    }

    // Return the Remainder from Two Numbers
    public int remainderFromTwoNums(int num1, int num2) {
        return num1 % num2;
    }

    // Maximum Edge of a Triangle
    public int triangle3rdEdgeMaxRange(int edge1, int edge2) {
        if (edge1 > 0 && edge2 > 0) {
            return (edge1 + edge2) - 1;
        } else {
            return 0;
        }
    }

    // Convert Hours into Seconds
    public int convertHoursToSeconds(int hours) {
        return (hours * 60) * 60;
    }
}

class GFG {

    public static void main(String[] args) {
        EdabitExcercises excercise = new EdabitExcercises();
        //System.out.println(excercise.convertMinutesToSeconds(3));
        //System.out.println(excercise.isSameNum(2, 2));
        //System.out.println(excercise.remainderFromTwoNums(10, 3));
        //System.out.println(excercise.triangle3rdEdgeMaxRange(8, 10));
        System.out.println(excercise.convertHoursToSeconds(10));
    }
}
