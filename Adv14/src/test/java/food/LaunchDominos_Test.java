package food;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LaunchDominos_Test {
	
	@Test
	public void dominos() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		//String url = System.getProperty("url");
		//driver.get(url);
		
		driver.get("https://pizzaonline.dominos.co.in/");
		Thread.sleep(2000);
		driver.manage().window().minimize();
		driver.quit();
	}

}
