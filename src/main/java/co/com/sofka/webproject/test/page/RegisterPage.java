package co.com.sofka.webproject.test.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    @CacheLookup
    @FindBy(id = "gender-male")
    WebElement genderMale;
    @CacheLookup
    @FindBy(id = "FirstName")
    WebElement firstName;
    @CacheLookup
    @FindBy(id = "LastName")
    WebElement lastName;
    @CacheLookup
    @FindBy(id = "Email")
    WebElement email;
    @CacheLookup
    @FindBy(id = "Password")
    WebElement password;
    @CacheLookup
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;
    @CacheLookup
    @FindBy(id = "register-button")
    WebElement registerButton;

    public WebElement getGenderMale(){
        return genderMale;
    }
    public WebElement getFirstName(){
        return firstName;
    }
    public WebElement getLastName(){
        return lastName;
    }
    public WebElement getEmail(){
        return email;
    }
    public WebElement getPassword(){
        return password;
    }
    public WebElement getConfirmPassword(){ return confirmPassword;}
    public WebElement getRegisterButton(){ return registerButton;}

    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
