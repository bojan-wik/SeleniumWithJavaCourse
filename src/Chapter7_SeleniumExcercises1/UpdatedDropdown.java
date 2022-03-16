package Chapter7_SeleniumExcercises1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\88\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://www.ryanair.com";
        driver.get(url);

        Thread.sleep(1000);

        WebElement cookieAcceptButton = driver.findElement(By.xpath("//*[@id=\"cookie-popup-with-overlay\"]/div/div[3]/button[2]"));
        cookieAcceptButton.click();

        WebElement toDropdown = driver.findElement(By.xpath("//*[@id=\"input-button__destination\"]"));
        toDropdown.click();
        Thread.sleep(1000);
        toDropdown.findElement(By.xpath("//span[text()=' Alicante ']")).click();
        Thread.sleep(1000);

        WebElement passengersNumDropdown = driver.findElement(
                By.xpath("/html/body/hp-app-root/hp-home-container/hp-home/hp-search-widget-container/hp-search-widget/div/hp-flight-search-widget-container/fsw-flight-search-widget-container/fsw-flight-search-widget/div/fsw-flight-search-widget-controls-container/fsw-flight-search-widget-controls/div[2]/fsw-input-button/div/div[2]"));
        passengersNumDropdown.click();
        Thread.sleep(1000);

        WebElement adultsCounterPlusButton = driver.findElement(
                By.xpath("//*[@id=\"ry-tooltip-6\"]/div[2]/hp-app-controls-tooltips/fsw-controls-tooltips-container/fsw-controls-tooltips/fsw-passengers-container/fsw-passengers/fsw-passengers-picker-container/fsw-passengers-picker/ry-counter[1]/div[2]/div[3]"));
        Integer adultsAddedCounter = 1;
        Integer adultsDesiredNum = 7;

        /**
         * Adding adults with while loop
         */
        while (adultsAddedCounter < adultsDesiredNum) {
            adultsCounterPlusButton.click();
            adultsAddedCounter += 1;
        }

        /**
         * Same thing executed with for loop
         */
        /*for (int i = adultsAddedCounter; i < adultsDesiredNum; i += 1) {
            adultsCounterPlusButton.click();
        }*/

        String adultsAddedNum = driver.findElement(
                By.xpath("//*[@id=\"ry-tooltip-6\"]/div[2]/hp-app-controls-tooltips/fsw-controls-tooltips-container/fsw-controls-tooltips/fsw-passengers-container/fsw-passengers/fsw-passengers-picker-container/fsw-passengers-picker/ry-counter[1]/div[2]/div[2]")).getText();
        System.out.printf("The selected number of adults is: %s", adultsAddedNum).println();
        Assert.assertEquals(adultsAddedNum, adultsDesiredNum.toString());
        System.out.printf("Does the selected number of adults match the desired number of adults?: %b", adultsAddedNum.contentEquals(adultsDesiredNum.toString()));

        Thread.sleep(1000);
        WebElement gotoweButton = driver.findElement(By.xpath("//button[text()=' Gotowe ']"));
        //gotoweButton.click();
    }
}
