package co.com.sofka.webproject.test.helpers;

import co.com.sofka.webproject.test.models.Customer;
import co.com.sofka.test.evidence.reports.Report;
import com.github.javafaker.Faker;

import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;

import static co.com.sofka.webproject.test.helpers.Dictionary.*;

public class Helper {

    private Helper() {
    }

    public static String getProperty(String property) {
        Properties properties = new Properties();
        try (FileReader fileReader = new FileReader(CONFIGURATION_PROPERTIES_FILE)) {
            properties.load(fileReader);
        } catch (IOException e) {
            Report.reportFailure("Fallo al consultar una propiedad del archivo "
                    + CONFIGURATION_PROPERTIES_FILE, e);
        }

        return properties.getProperty(property);
    }

    public static Customer generateCustomer(String language, String country, String emailDomain){

        Faker faker =  Faker.instance(
                new Locale(language, country),
                new Random()
        );

        Customer customer = new Customer();

        customer.setEmail(
                faker.name()
                        .username()
                        .concat(emailDomain)
                        .replace(SPACE_STRING, EMPTY_STRING)
        );

        customer.setFirstName(faker.name().firstName());
        customer.setLastName(faker.name().lastName());
        customer.setPassword(faker.number().digits(8));
        customer.setCompany(faker.company().name());
        customer.setEnquiry(faker.lorem().characters());
        customer.setCity(faker.address().cityName());
        customer.setAddress(faker.address().city());
        customer.setPostalCode(faker.address().zipCode());
        customer.setPhoneNUmber(faker.phoneNumber().phoneNumber());

        customer.setCity(faker.address().city());
        customer.setPostalCode(faker.address().zipCode());
        customer.setPhoneNUmber(
                String.valueOf(
                        faker
                                .number()
                                .numberBetween(300000000, 399999999))
                        .concat(
                                String.valueOf(
                                        faker.number()
                                                .numberBetween(1, 9)
                                )
                        )
        );
        customer.setCountry(COUNTRY_BY_DEFAULT_USA);
        customer.setState(STATE_BY_DEFAULT_FLORIDA);

        return customer;
    }
}
