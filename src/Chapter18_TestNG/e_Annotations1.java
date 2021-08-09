package Chapter18_TestNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class e_Annotations1 {

    /**
     * Analogicznie do BeforeTest - adnotacja AfterTest powoduje, że dany test case będzie wykonywany na samym końcu
     * w obrębie danego test folderu (<test></test>).
     * Przydatne np. kiedy chcemy po wykonaniu testów usunąć dane testowe, wyczyścić cookies itd.
     */
    @AfterTest
    public void testCase1() {
        System.out.println("test folder 1: test case 1");
    }

    @AfterSuite
    public void testCase2() {
        System.out.println("test folder 1: test case 2");
    }

    @Test
    public void testCase3() {
        System.out.println("test folder 1: test case 3");
    }
}
