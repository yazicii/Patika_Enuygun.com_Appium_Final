package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;
import testng.BaseTest;

@Data
public class SignUpPage {

    public SignUpPage(){
        PageFactory.initElements(new AppiumFieldDecorator(BaseTest.Driver), this);
    }

    @AndroidFindBy(id = "username")
    private MobileElement emailInputButton;

    @AndroidFindBy(id = "password1")
    private MobileElement signInPasswordBtn;

    @AndroidFindBy(id = "sign")
    private MobileElement signupBtn;

    @AndroidFindBy(id = "signin")
    private MobileElement signInBtn;

}
