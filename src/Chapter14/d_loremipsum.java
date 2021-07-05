package Chapter14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Quest:
 * write script to validate that whatever is provided into the searchbox is the same what is given in the search result
 */
public class d_loremipsum {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\91\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        String searchedProduct = "Rice";

        WebElement searchBox = driver.findElement(By.id("search-field"));
        searchBox.sendKeys(searchedProduct);

        List<WebElement> productListAfterSearching = driver.findElements(By.xpath("//tbody/tr/td[1]"));
        // 5:45
        List<String> searchedProductInListString = productListAfterSearching.stream().
                filter(product -> product.getText().contains(searchedProduct))
                .map(product -> product.getText()).collect(Collectors.toList());

        System.out.println(searchedProductInListString.contains(searchedProduct));

        //driver.quit();
    }
}
