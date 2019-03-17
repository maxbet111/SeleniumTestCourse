package com.test22;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ListIterator;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Test2 {

    public ChromeDriver driver;

    @Test
    public void mainMenuElements() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-crash-reporter");
        options.addArguments("full-memory-crash-report");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);

        driver.get("http://localhost/lifecard/admin/login.php");
        driver.findElementByXPath("//input[@name='username']").sendKeys("admin");
        driver.findElementByXPath("//input[@name='password']").sendKeys("admin");
        driver.findElementByXPath("//button[@value='Login']").click();
        Thread.sleep(3000);



        List<WebElement> menu = driver.findElements(By.xpath("//div[@id='box-apps-menu-wrapper']//li"));

        System.out.println(menu.size());

        WebElement title = driver.findElement(By.tagName("title"));

        System.out.println(menu);

        for (int i = 0 ; i < menu.size(); i++)
        {

            menu.get(i).click();
            WebElement submenu = driver.findElementByXPath("//li[@class='selected']//li");
            if(submenu.isDisplayed()){
                submenu.click();
                title.isDisplayed();

            }

        }

        /*List<WebElement> elements = driver.findElement(By.xpath("//ul[@id='box-apps-menu']")).findElements(By.id("app"));
        System.out.println(elements.());*/

        // Проверка title на странице
        /*driver.findElementByXPath("//span[contains(text(),'Appearence')]").click();
        String my_title = driver.getTitle();
        System.out.println(my_title);
        Assert.assertTrue(my_title.contains("Template"));
        Thread.sleep(5000);*/
driver.quit();
    }


    @Test
    public void check_stiker()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-crash-reporter");
        options.addArguments("full-memory-crash-report");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        driver.get("http://localhost/lifecard/en/");
       List<WebElement> ducks  = driver.findElementsByXPath("//div[@id='main']//li[@class='product column shadow hover-light']");
       System.out.println(ducks.size());
       WebElement stiker = driver.findElement(By.xpath("//*[starts-with(@class,\"sticker\")]"));


        for (WebElement label : ducks)
        {
            

            if (label.isSelected()){

                stiker.isDisplayed();

        }

        }


    }


}


