package screenplay.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import screenplay.ui.SwagLabsLoginPage;

public class TheProductsTitle {
    public static Question<String> text() {
        return actor -> Text.of(SwagLabsLoginPage.PRODUCTS_TITLE).answeredBy(actor).trim();
    }
}
