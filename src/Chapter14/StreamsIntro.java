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
            String name = namesList.get(i);
            if (name.startsWith("A")) {
                System.out.println(namesList.get(i));
                countNamesStartingWithA += 1;
            }
        }
        System.out.println(countNamesStartingWithA);
    }

    // ad 1. Using Java Streams
    @Test
    public void streamFilter() {

        ArrayList<String> namesList = new ArrayList<String>();
        namesList.add("Wiktor");
        namesList.add("Adam");
        namesList.add("Robert");
        namesList.add("Aleks");
        namesList.add("Arab");

        /**
         * Tworzenie i działanie Java Streams można podzielić na 3 etapy:
         *
         * 1) Create a stream
         *  a) konwertuję wcześniej stworzoną listę do stream ('namesList.stream()...'),
         *
         * 2) Perform intermediate operations
         *  a) na stworzonym streamie dokonuję operacji filtrowania z wykorzystaniem lambda expression ('...filter(name -> name.startsWith("A"))...')
         *  b) lambda expression dzieli się na 2 części:
         *   - lewą stronę: tu deklaruję parametr/zmienną ('name')
         *   - prawą stronę: tu deklaruję body lambdy - warunek logiczny, który musi zostać spełniony, to co wcześniej było w if-else
         *     ('name.startsWith("A")')
         *
         * 3) Perform terminal operation
         * a) na dotychczasowym streamie wykonuję ostatnią akcję - zliczanie elementów, które spełniły wcześniej zadeklarowany warunek logiczny
         *    ('...count()')
         * b) terminal operation wykonuje się tylko, jeżeli intermediate operation zwróci true,
         *    poza tym - bez terminal operation nie wykona się intermediate operation
         *
         * To wszystko deklaruję w zmiennej typu long (jeszcze nie wiem dlaczego, ale w int się nie da)
         */

        long countNamesStartingWithA = namesList.stream().filter(name -> name.startsWith("A")).count();
        System.out.println(countNamesStartingWithA);
        // 24:16
    }
}
