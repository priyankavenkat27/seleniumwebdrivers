package mypackage;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;


import io.github.bonigarcia.wdm.WebDriverManager;
public class tc006_alert {
	public static void main(String args[]) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://letcode.in/alert");
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("alert('Hello')");
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		driver.findElement(By.id("accept")).click();
		Alert simplealert=driver.switchTo().alert();
		System.out.println("Alert message:"+simplealert.getText());
		simplealert.accept();
		
		driver.findElement(By.id("confirm")).click();
		Alert confirmalert=driver.switchTo().alert();
		System.out.println("Alert message:"+confirmalert.getText());
		confirmalert.accept();
		
		
		driver.findElement(By.id("prompt")).click();
		Alert promptalert=driver.switchTo().alert();
		System.out.println("Alert message:"+promptalert.getText());
		promptalert.sendKeys("hhhhh");
		promptalert.accept();

		driver.quit();
	}

}
