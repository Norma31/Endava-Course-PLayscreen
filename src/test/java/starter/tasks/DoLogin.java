package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.LoginUi;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class DoLogin implements Task {

    private String username;
    private String password;

    public DoLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Performable withCredentials(String username, String password) {   //Es performable porque es el objeto que me permite hacer acciones
        return instrumented(DoLogin.class, username, password);   //Llamamos a este metodo, pero por debajo el sabe que vamos a llamar los steps del metodo performAs
    }

    /*public static Performable withCredentials(String username, String password) {
        return
                Task.where("{0} opens the Wikipedia home page",   //el 0 es para indicarle que use el actor con el que se esta trabajando
                Enter.theValue(username).into(LoginUi.USERNAME_FIELD),
                Enter.theValue(password).into(LoginUi.PASSWORD_FIELD),
                Click.on(LoginUi.LOGIN_BUTTON));
    }  ESTA ES OTRA FORMA DE HACER EL PASO DEL LOGIN EN LA PAGINA - SI SE USA ESTO TOCA QUITARLE EL IMPLEMENTS - SE PUEDEN TENER MUCHOS PERFORMABLES*/

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginUi.USERNAME_FIELD, isVisible()),
                Enter.theValue(username).into(LoginUi.USERNAME_FIELD),
                Enter.theValue(password).into(LoginUi.PASSWORD_FIELD),
                Click.on(LoginUi.LOGIN_BUTTON)
        );

    }

    //Hacer el metodo de Logout

    /* @Override
    public Performable then(Performable nextPerformable) {
        return Task.super.then(nextPerformable);
    }*/
}


