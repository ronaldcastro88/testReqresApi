package reqres.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import reqres.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static reqres.utils.constants.paths.USERS;

public class ActualizarUsuario implements Task {

    private final Object datosUsuario;

    public ActualizarUsuario(Object datosNuevos) {
        this.datosUsuario = datosNuevos;
    }

    public static Performable conInfoNueva(Object datosNuevos) {
        return instrumented(ActualizarUsuario.class, datosNuevos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(USERS.getPath()).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(datosUsuario)
                )
        );
    }
}