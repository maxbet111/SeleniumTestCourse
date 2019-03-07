package simple_test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class Simple_test {
    public ChromeDriver driver;

    @Test
    public void test1()
    {
        System.setProperty("webdriver.chrome.driver", "\\Users\\MaximK\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost/lifecard/admin/login.php");
        driver.findElementByXPath("//input[@name='username']").sendKeys("admin");
        driver.findElementByXPath("//input[@name='password']").sendKeys("admin");
        driver.findElementByXPath("//button[@value='Login']").click();
        driver.quit();

    }
}
