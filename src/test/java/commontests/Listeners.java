package commontests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.Base;

public class Listeners extends Base implements ITestListener{
    ExtentTest test;
    ExtentReports extent = ExtentReporterNG.getReportObject();
    //For parallel execution we are creating this
    ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();


    public void onTestStart(ITestResult result) {
        // Before executing test control will come here, so we are adding extent reports here
        test= extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    public void onTestSuccess(ITestResult result) {
        // It enters when test is success
        extentTest.get().log(Status.PASS, "Test Passed");

    }


    public void onTestFailure(ITestResult result) {
        //capturing test name and Code to Capture Screenshot
        //Below is to get the driver instance
        extentTest.get().fail(result.getThrowable());
        WebDriver driver =null;
        String testMethodName =result.getMethod().getMethodName();


        try {
            driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch(Exception e)
        {

        }
        try {
            extentTest.get().addScreenCaptureFromPath(getScreenshotPath(testMethodName, driver), result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    public void onFinish(ITestContext context) {
        // Once all tests are done we are flushing
        extent.flush();

    }

}