package Chapter10;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class FramesDragAndDrop {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\90\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        String url = "https://jqueryui.com/droppable/";
        driver.get(url);
        driver.manage().window().maximize();

        /**
         * Definuję sobie jakiś przykładowy element, który znajduje się w main frame strony, żeby potem po nim walidować,
         * czy jestem w main frame, czy poza
         */
        //System.out.println(driver.findElements(By.className("entry-title")).size() == 1);
        Assert.assertTrue(driver.findElements(By.className("entry-title")).size() == 1);
        /**
         * Frame - part of a web page/browser window which displays content independent of its container,
         * with the ability to load content independently.
         * Dlatego też muszę użyć metody switchTo() i przestawić się na konretnego iframe, żeby móc znaleźć element z id=droppable
         * - tak samo jak przy przełączaniu się po różnych tabach/oknach przeglądarki w MultipleWindows.java
         * Tutaj przełączam się za pomocą webelement
         */
        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        /**
         * Nie jestem w stanie przełączyć się za pomocą id/name ponieważ iframe na tej stronie nie ma tych atrybutów.
         * Tutaj przełączam się za pomocą indeksu - wg. kolejności w DOMie. Zliczam sobie wcześniej ilość elementów iframe
         * na stronie i potem przełączam się na pierwszy element - indeksowanie od zera
         */
        int iframeCount = driver.findElements(By.tagName("iframe")).size();
        Assert.assertTrue(iframeCount > 0);
        System.out.printf("Number of iframe elements on the page: %d\n", iframeCount);
        driver.switchTo().frame(0);
        /**
         * Waliduję sobie, czy element z main frame już nie jest widoczny - rozwiązanie z https://stackoverflow.com/a/13647226
         */
        Assert.assertFalse(driver.findElements(By.className("entry-title")).size() == 1);

        WebElement dragMeElem = driver.findElement(By.id("draggable"));
        //System.out.println(dragMeElem.isDisplayed());
        Assert.assertTrue(dragMeElem.isDisplayed());
        WebElement dropHereElem = driver.findElement(By.id("droppable"));
        //System.out.println(dropHereElem.isDisplayed());
        Assert.assertTrue(dropHereElem.isDisplayed());
        Assert.assertEquals(dropHereElem.getText(), "Drop here");

        Actions action = new Actions(driver);
        /**
         * Żeby móc wykonywać operacje na elementach dragMeElem i dropHereElem muszę przeskrolować przeglądarkę, aż te elementy
         * będą w pełni widoczne w oknie - w tzw. viewport (user's visible area of a web page) - inaczej wywala mi exception
         * MoveTargetOutOfBound. Rozwiązanie z JavaScriptExecutor znalezione w necie (https://stackoverflow.com/a/20487332)
         */
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dragMeElem);
        /**
         * Jak już wcześniej robiłem - buduję action chain:
         * moveToElement() - ustawia kursor myszki na środek elementu dragMeElem
         * dragAndDrop - robi drag and drop z source do target
         */
        action.moveToElement(dragMeElem).dragAndDrop(dragMeElem, dropHereElem).build().perform();
        Assert.assertEquals(dropHereElem.getText(), "Dropped!");
        /**
         * Wracam z powrotem do main frame
         */
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.findElements(By.className("entry-title")).size() == 1);

        driver.quit();
    }
}
