package Chapter11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Calendar2 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\90\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        String url = "https://www.path2usa.com/travel-companions";
        driver.get(url);
        driver.manage().window().maximize();

        WebElement cookiePopupAcceptButton = driver.findElement(By.id("ez-accept-all"));
        cookiePopupAcceptButton.click();

        WebElement travelDatePicker = driver.findElement(By.id("travel_date"));
        travelDatePicker.click();

        Integer searchedDay = 13;
        /**
         * W kursie użyte jest szukanie po classname=day, ale moim zdaniem jest to błędne rozwiązanie, ponieważ wtedy zwraca nam wszystkie dni, nawet te niedostępne (np. przeszłe),
         * co w niektórych przypadkach generuje błędy.
         */
        //List<WebElement> availableDays = driver.findElements(By.className("day"));
        /**
         * Napisałem własny xpath z wykorzystaniem OR condition, który zwraca mi dokładnie te dni, które potrzebuję, żeby skrypt działał poprawnie.
         * Hint w: https://sqa.stackexchange.com/questions/22621/or-conditions-in-xpath
         */
        List<WebElement> availableDays = driver.findElements(By.xpath("//td[@class='active day' or @class='day']"));
        for (int i = 0; i < availableDays.size(); i += 1) {
            WebElement availableDay = availableDays.get(i);
            if (availableDay.getText().equals(searchedDay.toString())) {
                System.out.println(availableDay.getText());
                availableDay.click();
                /**
                 * W tym przypadku trzeba zastosować break. Kalendarz na stronie działa w ten sposób, że po kliknięciu w daną datę, kalendarz się zamyka.
                 * Bez break, pętla idzie dalej, starając się kliknąć w element, który nie jest już obecny w DOM strony, przez to, że kalendarz jest już zamknięty.
                 */
                break;
            }
        }

        //driver.quit();
    }
}
