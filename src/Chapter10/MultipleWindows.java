package Chapter10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
/**
 * Zadanie: Otworzyć stronę (parent window), z poziomu tej strony kliknąć w link, który otworzy nową stronę
 * w nowym tabie/oknie (child window) i wyprintować title nowej strony.
 */
public class MultipleWindows {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\89\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        String url = "https://rahulshettyacademy.com/seleniumPractise/#/";
        driver.get(url);
        driver.manage().window().maximize();
        System.out.printf("Parent window title:\n%s\n", driver.getTitle()).println();

        WebElement topDealsLink = driver.findElement(By.xpath("//a[@href='https://rahulshettyacademy.com/dropdownsPractise/']"));
        topDealsLink.click();
        /**
         * Aby móc przełączyć się na child window muszę rozpoznać ID poszczególnych okien i umieścić je w kolekcji typu Set
         */
        Set<String> windowIDs = driver.getWindowHandles();
        //System.out.println(windowIDs);
        /**
         * Aby móc iterować po kolekcji typu Set muszę skorzystać z metody Iterator. Przybliżona struktura takiej kolekcji to:
         *
         *       begin
         * |---------------|
         * | parent id     |
         * |_______________|
         * | child id      |
         * |_______________|
         * |               |
         * |_______________|
         *
         * metodą next() schodzę od begin w dół kolekcji
         */
        Iterator<String> windowIDsIterator = windowIDs.iterator();
        String parentWindowID = windowIDsIterator.next();
        String childWindowID = windowIDsIterator.next();
        /**
         * Przechodzę na child window. Od tej pory wszystkie następne akcje będą wykonywane na tym oknie, a nie na głównym.
         */
        driver.switchTo().window(childWindowID);
        System.out.printf("Child window title:\n%s\n", driver.getTitle()).println();

        //driver.quit();
    }
}
