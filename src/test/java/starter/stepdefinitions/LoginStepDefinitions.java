package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import starter.questions.OnThePrincipalPage;
import starter.questions.SwagLabsStoreQuestions;
import starter.tasks.DoLogin;
import starter.navigation.NavigateTo;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginStepDefinitions {

    @Given("{actor} is a {}")
    public void userNavigatesToHomePage(Actor actor, String customerType){
        actor.wasAbleTo(NavigateTo.theSauceHomePage());
    }

    @When("{actor} tries to login")    //actor es un parametro, por lo tanto toca pasarselo al metodo
    public void userTriesToLogin (Actor actor){
       // actor.wasAbleTo(DoLogin.withCredentials("standard_user", "secret_sauce"));   ASI ES OTRA FORMA DE HACERLO, JUNTO CON LO QUE TENGO COMENTARIADO EN DOLOGIN
        actor.attemptsTo(DoLogin.withCredentials("standard_user" ,"secret_sauce"));
    }


    @When("{actor} tries to login with user name {} and password {}")    //actor es un parametro, por lo tanto toca pasarselo al metodo
    public void userTriesToLoginWithCredentials (Actor actor, String userName, String password){
        actor.attemptsTo(DoLogin.withCredentials(userName ,password));
    }

    @Then("{actor} should see products list")
    public void userShouldSeeProductsList(Actor actor){
        actor.should(
                seeThat("The display title",
                        OnThePrincipalPage.theTitleIs(), equalTo("PRODUCTS")
                )
        );

        theActorInTheSpotlight() .should(
                seeThat("The title is present",
                        SwagLabsStoreQuestions.ProductsAvailables(), equalTo("PRODUCTS"))
        ); //Me va a recuperar el ultimo actor que ha usado en el ultimo paso
    }
}
