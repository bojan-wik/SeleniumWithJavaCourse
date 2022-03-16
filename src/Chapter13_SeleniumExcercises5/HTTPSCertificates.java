package Chapter13_SeleniumExcercises5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

/**
 * Zadanie: wejść na stronę bez certyfikatu SSL (http) i zaakceptować ten brak certyfikatu, tak aby przejść do właściwej strony,
 * żeby móc kontynuować testy.
 */
public class HTTPSCertificates {

    public static void main(String[] args) {

        /**
         * Muszę dodać konkretne capabilities do przeglądarki Chrome.
         * Najpier tworzę instancję klasy DesiredCapabilities, która dzięki metodzie chrome() pozwoli mi  customizować przeglądarke Chrome.
         * Potem na tym obiekcie wywoułuję metode acceptInsecureCerts(), która stanowi capability, o które chcę 'wzbogacić' Chrome
         */
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        // pierwszy sposób
        desiredCapabilities.acceptInsecureCerts();
        // drugi sposób
        //desiredCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        /**
         * Tworzę instancję klasy ChromeOptions (która pozwala na tworzenie lokalnych ustawień dla Chrome)
         * i potem za pomocą metody merge() 'domergowuję' wcześniej zdefiniowane capabilities -
         * żeby Chrome akceptował insecure certs
         */
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(desiredCapabilities);
        /**
         * Potem po staremu definuję co zawsze, z tą różnicą, że przy tworzeniu instancj klasy WebDriver, w metodzie ChromeDriver() jako parametr
         * podaję obiekt klasy ChromeOptions (moje lokalne ustawienia dla Chrome)
         */
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\91\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        /**
         * W tym momencie mój Chrome bez problemu otwiera mi też strony http, więc nie jestem w stanie przetestować, jak działa to rozwiązanie
         */
        String url = "http://www.webscantest.com/";
        driver.get(url);
        driver.manage().window().maximize();

        //driver.quit();

    }
}
