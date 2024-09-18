package UserStory_4;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SuccesfullyLogin extends BaseDriver {
    @Test
    public void Test1()
        {
            driver.navigate().to("https://demowebshop.tricentis.com/");
            MyFunc.Bekle(5);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement Register = driver.findElement(By.cssSelector("[href='/login']"));
            Register.click();
            MyFunc.Bekle(1);

            WebElement Email= driver.findElement(By.cssSelector("[autofocus='autofocus']"));
            Email.sendKeys("techno.study5@gmail.com");
            MyFunc.Bekle(1);

            WebElement Password=driver.findElement(By.cssSelector("[class='password']"));
            Password.sendKeys("pass1234");
            MyFunc.Bekle(1);

            WebElement Login=driver.findElement(By.cssSelector("[class='button-1 login-button']"));
            Login.click();
            MyFunc.Bekle(1);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("account")));
            WebElement accountLink = driver.findElement(By.className("account"));
            String Techno= accountLink.getText();
            System.out.println("Giriş yapılan kullanıcı: " + Techno);

            if (Techno.contains("techno.study5@gmail.com")) {
                System.out.println("Kullanıcı adı doğrulandı.");
            } else {
                System.out.println("Kullanıcı adı doğrulanamadı.");

            }



            BekleKapat();
        }
}
