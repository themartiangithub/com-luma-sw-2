package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {

    //Declaring BaseURL
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage(){
        driver.findElement(By.xpath("//span[text() = 'Sale']")).click();
        driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html'][text()='Jackets']")).click();
        String expected = "Jackets";
        String actual = driver.findElement(By.xpath("//span[@class = 'base']")).getText();
        List<WebElement> items = driver.findElements(By.xpath("//li[@class = 'item product product-item']"));
        List<WebElement> itemsName = driver.findElements(By.xpath("//a[@class = 'product-item-link']"));
        System.out.println("Total Items : "+items.size());

        for(WebElement list : itemsName){
            System.out.println(list.getText());
        }

        int count = 12;
        int actualCount = items.size();
        Assert.assertEquals(count,actualCount);

    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
