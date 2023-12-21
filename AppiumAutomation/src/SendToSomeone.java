import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendToSomeone {
    private static WebElement ButtonSendTo;
    private static WebElement ButtonBlessTo;
    private static WebElement ButtonContinue;


    /*Enter receiver name*/
    public static WebElement ReceiverNameApp(WebDriver driver)
    {
        ButtonSendTo=driver.findElement(MobileBy.id("il.co.mintapp.buyme:id/toEditText"));
        return ButtonSendTo;
    }

    /*Enter a blessing*/
    public static WebElement ReceiveBlessingApp(WebDriver driver)
    {
        ButtonBlessTo=driver.findElement(MobileBy.id("il.co.mintapp.buyme:id/blessEditText"));
        return ButtonBlessTo;
    }

    /*Press button continue*/

    public static WebElement ButtonContinueApp(WebDriver driver)
    {
        ButtonContinue=driver.findElement(MobileBy.id("il.co.mintapp.buyme:id/goNextButton"));
        return ButtonContinue;
    }




}
