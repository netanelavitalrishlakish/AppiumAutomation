import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Main {
    private static String appPackageStr ;
    private static String appActivityStr ;
    private static String imagePath="C:\\REPORTS\\";
    private static String PathNameOfGetdata="C:\\XmlToProject\\AppPackageAndActivity.xml";
    private static String CreateReport="C://REPORTS//reportsappium.html";
    @Rule
    public TestName name = new TestName();

    private static AndroidDriver driver;

    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent ;

    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test ;

    // We will need this variable to execute commands on the mobile as scrolling
    private static MobileElement Next;


    @BeforeClass
    public static void setUp() throws MalformedURLException, org.xml.sax.SAXException{

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(CreateReport);

        // choose to append each test
        htmlReporter.setAppendExisting(true);
        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // name your test and add description
        test = extent.createTest("AllTestsInAppium", "Attached are pictures for each test");

        // add custom system info
        extent.setSystemInfo("Tester", "Netanel");

        // log results
        test.log(Status.INFO, "@Before class");

        /*from connection android*/
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Device");

         /*Use with Xml*/
        /*check for appPackage*/
            appPackageStr = getData("appPackage");
            if (appPackageStr.equals("il.co.mintapp.buyme")) {
                capabilities.setCapability("appPackage", appPackageStr);
                test.log(Status.PASS, "successfully appPackage with Xml");
            } else test.log(Status.FAIL, "The appPackage is not inside an external XML file.");

        /*check for appActivity*/
            appActivityStr = getData("appActivity");
            if (appActivityStr.equals("il.co.mintapp.buyme.activities.common.SplashScreen")) {
                capabilities.setCapability("appActivity", appActivityStr);
                test.log(Status.PASS, "successfully appActivity with Xml");
            } else test.log(Status.FAIL, "The appActivity is not inside an external XML file.");
            /*Continued installation and compatibility for Android*/
            capabilities.setCapability("newCommandTimeout", 120);
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub/"), capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
    }

    /*A. Intro & Registration screen*/

    @Test
    public void test01_ClickIconTest() throws IOException
    {
        /*for report*/
        test.log(Status.PASS, "Test01");
        /*Check whether the test has passed*/
        boolean pressed = false;
        try {
            // add screenshot
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            ClickIcon.ClickOnIcon(driver).click();
            test.pass("picture of new page current - register ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(imagePath + name.getMethodName())).build());
            pressed = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "The icon does not open" + e.getMessage());
            pressed = false;
        } finally {
            if (pressed) {
                test.log(Status.PASS, "Icon was clicked successfully");
            }

        }
    }

    /*screen choose- email,facebook,google*/
    @Test
    public void test02_RegisterTest()
    {
        /*for report*/
        test.log(Status.PASS, "Test02");
            /*Check whether the test has passed*/
        boolean pressed = false;
        try {
            // add screenshot
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            ClickRegisterButton.RegisterClickApp(driver).click();
            test.pass("picture of new page current - after Click the Register button", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(imagePath + name.getMethodName())).build());
            pressed = true;
        } catch (Exception e)
        {
            e.printStackTrace();
            test.log(Status.FAIL, "The button Register does not open new page" + e.getMessage());
            pressed = false;
        } finally {
            if (pressed)
            {
                test.log(Status.PASS, "We choice the email button to continue(orange)");
            }

        }
    }


    @Test
    public void test03_LoginScreenTest()
    {
         /*for report*/
        test.log(Status.PASS, "Test03");
          /*Check whether the test has passed*/
        boolean pressed = false;
        try {
            // add screenshot
            LoginScreen.LoginScreenApp(driver).click();
            test.pass("picture of new page current - after email button clicked", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(imagePath + name.getMethodName())).build());
            pressed = true;
        } catch (Exception e)
        {
            e.printStackTrace();
            test.log(Status.FAIL, "The page does not open" + e.getMessage());
            pressed = false;
        } finally {
            if (pressed)
            {
                test.log(Status.PASS, "page show successfully");
            }

        }
    }

      @Test
    public void test04_LoginInsertEmailTest()
    {
         /*for report*/
        test.log(Status.PASS, "Test04");
        /*Check whether the test has passed*/
        boolean pressed = false;
        try {
        // add screenshot
        LoginInsertEmail.LoginInsertEmailApp(driver).sendKeys("hjssdkj2990@gmail.com");
        driver.hideKeyboard();
        test.pass("Email Insert", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(imagePath + name.getMethodName())).build());
        LoginInsertEmail.NextLoginInsertEmailApp(driver).click();
        pressed = true;
    } catch (Exception e)
    {
        e.printStackTrace();
        test.log(Status.FAIL, "The Email does not inserted" + e.getMessage());
        pressed = false;
    } finally {
        if (pressed)
        {
            test.log(Status.PASS, "The Email inserted successfully and click to continue");
        }

    }
}

    @Test
    public void test05_InputPasswordTest() throws IOException {
         /*for report*/
        test.log(Status.PASS, "Test05");
            /*Check whether the test has passed*/
        boolean pressed = false;
        try {
            // add screenshot
            InputPassword.InputPasswordApp(driver).sendKeys("123");
            driver.hideKeyboard();
            test.pass("password Insert", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(imagePath + name.getMethodName())).build());
            InputPassword.OkButton(driver).click();
            pressed = true;
        } catch (Exception e)
        {
            e.printStackTrace();
            test.log(Status.FAIL, "The password does not inserted and click to continue" + e.getMessage());
            pressed = false;
        } finally {
            if (pressed)
            {
                test.log(Status.PASS, "The password inserted successfully and click to continue");
            }

        }
    }

        /*
    @Test
    public void test5_InputPhoneTest()
    {
        InputPhone.InputPhoneApp(driver).get(0).sendKeys("0");
        InputPhone.InputPhoneApp(driver).get(1).sendKeys("5");
        InputPhone.InputPhoneApp(driver).get(2).sendKeys("2");
        InputPhone.InputPhoneApp(driver).get(3).sendKeys("0");
        InputPhone.InputPhoneApp(driver).get(4).sendKeys("0");
        InputPhone.InputPhoneApp(driver).get(5).sendKeys("0");
        InputPhone.InputPhoneApp(driver).get(6).sendKeys("0");
        InputPhone.InputPhoneApp(driver).get(7).sendKeys("0");
        InputPhone.InputPhoneApp(driver).get(8).sendKeys("0");
        InputPhone.InputPhoneApp(driver).get(9).sendKeys("0");

        InputPhone.SendCodeApp(driver).click();

        InputPhone.OkButtonApp(driver).click();

        InputPhone.OkButtonAgainApp(driver).click();
    }

    @Test
    public void test6_InsertCodePhoneTest()
    {
        InsertCodePhone.InsertCodePhoneApp1(driver).click();
    }

*/



