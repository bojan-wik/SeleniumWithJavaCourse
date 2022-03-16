package Chapter7_SeleniumExcercises1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * JavaScript alerts, jak sama nazwa wskazuje, są wywoływane przez JavaScript, przez co nie należą do kodu HTML strony.
 * Nie da się do nich odnieść, jak do elementów z kodu HTML i Selenium defaultowo nie jest sobie w stanie z takimi alertami poradzić.
 * Służy do tego osobny, dedykowany mechanizm.
 */
public class JavaScriptAlertsHandling {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\93\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        String name = "Ferdynand";
        WebElement nameInput = driver.findElement(By.id("name"));
        nameInput.sendKeys(name);
        WebElement alertButton = driver.findElement(By.id("alertbtn"));
        alertButton.click();
        /**
         * Na tym etapie mam wywołany alert. Teraz, aby móc się do niego dostać muszę przestawić kontekst drivera z przeglądarki na alerty.
         * Zrobię to za pomocą metody switchTo().
         * Nie wiem, czy z tej metody nie korzystałem już wcześniej do przełączania się pomiędzy tabami/oknami przelądarki.
         */
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        Assert.assertTrue(alertText.contains(name));
        driver.switchTo().alert().accept();
        /**
         * Jak pokazuje przykład powyżej - nie jestem w stanie raz przestawić drivera na alerty i potem działać tylko na alertach.
         * Muszę za każdym razem pisać całe driver.switchTo().alert()...
         *
         * W kolejnym przykładzie alerta mogę poza kliknięciem OK także kliknąć w Cancel.
         * Aby to zrobić, muszę skorzystać z metody dismiss()
         */
        nameInput.sendKeys(name);
        WebElement confirmButton = driver.findElement(By.id("confirmbtn"));
        confirmButton.click();
        alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        Assert.assertTrue(alertText.contains(name));
        driver.switchTo().alert().dismiss();

        driver.quit();
    }
}
