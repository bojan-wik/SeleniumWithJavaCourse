package Chapter12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class AutosuggestiveDropdown3 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\90\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Actions action = new Actions(driver);

        String url = "https://www.makemytrip.com/";
        driver.get(url);
        driver.manage().window().maximize();

        String searchedFromCity = "mumbai";
        String searchedToCity = "deline";

        /*WebElement loginPopup = driver.findElement(By.xpath("//div[contains(@class, 'autopop')]"));
        System.out.println(loginPopup.isDisplayed());*/

        /**
         * Muszę znaleźć jakiś sposób na randomowo wyskakujący popup - raz wyskakuje, innym razem nie
         * hint: https://intellipaat.com/community/6010/how-to-check-if-an-element-is-visible-with-webdriver
         */
        if (driver.findElement(By.xpath("//div[contains(@class, 'autopop')]")) != null) {
            System.out.println("present");
        } else {
            System.out.println("no present");
        }

        WebElement fromCity = driver.findElement(By.id("fromCity"));
        fromCity.click();
        WebElement fromCitySearchbox = driver.findElement(By.xpath("//div[@role='combobox']//input[@type='text']"));
        /**
         * sendKeys() method
         */
        fromCitySearchbox.sendKeys(searchedFromCity);
        fromCitySearchbox.sendKeys(Keys.ARROW_DOWN);
        fromCitySearchbox.sendKeys(Keys.ENTER);
        /**
         * Actions class
         */
        /*action.moveToElement(fromCity).click().build().perform();
        action.moveToElement(fromCitySearchbox).sendKeys(searchedFromCity).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).
                build().perform();*/

        //driver.quit();
    }
}
