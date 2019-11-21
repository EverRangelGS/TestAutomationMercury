package grupo.prueba.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PageLogon {

    //-----------------------------------Global Variables-----------------------------------
    //Declare a Webdriver variable
    private WebDriver driver;
    private By titleText;
    private By signonImg;

    public PageLogon(WebDriver driver) {
        this.driver = driver;
        //titleText = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table//p/font/b[1]");
        signonImg = By.xpath("//img[@src='/images/masts/mast_signon.gif']");
    }

    public void assertPage(){
        //Assert.assertTrue(driver.findElement(titleText).getText().contains("Welcome back to"));
        Assert.assertTrue(driver.findElement(signonImg).isDisplayed());
    }

}
