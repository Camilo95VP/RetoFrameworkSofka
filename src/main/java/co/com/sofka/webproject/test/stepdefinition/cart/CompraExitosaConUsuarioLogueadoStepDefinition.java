package co.com.sofka.webproject.test.stepdefinition.cart;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import co.com.sofka.webproject.test.controllers.LoginPageWebController;
import co.com.sofka.webproject.test.controllers.MyAccountWebController;
import co.com.sofka.webproject.test.controllers.RegisterPageWebController;
import co.com.sofka.webproject.test.controllers.checkoutpage.CheckoutPageWebController;
import co.com.sofka.webproject.test.controllers.checkoutpage.ConfirmationPageWebController;
import co.com.sofka.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.sofka.webproject.test.controllers.productpage.ProductPageWebController;
import co.com.sofka.webproject.test.data.objects.TestInfo;
import co.com.sofka.webproject.test.models.Customer;
import co.com.sofka.webproject.test.page.procesodecompra.CheckoutPage;
import co.com.sofka.webproject.test.page.procesodecompra.ConfirmationPage;
import co.com.sofka.webproject.test.stepdefinition.stup.GeneralSetUp;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import static co.com.sofka.webproject.test.helpers.Dictionary.COUNTRY_CODE;
import static co.com.sofka.webproject.test.helpers.Dictionary.EMAIL_DOMAIN;
import static co.com.sofka.webproject.test.helpers.Dictionary.MESSAGE_CONFIRMATION_SUCCESFUL;
import static co.com.sofka.webproject.test.helpers.Dictionary.SPANISH_CODE_LANGUAGE;
import static co.com.sofka.webproject.test.helpers.Helper.generateCustomer;

public class CompraExitosaConUsuarioLogueadoStepDefinition extends GeneralSetUp {

    private WebAction webAction;
    private Customer customer;
    private CheckoutPage checkoutPage;

    private ConfirmationPage confirmationPage;

    @Before
    public void setUp(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
        customer = generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);
    }

    @Dado("que el cliente naveg?? hasta la p??gina principal")
    public void queElClienteNaveg??HastaLaP??ginaPrincipal() {
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

    @Entonces("el cliente podr?? observar que se realizo correctamente la compra")
    public void elClientePodr??ObservarQueSeRealizoCorrectamenteLaCompra() {
        ConfirmationPageWebController confirmationPageWebController=new ConfirmationPageWebController();
        confirmationPageWebController.setWebAction(webAction);
        Assert.Hard.thatString(confirmationPageWebController.obtenerMensaje()).isEqualTo(MESSAGE_CONFIRMATION_SUCCESFUL);
    }

    @After
    public void cerrarDriver() throws WebActionsException {
        // Cerrar el driver
        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }
}
