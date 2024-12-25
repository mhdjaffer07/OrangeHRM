package orangehrm;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	@Nullable
	String currentUrl = driver.getCurrentUrl();
	String successfulLoginUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	if(currentUrl.equals(successfulLoginUrl))
		System.out.println("Login successful");
	else
		System.out.println("Login failed");
	System.out.println("Actual URL : "+currentUrl);
	System.out.println("Expected URL : "+successfulLoginUrl);
	driver.quit();
	}

}
