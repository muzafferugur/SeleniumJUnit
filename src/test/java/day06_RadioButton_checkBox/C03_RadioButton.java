package day06_RadioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    /*
    1-https://facebook.com hesabına gidin
    2- Cookies'i kabul edin
    3-"Create an Account" butonuna basın
    4-"radio buttons" elementlerini locate edin.
    **bize tek seçenek sunuyorsa ve birini seçince diğerlerini seçtirmiyorsa bu ihtimali ortadan kaldırıyorsa "radio button"
    **birden fazla seçenek seçebiliyorsak "checkbox"
    5-Seçili değilse cinsiyet butonundan size uygun olanı seçin
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
        //driver.quit();
    }

    @Test
    public void RadioButtonTest() throws InterruptedException {
        //1-https://facebook.com hesabına gidin
        driver.get("https://facebook.com");
        //2- Cookies'i kabul edin-bende çıkmıyor
        //3-"Create an Account" butonuna basın
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        //4-"radio buttons" elementlerini locate edin.
        WebElement femaleRadioButtons = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement maleRadioButtons = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement customRadioButtons = driver.findElement(By.xpath("(//input[@type='radio'])[3]"));

        //5-Seçili değilse cinsiyet butonundan size uygun olanı seçin
        Thread.sleep(3000);
        if (maleRadioButtons.isSelected()) {
            maleRadioButtons.click();
        }
        Thread.sleep(3000);
    }
}
