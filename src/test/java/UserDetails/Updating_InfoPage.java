package UserDetails;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class Updating_InfoPage {

	public static void main(String[] args) throws InterruptedException {
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

		driver.findElement(By.xpath("//button[@type='submit'][text()=' Login ']")).click();


		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='My Info']")).click();
		
		Thread.sleep(3000);
		
		String x=" ";
		WebElement firstName=driver.findElement(By.xpath("//input[@name='firstName'][@placeholder='First Name']"));
		JavascriptExecutor js= driver;
		js.executeScript("arguments[0].value='"+x+"';",firstName);
		String x1="Aishwarya"; js.executeScript("arguments[0].value='"+x1+"';",firstName);
		
				
		WebElement lastName= driver.findElement(By.xpath("//input[@name='lastName']"));
		js.executeScript("arguments[0].value='"+x+"';",lastName);
		String x2="Ravichandran";
		js.executeScript("arguments[0].value='"+x2+"';",lastName);
		
				
		
		
        WebElement Employee_No=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[1]/div/div[2]/input"));
        js.executeScript("arguments[0].value='"+x+"';",Employee_No);
		String x3="1081098";
		js.executeScript("arguments[0].value='"+x3+"';",Employee_No);

	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//label[text()='Female']/span")).click();
	    driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();


	}



}
