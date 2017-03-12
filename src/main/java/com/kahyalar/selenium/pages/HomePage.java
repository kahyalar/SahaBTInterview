package com.kahyalar.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by kahyalar on 17/02/2017.
 */
public class HomePage extends Page{
    private String username;

    @FindBy(xpath = "//a[@class='profileName']/span[@class='profileName']")
    private WebElement usernameField;

    @FindBy(id = "gg-subscribe-close-button")
    private WebElement subscribeClose;

    @FindBy(id = "MastheadBannerController")
    private WebElement popup;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public HomePage closeSubscribeWindow(){
        PageFactory.initElements(driver, this);
        waitSafely(subscribeClose);
        clickTo(subscribeClose);
        return this;
    }

    public void closeSpecialForMeWindow(){
        driver.get(driver.getCurrentUrl());
    }

    public HomePage greetUser(){
        PageFactory.initElements(driver, this);
        setUsername(usernameField.getText());
        return this;
    }
}
