package co.com.sofka.webproject.test.page.procesodecompra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
    @CacheLookup
    @FindBy(xpath = "//div[@class='title']")
    WebElement mensajeCompraExitosa;

    public WebElement getMensajeCompraExitosa() {
        return mensajeCompraExitosa;
    }

    public ConfirmationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
