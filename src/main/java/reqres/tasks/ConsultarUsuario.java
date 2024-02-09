package reqres.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static reqres.utils.constants.paths.USERS;

public class ConsultarUsuario implements Task {

    public static Performable paraDatosBasicos() {
        return instrumented(ConsultarUsuario.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(USERS.getPath()));
    }
}