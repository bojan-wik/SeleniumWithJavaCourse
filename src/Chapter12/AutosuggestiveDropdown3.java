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
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Actions action = new Actions(driver);

        String url = "https://www.makemytrip.com/";
        driver.get(url);
        driver.manage().window().maximize();

        String searchedFromCity = "mumbai";
        String searchedToCity = "deline";

        /**
         * Problem:
         * podczas otwierania strony czasem wyskakuje LoginPopup, a czasem nie. Kiedy wyskakuje - muszę go najpierw odkliknąć.
         * Kiedy go nie ma - mogę kontynuować wykonywanie skrypt. Próbowałem zrobić if-else z metodą isDisplayed(), albo sprawdzić, czy element
         * jest != null, ale to nie działało, bo gdy popup nie wyskakiwał to wywalało mi exception, że takiego elementu nie można zlokalizować.
         * Rozwiązanie:
         * Gdy popup wyskakuje - wrzucam go do listy i sprawdzam, czy lista ma więcej elementów niż 0.
         * Hint: https://intellipaat.com/community/27181/selenium-check-if-element-exists-test-if-element-is-present-using-selenium-webdriver
         */
        //Boolean isLoginPopupPresent = driver.findElement(By.xpath("//div[contains(@class, 'autopop')]")) != null;
        //Boolean isLoginPopupPresent = driver.findElement(By.xpath("//div[contains(@class, 'autopop')]")).isDisplayed();
        Boolean isLoginPopupPresent = driver.findElements(By.xpath("//div[contains(@class, 'autopop')]")).size() > 0;
        if (isLoginPopupPresent) {
            System.out.println("popup present");
            driver.findElement(By.xpath("//li[@data-cy='account']")).click();

        } else {
            System.out.println("popup not present");
        }

        WebElement fromCity = driver.findElement(By.id("fromCity"));
        fromCity.click();
        WebElement fromCitySearchbox = driver.findElement(By.xpath("//div[@role='combobox']//input[@type='text']"));
        /**
         * Z użyciem metodfd sendKeys()
         */
        /*fromCitySearchbox.sendKeys(searchedFromCity);
        fromCitySearchbox.sendKeys(Keys.ARROW_DOWN);
        fromCitySearchbox.sendKeys(Keys.ENTER);*/
        /**
         * Z użyciem klasy Actions
         */
        action.moveToElement(fromCity).click().build().perform();
        action.moveToElement(fromCitySearchbox).sendKeys(searchedFromCity).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).
                build().perform();

        //driver.quit();
    }
}
