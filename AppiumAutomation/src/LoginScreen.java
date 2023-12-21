import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginScreen {
    private static WebElement ButtonLoginScreen;

    /*STEP 2 - click to login*/
    public static WebElement LoginScreenApp(WebDriver driver)
    {
        ButtonLoginScreen=driver.findElement(MobileBy.id("il.co.mintapp.buyme:id/emailButton"));
        return  ButtonLoginScreen;
    }



}
