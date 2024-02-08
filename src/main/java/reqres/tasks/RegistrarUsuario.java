package reqres.tasks;

import reqres.interactions.Post;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegistrarUsuario implements Task {

    private final Object datosUsuario;

    public RegistrarUsuario(Object userInfo) {
        this.datosUsuario = userInfo;
    }

    public static Performable ConLosDatos(Object userInfo) {
        return instrumented(RegistrarUsuario.class, userInfo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("register").with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(datosUsuario)
                )
        );
    }
}