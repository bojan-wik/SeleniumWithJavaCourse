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
 * Find the given product and print its price. In this case the given product IS NOT on the first page.
 */
public class c_PaginationAutomating_DoWhileLoop {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\91\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        String searchedProduct = "Cheese";

        /**
         * W tym scenariuszu najbardziej pasuje zastosowanie do-while-loop, która najpierw wykonuje kod niezależnie, czy postawiony warunek jest true, czy false
         * i dopiero po wykonaniu kodu sprawdza warunek i w zależności od wyniku, albo pętla jest kontynuowana, albo nie.
         * Czyli: wchodzę na stronę, najpierw sprawdzam, czy szukany produkt jest na pierwszej stronie i jeśli jest to wychodzę z pętli,
         * jeśli nie ma, to kilkam next, szukam na drugiej stronie, czy produkt tam jest itd.
         */
        List<String> searchedProductPriceList;
        do {
            List<WebElement> productList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
            searchedProductPriceList = productList.stream().filter(productWebelem -> productWebelem.getText().equals(searchedProduct))
                    .map(searchedProductWebelem -> getProductPrice(searchedProductWebelem)).collect(Collectors.toList());
            if (searchedProductPriceList.size() > 0) {
                searchedProductPriceList.forEach(price -> System.out.printf("Price of %s: %s", searchedProduct, price).println());
            } else {
                WebElement nextButton = driver.findElement(By.xpath("//a[@aria-label='Next']"));
                nextButton.click();
            }
        }
        while (!(searchedProductPriceList.size() > 0));

        driver.quit();
    }

    private static String getProductPrice(WebElement product) {
        String priceValue = product.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }
}
