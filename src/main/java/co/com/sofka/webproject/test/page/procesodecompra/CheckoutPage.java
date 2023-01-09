package co.com.sofka.webproject.test.page.procesodecompra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    @CacheLookup
    @FindBy(id = "BillingNewAddress_Company")
    WebElement company;

    @CacheLookup
    @FindBy(xpath = "//*[@class=\"inputs\"]")
    WebElement country;

    @CacheLookup
    @FindBy(id = "BillingNewAddress_City")
    WebElement city;


    @CacheLookup
    @FindBy(id = "BillingNewAddress_Address1")
    WebElement address;

    @CacheLookup
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement postalCode;

    @CacheLookup
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phoneNumber;

    @CacheLookup
    @FindBy(xpath = "//input[@value=\"Continue\"]")
    WebElement continuar;

    public WebElement getContinuar() {
        return continuar;
    }

    public WebElement getAdress() {
        return address;
    }

    public WebElement getCompany() {
        return company;
    }

    public WebElement getCountry() {
        return country;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getPostalCode() {
        return postalCode;
    }

    public WebElement getPhoneNumber() {
        return phoneNumber;
    }

    public CheckoutPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
