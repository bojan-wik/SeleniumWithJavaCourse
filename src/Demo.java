import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

    public static void main(String[] args) {
        // invoke dedicated .exe file
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\87\\chromedriver.exe");
        // create driver object for Chrome browser
        WebDriver driver = new ChromeDriver();

        String urlInit = "https://www.google.com";
        driver.get(urlInit);
        String urlActual = driver.getCurrentUrl();
        boolean urlTest = urlActual.contains(urlInit);

        System.out.printf("Opened page is %s", urlActual).println();
        System.out.printf("Is the correct page open: %s", urlTest).println();

        String pageSource = driver.getPageSource();
        //System.out.println(pageSource);

        driver.get("http://w3.org");
        driver.navigate().back();
        driver.close();
    }
}
