package day08_alerts_iframe_basicauth;

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

public class C04_Iframe {

    /*
    bir method oluşturun: iframetest
    *An IFrame containing... ." textinin erişilebilir olduğunu test edin ve konsolda yazdırın
    *text box'a  "Merhaba Dunya!" yazın.
    *Text Box'ın altında bulunan "Elemental Selenium" linkinin textinin görünür olduğunu doğrulayın ve konsolda yazdırın

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
         driver.close();
    }

    @Test
    public void iFrameTest01() throws InterruptedException {

        // https://the-internet.herokuapp.com/iframe adresine gidelim
       // *An IFrame containing... ." textinin erişilebilir olduğunu test edin ve konsolda yazdırın
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement titleElement= driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(titleElement.isEnabled());
        System.out.println(titleElement.getText());


        // *text box'a  "Merhaba Dunya!" yazın.
        //*text box'ı doğru locate etmemize rağmen driver bulamadı
        //bunun üzerine html kodlarını incelediğimizde  text box'ın aslında bir iframe içerisinde olduğunu gördük
        //bu durumda önce iframe i locate edip switchTo ile o iframe e geçmeliyiz.

        WebElement iframeElementi= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeElementi);

        WebElement textBox= driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBox.clear();
        Thread.sleep(2000);
        textBox.sendKeys("Merhaba Dunya!");

        Thread.sleep(5000);

        //*Text Box'ın altında bulunan "Elemental Selenium" linkinin textinin görünür olduğunu doğrulayın ve konsolda yazdırın
        //Link yazı elementini doğru olmasına ragmen yazdırmadı, çünkü yukarıda ifram'e geçis yapmıştık
        // bu durumda önce iframe i locate edip switchTo ile o iframe e geçmeliyiz.

        driver.switchTo().defaultContent();
        WebElement linkText= driver.findElement(By.xpath(  "//div[@style='text-align: center;']"));
        Assert.assertTrue(linkText.isDisplayed());

        /*
        iframe den çıkmak için 2 komut vardır.
        *driver.switchTo().parentFrame();-->1 üst seviiyedeki frame' e çıkartır.
        *driver.switchTo().defaultContent();-->En üstteki frame'e çıkmak için kullanılır.
         */
    }



        /*
        Bir web sitesinde bir video(youtube vs) varsa <iframe> tag'i içerisindeyse bu video'yu direkt locate edip çalıştırmak dinamik olmaz.
        Çünkü link değişebilir ve locate'imiz çalışmaz.
        Bunun için bütün frame'leri bir array liste atıp index ile frame'i seçip sonrasında play tuşunu locate edip çalıştırabiliriz.
        */


}
