package VariousTopics.DuckDuckGoSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class MainTest {

    private static String url = "https://duckduckgo.com/";
    private static String searchedPhrase = "giant panda";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\105\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.get(url);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(searchedPhrase);

        WebElement searchButton = driver.findElement(By.className("searchbox_searchButton__F5Bwq"));
        searchButton.click();

        wait.until(ExpectedConditions.titleContains(searchedPhrase));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-testid='result-title-a']")));
        List<WebElement> linkNames = driver.findElements(By.cssSelector("a[data-testid='result-title-a'] > span"));
        for (WebElement linkName : linkNames) {
//            System.out.println(linkName.getText());
//            System.out.println(linkName.getText().toLowerCase().contains(searchedPhrase));
            Assert.assertTrue(linkName.getText().toLowerCase().contains(searchedPhrase));
        }

        driver.quit();
    }
}
