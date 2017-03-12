package com.kahyalar.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kahyalar on 17/02/2017.
 */
public class SearchProductPage extends Page {
    private String searchResult;

    @FindBy(className = "search-result-keyword")
    private WebElement searchResultText;

    public SearchProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        setSearchResult(searchResultText.getText());
    }

    public String getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(String searchResult) {
        this.searchResult = searchResult;
    }
}
