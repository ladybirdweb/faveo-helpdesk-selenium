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

public class LoginTest extends Base {
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
    @Parameters({"userName", "password"})
    public void login(String userName, String password) {
        this.lp = new LoginAndForgotPasswordPage(driver);
        this.lp.clickOnLoginButtonOnHomePage();
        this.lp.enteringUsernameForLogin(userName);
        this.lp.enteringPasswordForLogin(password);
        this.lp.clickOnDefloginbutton();
    }

    @Test
    public void adminLoginCheck() {
        Assert.assertEquals(this.lp.adminLoginDetailsText(), "System summary for last 24 hours");
        log.info("Logged in successfully as admin" + " " + this.lp.adminLoginDetailsText()
                + " " + "visibility on dashboard was" + " " + this.lp.adminLoginCheck());
    }

    @Test
    public void invalidLoginDetailsCheck() {
        Assert.assertEquals(this.lp.alertWhenInvalidLoginDetailsText(), "Login failed, please check email/username and password you entered are correct.");
        log.error(this.lp.alertWhenInvalidLoginDetailsText());
    }

    @Test
    public void agentLoginCheck() throws InterruptedException {
        Thread.sleep(3000);
        String actualURL = this.driver.getCurrentUrl();
        System.out.println(actualURL);
        Assert.assertTrue(actualURL.contains("dashboard"));
        log.info("Logged in successfully as agent");
    }

    @Test
    public void unverifiedUserLoginCheck() throws InterruptedException {
        Thread.sleep(5000);
        String actualURL = this.driver.getCurrentUrl();
        System.out.println(actualURL);
        Assert.assertTrue(actualURL.contains("verify-email"));
        log.info("Redirected to Verification Mail Resend Page");
    }

    @Test
    public void deactivatedUserLoginCheck() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(this.lp.deactivatedUserAlert.getText(), "  Sorry! This account has been deactivated. Please contact the administrator.");
        log.error(this.lp.deactivatedUserAlert.getText());
    }

    @Test
    public void OrganizationManagerUserLoginCheck() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(this.lp.organizationDropdownVisibility());
        log.info("Logged in successfully as" + " " + this.lp.organizationDropdownForOrganizationManager.getText() + " " + this.lp.organizationDropdownVisibility());
    }


    @Test
    public void OrganizationMemeberUserLoginCheck() throws InterruptedException {
        Thread.sleep(5000);
        String actualURL = this.driver.getCurrentUrl();
        System.out.println(actualURL);
        Assert.assertTrue(actualURL.contains("home"));
        log.info("Redirected to homepage once loggedin as client/user");
    }

    @AfterTest(alwaysRun = true)
    public void teardown() {
        driver.close();
    }

}

