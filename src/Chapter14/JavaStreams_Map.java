package Chapter14;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Zadanka:
 * I. Print names which end with 'a' with uppercase
 * II. Print names which start with 'a' with lowercase and sorted
 * III. Merge two arrayLists
 */
public class JavaStreams_Map {

    @Test
    public void streamMap() {

        // ad 1.
        /**
         * W 'JavaStreams_Filter' tworzyłem najpierw ArrayList i ją potem dopiero konwertowałem do stream.
         * Istnieje możliwość stworzenia stream bezpośrednio.
         * Na początu piszę sekwencję, jak robiłem to przy poprzednich zadaniach (bez metody map())
         */
        /*Stream.of("Wiktoria", "Adam", "Robert", "Aleksa", "Arab").filter(name -> name.endsWith("a")).
                forEach(name -> System.out.println(name.toUpperCase()));*/
        /**
         * Z wykorzystaniem metody map(), która modyfikuje mi wartości ze streama
         */
        /*Stream.of("Wiktoria", "Adam", "Robert", "Aleksa", "Arab").filter(name -> name.endsWith("a")).map(name -> name.toUpperCase()).
                forEach(name -> System.out.println(name));*/

        // ad 2.
        /**
         * Z wykorzystaniem metody sorted(), która stanowi terminal operation, jak wykorzystywany wcześniej np. count()
         */
        /*Stream.of("Wiktoria", "Robert", "Aleksa", "Arab", "Adam").filter(name -> name.startsWith("A")).map(name -> name.toLowerCase()).
                sorted().forEach(name -> System.out.println(name));*/

        // ad 3.

        List<String> drinks = Arrays.asList("Beer", "Water", "Wine", "Coke", "Juice");
        List<String> foods = Arrays.asList("Sandwich", "Pizza", "Kebab", "Apple", "Chocolate");
        // 51:00
    }
}
