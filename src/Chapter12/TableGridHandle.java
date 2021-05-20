package Chapter12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TableGridHandle {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\90\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        String url = "https://www.cricbuzz.com/live-cricket-scorecard/33213/mdx-vs-ham-group-2-county-championship-2021";
        driver.get(url);
        driver.manage().window().maximize();

        /**
         * Wyodrębniam jako WebElement pierwszą tabelę, potem w obrębie tej tabeli wyodrębniam jej 3cią kolumnę w której są wyniki, które chcę wylistować,
         * a potem zsumować i sprawdzić, czy wynik sumy na stronie jest poprawny.
         */
        //WebElement table1 = driver.findElement(By.xpath("//*[@id='innings_1']/div[1]"));
        WebElement table1 = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
        List<WebElement> table1column3 = table1.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)"));
        /**
         * Iteruję po elementach z 3ciej kolumny, wpisuję i < (table1column3.size()) - 2 bo nie chcę ostatnich dwóch elementów z tej kolumny,
         * do ostatnich dwóch elementów muszę się dostać osobno.
         */
        int table1ResultsCount = 0;
        for (int i = 0; i < (table1column3.size()) - 2; i += 1) {
            String result = table1column3.get(i).getText();
            System.out.println(result);
            table1ResultsCount += Integer.parseInt(result);
        }
        /**
         * Wartość z wiersza Extras wyciągam za pomocą xpath, gdzie szukam diva z tekstem 'Extras' i potem przechodzę do jego pierwszego sibilinga
         */
        String table1ExtrasValue = driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
        System.out.println(table1ExtrasValue);
        table1ResultsCount += Integer.parseInt(table1ExtrasValue);
        System.out.println(table1ResultsCount);

        String table1TotalValue = driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
        System.out.println(table1TotalValue);

        //Assert

        //List<WebElement> table1rows = table1.findElements(By.cssSelector("cb-col cb-col-100 cb-scrd-itms"));

        //div[@id='innings_1']//div[contains(@class, 'cb-scrd-itms')]//div[contains(@class, 'text-bold')]
        //div[contains(@class, 'cb-scrd-itms')]

        driver.quit();
    }
}
