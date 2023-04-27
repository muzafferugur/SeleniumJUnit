package day10_actions;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_Actions extends TestBase {
    /*
    1.https://the-internet.herokuapp.com/context_menu sitesine gidelim
    2.Cizili alan uzerinde sag click yapalim
    3.Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
    4.Tamam diyerek alert’i kapatalim
    5.Elemental Selenium linkine tiklayalim
    6.Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
     */

    @Test
    public void actionsTest() {
        // 1.https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //2.Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
        WebElement cizgiliAlanElement = driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlanElement).perform();

        // 3.Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String expectedYazı = "You selected a context menu";
        String actualYazı = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazı, actualYazı);

        //4.Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        // 5.Elemental Selenium linkine tiklayalim
        String ilkSayfanınHandleDeğeri = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        Set<String> handleSeti = driver.getWindowHandles();
        String ikinciSayfaHandleDeğeri = driver.getWindowHandle();
        System.out.println(handleSeti);

        for (String each : handleSeti
        ) {
            if (!each.equals(ilkSayfanınHandleDeğeri)) {
                ikinciSayfaHandleDeğeri = each;
            }
        }
        driver.switchTo().window(ikinciSayfaHandleDeğeri);
// 6.Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        WebElement yazıElement = driver.findElement(By.tagName("h1"));
        String expectedIkinciYazıElement = "Elemental Selenium";
        String actualIkinciYazıElement = yazıElement.getText();
        Assert.assertEquals(expectedIkinciYazıElement, actualIkinciYazıElement);


    }

}
