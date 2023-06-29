package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {

    //Declaring BaseURL
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSignInPageDisplay(){
        driver.findElement(By.xpath("//div[@class = 'panel header']//a[text() = 'Create an Account']")).click();
        String expected = "Create New Customer Account";
        String actual = driver.findElement(By.xpath("//span[@class = 'base']")).getText();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void userShouldRegisterAccountSuccessfully(){
        driver.findElement(By.xpath("//div[@class = 'panel header']//a[text() = 'Create an Account']")).click();
        driver.findElement(By.id("firstname")).sendKeys("YK");
        driver.findElement(By.id("lastname")).sendKeys("Modi");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.id("email_address")).sendKeys("yrpatel@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Prime@123");
        driver.findElement(By.id("password-confirmation")).sendKeys("Prime@123");
        driver.findElement(By.xpath("//button[@class = 'action submit primary']")).click();
        String expected = "Thank you for registering with Main Website Store.";
        String actual = driver.findElement(By.xpath("//div[text() = 'Thank you for registering with Main Website Store.']")).getText();
        Assert.assertEquals(expected,actual);
        driver.findElement(By.xpath("//button[@class = 'action switch']")).click();
        driver.findElement(By.xpath("//li[@class = 'authorization-link']")).click();

    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
