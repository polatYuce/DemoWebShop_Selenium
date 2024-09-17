package UserStory_5;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CurrentEmailEmptyPassword extends BaseDriver {

    @Test
    public void Test2(){

        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.Bekle(3);

        WebElement Login = driver.findElement(By.cssSelector("[href='/login']"));
        Login.click();
        MyFunc.Bekle(1);

        WebElement Email= driver.findElement(By.cssSelector("[autofocus='autofocus']"));
        Email.sendKeys("techno.study5@gmail.com");
        MyFunc.Bekle(1);

//      WebElement Password=driver.findElement(By.cssSelector("[class='password']"));

        WebElement LoginButton=driver.findElement(By.cssSelector("[class='button-1 login-button']"));
        LoginButton.click();
        MyFunc.Bekle(1);

        WebElement Message = driver.findElement(By.xpath("//div[@class='validation-summary-errors']/span"));
        System.out.println("Uyari Mesaji = " + Message.getText());
        MyFunc.Bekle(1);


        BekleKapat();
    }
}
