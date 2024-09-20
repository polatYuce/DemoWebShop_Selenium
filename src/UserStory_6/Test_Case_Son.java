package Test_Case_06;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Test_Case_Son extends BaseDriver {

    @Test
    public void Test6() {

        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.Bekle(2);
        WebElement loginButon = driver.findElement(By.className("ico-login"));
        if (driver.getCurrentUrl().equals("https://demowebshop.tricentis.com/login"))
            System.out.println("Giriş Yapılmış.");
        else {
            System.out.println("loginButon.getText() = " + loginButon.getText());
            loginButon.click();
            MyFunc.Bekle(2);


            WebElement loginEmail = driver.findElement(By.id("Email"));
            loginEmail.sendKeys("techno.study5@gmail.com");

            WebElement loginPassword = driver.findElement(By.cssSelector("[id$='Password']"));
            loginPassword.sendKeys("pass1234");

            WebElement submitbuton = driver.findElement(By.cssSelector("input[type='submit'][value='Log in']"));
            submitbuton.click();
            MyFunc.Bekle(2);

        }

        //TODO Giriş İşlemleri Başarıyla Tamamlandı.


        WebElement computers = driver.findElement(By.xpath("//ul[@class='top-menu']/li[2]/a"));
        new Actions(driver).moveToElement(computers).build().perform();
        computers.click();
        MyFunc.Bekle(2);


        WebElement notebook = driver.findElement(By.xpath("(//a[@href='/notebooks'])[4]"));
        notebook.click();
        MyFunc.Bekle(3);

        //TODO Sepete ekleme kısmına geç -> 4. ADIM

        WebElement addtoCart = driver.findElement(By.xpath("//input[@value='Add to cart']"));
        addtoCart.click();
        MyFunc.Bekle(2);

        //TODO Shopping Cart butonuna bas -> 5. ADIM

        WebElement shoppingCard = driver.findElement(By.xpath("//span[text()='Shopping cart']"));
        shoppingCard.click();
        MyFunc.Bekle(2);

        //TODO Ülke seç -> 6. ve 7. ADIM

        WebElement ulke = driver.findElement(By.id("CountryId"));
        Select javaSelect = new Select(ulke);
        javaSelect.selectByVisibleText("Turkey");


        WebElement state = driver.findElement(By.className("state-input"));
        Select javaSelect2 = new Select(state);
        javaSelect2.selectByValue("0");

        //TODO Check Box işaretle 8. ADIM
        WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        checkbox.click();

        //TODO 9. ADIM Check out ödeme kısmına tıkla

        WebElement checkout = driver.findElement(By.xpath("//button[@type='submit' and @id='checkout']"));
        checkout.click();
        MyFunc.Bekle(2);

        //TODO 10. ADIM ÖDEME BİLGİLERİNİ GİR
        WebElement billing_adres = driver.findElement(By.xpath("//select[@name='billing_address_id' and @id='billing-address-select']"));
        Select select_adres = new Select(billing_adres);
        select_adres.selectByVisibleText("New Address");

        WebElement odeme_first_name = driver.findElement(By.xpath("//input[@name='BillingNewAddress.FirstName']"));
        odeme_first_name.sendKeys("Techno");

        WebElement odeme_last_name = driver.findElement(By.xpath("//*[@id='BillingNewAddress_LastName']"));
        odeme_last_name.sendKeys("Study");

        // WebElement odeme_mail = driver.findElement(By.cssSelector("input[id='BillingNewAddress_Email']"));
        // odeme_mail.sendKeys("techno.study5@gmail.com");
        // Email kayıtlı geldiği için tekrar göndermeye gerek kalmadı.

        WebElement odeme_company = driver.findElement(By.xpath("//input[@id='BillingNewAddress_Company']"));
        odeme_company.sendKeys("Company-Techno");

        WebElement odeme_country = driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"));
        Select countryID = new Select(odeme_country);
        countryID.selectByVisibleText("United States");

        MyFunc.Bekle(2);

        WebElement odeme_state = driver.findElement(By.xpath("//select[@id='BillingNewAddress_StateProvinceId'and @name='BillingNewAddress.StateProvinceId']"));

        Select stateID = new Select(odeme_state);
        stateID.selectByValue("3");

        MyFunc.Bekle(1);

        WebElement odeme_city = driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']"));
        odeme_city.sendKeys("Ankara");

        WebElement odeme_adres1 = driver.findElement(By.xpath("//input[@name='BillingNewAddress.Address1']"));
        odeme_adres1.sendKeys("Kalaba Mah.");

        WebElement odeme_adres2 = driver.findElement(By.xpath("//*[@id='BillingNewAddress_Address2']"));
        odeme_adres2.sendKeys("Halic Sokak");

        WebElement odeme_zip = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
        odeme_zip.sendKeys("06120");

        WebElement odeme_telefon = driver.findElement(By.cssSelector("input[id='BillingNewAddress_PhoneNumber']"));
        odeme_telefon.sendKeys("5554932514");

        WebElement odeme_fax = driver.findElement(By.cssSelector("input[id='BillingNewAddress_FaxNumber']"));
        odeme_fax.sendKeys("0000");

        MyFunc.Bekle(2);

        //TODO Continue bas

        WebElement odeme_continue = driver.findElement(By.xpath("(//input[@type='button' and @title='Continue'])[1]"));
        odeme_continue.click();
        MyFunc.Bekle(3);

        //TODO Shipping adres gir

        WebElement shipping_adres = driver.findElement(By.xpath("//select[@name='shipping_address_id']"));
        Select select_shipping = new Select(shipping_adres);
        select_shipping.selectByVisibleText("New Address");

        MyFunc.Bekle(2);

        WebElement shipping_firstname = driver.findElement(By.id("ShippingNewAddress_FirstName"));
        shipping_firstname.sendKeys("Techno");

        WebElement shipping_lastname = driver.findElement(By.cssSelector("input[id='ShippingNewAddress_LastName']"));
        shipping_lastname.sendKeys("Study");

        // WebElement shipping_email = driver.findElement(By.xpath("//*[@id='id=ShippingNewAddress_Email']"));
        // shipping_email.sendKeys("techno.study5@gmail.com");
        // Email kayıtlı geldiği için tekrar göndermeye gerek kalmadı

        WebElement shipping_company = driver.findElement(By.xpath("//*[@id='ShippingNewAddress_Company']"));
        shipping_company.sendKeys("Techno Study");

        WebElement shipping_country = driver.findElement(By.xpath("//select[@id='ShippingNewAddress_CountryId']"));
        Select select_country = new Select(shipping_country);
        select_country.selectByVisibleText("United States");
        MyFunc.Bekle(1);

        WebElement shipping_State = driver.findElement(By.xpath("//select[@id='ShippingNewAddress_StateProvinceId']"));
        Select select_state = new Select(shipping_State);
        select_state.selectByVisibleText("Alabama");

        WebElement shipping_city = driver.findElement(By.xpath("//*[@id='ShippingNewAddress_City']"));
        shipping_city.sendKeys("Huntsville");

        WebElement shipping_addres1 = driver.findElement(By.xpath("//*[@name='ShippingNewAddress.Address1']"));
        shipping_addres1.sendKeys("Auckland Street");

        WebElement shipping_addres2 = driver.findElement(By.xpath("//input[@id='ShippingNewAddress_Address2']"));
        shipping_addres2.sendKeys("No 17");

        WebElement shipping_postal = driver.findElement(By.id("ShippingNewAddress_ZipPostalCode"));
        shipping_postal.sendKeys("0655");

        WebElement shipping_phone = driver.findElement(By.xpath("//*[@id='ShippingNewAddress_PhoneNumber']"));
        shipping_phone.sendKeys("009955544");

        WebElement shipping_fax = driver.findElement(By.xpath("//*[@id='ShippingNewAddress_FaxNumber']"));
        shipping_fax.sendKeys("0000");
        MyFunc.Bekle(2);

        WebElement shipping_button = driver.findElement(By.xpath("//input[@onclick='Shipping.save()']"));
        shipping_button.click();

        //TODO Shipping Method seçilecek

        WebElement shipping_method = driver.findElement(By.xpath("//input[@id='shippingoption_2']"));
        shipping_method.click();
        MyFunc.Bekle(4);
        WebElement shipping_method1 = driver.findElement(By.xpath("//input[@id='shippingoption_1']"));
        shipping_method1.click();
        MyFunc.Bekle(4);

        WebElement shipping_method_button = driver.findElement(By.xpath("//input[@type='button' and @onclick='ShippingMethod.save()']"));
        shipping_method_button.click();


        //TODO Payment Moethod seçilecek

        WebElement payment_method = driver.findElement(By.cssSelector("[id='paymentmethod_1']"));
        payment_method.click();
        MyFunc.Bekle(2);

        WebElement payment_method2 = driver.findElement(By.cssSelector("[id='paymentmethod_2']"));
        payment_method2.click();
        MyFunc.Bekle(2);

        WebElement payment_method_button = driver.findElement(By.xpath("//*[@type='button' and @onclick='PaymentMethod.save()']"));
        payment_method_button.click();


// TODO Payment Info gir

        WebElement payment_credit_card = driver.findElement(By.xpath("//select[@id='CreditCardType']"));
        Select select_payment = new Select(payment_credit_card);
        select_payment.selectByValue("MasterCard");

        WebElement payment_name = driver.findElement(By.xpath("//*[@id='CardholderName']"));
        payment_name.sendKeys("Techno Study");

        WebElement payment_number = driver.findElement(By.xpath("//*[@id='CardNumber']"));
        payment_number.sendKeys("000000");

        WebElement payment_date = driver.findElement(By.xpath("//select[@id='ExpireMonth']"));
        Select select_Date = new Select(payment_date);
        select_Date.selectByVisibleText("02");
        MyFunc.Bekle(2);
        select_Date.selectByVisibleText("04");

        WebElement payment_date2 = driver.findElement(By.xpath("//select[@id='ExpireYear']"));
        Select select_year = new Select(payment_date2);
        select_year.selectByIndex(3);
        MyFunc.Bekle(2);
        select_year.selectByIndex(4);

        WebElement payment_code = driver.findElement(By.xpath("//input[@id='CardCode']"));
        payment_code.sendKeys("000");

        MyFunc.Bekle(2);

        WebElement payment_button = driver.findElement(By.xpath("//*[@type='button' and @onclick='PaymentInfo.save()']"));
        payment_button.click();

        //TODO Confirmation tıkla
        WebElement confirm_order = driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']"));
        confirm_order.click();
/*
        //TODO text karşılaştır

        WebElement txtMesaj = driver.findElement(By.xpath("//div[@class='title']/strong"));
        Assert.assertTrue("Mesaj bulunamadı ", txtMesaj.getText().equalsIgnoreCase("Your order has been successfully processed!"));
        System.out.println("txtMesaj = " + txtMesaj);
        MyFunc.Bekle(5);
        System.out.println("Sipariş verildi ekranda görüldü mü kısmı====");
        //Order number: 1792065
//Order number: 1792183

       WebElement order_no=driver.findElement(By.xpath("//li[contains(@text='Order number')]"));
        String siparis_no=order_no.getText();


        //TODO Orders karşılaştır

        WebElement orders=driver.findElement(By.xpath("//li[@href='/customer/orders']"));
        orders.click();


        Assert.assertTrue("Sipariş No Bulunamadı", order_no.getText().equalsIgnoreCase(siparis_no));

        WebElement son_order=driver.findElement(By.xpath("(//li[contains(@text='Order number')])(1)"));
String son_siparis=son_order.getText();

if (son_siparis.equals(siparis_no))
    System.out.println("Sipariş Doğrulandı");
else
    System.out.println("HATAAA");*/

        // Sipariş doğrulandı yazısı yazdır -- Order processed!
        WebElement order_placed = driver.findElement(By.xpath("//div[@class='title']/strong"));
        String siparis_goruldu = order_placed.getText(); //
        System.out.println("siparis_goruldu = " + siparis_goruldu);
        System.out.println("order_placed = " + order_placed.getText());

        Assert.assertTrue("Mesaj bulunamadı ", order_placed.getText().equalsIgnoreCase("Your order has been successfully processed!"));
        MyFunc.Bekle(2);
// Sipariş Numarasını al

        WebElement order_number = driver.findElement(By.xpath("//ul[@class='details']/li"));
        System.out.println("order_number.getText = " + order_number.getText());
        String dogrulama_son = String.valueOf(order_number.getText());

// Orders sayfasına git
        WebElement ordersLink = driver.findElement(By.xpath("//a[@href='/customer/orders']"));
        ordersLink.click();
        MyFunc.Bekle(10);
// Orders sayfasında sipariş numarasını bul ve kontrol et
        WebElement successMessage = driver.findElement(By.xpath("(//div[@class='title']/strong)[2]"));
        System.out.println("succes mesaj = " + successMessage.getText());

        String son_siparis = successMessage.getText(); // Gerekiyorsa temizleyin
        System.out.println("Succes mesaj get text = " + successMessage.getText());

        MyFunc.Bekle(2);
// Sipariş numarasını karşılaştırın

        if (son_siparis.equalsIgnoreCase(dogrulama_son))
            System.out.println("Sipariş Doğrulandı");
        else
            System.out.println("HATAAA: Sipariş numarası eşleşmedi.");


        System.out.println("Son sipariş= == " + son_siparis);
        System.out.println("siparis_goruldu = " + siparis_goruldu);


// Assert ile doğrulama


        System.out.println("dogrulama_son = " + dogrulama_son);

        Assert.assertTrue("Sipariş numarası Orders sayfasında bulunamadı!", son_siparis.equalsIgnoreCase(dogrulama_son));


        BekleKapat();
    }


}
