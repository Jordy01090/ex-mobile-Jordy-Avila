package screenplay.questions;

import net.serenitybdd.screenplay.Question;
import screenplay.ui.SwagLabsLoginPage;

public class TheProductsCount {
    public static Question<Integer> value() {
        return actor -> SwagLabsLoginPage.PRODUCT_ITEM
                .resolveAllFor(actor)
                .size();
    }
}
