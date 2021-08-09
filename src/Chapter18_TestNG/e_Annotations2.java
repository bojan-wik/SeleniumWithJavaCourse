package Chapter18_TestNG;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class e_Annotations2 {

    @Test
    public void testCase4() {
        System.out.println("test folder 2: test case 4");
    }

    /**
     * BeforeTest adnotacja sprawia, że dany test case jest uruchamiany przed jakimikolwiek innymi, jako pierwszy,
     * w obrębie danego test folderu (<test></test>)
     * Przydatne np. w przypadkach, kiedy przed właściwymi testami muszę wykonać jakieś operacje na środowisku testownym
     * np. wyczyszczenie bazy danych z efektów poprzednich testów itd.
     */
    @BeforeTest
    public void testCase5() {
        System.out.println("test folder 2: test case 5");
    }

    /**
     * Inna przydatna adnotacja to BeforeSuite. W pliku testng.xml node <suite></suite> jest najwyżej, nie ma nic nad nim.
     * Więc test case z adnotacją BeforeSuite będzie wykonywany bezwzględnie jako pierwszy, niezależnie od tego w jakim test folderze
     * się znajduje.
     * Analogicznie adnotacja AfterSuite będzie powodowała, że dany test case będzie wykonywany bezwzględnie jako ostatni.
     */
    @BeforeSuite
    public void testCase6() {
        System.out.println("test folder 2: test case 6");
    }
}
