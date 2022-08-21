package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement loginlink = driver.findElement(By.linkText("Log in"));
		loginlink.click();
		
		WebElement username = driver.findElement(By.name("user_login"));
		username.sendKeys("abc@xyz.com");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Test@123");
		WebElement remember = driver.findElement(By.className("rememberMe"));
		remember.click();
		WebElement loginbutton = driver.findElement(By.name("btn_login"));
		loginbutton.click();
		
		WebElement error = driver.findElement(By.id("msg_box"));
		String acterror = error.getText();
		String experror = "The email or password you have entered is invalid.";
		if (acterror.equals(experror)) {
			System.out.println("Test Case passed");
		}
		else {
			System.out.println("Test Case failed");
		}
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total Number of size are: " + links.size());
		
		for(int i = 0; i<links.size(); i++) {
			System.out.println(links.get(i).getAttribute("href"));
		}
		driver.close();
	}

}
