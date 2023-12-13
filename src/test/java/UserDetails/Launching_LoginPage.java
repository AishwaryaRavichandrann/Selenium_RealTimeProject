package UserDetails;

import static org.testng.Assert.assertEquals;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

public class Launching_LoginPage {


	public static void main(String[] args) throws Exception {
		Launching_LoginPage lp= new Launching_LoginPage();
		lp.test();

	}

	public void test() throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\kisho\\OneDrive\\Desktop\\Selenium_Project\\Selenium_Practice\\src\\test\\resources\\webDrivers\\chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-orgins=*");
		
		ChromeDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(3000);

		// UserName 
		String UserName=driver.findElement(By.xpath("//p[text()='Username : Admin']")).getText();
		String actual_username=UserName.substring(UserName.indexOf("A"),UserName.length());
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(actual_username);

		// PassWord
		String PassWord=driver.findElement(By.xpath("//p[text()='Password : admin123']")).getText();
		String actual_password=PassWord.substring(PassWord.indexOf("ad"),PassWord.length());
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(actual_password);
		//System.out.println(actual_username+' '+actual_password);


		try {
			driver.findElement(By.xpath("//button[@type='submit'][text()=' Login ']")).click();
			Thread.sleep(2000);
			String Page_Title=driver.findElement(By.xpath("//header[@class='oxd-topbar']/div/div[1]/span/h6")).getText();
			assertEquals(Page_Title,"Dashboard");
			System.out.println("Logged in successfully");
		} catch (Exception e) {
			
			Thread.sleep(5000);
			TakesScreenshot ts= driver; 
			File sourceFile=ts.getScreenshotAs(OutputType.FILE);
			File destinationFile= new File("C:\\Users\\kisho\\OneDrive\\Desktop\\Personal_Project\\Demo_Project\\Error.png");
			FileHandler.copy(sourceFile, destinationFile);
			System.out.println("Screenshot is ready in the location");
		}
		
				
		//Thread.sleep(5000);
		driver.close();
}}
