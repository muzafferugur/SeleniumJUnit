package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropDownOptions {
    /*
    1-Amazon anasayfaya gidip dropdown menuden books'u seçelim
    seçtiğimiz option'u yazdıralım

    2-Dropdowndaki options'ların sayısının 28 olduğunu test edelim.
     */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://amazon.com");
    }

    @After
    public  void tearDown() {
       driver.quit();
    }

    @Test
    public void dropDownOptionsTest() {
        driver.get("http://www.amazon.com");
        WebElement ddm= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Books");

        System.out.println(select.getFirstSelectedOption().getText());//son seçilen option->getFirstSelectedOption(). dediğimizde bize WebElement döndürür ,referans yazdırır
        //getText() yazdığımızda seçtiğimiz option'u yazdırırız

        //2-Dropdowndaki options'ların sayısının 28 olduğunu test edelim
       // select.getOptions();list döndürür--> WebElementlerden oluşan bir liste yapalım

        List<WebElement> optionList=select.getOptions();
        int actualoptionSayısı=optionList.size();
        int expectedOptionSayısı=28;

        Assert.assertEquals(expectedOptionSayısı, actualoptionSayısı);

    }

}


