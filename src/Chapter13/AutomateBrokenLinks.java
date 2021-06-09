package Chapter13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Zadanie: wejść na stronkę i w jej foterze sprawdzić, które linki są "zepsute" - prowadzą do niestniejących stron.
 */
public class AutomateBrokenLinks {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\91\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        /**
         * Moje rozwiązanie: planuję (jak w przypadku Chapter11 -> PrintLinksCount.java) otworzyć każdy link w nowym tabie, przejść na tego taba,
         * sprawdzić, czy metoda getTitle() zwraca stringa, który zawiera w sobie "404", czy nie.
         */
        WebElement footer = driver.findElement(By.id("gf-BIG"));
        List<WebElement> footerLinks = footer.findElements(By.tagName("a"));
        //System.out.println(footerLinks.size());
        /*for (int i = 0; i < footerLinks.size(); i += 1) {
            //System.out.println(footerLinks.get(i).getText());
            footerLinks.get(i).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
        }

        String parentWindowID = driver.getWindowHandle();
        Set<String> windowIDs = driver.getWindowHandles();
        Iterator<String> windowIDsIterator = windowIDs.iterator();
        while (windowIDsIterator.hasNext()) {
            String childWindowID = windowIDsIterator.next();
            if (!parentWindowID.equals(childWindowID)) {
                driver.switchTo().window(childWindowID);
                String childWindowTitle = driver.getTitle();
                //System.out.println(childWindowTitle);
                if (childWindowTitle.contains("404")) {
                    System.out.println(childWindowTitle);
                    System.out.println(driver.getCurrentUrl());
                }
            }
        }*/
        /**
         * Minusem tego rozwiązania jest to, że jest wolne i zajmuje relatywnie dużo mocy obliczeniowej.
         */

         /**Rozwiązanie z kursu:
         * 1) get all URLs tied up to the links, Selenium - getAttribute()
         * 2) use Java methods to call the URLs and get their status codes (pewnie coś a la bashowy curl -I)
         * 3) if status code > 400 then URL is not working -> link is broken
         */
        for (int i = 0; i < footerLinks.size(); i += 1) {
            String linkText = footerLinks.get(i).getText();
            String linkURL = footerLinks.get(i).getAttribute("href");
            System.out.printf("%s %s", linkText, linkURL).println();
        }

        driver.quit();
    }
}
