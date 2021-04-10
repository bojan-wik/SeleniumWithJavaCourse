package Chapter5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class chromebrowser {
    //static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\87\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "http://automationpractice.com";
        driver.get(url);

        //driver.findElement(By.linkText("Specials")).click();

        WebElement singinNavbarOption = driver.findElement(By.className("login"));
        singinNavbarOption.click();

        // test - various elements with the same className
        /*WebElement unknownBox = driver.findElement(By.className("is_required"));
        unknownBox.sendKeys("mic check");*/

        // test - entering className with more than one class
        /*WebElement unknownBox = driver.findElement(By.className("is_required validate account_input form-control"));
        unknownBox.sendKeys("mic check");*/

        WebElement emailBox = driver.findElement(By.id("email"));
        emailBox.sendKeys("wiktor.bojanowski@contractors.roche.com");

        WebElement passwordBox = driver.findElement(By.name("passwd"));
        passwordBox.sendKeys("password");

        WebElement signinButton = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]"));
        signinButton.click();

        //driver.quit();
    }
}
