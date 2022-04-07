package installationtests;

import commontests.ExcelData;
import installationpages.InstallationBasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import resources.Base;

import java.io.IOException;

public class InstallationViaGuiTest extends Base {
    public static Logger log = LogManager.getLogger(InstallationViaGuiTest.class.getName());
    public WebDriver driver;
    String validDbUserName = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 4, 4);
    String passwordValid = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 4, 5);


    String firstName = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 4, 6);
    String lastName = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 4, 7);
    String email = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 4, 8);
    String emailWrongFormat = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 10, 8);

    String userName = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 4, 9);
    String password = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 4, 10);
    String confirmPassword = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 4, 11);
    String confirmPasswordMismatch = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 9, 11);

    String timeZoneAsia = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 4, 12);
    String timeZoneDubai = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 5, 12);

    String languageGerman = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 4, 13);
    String languageArabic = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 5, 13);

    String environmentProd = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 4, 14);
    String environmentDev = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 5, 14);

    String storageS3 = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 6, 15);
    String storageSys = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 4, 15);
    String accessKeyId = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 6, 16);
    String secretAccessKey = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 6, 17);
    String defaultRegion = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 6, 18);
    String bucket = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 6, 19);
    String endPoint = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 6, 20);
    String wrongDefaultRegion = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 13, 18);

    // LICENSE CODE DATA READING FROM EXCEL
    String lOne = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 4, 21);
    String lTwo = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 4, 22);
    String lThree = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 4, 23);
    String lFour = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 4, 24);

    String lOneInvalid = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 8, 21);
    String lTwoInvalid = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 8, 22);
    String lThreeInvalid = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 8, 23);
    String lFourInvalid = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 8, 24);


    String inValidDbUserName = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 11, 4);

    String passwordInvalid = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "installation", 12, 5);


    InstallationBasePage ibp = new InstallationBasePage(null);

    // Initialize browser and open URL
    @BeforeTest(alwaysRun = true)
    public void initializeB() throws IOException, InterruptedException {
        driver = initializeDriver();
        log.info("Browser Initialized");
        driver.get(prop.getProperty("url"));
        log.info("Navigated to homepage");
        Thread.sleep(5000);
    }


    // Checking the ProbePage
    @Test
    public void probePageCheck() {
        this.ibp = new InstallationBasePage(driver);
        log.info("Title for the Probe Page is" + " " + this.ibp.probePageTitle());
        this.scrollDown();
        try {
            this.ibp.probeContinueButtonEnabledCheck();
            this.ibp.probeContinueButtonClick();
        } catch (Exception e) {
            Boolean probeContinueButton = this.ibp.probeContinueButtonDisabled();
            log.warn("probeContinueButton is " + " " + probeContinueButton);
            log.error("Unable to continue installation as" + " " + this.ibp.probeAlert.getText());
        }
    }

    @Test(dependsOnMethods = {"probePageCheck"})
    public void licensePageCheck() {
        log.info("Title for the License Agreement Page is" + " " + this.ibp.licenseAgreementTitle());
        if (!this.ibp.continueAfterLicAgreement.isEnabled()) {
            this.ibp.continueAfterLicAgreement();
            Boolean licAgreementContinueButton = this.ibp.checkContinueButtonWithoutAcceptingLicAgreement();
            log.info("licAgreementContinueButton enabled is " + " " + licAgreementContinueButton);
            Assert.assertFalse(licAgreementContinueButton);
            log.info("Unable to continue Lic Agreement as Lic Agreement is not accepted so continue button enabled is" + " "
                    + false);
        }
        this.ibp.enableCheckboxForLicense();
        this.ibp.continueAfterLicAgreement();

    }

    @Test(dependsOnMethods = {"probePageCheck"})
    public void licensePageCheckInvalid() {
        log.info("Title for the License Agreement Page is" + " " + this.ibp.licenseAgreementTitle());
        this.ibp.continueAfterLicAgreement();
        Boolean licAgreementContinueButton = this.ibp.checkContinueButtonWithoutAcceptingLicAgreement();
        log.info("licAgreementContinueButton enabled is " + " " + licAgreementContinueButton);
        Assert.assertFalse(licAgreementContinueButton);
        log.error("Unable to continue Lic Agreement as Lic Agreement is not accepted so continue button enabled is" + " "
                + false);
    }

    // Getting title for DBSetUpPage
    @Test(dependsOnMethods = {"licensePageCheck"})
    public void dbSetUpPageGetTitleTest() {
        log.info("Title for the DB Setup Page is" + " " + this.ibp.dbSetupTitle());
    }

    @Test(dependsOnMethods = {"dbSetUpPageGetTitleTest"})
    @Parameters("dbNameWithDummyData")
    public void givingDbSetUpAndContinuingWithDummyData(String dbNameWithDummyData) {
        this.ibp.enteringInputsInDBSetUpPage("", "", dbNameWithDummyData, validDbUserName, passwordValid);
        this.ibp.clickCheckboxForDummyData();
        this.ibp.continueAfterDBSetUp();
    }


    // Giving Valid Inputs for DB without Dummy Data
    @Test(dependsOnMethods = {"dbSetUpPageGetTitleTest"})
    @Parameters("dbName")
    public void givingDbSetUpAndContinuingWithOutDummyData(String dbName) {
        this.ibp.enteringInputsInDBSetUpPage("", "", dbName, validDbUserName, passwordValid);
        this.ibp.continueAfterDBSetUp();
    }

    // Giving Invalid Inputs(existing db) for DB without Dummy Data
    @Test(dependsOnMethods = {"dbSetUpPageGetTitleTest"})
    @Parameters("dbNameDuplicate")
    public void givingInvalidDbNameAndContinuingWithOutDummyData(String dbNameDuplicate) {
        this.ibp.enteringInputsInDBSetUpPage("", "", dbNameDuplicate, validDbUserName, passwordValid);
        this.ibp.continueAfterDBSetUp();
    }


    // Giving Invalid Inputs(Invalid Username) for DB without Dummy Data
    @Test(dependsOnMethods = {"dbSetUpPageGetTitleTest"})
    @Parameters("dbNameForInvalidDBUsername")
    public void givingInvalidDBUserNameAndContinuingWithOutDummyData(String dbNameForInvalidDBUsername) {
        this.ibp.enteringInputsInDBSetUpPage("", "", dbNameForInvalidDBUsername, inValidDbUserName, passwordValid);
        this.ibp.continueAfterDBSetUp();
    }

    // Giving Invalid Inputs(Invalid password) for DB without Dummy Data
    @Test(dependsOnMethods = {"dbSetUpPageGetTitleTest"})
    @Parameters({"dbNameForInvalidDBPassword"})
    public void givingInvalidDbPasswordAndContinuingWithOutDummyData(String dbNameForInvalidDBPassword) {
        this.ibp.enteringInputsInDBSetUpPage("", "", dbNameForInvalidDBPassword, validDbUserName, passwordInvalid);
        this.ibp.continueAfterDBSetUp();
        log.error(this.ibp.passwordMismatch.getText());
    }

    // Starting with the dbSetupConfirmationpage
    @Test(dependsOnMethods = {"dbSetUpPageGetTitleTest"})
    public void dbSetUpConfirmationPage() throws InterruptedException {
        log.info("Title for the DB Setup Confirmation Page is" + " " + this.ibp.dbSetupConfirmationTitle());
        Thread.sleep(10000);
        this.scrollDown();
        if (!this.ibp.continueAfterDBSetUpConfirmationFailedLogging()) {
            log.error(this.ibp.errorLoggingWhenDBConnectionFailed() + " " + "Please refer screenshot for more details");

        }
        this.ibp.continueAfterDBSetUpConfirmation();
    }

    // Starting with the GettingStartedPage, getting title
    @Test(dependsOnMethods = {"dbSetUpConfirmationPage"})
    public void gettingStartedPageGetTitleTest() {
        log.info("Title for the Getting Started Page is" + " " + this.ibp.gettingStartedPageTitle());

    }

    // Entering Valid Inputs with Storage as System
    @Test(dependsOnMethods = {"gettingStartedPageGetTitleTest"})

    public void enteringAdminDetailsWithSystemStorageInGettingStartedPage() {
        this.ibp.enteringAdminInputs(firstName, lastName, email, userName, password, confirmPassword);
        this.scrollDown();
        this.ibp.selectingTimezone(timeZoneDubai);
        this.ibp.selectingLanguage(languageArabic);
        this.ibp.selectingEnvironment(environmentDev);
        this.ibp.selectingDefStorageDriverField(storageSys);
        this.ibp.continueInGettingStartedPage();
    }


    // Entering Valid Inputs with Storage as S3
    @Test(dependsOnMethods = {"gettingStartedPageGetTitleTest"})

    public void enteringAdminDetailsWithS3StorageInGettingStartedPage() {
        this.ibp.enteringAdminInputs(firstName, lastName, email, userName, password, confirmPassword);
        this.scrollDown();
        this.ibp.selectingTimezone(timeZoneAsia);
        this.ibp.selectingLanguage(languageGerman);
        this.ibp.selectingEnvironment(environmentProd);
        this.ibp.selectingDefStorageDriverField(storageS3);
        this.ibp.enteringS3Details(accessKeyId, secretAccessKey, defaultRegion, bucket, endPoint);
        this.ibp.continueInGettingStartedPage();
    }

    // Entering Invalid Inputs(Email wrong format) with Storage as System
    @Test(dependsOnMethods = {"gettingStartedPageGetTitleTest"})
    public void enteringAdminInvalidEmailFormatDetailsWithSystemStorageInGettingStartedPage() {
        this.ibp.enteringAdminInputs(firstName, lastName, emailWrongFormat, userName, password, confirmPassword);
        this.scrollDown();
        this.ibp.selectingTimezone("");
        this.ibp.selectingLanguage("");
        this.ibp.selectingEnvironment("");
        this.ibp.selectingDefStorageDriverField("");
        this.ibp.continueInGettingStartedPage();
        if (this.ibp.gettingEmailWrongPattern()) {
            log.error("Email format given for Admin is Wrong");
        }

    }

    // Entering Invalid Inputs(Mismatch Of Passwords) with Storage as System
    @Test(dependsOnMethods = {"gettingStartedPageGetTitleTest"})

    public void enteringAdminDetailsWithMismatchPasswordAndSystemStorageInGettingStartedPage() {
        this.ibp.enteringAdminInputs(firstName, lastName, email, userName, password, confirmPasswordMismatch);
        this.scrollDown();
        this.ibp.selectingTimezone("");
        this.ibp.selectingLanguage("");
        this.ibp.selectingEnvironment("");
        this.ibp.selectingDefStorageDriverField("");
        this.ibp.continueInGettingStartedPage();
        log.error(this.ibp.gettingPasswordMismatchAlert());
    }

    // Entering Invalid Input of default region with Storage as S3
    @Test(dependsOnMethods = {"gettingStartedPageGetTitleTest"})

    public void enteringAdminDetailsWithS3StorageInvalidDefaultRegionInGettingStartedPage() {
        this.ibp.enteringAdminInputs(firstName, lastName, email, userName, password, confirmPassword);
        this.scrollDown();
        this.ibp.selectingTimezone(timeZoneAsia);
        this.ibp.selectingLanguage(languageGerman);
        this.ibp.selectingEnvironment(environmentProd);
        this.ibp.selectingDefStorageDriverField(storageS3);
        this.ibp.enteringS3Details(accessKeyId, secretAccessKey, wrongDefaultRegion, bucket, endPoint);
        this.ibp.continueInGettingStartedPage();
        log.error(this.ibp.gettingS3DetailsInvalidAlert());
    }

    // Getting title for the License Code Page
    @Test(dependsOnMethods = {"gettingStartedPageGetTitleTest"})
    public void licenseCodePageGetTitleTest() {
        log.info("Title for the License Code Page is" + " " + this.ibp.licenseCodePageTitle());
    }

    // Entering Valid License Code
    @Test(dependsOnMethods = {"licenseCodePageGetTitleTest"})
    public void enteringValidLicenseCodeDetailsInGettingStartedPage() {
        this.ibp.enteringLicenseCode(lOne, lTwo, lThree, lFour);
        this.ibp.continueInLicenseCodePage();
        try {
            this.ibp.finalPageTitle();
        } catch (Exception e) {
            log.error(this.ibp.inValidLicenseCodeAlert.getText());
        }
    }

    // Entering Invalid License Code
    @Test(dependsOnMethods = {"licenseCodePageGetTitleTest"})
    public void enteringInvalidLicenseCodeDetailsInGettingStartedPage() {
        this.ibp.enteringLicenseCode(lOneInvalid, lTwoInvalid, lThreeInvalid, lFourInvalid);
        this.ibp.continueInLicenseCodePage();
        log.error(this.ibp.inValidLicenseCodeAlert.getText());
    }

    // Getting title for the Final Page
    @Test(dependsOnMethods = {"licenseCodePageGetTitleTest"})
    public void finalPageGetTitleTest() {
        log.info("Title for the Final Page is" + " " + this.ibp.finalPageTitle());
    }

    // Getting title for the Final Page
    @Test(dependsOnMethods = {"finalPageGetTitleTest"})
    public void continueAndInstallationDone() {
        this.ibp.continueInFinalPage();
    }

    @AfterTest(alwaysRun = true)
    public void teardown() {
        driver.close();
    }
}
