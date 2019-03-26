package com.copabities;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cap {



    public class Test2 {
        public ChromeDriver driver;

        @Test
        public void test22()
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

}
