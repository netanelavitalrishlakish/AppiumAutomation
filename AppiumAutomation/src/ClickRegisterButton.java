import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClickRegisterButton {
    private static WebElement introSkipButton;

    public static WebElement RegisterClickApp(WebDriver driver)
    {
         introSkipButton = driver.findElement(By.id("il.co.mintapp.buyme:id/skipButton"));
        return introSkipButton;
    }
}
