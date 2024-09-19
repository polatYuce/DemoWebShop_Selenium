package UserStory_7;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Queue;

public class SurveyResponse extends BaseDriver {

    @Test
    public void Test1() {
        driver.get(" https://demowebshop.tricentis.com/");
        MyFunc.Bekle(3);

        WebElement pollOption = driver.findElement(By.xpath("//input[@id='pollanswers-1']"));
        pollOption.click();
        MyFunc.Bekle(3);

        WebElement voteButton = driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
        voteButton.click();
        MyFunc.Bekle(3);

        WebElement errorMessage = driver.findElement(By.xpath("//*[@id='block-poll-vote-error-1']"));
        if (errorMessage.isDisplayed()) {
            System.out.println("Hata mesajı görüntülendi: Sadece kayıtlı kullanıcılar oy verebilir.");
        }





    }}
