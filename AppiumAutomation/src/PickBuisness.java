import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PickBuisness {
    private static WebElement ButtonPickBuisness;

     /*Pick a Buisness*/

    public static WebElement PickBuisnessApp(WebDriver driver)
    {
        ButtonPickBuisness=driver.findElement(MobileBy.id("il.co.mintapp.buyme:id/businessImage"));
        return ButtonPickBuisness;
    }
}
