package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenTest {
    public static void main(String[] args) throws InterruptedException {
        /*
        1. http://zero.webappsecurity.com/ sayfasına gidin
        2. Signin butonuna tıklayın
        3. Login alanına "username" yazdırın.
        4. Password alanına "password" yazdırın.
        5. Signin butonuna tıklayın.
        6. Pay Bills sayfasına gidin.
        7. amaunt kısmına yazdırmak istediğiniz miktarı yazdırın
        8. Tarih kısmına "2023-04-21" yazdırın
        9. Pay butonuna tıklayın.
        10. "The payment was succesfully submitted." mesajının çıktığını kontrol edin.
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. http://zero.webappsecurity.com/ sayfasına gidin
        driver.get("http://zero.webappsecurity.com/");

        //2. Signin butonuna tıklayın
        WebElement sigInButton = driver.findElement(By.className("icon-signin"));
        sigInButton.click();

        //3. Login alanına "username" yazdırın.
        WebElement login = driver.findElement(By.xpath("//input[@id='user_login']"));
        login.sendKeys("username" + Keys.ENTER);
        Thread.sleep(3000);

        // 4. Password alanına "password" yazdırın.
        WebElement password = driver.findElement(By.xpath("//input[@id='user_password']"));
        password.sendKeys("password" + Keys.ENTER);
        Thread.sleep(3000);

        //5. Signin butonuna tıklayın
        WebElement signInButton = driver.findElement(By.xpath("//input[@value='Sign in']"));
        signInButton.click();
        driver.navigate().back();
        //http ile olduğundan sayfada sorun çıkıyor signin butonuna bastıktan sonra sayfada geri yapınca düzeliyor.

        // 6. Pay Bills sayfasına gidin.(Online Bank'e tıklayınca aşağıda hemen)
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        driver.findElement(By.xpath("(//span[@class='headers'])[4]")).click();

        //7. amaunt kısmına yazdırmak istediğiniz miktarı yazdırın
        driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("1000" + Keys.ENTER);

        //8. Tarih kısmına "2023-04-21" yazdırın
        driver.findElement(By.xpath("//input[@name='date']")).sendKeys("2023-04-21" + Keys.ENTER);

        //9. Pay butonuna tıklayın.
        driver.findElement(By.xpath("//input[@value='Pay']")).click();

        //10. "The payment was succesfully submitted." mesajının çıktığını kontrol edin.
        WebElement actualYazı=  driver.findElement(By.xpath("//span[@title='$ 1000 payed to payee sprint']"));

        if (actualYazı.isEnabled()){
            System.out.println("yazı testi PASSED");

        }else System.out.println("yazı testi FAILED");

    }
}
