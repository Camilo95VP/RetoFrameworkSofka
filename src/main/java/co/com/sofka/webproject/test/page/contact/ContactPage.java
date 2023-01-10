package co.com.sofka.webproject.test.page.contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

    @CacheLookup
    @FindBy(xpath = "//a[@href='/contactus']")
    WebElement btn_contact_us;

    @CacheLookup
    @FindBy(xpath = "//textarea[@class='enquiry']")
    WebElement enquiry;


    @CacheLookup
    @FindBy(xpath = "//input[@class='button-1 contact-us-button']")
    WebElement btn_submit;

    @CacheLookup
    @FindBy(xpath = "//div[@class='result']")
    WebElement message_successfull;

    @CacheLookup
    @FindBy(xpath = "//span[@class='field-validation-error']")
    WebElement message_unsuccessfull;

    public WebElement getMessage_unsuccessfull() {
        return message_unsuccessfull;
    }

    public WebElement getMessage_successfull() {
        return message_successfull;
    }

    public WebElement getBtn_contact_us() {
        return btn_contact_us;
    }

    public WebElement getEnquiry() {
        return enquiry;
    }

    public WebElement getBtn_submit() {
        return btn_submit;
    }

    public ContactPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
