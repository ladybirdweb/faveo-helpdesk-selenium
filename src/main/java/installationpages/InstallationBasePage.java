package installationpages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InstallationBasePage {
    public WebDriver driver;

    public InstallationBasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /* PROBE PAGE */

    // Title of Probe Page {Server Requirements}
    @FindBy(xpath = "//div[@class='setup-content'] //h1")
    public WebElement probePageTitle;

    // Continue button enabled
    @FindBy(xpath = "//p[@class='setup-actions step'] //input[@id='submitme']")
    public WebElement probeContinueButtonEnabled;

    // Continue Button Disabled In Server Requirements
    @FindBy(xpath = "//p[@class='setup-actions step'] //button")
    public WebElement probeContinueButtonDisabled;

    // In probe.php if anything is not as per requirement will be in this color
    @FindBy(xpath = "//td[@style='color:red']")
    public WebElement probeAlert;

    // Getting text of the title of Probe Page
    public String probePageTitle() {
        return this.probePageTitle.getText();
    }

    // Clicking on Continue Button In Probe Page
    public void probeContinueButtonClick() {
        this.probeContinueButtonEnabled.click();
    }

    public void probeContinueButtonEnabledCheck() {
        this.probeContinueButtonEnabled.isEnabled();
    }

    // Checking Continue button is enabled/disabled in probe page
    public Boolean probeContinueButtonDisabled() {
        return this.probeContinueButtonDisabled.isEnabled();
    }


    /* LICENSE AGREEMENT PAGE */

    // Title of License Agreement Page {License Agreement}
    @FindBy(xpath = "//div[@class='setup-content'] //div[2] //h1")
    public WebElement licenseAgreementTitle;

    // Checkbox for accepting agreement in license agreement Page
    @FindBy(xpath = "//input[@id='Acceptme']")
    public WebElement checkboxForAgreement;

    // Continue Button In LicenseAgreement
    @FindBy(xpath = "//input[@id='submitme']")
    public WebElement continueAfterLicAgreement;

    // Getting text of the title of License Agreement Page
    public String licenseAgreementTitle() {
        return this.licenseAgreementTitle.getText();
    }

    // Accepting the license by selecting check box
    public void enableCheckboxForLicense() {
        this.checkboxForAgreement.click();
    }

    // Clicking On Continue In License Agreement Page
    public void continueAfterLicAgreement() {
        this.continueAfterLicAgreement.click();
    }

    // Checking Continue button is disabled or not when checkbox is not selected
    public Boolean checkContinueButtonWithoutAcceptingLicAgreement() {
        return this.continueAfterLicAgreement.isEnabled();
    }

    /* DATABASE SETUP PAGE */

    // Title of Database Setup Page {Database Setup}
    @FindBy(xpath = "//div[@class='setup-content'] //div //h1")
    public WebElement dbSetupTitle;

    // Host name in Database Setup Page
    @FindBy(xpath = "//input[@name='host']")
    public WebElement host;

    // MySql Port Number in Database Setup Page
    @FindBy(xpath = "//input[@name='port']")
    public WebElement mysqlPortNumber;

    // DBName in Database Setup Page
    @FindBy(xpath = "//input[@name='databasename']")
    public WebElement dbName;

    // DB User name in Database Setup Page
    @FindBy(xpath = "//input[@name='username']")
    public WebElement dbUsername;

    // DB Password in Database Setup Page
    @FindBy(xpath = "//input[@name='password']")
    public WebElement dbPassword;

    // Check box for Dummy data in Database Setup Page //input[@id='dummy-data']
    @FindBy(xpath = "//input[@id='dummy-data']")
    public WebElement dummyDataCheckbox;


    // Continue Button in Database Setup Page
    @FindBy(xpath = "//input[@id='submitme']")
    public WebElement continueInDBSetUp;

    // Entering Inputs In The Fields Of DatabaseSetupPage
    public void enteringInputsInDBSetUpPage(String host, String port, String dbName, String dbUsername,
                                            String dbPassword) {
        this.host.sendKeys(host);
        this.mysqlPortNumber.sendKeys(port);
        this.dbName.sendKeys(dbName);
        this.dbUsername.sendKeys(dbUsername);
        this.dbPassword.sendKeys(dbPassword);
    }

    // Selecting Check box for Installing With DummyData
    public void clickCheckboxForDummyData() {
        this.dummyDataCheckbox.click();
    }

    // Clicking On Continue Button In DB Setup
    public void continueAfterDBSetUp() {
        this.continueInDBSetUp.click();
    }

    public String dbSetupTitle() {
        return this.dbSetupTitle.getText();
    }

    /* DB SetUp Confirmation PAGE */

    // Title of DB SetUp Confirmation Page {Database Setup}
    @FindBy(xpath = "//div[@class='setup-content'] //h1")
    public WebElement dbSetUpConfirmationTitle;

    // Continue in DB SetUp Confirmation Page
    @FindBy(xpath = "//input[@id='submitme']")
    public WebElement continueInDbSetUpConfirmation;

    //DB setup failed and continue button disabled
    @FindBy(xpath="//input[@id='submitme']")
    public WebElement disabledContinueButtonWhenDBConnectionFailed;

    //DB setup failed and error
    @FindBy(xpath="//body //div //p //span[@class='error']")
    public WebElement errorMessage;

    public String dbSetupConfirmationTitle() {
        return this.dbSetUpConfirmationTitle.getText();
    }

    // Clicking On Continue Button In DB Setup Confirmation
    public void continueAfterDBSetUpConfirmation() throws InterruptedException {
        Thread.sleep(30000);
        this.continueInDbSetUpConfirmation.click();
    }

    public Boolean continueAfterDBSetUpConfirmationFailedLogging(){
        return this.disabledContinueButtonWhenDBConnectionFailed.isEnabled();
    }

    public String errorLoggingWhenDBConnectionFailed(){
        return this.errorMessage.getText();
    }

    /* GETTING STARTED PAGE */

    // Title of GETTING STARTED Page {SignUpAsAdmin}
    @FindBy(xpath = "//div[@ng-controller='MainController'] //h1[1]")
    public WebElement gettingStartedPageTitle;

    // Firstname field
    @FindBy(xpath = "//input[@name='firstname']")
    public WebElement firstName;

    // Lastname field
    @FindBy(xpath = "//input[@name='Lastname']")
    public WebElement lastName;

    // email field
    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;

    // userName field
    @FindBy(xpath = "//input[@name='username']")
    public WebElement userName;

    // password field
    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    // confirmPassword field
    @FindBy(xpath = "//input[@name='confirm_password']")
    public WebElement confirmPassword;

    // Time zone Field
    @FindBy(xpath = "//select[@name='timezone']/following-sibling::div[1]")
    public WebElement timeZone;

    // Enter input/search field of Timezone
    @FindBy(xpath = "//input[@class='chosen-search-input']")
    public WebElement enterFieldOfTimezone;

    // Language Field
    @FindBy(xpath = "//select[@name='language']/following-sibling::div[1]")
    public WebElement language;

    // Enter input/search field of Language
    @FindBy(xpath = "//select[@name='language']/following-sibling::div[1] //input")
    public WebElement enterFieldOfLanguage;

    // Environment Field
    @FindBy(xpath = "//select[@name='environment']/following-sibling::div[1]")
    public WebElement environment;

    // Enter input/search field of EnvironementField
    @FindBy(xpath = "//select[@name='environment']/following-sibling::div[1] //input")
    public WebElement enterFieldOfEnvironmentField;

    // DefaultStorageDriver Field
    @FindBy(xpath = "//select[@name='driver']/following-sibling::div[1]")
    public WebElement defaultStorageDriver;

    // Enter input/search field of DefStorageDriverField
    @FindBy(xpath = "//select[@name='driver']/following-sibling::div[1] //input")
    public WebElement DefStorageDriverField;

    //S3 Fields
    @FindBy(xpath = "//tr[@class='hiddenCredentials'] //td[2] //input[@name='aws_access_key_id']")
    public WebElement AWSAccessKeyId;
    @FindBy(xpath = "//tr[@class='hiddenCredentials'] //td[2] //input[@name='aws_access_key']")
    public WebElement AWSSecretAccessKey;
    @FindBy(xpath = "//tr[@class='hiddenCredentials'] //td[2] //input[@name='aws_default_region']")
    public WebElement AWSDefaultRegion;
    @FindBy(xpath = "//tr[@class='hiddenCredentials'] //td[2] //input[@name='aws_bucket']")
    public WebElement AWSBucket;
    @FindBy(xpath = "//tr[@class='hiddenCredentials'] //td[2] //input[@name='aws_endpoint']")
    public WebElement AWSEndpoint;

    // Continue In Getting Started Page
    @FindBy(xpath = "//input[@id='submitme']")
    public WebElement continueInGettingStartedPage;

    //Password mismatch alert
    @FindBy(xpath = "//body[@class='setup wp-core-ui'] //div //div //div //form //div //div //span[@id='fail']")
    public WebElement passwordMismatch;

    //Invalid S3 details alert
    @FindBy(xpath="//div[@class='woocommerce-message woocommerce-tracker'] //div //span[@id='fail']")
    public WebElement s3InvalidAlert;

    // Getting Title in Getting Started Page
    public String gettingStartedPageTitle() {
        return this.gettingStartedPageTitle.getText();
    }

    // Entering Admin Details in Getting Started Page
    public void enteringAdminInputs(String firstName, String lastName, String email, String userName, String password,
                                    String confirmPassword) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(confirmPassword);
    }

    // Clicking On time zone field
    public void selectingTimezone(String timeZone) {
        this.timeZone.click();
        this.enterFieldOfTimezone.click();
        this.enterFieldOfTimezone.sendKeys(timeZone);
        this.enterFieldOfTimezone.sendKeys(Keys.ENTER);
    }

    // Clicking On language field
    public void selectingLanguage(String language) {
        this.language.click();
        this.enterFieldOfLanguage.click();
        this.enterFieldOfLanguage.sendKeys(language);
        this.enterFieldOfLanguage.sendKeys(Keys.ENTER);
    }

    // Clicking On Environment field
    public void selectingEnvironment(String environment) {
        this.environment.click();
        this.enterFieldOfEnvironmentField.click();
        this.enterFieldOfEnvironmentField.sendKeys(environment);
        this.enterFieldOfEnvironmentField.sendKeys(Keys.ENTER);
    }

    // Clicking On DefStorageDriverField
    public void selectingDefStorageDriverField(String storage) {
        this.defaultStorageDriver.click();
        this.DefStorageDriverField.click();
        this.DefStorageDriverField.sendKeys(storage);
        this.DefStorageDriverField.sendKeys(Keys.ENTER);
    }

    //Entering S3 details

    public void enteringS3Details( String accessKeyId, String secretAccessKey, String defaultRegion,String bucket, String endPoint) {
        this.AWSAccessKeyId.sendKeys(accessKeyId);
        this.AWSSecretAccessKey.sendKeys(secretAccessKey);
        this.AWSDefaultRegion.sendKeys(defaultRegion);
        this.AWSBucket.sendKeys(bucket);
        this.AWSEndpoint.sendKeys(endPoint);
    }
    // Clicking On continue in Getting Started Page
    public void continueInGettingStartedPage() {
        this.continueInGettingStartedPage.click();
    }

    //Getting alert message when Admin Details Password and Confirm Password mismatch
    public String gettingPasswordMismatchAlert() {
        return this.passwordMismatch.getText();
    }

    //Check when admin email is in wrong format
    public Boolean gettingEmailWrongPattern(){
        return gettingStartedPageTitle.isDisplayed();
    }

    //Getting alert message when S3 Details are invalid
    public String gettingS3DetailsInvalidAlert() {
        return this.s3InvalidAlert.getText();
    }

    /* LICENSE CODE PAGE */

    // LicenseCode Page Title {Faveo Helpdesk License Code}
    @FindBy(xpath = "//div[@class='wc-setup-content'] //h1")
    public WebElement licenseCodePageTitle;

    // License code field One
    @FindBy(xpath = "//input[@id='productKey1']")
    public WebElement licCodeOne;

    // License code field Two
    @FindBy(xpath = "//input[@id='productKey2']")
    public WebElement licCodeTwo;

    // License code field Three
    @FindBy(xpath = "//input[@id='productKey3']")
    public WebElement licCodeThree;

    // License code field Four
    @FindBy(xpath = "//input[@id='productKey4']")
    public WebElement licCodeFour;

    // Continue in License code Page
    @FindBy(xpath = "//input[@id='submitme']")
    public WebElement continueInLicenseCodePage;

    //Alert when Invalid license code
    @FindBy(xpath="//body[@class='setup wp-core-ui'] //div //div //div //div //div //span[@id='fail']")
    public WebElement inValidLicenseCodeAlert;

    // Getting text of title for License code Page
    public String licenseCodePageTitle() {
        return this.licenseCodePageTitle.getText();
    }

    // Giving Inputs for LicenseCode
    public void enteringLicenseCode(String lOne, String lTwo, String lThree, String lFour) {
        this.licCodeOne.sendKeys(lOne);
        this.licCodeTwo.sendKeys(lTwo);
        this.licCodeThree.sendKeys(lThree);
        this.licCodeFour.sendKeys(lFour);
    }

    // Clicking on Continue In LicenseCode Page
    public void continueInLicenseCodePage() {
        this.continueInLicenseCodePage.click();
    }

    /* FINAL PAGE */

    // Title for the final page {Your Helpdesk is Ready!}
    @FindBy(xpath = "//div[@class='setup-content'] //h1[contains(text(),'Your Helpdesk is Ready!')]")
    public WebElement finalPageTitle;

    // Continue Button In FinalPage
    @FindBy(xpath = "//div[@class='setup-next-steps'] //div //ul //li[@class='setup-product'] //a")
    public WebElement continueInFinalPage;

    // Getting text of title for Final Page
    public String finalPageTitle() {
        return this.finalPageTitle.getText();
    }

    // Clicking on Continue In Final Page
    public void continueInFinalPage() {
        this.continueInFinalPage.click();
    }
}
