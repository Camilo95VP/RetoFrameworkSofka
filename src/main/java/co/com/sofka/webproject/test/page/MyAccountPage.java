package co.com.sofka.webproject.test.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]")
    WebElement registerCompletedLabel;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
    WebElement registredEmail;

    public WebElement getRegisterCompletedLabel(){
        return registerCompletedLabel;
    }
    public WebElement getRegistredEmail(){
        return registredEmail;
    }

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
