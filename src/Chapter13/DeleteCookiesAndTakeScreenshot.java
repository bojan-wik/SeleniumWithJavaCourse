package Chapter13;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * Jest problem z zaimportowaniem tej klasy - nie importuje automatycznie. Wchodzę ręczenie na https://commons.apache.org/proper/commons-io/
 * pobieram najnowszą, stabilną wersję biblioteki Commons IO i ręcznie dodaję pliki jar do projektu.
 */
//import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class DeleteCookiesAndTakeScreenshot {

    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\95\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //driver.manage().deleteCookieNamed("NID");
        driver.get("https://google.com");

        /**
         * Aby móc zrobić screenshot muszę skonwertować mój obiekt WebDriver (driver) na obiekt screenshot. W tym celu muszę użyć koncepcji
         * castowania obiektów. Tutaj castuję obiekt WebDriver (driver) na obiekt, który może robić screenshoty (TakesScreenshot).
         * Screenshot przechowuję w obiekcie klasy File (screenshotFile)
         */
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        System.out.println(screenshotFile.exists());
        /**
         * Aby zapisać fizyczny plik na lokalnym dysku muszę skorzystać z klasy FileUtils. Podaję źródło pliku (obiekt klasy File - screenshotFile)
         * i jego destynację (adres na dysku lokalnym)
         */
        //FileUtils.copyFile(screenshotFile, new File("C:\\Users\\bojanoww\\Downloads\\screenshot1.png"));

        driver.quit();
    }
}
