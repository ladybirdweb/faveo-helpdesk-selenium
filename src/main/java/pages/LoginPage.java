package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    // LoginButton In HomePage
    @FindBy(xpath = "//li //a[@id='client_login']")
    public WebElement loginOnHomePage;
    //Username
    @FindBy(xpath = "//input[@id='login_form_user_name']")
    public WebElement username;
    //Password
    @FindBy(xpath = "//input[@id='login_form_password']")
    public WebElement password;
    //Default Login Button
    @FindBy(xpath = "//button[@id='default-login-button']")
    public WebElement defloginbutton;
    //After adminLogin getting System Summary title
    @FindBy(xpath = "//div[@class='col-md-12'] //div //div //h3")
    public WebElement adminDashboardFields;
    //Alert when username/password is invalid
    @FindBy(xpath = "//div[@id='alert'] //div //div[@id='alert-message']  //div //span")
    public WebElement invalidLoginDetailsAlert;
    //Alert when deactivated user loggedin
    @FindBy(xpath = "//div[@class='alert alert-danger'] //div")
    public WebElement deactivatedUserAlert;
    //Organization Manager logged in checking for organization dropdown
    @FindBy(xpath = "//a[@id='navbarDropdownOrg']")
    public WebElement organizationDropdownForOrganizationManager;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Clicking On LoginButton
    public void clickOnLoginButtonOnHomePage() {
        this.loginOnHomePage.click();
    }

    public void enteringUsernameForLogin(String username) {

        this.username.sendKeys(username);
    }

    public void enteringPasswordForLogin(String password) {

        this.password.sendKeys(password);
    }

    public void clickOnDefloginbutton() {

        this.defloginbutton.click();
    }

    //Checking System Summary Title visible or not on dashboard
    public boolean adminLoginCheck() {
        return this.adminDashboardFields.isDisplayed();
    }

    //Getting System Summary Title on dashboard
    public String adminLoginDetailsText() {

        return this.adminDashboardFields.getText();
    }


    // Getting text of alert for Invalid Login Details is displayed or not
    public String alertWhenInvalidLoginDetailsText() {

        return this.invalidLoginDetailsAlert.getText();
    }

    public Boolean organizationDropdownVisibility() {
        return this.organizationDropdownForOrganizationManager.isDisplayed();
    }


}
