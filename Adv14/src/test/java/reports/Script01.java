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

public class Script01 {
	@Test
	public void script01() throws InterruptedException {
		WebDriver driver;
		ScreenshotMethod ss = new ScreenshotMethod();
		String dateTime = LocalDateTime.now().toString().replace(":", "-");
		ExtentReports reports = new ExtentReports();
		ExtentSparkReporter reporter = new ExtentSparkReporter("./reportFile/"+dateTime+".html");
		reports.attachReporter(reporter);
		ExtentTest test= reports.createTest("Books");
		driver= new FirefoxDriver();
		test.log(Status.INFO, "Firefox is launched");
		driver.manage().window().maximize();
		test.log(Status.INFO,"Browser is maximixed");
		driver.get("https://demowebshop.tricentis.com/");
		test.log(Status.INFO,"Demo web shop is launched");
		driver.findElement(By.linkText("Books")).click();
		test.log(Status.INFO,"Books button is clicked");
		driver.findElement(By.linkText("Computing and Internet")).click();
		test.log(Status.INFO,"clicked on computer and Internet Books");
		Thread.sleep(2000);
		driver.findElement(By.id("add-to-cart-button-13")).click();
		test.log(Status.INFO,"add to cart button is pressed");
		try {
			if (driver.getTitle().contains("Demo Web Shop. Compung and Internet")) {
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(ss.takeScreenshot(driver)).build());
					
			}
		} 
		catch (Exception e) {
			
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(ss.takeScreenshot(driver)).build());
		}
		reports.flush();
		
	}

}
