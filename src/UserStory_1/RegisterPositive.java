package UserStory_1;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPositive extends BaseDriver {
    @Test
    public void Test1() {
        driver.get("https://demowebshop.tricentis.com/");

        WebElement register = driver.findElement(By.xpath("//a[@class='ico-register']"));
        register.click();
        MyFunc.Bekle(2);

        WebElement gender = driver.findElement(By.xpath("//input[@id='gender-female']"));
        gender.click();
        MyFunc.Bekle(2);

        WebElement fistName = driver.findElement(By.id("FirstName"));
        fistName.sendKeys("Techno");
        MyFunc.Bekle(2);

        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys("Study");
        MyFunc.Bekle(2);

        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("techno.study5@gmail.com");
        MyFunc.Bekle(2);

        WebElement passWord = driver.findElement(By.id("Password"));
        passWord.sendKeys("pass1234");
        MyFunc.Bekle(2);

        WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.sendKeys("pass1234");
        MyFunc.Bekle(2);

        WebElement registerBtn = driver.findElement(By.id("register-button"));
        registerBtn.click();
        MyFunc.Bekle(2);

        WebElement answerOku = driver.findElement(By.cssSelector("[class='page registration-page'] li"));
        System.out.println("answerOku.getText() = " + answerOku.getText());
        Assert.assertTrue("bu şekilde bir kullanıcı tanımlı değil", answerOku.getText().equalsIgnoreCase("The specified email already exists"));

        BekleKapat();


    }
}
