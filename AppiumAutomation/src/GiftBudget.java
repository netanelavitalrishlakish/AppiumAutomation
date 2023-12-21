import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GiftBudget {
    private static WebElement ButtonGiftBudget;
    private static WebElement ButtonBuyToContinue;

    /*Enter my gift budget*/
    public static WebElement GiftBudgetApp(WebDriver driver)
    {
        ButtonGiftBudget=driver.findElement(MobileBy.id("il.co.mintapp.buyme:id/priceEditText"));
        return ButtonGiftBudget;
    }

    public static WebElement GiftBudgetButtonBuyToContinueApp(WebDriver driver)
    {
        ButtonBuyToContinue=driver.findElement(MobileBy.id("il.co.mintapp.buyme:id/purchaseButton"));
        return ButtonBuyToContinue;
    }



}
