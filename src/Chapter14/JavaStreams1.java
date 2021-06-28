package Chapter14;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Zadanka:
 * I. Count the number of names starting with letter 'A' in a list
 * II. Print all the names which length is greater than 4
 * III. Among the names which length is greater than 4 - print the first result
 */
public class JavaStreams1 {

    // Regular way (without using Java Streams)
    @Test
    public void regular() {

        ArrayList<String> namesList = new ArrayList<String>();
        namesList.add("Wiktor");
        namesList.add("Adam");
        namesList.add("Robert");
        namesList.add("Aleks");
        namesList.add("Arab");
        //System.out.println(namesList);

        // ad I.
        int countNamesStartingWithA = 0;
        for (int i = 0; i < namesList.size(); i += 1) {
            String name = namesList.get(i);
            if (name.startsWith("A")) {
                //System.out.println(namesList.get(i));
                countNamesStartingWithA += 1;
            }
        }
        System.out.println(countNamesStartingWithA);

        // ad II.
        for (String name : namesList) {
            if (name.length() > 4) {
                System.out.println(name);
            }
        }
    }

    // Using Java Streams
    @Test
    public void streamFilter() {

        ArrayList<String> namesList = new ArrayList<String>();
        namesList.add("Wiktor");
        namesList.add("Adam");
        namesList.add("Robert");
        namesList.add("Alex");
        namesList.add("Arab");

        // ad I.
        /**
         * Tworzenie i działanie Java Streams można podzielić na 3 etapy:
         *
         * 1) Create a stream
         *  a) konwertuję wcześniej stworzoną listę do stream ('namesList.stream()...'),
         *  b) istnieje też możliwość stworzenia od razu obiektu typu Stream np.
         *     Stream.of("Wiktor", "Adam", "Robert", "Aleks", "Arab")
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
         * To wszystko deklaruję w zmiennej typu long (dlatego że metoda count() zwraca longa)
         */
        long countNamesStartingWithA = namesList.stream().filter(name -> name.startsWith("A")).count();
        //System.out.println(countNamesStartingWithA);

        // ad II.
        /**
         * 1) 'namesList.stream()' - na tym etapie stream jest stworzony i ma 5 elementów (imion)
         * 2) '.filter(name -> name.length() > 4)' - na tym etapie dokonana jest już intermediate operation i stream ma już tylko 2 elementy
         * 3) '.forEach(name -> System.out.println(name))' - terminal operation wykonuje operacje na aktualnym streamie (z 2 imionami)
         */
        //namesList.stream().filter(name -> name.length() > 4).forEach(name -> System.out.println(name));

        // ad III.
        Optional<String> firstNameLongerThan4 = namesList.stream().filter(name -> name.length() > 4).findFirst();
        //System.out.println(firstNameLongerThan4);

        namesList.stream().filter(name -> name.length() > 4).limit(1).forEach(name -> System.out.println(name));
    }
}
