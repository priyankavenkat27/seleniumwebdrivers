package mypackage;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class lab8part2 {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
    }

    @Test
    public void testLab4Flow() {
        // Verify title
        Assert.assertEquals("Your Store", driver.getTitle());

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

        // Search for Mobile
        driver.findElement(By.name("search")).sendKeys("Mobile");
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();


        // Clear & search for Monitors
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.clear();
        searchBox.sendKeys("Monitors");
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();


        // Check description box and search again
        driver.findElement(By.name("description")).click();
        driver.findElement(By.className("btn-primary")).click();

        // Verify results displayed
        Assert.assertTrue(driver.findElement(By.id("content")).isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
