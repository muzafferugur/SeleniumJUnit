package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions extends TestBase {
    //facebook anasayfaya gidip
    //yeni kayıt oluştur butonuna basın
    //isim kutusunu locate edip
    //geriye kalanları TAB ile dolasarak
    //formu doldursun

    @Test
    public void test() {
        // 1- https://www.facebook.com adresine gidelim.
        driver.get("https://www.facebook.com");
        Actions actions = new Actions(driver);
        // 2- Yeni hesap olustur butonuna basalim.
        WebElement account = driver.findElement(By.xpath("(//a[@role='button'])[2]"));
        account.click();

        // 3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim.
        WebElement name = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        actions.click(name).sendKeys("muzaffer").sendKeys(Keys.TAB).sendKeys("ugur").
                sendKeys(Keys.TAB).sendKeys("ornek@gmail.com").sendKeys(Keys.TAB).
                sendKeys("ornek@gmail.com").sendKeys(Keys.TAB).sendKeys("147856").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("5").sendKeys(Keys.TAB).
                sendKeys("Tem").
                sendKeys(Keys.TAB).sendKeys("1995").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).
                perform();

        // 4- Kaydol tusuna basalim.
    }
}
