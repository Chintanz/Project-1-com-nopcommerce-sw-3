package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;
public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    /**create method with name "selectMenu" it has one parameter name "menu" of type string.
    //This method should click on the menu whatever name is passed as parameter*/
    public void selectMenu(){
        String menu = "Computers";
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li/a[text() ='" + menu + " ']")).click();
    }
@Test
//create the @Test method name verifyPageNavigation.use selectMenu method to
//select the Menu and click on it and verify the page navigation.
public void verifyPageNavigation() {
      selectMenu();
}


    @After
    public void tearDown() {
//      closeBrowser();}
    }
}
