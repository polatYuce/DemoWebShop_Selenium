package UserStory_3;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExitFromTheSession extends BaseDriver {

    @Test()
    public void Test1() {
        driver.get("https://demowebshop.tricentis.com/");


        WebElement loginLink = driver.findElement(By.className("ico-login"));
        Actions actions=new Actions(driver);
        actions.moveToElement(loginLink).click().perform();


        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("techno.study5@gmail.com");
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("pass1234");


        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log in']"));
        loginButton.click();


        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("account")));
        WebElement accountLink = driver.findElement(By.className("account"));
        String Techno = accountLink.getText();
        System.out.println("Giriş yapılan kullanıcı: " + Techno);


        if (Techno.contains("techno.study5@gmail.com")) {
            System.out.println("Kullanıcı adı doğrulandı.");
        } else {
            System.out.println("Kullanıcı adı doğrulanamadı.");
        }

        actions.moveToElement(accountLink).perform();
        WebElement logoutLink = driver.findElement(By.className("ico-logout"));
        logoutLink.click();
        MyFunc.Bekle(2);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ico-login")));
        boolean logOut = driver.findElement(By.className("ico-login")).isDisplayed();
        if (logOut) {
            System.out.println("Başarıyla çıkış yapıldı.");
        } else {
            System.out.println("Çıkış yapılamadı.");
        }
BekleKapat();
    }

    }



