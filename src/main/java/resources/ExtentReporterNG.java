package resources;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.IReporter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ExtentReporterNG implements IReporter {
        static ExtentReports extent;

        public static ExtentReports getReportObject() {
            //ExtentReports , ExtentSparkReporter
           String timestampforreport = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

            String path = System.getProperty("user.dir")+"/htmlreports/" + timestampforreport+ " " + ".html";

            ExtentSparkReporter reporter = new ExtentSparkReporter(path);  //Responsible for creating html file and to do some configurations
            reporter.config().setReportName("Web Automation Results");
            reporter.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Veera");
            return extent;

        }
    }
