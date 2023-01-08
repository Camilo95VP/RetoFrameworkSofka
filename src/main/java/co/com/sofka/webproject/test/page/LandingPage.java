package co.com.sofka.webproject.test.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    @CacheLookup
    @FindBy(className = "ico-register")
    WebElement register;

    public WebElement getRegister(){
        return register;
    }

    public LandingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
