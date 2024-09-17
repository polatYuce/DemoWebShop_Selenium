package UserStory_5;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class İnvalidEmailİnvalidPassword extends BaseDriver {

    @Test
    public void Test4(){

        driver.navigate().to("https://demowebshop.tricentis.com/");
        MyFunc.Bekle(5);

        WebElement Register = driver.findElement(By.cssSelector("[href='/login']"));
        Register.click();
        MyFunc.Bekle(1);

        WebElement Email= driver.findElement(By.cssSelector("[autofocus='autofocus']"));
        Email.sendKeys("techno.study55@gmail.com");
        MyFunc.Bekle(1);

        WebElement Password=driver.findElement(By.cssSelector("[class='password']"));
        Password.sendKeys("password123456");
        MyFunc.Bekle(1);

        WebElement Login=driver.findElement(By.cssSelector("[class='button-1 login-button']"));
        Login.click();
        MyFunc.Bekle(1);

        WebElement Message = driver.findElement(By.xpath("//div[@class='validation-summary-errors']/span"));
        System.out.println("Uyari Mesaji = " + Message.getText());
        MyFunc.Bekle(1);

        BekleKapat();
    }
}
