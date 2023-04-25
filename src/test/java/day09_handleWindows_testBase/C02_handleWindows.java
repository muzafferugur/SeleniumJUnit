package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_handleWindows {

    /*
    1. amazon sayfasına gidelim.
    2.url'in amazon içerdiğini test edelim.
    3.yeni bir sayfa açıp bestbuy anasayfasına gidelim.
    4.title'ın Best Buy içerdiğini test edelim.
    5.ilk sayfaya dönüp sayfada java aratalım.
    6.arama sonuçlarının java içerdiğini test edelim.
    7.yeniden bestbuy'ın açık olduğu sayfaya gidelim.
    8.logonun göründüğünü test edelim.
     */
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() {
        //1-amazona gidin.
        driver.get("https://amazon.com");
        String ilkSayfaWindowHandle = driver.getWindowHandle();

        //2.url'in amazon içerdiğini test edelim.
        String expectedKelime = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedKelime));

        //3.yeni bir sayfa açıp bestbuy anasayfasına gidelim.
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://bestbuy.com");
        String ikinciSayfaWindowHandle = driver.getWindowHandle();

        // 4.title'ın BestBuy içerdiğini test edelim.
        String istenenKelime = "Best Buy";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(istenenKelime));

        //5.ilk sayfaya dönüp sayfada Java aratalım.
        driver.switchTo().window(ilkSayfaWindowHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);

        // 6.arama sonuçlarının java içerdiğini test edelim.
        WebElement sonucYaziElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonuc = sonucYaziElement.getText();
        String aradığımızKelime = "Java";
        Assert.assertTrue(sonuc.contains(aradığımızKelime));

        //7.yeniden bestbuy'ın açık olduğu sayfaya gidelim.
        driver.switchTo().window(ikinciSayfaWindowHandle);

        // 8.logonun göründüğünü test edelim.
        WebElement logoElement = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoElement.isDisplayed());

    }
}
