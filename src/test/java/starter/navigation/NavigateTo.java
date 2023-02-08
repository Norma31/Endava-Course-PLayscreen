package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
   public static Performable theWikipediaHomePage() {
       return Task.where("{0} opens the Wikipedia home page",   //el 0 es para indicarle que use el actor con el que se esta trabajando
              Open.browserOn().the(WikipediaHomePage.class));
   }

    public static Performable theSauceHomePage() {
        return Task.where("{0} opens the Sauce home page",   //el 0 es para indicarle que use el actor con el que se esta trabajando
                Open.browserOn().the(SauceHomePage.class));
    }
}
