package org.benz.mainTest;

import org.benz.pages.browser.BrowserMethods;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.benz.WebDrivers;


public class PriceEnquiryTest extends GenericWebSTeps {

    public WebDriver driver;
    private GenericWebSTeps genericWebSteps;
    private BrowserMethods browserMethods;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        browserMethods = new BrowserMethods();
        browserMethods.openPortal();
    }

    @Test
    public void getVehicleInfo() {
        genericWebSteps = new GenericWebSTeps();
        System.out.println("Test ");
        genericWebSteps.clickAgreeButton();
        genericWebSteps.selectState();
        genericWebSteps.inputPostalCod();
        genericWebSteps.selectPurpose();
        genericWebSteps.clickContinueButton();
        genericWebSteps.clickFilterButton();
        genericWebSteps.selectPreOwnedTab();
        genericWebSteps.clickAllFiltersButton();
        //after filter button is clicked, again handle this Agree to all button on cookie box.
        genericWebSteps.clickColorFilterButton();
        genericWebSteps.selectBlueColorOption();
        //genericWebSteps.clickShowAvailableVehiclesButton(); not displaying on the site now.
        genericWebSteps.selectSorting();
        genericWebSteps.clickTopPriceVin();
        genericWebSteps.saveVinInformation();
        genericWebSteps.clickSpeakToExpertBtn();
        genericWebSteps.inputFirstName();
        genericWebSteps.inputLastName();
        genericWebSteps.inputPostCode();
        genericWebSteps.inputMobileNumber();
        genericWebSteps.inputEmailId();
        genericWebSteps.inputComment();
        genericWebSteps.clickSubmitBtn();
    }
    //@AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Test failed, keeping the browser open for debugging.");
            // add code for screenshot of failure...
        } else {
            browserMethods.quitDriver();
        }
    }
}