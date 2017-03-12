package com.kahyalar.selenium;

import com.kahyalar.selenium.pages.ActivationPage;
import com.kahyalar.selenium.pages.HomePage;
import com.kahyalar.selenium.pages.SearchProductPage;
import org.junit.Assert;

/**
 * Created by kahyalar on 17/02/2017.
 */
public class Test extends BaseTest {
    @org.junit.Test
    public void test(){
        new HomePage(driver)
                .closeSubscribeWindow()
                .goToSignupPage()
                .fillForm()
                .signUp();
        String signUpFound = new ActivationPage(driver).getActivationStatus();
        Assert.assertTrue("User must be seen activation screen right now.", signUpExpected.equals(signUpFound));

        new ActivationPage(driver)
                .returnToHomePage()
                .goToLoginPage()
                .login()
                .closeSpecialForMeWindow();
        HomePage homePage = new HomePage(driver)
                 .greetUser();
        String loginFound = homePage.getUsername();
        Assert.assertTrue("User must be logged in.", loginExpected.equals(loginFound));

        homePage.searchProduct("asus notebook");
        String searchResultFound = new SearchProductPage(driver).getSearchResult();
        Assert.assertTrue("User must be searched product.", searchResultExpected.equals(searchResultFound));
    }

}
