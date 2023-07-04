package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //Mouse Hover on “Electronics” Tab
        String menu = "Electronics";
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li/a[text() ='" + menu + " ']"));
        // Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
       //Verify the text “Cell phones”
        String exText = "Cell phones";
        String acText = getTextFromElement(By.xpath("//h1[text()='Cell phones']"));
        Assert.assertEquals("Cell phones",acText);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //Mouse Hover on “Electronics” Tab
        String menu = "Electronics";
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li/a[text() ='" + menu + " ']"));
        // Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        Thread.sleep(1000);
        //Verify the text “Cell phones”
        String exText = "Cell phones";
        String acText = getTextFromElement(By.xpath("//h1[text()='Cell phones']"));
        Assert.assertEquals("Cell phones", acText);
        Thread.sleep(1000);
        //4 Click on List View Tab
        clickOnElement(By.xpath("//a[@class='viewmode-icon list']"));
        //Click on product name “Nokia Lumia 1020” link
        mouseHoverToElementAndClick(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));
        Thread.sleep(1000);
        /**Verify the text “Nokia Lumia 1020”*/
        String expectedNokia = "Nokia Lumia 1020";
        String actualNokia = getTextFromElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));
        Assert.assertEquals("Nokia Lumia 1020", actualNokia);
        Thread.sleep(1000);
        //Verify the price “$349.00”
        String expectedPrice = "$349.00";
        String actualPrice = getTextFromElement(By.xpath("//span[text()='$349.00']"));
        Assert.assertEquals("$349.00", actualPrice);
        Thread.sleep(1000);
        //Change quantity to 2
        //Click on “ADD TO CART” tab
        clickOnElement(By.cssSelector("div.master-wrapper-page:nth-child(7) div.master-wrapper-content div.master-column-wrapper div.center-2 div.page.category-page div.page-body div.products-container div.products-wrapper div.product-list div.item-grid div.item-box:nth-child(3) div.product-item div.details div.add-info div.buttons > button.button-2.product-box-add-to-cart-button:nth-child(1)"));
        Thread.sleep(1000);
        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String exMessage = "The product has been added to your shopping cart";
        String acMessage = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals("The product has been added to your shopping cart", acMessage);
        Thread.sleep(1000);
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));
        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElementAndClick(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        Thread.sleep(1000);
        //Verify the message "Shopping cart"
        String exShoppingart = "Shopping cart";
        String acShoppingCart = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Shopping cart", acShoppingCart);
        Thread.sleep(1000);
        //Verify the quantity is 1
        String exQuantity = "1";
        String acQuantity = getTextFromElement(By.xpath("//input[@id='itemquantity11228']"));
        Assert.assertEquals("1",acQuantity);
        Thread.sleep(1000);
        //Verify the Total $698.00
        String exPrice = "$698.00";
        String acPrice = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        Assert.assertEquals("$698.00",acPrice);
        Thread.sleep(1000);
        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        // Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        Thread.sleep(1000);
        //Verify the Text “Welcome, Please Sign In!”
        String exWelome = "Welcome, Please Sign In!";
        String acWelcome = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Welcome, Please Sign In!",acWelcome);
        Thread.sleep(1000);
        //Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        //Verify the text “Register”
        String exRegister = "Register";
        String acRegister = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals("Register",acRegister);
        Thread.sleep(1000);
        //Fill the mandatory fields
        clickOnElement(By.xpath("//input[@id='gender-male']"));
        sendTextToElements(By.xpath("//input[@name='FirstName']"),"Abcd");
        sendTextToElements(By.xpath("//input[@id='LastName']"),"Fgh");
        sendTextToElements(By.xpath("//input[@id='Email']"),"abc@gmail.com");
        sendTextToElements(By.xpath("//input[@id='Password']"),"chintz111");
        sendTextToElements(By.xpath("//input[@id='ConfirmPassword']"),"chintz111");
        Thread.sleep(1000);
        // Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));
        // Verify the message “Your registration completed”
        String exMsg = "Your registration completed";
        String acMsg = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals("Your registration completed",acMsg);
        Thread.sleep(1000);
        //Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[@class='button-1 register-continue-button']"));
        //Verify the text “Shopping cart”
        String exeShoppingCart = "Shopping cart";
        String actShoppingCart = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Shopping cart",actShoppingCart);
        Thread.sleep(1000);
        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        Thread.sleep(1000);
        //Fill the Mandatory fields
        //FirstName
        sendTextToElements(By.xpath("//input[@name='BillingNewAddress.FirstName']"), "Abcde");
        Thread.sleep(1000);
        //LastName
        sendTextToElements(By.xpath("//input[@name='BillingNewAddress.LastName']"), "Fghi");
        //Email
        sendTextToElements(By.xpath("//input[@name='BillingNewAddress.Email']"), "xyz@gmail.com");
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//option[contains(text(),'United Kingdom')]"));
        sendTextToElements(By.id("//input[@id='BillingNewAddress_City']"), "Wembley");
        Thread.sleep(1000);
        //Zip / postal code
        sendTextToElements(By.id("//input[@id='BillingNewAddress_ZipPostalCode']"), "HA1 1AH");
        //phone number
        sendTextToElements(By.id("//input[@id='BillingNewAddress_PhoneNumber']"), "01234567891");
        Thread.sleep(1000);
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[text()='Continue']"));
        //Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//label[contains(text(),'2nd Day Air ($0.00)')]"));
        // Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        Thread.sleep(1000);
        //Select Radio Button “Credit Card
        clickOnElement(By.xpath("//label[@for='paymentmethod_1']"));
        // Select “Visa” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.id("name"), "Visa");
        Thread.sleep(1000);
        //Fill all the details
        sendTextToElements(By.xpath("//input[@id='CardholderName']"), "Abcde");
        sendTextToElements(By.xpath("//input[@name='CardNumber']"), "5555 4444 3333 1111");
        Thread.sleep(1000);
        //Expiration date
        selectByValueFromDropDown(By.id("value"), "3");
        selectByValueFromDropDown(By.id("value"), "2030 ");
        sendTextToElements(By.xpath("//input[@id='CardCode']"), "737");
        Thread.sleep(1000);
        //Click on “CONTINUE
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //Verify “Payment Method” is “Credit Card
        String exPaymentMethod = "Credit Card";
        String acPaymentMethod = getTextFromElement(By.xpath("li[class='payment-method'] span[class='value']"));
        Assert.assertEquals("Credit Card", acPaymentMethod);
        Thread.sleep(1000);
        //Verify “Shipping Method” is “2nd Day Air”
        String exShippingMethd = "2nd Day Air";
        String acShippingMethod = getTextFromElement(By.xpath("//span[normalize-space()='2nd Day Air']"));
        Assert.assertEquals("2nd Day Air", acShippingMethod);
        Thread.sleep(1000);
        //Verify the Text “Thank You”
        String expText = "Thank You";
        String actText = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Thank You", actText);
        Thread.sleep(1000);

        //Verify the message “Your order has been successfully processed!”
        String expMessage = "Your order has been successfully processed!";
        String actMessage = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Thread.sleep(1000);
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        // Verify the text “Welcome to our store”
        String eText = "Welcome to our store";
        String aText = getTextFromElement(By.xpath("//h2[text()='Welcome to our store']"));
        Assert.assertEquals("Welcome to our store", aText);
        //Click on “Logout” link
        mouseHoverToElementAndClick(By.xpath("//a[contains(text(),'Log out')]"));
        //Verify the URL is “https://demo.nopcommerce.com/
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://demo.nopcommerce.com/");

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
