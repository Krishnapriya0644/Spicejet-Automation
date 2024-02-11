package base;

import java.io.IOException;
import java.time.Duration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import utilities.Utility;

public class BaseClass extends Utility{

	Listeners listeners;
	@BeforeMethod	
	public void startup() throws IOException {
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(45));
		InilializeWebDriverWait();
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}
}
