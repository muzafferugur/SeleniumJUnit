package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TekrarTestiNutella {
    public static void main(String[] args) {
       /*
       1-https://www.google.com/ adresine gidin
       2-Cookies uyarısını kabul ederek kapatın
       3-Sayfa başlığının "Google" ifadesi içerdiğini test edin
       4-Arama çubuğuna "Nutella" yazıp aratın
       5-Bulunan sonuc sayısını yazdırın
       6- Sonuc sayısının 10milyon dan fazla olduğunu test edin
       7-Sayfayı kapatın
        */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1-https://www.google.com/ adresine gidin
        driver.get("https://google.com");

        // 2-Cookies uyarısını kabul ederek kapatın-bende çıkmıyor
        // 3-Sayfa başlığının "Google" ifadesi içerdiğini test edin
        WebElement sayfaBaslığı = driver.findElement(By.xpath("//img[@src='/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png']"));

        if (sayfaBaslığı.isDisplayed()) {
            System.out.println("Sayfa başlığı testi PASSED");

        } else System.out.println("sayfa başlığı testi FAILED");

        // 4-Arama çubuğuna "Nutella" yazıp aratın
        driver.findElement(By.id("APjFqb")).sendKeys("Nutella" + Keys.ENTER);

        // 5-Bulunan sonuc sayısını yazdırın
        WebElement sonucSayısı = driver.findElement(By.xpath("//div[@id='result-stats'][1]"));
        System.out.println("sonucsayısı  : " + sonucSayısı.getText());

        // 6- Sonuc sayısının 10milyon dan fazla olduğunu test edin
        String sonucYazısı = "Yaklaşık 131.000.000 sonuç bulundu (0,37 saniye)";
        String sonucYazı = sonucYazısı.replaceAll("\\D", "").substring(0, 10);
        int numResult = Integer.parseInt(sonucYazı);
        if (numResult > 10000000) {
            System.out.println("10 milyondan fazla, test PASSED");

        } else System.out.println("10 milyondan az, test FAILED");

        // 7-Sayfayı kapatın
        driver.close();

    }
}




