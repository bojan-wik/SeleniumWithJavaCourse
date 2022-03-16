package Chapter8_9_SeleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class AddProductsToCart_beforeRefactor {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\89\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://rahulshettyacademy.com/seleniumPractise/#/";
        driver.get(url);
        Thread.sleep(1000);
        driver.manage().window().maximize();

        String searchedProduct1 = "Cucumber";
        String[] searchedProducts = {"Musk Melon", "Brocolli", "Cucumber"};
        /**
         * Konwertuję arraya ze stringami do List, dzięki temu mogę wykorzystać metodę contains,
         * generalnie powinienem zrobić tą konwersję dopiero w for-loop a nie tutaj - oszczędność pamięci
         */
        List<String> searchedProductsList = Arrays.asList(searchedProducts);
        System.out.printf("Products to be added to the cart: %s\n", searchedProductsList).println();
        List<WebElement> productsList = driver.findElements(By.xpath("//h4[@class='product-name']"));

        /**
         * Z początku wybrałem takiego for-loop, ale ostatecznie lepszym rozwiązaniem jest Iterowanie za pomocą for-i-loop jak niżej.
         * tutaj nie mogę po elemencie List<WebElement> iterować wg. indeksu jak po arrayu, muszę wykorzystać metodę getindex
         */

        /*for (WebElement product : productsList) {
            //System.out.println(product.getText());
            if (product.getText().contains(searchedProduct)) {
                System.out.println(product.getText());
                driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
                break;
            }
        }*/
        /**
         * Iterowanie za pomocą for-i-loop, mogę tu z pomocą zmiennej 'i' dojść do właściwego buttona 'add to cart'
         */
        /*for (int i = 0; i < productsNum; i += 1) {
            String productName = productsList.get(i).getText();
            if (productName.contains(searchedProduct1)) {
                System.out.println(productsList.get(i).getText());
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                //break;
            }
        }*/
        /**
         * Iterowanie za pomocą for-i-loop, ale z szukaniem więcej niż jednego produktu
         */
        int numOfProductsToBeAddedToCart = searchedProducts.length;
        for (int i = 0; i < productsList.size(); i += 1) {
            String productName = productsList.get(i).getText(); // nazwa produktu, którą otrzymuje ze strony np. "Brocolli - 1 Kg"
            productName = productName.split(" -")[0]; // nazwa produktu, którą potrzebuje np. "Brocolli"
            if (searchedProductsList.contains(productName)) {
                System.out.printf("Adding product to the cart: %s", productName).println();
                //driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                /**
                 * Po kliknięciu w button 'add to cart' jego tekst zmienia się na ok. 5 sek. na 'added'. Skrypt zaczyna
                 * wtedy iterować po indeksie=0 od następnego elementu z tekstem 'add to cart', dlatego klika w niewłaściwy
                 * produkt. Workaroundem byłoby odczekanie 5 sek. po dodaniu produktu, aż tekst buttona wróci do oryginalnej postaci.
                 *
                 * Ale generalnie poleganie na tekście, który się zmienia jako locatorze jest złą praktyką i powinno się
                 * utworzyć inny xpath locator, jak niżej.
                 */
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                numOfProductsToBeAddedToCart -= 1;
                System.out.printf("Number of remaining products to be added: %d\n", numOfProductsToBeAddedToCart).println();
                if (numOfProductsToBeAddedToCart == 0) {
                    break;
                }
                //Thread.sleep(5000);
            }
        }
    }
}

