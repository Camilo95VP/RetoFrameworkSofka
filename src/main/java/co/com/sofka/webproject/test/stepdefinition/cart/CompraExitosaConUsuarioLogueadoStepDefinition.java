package co.com.sofka.webproject.test.stepdefinition.cart;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.webproject.test.controllers.LoginPageWebController;
import co.com.sofka.webproject.test.controllers.MyAccountWebController;
import co.com.sofka.webproject.test.controllers.RegisterPageWebController;
import co.com.sofka.webproject.test.controllers.checkoutpage.CheckoutPageWebController;
import co.com.sofka.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.sofka.webproject.test.controllers.productpage.ProductPageWebController;
import co.com.sofka.webproject.test.data.objects.TestInfo;
import co.com.sofka.webproject.test.models.Customer;
import co.com.sofka.webproject.test.stepdefinition.stup.GeneralSetUp;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import static co.com.sofka.webproject.test.helpers.Dictionary.COUNTRY_CODE;
import static co.com.sofka.webproject.test.helpers.Dictionary.EMAIL_DOMAIN;
import static co.com.sofka.webproject.test.helpers.Dictionary.SPANISH_CODE_LANGUAGE;
import static co.com.sofka.webproject.test.helpers.Helper.generateCustomer;

public class CompraExitosaConUsuarioLogueadoStepDefinition extends GeneralSetUp {

    private WebAction webAction;
    private Customer customer;

    @Before
    public void setUp(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
        customer = generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);
    }

    @Dado("que el cliente navegó hasta la página principal")
    public void queElClienteNavegóHastaLaPáginaPrincipal() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();
    }

    @Cuando("el cliente se registre y se loguee")
    public void elClienteSeRegistreYSeLoguee() {
        LoginPageWebController loginPageWebController = new LoginPageWebController();
        loginPageWebController.setWebAction(webAction);
        loginPageWebController.irHaciaRegisterPage();

        RegisterPageWebController registerPageWebController = new RegisterPageWebController();
        registerPageWebController.setCustomer(customer);
        registerPageWebController.setWebAction(webAction);
        registerPageWebController.llenarCamposDeRegistro();
    }

    @Cuando("el cliente agregue los productos al carro y realice el procedimiento de compra")
    public void elClienteAgregueLosProductosAlCarroYRealiceElProcedimientoDeCompra() {
        ProductPageWebController productPageWebController = new ProductPageWebController();
        productPageWebController.setWebAction(webAction);
        productPageWebController.agregarProductosAlCarro();

        CheckoutPageWebController checkoutPageWebController = new CheckoutPageWebController();
        checkoutPageWebController.setCustomer(customer);
        checkoutPageWebController.setWebAction(webAction);
        checkoutPageWebController.llenarFormularioDeCompra();

    }

    @Entonces("el cliente podrá observar que se realizo correctamente la compra")
    public void elClientePodráObservarQueSeRealizoCorrectamenteLaCompra() {

    }
}
