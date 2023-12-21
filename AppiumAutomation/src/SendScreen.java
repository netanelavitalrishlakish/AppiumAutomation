import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SendScreen {
    private static WebElement ButtonEmailOption;
    private static WebElement ButtonEmailAddressInside;
    private static WebElement ButtonContinue;

    /*Pick Email option*/
    public static List<WebElement> EmailOptionApp(WebDriver driver)
    {
        List<WebElement> ButtonEmailOption=driver.findElements(MobileBy.className("android.widget.CheckBox"));
        return ButtonEmailOption;
    }

    /*Enter email address*/
    public static WebElement EmailAddressInsideApp(WebDriver driver)
    {
        ButtonEmailAddressInside=driver.findElement(MobileBy.id("il.co.mintapp.buyme:id/description"));
        return ButtonEmailAddressInside;
    }

    /*Press button continue*/

    public static WebElement ButtonContinueApp(WebDriver driver)
    {
        ButtonContinue=driver.findElement(MobileBy.id("il.co.mintapp.buyme:id/goNextButton"));
        return ButtonContinue;
    }




}
