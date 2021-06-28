package Chapter14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Algorithm:
 * 1) go to webpage, sort the column alphabetically
 * 2) capture all webelements into list (webelements list)
 * 3) capture text of all webelements into list (ArrayList, original)
 * 4) sort on the original list and store the result in new list (ArrayList, sorted)
 * 5) compare both lists (original vs. stored)
 */
public class WebTableSorting {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\91\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        // ad 1
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        WebElement productColumnHeader = driver.findElement(By.xpath("//tr/th[1]"));
        productColumnHeader.click();
        // ad 2 & 3
        List<WebElement> productsList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
        ArrayList<String> productsListAsString = new ArrayList<>();
        for (int i = 0; i < productsList.size(); i += 1) {
            String productAsString = productsList.get(i).getText();
            productsListAsString.add(productAsString);
        }
        //System.out.println(productsListAsString);
        // ad 4

        driver.quit();
    }
}