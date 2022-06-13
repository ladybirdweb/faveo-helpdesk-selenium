package clientpaneltests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import clientpanelpages.LoginAndForgotPasswordPage;
import resources.Base;

import java.io.IOException;

public class ForgotPasswordTest extends Base {
    public static Logger log = LogManager.getLogger(LoginTest.class.getName());
    public WebDriver driver;
    LoginAndForgotPasswordPage lp = new LoginAndForgotPasswordPage(null);


    @BeforeTest(alwaysRun = true)
    // Initialize browser and open URL
    public void initialize() throws IOException, InterruptedException {
        driver = initializeDriver();
        log.info("Browser Initialized");

        driver.get(prop.getProperty("url"));
        log.info("Navigated to homepage");
        Thread.sleep(5000);
    }

    @Test
    @Parameters({"emailforforgotpassword"})
    public void validForgotPassword(String emailforforgotpassword) throws InterruptedException {
        this.lp = new LoginAndForgotPasswordPage(driver);
        this.lp.clickOnLoginButtonOnHomePage();
        String expectedURL = driver.getCurrentUrl();
        this.lp.clickOnForgotPassword();
        this.lp.enteringEmailForForgotPassword(emailforforgotpassword);
        this.lp.clickOnSendOfForgotPasswordEmailProvidingPage();
        Thread.sleep(5000);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }


    @Test
    @Parameters({"emailforforgotpassword"})
    public void invalidForgotPassword(String emailforforgotpassword) {
        this.lp = new LoginAndForgotPasswordPage(driver);
        this.lp.clickOnLoginButtonOnHomePage();
        this.lp.clickOnForgotPassword();
        this.lp.enteringEmailForForgotPassword(emailforforgotpassword);
        this.lp.clickOnSendOfForgotPasswordEmailProvidingPage();
        String actualAlert = this.lp.alertForInvalidEmailOfForgotPassword();
        String expectedAlert = "Please type a valid email address";
        Assert.assertEquals(actualAlert,expectedAlert);
        log.info(actualAlert);
    }

    @Test
    public void iKnowMyPassword() {
        this.lp = new LoginAndForgotPasswordPage(driver);
        this.lp.clickOnLoginButtonOnHomePage();
        String expectedURL = driver.getCurrentUrl();
        this.lp.clickOnForgotPassword();
        this.lp.clickOnIKnowMyPassword();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
        log.info("Redirected to login page as clicked on I know my password");
    }

   @AfterTest(alwaysRun = true)
    public void teardown() {
        driver.close();
    }

}
