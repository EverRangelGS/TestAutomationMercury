package grupo.prueba.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageFactoryLogin {
    //-----------------------------------Global Variables-----------------------------------
    private WebDriver driver;

    //PageFactory annotations large

    @FindBy(how = How.NAME, using = "userName")
    private WebElement userFieldElement;
    @FindBy(how = How.NAME, using = "password")
    private WebElement passFieldElement;
    @FindBy(how = How.NAME, using = "login")
    private WebElement loginBtnElement;
    @FindBy(how = How.TAG_NAME, using = "input")
    private List<WebElement> fields;

    //PageFactory annotations short
    /*
    @FindBy(name= "userName")
    private WebElement userFieldElement;
    @FindBy(name = "password")
    private WebElement passFieldElement;
    @FindBy(name = "login")
    private WebElement loginBtnElement;
    @FindBy(tagName = "input")
    private List<WebElement> fields;*/

    public PageFactoryLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void login(String user, String pass){
        userFieldElement.sendKeys(user);
        passFieldElement.sendKeys(pass);
        loginBtnElement.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //Máx 5 seg
    }

    public void login_fields(String user, String pass){
        fields.get(1).sendKeys(user);
        fields.get(2).sendKeys(pass);
        loginBtnElement.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void verifyFields(){
        System.out.println("Cantidad de campos login: "+fields.size());
        Assert.assertEquals(fields.size(),5);
    }

    public void verifyTitle(){
        String title = driver.getTitle();
        userFieldElement.sendKeys(title);
        Assert.assertEquals("Welcome: Mercury Tours",title);
    }
}
