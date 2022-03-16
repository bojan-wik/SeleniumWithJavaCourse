package Chapter13_SeleniumExcercises5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Zadanie: wejść na stronkę i w jej foterze sprawdzić, które linki są "zepsute" - prowadzą do niestniejących stron.
 */
public class DetectBrokenLinks {

    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\91\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        /**
         * Moje rozwiązanie: planuję (jak w przypadku Chapter11 -> PrintLinksCount.java) otworzyć każdy link w nowym tabie, przejść na tego taba,
         * sprawdzić, czy metoda getTitle() zwraca stringa, który zawiera w sobie "404", czy nie.
         */
        WebElement footer = driver.findElement(By.id("gf-BIG"));
        List<WebElement> footerLinks = footer.findElements(By.tagName("a"));
        //System.out.println(footerLinks.size());
        /*for (int i = 0; i < footerLinks.size(); i += 1) {
            //System.out.println(footerLinks.get(i).getText());
            footerLinks.get(i).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
        }

        String parentWindowID = driver.getWindowHandle();
        Set<String> windowIDs = driver.getWindowHandles();
        Iterator<String> windowIDsIterator = windowIDs.iterator();
        while (windowIDsIterator.hasNext()) {
            String childWindowID = windowIDsIterator.next();
            if (!parentWindowID.equals(childWindowID)) {
                driver.switchTo().window(childWindowID);
                String childWindowTitle = driver.getTitle();
                //System.out.println(childWindowTitle);
                if (childWindowTitle.contains("404")) {
                    System.out.println(childWindowTitle);
                    System.out.println(driver.getCurrentUrl());
                }
            }
        }*/
        /**
         * Minusem tego rozwiązania jest to, że jest wolne i zajmuje relatywnie dużo mocy obliczeniowej.
         */

         /**Rozwiązanie z kursu:
         * 1) get all URLs tied up to the links, Selenium - getAttribute()
         * 2) use Java methods to call the URLs and get their status codes (pewnie coś a la bashowy curl -I)
         * 3) if status code > 400 then URL is not working -> link is broken
         */

        /**
         * 2) na przykładzie pojedyńczego linka
         * Wykorzystuję Java klasę HttpUrlConnection, aby móc wykonywać HTTP requesty na konkretnych URL.
         * Tworzę String z adresem, potem tworzę obiekt klasy URL, któremu jako paramentr podaję adres w postaci Stringa
         */
        String linkURL = "https://rahulshettyacademy.com/brokenlink";
        URL url = new URL(linkURL);
        /**
         * Tworzę obiekt klasy HttpURLConnection, gdzie castuję obiekt klasy URL na HttpURLConnection i otwieram połączenie.
         * To jest dopiero obiekt połączenia, ale samo połączenie w tym momencie nie jest jeszcze zainicjalizowane
         */
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
        /**
         * Jako parametr setRequestMethod() mogę podać jedną z wartości: GET, POST, HEAD, OPTIONS, PUT, DELETE, TRACE.
         * Ustawiam potrzebny mi parametr, inicjalizuję połączenie i zczytuję response code.
         */
        urlConnection.setRequestMethod("HEAD");
        urlConnection.connect();
        System.out.println(urlConnection.getResponseCode());

        driver.quit();
    }
}
