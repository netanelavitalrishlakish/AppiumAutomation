import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChoseCategory {
    private static WebElement ButtonChoseCategory;

    /*Pick a category*/

    public static WebElement ChoseCategoryApp(WebDriver driver)
    {
        ButtonChoseCategory=driver.findElement(MobileBy.id("il.co.mintapp.buyme:id/t_title"));
        return ButtonChoseCategory;
    }
}
