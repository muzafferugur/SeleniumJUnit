package day06_RadioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
/*
BeforeClass  ve AfterClass methodları sadece static methodlar için çalışır.Class da sadece 1 kere çalışır.
Before ve After notasyonları her methoddan önce ve her methoddan sonra çalısır.
Ama BeforeClass  ve AfterClass methodları sadece class'ın basında ve class'ın sonunda çalısır.

**Before ve After da gidiyo test1 i yapıyo kapatıyo test2 yi yapıyo kapatıyo...**
**BeforeClass  ve AfterClass methodlarında gidiyo test1,2,3 üyapıp geliyo kapatıyo**

BeforeClass(precondition)->örneğin test methodlarımız çalışmadan driver oluşturup tüm methodlarda kullanabilirm.
AfterClass->örneğin açtığımız sayfayı kapatmak veya elde ettiğimiz test sonuçlarını raporlamak gibi.
 */

public class C01_BeforeClass_AfterClass {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() {
        //Before method call
        driver.get("https://amazon.com");
        //After method call
    }

    @Test
    public void test02() {
        driver.get("https://techproeducation.com");
    }

    @Test
    public void test03() {
        driver.get("https://facebook.com");
    }
}
