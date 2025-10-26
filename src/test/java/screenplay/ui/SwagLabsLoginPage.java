package screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SwagLabsLoginPage {
    public static final Target USERNAME = Target.the("campo usuario")
            .located(By.xpath("//*[@content-desc='test-Username' or @resource-id='test-Username' or @text='Username']"));

    public static final Target PASSWORD = Target.the("campo contraseña")
            .located(By.xpath("//*[@content-desc='test-Password' or @resource-id='test-Password' or @text='Password']"));

    public static final Target LOGIN_BUTTON = Target.the("botón login")
            .located(By.xpath("//*[@content-desc='test-LOGIN' or @resource-id='test-LOGIN' or @text='LOGIN']"));

    public static final Target PRODUCTS_TITLE = Target.the("título PRODUCTS")
            .located(By.xpath("//*[normalize-space(@text)='PRODUCTS']"));

    public static final Target PRODUCT_ITEM = Target.the("item de producto")
            .located(By.xpath("//*[contains(@resource-id,'row') or contains(@content-desc,'test-Item') or contains(@text,'Sauce Labs')]"));
}
