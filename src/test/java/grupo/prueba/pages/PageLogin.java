package grupo.prueba.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageLogin {

    //-----------------------------------Global Variables-----------------------------------
    //Declare a Webdriver variable
    private WebDriver driver;

    private By userField;
    private By passField;
    private By loginBtn;
    private By fields;

    public PageLogin(WebDriver driver) {
        this.driver = driver;
        userField = By.name("userName");
        passField = By.cssSelector("input[name='password']");
        loginBtn = By.name("login");
        fields = By.tagName("input");
    }

    public void login(String user, String pass){
        driver.findElement(userField).sendKeys(user);
        driver.findElement(passField).sendKeys(pass);
        driver.findElement(loginBtn).click();
        //Helpers helper = new Helpers(); helper.waitSeconds(3);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //Esperara máximo 5 seg
    }

    public void login_fields(String user, String pass){
        List<WebElement> loginFiels = driver.findElements(fields); //findElements genera una lista de elementos <WebElements>
        loginFiels.get(1).sendKeys(user);
        loginFiels.get(2).sendKeys(pass);
        driver.findElement(loginBtn).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //Esperara máximo 5 seg
    }

    public void verifyFields(){
        List<WebElement> loginFiels = driver.findElements(fields); //findElements genera una lista de elementos <WebElements>
        System.out.println("Cantidad de campos login: "+loginFiels.size());
        Assert.assertEquals(loginFiels.size(),5);
    }

}
