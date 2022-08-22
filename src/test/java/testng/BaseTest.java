package testng;

import devices.DeviceFarm;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.SignUpPage;
import pages.UserPage;
import utility.DeviceFarmUtility;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.InvalidPathException;

public class BaseTest {
    public static AppiumDriver<?> Driver;
    HomePage homePage;
    SignUpPage signUpPage;
    UserPage userPage;
    String oreo;
    DesiredCapabilities capabilities;
    WebDriverWait wait;

    public BaseTest() {
        oreo = DeviceFarm.ANDROID_OREO.path;
    }

    @BeforeSuite
    public void setup() {

        capabilities = new DesiredCapabilities();
        try {
            capabilities = DeviceFarmUtility.pathToDesiredCapabilities(this.oreo);
        }catch (InvalidPathException exception){
            System.out.println("Please add correct path , this path is not working"+exception.getMessage());
        }
        try {
            capabilities.setCapability("app", new File("src/test/resources/apps/patikaappium.apk").getAbsolutePath());
        }catch (WebDriverException exception){
            System.out.println("Please add apk , was not find file APK or APK path"+exception.getMessage());
        }
        try {
            Driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        }catch (MalformedURLException exception){
            System.out.println("Please set correct remote url hub :\t"+exception.getMessage());
        }
        wait = new WebDriverWait(Driver,15);
    }

    @BeforeTest
    public void createPages(){
        homePage = new HomePage();
        signUpPage = new SignUpPage();
        userPage = new UserPage();
    }

    //@AfterSuite
    //    public void tearDown() {
    //        if (Driver != null) {
    //            Driver.quit();
    //        }
    //    }


}
