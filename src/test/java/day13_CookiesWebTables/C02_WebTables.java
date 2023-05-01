package day13_CookiesWebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

public class C02_WebTables extends TestBase {
    /*
     login( ) metodun oluşturun ve oturum açın.
     https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
     Username : manager
     Password : Manager1!
     table( ) metodu oluşturun
     Tüm table body’sinin boyutunu(sutun sayisi) bulun.
     Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
     printRows( ) metodu oluşturun //tr table body’sinde bulunan toplam satir(row) sayısını bulun.
     Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
     4.satirdaki(row) elementleri konsolda yazdırın.
     */

    @Test
    public void webTableTest() {
        girisYap();

    }

    public void girisYap() {

        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions=new Actions(driver);
        WebElement username =driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager")
                . sendKeys(Keys.TAB)
                        .sendKeys("Manager1!").sendKeys(Keys.ENTER)
                        .perform();

    }
}
