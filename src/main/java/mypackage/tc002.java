package mypackage;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
import io.github.bonigarcia.wdm.WebDriverManager;
public class tc002 {
public static void main(String args[]) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.myntra.com");
	//driver.findElement(By.xpath("//button[text()='Continue shopping']")).click();

	List<WebElement> alllinks=driver.findElements(By.tagName("a"));
	System.out.println("Title links:"+alllinks.size());
	for(WebElement link:alllinks)
	{
		System.out.println("The link is:"+link.getText());
	}
	driver.quit();
}


}

