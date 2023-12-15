package UserDetails;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeavePage {
	
	ChromeDriver driver= new ChromeDriver();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		AdminPage a = new AdminPage();
		a.LoginDetails();
		a.PIMDetails();
		a.AdminDetails();
		
	}
	
	public void leavepg() {
		// Leave click
		WebElement leave_click =driver.findElement(By.xpath("//span[text()='Leave']"));
		leave_click.click();
		
		//
	}

}
