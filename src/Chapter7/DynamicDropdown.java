package Chapter7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\88\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://www.spicejet.com/";
        driver.get(url);

        /**
         * To scenario będzie miało faila, ponieważ skrypt będzie chciał kliknąć pierwszy napotkany od góry element z @value='MAA',
         * a trzeba kliknąć na drugi z kolei element.
         */
        /*// from Bengaluru
        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        // to Chennai
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@value='MAA'])")).click();*/

        /**
         * To scenario zadziała, ponieważ skrypt kliknie w drugi z kolei element z @value='MAA',
         * dzięki wskazaniu po indeksie: //a[@value='MAA'])[2]
         */
        /*// from Bengaluru
        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        // to Chennai
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();*/

        /**
         * To scenario też zadziała, mimo braku wskazywania po indeksie.
         * Xpath locator został napisany w oparciu o relację parent-children.
         */
        /*// from Bengaluru
        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]")).click();
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR']//a[@value='BLR']")).click();
        // to Chennai
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();*/

        /**
         * inny sposób - sam wykminiłem
         */
        // from Bengalore
        WebElement fromDropdown = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]"));
        fromDropdown.click();
        fromDropdown.findElement(By.xpath("//a[@value='BLR']")).click();
        // to Chennai
        WebElement toDropdown = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_destinationStation1_CTXT\"]"));
        toDropdown.findElement(By.xpath("//a[@value='MAA']")).click();
    }
}
