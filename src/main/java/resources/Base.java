package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;

public class Base {
    public WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
                "/src/main/java/resources/data.properties");
        prop.load(fis);

        String browserName = prop.getProperty("browser");

        if(browserName.contains("chrome")){
            System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir")+
                            "/src/main/java/resources/chromedriver");
            driver = new ChromeDriver();
        }
        else if(browserName.equals("firefox")){
            setProperty("webdriver.geckodriver.driver",System.getProperty("user.dir")+
                    "/src/main/java/resources/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;

    }
    private static final int DELAY = 5;
    protected WebDriverWait webDriverWait;

    public void ExplicitVisibilityWait() {
        webDriverWait = new WebDriverWait(driver, DELAY);
    }

    public WebElement waitForVisibilityOfElementLocatedBy(final By locator){
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        Date date = new Date();
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "/screenshots/" + testCaseName + "_" +dateFormat.format(date)+ ".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,9000)");
        return;
    }

    public void mouseOverActions(WebElement moa){
        Actions actions = new Actions(driver);
        actions.moveToElement(moa).perform();
        return;
    }

    public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
        // WebDriver driver =null;

        // Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

        // Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        // Move image file to new destination
        File DestFile = new File(fileWithPath);

        // Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);

    }
    public void changeControlToNewTabWhenLinkOpensInNewTab(int childId) {
        ArrayList<String> windowHandles = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(childId));

    }

    public void changeControlToParentTab(int parentId) {
        ArrayList<String> windowHandles = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(parentId));
    }
}
