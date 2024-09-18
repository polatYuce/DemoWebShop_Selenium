package _02_Proje.US09;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class DownloadTheOrderHistoryToTheComputer extends BaseDriver {
    @Test
    public void test() {
        driver.get("https://demowebshop.tricentis.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Log in linkine tıklama
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Log in']")));
        login.click();
        MyFunc.Bekle(2);

        // E-posta alanına veri girme
        WebElement eMail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='email']")));
        eMail.sendKeys("techno.study5@gmail.com");
        MyFunc.Bekle(2);
        //Şifre alanına veri girme
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='password']")));
        password.sendKeys("pass1234");
        MyFunc.Bekle(2);

        // Log in butonuna tıklama
        WebElement login2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value='Log in']")));
        login2.click();
        MyFunc.Bekle(2);

        //Hesap sayfasına gitme
        WebElement account = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='techno.study5@gmail.com']")));
        account.click();
        MyFunc.Bekle(2);

        // Siparişler sayfasına gitme
        WebElement orders = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='list']//li[3]/a")));
        orders.click();
        MyFunc.Bekle(2);

        // Detaylar butonuna tıklama
        WebElement detaylar = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value='Details']")));
        detaylar.click();
        MyFunc.Bekle(2);

        // PDF Invoice butonuna tıklama
        WebElement pdfLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("PDF Invoice")));
        pdfLink.click();
        MyFunc.Bekle(2);

        String pdfPath = "C:\\Users\\fatma\\Downloads\\order_1790077.pdf"; // Dosya yolunu tanımlama

        // PDF'yi tarayıcıda açma
        File pdfFile = new File(pdfPath);
        if (pdfFile.exists()) {
            driver.get("file:///" + pdfFile.getAbsolutePath().replace("\\", "/")); // Uygun hale getirilen dosya yolunu tarayıcıdan aç
        } else {
            System.out.println("PDF dosyası bulunamadı.");
        }
   BekleKapat();
    }
}
