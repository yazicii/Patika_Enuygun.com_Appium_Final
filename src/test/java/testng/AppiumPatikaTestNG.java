package testng;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.ByteArrayInputStream;

public class AppiumPatikaTestNG extends BaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Description("User checks title whether it is 'Giriş Yap'")
    @Test(priority = 1, description = "Check Sign Up Page Title")
    public void checkSignUpPageTitle() {
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getHomeSignUpPageTitle())).isEnabled();
        Assert.assertEquals(homePage.getHomeSignUpPageTitle().getText(), "Giriş Yap");
        Allure.addAttachment("I Should See That Page Cant Be Found Alert", new ByteArrayInputStream(((TakesScreenshot) Driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("User checks required fields for add account page")
    @Test(priority = 2, description = "Check Required Input")
    public void checkRequiredInput() {
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSignInEmailButton())).click();
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSignInPasswordButton())).click();
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSignInButton())).click();
        Assert.assertEquals(homePage.getErrorView().getText(), "Email boş olamaz");
        Driver.hideKeyboard();
        Allure.addAttachment("I Should See That Page Cant Be Found Alert", new ByteArrayInputStream(((TakesScreenshot) Driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Tests getting an error message when user enters wrong password")
    @Test(priority = 3, description = "Check False Required Input")
    public void checkFalseRequiredInput() throws InterruptedException, IllegalMonitorStateException {
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSignInEmailButton())).click();
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSignInEmailButton())).sendKeys("test5@gmail.com");
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSignInPasswordButton())).click();
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSignInPasswordButton())).sendKeys("paattikaa");
        Driver.hideKeyboard();
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSignInButton())).click();
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getErrorView())).click();
        Thread.sleep(5000);
        Assert.assertEquals(homePage.getErrorView().getText(), "The password is invalid or the user does not have a password.");
        Allure.addAttachment("I Should See That Page Cant Be Found Alert", new ByteArrayInputStream(((TakesScreenshot) Driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("User tests by successfully seeing Sign Up Button")
    @Test(priority = 4, description = "Check Sign Up Button Click")
    public void checkSignupButtonClick() {
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSignUpButton())).click();
        Assert.assertTrue(signUpPage.getSignupBtn().isEnabled());
        Allure.addAttachment("I Should See That Page Cant Be Found Alert", new ByteArrayInputStream(((TakesScreenshot) Driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("User successfully adds an account and logs in successfully")
    @Test(priority = 5, description = "Check Add Account Log In Successfully")
    public void checkAddAccountLogInSuccessfully() throws NoSuchElementException {
        wait.until(ExpectedConditions.elementToBeClickable(signUpPage.getEmailInputButton())).click();
        wait.until(ExpectedConditions.elementToBeClickable(signUpPage.getEmailInputButton())).sendKeys("test10@gamil.com");
        wait.until(ExpectedConditions.elementToBeClickable(signUpPage.getSignInPasswordBtn())).click();
        wait.until(ExpectedConditions.elementToBeClickable(signUpPage.getSignInPasswordBtn())).sendKeys("patika");
        Driver.hideKeyboard();
        wait.until(ExpectedConditions.elementToBeClickable(signUpPage.getSignupBtn())).click();
        wait.until(ExpectedConditions.elementToBeClickable(signUpPage.getSignInBtn())).click();
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSignInEmailButton())).click();
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSignInEmailButton())).sendKeys("test10@gmail.com");
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSignInPasswordButton())).click();
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSignInPasswordButton())).sendKeys("patika");
        Driver.hideKeyboard();
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSignInButton())).click();
        Assert.assertEquals(userPage.getSearchCustomerBtn().getText(), "MÜŞTERI ARAMA");
        Allure.addAttachment("I Should See That Page Cant Be Found Alert", new ByteArrayInputStream(((TakesScreenshot) Driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("User 'search customer' button tests that it opens the list")
    @Test(priority = 6, description = "Check Search Customer")
    public void checkSearchCustomer() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(userPage.getSearchCustomerBtn())).click();
        Assert.assertTrue(userPage.getListView().isEnabled());
        Allure.addAttachment("I Should See That Page Cant Be Found Alert", new ByteArrayInputStream(((TakesScreenshot) Driver).getScreenshotAs(OutputType.BYTES)));
    }


}
