package com.kahyalar.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kahyalar on 17/02/2017.
 */
public class ActivationPage extends Page {
    @FindBy(xpath = "//div[@class='gg-w-21 gg-d-21 gg-t-19 gg-m-24 register-content']/h1")
    private WebElement activationText;

    @FindBy(xpath = "//*/div[@class='left']/a[@class='logo_gg imglink logo-small']")
    private WebElement logo;

    private String activationStatus;

    public String getActivationStatus() {
        return activationStatus;
    }

    public void setActivationStatus(String activationStatus) {
        this.activationStatus = activationStatus;
    }

    public ActivationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        setActivationStatus(activationText.getText());
    }

    public HomePage returnToHomePage(){
        PageFactory.initElements(driver, this);
        clickTo(logo);
        return new HomePage(driver);
    }

}
