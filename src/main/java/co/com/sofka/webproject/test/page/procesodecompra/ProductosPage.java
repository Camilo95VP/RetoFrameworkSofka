package co.com.sofka.webproject.test.page.procesodecompra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductosPage {

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[2]/ul[1]/li[1]/a")
    WebElement books;
    @CacheLookup
    @FindBy(xpath = "//*[@value=\"Add to cart\"]")
    WebElement add;

    @CacheLookup
    @FindBy(xpath = "//input[@id=\"add-to-cart-button-72\"]")
    WebElement add2;

    @CacheLookup
    @FindBy(xpath= "//img[@alt=\"Tricentis Demo Web Shop\"]")
    WebElement home;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[3]/p/a")
    WebElement car;

    @CacheLookup
    @FindBy(xpath = "//input[@id=\"termsofservice\"]")
    WebElement terms;

    @CacheLookup
    @FindBy(xpath = "//button[@id=\"checkout\"]")
    WebElement checkout;

    public WebElement getCheckout() {
        return checkout;
    }

    public WebElement getTerms() {
        return terms;
    }

    public WebElement getAdd(){
        return add;
    }

    public WebElement getHome(){
        return home;
    }

    public WebElement getBooks(){
        return books;
    }

    public WebElement getCar(){
        return car;
    }

    public ProductosPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }


}
