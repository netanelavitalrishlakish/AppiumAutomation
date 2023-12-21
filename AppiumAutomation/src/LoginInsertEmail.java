import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginInsertEmail {

    private static WebElement ButtonLoginInsertEmail;
    private static WebElement NextLoginInsertEmailApp;
    /*STEP 3 - Insert an existing email*/
    public static WebElement LoginInsertEmailApp(WebDriver driver)
    {
        ButtonLoginInsertEmail=driver.findElement(MobileBy.id("il.co.mintapp.buyme:id/inputEmail"));
        return  ButtonLoginInsertEmail;
    }

    public static WebElement NextLoginInsertEmailApp(WebDriver driver)
    {
        NextLoginInsertEmailApp=driver.findElement(MobileBy.id("il.co.mintapp.buyme:id/continueButton"));
        return  NextLoginInsertEmailApp;
    }
}
