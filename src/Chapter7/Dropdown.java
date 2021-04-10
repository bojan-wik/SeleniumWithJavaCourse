package Chapter7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\88\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://www.techlistic.com/p/selenium-practice-form.html";
        driver.get(url);

        Select continentsDropdown = new Select(driver.findElement(By.id("continents")));
        //continentsDropdown.selectByIndex(1);
        continentsDropdown.selectByVisibleText("Africa");

        //driver.quit();
    }
}
