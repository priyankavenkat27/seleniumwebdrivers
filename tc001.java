package mypackage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class tc001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 WebDriverManager.chromedriver().setup();
 WebDriver driver=new ChromeDriver();
 driver.get("https://www.google.com");
 System.out.println("Title is: " +driver.getTitle());
 driver.navigate().to("https://www.yahoo.com");
 System.out.println("Title is: " +driver.getTitle());
 driver.navigate().back();
System.out.println("After back title is:"+driver.getTitle());
	driver.navigate().forward();
System.out.println("After forward title is:"+driver.getTitle());
System.out.println("title is:"+driver.getTitle());
System.out.println("url is:"+driver.getCurrentUrl());
System.out.println("page source is:"+driver.getPageSource());

driver.quit();
	}
}
