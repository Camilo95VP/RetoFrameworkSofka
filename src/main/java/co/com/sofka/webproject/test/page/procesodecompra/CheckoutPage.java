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
    @FindBy(id = "BillingNewAddress_CountryId")
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
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continuar;

    @CacheLookup
    @FindBy(xpath = "//input[@onclick='Shipping.save()']")
    WebElement continuar2;

    @CacheLookup
    @FindBy(xpath = "//input[@onclick='ShippingMethod.save()']")
    WebElement continuar3;

    @CacheLookup
    @FindBy(xpath = "//input[@onclick='PaymentMethod.save()']")
    WebElement continuar4;

    @CacheLookup
    @FindBy(xpath = "//input[@onclick='PaymentInfo.save()']")
    WebElement continuar5;

    @CacheLookup
    @FindBy(xpath = "//input[@onclick='ConfirmOrder.save()']")
    WebElement confirmar;



    public void setCompany(WebElement company) {
        this.company = company;
    }

    public WebElement getContinuar2() {
        return continuar2;
    }

    public void setContinuar2(WebElement continuar2) {
        this.continuar2 = continuar2;
    }

    public WebElement getContinuar3() {
        return continuar3;
    }

    public void setContinuar3(WebElement continuar3) {
        this.continuar3 = continuar3;
    }

    public WebElement getContinuar4() {
        return continuar4;
    }

    public void setContinuar4(WebElement continuar4) {
        this.continuar4 = continuar4;
    }

    public WebElement getContinuar5() {
        return continuar5;
    }

    public void setContinuar5(WebElement continuar5) {
        this.continuar5 = continuar5;
    }

    public WebElement getConfirmar() {
        return confirmar;
    }

    public void setConfirmar(WebElement confirmar) {
        this.confirmar = confirmar;
    }

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
