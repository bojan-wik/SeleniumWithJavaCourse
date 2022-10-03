package VariousTopics.SeleniumZadanie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * zadanie: na stronie http://automationpractice.com/
 * dodać produkt do kosza, przejść do kosza i odczytać cenę (bez waluty) - napisać na to lokator
 */

public class Zadanie extends Selectors {

    String section_popular_xpath = "//ul[@id='homefeatured']";
    String section_bestsellers_xpath = "//ul[@id='blockbestsellers']";

    //ul[@id='homefeatured']/a[@title='Faded Short Sleeve T-shirts']


    String product = "Faded Short Sleeve T-shirts";
    String btn_addToCart_xpath = "//a[@title='Add to cart']";
    //a[@title='Faded Short Sleeve T-shirts']

    //ul[@id='homefeatured']/span[contains(text(), 'Add to cart')]

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\103\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        Actions actions = new Actions(driver);

        // na stronie http://automationpractice.com/
        String url = "http://automationpractice.com/index.php";
        driver.get(url);
        driver.manage().window().maximize();
        // dodać produkt do kosza
        WebElement productContainer = driver.findElement(By.xpath("//div[@class='product-container'][1]"));
        WebElement addToCartButton = driver.findElement(By.xpath("//span[contains(text(), 'Add to cart')][1]"));
        actions.moveToElement(productContainer).build().perform();
        addToCartButton.click();
        // przejść do kosza
        WebElement closeButton = driver.findElement(By.xpath("//span[@title='Close window']"));
        WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//a[@title='Proceed to checkout']"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton)).click();
        // i odczytać cenę (bez waluty) - napisać na to lokator
        WebElement totalPrice = driver.findElement(By.xpath("//span[@id='total_price']"));
        System.out.println(totalPrice.getText().replaceAll("\\$", ""));

//        addProductToCart("Faded Short Sleeve T-shirts");
//        goToCart();
//        readPriceWithoutCurrency();

        tearDownTest(driver);
    }

    public static void setUpTest(WebDriver driver) {

    }

    public static void addProductToCart(String product) {
        //tbd
    }

    public static void goToCart() {
        //tbd
    }

    public static void readPriceWithoutCurrency() {
        // tbd
        // return int price
    }

    public static void tearDownTest(WebDriver driver) {
        driver.quit();
    }
}
