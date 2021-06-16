package Chapter14;

import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * 1) Count the number of names starting with letter 'A' in a list
 */
public class StreamsIntro {

    // ad 1. Regular way (without using Java Streams)
    @Test
    public void regular() {

        ArrayList<String> namesList = new ArrayList<String>();
        namesList.add("Wiktor");
        namesList.add("Adam");
        namesList.add("Robert");
        namesList.add("Aleks");
        namesList.add("Arab");
        //System.out.println(namesList);

        int countNamesStartingWithA = 0;
        for (int i = 0; i < namesList.size(); i += 1) {
            if (namesList.get(i).toLowerCase().startsWith("a")) {
                System.out.println(namesList.get(i));
                countNamesStartingWithA += 1;
            }
        }
        System.out.println(countNamesStartingWithA);
    }

    // ad 1. Using Java Streams
    //@Test
    public void streamFilter() {

        ArrayList<String> namesList = new ArrayList<String>();
        namesList.add("Wiktor");
        namesList.add("Adam");
        namesList.add("Robert");
        namesList.add("Aleks");
        namesList.add("Arab");

        // 10:20
    }
}
