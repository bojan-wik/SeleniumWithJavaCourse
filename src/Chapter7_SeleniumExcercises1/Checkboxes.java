package Chapter7_SeleniumExcercises1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Checkboxes {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\88\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://www.spicejet.com/";
        driver.get(url);

        WebElement studentCheckbox = driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount"));
        Assert.assertFalse(studentCheckbox.isSelected());
        studentCheckbox.click();
        //System.out.printf("Is 'Student' checkbox selected: %b", studentCheckbox.isSelected()).println();
        Assert.assertTrue(studentCheckbox.isSelected());

        List<WebElement> discountCheckboxesBar = driver.findElements(By.xpath("//div[@id='discount-checkbox']//input[@type='checkbox']"));
        int discountCheckboxesNum = discountCheckboxesBar.size();
        Assert.assertEquals(discountCheckboxesNum, 7);
        System.out.printf("Number of the checkboxes present on the page: %d", discountCheckboxesNum).println();
    }
}