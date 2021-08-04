package Chapter18_TestNG;

import org.testng.annotations.Test;

/**
 * Możliwe jest też dobieranie test casów za pomocą Regex -> 'd_testng.xml'
 */
public class d_Regex {

    @Test
    public void WebLogin() { System.out.println("Test case: web login"); }

    @Test
    public void MobileLogin() {
        System.out.println("Test case: mobile login");
    }

    @Test
    public void APILogin() {
        System.out.println("Test case: api login");
    }

    @Test
    public void WebPost() { System.out.println("Test case: web post"); }

    @Test
    public void MobilePost() {
        System.out.println("Test case: mobile post");
    }

    @Test
    public void APIPost() {
        System.out.println("Test case: api post");
    }

    @Test
    public void WebLogout() { System.out.println("Test case: web logout"); }

    @Test
    public void MobileLogout() {
        System.out.println("Test case: mobile logout");
    }

    @Test
    public void APILogout() {
        System.out.println("Test case: api logout");
    }
}
