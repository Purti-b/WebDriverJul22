package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement signupbutton = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		signupbutton.click();
		WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
		WebElement mobile = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password_step_input']"));
		
		firstname.sendKeys("NewTestUser");
		lastname.sendKeys("TestUserSurname");
		mobile.sendKeys("1234567890");
		password.sendKeys("abc@123");
		
		WebElement day = driver.findElement(By.name("birthday_day"));
		Select ddday = new Select(day);
		ddday.selectByVisibleText("4");
		
		WebElement month = driver.findElement(By.name("birthday_month"));
		Select ddmonth = new Select(month);
		ddmonth.selectByVisibleText("Sep");
		System.out.println("Selected month is: " + ddmonth.getFirstSelectedOption().getText());
		
		WebElement year = driver.findElement(By.name("birthday_year"));
		Select ddyear = new Select(year);
		ddyear.selectByVisibleText("1997");
		
	/*	List<WebElement> month1 =  ddmonth.getOptions();
		for(WebElement elm : month1) {
			System.out.println(elm.getText());
		} */
		
		List<WebElement> Allmonth = driver.findElements(By.xpath("//select[@name='birthday_month']/option"));
		for(WebElement elm : Allmonth) {
			System.out.println(elm.getText());
		}
		
		WebElement selected = driver.findElement(By.xpath("//select[@name='birthday_month']/option[@selected='1']"));
		System.out.println("Selected month is " + selected.getText());
		
		String Gender = "Female";
		
		// WebElement Female = driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));
		//WebElement Male = driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
		//WebElement Other = driver.findElement(By.xpath("//input[@type='radio' and @value='-1']"));
		
		//if(Gender.equals("Female")) {
		//	Female.click();
		//}else if(Gender.equals("Male")) {
		//	Male.click();
		//}else {
		//	Other.click();
		//} 
		
		WebElement gendersel = driver.findElement(By.xpath("//label[text()='" + Gender + "']/following-sibling::input"));
		gendersel.click();
	}

		
}
