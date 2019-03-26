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
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

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

        for (int i = 0; i < menu.size(); i++) {

            menu.get(i).click();
            WebElement submenu = driver.findElementByXPath("//li[@class='selected']//li");
            List<WebElement> menu1 = driver.findElements(By.xpath("//div[@id='box-apps-menu-wrapper']//li"));
            menu1.get(i).click();
            if (submenu.isDisplayed()) {
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
    public void check_stiker() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-crash-reporter");
        options.addArguments("full-memory-crash-report");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        driver.get("http://localhost/lifecard/en/");
        List<WebElement> ducks = driver.findElementsByXPath("//li[@class='product column shadow hover-light']");
        System.out.println(ducks.size());
        WebElement stiker = driver.findElement(By.xpath("//*[starts-with(@class,\"sticker\")]"));


        for (WebElement label : ducks) {


            if (label.isSelected()) {

                stiker.isDisplayed();


            }

        }
        driver.quit();

    }


    @Test
    public void Check_SortingTask9() {

        driver = new ChromeDriver();
        driver.get("http://localhost/lifecard/admin/login.php");
        driver.findElementByXPath("//input[@name='username']").sendKeys("admin");
        driver.findElementByXPath("//input[@name='password']").sendKeys("admin");
        driver.findElementByXPath("//button[@value='Login']").click();

        driver.get("http://localhost/lifecard/admin/?app=countries&doc=countries");
        WebElement table = driver.findElementByXPath("//table[@class='dataTable']");
        List<WebElement> countries = table.findElements(By.xpath(".//td[5]"));

        ArrayList<String> obtainedList = new ArrayList<>();

        for (WebElement ele : countries) {
            obtainedList.add(ele.getText());

        }
        ArrayList<String> sortedList = new ArrayList<>();
        for (String s : obtainedList) {
            sortedList.add(s);
        }
        Collections.sort(sortedList);
        Assert.assertTrue(sortedList.equals(obtainedList));

        List<WebElement> zone = driver.findElements(By.xpath(".//td[6]"));

        for (WebElement ele : zone) {
            String fff = ele.getAttribute("textContent");
            int result = Integer.parseInt(fff);
            //System.out.println(result);
            if (result != 0) {

                ele.click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                WebElement tablein = driver.findElementByXPath("//table[@id='table-zones']");
                List<WebElement> countriesInside = tablein.findElements(By.xpath(".//td[5]"));

                ArrayList<String> obtainedList1 = new ArrayList<>();

                for (WebElement ele1 : countriesInside) {
                    obtainedList1.add(ele1.getText());

                }
                ArrayList<String> sortedList1 = new ArrayList<>();
                for (String s : obtainedList1) {
                    sortedList1.add(s);
                }
                Collections.sort(sortedList);
                Assert.assertTrue(sortedList1.equals(obtainedList1));

            }


        }


        driver.quit();


    }


    @Test
    public void CorrectGoodsPageOpen_Task10() {
        driver = new ChromeDriver();
        driver.get("http://localhost/lifecard/en/");
        List<WebElement> compain = driver.findElement(By.xpath("//div[@class='content']")).findElements(By.xpath("//li[@class='product column shadow hover-light']"));
        String mainGoodstitle = driver.findElement(By.xpath("//div[@id='box-campaigns']//a[1]")).getAttribute("title");
        String mainGoodPrice = driver.findElement(By.xpath("//div[@id='box-campaigns']//strong[@class='campaign-price']")).getAttribute("innerText");
        String priscStyle = driver.findElementByXPath("//s[@class='regular-price']").getCssValue("text-decoration-line");
        System.out.println(priscStyle);


        driver.findElementByXPath("//div[@id='box-campaigns']//a[1]").click();
        String goodsPageTitle = driver.findElement(By.xpath("//h1[@class='title']")).getAttribute("textContent");
        String pageGoodPrice = driver.findElement(By.xpath("//s[@class='regular-price']")).getAttribute("innerText");
        System.out.println(pageGoodPrice);
        Assert.assertTrue(mainGoodstitle.equals(goodsPageTitle));
        Assert.assertFalse(mainGoodPrice.equals(pageGoodPrice));
        System.out.println(goodsPageTitle);

        driver.quit();
    }

    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@example.com";
    }

    @Test
    public void registerUser_Task11() {
        driver = new ChromeDriver();
        driver.get("http://localhost/lifecard/en/");
        driver.findElementByXPath("//a[contains(text(),'New customers click here')]").click();
        driver.findElementByXPath("//input[@name='firstname']").sendKeys("testuser");
        driver.findElementByXPath("//input[@name='lastname']").sendKeys("testLastName");
        driver.findElementByXPath("//input[@name='address1']").sendKeys("testAddress");
        driver.findElementByXPath("//input[@name='address2']").sendKeys("testAddress2");
        driver.findElementByXPath("//input[@name='postcode']").sendKeys("12345");
        driver.findElementByXPath("//input[@name='city']").sendKeys("Rome");

        Select countries = new Select(driver.findElement(By.name("country_code")));
        countries.selectByVisibleText("United States");
        WebElement zone = driver.findElementByXPath("//input[@name='zone_code']");

        //System.out.println(zone.getText());
        driver.executeScript("arguments[0].setAttribute('type', 'text')", zone);
        zone.sendKeys("12333");
        /*Select zoneSelect = new Select(driver.findElement(By.name("zone_code")));
        zoneSelect.selectByVisibleText("Alaska");*/
        final String randomEmail = randomEmail();
        WebElement email = driver.findElementByXPath("//input[@name='email']");
        email.sendKeys(randomEmail);

        driver.findElementByXPath("//input[@name='phone']").sendKeys("444444444");
        WebElement pass =  driver.findElementByXPath("//input[@name='password']");
        pass.sendKeys("12345678");

        driver.findElementByXPath("//input[@name='confirmed_password']").sendKeys("12345678");
        driver.findElementByXPath("//button[@value='Create Account']").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//a[text()='Logout']").click();

        String login = email.getText();
        String loginPass = pass.getText();
        driver.findElementByXPath("//input[@name='email']").sendKeys(login);
        driver.findElementByXPath("//input[@name='password']").sendKeys(loginPass);
        driver.findElementByXPath("//a[text()='Logout']").click();



       driver.quit();


    }

    @Test
    public void addtoRecycle_Task13() {
        driver = new ChromeDriver();
        driver.get("http://localhost/lifecard/en/");
        driver.findElementByXPath("//div[@id='box-campaigns']//a[1]").click();
        driver.findElementByXPath("//button[@value='Add To Cart']").click();

        Select countries = new Select(driver.findElement(By.xpath("//select[@name='options[Size]']")));
        countries.selectByVisibleText("Small");
        driver.findElementByXPath("//button[@value='Add To Cart']").click();

        driver.quit();
    }



}