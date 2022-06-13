package clientpanelpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientChangePasswordFromProfilePage {

    //MyProfile section Of client panel
    @FindBy(xpath = "//a[@id='navbarDropdownProfile']")
    public WebElement myProfile;

    //Profile Under Myprofile of client panel
    @FindBy(xpath = "//div[@id='dropdown_content'] //a[@id='client_profile']")
    public WebElement profileUnderMyProfileOfClientPanel;

    //Change Password Under MyProfile
    @FindBy(xpath = "//a[@id='client_profile_tab_1']")
    public WebElement changePasswordOfClientPanel;

    //Old Password field
    @FindBy(xpath = "//input[@id='client_change_pass_old']")
    public WebElement oldPasswordOfClientPanel;

    //New Password Field
    @FindBy(xpath = "//input[@id='client_change_pass_new']")
    public WebElement newPasswordOfClientPanel;

    //COnfirm Password field
    @FindBy(xpath = "//input[@id='client_change_pass_confirm']")
    public WebElement confirmPasswordOfClientPanel;

    //Update button in change password field
    @FindBy(xpath = "//button[@id='client_change_pass_action']")
    public WebElement updateButtonInChangePasswordOfClientPanel;

    //Alert when we input invalid old password
    @FindBy(xpath = "//div[@id='alert-message'] //div //span[text()='Password was not updated. Incorrect old password']")
    public WebElement oldPasswordInvalidAlert;

    //Alert when we input mismatch of new and confirm password
    @FindBy(xpath = "//div[@class='error-block is-danger']")
    public WebElement newAndConfirmPasswordMismatch;

    //FirstName Of Profile Page
    @FindBy(xpath = "//input[@id='client_pro_first_name']")
    public WebElement firstNameOfProfileInClientPanel;

    //LastName Of Profile Page
    @FindBy(xpath = "//input[@id='client_pro_last_name']")
    public WebElement lastNameOfProfileInClientPanel;

    //Email Of Profile Page
    @FindBy(xpath = "//input[@id='client_pro_email']")
    public WebElement emailOfProfileInClientPanel;

    //Extension Of Profile Page
    @FindBy(xpath = "//div[@id='client_pro_ext'] //div //div")
    public WebElement extensionOfProfileInClientPanel;

    //Work-phone Of Profile Page
    @FindBy(xpath = "//div[@id='client_pro_phone'] //div //div")
    public WebElement workPhoneOfProfileInClientPanel;

    //MobileNumber Of Profile Page
    @FindBy(xpath = "//input[@id='id']")
    public WebElement mobileOfProfileInClientPanel;

    @FindBy(xpath="//button[@id='crop_change_img']")
    public WebElement uploadImageInProfile;

    @FindBy(xpath="//div[@class='modal-footer justify-content-between']")
    public WebElement popupOfuploadImageInProfile;

    @FindBy(xpath="//div[@class='modal-container'] //div[3] //button[@id='crop_action']")
    public WebElement proceedOfuploadImageInProfilePopup;

    //Update button of Profile Page
    @FindBy(xpath = "//button[@id='client_pro_update']")
    public WebElement updateButtonOfProfileInClientPanel;


    public ClientChangePasswordFromProfilePage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    //Clicking On Myprofile Dropdown
    public void clickOnMyProfileDropdown() {

        this.myProfile.click();
    }

    //Clicking On profile under Myprofile Dropdown
    public void clickOnProfileUnderMyProfileDropdown() {

        this.profileUnderMyProfileOfClientPanel.click();
    }

    //Clicking On change password under Myprofile Section
    public void clickOnChangePasswordUnderMyProfileSection() {

        this.changePasswordOfClientPanel.click();
    }

    //Enter old password
    public void enteringOldPasswordOfClientPanel(String oldPasswordOfClientPanel) {

        this.oldPasswordOfClientPanel.sendKeys(oldPasswordOfClientPanel);
    }

    //Enter new password
    public void enteringNewPasswordOfClientPanel(String newPasswordOfClientPanel) {

        this.newPasswordOfClientPanel.sendKeys(newPasswordOfClientPanel);
    }

    //Enter again new password for confirmation
    public void enteringConfirmPasswordOfClientPanel(String confirmPasswordOfClientPanel) {

        this.confirmPasswordOfClientPanel.sendKeys(confirmPasswordOfClientPanel);
    }

    //Clicking On Update button in Change password of Myprofile Section
    public void clickOnUpdateOfChangePasswordUnderMyProfileSection() {

        this.updateButtonInChangePasswordOfClientPanel.click();
    }

    //Getting alert text when invalid old password provided
    public String alertForInvalidOldPasswordInPasswordChange() {

        return this.oldPasswordInvalidAlert.getText();
    }

    //Getting alert text when new and confirm  password mismatch
    public String alertForMismatchOfNewAndConfirmPasswordInPasswordChange() {

        return this.newAndConfirmPasswordMismatch.getText();
    }

    //Enter firstName in Profile
    public void enteringFirstNameInProfileOfClientPanel(String firstNameInProfileOfClientPanel) {

        this.firstNameOfProfileInClientPanel.sendKeys(firstNameInProfileOfClientPanel);
    }

    //Enter lastName in Profile
    public void enteringLastNameInProfileOfClientPanel(String lastNameInProfileOfClientPanel) {

        this.lastNameOfProfileInClientPanel.sendKeys(lastNameInProfileOfClientPanel);
    }

    //Enter ext in Profile
    public void enteringExtInProfileOfClientPanel(String extInProfileOfClientPanel) {

        this.extensionOfProfileInClientPanel.sendKeys(extInProfileOfClientPanel);
    }

    //Enter phone number in Profile
    public void enteringPhoneInProfileOfClientPanel(String phoneInProfileOfClientPanel) {

        this.workPhoneOfProfileInClientPanel.sendKeys(phoneInProfileOfClientPanel);
    }

    //Enter mobile in Profile
    public void enteringMobileInProfileOfClientPanel(String mobileInProfileOfClientPanel) {

        this.mobileOfProfileInClientPanel.sendKeys(mobileInProfileOfClientPanel);
    }

    //Checking email is disabled or not in Profile
    public Boolean checkEmailFieldInProfileOfClientPanel() {
        return this.emailOfProfileInClientPanel.isDisplayed();
    }

    //Getting text for email is disabled or not in Profile
    public String getEmailFieldInProfileOfClientPanel() {
      return this.emailOfProfileInClientPanel.getText();
    }

}
