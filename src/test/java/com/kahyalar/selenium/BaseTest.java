package com.kahyalar.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by kahyalar on 17/02/2017.
 */
public class BaseTest {
    protected String signUpExpected = "Üyelik işlemini tamamlamanız için size bir e-posta gönderdik";
    protected String loginExpected = "seleniumrocks";
    protected String searchResultExpected = "asus notebook";
    protected WebDriver driver;
    private final String BASE_URL = "http://www.gittigidiyor.com/";

    @Before
    public void startUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
