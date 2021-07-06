package Chapter14_JavaStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Quest:
 * Find the given product and print its price. In this case the given product IS on the first page.
 */
public class b_CustomMethodBuilding {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\91\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        String searchedProduct = "Mango";

        List<WebElement> productList = driver.findElements(By.xpath("//tbody/tr/td[1]"));

        /**
         * productList.stream() - na tym etapie mam streama ze wszystkimi webelementami
         * .filter(productWebElem -> productWebElem.getText().equals(searchedProduct)) - na tym etapie mam streama z tylko jednym webelementem poszukiwanego produktu
         * .map(searchedProductString -> getProductPrice(searchedProductString)) - na tym etapie mapuję z wykorzystaniem custom metody, którą będę dopiero tworzył niżej
         */
        List<String> searchedProductPriceList = productList.stream().filter(productWebelem -> productWebelem.getText().equals(searchedProduct))
                .map(searchedProductWebelem -> getProductPrice(searchedProductWebelem)).collect(Collectors.toList());
        searchedProductPriceList.forEach(price -> System.out.println(price));

        driver.quit();
    }

    /**
     * Tworzę customową metodę, którą wykorzystuję wyżej, która ma zwrócić cenę poszukiwanego produktu,
     * wykorzystany jest tutaj koncept relacji sibiling dla xpath (pominąłem wcześniej tą lekcję),
     * pełny xpath dla znalezienia cen to '//tbody/tr/td[1]/following-sibling::td[1]',
     * w tej metodzie inputem (WebElement product) jest webelement poszukiwanego produktu, więc wystarczy zawęzić wyszukiwanie do tego webelementu
     * i wtedy otrzymujemy cenę tego konkretnego produktu szukając już tylko po xpath 'following-sibling::td[1]'
     */
    private static String getProductPrice(WebElement product) {
        String priceValue = product.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }
}
