package Chapter8_9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class AddProductsToCart {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\89\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://rahulshettyacademy.com/seleniumPractise/#/";
        driver.get(url);
        Thread.sleep(1000);
        driver.manage().window().maximize();

        String[] searchedProducts = {"Musk Melon", "Brocolli", "Cucumber"};
        addProducts(driver, searchedProducts);

        WebElement basketIcon = driver.findElement(By.xpath("//img[@alt='Cart']"));
        basketIcon.click();
        WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']"));
        proceedToCheckoutButton.click();
        Thread.sleep(5000);
        WebElement promoCodeInput = driver.findElement(By.xpath("//input[@class='promoCode']"));
        promoCodeInput.sendKeys("rahulshettyacademy");
        WebElement applyButton = driver.findElement(By.xpath("//button[@class='promoBtn']"));
        applyButton.click();
    }

    public static void addProducts(WebDriver driver, String[] searchedProducts) {

        /**
         * Konwertuję arraya ze stringami do List, dzięki temu mogę wykorzystać metodę contains,
         * generalnie powinienem zrobić tą konwersję dopiero w for-loop a nie tutaj - oszczędność pamięci
         */
        List<String> searchedProductsList = Arrays.asList(searchedProducts);
        System.out.printf("Products to be added to the cart: %s\n", searchedProductsList).println();
        List<WebElement> productsList = driver.findElements(By.xpath("//h4[@class='product-name']"));

        int numOfProductsToBeAddedToCart = searchedProducts.length;
        for (int i = 0; i < productsList.size(); i += 1) {
            String productName = productsList.get(i).getText(); // nazwa produktu, którą otrzymuje ze strony np. "Brocolli - 1 Kg"
            productName = productName.split(" -")[0]; // nazwa produktu, którą potrzebuje np. "Brocolli"
            if (searchedProductsList.contains(productName)) {
                System.out.printf("Adding product to the cart: %s", productName).println();
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                numOfProductsToBeAddedToCart -= 1;
                System.out.printf("Number of remaining products to be added: %d\n", numOfProductsToBeAddedToCart).println();
                if (numOfProductsToBeAddedToCart == 0) {
                    break;
                }
            }
        }
    }
}

