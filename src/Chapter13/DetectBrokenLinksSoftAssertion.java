package Chapter13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Zadanie: wejść na stronkę i w jej foterze sprawdzić, które linki są "zepsute" - prowadzą do niestniejących stron.
 */
public class DetectBrokenLinksSoftAssertion {

    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\91\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        SoftAssert softAssert = new SoftAssert();

         /**Rozwiązanie z kursu (ale z moją pętlą for-loop):
         * 1) get all URLs tied up to the links, Selenium - getAttribute()
         * 2) use Java methods to call the URLs and get their status codes (pewnie coś a la bashowy curl -I)
         * 3) if status code > 400 then URL is not working -> link is broken
         */
        WebElement footer = driver.findElement(By.id("gf-BIG"));
        List<WebElement> footerLinks = footer.findElements(By.tagName("a"));

        for (int i = 0; i < footerLinks.size(); i += 1) {
            String linkText = footerLinks.get(i).getText();
            String linkURL = footerLinks.get(i).getAttribute("href");
            //System.out.printf("%s %s", linkText, linkURL).println();
            URL url = new URL(linkURL);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("HEAD");
            urlConnection.connect();
            int linkResponseCode = urlConnection.getResponseCode();
            /**
             * Tu mamy do czynienia z tzw. hard assertion. Minusem tego rozwiązania jest to, że w momencie natrafienia na
             * broken link test się wysypuje i nie sprawdza kolejnych linków.
             */
            //Assert.assertTrue(linkResponseCode < 400, "The link with text '" + linkText + "' is broken with code " + linkResponseCode + " .");
            /**
             * Rozwiązanie: muszę skorzystać z tzw. soft assertion, który nie będzie wywalał testu. SoftAssert w momencie natrafienia na test, który failuje,
             * zamiast wywalać cały skrypt, będzie storował w pamięci te zfailowane przypadki, ale skrypt będzie mógł kontynuować pracę.
             */
            softAssert.assertTrue(linkResponseCode < 400, "The link with text '" + linkText + "' is broken with code " + linkResponseCode + ".");
        }
        /**
         * Metoda assertAll() ewauluje wszystkie wykonane wcześniej soft assertions i jeżeli, któryś był na fail to dopiero tutaj
         * będzie wywalało cały skrypt
         */
        softAssert.assertAll();

        driver.quit();
    }
}
