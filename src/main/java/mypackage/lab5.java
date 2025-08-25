package mypackage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class lab5 {

	public static void main(String[] args) {
		
		//PART 1
		
		
		// Setup ChromeDriver
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//maximize the window
		driver.manage().window().maximize();
		// Open URL
        driver.get("https://tutorialsninja.com/demo/index.php?");
		//getting the title of the page
        System.out.println("Title is :" +driver.getTitle());
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
     // Click on "Register" from dropdown
        driver.findElement(By.xpath("//a[text()='Register']")).click();
      //getting the title of the reg page
        System.out.println("Title is :" +driver.getTitle());
        String actualheading= "Register Account";
        String expectedheading=driver.getTitle();
        if(expectedheading.equals(actualheading)) {
        	System.out.println("Title verified");
        }else {
        	System.out.println("Title not verified");}
        driver.findElement(By.xpath("//input[@class='btn btn-primary']"
        		)).click();
        WebElement warning=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        System.out.println("WARNING:" +warning.getText());
       
        
        //PART 2
        
     // 1. First Name with 33 characters
        String firstName = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFG"; // 33 chars
        driver.findElement(By.id("input-firstname")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        WebElement firstNameWarning = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div"));
        System.out.println("First Name Warning: " + firstNameWarning.getText());
        
     // Clear and continue
        driver.findElement(By.id("input-firstname")).clear();

        // 2. Last Name with 33 characters
        String lastName = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFG"; // 33 chars
        driver.findElement(By.id("input-lastname")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        WebElement lastNameWarning = driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div"));
        System.out.println("Last Name Warning: " + lastNameWarning.getText());

        // Clear and continue
        driver.findElement(By.id("input-lastname")).clear();
   		
     // 3. Enter valid Email
        driver.findElement(By.id("input-email")).sendKeys("bobmaria@gmail.com");

        // 4. Telephone field test
        driver.findElement(By.id("input-telephone")).sendKeys("12"); // only 2 char
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        WebElement telephoneWarning = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div"));
        System.out.println("Telephone Warning (short): " + telephoneWarning.getText());

        // Enter valid telephone
        driver.findElement(By.id("input-telephone")).clear();
        driver.findElement(By.id("input-telephone")).sendKeys("9876543210");

        //PART 4
        
     // Password & Confirm Password
        driver.findElement(By.id("input-password")).sendKeys("Test@1234");
        driver.findElement(By.id("input-confirm")).sendKeys("Test@1234");
        
     // Newsletter = Yes
        driver.findElement(By.xpath("//label[text()='Yes']/input[@name='newsletter']")).click();
        
     // Agree to Privacy Policy
        driver.findElement(By.name("agree")).click();

     // Click Continue
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        // Verify Account Created Message
        String successHeading = driver.findElement(By.xpath("//h1")).getText();
        if (successHeading.equals("Your Account Has Been Created!")) {
            System.out.println("✅ Account created successfully!");
        } else {
            System.out.println("❌ Account creation failed. Got: " + successHeading);
        }
        
        // Click Continue on success page
        driver.findElement(By.xpath("//a[text()='Continue']")).click();

        // Click on 'View your order history'
        driver.findElement(By.xpath("//a[text()='View your order history']")).click();

        // Verify navigation
        String orderHistoryTitle = driver.getTitle();
        System.out.println("Navigated to: " + orderHistoryTitle);

        // Close
        driver.quit();
   
	}

}
