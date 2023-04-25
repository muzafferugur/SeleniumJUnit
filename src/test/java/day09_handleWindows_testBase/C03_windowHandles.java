package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_windowHandles {
    /*
    1.https://the-internet.herokuapp.com/windows adresine gidin
    2.Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
    3.Sayfa başlığının "The Internet" olduğunu doğrulayın.
    4.Click here butonuna basın.
    5.Açılan yeni pencerinin sayfa başlığının "New Windoww" olduğunu doğrulayın.
    6.Saydaki textin "New Window" olduğunu doğrulayın.
    7.Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu doğrulayın.
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

        // 1.https://the-internet.herokuapp.com/windows adresine gidin
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWindowHandleDeğeri = driver.getWindowHandle();
        //2.Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
        WebElement sayfadakiYazıElementi = driver.findElement(By.xpath("//h3"));
        String expectedYazı = "Opening a new window";
        String actualYazı = sayfadakiYazıElementi.getText();
        Assert.assertEquals(expectedYazı, actualYazı);

        // 3.Sayfa başlığının "The Internet" olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        /*
        eğer kontrolsuz acılan bir tab veya window varsa o zaman sayfaların window handle değerlerini elde etmem
        gerekir.

        Öncelikle 2. sayfa açılmadan önce ilk sayfanın window handle değerini bir stringe atayalım.
         */

        //4.Click here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

        /*
        switchTo().newWndow() demeden link tıklayarak yeni tab veya window oluştuğunda biz driver a
        yeni sayfaya geç demedikçe eski sayfada kalır ve yeni sayf ile ilgili hiç bir işlem yapmaz.

        Yeni sayfada  driver'ı çalıştırmak isterseniz önce driverı yeni sayfaya yollamalısınız.

        Yeni sayfaya geçebilmek için öncelikle ikinciSayfaWindowHandleDeğeri'ni bulmamız gerekir.

        Bunun için driver.getWindowHandles() methodunu kullanarak açık olan tüm sayfaların window handle değerlerini
        alıp bir sete assign ederiz.

        ilk sayfanın window handle değerini zaten biliyoruz. Set'deki window handle değerlerini kontrol edip
        ilk sayfanın handle değerine eşit  olmayan ikinci sayfanın window handle değeridir.

         */
        Set<String> windowHandleSeti = driver.getWindowHandles();
        System.out.println(windowHandleSeti);//-->Window handle değerlerini set halinde getirdi
        //bunları almak için foreach kullanıyoruz.

        String ikinciSayfaWindowHandleDeğeri = "";
        for (String each : windowHandleSeti
        ) {
            if (!each.equals(ilkSayfaWindowHandleDeğeri)) {
                ikinciSayfaWindowHandleDeğeri = each;//-->Artık ikinci sayfanın window handle değerini biliyorum.
            }
        }
        //rahatlıkla sayfalar arası geçiş yapabilirim.

        driver.switchTo().window(ikinciSayfaWindowHandleDeğeri);

        //5.Açılan yeni pencerinin sayfa başlığının "New Windoww" olduğunu doğrulayın.
        String expectedIkinciTitle = "New Window";
        String actualIkinciTitle = driver.getTitle();
        Assert.assertEquals(expectedIkinciTitle, actualIkinciTitle);

        // 6.Saydaki textin "New Window" olduğunu doğrulayın.
        WebElement ikinciSayfaYazıElementi = driver.findElement(By.xpath("//h3"));
        String expectedIkinciYazi = "New Window";
        String actualIkinciYazi = ikinciSayfaYazıElementi.getText();
        Assert.assertEquals(expectedIkinciYazi, actualIkinciYazi);

        //7.Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWindowHandleDeğeri);
        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);


    }
}
