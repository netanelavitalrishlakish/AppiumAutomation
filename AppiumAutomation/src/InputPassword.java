import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputPassword {

    private static WebElement ButtonInputPassword;
    private static WebElement OkButton;

    public static WebElement InputPasswordApp(WebDriver driver) {
        ButtonInputPassword = driver.findElement(MobileBy.id("il.co.mintapp.buyme:id/inputPassword"));
        return ButtonInputPassword;
    }

    public static WebElement OkButton(WebDriver driver) {
        OkButton = driver.findElement(MobileBy.id("il.co.mintapp.buyme:id/continueButton"));
        return OkButton;
    }
}


