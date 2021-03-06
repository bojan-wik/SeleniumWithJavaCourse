package Chapter12_SeleniumExcercises4;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Zadanie: Wpisz w wyszukiwarkę słowo jakąś nazwe miasta i zweryfikuj, czy w podpowiadanych opcjach pojawia się słowo "airport"
 * Tips: Z Javascript executorem miałem już styczność w Chapter12 -> FramesDragAndDrop.java
 */
public class JavascriptExecutor_Intro {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\91\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Actions action = new Actions(driver);

        String url = "https://ksrtc.in/";
        driver.get(url);
        driver.manage().window().maximize();

        String searchedCity = "kempegowda";
        String searchedWord = "airport";
        WebElement leavingFromInputField = driver.findElement(By.id("fromPlaceName"));
        leavingFromInputField.sendKeys(searchedCity);
        leavingFromInputField.sendKeys(Keys.UP);
        Thread.sleep(1000);
        System.out.println(leavingFromInputField.getText());
        /**
         * Problem: chcę otrzymać tekst, który w kodzie figuruje jako hidden text. Selenium nie jest w stanie identyfikować hidden elements,
         * przez co metoda getText() nic nie zwraca.
         * Rozwiązanie: muszę odwołać sie do Javascript DOM za pomocą Javascript Executora i jako parametr 'script' używam metody napisanej  w javascript,
         * działanie skryptu wcześniej weryfikuję w konsoli przeglądarki - czy zwraca mi właściwy element
         */
        JavascriptExecutor jsExec = (JavascriptExecutor)driver;
        String jsScript = "return document.getElementById(\"fromPlaceName\").value;";
        /*String cityNameReceived = (String) jsExec.executeScript(jsScript);
        System.out.println(cityNameReceived);*/
        /**
         * Przechodzę do właściwego zadania (moje rozwiązanie). Tworzę while-loop i opieram się na JavascriptExecutor.
         * Innym rozwiązaniem byłoby stworzenie Webelement listy złożonej z opcji, które wyświetlają się jako proponowane w dropdown i przeiterowanie po tej
         * liście pętlą for-loop.
         */
        String cityNameReceived = "";
        while (!cityNameReceived.equals(searchedCity)) {
            leavingFromInputField.sendKeys(Keys.DOWN);
            Thread.sleep(1000);
            cityNameReceived = (String) jsExec.executeScript(jsScript);
            if (cityNameReceived.contains(searchedWord.toUpperCase())) {
                System.out.println(cityNameReceived);
            }
        }

        driver.quit();
    }
}
