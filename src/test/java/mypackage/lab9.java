package mypackage;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class lab9 {

    private WebDriver driver;
    private String browser;

    public lab9(String browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "{index}: Browser={0}")
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][] {
            { "chrome" },
            { "edge" }
        });
    }

    @Before
    public void setUp() {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
    }

    @Test
    public void lab3Flow() {
        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Mac (1)")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Mac']")).isDisplayed());

        Select sortDropdown = new Select(driver.findElement(By.id("input-sort")));
        sortDropdown.selectByVisibleText("Name (A - Z)");

        driver.findElement(By.xpath("//*[@id='content']/div[2]/div/div/div[2]/div[2]/button[1]/span")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success")));
        Assert.assertTrue(success.getText().contains("iMac"));
    }

    @Test
    public void lab4Flow() {
        Assert.assertEquals("Your Store", driver.getTitle());

        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Mac (1)")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Mac']")).isDisplayed());

        Select sortDropdown = new Select(driver.findElement(By.id("input-sort")));
        sortDropdown.selectByVisibleText("Name (A - Z)");

        driver.findElement(By.xpath("//*[@id='content']/div[2]/div/div/div[2]/div[2]/button[1]/span")).click();

        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.clear();
        searchBox.sendKeys("Mobile");
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();

        searchBox = driver.findElement(By.name("search"));
        searchBox.clear();
        searchBox.sendKeys("Monitors");
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();

        driver.findElement(By.name("description")).click();
        driver.findElement(By.className("btn-primary")).click();

        Assert.assertTrue(driver.findElement(By.id("content")).isDisplayed());
    }

    @After
    public void finish() {
        if (driver != null) {
            driver.quit();
        }
    }
}
