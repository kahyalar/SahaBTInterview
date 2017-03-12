package com.kahyalar.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kahyalar on 17/02/2017.
 */
public class SignupPage extends Page {
    private static final String NAME = "Deneme";
    private static final String SURNAME = "Kullanıcısı";
    private static final String EMAIL = "tamamiylekullanilmayanbirmail404@gmail.com";
    private static final String USERNAME = "dene404dene";
    private static final String PASSWORD = "1234qwer";
    private static final String GSM_CODE = "555";
    private static final String GSM_NUMBER = "1234567";

    @FindBy(xpath = "//input[@name='name']")
    private WebElement name;

    @FindBy(xpath = "//input[@name='surname']")
    private WebElement surname;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@name='nick']")
    private WebElement username;

    @FindBy(xpath = "//input[@name='password_passwd']")
    private WebElement password;

    @FindBy(xpath = "//input[@name='passwd2']")
    private WebElement passwordFix;

    @FindBy(xpath = "//input[@name='gsmcode']")
    private WebElement gsmCode;

    @FindBy(xpath = "//input[@id='gsmnumber']")
    private WebElement gsmNumber;

    @FindBy(xpath = "//input[@id='SubmitForm']")
    private WebElement submitButton;


    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public SignupPage fillForm(){
        PageFactory.initElements(driver, this);
        writeTo(name, NAME);
        writeTo(surname, SURNAME);
        writeTo(email, EMAIL);
        writeTo(username, USERNAME);
        fillPassword(password, PASSWORD);
        fillPassword(passwordFix, PASSWORD);
        writeTo(gsmCode, GSM_CODE);
        writeTo(gsmNumber, GSM_NUMBER);
        return this;
    }

    public ActivationPage signUp(){
        PageFactory.initElements(driver, this);
        clickTo(submitButton);
        return new ActivationPage(driver);
    }

}
