package Chapter5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class saucedemo {
    //static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\88\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "http://www.saucedemo.com";
        driver.get(url);

        // css selector - syntax 1
        //WebElement usernameField = driver.findElement(By.cssSelector("#user-name"));
        // css selector - syntax 2
        //WebElement usernameField = driver.findElement(By.cssSelector("input[id='user-name']"));
        // css selector - regex
        WebElement usernameField = driver.findElement(By.cssSelector("input[id*='-name']"));
        usernameField.sendKeys("uszanowanko3");

        // xpath - syntax
        //WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        // xpath - regex contain
        WebElement passwordField = driver.findElement(By.xpath("//input[contains(@id, 'passw')]"));
        // xpath - regex endswith
        //WebElement passwordField = driver.findElement(By.xpath("//input[ends-with(@id, 'sword')]"));
        passwordField.sendKeys("a");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement incorrerctLoginErrorMsg =
                driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/h3"));
        System.out.println(incorrerctLoginErrorMsg.getText());

        //driver.quit();
    }
}