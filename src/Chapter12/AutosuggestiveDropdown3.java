package Chapter12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AutosuggestiveDropdown3 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\90\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        String url = "https://www.makemytrip.com/";
        driver.get(url);
        driver.manage().window().maximize();

        String searchedFromCity = "mumbai";
        String searchedToCity = "deline";

        WebElement fromCity = driver.findElement(By.id("fromCity"));
        fromCity.click();
        fromCity.sendKeys(searchedFromCity);

        //driver.quit();
    }
}
