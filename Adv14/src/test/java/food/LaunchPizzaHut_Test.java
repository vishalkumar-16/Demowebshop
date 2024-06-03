package food;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LaunchPizzaHut_Test {
	
	@Test
	public void pizzaHut() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.pizzahut.co.in/");
		Thread.sleep(2000);
		driver.manage().window().minimize();
		driver.quit();
	}

}
