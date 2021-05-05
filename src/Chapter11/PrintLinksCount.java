package Chapter11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PrintLinksCount {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\90\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        String url = "https://www.rahulshettyacademy.com/AutomationPractice/";
        driver.get(url);
        driver.manage().window().maximize();
        /**
         * Print the links count in the entire page.
         * (Robiłem to już wcześniej w FramesDragAndDrop.java, gdzie liczyłem liczbę iframe na stronie)
         */
        int linksCountEntirePage = driver.findElements(By.tagName("a")).size();
        System.out.println(linksCountEntirePage);
        /**
         * Print the links count but only in the footer section.
         * Moje pierwotne rozwiązanie - zliczanie po xpath elementów a, które mają konkretnego parenta,
         * hint znaleiony w https://html-agility-pack.net/knowledge-base/44156166/xpath-select-all-children-with-specific-parent-node-by-attribute
         */
        //int linksCountFooter = driver.findElements(By.xpath("//div[@id='gf-BIG']//a")).size();
        /**
         * Rozwiązanie z kursu - tworzę osobnego drivera tylko dla footera i potem zawężam wyszukiwanie elementów a tylko do tej subsekcji,
         * ja już w sumie wcześniej gdzieś wpadłem na to rozwiązanie - chyba przy dodawaniu produktów do koszyka
         */
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        int linksCountFooter = footerDriver.findElements(By.tagName("a")).size();
        System.out.println(linksCountFooter);

        driver.quit();
    }
}
