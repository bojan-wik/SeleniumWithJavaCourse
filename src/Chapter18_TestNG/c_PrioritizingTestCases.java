package Chapter18_TestNG;

import org.testng.annotations.Test;

/**
 * Załóżmy, że mamy 3 moduły logowania: API login, web login, mobile login
 * Do każdego z nich musimy napisać test case
 */
public class c_PrioritizingTestCases {

    @Test
    public void WebLogin() {
        System.out.println("Test case: web login");
    }

    @Test
    public void MobileLogin() {
        System.out.println("Test case: mobile login");
    }

    @Test
    public void APILogin() {
        System.out.println("Test case: api login");
    }

    /**
     * Za pomocą pliku xml mogę dowolnie dobierać test casy, grupować je w test suity
     * i nadawać im kolejność do wykonania -> 'c_testng.xml'
     */
}
