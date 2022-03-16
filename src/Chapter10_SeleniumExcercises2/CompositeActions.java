package Chapter10_SeleniumExcercises2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;
/**
 * Zadanie: za pomocą akcji wpisać w searchbox słowo 'HELLO' tak jakby zrobił to user.
 */
public class CompositeActions {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\89\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String url = "https://www.amazon.com/";
        driver.get(url);
        driver.manage().window().maximize();

        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        // dotychczas poznany sposób
        // searchbox.sendKeys("HELLO");
        Actions action = new Actions(driver);
        /**
         * Wygląda na to, że nie da się emulować działania konkretnie przycisku CAPSLOCK - trzeba najpierw zasymulować
         * wciśnięcie SHIFT i potem pisanie z wciśniętym jednocześnie SHIFT
         */
        action.moveToElement(searchbox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();

        //driver.quit();
    }
}
