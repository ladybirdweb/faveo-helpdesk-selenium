package clientpaneltests;

import clientpanelpages.ClientPanelRegisterPage;
import commontests.ExcelData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Base;

import java.io.IOException;
import java.sql.ResultSet;

import static junit.framework.Assert.assertTrue;

public class ClientPanelRegisterTest extends Base {

    public static Logger log = LogManager.getLogger(ClientPanelRegisterTest.class.getName());
    public WebDriver driver;

    String firstName_one = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 5, 1);
    String lastName_one = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 5, 2);

    String firstName_two = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 6, 1);
    String lastName_two = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 6, 2);
    String userName_two = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 6, 3);
    String workPhone_two = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 6, 4);
    String mobilePhone_two = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 6, 5);
    String address_two = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 6, 6);


    String firstName_three = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 7, 1);
    String lastName_three = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 7, 2);
    String userName_three = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 7, 3);
    String workPhone_three = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 7, 4);
    String mobilePhone_three = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 7, 5);
    String address_three = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 7, 6);
    String textfieldofRFB_three = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 7, 9);


    String firstName_four = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 8, 1);
    String lastName_four = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 8, 2);
    String userName_four = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 8, 3);
    String workPhone_four = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 8, 4);
    String mobilePhone_four = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 8, 5);
    String address_four = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 8, 6);
    String textfieldofRFB_four = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 8, 9);

    String lastName_five = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 9, 2);

    String firstName_six = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 10, 1);
    String lastName_six = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 10, 2);
    String userName_six = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 10, 3);
    String workPhone_six = ExcelData.getCellValue("./data/faveofinalsheet2021.xlsx", "register", 10, 4);


    ClientPanelRegisterPage cprp  = new ClientPanelRegisterPage(null);


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
    public void navigatingToRegister() {
        this.cprp = new ClientPanelRegisterPage(driver);
        this.cprp.clickOnRegisterOfHomePage();
    }
    @Test
    public void registerWithDefaultFieldsAndMandatory() {
        this.cprp = new ClientPanelRegisterPage(driver);
        this.cprp.enterTextField(textfieldofRFB_three);
        this.cprp.firstNameOfRFB.sendKeys(firstName_one);
        this.cprp.lastNameOfRFB.sendKeys(lastName_one);
        this.cprp.enterEmail();
        this.cprp.submittingRegister();
        String actualAlert = this.cprp.userCreatedSuccessText();
        String expectedAlert = "New user sucessfully created";
        log.info(actualAlert);
        Assert.assertEquals(actualAlert,expectedAlert);
    }

    @Test
    public void registerWithDefaultFieldsAlongNonMandatory() {
        this.cprp = new ClientPanelRegisterPage(driver);
        this.cprp.enterTextField(textfieldofRFB_three);
        this.cprp.enterFirstName(firstName_two);
        this.cprp.enterLastName(lastName_two);
        this.cprp.enterEmail();
        this.cprp.enterUserName(userName_two);
        this.cprp.enterWorkPhone(workPhone_two);
        this.cprp.enterMobile(mobilePhone_two);
        this.cprp.enterAddress(address_two);
        this.cprp.submittingRegister();
        String actualAlert = this.cprp.userCreatedSuccessText();
        String expectedAlert = "New user sucessfully created";
        log.info(actualAlert);
        Assert.assertEquals(actualAlert,expectedAlert);

    }

    @Test
    public void registerWithDefaultFieldsAlongCustomFields() {
        this.cprp = new ClientPanelRegisterPage(driver);
        this.cprp.enterTextField(textfieldofRFB_three);
        this.cprp.selectOption1();
        this.cprp.radioOfRFB_Option1.click();
        this.cprp.checkboxOfRFB_Option2.click();
        this.cprp.checkboxOfRFB_Option3.click();
        this.cprp.enterFirstName(firstName_three);
        this.cprp.enterLastName(lastName_three);
        this.cprp.enterEmail();
        this.cprp.enterUserName(userName_three);
        this.cprp.enterWorkPhone(workPhone_three);
        this.cprp.enterMobile(mobilePhone_three);
        this.cprp.enterAddress(address_three);
        this.cprp.submittingRegister();
        String actualAlert = this.cprp.userCreatedSuccessText();
        String expectedAlert = "New user sucessfully created";
        log.info(actualAlert);
        Assert.assertEquals(actualAlert,expectedAlert);
    }

    @Test
    public void registerWithDefaultFieldsAlongCustomFieldsAndOrganization(){
        this.cprp = new ClientPanelRegisterPage(driver);
        this.cprp.enterTextField(textfieldofRFB_four);
        this.cprp.selectOption3();
        this.cprp.radioOfRFB_Option2.click();
        this.cprp.checkboxOfRFB_Option1.click();
        this.cprp.enterFirstName(firstName_four);
        this.cprp.enterLastName(lastName_four);
        this.cprp.enterEmail();
        this.cprp.enterUserName(userName_four);
        this.cprp.enterWorkPhone(workPhone_four);
        this.cprp.enterMobile(mobilePhone_four);
        this.cprp.enterAddress(address_four);
        this.cprp.selectOrganizationOption2();
        this.cprp.submittingRegister();
        String actualAlert = this.cprp.userCreatedSuccessText();
        String expectedAlert = "New user sucessfully created";
        log.info(actualAlert);
        Assert.assertEquals(actualAlert,expectedAlert);
    }

    @Test
    public void registerWithDefaultFieldsAsNull() {
        this.cprp = new ClientPanelRegisterPage(driver);
        this.cprp.enterTextField(textfieldofRFB_four);
        this.cprp.enterFirstName("");
        this.cprp.enterLastName(lastName_five);
        this.cprp.enterEmail();
        this.cprp.submittingRegister();
        String actualAlert = this.cprp.firstNameNULLAlert();
        log.info(actualAlert);
        assertTrue(actualAlert.contains("This field is required"));
    }

    @Test
    public void registerWithWrongInputInWorkPhone() {
        this.cprp = new ClientPanelRegisterPage(driver);
        this.cprp.enterTextField(textfieldofRFB_four);
        this.cprp.enterFirstName(firstName_six);
        this.cprp.enterLastName(lastName_six);
        this.cprp.enterEmail();
        this.cprp.enterUserName(userName_six);
        this.cprp.enterWorkPhone(workPhone_six);
        this.cprp.submittingRegister();
        String actualAlert = this.cprp.alertValueWorkPhone();
        String expectedAlert = "The phone number must be between 1 and 20 digits.";
        log.info(actualAlert);
        Assert.assertEquals(actualAlert,expectedAlert);
    }

    @AfterTest(alwaysRun = true)
    public void teardown() {
        driver.close();
    }

}
