package co.com.sofka.webproject.test.controllers.productpage;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import co.com.sofka.webproject.test.page.procesodecompra.ProductosPage;
import org.openqa.selenium.WebElement;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import static co.com.sofka.webproject.test.helpers.Seconds.TWENTY_SECONDS;
import static org.openqa.selenium.By.xpath;

public class ProductPageWebController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void agregarProductosAlCarro(){
        try {
            ProductosPage productsPage = new ProductosPage(webAction.getDriver());
            webAction.click(productsPage.getHome(), TWENTY_SECONDS.getValue(), true);
            webAction.click(productsPage.getBooks(), TWENTY_SECONDS.getValue(), true);

            Random r = new SecureRandom();

            List<WebElement> listings = webAction.getDriver().findElements(xpath("//*[@class='item-box']"));
            webAction.waitFor(listings.get(0), TWENTY_SECONDS.getValue(), true);

            webAction.click(listings.get(r.nextInt(listings.size()/2)), TWENTY_SECONDS.getValue(), true);
            webAction.click(productsPage.getAdd(), TWENTY_SECONDS.getValue(), true);
            webAction.click(productsPage.getCar(),TWENTY_SECONDS.getValue(),true);
            webAction.click(productsPage.getTerms(),TWENTY_SECONDS.getValue(),true);
            webAction.click(productsPage.getCheckout(),TWENTY_SECONDS.getValue(),true);

        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al agregar los productos al carrito",e);
        }
    }

}
