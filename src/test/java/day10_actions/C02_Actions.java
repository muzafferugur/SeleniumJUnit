package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {
    /*Keyboard ve mouse ile yapabildiğimiz her işlemi TestNG de Action class kullanarak yapabiliriz.
    3 adımda yapılır.

    1.Adım : Actions Class'ta bir object oluşturulur.
    Actions actions=new Actions(driver);

    2.Adım: Üzerinde çalışmak istediğimiz WebElement öğesini bulur.(Locate ederiz)
    WebElement element =driver.findElement(By.id("ID"));

    3.Adım: Ardından bu webelement üzerinde action gerçekleştirilir.Örrneğin tıklamak için
    actions.click(element).perform();

    not:Action Class'ını her kullanmak istediğimizde yeniden obje oluşturmamız gerekmez.

    action objesini bir kere oluşturunca istediğimiz kadar action ile başlayan komut yazar çalışması için
    sonuna "perform()" <-->yap demek <yazarız.

    -----Mouse Base Actions-----

    doubleClick(); Web elemente çift tıklar.
    clickAndHold();Web element üzerinde click yapılı olarak bizi bekler
    dragAndDrop():Web elementi bir noktadan diğerine sürükler ve bırakır.
    moveToElement():Mouse'u istediğimiz Webeleementin üzerinde tutar ve bekler.
    contextClick():Mouse'u istediğimiz Webeleemente sağ tıklama yapar.'

     */

    @Test
    public void test() throws InterruptedException {
        //amazon sayfasına gidip
        //account menusunden create a list linkinin üstüne git.
        driver.get("https://www.amazon.com");
        Actions actions = new Actions(driver);
        WebElement accountLink = driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        actions.moveToElement(accountLink).perform();
        Thread.sleep(3000);

        //driver.findElement(By.xpath("//*[text()='Create a Lists']")).click();-->NoSuchElement


    }
}
