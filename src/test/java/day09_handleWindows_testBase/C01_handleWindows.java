package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_handleWindows {

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
        // driver.quit();
    }

    @Test
    public void test1() {
        //1-amazona gidin.
        driver.get("https://amazon.com");
        // System.out.println(driver.getWindowHandle());//bize hashkodu yazdırır
        /*
        736BDF8004415AE2D76DAB9226777825 bu kod açılan sayfanın unique hash kodudur.
        Selenium sayfalar arası geçişte bu handle değerini kullanır.

        Eğer sayfalar arasında driverımızı gezdiriyorsak veya herhangi bir sayfadan
        şuanda bulunduğumuz sayfaya geçmek istiyorsak
        driver.switchTo().window("736BDF8004415AE2D76DAB9226777825");
        bu sayfanın window handle değerini girerek bu sayfaya geçiş yapabiliriz.
         */

        String ilkSayfaHandleDeğeri = driver.getWindowHandle();

        //2-Nutella için arama yapın.
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);

        //3-ilk ürünün resmine tıklayarak farklı bir tab olarak açın
        WebElement ilkUrunResmi = driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        driver.switchTo().newWindow(WindowType.TAB);

        /*
        Bu komutu kullandığımızda driver otomatik olarak oluşturulannew Tab a tıklar
        yeni Tab'da görevi gerçekleştirmek için adımları baştan almamız gerekir.
         */
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();

        //4-yeni tab da açılan ürünün title'ını yazdır.
        WebElement urunBaşlığı = driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(urunBaşlığı.getText());//Nutella Hazelnut Spread with Cocoa for Breakfast, 35.3 oz Jar
        System.out.println(driver.getCurrentUrl());//https://www.amazon.com/Nutella-Hazelnut-Spread-Breakfast-Holiday/dp/B008IGB0QQ/ref=sr_1_1?keywords=Nutella&qid=1682448540&sr=8-1

        //ilk  sayfaya geçip url i yazdıralım
        driver.switchTo().window(ilkSayfaHandleDeğeri);
        System.out.println(driver.getCurrentUrl());//https://www.amazon.com/s?k=Nutella&ref=nb_sb_noss
    }

}
