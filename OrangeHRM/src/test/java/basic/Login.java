package basic;

import java.util.concurrent.TimeUnit;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		Timeouts implicitlyWait = driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		try {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		@Nullable
		String currentUrl = driver.getCurrentUrl();
		String successfulUrl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		if(currentUrl.equals(successfulUrl))
			System.out.println("Login Successful");
		else
			System.out.println("Login Failed");
		}
		catch(Exception a)
		{
			a.printStackTrace();
		}
		finally {
			driver.quit();
		}
	}
}
