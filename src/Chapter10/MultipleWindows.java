package Chapter10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MultipleWindows {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\89\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        String url = "https://rahulshettyacademy.com/seleniumPractise/#/";
        driver.get(url);
        driver.manage().window().maximize();

        //System.out.printf("Parent window title:\n%s", driver.getTitle()).println();

        WebElement topDealsLink = driver.findElement(By.xpath("//a[@href='https://rahulshettyacademy.com/dropdownsPractise/']"));
        topDealsLink.click();

        //System.out.printf("\nChild window title:\n%s", driver.getTitle()).println();

        Set<String> windowIDs = driver.getWindowHandles();
        System.out.println(windowIDs);

        driver.quit();
    }
}
