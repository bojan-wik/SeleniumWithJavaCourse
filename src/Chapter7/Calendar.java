package Chapter7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\89\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://www.spicejet.com/";
        driver.get(url);
        Thread.sleep(1000);
        /**
         * Maksymalizuję ekran przeglądarki, bo jak przeczytałem, jest to dobra praktyka - bez maksymalizacji część
         * elementów na stronie może się źle wyświetlać i być niedostępna
         */
        driver.manage().window().maximize();
        Thread.sleep(1000);

        /**
         * patrz rozwiązania z DynamicDropdown.java
         */

        WebElement departDatePicker = driver.findElement(By.id("ctl00_mainContent_view_date1"));
        departDatePicker.click();
        Thread.sleep(1000);
        /**
         * Ustawiam żeby skrypt wybierał zawsze datę dzisiejszą - nie jest ustawione na sztywno, tylko identyfikuje
         * konkretny element, który ma class = 'ui-state-active', który akurat na tej stronie odróznia datę dzisiejszą
         * od pozostałych
         */
        departDatePicker.findElement(By.xpath("//a[contains(@class, 'ui-state-active')]")).click();
        /**
         * Tu data ustawiona na sztywno
         */
        //departDatePicker.findElement(By.xpath("(//a[text()='12'])[1]")).click();


        /*WebElement returnDatePicker = driver.findElement(By.id("ctl00_mainContent_view_date2"));
        returnDatePicker.click();
        Thread.sleep(1000);
        //returnDatePicker.findElement(By.xpath("(//a[text()='26'])[1]")).click();//działa
        driver.findElement(By.xpath("(//a[text()='2'])[3]")).click();*/
    }
}
