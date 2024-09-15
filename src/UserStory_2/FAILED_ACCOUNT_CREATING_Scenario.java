package UserStory_2;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.checkerframework.checker.units.qual.N;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FAILED_ACCOUNT_CREATING_Scenario extends BaseDriver {

    @Test
    public void Test1() {
        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.Bekle(2);

        WebElement Register = driver.findElement(By.cssSelector("[href='/register']"));
        Register.click();

        WebElement Gender = driver.findElement(By.id("gender-female"));
        Gender.click();

        WebElement FirstName = driver.findElement(By.cssSelector("[name='FirstName']"));
        FirstName.sendKeys("Techno");

        WebElement LastName = driver.findElement(By.cssSelector("[name='LastName']"));
        LastName.sendKeys("Study");

        WebElement Email = driver.findElement(By.id("Email"));
        Email.sendKeys("techno.study5@gmail.com");

        WebElement Password = driver.findElement(By.id("Password"));
        Password.sendKeys("pass1234");

        WebElement ConfirmPassword = driver.findElement(By.id("ConfirmPassword"));
        ConfirmPassword.sendKeys("pass1234");

        WebElement Account_Register = driver.findElement(By.id("register-button"));
        Account_Register.click();

        WebElement HataMesajı = driver.findElement(
                By.xpath("//*[text()='The specified email already exists']"));


        Assert.assertTrue("Hata mesajı alınmadı", HataMesajı.getText().equals("The specified email already exists"));


        BekleKapat();
    }
}
