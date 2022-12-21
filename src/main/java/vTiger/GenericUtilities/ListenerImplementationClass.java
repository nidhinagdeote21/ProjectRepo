package vTiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * This class provides implementation to the ITestListener Interface of TestNG 
 * @author nidhi
 *
 */
public class ListenerImplementationClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
		public void onTestStart(ITestResult result)
		{
			String methodName = result.getMethod().getMethodName();
			System.out.println(methodName+" -------> test execution started");
			test = report.createTest(methodName);
		}
		public void onTestSuccess(ITestResult result)
		{
			String methodName = result.getMethod().getMethodName();
			//for listener without extent System.out.println(methodName+" -------> test execution successful");
			test.log(Status.PASS, methodName+"----> SUCCESS");
		}
		public void onTestFailure(ITestResult result)
		{
			WebDriverUtility wUtil=new WebDriverUtility();
			JavaUtility jUtil=new JavaUtility();
			String methodName = result.getMethod().getMethodName();
			//System.out.println(methodName+" -------> test execution failed");
			//System.out.println(result.getThrowable());
			test.log(Status.FAIL, methodName+"----> FAIL");
			test.log(Status.FAIL, result.getThrowable());
			
			String screenShotName = methodName+"-"+jUtil.getSystemDateInFormat();
			
			try {
				String path = wUtil.taketheScreenshot(BaseClass.sdriver, screenShotName);
				test.addScreenCaptureFromPath(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void onTestSkipped(ITestResult result)
		{
			String methodName = result.getMethod().getMethodName();
			//System.out.println(methodName+" -------> test execution skipped");
			test.log(Status.SKIP, methodName+"----> SKIPPED");
			test.log(Status.SKIP, result.getThrowable());
		}
		public void onStart(ITestContext context)
		{	//configure the report
			//create object of extent spark reporter class
			System.out.println("Execution Started");
			ExtentSparkReporter htmlreport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
			htmlreport.config().setDocumentTitle("Execution Report");
			htmlreport.config().setTheme(Theme.DARK);
			htmlreport.config().setReportName("vTiger Execution Report");
			
			//Attach the html report to Extent Report
			report = new ExtentReports();
			report.attachReporter(htmlreport);
			report.setSystemInfo("Base Platform", "Windows");
			report.setSystemInfo("Base Browser", "Firefox");
			report.setSystemInfo("Base Environment", "Testing");
			report.setSystemInfo("Base URL", "http://localhost:8888");
			report.setSystemInfo("Author", "Nidhi Nagdeote");
			
			
			
		}
		public void onFinish(ITestContext context)
		{
			System.out.println("Execution finished");
			
			//Flush the report - consolidate the status of every test script and generate the report
			report.flush();
		}
}
