package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BestBuyAssertions {
    /*

     https://www.bestbuy.com/ adresine gidin farkli test method’lari olusturarak asagidaki
    testleri yapin
     -sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
     - titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
     -logoTest => BestBuy logosunun görüntülendigini test edin
     - FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.bestbuy.com/");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void Test1() {
        //-sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @Test
    public void Test2() {
        //titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String expectedArananKelime = "Rest";
        String actualArananKelime = driver.getTitle();
        Assert.assertFalse(actualArananKelime.contains(expectedArananKelime));

    }

    @Test
    public void Test3() {
        //logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement bestBuyLogo = driver.findElement(By.xpath("//img[@class='logo']"));
        Assert.assertTrue(bestBuyLogo.isDisplayed());
    }

    @Test
    public void Test4() {
        //FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement francisLink = driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(francisLink.isDisplayed());

    }
}
