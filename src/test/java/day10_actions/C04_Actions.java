package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions extends TestBase {
    /*
    1.https://demoqa.com/droppable adresine gidelim
    2. “Drag me” butonunu tutup “Drop here” kutusunun ustune
    3.“Drop here” yazisi yerine “Dropped!” oldugunu test edin
     */

    @Test
    public void test() throws InterruptedException {
        //1.// https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        // 2. “Drag me” butonunu tutup “Drop here” kutusunun ustune
        Actions actions = new Actions(driver);
        WebElement dragMe = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHere = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        Thread.sleep(3000);
        actions.dragAndDrop(dragMe, dropHere).perform();


        //3.“Drop here” yazisi yerine “Dropped!” oldugunu test edin.
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String expectedsonucYazisi = "Dropped!";
        String actualsonucYazisi = sonucYaziElementi.getText();
        Assert.assertEquals(expectedsonucYazisi, actualsonucYazisi);
        Thread.sleep(3000);

    }

}
