package clientpanelpages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.util.Random;

public class ClientPanelRegisterPage {

    Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(1000);
    //*NOTE* PLEASE MAKE SURE THE ID'S OF CUSTOM FIELDS ARE MATCHING THE INSTANCE YOU ARE EXECUTING //

    @FindBy(xpath="//div[@id='corewidgetbox'] //div //span //a[@id='client_widget_register']")
    public WebElement registerOfClientPanel;

    @FindBy(xpath="//input[@id='custom_54']")
    public WebElement textfieldOfRFB;

    @FindBy(xpath="//div[@class='vs__selected-options'] //input[@id='custom_55']")
    public WebElement selectOfRFB;

    @FindBy(xpath="//ul [@id='vs1__listbox'] //li[@id='vs1__option-0']")
    public WebElement s1OfSelectOfRFB;

    @FindBy(xpath="//ul [@id='vs1__listbox'] //li[@id='vs1__option-1']")
    public WebElement s2OfSelectOfRFB;

    @FindBy(xpath="//ul [@id='vs1__listbox'] //li[@id='vs1__option-2']")
    public WebElement s3OfSelectOfRFB;


    @FindBy(xpath="//div[@id='custom_56'] //div[2] //div //div //div[1] //label //input[@type='radio'] ")
    public WebElement radioOfRFB_Option1;

    @FindBy(xpath="//div[@id='custom_56'] //div[2] //div //div //div[2] //label //input[@type='radio'] ")
    public WebElement radioOfRFB_Option2;

    @FindBy(xpath="//div[@id='custom_56'] //div[2] //div //div //div[3] //label //input[@type='radio'] ")
    public WebElement radioOfRFB_Option3;


    @FindBy(xpath="//div[@id='custom_57'] //div[2] //div //div //div[1] //label //input[@type='checkbox']")
    public WebElement checkboxOfRFB_Option1;

    @FindBy(xpath="//div[@id='custom_57'] //div[2] //div //div //div[2] //label //input[@type='checkbox']")
    public WebElement checkboxOfRFB_Option2;

    @FindBy(xpath="//div[@id='custom_57'] //div[2] //div //div //div[3] //label //input[@type='checkbox']")
    public WebElement checkboxOfRFB_Option3;

    @FindBy(xpath="//input[@id='first_name']")
    public WebElement firstNameOfRFB;

    @FindBy(xpath="//input[@id='last_name']")
    public WebElement lastNameOfRFB;

    @FindBy(xpath="//input[@id='user_name']")
    public WebElement userNameOfRFB;

    @FindBy(xpath="//input[@id='phone_number']")
    public WebElement workPhoneOfRFB;

    @FindBy(xpath="//input[@id='email']")
    public WebElement emailOfRFB;

    @FindBy(xpath="//input[@id='mobile']")
    public WebElement mobileOfRFB;

    @FindBy(xpath="//div //textarea[@id='address']")
    public WebElement addressOfRFB;

    @FindBy(xpath="//div[@class='vs__selected-options'] //input[@id='organisation']")
    public WebElement organizationOfRFB;

    @FindBy(xpath="//ul[@id='vs2__listbox'] //li[@id='vs2__option-0']")
    public WebElement organizationOption1;

    @FindBy(xpath="//ul[@id='vs2__listbox'] //li[@id='vs2__option-1']")
    public WebElement organizationOption2;

    @FindBy(xpath="//div //button[@id='client_form_submit']")
    public WebElement submitOfRegisterRFB;

    @FindBy(xpath="//div //span[text()='New user sucessfully created']")
    public WebElement userCreatedSuccess;

    @FindBy(xpath="//div[@id='First Name']")
    public WebElement alertForNullValueWithFirstName;

    @FindBy(xpath="//span //span[@class='error-block is-danger']")
    public WebElement alertValue;

    @FindBy(xpath="//span //div[text()='The phone number must be between 1 and 20 digits.']")
    public WebElement workPhoneValidationAlert;

    @FindBy(xpath="//div //div[2] //span //div[text()='The mobile has already been taken.']")
    public WebElement mobileDuplicateAlert;



    public String userCreatedSuccessText(){
        return this.userCreatedSuccess.getText();
    }

    public String firstNameNULLAlert(){
        return this.alertForNullValueWithFirstName.getText();
    }

    public String alertValueWorkPhone(){
        return this.workPhoneValidationAlert.getText();
    }

    public String alertValueDuplicateMobile(){

        return this.mobileDuplicateAlert.getText();
    }

    public ClientPanelRegisterPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    public void clickOnRegisterOfHomePage(){
        this.registerOfClientPanel.click();
    }

    public void enterFirstName(String firstName){

        this.firstNameOfRFB.sendKeys(firstName);
    }

    public void enterLastName(String lastName){

        this.lastNameOfRFB.sendKeys(lastName);
    }

    public void enterUserName(String userName){
        this.userNameOfRFB.sendKeys(userName+ randomInt);
    }

    public void enterWorkPhone(String workPhone){
        this.workPhoneOfRFB.sendKeys(workPhone);
    }

    public void enterEmail(){
        this.emailOfRFB.sendKeys("email"+ randomInt +"@gmail.com");
    }

    public void enterMobile(String mobile){

        this.mobileOfRFB.sendKeys(mobile + randomInt);
    }

    public void enterAddress(String address){

        this.addressOfRFB.sendKeys(address);
    }

    public void enterTextField(String textfieldOfRFB){

        this.textfieldOfRFB.sendKeys(textfieldOfRFB+randomInt);
    }
    public void selectOrganizationOption1() {
        this.organizationOfRFB.click();
        this.organizationOption1.click();

    }

    public void selectOrganizationOption2() {
        this.organizationOfRFB.click();
        this.organizationOption2.click();

    }

    public void selectOption1(){
        this.selectOfRFB.click();
        this.s1OfSelectOfRFB.click();

    }

    public void selectOption2(){
        this.selectOfRFB.click();
        this.s2OfSelectOfRFB.click();

    }

    public void selectOption3(){
        this.selectOfRFB.click();
        this.s3OfSelectOfRFB.click();

    }


    public void selectRadioOption1(){

        this.radioOfRFB_Option1.click();
    }

    public void selectRadioOption2(){

        this.radioOfRFB_Option2.click();
    }

    public void selectRadioOption3(){

        this.radioOfRFB_Option3.click();
    }

    public void selectCheckboxOption1(){
        this.checkboxOfRFB_Option1.click();
    }

    public void selectCheckboxOption2(){
        this.checkboxOfRFB_Option2.click();
    }

    public void selectCheckboxOption3(){
        this.checkboxOfRFB_Option3.click();
    }

    public void submittingRegister(){
        this.submitOfRegisterRFB.click();
    }



}
