package day11_Faker_File;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void test() {

        System.out.println(System.getProperty("user.dir"));
        //bana içinde olduğum projenin yolunu(path) ini verir.C:\Users\muzaf\OneDrive\Masaüstü\com.Batch81JUnit

        System.out.println(System.getProperty("user.home"));
        //C:\Users\muzaf yani benim bilgisayarımın bana özel kısmını verdi

        //masaüstümüzdeki text dosyasının varlığını test edelim
        //"C:\Users\muzaf\OneDrive\Masaüstü\text.txt"
        String dosyaYolu = System.getProperty("user.home") + "\\Desktop\\text.txt";
        System.out.println(dosyaYolu);//C:\Users\muzaf\Desktop\text.txt

        /*
        bilgisayramızdaki bir dosyanın varlığını test etmemiz için once o dosyaya ulaşmamız gerekir

        Javada dosya erişimi için dosya yoluna (path) ihtiyaç vardır.

        Her bilgisayarın kullanıcı adı farklı olacağından masaustu dosya yolu birbirinden farklı olacaktır

        Testlerimizn tüm bilgisayarlarda çalışması için dosya yolunu dinamik yapmak zorundayız.

        Bunun için
            her bilgisayarın birbirinden farklı olan yolunu bulmak adına

         */
        String farklıKısım = System.getProperty("user.home");

        // herkesin bilgisayarında ortak olan kısım ise
        String ortakKısım = "\\Desktop\\text.txt";

        String masaustudosyaYolu = farklıKısım + ortakKısım;

        // System.out.println(Files.exists(Paths.get(masaustudosyaYolu)));//text.txt masaustunde böyle bir dosyanın olup olmadığını kontrol ediyor.
        //OneDrive da sıkıntı olabiliyor. bende de false verdi

        //Assert.assertTrue(Files.exists(Paths.get(masaustudosyaYolu)));
        /*
        C:\Users\muzaf\OneDrive\Masaüstü\com.Batch81JUnit
        C:\Users\muzaf
        C:\Users\muzaf\Desktop\text.txt
         */


    }
}
