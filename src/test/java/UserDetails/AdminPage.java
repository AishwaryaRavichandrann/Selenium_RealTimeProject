package UserDetails;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AdminPage {

	ChromeDriver driver= new ChromeDriver();
	public static void main(String[] args) throws Exception{
		
		AdminPage a = new AdminPage();
		a.LoginDetails();
		a.PIMDetails();
		a.AdminDetails();
//		a.fileRead();
		
		
	}
	
	public void LoginDetails() throws InterruptedException {
		
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(3000);

		// UserName 
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

		// PassWord
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit'][text()=' Login ']")).click();
		Thread.sleep(2000);
		
	}
	
	@SuppressWarnings("deprecation")
	public void PIMDetails() throws InterruptedException, Exception {
		
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
		
		Thread.sleep(3000);
		WebElement firstName=driver.findElement(By.xpath("//input[@name='firstName'][contains(@placeholder,'First')]"));
		firstName.sendKeys("Aishwarya");
		WebElement lastName= driver.findElement(By.xpath("//input[@name='lastName']"));
		lastName.sendKeys("Ravichandran");
		
		//js.executeScript("arguments[0].onchange();",Employee_No);
				
		
		driver.findElement(By.xpath("//img[@alt='profile picture'][@class='employee-image']")).click();
		StringSelection Profile_path= new StringSelection("C:\\Users\\kisho\\OneDrive\\Desktop\\Personal_Project\\Demo_Project\\Employee_profile.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Profile_path,null);
		
		Robot robot= new Robot();
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
				
		Thread.sleep(3000);
		
		// Save the Details
		
		driver.findElement(By.xpath("//button[@type='submit'][normalize-space(text()='Save')]")).click();
		
		Thread.sleep(5000);
		
		// Employee NO
		
//		WebElement Employee_No=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[1]/div/div[2]/input"));
//		JavascriptExecutor js= driver;
//		String x=" ";
//        js.executeScript("arguments[0].value='"+x+"';",Employee_No);
//        
//        Thread.sleep(1000);
//        
//		String x1="1081098";
//		js.executeScript("arguments[0].value='"+x1+"';arguments[0].dispatchEvent(new Event('change'));",Employee_No);
//		
		
		Thread.sleep(2000);
		// Driving License Number
		WebElement license_No= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/input"));
		license_No.sendKeys("BC 47 Q4567");
		
		Thread.sleep(1000);
		// License expiry
		
		
		WebElement Expiry_Date= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[2]/div/div[2]/div/div/input"));
		Expiry_Date.sendKeys("2023-12-29");
		
		Thread.sleep(1000);
		
		// SSN Number
		
		
		
		WebElement SSN_No= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[3]/div[1]/div/div[2]/input"));
		SSN_No.sendKeys("4598 2345");
		
		Thread.sleep(2000);
		
		// SIN Number
		WebElement SIN_No= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[3]/div[2]/div/div[2]/input"));
		SIN_No.sendKeys("000000");
		
		Thread.sleep(2000);
		// Nationality
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[1]/div/div[2]/div/div/div[1]")).click();
		
	    List<WebElement> Nationality=driver.findElements(By.xpath("//div[@role='listbox']//span"));
	    
	    for(WebElement e : Nationality) {
	    	String text=e.getText();
	    	if(text.contains("Indian")) {
	    		e.click();
	    		break;
	    	}
	    }
		Thread.sleep(2000);
		
		// Marital Status
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[2]/div/div[2]/div/div/div[1]")).click();

		List<WebElement> Status=driver.findElements(By.xpath("//div[@role='listbox']//span"));

		for(WebElement e : Status) {
			String text=e.getText();
			if(text.contains("Other")) {
				e.click();
				break;
			}
		}
		Thread.sleep(2000);
				
		
		// Date Of Birth
				
		WebElement DOB= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[1]/div/div[2]/div/div/input"));
		DOB.sendKeys("2000-05-02");
		
		// Gender
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/label/span")).click();
		
		
		// Military Service
		WebElement service= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/div/div[1]/div/div[2]/input"));
		service.sendKeys("No");
		
		Thread.sleep(2000);
		
		// Save
		
	    driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
	    
	    Thread.sleep(3000);
	    
	    //Scroll Up
	    
	    JavascriptExecutor Js = (JavascriptExecutor) driver;
		Js.executeScript("window.scrollBy(0,-document.body.scrollHeight)"); 
	    
		Thread.sleep(2000);
	    
	    //Job Details
	    WebElement contact_Details=driver.findElement(By.xpath("//a[text()='Job']"));
	    contact_Details.click();
	    Thread.sleep(2000);
	    
	    //Joined Date
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[1]/div/div[2]/div/div/input")).sendKeys("2019-12-09");
	      
	    Thread.sleep(2000);
	    
	    // Job Title
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]")).click();
	    List<WebElement> title_options= driver.findElements(By.xpath("//div[@role='listbox']//span"));
	    
	    for(WebElement titleName : title_options) {
	    	String text=titleName.getText();
	    	if(text.contains("QA Lead")) {
	    		titleName.click();
	    		break;
	    	}
	    }
	    Thread.sleep(2000);
		//Sub Unit
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[5]/div/div[2]/div/div/div[1]")).click();
		
	    List<WebElement> Sub_options=driver.findElements(By.xpath("//div[@role='listbox']//span"));
	    
	    for(WebElement e : Sub_options) {
	    	String text=e.getText();
	    	if(text.contains("Quality Assurance")) {
	    		e.click();
	    		break;
	    	}
	    }
//		WebElement Sub=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[5]/div/div[2]/div/div/div[1]"));
//		try {
//			Sub.click();
//		}
//		catch(StaleElementReferenceException e) {
//			Sub=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[5]/div/div[2]/div/div/div[1]"));
//			Sub.click();			
//		}
		
		Robot rb= new Robot();
			
		Thread.sleep(2000);
		//Employment Status
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[7]/div/div[2]/div/div/div[1]")).click();
		
		List<WebElement> Employment_options=driver.findElements(By.xpath("//div[@role='listbox']//span"));
		   
		for(WebElement e : Employment_options) {
		    String text=e.getText();
		    if(text.contains("Full-Time Permanent")) {
		    	e.click();
		    	break;
		    	}
		    }
		Thread.sleep(3000);
		
		
		//Save
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/button")).click();
		
		//Report to
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[9]/a")).click();
		
		// Add Button
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/button")).click();
		
		Thread.sleep(2000);
		// Name
		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("Paul");
		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		//Reporting Method
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]")).click();
		
		List<WebElement> Reporting_Method=driver.findElements(By.xpath("//div[@role='listbox']//span"));
		   
		for(WebElement e : Reporting_Method) {
		    String text=e.getText();
		    if(text.contains("Direct")) {
		    	e.click();
		    	break;
		    	}
		    }
		Thread.sleep(3000);
		
//		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]")).click();
//		Thread.sleep(2000);
//		rb.keyPress(KeyEvent.VK_DOWN);
//		rb.keyRelease(KeyEvent.VK_DOWN);
//		Thread.sleep(1000);
//		rb.keyPress(KeyEvent.VK_ENTER);
//		rb.keyRelease(KeyEvent.VK_ENTER);
		
		// Save
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/div[2]/button[2]")).click();
		
	}
	
	@SuppressWarnings("deprecation")
	public void AdminDetails() throws InterruptedException, AWTException {
		
		// Admin
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		
		// Add
		driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']//button//i[normalize-space(text()='Add')][1]")).click();
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		
		// User Role
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]")).click();
		
		Robot rb= new Robot();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);		
		
		// Employee Name
		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("Aishwarya");
		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		// Status
		
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div")).click();
		
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		// Username
		driver.findElement(By.xpath("//input[@autocomplete='off'][1]")).sendKeys("Aishwarya");
		
		Thread.sleep(2000);
		// Password
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Aishu@123");
		
		WebElement confirm_password=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input"));
		confirm_password.sendKeys("Aishu@123");
		
		// Save
		driver.findElement(By.xpath("//button[@type='submit'][normalize-space(text()='Save')]")).click();
		
		//driver.quit();
	}
	
	public void fileRead() throws Exception {
		
		FileInputStream File_location= new FileInputStream("C:\\Users\\kisho\\Downloads\\EmployeeList.xlsx");
		Workbook workbook =new XSSFWorkbook(File_location);
		Sheet sheet=workbook.getSheetAt(0);
		
		Iterator<Row> rowIterator =sheet.iterator();
		System.out.println(rowIterator);
		
		
	}

}


