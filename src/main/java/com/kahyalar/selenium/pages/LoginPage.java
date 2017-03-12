package com.kahyalar.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kahyalar on 17/02/2017.
 */
public class LoginPage extends Page {
    private static final String USERNAME = "seleniumrocks";
    private static final String PASSWORD = "1234qwer";

    @FindBy(id = "L-UserNameField")
    private WebElement username;

    @FindBy(id = "L-PasswordField")
    private WebElement password;

    @FindBy(id = "L-Enter")
    private WebElement login;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage login(){
        PageFactory.initElements(driver, this);
        writeTo(username, USERNAME);
        fillPassword(password, PASSWORD);
        clickTo(login);
        return new HomePage(driver);
    }


}
