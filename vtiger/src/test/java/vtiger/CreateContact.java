package vtiger;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {
	@Test
	public void creatcontact()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("http://localhost/vtigercrm");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//div[@id='appnavigator']/child::div")).click();
		driver.findElement(By.xpath("//div[@class='app-list row']/descendant::span[text()=' MARKETING']")).click();
		driver.findElement(By.xpath("//div[@id='mCSB_1_container']/descendant::span[text()=' Contacts']")).click();
		driver.findElement(By.id("Contacts_listView_basicAction_LBL_ADD_RECORD")).click();
		driver.findElement(By.id("Contacts_editView_fieldName_lastname")).sendKeys("Karun");
		driver.findElement(By.name("mailingstreet")).sendKeys("mysore");
		driver.findElement(By.id("Contacts_editView_fieldName_support_end_date")).click();
		driver.findElement(By.xpath("//td[@class='day' and text()='20']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();


		//verification
		WebElement name = driver.findElement(By.xpath("//span[@class='value textOverflowEllipsis' and @title='Karun']"));
		String addedcontact = name.getText();
		System.out.println(addedcontact);
		String contactname="Karun";
		Assert.assertEquals(contactname,addedcontact);
		System.out.println("contact created");

		driver.close();
	}

}
