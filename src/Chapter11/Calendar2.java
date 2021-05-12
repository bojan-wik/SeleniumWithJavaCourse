package Chapter11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Calendar2 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\90\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        String url = "https://www.path2usa.com/travel-companions";
        driver.get(url);
        driver.manage().window().maximize();

        WebElement cookiePopupAcceptButton = driver.findElement(By.id("ez-accept-all"));
        cookiePopupAcceptButton.click();

        WebElement travelDatePicker = driver.findElement(By.id("travel_date"));
        travelDatePicker.click();

        // May 14
        int day = 14;

        List<WebElement> availableDays = driver.findElements(By.className("day"));
        //List<WebElement> availableDays = driver.findElements(By.xpath("//td[@class='day']"));
        for (int i = 0; i < availableDays.size(); i += 1) {
            System.out.println(availableDays.get(i).getText());
        }

        //driver.quit();
    }
}
