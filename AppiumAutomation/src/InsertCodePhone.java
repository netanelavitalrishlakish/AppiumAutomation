import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InsertCodePhone {
    private static WebElement ButtonInsertCodePhone;


    public static WebElement InsertCodePhoneApp1(WebDriver driver) {

        ButtonInsertCodePhone = driver.findElement(MobileBy.id("il.co.mintapp.buyme:id/okButton"));
        return ButtonInsertCodePhone;
    }



}
