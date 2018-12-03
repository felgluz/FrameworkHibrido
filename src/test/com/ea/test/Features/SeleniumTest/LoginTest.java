package com.ea.test.Features.SeleniumTest;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class LoginTest {

    private WebDriver _driver = null;

    private void configureAuth(String username, String password) {
            _driver.get("chrome-extension://ggmdpepbjljkkkdaklfihhngmmgmpggp/options.html");

            String windowHandle = _driver.getWindowHandle();
            _driver.switchTo().window(windowHandle);

            _driver.findElement(By.id("login")).sendKeys(username);
            _driver.findElement(By.id("password")).sendKeys(password);
            _driver.findElement(By.id("retry")).clear();
            _driver.findElement(By.id("retry")).sendKeys("5");
            _driver.findElement(By.id("save")).click();
    }

    @Before
    public void Initialize() throws Exception {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Stefanini\\Documents\\Libs\\chromedriver.exe");
        ChromeOptions cOptions = new ChromeOptions();
        cOptions.addExtensions(new File("C:\\Users\\Stefanini\\Documents\\UdemyCourse\\src\\com\\ea\\framework\\config\\Proxy-Auto-Auth_v2.0.crx"));


            _driver = new ChromeDriver(cOptions);

        configureAuth(
                "TR662920",
                "b0t4f0go"
        );
        _driver.navigate().to("http://executeautomation.com/demosite/Login.html");

    }

    @Test
    public void Login () {
        _driver.findElement(By.name("UserName")).sendKeys(("admin"));
        _driver.findElement(By.name("Password")).sendKeys(("admin"));
        _driver.findElement(By.name("Login")).submit();
    }
}
