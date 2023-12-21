import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClickIcon {

private static WebElement ButtonIcon;
    /*STEP 1 - click on the icon application to open*/
    public static WebElement ClickOnIcon(WebDriver driver)
    {
        ButtonIcon=driver.findElement(MobileBy.className("android.widget.TextView"));
        return ButtonIcon;
    }


}
