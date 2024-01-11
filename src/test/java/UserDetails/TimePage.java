package UserDetails;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TimePage {

	ChromeDriver driver= new ChromeDriver();
	public static void main(String[] args) throws Exception {
		
		AdminPage a = new AdminPage();
		a.LoginDetails();
		a.PIMDetails();
		a.AdminDetails();
		TimePage T = new TimePage();
		T.PunchIN();
		
	}
	
	public void PunchIN() throws Exception {
		
		// TimePage click
		WebElement Time_Click= driver.findElement(By.xpath("//span[text()='Time']"));
		Time_Click.click();
		
		// Attendance dropdown
		driver.findElement(By.xpath("//span[text()='Attendance ']")).click();
		
		// Employee Records
		driver.findElement(By.xpath("//a[text()='Employee Records']")).click();
		
		//Employee Name
		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("Aishwarya");
		Thread.sleep(2000);
		
		List<WebElement> options= driver.findElements(By.xpath("//div[@role='option']//span"));
		
		for(WebElement e: options) {
			String text=e.getText();
			if(text.contains("Aishwarya")) {
				e.click();
			}
		}
		
		Thread.sleep(1000);
		
		// Click View
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/div[2]/form/div[2]/button")).click();
		
		// Click Add
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/div[1]/button")).click();
		
		// Punch in
		driver.findElement(By.xpath("//div[@class='oxd-layout-container']//button[normalize-space(text()='In')]")).click();
		
	}
	
}
