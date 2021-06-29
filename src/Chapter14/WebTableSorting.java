package Chapter14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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

        // ad 2
        List<WebElement> productList = driver.findElements(By.xpath("//tbody/tr/td[1]"));

        // ad 3
        /*ArrayList<String> originalProductList = new ArrayList<>();
        for (int i = 0; i < productList.size(); i += 1) {
            String productAsString = productList.get(i).getText();
            originalProductList.add(productAsString);
        }
        System.out.println(originalProductList);*/
        /**
         * Punkt 3 zrobiłem pierwotnie za pomocą for-loop, ale okazuje się, że to samo można osiągnąć dzięki java-streams
         * i metodzie map()
         */
        List<String> originalProductList = productList.stream().map(product -> product.getText()).collect(Collectors.toList());

        // ad 4
        List<String> sortedProductList = originalProductList.stream().sorted().collect(Collectors.toList());

        // ad 5
        Assert.assertEquals(originalProductList, sortedProductList);
        System.out.println(originalProductList);
        System.out.println(sortedProductList);

        driver.quit();
    }
}