package test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowNTabExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		String parentWin = driver.getWindowHandle();
		System.out.println("Before clicking tab: " + parentWin);
		
		WebElement Tab = driver.findElement(By.id("tabButton"));
		Tab.click();
		Set<String> allwin = driver.getWindowHandles();
		
		for(String win : allwin) {
			System.out.println("After clicking tab" + win);
			
			if(!win.equals(parentWin))
			{
				driver.switchTo().window(win);
				
			}
		}
		
		WebElement childHeader = driver.findElement(By.id("sampleHeading"));
		System.out.println(childHeader.getText());
		//driver.close();
		
		driver.switchTo().window(parentWin);
		WebElement window = driver.findElement(By.id("windowButton"));
		window.click();
		
		driver.quit();
		
	}

}
