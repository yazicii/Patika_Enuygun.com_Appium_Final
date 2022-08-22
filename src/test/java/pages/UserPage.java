package pages;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;
import testng.BaseTest;

@Data
public class UserPage {

    public UserPage(){
        PageFactory.initElements(new AppiumFieldDecorator(BaseTest.Driver),this);
    }

    @AndroidFindBy(id = "signUpPageTitle")
    private MobileElement signUpPageTitle;

    @AndroidFindBy(id = "searchCustomerInfo")
    private MobileElement searchCustomerBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ListView/android.widget.TextView[2]\n")
    private MobileElement listView;
}
