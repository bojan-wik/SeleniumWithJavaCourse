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
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']/button"));
        startButton.click();

        String helloWorldTextLocator = "//div[@id='finish']/h4";
        WebElement helloWorldElem = driver.findElement(By.xpath(helloWorldTextLocator));

        /**
         * a) WebDriverWait, czyli sposób, który poznałem już na poprzedniej lekcji
         */
        /*WebDriverWait explicitWait = new WebDriverWait(driver, 6);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(helloWorldTextLocator)));*/

        /**
         * b) FluentWait
         */
        Wait fluentWait = new FluentWait(driver).
                withTimeout(Duration.ofSeconds(6)).
                pollingEvery(Duration.ofSeconds(2)).
                ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(helloWorldTextLocator)));

        Assert.assertTrue(helloWorldElem.isDisplayed());
        System.out.println(helloWorldElem.getText());

        //driver.quit();
    }
}
