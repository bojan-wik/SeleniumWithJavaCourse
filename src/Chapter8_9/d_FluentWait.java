package Chapter8_9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Na podanej stronie text 'Hello world' pojawia się dopiero po jakimś czasie.
 * Zadanie: wyprintować text. Mogę to zrobić za pomocą explicit wait na dwa sposoby:
 *  a) tak jak wcześniej, za pomocą WebDriverWait
 *  b) za pomocą FluentWait
 */
public class d_FluentWait {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\93\\chromedriver.exe");
        /**
         * W tym momencie tworzymy obiekt ('driver') klasy ChromeDriver, która z kolei implementuje interfejs WebDriver.
         * Tak samo jest w przypadku WebDriverWait i FluentWait - oba są klasami, które implementują interfejs Wait.
         */
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']/button"));
        startButton.click();

        String helloWorldTextLocator = "//div[@id='finish']/h4";
        WebElement helloWorldElem = driver.findElement(By.xpath(helloWorldTextLocator));

        /**
         * a) WebDriverWait, czyli sposób, który poznałem już na poprzedniej lekcji.
         * Tworzę obiekt ('explicitWait') klasy WebDriverWait, która z kolei implementuje interfejs Wait
         * Jednocześnie możliwe jest stworzeniu obiektu w bardziej znany mi sposób (z pominięciem interfejsu:
         * WebDriverWait explicitWait = new WebDriverWait(driver, 6);
         */
        /*Wait explicitWait = new WebDriverWait(driver, 6);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(helloWorldTextLocator)));*/

        /**
         * b) FluentWait, tworzę obiekt tak samo jak wyżej
         * i tutaj też można stworzyć obiekt na dwa sposoby, drugi:
         * FluentWait fluentWait = new FluentWait(driver)...
         */
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).
                withTimeout(Duration.ofSeconds(6)).
                pollingEvery(Duration.ofSeconds(2)).
                ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(helloWorldTextLocator)));
        /**
         * W kursie gościu mówi, że klasa FluentWait nie ma metody until() i że trzeba pisać swoje własne metody.
         * Mi metoda until() zadziałała - dokładnie tak samo, jak w przypadku klasy WebDriverWait, więc to pewnie kwestia
         * nieaktualnego kursu.
         */

        Assert.assertTrue(helloWorldElem.isDisplayed());
        System.out.println(helloWorldElem.getText());

        driver.quit();
    }
}
