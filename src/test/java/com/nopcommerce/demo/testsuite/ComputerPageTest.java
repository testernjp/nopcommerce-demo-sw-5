package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ComputerPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage ;


    @BeforeMethod
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        computerPage = new ComputerPage();
        desktopsPage = new DesktopsPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    }
    @Test(groups={"sanity","smoke","regression"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully(){
        //Click on Computer tab
        computerPage.clickOnComputerTab();
        //Verify "Computer" text
        String expectedErrorMessage4 = "Computer";
        String actualErrorMessage4 = computerPage.getComputerText();
        Assert.assertEquals(expectedErrorMessage4, actualErrorMessage4, " message not displayed");
    }
    @Test(groups={"smoke","regression"})

    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        //Click on Computer tab
        computerPage.clickOnComputerTab();
        //Click on Desktops link
        desktopsPage.clickOnDesktop();
    }
    @Test(groups={"regression"})
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(){
        //Click on Computer tab
        computerPage.clickOnComputerTab();
        //Click on Desktops link
        desktopsPage.clickOnDesktop();
        //Click on product name "Build your own computer"
        desktopsPage.clickOnBuildYourOwnComputer();
        //Select processor "processor"
        buildYourOwnComputerPage.selectProcessor("Processor");
        //Select RAM "ram"
        buildYourOwnComputerPage.selectRAM("Ram");
        //Select HDD "hdd"
        buildYourOwnComputerPage.selectHDD();
        //Select OS "os"
        buildYourOwnComputerPage.selectOS();
        //Select Software "software"
        buildYourOwnComputerPage.selectMicrosoftOffice();
        //Click on "ADD TO CART" Button
        buildYourOwnComputerPage.addToCartButtonClick();
        //Verify message "The product has been added to your shopping cart"
        String expectedErrorMessage4 = "The product has been added to your shopping cart";
        String actualErrorMessage4 = buildYourOwnComputerPage.shoppingCartMessage();
        Assert.assertEquals(expectedErrorMessage4, actualErrorMessage4, " message not displayed");

    }
}