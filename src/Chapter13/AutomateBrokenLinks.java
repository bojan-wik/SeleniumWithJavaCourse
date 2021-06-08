package Chapter13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Zadanie: wejść na stronkę i w jej foterze sprawdzić, które linki są "zepsute" - prowadzą do niestniejących stron.
 * Rozwiązanie: planuję (jak w przypadku Chapter11 -> PrintLinksCount.java) otworzyć każdy link w nowym tabie, przejść na tego taba,
 * sprawdzić, czy metoda getTitle() zwraca stringa, który zawiera w sobie "404", czy nie.
 */
public class AutomateBrokenLinks {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\91\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement footer = driver.findElement(By.id("gf-BIG"));
        List<WebElement> footerLinks = footer.findElements(By.tagName("a"));
        //System.out.println(footerLinks.size());
        for (int i = 0; i < footerLinks.size(); i += 1) {
            //System.out.println(footerLinks.get(i).getText());
            footerLinks.get(i).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
        }

        String parentWindowID = driver.getWindowHandle();
        Set<String> windowIDs = driver.getWindowHandles();
        Iterator<String> windowIDsIterator = windowIDs.iterator();

        //System.out.println(driver.getTitle().contains("404"));

        driver.quit();
    }
}
