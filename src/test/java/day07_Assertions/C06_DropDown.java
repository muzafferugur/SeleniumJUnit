package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C06_DropDown {
    /*
    Bir class oluşturun: DropDown
    ı.https://the-internet.herokuapp.com/dropdown adresine gidin.
    ıı.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    ııı.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    ıv.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    v.Tüm dropdown değerleri(value) yazdırın
    vı.Dropdown'un boyutunu bulun, Dropdown'da 4 öğe varsa konsolda True , degilse
    False yazdırın.
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
        driver.quit();
    }

    @Test
    public void testDropDown() {
        //ı.https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //ıı.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın.
        WebElement ddm= driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(ddm);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        //ııı.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın.
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        //ıv.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        //v.Tüm dropdown options'ı yazdırın.
        List<WebElement> tumOptions=select.getOptions();
        for(WebElement option:tumOptions){
            System.out.println(option.getText());
        }
        /*
        List<WebElement> list = select.getOptions();
        for (WebElement each : list
        ) {
            System.out.println(each.getText());
        }

        list.stream().forEach(t-> System.out.println(t.getText())); // LAMBDA ile
         */

        //vı.Dropdown'un boyutunu bulun, Dropdown'da 4 öğe varsa konsolda True, degilse False yazdırın.
        int dropDownBoyut=tumOptions.size();
        if (dropDownBoyut==4){
            System.out.println("True");
        }else System.out.println("False");







    }

}
