import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class SecurityTest {
    private static Response response;

    @Test
    public void securityTest(){
        response =given().auth().oauth2(Consts.INCORRECT_API_KEY).contentType("application/json").get(Consts.INCORRECT_URL +Consts.INCORRECT_API_KEY);
        response.then().statusCode(401);
    }

    @Test
    public void securityTestDone() {
        response = given().auth().oauth2(Consts.API_KEY).contentType("application/json").get(Consts.CORRECT_URL_WITHOUT_KEY + Consts.API_KEY);
        response.then().statusCode(200);
    }
}
