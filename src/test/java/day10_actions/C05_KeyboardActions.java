package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {

     /*
    Keyboard Base Actions
    *sendKeys():Öğeye bir dizi anahtar gönderir.
    *keyDown():Klavyede tuşa basma işlemini gerçekleştirir.
    *keyUp():Klavyede tuşu serbest bırakma işlemini yapar.
     */

    @Test
    public void test() throws InterruptedException {
        driver.get("https://amazon.com");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        //önce arama kutusuna click yapıp sonra harf harf nutella yazısını yazdıralım
        //sonra enter ruşuna basalım

        Actions actions = new Actions(driver);

        actions.click(aramaKutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("n")
                .keyUp(Keys.SHIFT)
                .sendKeys("u")
                .sendKeys("t")
                .sendKeys("e")
                .sendKeys("l")
                .sendKeys("l")
                .sendKeys("a").sendKeys(Keys.ENTER).perform();

        Thread.sleep(3000);

    }
}
