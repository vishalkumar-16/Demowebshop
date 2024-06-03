package food;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LaunchKFC_Test {
	
	@Test
	public void kfc() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://online.kfc.co.in/");
		Thread.sleep(2000);
		driver.manage().window().minimize();
		driver.quit();
	}

}
