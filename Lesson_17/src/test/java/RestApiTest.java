import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.nullValue;

public class RestApiTest {

    private final static String url = "https://postman-echo.com";

    @Test
    @DisplayName("GET requests")
    public void getTest() {
        given()
                .baseUri(url)
                .param("foo1", "bar1")
                .param("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .assertThat()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto",equalTo("http"))
                .body("headers.x-request-start",notNullValue())
                .body("headers.connection",equalTo("close"))
                .body("headers.x-amzn-trace-id",notNullValue())
                .body("headers.user-agent",equalTo("Apache-HttpClient/4.5.13 (Java/11.0.23)"))
                .body("headers.accept",equalTo("*/*"))
                .body("headers.cache-control",nullValue())
                .body("headers.accept-encoding",equalTo("gzip,deflate"))
                .body("url",equalTo("http://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    @DisplayName("POST Raw Tex")
    public void postRawTextTest() {
        given()
                .baseUri(url)
                .body("{\"foo1\": \"bar1\", \"foo2\": \"bar2\"}")
                .contentType("application/json")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data.foo1", equalTo("bar1"))
                .body("data.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto",equalTo("http"))
                .body("headers.x-request-start",notNullValue())
                .body("headers.connection",equalTo("close"))
                .body("headers.x-amzn-trace-id",notNullValue())
                .body("headers.user-agent",equalTo("Apache-HttpClient/4.5.13 (Java/11.0.23)"))
                .body("headers.accept",equalTo("*/*"))
                .body("headers.cache-control",nullValue())
                .body("headers.accept-encoding",equalTo("gzip,deflate"))
                .body("url",equalTo("http://postman-echo.com/post"));
    }
    @Test
    @DisplayName("POST Form Data")
    public void postFormDataTest() {
        given().baseUri(url)
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto",equalTo("http"))
                .body("headers.x-request-start",notNullValue())
                .body("headers.connection",equalTo("close"))
                .body("headers.content-length",equalTo("19"))
                .body("headers.x-amzn-trace-id",notNullValue())
                .body("headers.user-agent",equalTo("Apache-HttpClient/4.5.13 (Java/11.0.23)"))
                .body("headers.accept",equalTo("*/*"))
                .body("headers.cache-control",nullValue())
                .body("headers.accept-encoding",equalTo("gzip,deflate"))
                .body("headers.content-type",equalTo("application/x-www-form-urlencoded; charset=utf-8"))
                .body("url",equalTo("http://postman-echo.com/post"));
    }

    @Test
    @DisplayName("PUT requests")
    public void putTest(){
        given()
                .baseUri(url)
                .contentType("application/json")
                .body("{\"foo1\": \"bar1\", \"foo2\": \"bar2\"}")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data.foo1", equalTo("bar1"))
                .body("data.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto",equalTo("http"))
                .body("headers.x-request-start",notNullValue())
                .body("headers.connection",equalTo("close"))
                .body("headers.content-length",equalTo("32"))
                .body("headers.x-amzn-trace-id",notNullValue())
                .body("headers.content-type",equalTo("application/json"))
                .body("headers.user-agent",equalTo("Apache-HttpClient/4.5.13 (Java/11.0.23)"))
                .body("headers.accept",equalTo("*/*"))
                .body("headers.cache-control",nullValue())
                .body("headers.accept-encoding",equalTo("gzip,deflate"))
                .body("url",equalTo("http://postman-echo.com/put"));
    }

    @Test
    @DisplayName("PATCH requests")
    public void patchTest() {
        given()
                .baseUri(url)
                .contentType("application/json")
                .body("{\"foo1\": \"bar1\"}")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data.foo1", equalTo("bar1"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto",equalTo("http"))
                .body("headers.x-request-start",notNullValue())
                .body("headers.connection",equalTo("close"))
                .body("headers.content-length",equalTo("16"))
                .body("headers.x-amzn-trace-id",notNullValue())
                .body("headers.content-type",equalTo("application/json"))
                .body("headers.user-agent",equalTo("Apache-HttpClient/4.5.13 (Java/11.0.23)"))
                .body("headers.accept",equalTo("*/*"))
                .body("headers.cache-control",nullValue())
                .body("headers.accept-encoding",equalTo("gzip,deflate"))
                .body("url",equalTo("http://postman-echo.com/patch"));
    }

    @Test
    @DisplayName("DELETE requests")
    public void deleteTest() {
        given()
                .baseUri(url)
                .param("foo","bar")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("args.foo", equalTo("bar"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto",equalTo("http"))
                .body("headers.x-request-start",notNullValue())
                .body("headers.connection",equalTo("close"))
                .body("headers.x-amzn-trace-id",notNullValue())
                .body("headers.content-type",equalTo("application/json"))
                .body("headers.user-agent",equalTo("Apache-HttpClient/4.5.13 (Java/11.0.23)"))
                .body("headers.accept",equalTo("*/*"))
                .body("headers.cache-control",nullValue())
                .body("headers.accept-encoding",equalTo("gzip,deflate"))
                .body("json",nullValue())
                .body("url",equalTo("http://postman-echo.com/delete?foo=bar"));
    }
}
