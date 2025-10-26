package screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import screenplay.ui.SwagLabsLoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DoLogin implements Task {

    private final String user;
    private final String pass;

    public DoLogin(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public static DoLogin with(String user, String pass){
        return instrumented(DoLogin.class, user, pass);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user).into(SwagLabsLoginPage.USERNAME),
                Enter.theValue(pass).into(SwagLabsLoginPage.PASSWORD),
                Click.on(SwagLabsLoginPage.LOGIN_BUTTON)
        );
    }
}
