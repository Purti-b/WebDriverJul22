package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		WebElement button1 = driver.findElement(By.id("alertButton"));
		button1.click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		WebElement button3 = driver.findElement(By.id("confirmButton"));
		button3.click();
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.dismiss();
		
		WebElement button4 = driver.findElement(By.id("promtButton"));
		button4.click();
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.sendKeys("Hello World");
		alert.accept();
	}

}
