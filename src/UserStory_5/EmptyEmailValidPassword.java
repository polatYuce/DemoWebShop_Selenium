package UserStory_5;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmptyEmailValidPassword extends BaseDriver {

    @Test
    public void Test3(){

        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.Bekle(5);

        WebElement Register = driver.findElement(By.cssSelector("[href='/login']"));
        Register.click();
        MyFunc.Bekle(1);

//      WebElement Email= driver.findElement(By.cssSelector("[autofocus='autofocus']"));

        WebElement Password=driver.findElement(By.cssSelector("[class='password']"));
        Password.sendKeys("password1234");
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
