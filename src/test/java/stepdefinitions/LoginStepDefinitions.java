package stepdefinitions;

import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import screenplay.questions.DataLoader;
import screenplay.questions.TheProductsCount;
import screenplay.questions.TheProductsTitle;
import screenplay.tasks.DoLogin;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginStepDefinitions {

    @Managed(driver = "appium")
    WebDriver hisMobile;

    Actor jordy = Actor.named("Jordy");

    @Dado("que la app está abierta")
    public void appAbierta() {
        jordy.can(BrowseTheWeb.with(hisMobile));
    }

    @Cuando("ingreso credenciales válidas")
    public void ingresoCredencialesValidas() {
        var creds = DataLoader.loadCredentials();
        jordy.attemptsTo(DoLogin.with(creds.get("user"), creds.get("pass")));
    }

    @Entonces("debería ver el título {string}")
    public void deberiaVerElTitulo(String expected) {
        assertThat(TheProductsTitle.text().answeredBy(jordy)).isEqualTo(expected);
    }

    @Y("debería existir al menos un producto en la lista")
    public void deberiaExistirAlMenosUnProducto() {
        assertThat(TheProductsCount.value().answeredBy(jordy)).isGreaterThan(0);
    }
}
