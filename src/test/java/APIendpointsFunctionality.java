import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.notNullValue;

public class APIendpointsFunctionality {
    private static Response response;

    @Test
    public void GetCurrentCurrencyConversionRatesFirst() {
        response = given().contentType("application/json").get(Consts.CORRECT_URL);
        //System.out.println(response.asString());
        response.then().body("source",containsString("USD"));
        response.then().body("success",notNullValue());


    }
    @Test
    public void GetCurrentCurrencyConversionRatesSecond() {
        response = given().contentType("application/json").get(Consts.CURRENCIES);
        System.out.println(response.asString());
    }
}
