import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InputPhone {
    private static WebElement ButtonInputPhone;
    private static WebElement ButtonSendCode;
    private static WebElement OkButton;
    private static WebElement OkButtonAgain;

    public static List<WebElement> InputPhoneApp(WebDriver driver) {
        List <WebElement> ButtonInputPhone = driver.findElements(MobileBy.id("il.co.mintapp.buyme:id/placeHolderImage"));
        return ButtonInputPhone;
    }

    public static WebElement SendCodeApp(WebDriver driver) {

        ButtonSendCode = driver.findElement(MobileBy.id("il.co.mintapp.buyme:id/continueButton"));
        return ButtonSendCode;
    }

    public static WebElement OkButtonApp(WebDriver driver) {

        OkButton = driver.findElement(MobileBy.id("il.co.mintapp.buyme:id/okButton"));
        return OkButton;
    }

    public static WebElement OkButtonAgainApp(WebDriver driver) {

        OkButtonAgain = driver.findElement(MobileBy.id("com.android.packageinstaller:id/permission_allow_button"));
        return OkButtonAgain;
    }











}
