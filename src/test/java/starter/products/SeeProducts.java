package starter.products;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class SeeProducts {

    public static  Target text = Target
            .the("text")
            .located(By.cssSelector(".header_secondary_container > span"));
}
