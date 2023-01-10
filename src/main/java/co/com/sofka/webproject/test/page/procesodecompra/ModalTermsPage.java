package co.com.sofka.webproject.test.page.procesodecompra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModalTermsPage {

    @CacheLookup
    @FindBy(xpath = "//div[@class='ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix']")
    WebElement modalErrorTerms;

    public WebElement getModalErrorTerms() {
        return modalErrorTerms;
    }

    public ModalTermsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
