package guests.api;

import guests.AbstractTest;
import io.restassured.http.ContentType;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

class SCIMControllerTest extends AbstractTest {

    @Test
    void createUser() {
        given()
                .when()
                .auth().basic("inviter", "secret")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(this.body())
                .post("/scim/v1/users")
                .then()
                .body("id", is(notNullValue()));
    }

    @Test
    void updateUser() {
        Map<String, Object> body = this.body();
        given()
                .when()
                .auth().basic("inviter", "secret")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(body)
                .pathParam("id", body.get("id"))
                .patch("/scim/v1/users/{id}")
                .then()
                .body("id", IsEqual.equalTo(body.get("id")));
    }

    @Test
    void deleteUser() {
        Map<String, Object> body = this.body();
        given()
                .when()
                .auth().basic("inviter", "secret")
                .accept(ContentType.JSON)
                .pathParam("id", body.get("id"))
                .delete("/scim/v1/users/{id}")
                .then()
                .statusCode(201);
    }

    @Test
    void createGroup() {
        given()
                .when()
                .auth().basic("inviter", "secret")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(this.body())
                .post("/scim/v1/groups")
                .then()
                .body("id", is(notNullValue()));

    }

    @Test
    void patchGroup() {
        Map<String, Object> body = this.body();
        given()
                .when()
                .auth().basic("inviter", "secret")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(body)
                .pathParam("id", body.get("id"))
                .patch("/scim/v1/groups/{id}")
                .then()
                .body("id", IsEqual.equalTo(body.get("id")));
    }

    @Test
    void updateGroup() {
        Map<String, Object> body = this.body();
        given()
                .when()
                .auth().basic("inviter", "secret")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(body)
                .pathParam("id", body.get("id"))
                .put("/scim/v1/groups/{id}")
                .then()
                .body("id", IsEqual.equalTo(body.get("id")));
    }

    @Test
    void deleteGroup() {
        Map<String, Object> body = this.body();
        given()
                .when()
                .auth().basic("inviter", "secret")
                .accept(ContentType.JSON)
                .pathParam("id", body.get("id"))
                .delete("/scim/v1/groups/{id}")
                .then()
                .statusCode(201);
    }

    @Test
    void deleteGroupUnauthorized() {
        Map<String, Object> body = this.body();
        given()
                .when()
                .accept(ContentType.JSON)
                .pathParam("id", body.get("id"))
                .delete("/scim/v1/groups/{id}")
                .then()
                .statusCode(401);
    }

    @Test
    void deleteGroupWrongAuthorization() {
        Map<String, Object> body = this.body();
        given()
                .when()
                .auth().basic("inviter", "nope")
                .accept(ContentType.JSON)
                .pathParam("id", body.get("id"))
                .delete("/scim/v1/groups/{id}")
                .then()
                .statusCode(401);
    }

    private Map<String, Object> body() {
        return Collections.singletonMap("id", UUID.randomUUID().toString());
    }
}