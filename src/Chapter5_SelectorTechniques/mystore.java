package Chapter5_SelectorTechniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class mystore {
    //static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\87\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "http://automationpractice.com";
        driver.get(url);

        // find element by full xpath
        //WebElement searchBox = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/input[4]"));
        // find element by short xpath
        //WebElement searchBox = driver.findElement(By.xpath("//input[@id=\"search_query_top\"]"));
        // find element by CSS selector
        //WebElement searchBox = driver.findElement(By.cssSelector("input[id='search_query_top']"));
        WebElement searchBox = driver.findElement(By.cssSelector("input#search_query_top"));
        searchBox.sendKeys("test5");

        //driver.quit();
    }
}
