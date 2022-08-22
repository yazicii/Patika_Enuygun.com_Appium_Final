package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;
import testng.BaseTest;

@Data
public class HomePage {

    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(BaseTest.Driver), this);
    }

    @AndroidFindBy(id = "signUpPageTitle")
    private MobileElement homeSignUpPageTitle;

    @AndroidFindBy(id = "signInEmailTextInput")
    private MobileElement signInEmailButton;

    @AndroidFindBy(id = "signInPasswordTextInput")
    private MobileElement signInPasswordButton;

    @AndroidFindBy(id = "signInButton")
    private MobileElement signInButton;

    @AndroidFindBy(id = "signInErrorView")
    private MobileElement errorView;

    @AndroidFindBy(id = "saveLoginCheckBox")
    private MobileElement saveLoginCheckBox;

    @AndroidFindBy(id = "signUpBtn")
    private MobileElement signUpButton;



}
