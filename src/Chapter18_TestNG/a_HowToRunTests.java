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

}
