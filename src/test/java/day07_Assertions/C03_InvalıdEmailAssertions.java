package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_InvalıdEmailAssertions {
    /*
    http://www.automationpractice.com/index.php sayfasına gidelim
    Sign in butonuna basalım
    Email kutusuna @işareti olmayan bir mail adresi yazpı enter'a bastağımızda
        "Invalid email address" uyarısı çıktığını test edelim
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://www.automationpractice.com/index.php");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void test() {
        //Sign in butonuna basalım
        driver.findElement(By.xpath("//a[@class='login']")).click();

        //Email kutusuna @işareti olmayan bir mail adresi yazpı enter'a bastağımızda'
        //"Invalid email address" uyarısı çıktığını test edelim
        WebElement mailKutusu = driver.findElement(By.xpath("//input[@id='email_create']"));
        mailKutusu.sendKeys("mehmetgmail.com" + Keys.ENTER);
        WebElement uyarıYazısıElementi = driver.findElement(By.xpath("//*[@text='Invalid email address']"));
        Assert.assertTrue(uyarıYazısıElementi.isDisplayed());

    }

}
