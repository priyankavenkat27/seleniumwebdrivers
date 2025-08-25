package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class newclass {

    public static void main(String[] args) {
        System.out.println("hello");

        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Open URL
        //driver.get("https://tutorialsninja.com/demo/index.php?");
        driver.get("https://www.google.com/");
        // Optional: wait a bit or perform actions here
        //WebElement search=driver.findElement(By.id("APjFqb"));
        //search.sendKeys("Automation Testing Tools");
        //search.submit();
        System.out.println("Title is :" +driver.getTitle());
        driver.quit();
}}

