package day11_Faker_File;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker extends TestBase {
    @Test
    public void fakerTest01() throws InterruptedException {
        //facebook görevini fake isimlerle yapalım
        // 1- https://www.facebook.com adresine gidelim.
        driver.get("https://www.facebook.com");


        // 2- Yeni hesap olustur butonuna basalim.
        WebElement account = driver.findElement(By.xpath("(//a[@role='button'])[2]"));
        account.click();

        // 3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim.

        Actions actions = new Actions(driver);
        Faker faker =new Faker();
        String fakeMail=faker.internet().emailAddress();
        WebElement name = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        actions.click(name).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(fakeMail)
                .sendKeys(Keys.TAB).
                sendKeys(fakeMail).
                sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB)
                .sendKeys("5").
                sendKeys(Keys.TAB).
                sendKeys("Tem").
                sendKeys(Keys.TAB).
                sendKeys("1995")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();

        Thread.sleep(13000);
    }
}
