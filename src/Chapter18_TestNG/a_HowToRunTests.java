package Chapter18_TestNG;

import org.testng.annotations.Test;

public class a_HowToRunTests {

    /**
     * Gdy w kodzie obecna jest ta metoda - 'public static void main' - znaczy to, że test/skrypt będzie wykonywany poprzez Java Compiler.
     * Bez tej metody nie jest możliwe skompilowanie i uruchomienie żadnego programu napisanego w Java.
     * TestNG sam w sobie może działać jako Java Compiler - dzięki temu nie potrzebuję tej metody, żeby uruchomić testy.
     */
    /*public static void main(String[] args) {
        System.out.println("Hello world");
    }*/

    /**
     * Aby móc odpalać poszczególne testy, muszę je zawrzeć w jakiejś funkcji (np. 'TestNG_Demo()')
     * i oznaczyć ją specjalną adnotacją - '@Test' (widziałem to już podczas nauki o Java Streams)
     */
    @Test
    public void TestNG_Demo() {
        System.out.println("Hello world");
    }

    /**
     * Każda funkcja przed którą jest adnotacja '@Test' jest traktowana jako osobny test case.
     */
    @Test
    public void SecondTestCase() {
        System.out.println("This is a 2nd test case.");
    }

    /**
     * Ostatecznie, mogę tworzyć wiele test caseów w jednej tylko klasie.
     * Istnieje też rozwiązanie, gdzie wszystkie te test casy mogę odpalić za pomocą pliku .xml. Żeby móc generować takie pliki automatycznie
     * musiałem ściągnąć plugin 'Create TestNG xml', potem klikam prawym na projekt/package/class i wybieram 'Create TestNG XML'
     */
}
