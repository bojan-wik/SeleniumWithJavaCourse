package Chapter10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MouseHoverAction {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\89\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        String url = "https://www.amazon.com/";
        driver.get(url);
        driver.manage().window().maximize();

        WebElement signInDropdown = driver.findElement(By.id("nav-link-accountList"));
        /**
         * Aby wykonać jakieś akcje muszę najpierw stworzyć obiekt klasy 'Actions'.
         */
        Actions action = new Actions(driver);
        /**
         * Następnie wykorzystuję konkretną metodę, jako argument podaję WebElement na którym akcja ma być wykonana,
         * potem jak chain akcji jest gotowy muszę jeszcze dodać metody build() a następnie perform().
         */
        action.moveToElement(signInDropdown).contextClick().build().perform();
    }
}
