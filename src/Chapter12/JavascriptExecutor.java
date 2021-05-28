package Chapter12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Z Javascript executorem miałem już styczność w Chapter12 -> FramesDragAndDrop.java
 */
public class JavascriptExecutor {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\90\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Actions action = new Actions(driver);

        String url = "https://ksrtc.in/";
        driver.get(url);
        driver.manage().window().maximize();

        WebElement leavingFromInputField = driver.findElement(By.id("fromPlaceName"));
        leavingFromInputField.sendKeys("BENG");
        leavingFromInputField.sendKeys(Keys.DOWN);
        leavingFromInputField.sendKeys(Keys.DOWN);
        System.out.println(leavingFromInputField.getText());

        //driver.quit();
    }
}
