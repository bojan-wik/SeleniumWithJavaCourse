package Chapter7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutosuggestiveDropdown {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\88\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://rahulshettyacademy.com/dropdownsPractise/";
        String searchedCountry = "India";
        driver.get(url);

        Thread.sleep(1000);

        WebElement countryInputField = driver.findElement(By.id("autosuggest"));
        countryInputField.sendKeys(searchedCountry.toLowerCase().substring(0, 2));

        Thread.sleep(2000);

        /**
         * Sposób, który sam wykminiłem. Teoretycznie lepszy, bo krótszy, ale nie mogę zastosować szukania po zmiennej,
         * muszę wpisać szukany tekst na sztywno.
         */
        /*WebElement countryDropdown = driver.findElement(By.cssSelector("li[class='ui-menu-item'] a"));
        countryDropdown.findElement(By.xpath("//a[text()='Poland']")).click();*/

        List<WebElement> countriesAvailable = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for(WebElement country : countriesAvailable) {
            if (country.getText().equalsIgnoreCase(searchedCountry)) {
                country.click();
                break;
            }
        }

    }
}