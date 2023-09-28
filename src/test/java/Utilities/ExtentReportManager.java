package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testBase.BaseClass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;
    String reportName;

    public void onStart(ITestContext context) {
        String timeStamp = new SimpleDateFormat("yyy.dd.HH.mm.ss").format(new Date());
        reportName = "Test-Report- At"+ timeStamp+".html";
        sparkReporter = new ExtentSparkReporter(".\\reports\\"+ reportName);
        sparkReporter.config().setDocumentTitle("Gurru Finance Automation");
        sparkReporter.config().setReportName("Gurru Finance-Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();

        extent.attachReporter(sparkReporter);


        extent.setSystemInfo("Application", "Gurru Finance");
        extent.setSystemInfo("Environment", "QA");
    }

    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.PASS, result.getName() + "Passed");
    }

    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, result.getName() + "Failed");
        test.log(Status.FAIL, result.getName() + "Fail cause is:" + result.getThrowable());
        try {
            String imgPath = new BaseClass().captureScreen(result.getName());
            test.addScreenCaptureFromPath(imgPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test Skipped");
        test.log(Status.SKIP, result.getThrowable().getMessage());

    }

    public void onFinish(ITestContext context) {
        extent.flush();
     }
}