/*B. Home Screen*/

    @Test
    public void test06_DisplayNextScreenTest() throws IOException {
         /*for report*/
        test.log(Status.PASS, "Test06,Test07");
        try {
            Thread.sleep(5000);
            test.pass("The next screen:", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(imagePath + name.getMethodName())).build());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test07_PickCategoryTest() throws IOException, InterruptedException {
        /*Check whether the test has passed*/
        boolean pressed = false;

        try {
            ChoseCategory.ChoseCategoryApp(driver).click();
            pressed = true;
        } catch (Exception e)
        {
            e.printStackTrace();
            test.log(Status.FAIL, "The gift card does not click to continue" + e.getMessage());
            pressed = false;
        } finally
        {
            if (pressed)
            {
                test.log(Status.PASS, "The gift card  click to continue and successfully");
            }
        }

    }

    @Test
    public void test08_DisplayNextScreenTest() throws IOException {
         /*for report*/
        test.log(Status.PASS, "Test08,Test09");
        // add screenshot
        try {
            Thread.sleep(5000);
            test.pass("The next screen:", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(imagePath + name.getMethodName())).build());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test09_PickBuisnessTest()
    {
        /*Check whether the test has passed*/
        boolean pressed = false;
        try {
            PickBuisness.PickBuisnessApp(driver).click();
            pressed = true;
        } catch (Exception e)
        {
            e.printStackTrace();
            test.log(Status.FAIL, "The Buisness does not click to continue" + e.getMessage());
            pressed = false;
        } finally
        {
            if (pressed)
            {
                test.log(Status.PASS, "The Buisness click to continue and successfully");
            }
        }

    }

    @Test
    public void test10_DisplayNextScreenTest() throws IOException {
         /*for report*/
        test.log(Status.PASS, "Test10,Test11");
        // add screenshot
        try {
            Thread.sleep(5000);
            test.pass("The next screen:", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(imagePath + name.getMethodName())).build());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test11_GiftBudgetTest() throws IOException
    {
        /*Check whether the test has passed*/
        boolean pressed = false;
        try {
            // add screenshot
            GiftBudget.GiftBudgetApp(driver).sendKeys("300");
            driver.hideKeyboard();
            Thread.sleep(2000);
            test.pass("Insert sum money", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(imagePath+ name.getMethodName())).build());
            GiftBudget.GiftBudgetButtonBuyToContinueApp(driver).click();
            pressed = true;
        } catch (Exception e)
        {
            e.printStackTrace();
            test.log(Status.FAIL, "The Insert money does not inserted and click to continue" + e.getMessage());
            pressed = false;
        } finally {
            if (pressed)
            {
                test.log(Status.PASS, "The Insert money successfully and click to continue");
            }

        }

    }

    /*C. Sender & Receiver information screen*/

    @Test
    public void test12_DisplayNextScreenTest() throws IOException {
         /*for report*/
        test.log(Status.PASS, "Test12,Test13");
        // add screenshot
        try {
            Thread.sleep(5000);
            test.pass("The next screen:", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(imagePath + name.getMethodName())).build());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test13_SendToSomeoneTest() throws InterruptedException
    {
        /*Check whether the test has passed*/
        boolean pressed = false;
        try {
            // add screenshot
            SendToSomeone.ReceiverNameApp(driver).sendKeys("netanyahu");
            driver.hideKeyboard();
            SendToSomeone.ReceiveBlessingApp(driver).sendKeys("Thank you very much for the best prime minister!");
            driver.hideKeyboard();
            Thread.sleep(2000);
            test.pass("Insert the bless(from Two fields)", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(imagePath + name.getMethodName())).build());
            /*scrol to find element*/
            Next= (MobileElement) driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"המשך\"))");
            SendToSomeone.ButtonContinueApp(driver).click();
            pressed = true;
        } catch (Exception e)
        {
            e.printStackTrace();
            test.log(Status.FAIL, "The Insert bless does not inserted and click to continue" + e.getMessage());
            pressed = false;
        } finally {
            if (pressed)
            {
                test.log(Status.PASS, "The bless successfully and click to continue");
            }

        }


    }


    @Test
    public void test14_DisplayNextScreenTest() throws IOException
    {
         /*for report*/
        test.log(Status.PASS, "Test14,Test15");
        // add screenshot
        try {
            Thread.sleep(5000);
            test.pass("The next screen:", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(imagePath + name.getMethodName())).build());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*D. How to send screen*/

    @Test
    public void test15_SendScreenTest()
    {
        /*Check whether the test has passed*/
        boolean pressed = false;
        try {
            // add screenshot
            SendScreen.EmailOptionApp(driver).get(1).click();
            SendScreen.EmailAddressInsideApp(driver).sendKeys("sdlksskseew00886@gmail.com");
            driver.hideKeyboard();
            test.pass("choice and Insert email", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(imagePath + name.getMethodName())).build());
            /*scrol to find element click button continue*/
            Next= (MobileElement) driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"המשך\"))");
            SendScreen.ButtonContinueApp(driver).click();
            pressed = true;
        } catch (Exception e)
        {
            e.printStackTrace();
            test.log(Status.FAIL, "The Insert email does not inserted and click to continue" + e.getMessage());
            pressed = false;
        } finally {
            if (pressed)
            {
                test.log(Status.PASS, "The email successfully and click to continue");
            }

        }
    }

    @Test
    public void test16_DisplayNextScreenTest() throws IOException
    {
        /*for report*/
        test.log(Status.PASS, "Test16");
        // add screenshot
        try {
            Thread.sleep(5000);
            test.pass("This is the last screen to reach according to the characterization document - the end.", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(imagePath + name.getMethodName())).build());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @AfterClass
    public static void tearDown() {
        driver.quit();
        // build and flush report
        extent.flush();
    }


    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath+".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath+".png";
    }

    private static String getData (String keyName) throws org.xml.sax.SAXException {
        File configXmlFile = new File(PathNameOfGetdata);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
            assert dBuilder != null;
            doc = dBuilder.parse(configXmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        assert doc != null;
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }
}




