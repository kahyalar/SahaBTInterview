package com.kahyalar.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by kahyalar on 17/02/2017.
 */
public class Page {
    private static final int DURATION_OF_ACCEPTANCE = 10;
    protected WebDriver driver;

    @FindBy(id = "H-Register")
    private WebElement signInButton;

    @FindBy(id = "H-Login")
    private WebElement loginButton;

    @FindBy(id = "search_word")
    private WebElement searchBar;

    @FindBy(id = "header_find_button")
    private WebElement searchButton;

    public Page(WebDriver driver){
        this.driver = driver;
    }

    public SignupPage goToSignupPage(){
        PageFactory.initElements(driver, this);
        waitObjectForClick(signInButton);
        clickTo(signInButton);
        return new SignupPage(driver);
    }

    public LoginPage goToLoginPage(){
        PageFactory.initElements(driver, this);
        waitObjectForClick(loginButton);
        clickTo(loginButton);
        return new LoginPage(driver);
    }

    public void waitObjectForClick(WebElement element) {
        WebDriverWait waitForClick = new WebDriverWait(driver, DURATION_OF_ACCEPTANCE);
        waitForClick.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitObjectUntilVisible(WebElement element){
        WebDriverWait waitForVisible = new WebDriverWait(driver, DURATION_OF_ACCEPTANCE);
        waitForVisible.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitSafely(WebElement element){
        waitObjectUntilVisible(element);
        waitObjectForClick(element);
    }

    public void clickTo(WebElement element){
        element.click();
    }

    public void writeTo(WebElement element, String text){
        clickTo(element);
        element.sendKeys(text);
    }

    public void fillPassword(WebElement element, String text){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickTo(element);
        element.sendKeys(text);
    }

    public SearchProductPage searchProduct(String query){
        PageFactory.initElements(driver, this);
        writeTo(searchBar, query);
        clickTo(searchButton);
        return new SearchProductPage(driver);
    }
}
