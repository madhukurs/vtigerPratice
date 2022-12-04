package vtiger;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickOnProductPage {
	@Test
	public void productPage() throws InterruptedException
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("http://localhost/vtigercrm");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.id("appnavigator")).click();
		driver.findElement(By.xpath("//div[@class='app-list row']/descendant::span[text()=' INVENTORY']")).click();
		Thread.sleep(3000);
		WebElement mouse = driver.findElement(By.xpath("//div[@id='mCSB_3_container']/descendant::span[text()=' Products']"));
		System.out.println(driver.getCurrentUrl());
		Actions act = new Actions(driver);
		act.moveToElement(mouse).perform();
		mouse.click();
		
		//how to validate blank page...?


		//		JavascriptExecutor js=(JavascriptExecutor)driver;
		//		js.executeAsyncScript("arguments[0].click()",mouse);



	}

}
