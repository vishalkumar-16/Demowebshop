package reports;

import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LearningExtentReport {
	@Test
	
	public void script()  {
		WebDriver driver;
		ScreenshotMethod ss = new ScreenshotMethod();
	    String dateTime = LocalDateTime.now().toString().replace(":", "-");
	    ExtentReports reports= new ExtentReports();
	    ExtentSparkReporter reporter = new ExtentSparkReporter("./reportFile/"+dateTime+".html");
	    reports.attachReporter(reporter);
	    ExtentTest extentTest = reports.createTest("login");
	    driver= new FirefoxDriver();
	    extentTest.log(Status.INFO, "Browser is launched");
	    driver.manage().window().maximize();
	    extentTest.log(Status.INFO, "Browser is maximised");
	    driver.get("https://demowebshop.tricentis.com/");
	    extentTest.log(Status.INFO, "demo web shop is launched");
	    driver.findElement(By.linkText("Log in")).click();
	    extentTest.log(Status.INFO, "User clicked on log in button");
	    driver.findElement(By.id("Email")).sendKeys("bangalore541@gmail.com");
	    extentTest.log(Status.INFO, "User entered the email");
	    driver.findElement(By.id("Password")).sendKeys("bangalore123");
	    extentTest.log(Status.INFO, "User entered password");
	    driver.findElement(By.xpath("//input[@value='Log in']")).click();
	    extentTest.log(Status.INFO, "user has logined");
	    try {
		if (driver.findElement(By.linkText("Log out")).isDisplayed()) {
			extentTest.pass(MediaEntityBuilder.createScreenCaptureFromPath(ss.takeScreenshot(driver)).build());
			
		}	
		} catch (Exception e) {
			// TODO: handle exception
			extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(ss.takeScreenshot(driver)).build());
		}
	    reports.flush();
	    
		
	}

}
