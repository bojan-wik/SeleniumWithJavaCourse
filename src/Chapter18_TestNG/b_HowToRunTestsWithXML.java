package Chapter18_TestNG;

import org.testng.annotations.Test;

public class b_HowToRunTestsWithXML {

    /**
     * Ostatecznie, mogę tworzyć wiele test caseów w jednej tylko klasie.
     * Istnieje też rozwiązanie, gdzie wszystkie te test casy mogę odpalić za pomocą pliku .xml. Żeby móc generować takie pliki automatycznie
     * musiałem ściągnąć plugin 'Create TestNG xml', potem klikam prawym na projekt/package/class i wybieram 'Create TestNG XML'
     */

    @Test
    public void ThirdTestCase() {
        System.out.println("This is a 3rd test case.");
    }

    @Test
    public void FourthTestCase() {
        System.out.println("This is a 4th test case.");
    }

    /**
     * Normalnie, aby wykonać testy zawarte w plikach 'a_HowToRunTests.java' i 'b_HowToRunTestsWithXML.java' musiałbym klikać prawym klikiem
     * na każdym pliku osobno i je odpalać.
     * Dzięki plikowi 'testng.xml' mogę zdefiniować dokładnie jakie testy chcę mieć odpalone, potem robię prawym klikiem
     * i odpalam tylko ten jeden plik xml i wszystkie zdefiniowane tam testy są odpalane.
     */
}
