package mypackage;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


	public class lab8part1 {
	    WebDriver driver;

	    @Before
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	        driver.get("https://tutorialsninja.com/demo/");
	    }

	    @Test
	    public void testLab3Flow() {
	        // Go to Desktops → Mac
	        driver.findElement(By.linkText("Desktops")).click();
	        driver.findElement(By.linkText("Mac (1)")).click();

	        // Verify Mac heading
	        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Mac']")).isDisplayed());

	        // Sort by Name (A-Z)
	        WebElement sort = driver.findElement(By.id("input-sort"));
	        sort.sendKeys("Name (A - Z)");

	        // Click Add to Cart
	        driver.findElement(By.xpath("//*[@id='content']/div[2]/div/div/div[2]/div[2]/button[1]/span")).click();

	        // Verify success message
	        WebElement success = driver.findElement(By.cssSelector(".alert-success"));
	        Assert.assertTrue("You have added iMac to your shopping cart!", success.isDisplayed());
	    }

	    @After
	    public void tearDown() {
	        driver.quit();
	    }
	}


  