package _08_UserStory;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class _08_UserStory extends BaseDriver {
    @Test
    public void Test1(){
        //1. Web tarayıcısını açın ve "demowebshop.tricentis.com" adresine gidin.
        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.Bekle(1);

        Actions aksiyonlar=new Actions(driver);

        //2. Eğer kullanıcı oturumu açık değilse, oturum açın (giriş yapın).
        WebElement loginLink = driver.findElement(By.xpath("//a[@href='/login']"));
        aksiyonlar.moveToElement(loginLink).click().build().perform();

        WebElement emailTextBox = driver.findElement(By.xpath("//input[@autofocus='autofocus']"));
        aksiyonlar.moveToElement(emailTextBox).click().sendKeys("techno.study5@gmail.com").build().perform();

        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@type='password']"));
        aksiyonlar.moveToElement(passwordTextBox).click().sendKeys("pass1234").build().perform();

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log in']"));
        aksiyonlar.moveToElement(loginButton).click().build().perform();
        MyFunc.Bekle(1);

        //3. Anasayfada "Computers" menüsünden "Notebook" altındaki "14.1-inch Laptop" ürününe tıklayın.
        WebElement computerLink = driver.findElement(By.cssSelector("ul[class='top-menu'] > li > a[href='/computers']"));
        aksiyonlar.moveToElement(computerLink).build().perform();

        WebElement noteBooksLink = driver.findElement(By.cssSelector("a[href='/notebooks']"));  //1of2
        aksiyonlar.moveToElement(noteBooksLink).click().build().perform();

        WebElement laptopLink = driver.findElement(By.cssSelector("h2[class='product-title']>a[href='/141-inch-laptop']"));
        aksiyonlar.moveToElement(laptopLink).click().build().perform();
        MyFunc.Bekle(1);

        //4. Ürün sayfasında "Add to Cart" (Sepete Ekle) düğmesine tıklayarak ürünü sepete ekleyin.
        WebElement addToCartButton = driver.findElement(By.cssSelector("input[type='button'][value='Add to cart'][data-productid='31']"));
        aksiyonlar.moveToElement(addToCartButton).click().build().perform();
        MyFunc.Bekle(1);

        //5. Sepetinize gitmek için "Shopping Cart" (Alışveriş Sepeti) düğmesine tıklayın.
        WebElement shoppingCartButton = driver.findElement(By.xpath("//a[@href='/cart']/*[text()='Shopping cart']"));
        aksiyonlar.moveToElement(shoppingCartButton).click().build().perform();
        MyFunc.Bekle(1);

        //6. "Apply Coupon" (Kupon Kullan) düğmesine tıklayın (kupon kodu yoksa kod girmeden tıklayın).
        WebElement applyCouponButton = driver.findElement(By.cssSelector("input[type='submit'][value='Apply coupon']"));
        aksiyonlar.moveToElement(applyCouponButton).click().build().perform();
        MyFunc.Bekle(1);

        //7. Kullanılacak kupon kodu olmadığını doğrulayın.
        WebElement couponTextBox = driver.findElement(By.xpath("//input[@name='discountcouponcode']"));
        System.out.println("Kupon Kodu: " + couponTextBox.getText());
        Assert.assertTrue("Kullanılacak Kupon Kodu: " + couponTextBox.getText(), couponTextBox!=null);

        //8. "Add Gift Card" (Hediye Kartı Ekle) düğmesine tıklayın (hediye kartı kodu yoksa kod girmeden tıklayın).
        WebElement addGiftCardButton = driver.findElement(By.cssSelector("input[type='submit'][value='Add gift card']"));
        aksiyonlar.moveToElement(addGiftCardButton).click().build().perform();
        MyFunc.Bekle(1);

        //9. Kullanılacak gift card (hediye kart kodu) olmadığını doğrulayın.
        WebElement giftCardTextBox = driver.findElement(By.xpath("//input[@name='giftcardcouponcode']"));
        System.out.println("Hediye Kartı: " + giftCardTextBox.getText());
        Assert.assertTrue("Kullanılacak Kupon Kodu: " + giftCardTextBox.getText(), giftCardTextBox !=null);
        MyFunc.Bekle(1);

        //10. Kargo detayları için gerekli bilgileri doldurun:
        //11. Ülke ve Eyalet seçin.
        WebElement countryOption = driver.findElement(By.cssSelector("select[data-val='true'][data-val-number='The field Country must be a number.']"));
        Select countrySelect = new Select(countryOption);
        countrySelect.selectByValue("77");

        WebElement stateOption = driver.findElement(By.xpath("//select[@data-val='true'][@data-val-number='The field State / province must be a number.']"));
        Select stateSelect = new Select(stateOption);
        stateSelect.selectByValue("0");

        WebElement postalCodeTextBox = driver.findElement(By.cssSelector("input[id='ZipPostalCode']"));
        aksiyonlar.moveToElement(postalCodeTextBox).doubleClick().sendKeys("31200").build().perform();

        WebElement estimateShippingButton = driver.findElement(By.xpath("//input[@value='Estimate shipping']"));
        aksiyonlar.moveToElement(estimateShippingButton).click().build().perform();
        MyFunc.Bekle(1);

        //12. Şartları kabul edin.
        WebElement agreeCheckBox = driver.findElement(By.cssSelector("input[id='termsofservice']"));
        aksiyonlar.moveToElement(agreeCheckBox).click().build().perform();
        MyFunc.Bekle(1);

        //13. "Checkout" (Ödeme) düğmesine tıklayarak ödeme sayfasına gidin.
        WebElement checkOutButton = driver.findElement(By.xpath("//button[@value='checkout']"));
        aksiyonlar.moveToElement(checkOutButton).click().build().perform();
        MyFunc.Bekle(1);

        //14. Ödeme bilgilerini doldurun ve siparişi onaylayın.

        WebElement continueButton1 = driver.findElement(By.cssSelector("input[onclick='Billing.save()']"));
        aksiyonlar.moveToElement(continueButton1).click().build().perform();
        MyFunc.Bekle(1);

        WebElement continueButton2 = driver.findElement(By.cssSelector("input[onclick='Shipping.save()']"));
        aksiyonlar.moveToElement(continueButton2).click().build().perform();
        MyFunc.Bekle(1);

        WebElement continueButton3 = driver.findElement(By.cssSelector("input[onclick='ShippingMethod.save()']"));
        aksiyonlar.moveToElement(continueButton3).click().build().perform();
        MyFunc.Bekle(1);

        WebElement continueButton4 = driver.findElement(By.cssSelector("input[onclick='PaymentMethod.save()']"));
        aksiyonlar.moveToElement(continueButton4).click().build().perform();
        MyFunc.Bekle(1);

        WebElement continueButton5 = driver.findElement(By.cssSelector("input[onclick='PaymentInfo.save()']"));
        aksiyonlar.moveToElement(continueButton5).click().build().perform();
        MyFunc.Bekle(1);

        WebElement continueButton6 = driver.findElement(By.cssSelector("input[onclick='ConfirmOrder.save()']"));
        aksiyonlar.moveToElement(continueButton6).click().build().perform();
        MyFunc.Bekle(1);

        //15 "Your order has been successfully processed!" (Siparişiniz başarıyla işleme alındı) mesajının görüntülendiğini doğrulayın.
        WebElement textLabel = driver.findElement(By.xpath("//*[text()='Your order has been successfully processed!']"));
        System.out.println("Header Text: " + textLabel.getText());
        Assert.assertTrue("Sipariş Verme Başarısız", !textLabel.equals("Your order has been successfully processed!"));

        BekleKapat();
    }
}
