package Chapter11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
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
         * 1) Print the links count in the entire page.
         *
         * (Robiłem to już wcześniej w FramesDragAndDrop.java, gdzie liczyłem liczbę iframe na stronie)
         */
        int linksCountEntirePage = driver.findElements(By.tagName("a")).size();
        System.out.println(linksCountEntirePage);

        /**
         * 2) Print the links count but only in the footer section.
         *
         * Moje pierwotne rozwiązanie - zliczanie po xpath elementów a, które mają konkretnego parenta,
         * hint znaleiony w https://html-agility-pack.net/knowledge-base/44156166/xpath-select-all-children-with-specific-parent-node-by-attribute
         */
        //int linksCountFooter = driver.findElements(By.xpath("//div[@id='gf-BIG']//a")).size();
        /**
         * Rozwiązanie z kursu - tworzę webelement dla sekcji footer i potem zawężam wyszukiwanie elementów a tylko do tej sekcji,
         * ja już w sumie wcześniej gdzieś wpadłem na to rozwiązanie - chyba przy dodawaniu produktów do koszyka
         */
        WebElement footerSection = driver.findElement(By.id("gf-BIG"));
        int linksCountFooter = footerSection.findElements(By.tagName("a")).size();
        System.out.println(linksCountFooter);

        /**
         * 3) Print the links count but only in the footer section and only in its 1st column
         *
         * Moje pierwotne rozwiązanie - połączyłem dwa poprzednie rozwiązania: zawężyłem scope wyszukiwania tylko do sekcji footer i dodatkowo
         * napisałem xpath w relacji parent-child
         * (hint w https://www.tutorialspoint.com/how-to-select-specified-node-within-xpath-node-sets-by-index-with-selenium)
         */
        //int linksCountFooter1stColumn = footerSection.findElements(By.xpath("//td[1]//a")).size();
        /**
         * Rozwiązanie z kursu - ponowne stworzenie kolejnego webelementu dla danej subsekcji, czyli pierwszej kolumny footera
         * (po xpath absolutnym i musi być aż do node ul bo do td nie działa) i potem szukanie po tagname=a już dla tej subsekcji
         */
        WebElement footerSection1stColumn = footerSection.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int linksCountFooter1stColumn = footerSection1stColumn.findElements(By.tagName("a")).size();

        System.out.println(linksCountFooter1stColumn);

        /**
         * 4) Click on each link in the 1st column and check if the pages are opening
         *
         * Moje rozwiązanie - najpierw tworzę listę linków a potem iteruję po tej liście, klikając w każdy link.
         * Co iterację robię chain action, dzięki czemu jestem w stanie otworzyć każdy link w nowym tabie
         */
        Actions action = new Actions(driver);

        List<WebElement> linksListFooter1stColumn = footerSection1stColumn.findElements(By.tagName("a"));
        for (int i = 1; i < linksListFooter1stColumn.size(); i += 1) {
            //System.out.println(linksListFooter1stColumn.get(i).getText());
            action.moveToElement(linksListFooter1stColumn.get(i)).keyDown(Keys.LEFT_CONTROL).click().build().perform();
        }

        //driver.quit();
    }
}
