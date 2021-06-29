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
 * Find and print price of the rice
 */
public class New {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\91\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        String searchedProduct = "Rice";

        List<WebElement> productList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
        List<String> ll = productList.stream().map(product -> product.getText()).
                filter(product -> product.equals(searchedProduct)).collect(Collectors.toList());
        System.out.println(ll);

        // 2:32

        driver.quit();
    }
}
