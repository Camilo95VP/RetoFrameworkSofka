package co.com.sofka.webproject.test.stepdefinition.stup;

import co.com.sofka.webproject.test.data.objects.TestInfo;
import co.com.sofka.test.automationtools.selenium.Browser;
import org.openqa.selenium.chrome.ChromeOptions;

public class GeneralSetUp {

    protected TestInfo testInfo;

    public Browser browser(){
        Browser browserConfiguration = new Browser();
        browserConfiguration.setBrowser(Browser.Browsers.CHROME);
        browserConfiguration.setIncognito(true);
        browserConfiguration.setMaximized(true);
        browserConfiguration.setAutoDriverDownload(true);
        browserConfiguration.setChromeOptions(chromeOptions());

    return browserConfiguration;
    }

    private ChromeOptions chromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return options;
    }
}
