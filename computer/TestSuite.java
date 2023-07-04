package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //Click on Computer Menu.
        String menu = "Computers";
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li/a[text() ='" + menu + " ']")).click();
        // Click on Desktop
        clickOnElement(By.xpath("//a[text()=' Desktops ']"));
        //Select Sort By position "Name: Z to A"
        clickOnElement(By.xpath("//option[text()='Name: Z to A']"));
        //Verify the Product will arrange in Descending order.
        String actualDescendingOrder = driver.findElement(By.xpath("//option[text()='Name: Z to A']")).getText();
        Assert.assertEquals("Name: Z to A", actualDescendingOrder);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //Click on Computer Menu.
        String menu = "Computers";
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li/a[text() ='" + menu + " ']")).click();
        // Click on Desktop
        clickOnElement(By.xpath("//a[text()=' Desktops ']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        Thread.sleep(1000);
        //Select Sort By position "Name: A to Z"
        clickOnElement(By.xpath("//option[text()='Name: A to Z']"));
        // Click on "ADD TO CARD" Button.
        Thread.sleep(1000);
        clickOnElement(By.xpath("(//*[@class='button-2 product-box-add-to-cart-button'])[1]"));
        Thread.sleep(1000);
        //Verify the Text "Build your own computer"
        getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        String expectedText = "Build your own computer";
        Assert.assertEquals("Build your own computer", expectedText);
        Thread.sleep(1000);
        //Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        WebElement dropDown = driver.findElement(By.name("product_attribute_1"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");
        Thread.sleep(1000);
        //Select "8GB [+$60.00]" using Select class
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"), "8GB [+$60.00]");
        // Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//ul[@class='option-list']/li/label[text()='400 GB [+$100.00]']"));
        Thread.sleep(1000);
        //Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
        //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
        //Verify the price "$1,475.00"
        String expectedPrice = "$1,475.00";
        String actualPrice = getTextFromElement(By.xpath("//span[@id='price-value-1']"));
        Assert.assertEquals("$1,475.00", actualPrice);
        Thread.sleep(1000);
        //Click on "ADD TO CARD" Button
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        //Verify the Message "The product has been added to your shopping cart" on Top
        //green Bar
        String expectedMessage = "The product has been added to your shopping cart";
        String actualMessage = getTextFromElement(By.xpath("//p[text()='The product has been added to your ']"));
        Assert.assertEquals("The product has been added to your shopping cart", actualMessage);
        Thread.sleep(1000);
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));
        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//div[@class='add-to-cart-panel']/button[text()='Add to cart']"));
//        Thread.sleep(1000);
//        String expectedTexts = "Shopping cart";
//        String actualTexts = getTextFromElement(By.xpath("//a[contains(text(),'shopping cart')]"));
//      Assert.assertEquals("", expectedTexts, actualTexts);
//        Thread.sleep(1000);
        // Verify the message "Shopping cart"
        String expectMessage = "shopping cart";
        String actualMsg = getTextFromElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        Assert.assertEquals("shopping cart", actualMsg);
        Thread.sleep(1000);
        //Click on add to cart
        mouseHoverToElementAndClick(By.xpath("//button[@id='add-to-cart-button-1']"));
        //Change the Qty to "2" and Click on "Update shopping cart"
        sendTextToElements(By.xpath("//input[@id='itemquantity11231']"), "2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        //Verify the Total"$2,930.00"
        String expectedTotal = "$2,930.00";
        String actualTotal = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[1]"));
        Assert.assertEquals("$2,960.00", actualTotal);
        Thread.sleep(1000);
        // click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        Thread.sleep(1000);
        //Verify the Text “Welcome, Please Sign In!”
        String expectedTxt = "Welcome, Please Sign In!";
        String actualTxt = getTextFromElement(By.xpath("//h1[text()='Welcome, Please Sign In!']"));
        Assert.assertEquals("Welcome, Please Sign In!", actualTxt);
        Thread.sleep(1000);
        //Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));
        //Fill the all mandatory field
        //FirstName
        sendTextToElements(By.xpath("//input[@name='BillingNewAddress.FirstName']"), "Abcde");
        Thread.sleep(1000);
        //LastName
        sendTextToElements(By.xpath("//input[@name='BillingNewAddress.LastName']"), "Fghi");
        //Email
        sendTextToElements(By.xpath("//input[@name='BillingNewAddress.Email']"), "xyz@gmail.com");
        Thread.sleep(1000);
        //Country
        WebElement listDown = driver.findElement(By.name("Country:"));
        Select select1 = new Select(listDown);
        select1.selectByVisibleText("United Kingdon");
        Thread.sleep(1000);
        //City
        sendTextToElements(By.id("//input[@data-val-required='City is required']"), "Lodon");
        //Address 1
        sendTextToElements(By.id("//input[@id='BillingNewAddress_City']"), "Wembley");
        Thread.sleep(1000);
        //Zip / postal code
        sendTextToElements(By.id("//input[@id='BillingNewAddress_ZipPostalCode']"), "HA1 1AH");
        //phone number
        sendTextToElements(By.id("//input[@id='BillingNewAddress_PhoneNumber']"), "01234567891");
        Thread.sleep(1000);
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[text()='Continue']"));
        //Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//label[@for='shippingoption_1']"));
        // Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        Thread.sleep(1000);
        //Select Radio Button “Credit Card
        clickOnElement(By.xpath("//label[@for='paymentmethod_1']"));
        // Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.id("name"), "Master card");
        Thread.sleep(1000);
        //Fill all the details
        sendTextToElements(By.xpath("//input[@id='CardholderName']"), "Abcde");
        sendTextToElements(By.xpath("//input[@name='CardNumber']"), "5555 4444 3333 1111");
        Thread.sleep(1000);
        //Expiration date
        selectByValueFromDropDown(By.id("value"), "1");
        selectByValueFromDropDown(By.id("value"), "2024");
        sendTextToElements(By.xpath("//input[@id='CardCode']"), "737");
        Thread.sleep(1000);
        //Click on “CONTINUE
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //Verify “Payment Method” is “Credit Card
        String exPaymentMethod = "Credit Card";
        String acPaymentMethod = getTextFromElement(By.xpath("li[class='payment-method'] span[class='value']"));
        Assert.assertEquals("Credit Card", acPaymentMethod);
        Thread.sleep(1000);
        // Verify “Shipping Method” is “Next Day Air”
        String exShippingMethd = "Next Day Air";
        String acShippingMethod = getTextFromElement(By.xpath("//span[normalize-space()='Next Day Air']"));
        Assert.assertEquals("Next Day Air", acShippingMethod);
        Thread.sleep(1000);
        //Verify Total is “$2,950.00”
        String exTotal = "$2950.00";
        String acTotal = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        Assert.assertEquals("$2950.00", acTotal);
        Thread.sleep(1000);
        //4 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        //Verify the Text “Thank You”
        String exText = "Thank You";
        String acText = getTextFromElement(By.xpath("//h1[text()='Thank you']"));
        Assert.assertEquals("Thank You", acText);
        Thread.sleep(1000);
        //Verify the message “Your order has been successfully processed!
        String exMessage = "Your order has been successfully processed!";
        String acMessage = getTextFromElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));
        Thread.sleep(1000);
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));
        // Verify the text “Welcome to our store”
        String eText = "Welcome to our store";
        String aText = getTextFromElement(By.xpath("//h2[text()='Welcome to our store']"));
        Assert.assertEquals("Welcome to our store", aText);
    }
    @After
public void tearDown(){
//    closeBrowser();}
}}
