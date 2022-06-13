package clientpaneltests;

import clientpanelpages.ClientChangePasswordFromProfilePage;
import clientpanelpages.LoginAndForgotPasswordPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import resources.Base;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class ChangePasswordOfClientTest extends Base {
    public static Logger log = LogManager.getLogger(ChangePasswordOfClientTest.class.getName());
    public WebDriver driver;
    LoginAndForgotPasswordPage lp = new LoginAndForgotPasswordPage(null);
    ClientChangePasswordFromProfilePage ccpp = new ClientChangePasswordFromProfilePage(null);



    @BeforeTest(alwaysRun = true)
    // Initialize browser and open URL
    public void initialize() throws IOException, InterruptedException {
        driver = initializeDriver();
        log.info("Browser Initialized");
        driver.get(prop.getProperty("url"));
        log.info("Navigated to homepage");
        Thread.sleep(5000);

    }

    @BeforeMethod
    @Parameters({"userName", "password"})
    public void loginAsClient(String userName,String password){
        this.lp = new LoginAndForgotPasswordPage(driver);
        this.lp.clickOnLoginButtonOnHomePage();
        this.lp.enteringUsernameForLogin(userName);
        this.lp.enteringPasswordForLogin(password);
        this.lp.clickOnDefloginbutton();
    }


    @Test
    @Parameters({"oldPasswordOfClientPanel", "newPasswordOfClientPanel", "confirmPasswordOfClientPanel"})
    public void passwordChangeInvalidOldPassword(String oldPasswordOfClientPanel, String newPasswordOfClientPanel, String confirmPasswordOfClientPanel) {
        this.ccpp = new ClientChangePasswordFromProfilePage(driver);
        this.ccpp.clickOnMyProfileDropdown();
        this.ccpp.clickOnProfileUnderMyProfileDropdown();
        this.ccpp.clickOnChangePasswordUnderMyProfileSection();
        this.ccpp.enteringOldPasswordOfClientPanel(oldPasswordOfClientPanel);
        this.ccpp.enteringNewPasswordOfClientPanel(newPasswordOfClientPanel);
        this.ccpp.enteringConfirmPasswordOfClientPanel(confirmPasswordOfClientPanel);
        this.ccpp.clickOnUpdateOfChangePasswordUnderMyProfileSection();
        String actualAlert = this.ccpp.alertForInvalidOldPasswordInPasswordChange();
        String expectedAlert = "Password was not updated. Incorrect old password";
        log.info(actualAlert);
        Assert.assertEquals(actualAlert,expectedAlert);
    }

    @Test
    @Parameters({"oldPasswordOfClientPanel", "newPasswordOfClientPanel", "confirmPasswordOfClientPanel"})
    public void passwordChangeMismatchNewAndConfirmPassword(String oldPasswordOfClientPanel, String newPasswordOfClientPanel, String confirmPasswordOfClientPanel) {
        this.ccpp = new ClientChangePasswordFromProfilePage(driver);
        this.ccpp.clickOnMyProfileDropdown();
        this.ccpp.clickOnProfileUnderMyProfileDropdown();
        this.ccpp.clickOnChangePasswordUnderMyProfileSection();
        this.ccpp.enteringOldPasswordOfClientPanel(oldPasswordOfClientPanel);
        this.ccpp.enteringNewPasswordOfClientPanel(newPasswordOfClientPanel);
        this.ccpp.enteringConfirmPasswordOfClientPanel(confirmPasswordOfClientPanel);
        this.ccpp.clickOnUpdateOfChangePasswordUnderMyProfileSection();
        String actualAlert = this.ccpp.alertForMismatchOfNewAndConfirmPasswordInPasswordChange();
        String expectedAlert = "Password does not match";
        log.info(actualAlert);
        Assert.assertEquals(actualAlert,expectedAlert);
    }


    @Test
    @Parameters({"oldPasswordOfClientPanel", "newPasswordOfClientPanel", "confirmPasswordOfClientPanel"})
    public void passwordChangeValid(String oldPasswordOfClientPanel, String newPasswordOfClientPanel, String confirmPasswordOfClientPanel) {
        this.ccpp = new ClientChangePasswordFromProfilePage(driver);
        this.ccpp.clickOnMyProfileDropdown();
        this.ccpp.clickOnProfileUnderMyProfileDropdown();
        this.ccpp.clickOnChangePasswordUnderMyProfileSection();
        this.ccpp.enteringOldPasswordOfClientPanel(oldPasswordOfClientPanel);
        this.ccpp.enteringNewPasswordOfClientPanel(newPasswordOfClientPanel);
        this.ccpp.enteringConfirmPasswordOfClientPanel(confirmPasswordOfClientPanel);
        this.ccpp.clickOnUpdateOfChangePasswordUnderMyProfileSection();
    }


    @Test
    public void profilePageOfClientCapture() throws Exception {
        this.ccpp = new ClientChangePasswordFromProfilePage(driver);
        this.ccpp.clickOnMyProfileDropdown();
        this.ccpp.clickOnProfileUnderMyProfileDropdown();
        this.takeSnapShot(driver, "./screenshots/userProfile.png");
    }

    @Test
    public void profilePageOfClient() throws Exception {
        this.ccpp = new ClientChangePasswordFromProfilePage(driver);
        this.ccpp.clickOnMyProfileDropdown();
        this.ccpp.clickOnProfileUnderMyProfileDropdown();

    }

    @Test
    //Checking email is disabled or not in Profile
    public void checkEmailFieldInProfileOfClientPanel() {
        this.ccpp = new ClientChangePasswordFromProfilePage(driver);
        this.ccpp.clickOnMyProfileDropdown();
        this.ccpp.clickOnProfileUnderMyProfileDropdown();
        String clientEmailInProfile = this.ccpp.getEmailFieldInProfileOfClientPanel();
        log.info(clientEmailInProfile);
        Boolean emailDisplayed = this.ccpp.checkEmailFieldInProfileOfClientPanel();
        log.info("email field displayed is "+ " " + emailDisplayed);
    }

    @Test
    //Checking email is disabled or not in Profile
    public void tryUploadingProfile() throws InterruptedException, AWTException {
        this.ccpp = new ClientChangePasswordFromProfilePage(driver);
        this.ccpp.clickOnMyProfileDropdown();
        this.ccpp.clickOnProfileUnderMyProfileDropdown();
        Thread.sleep(3000);
       /* this.ccpp.uploadImageInProfile.click();
        //this.driver.switchTo().frame(this.ccpp.popupOfuploadImageInProfile);
        this.ccpp.uploadImageInProfile.sendKeys("/Users/veerakada/Downloads/test1.png");
        //Thread.sleep(3000);
        this.ccpp.uploadImageInProfile.sendKeys(Keys.ENTER);
        this.ccpp.uploadImageInProfile.click();*/



        //File Need to be imported

       File file = new File("/Users/veerakada/Downloads/test1.png");
        //File file = new File("src/main/resources/media/" + fileName);
        StringSelection stringSelection = new StringSelection(file.getAbsolutePath());
        //Copy to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        // Cmd + Tab is needed since it launches a Java app and the browser looses focus
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.delay(500);

        //Open Goto window
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_G);

        //Paste the clipboard value
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_V);

        //Press Enter key to close the Goto window and Upload window
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

       // this.ccpp.proceedOfuploadImageInProfilePopup.click();
        this.ccpp.updateButtonOfProfileInClientPanel.click();

    }


  // @AfterTest(alwaysRun = true)
    public void teardown() {
        driver.close();
    }
}
