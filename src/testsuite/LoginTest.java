package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest { //calling the BaseTest class to LoginTest class
    String baseUrl = "http://the-internet.herokuapp.com/login"; //URL

    @Before
    public void setUp() {
        openBrowser(baseUrl); //Method for launching the browser
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.id("username")).sendKeys("tomsmith"); //Username enter
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!"); //Password enter
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();  // clicking login button
        String expectedMessage ="You logged into a secure area!\n" +  //Storing expected Text
                "×";
        String actualMessage = driver.findElement(By.id("flash")).getText(); // storing actual Text
        Assert.assertEquals(actualMessage, expectedMessage);  // Comparing actual and expected text
    }
    @Test

    public void verifyTheUsernameErrorMessage() {
        driver.findElement(By.id("username")).sendKeys("tomsmith1"); //Username enter
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!"); //Password enter
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();  // clicking login button
        String expectedMessage = "Your username is invalid!\n" +  //Storing expected Text
                "×";
        String actualMessage = driver.findElement(By.id("flash")).getText(); // storing actual Text
        Assert.assertEquals(actualMessage, expectedMessage); // Comparing actual and expected text
    }
    @Test
    public void verifyThePasswordErrorMessage() {
        driver.findElement(By.id("username")).sendKeys("tomsmith"); //Username enter
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");  //Password enter
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();  //clicking login button
        String expectedMessage = "Your password is invalid!\n" +
                "×"; //Storing expected Text
        String actualMessage = driver.findElement(By.id("flash")).getText(); // storing actual Text
        Assert.assertEquals(actualMessage, expectedMessage); // Comparing actual and expected text
    }

    @After
    public void tearDown() {
        closeBrowser();
    } //closing the browser

}
