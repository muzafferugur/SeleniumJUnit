package day08_alerts_iframe_basicauth;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleAlertClassWork {


    /*
    - https://the-internet.herokuapp.com/javascript_alerts adresine gidin.

    -bir method oluşturun :acceptAlert
    1.butona tıklayın, yukarıdaki OK butonuna tıklayın ve result mesajının
     "You succesfully clicked an alert" olduğunu test edin.

     -bir method oluşturun :dismissAlert
    2.butona tıklayın, yukarıdaki Cancel butonuna tıklayın ve result mesajının
    "successfully" içermediğini test edin.

     -bir method oluşturun :sendKeysAlert
    3.butona tıklayın ve yukarıdaki metin kutusuna isminizi yazın, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
     */

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
    public void acceptAlertTest() {
        /*
         -bir method oluşturun :acceptAlert
         1.butona tıklayın, yukarıdaki OK butonuna tıklayın ve result mesajının
        "You successfully clicked an alert" olduğunu test edin.
         */
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("(//button[@onclick=\"jsAlert()\"])[1]")).click();
        driver.switchTo().alert().accept();
        String expectedResultMessage = "You successfully clicked an alert";
        // WebElement sonucYazısı= driver.findElement(By.xpath("//p[@id='result']"));
        String actualResultMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(expectedResultMessage, actualResultMessage);
    }

    @Test
    public void dismissAlertTest() {
        /*
         -bir method oluşturun :dismissAlert
         2.butona tıklayın, yukarıdaki Cancel butonuna tıklayın ve result mesajının
         "successfully" içermediğini test edin.
         */
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()'][1]")).click();
        driver.switchTo().alert().dismiss();
        String unExpectedResultMessage = "successfully";
        String actualDissMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertNotEquals(unExpectedResultMessage, actualDissMessage);

    }

    @Test
    public void sendKeysAlertTest() {

        /*
         -bir method oluşturun :sendKeysAlert
         3.butona tıklayın ve yukarıdaki metin kutusuna isminizi yazın, OK butonuna
          tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
         */

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()'][1]")).click();
        driver.switchTo().alert().sendKeys("muzaffer uğur");
        driver.switchTo().alert().accept();
        String expectedResultMessageIsim = "muzaffer uğur";
        String actualResultMessageIsim = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertTrue(actualResultMessageIsim.contains(expectedResultMessageIsim));


    }
}