package Chapter14_JavaStreams;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Zadanka:
 * I. Print names which end with 'a' with uppercase
 * II. Print names which start with 'a' with lowercase and sorted
 * III. Merge two arrayLists
 * IV. Check whether certain values are in the list
 * V. Store the results of stream operations in some list
 * VI. Print unique and sorted values from the list
 */
public class JavaStreams2 {

    @Test
    public void streamMap() {

        // ad I.
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

        // ad II.
        /**
         * Z wykorzystaniem metody sorted(), która stanowi terminal operation, jak wykorzystywany wcześniej np. count()
         */
        /*Stream.of("Wiktoria", "Robert", "Aleksa", "Arab", "Adam").filter(name -> name.startsWith("A")).map(name -> name.toLowerCase()).
                sorted().forEach(name -> System.out.println(name));*/

        // ad III.
        List<String> drinks = Arrays.asList("Beer", "Water", "Wine", "Coke", "Juice");
        List<String> foods = Arrays.asList("Sandwich", "Pizza", "Kebab", "Apple", "Chocolate");
        /**
         * Z wykorzystaniem metody concat()
         */
        Stream<String> streamOfConcatenatedLists = Stream.concat(drinks.stream(), foods.stream());
        //streamOfConcatenatedLists.sorted().forEach(list -> System.out.println(list));

        // ad IV.
        /**
         * filter() zwraca rzeczy, których szukam, jako stringi, a mi zależy na otrzymaniu booleana true albo false
         */
        //streamOfConcatenatedLists.filter(i -> i.equals("Beer")).forEach(i -> System.out.println(i));
        /**
         * Do tego muszę wykorzystać metodę anyMatch()
         */
        boolean isBeerInTheList = streamOfConcatenatedLists.anyMatch(i -> i.equalsIgnoreCase("Beer"));
        Assert.assertTrue(isBeerInTheList);
    }

    @Test
    public void streamCollect() {

        List<String> drinks = Arrays.asList("Beer", "Water", "Wine", "Coke", "Juice");
        System.out.println(drinks);
        //drinks.stream().filter(drink -> drink.startsWith("W")).forEach(drink -> System.out.println(drink));

        // ad V.
        /**
         * Z wykorzystaniem metody collect(), która kolekconuje rezultaty wcześniejszych intermediate operations i je zapisuje
         */
        List<String> listOfDrinksStartingWithW = drinks.stream().filter(drink -> drink.startsWith("W")).collect(Collectors.toList());
        System.out.println(listOfDrinksStartingWithW);

        // ad VI.
        List<Integer> listOfNumbers = Arrays.asList(3, 2, 2, 7, 5, 1, 9, 7);
        List<Integer> listOfUniqueAndSortedNumbers = listOfNumbers.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(listOfUniqueAndSortedNumbers);
    }
}
