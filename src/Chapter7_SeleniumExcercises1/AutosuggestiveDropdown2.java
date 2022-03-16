package Chapter7_SeleniumExcercises1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutosuggestiveDropdown2 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\89\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://www.makemytrip.com/";
        String searchedCityFrom = "Mumbai";
        String searchedCityTo = "New York";
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(1000);

        WebElement countryInputField = driver.findElement(By.id("fromCity"));
        //countryInputField.clear();
        Thread.sleep(1000);
        countryInputField.sendKeys(searchedCityFrom.toLowerCase().substring(0, 3));
        Thread.sleep(2000);
        countryInputField.sendKeys(Keys.ARROW_DOWN);
        countryInputField.sendKeys(Keys.ENTER);

        Thread.sleep(2000);
    }
}
