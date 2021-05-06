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
         *
         * (Robiłem to już wcześniej w FramesDragAndDrop.java, gdzie liczyłem liczbę iframe na stronie)
         */
        int linksCountEntirePage = driver.findElements(By.tagName("a")).size();
        System.out.println(linksCountEntirePage);

        /**
         * Print the links count but only in the footer section.
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
         * Print the links count but only in the footer section and only in its 1st column
         *
         * Moje pierwotne rozwiązanie - połączyłem dwa poprzednie rozwiązania: zawężyłem scope wyszukiwania tylko do sekcji footer i dodatkowo
         * napisałem xpath w relacji parent-child
         */
        //int linksCountFooter1stColumn = footerSection.findElements(By.xpath("//td[1]//a")).size();
        /**
         * Rozwiązanie z kursu - ponowne stworzenie kolejnego webelementu dla danej subsekcji, czyli pierwszej kolumny footera
         * (po xpath absolutnym i musi być aż do node ul bo do td nie działa) i potem szukanie po tagname=a już dla tej subsekcji
         */
        WebElement footerSection1stColumn = footerSection.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int linksCountFooter1stColumn = footerSection1stColumn.findElements(By.tagName("a")).size();

        System.out.println(linksCountFooter1stColumn);

        driver.quit();
    }
}
