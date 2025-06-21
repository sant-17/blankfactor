package userInterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class HomeUI extends PageObject {

    public static final Target NAV_ITEM = Target
            .the("Navbar item called '{0}' ")
            .locatedBy("//nav//ul/li/a/span[text()='{0}']");

    public static final Target NAV_SECTION = Target
            .the("Navbar section called {0}")
            .locatedBy("//h6[text()='{0}']");
}
