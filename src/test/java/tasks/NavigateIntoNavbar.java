package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.HoverOverTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static userInterfaces.HomeUI.NAV_ITEM;
import static userInterfaces.HomeUI.NAV_SECTION;

public class NavigateIntoNavbar implements Task {
    private final String navbarItem;
    private final String navbarSection;

    private static final Logger LOGGER = LoggerFactory.getLogger(NavigateIntoNavbar.class);

    public NavigateIntoNavbar(String navbarItem, String navbarSection) {
        this.navbarItem = navbarItem;
        this.navbarSection = navbarSection;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info(
                "{} is navigating to {} section",
                actor.getName(),
                navbarSection
        );

        actor.attemptsTo(
                HoverOverTarget.over(NAV_ITEM.of(navbarItem)),
                Click.on(NAV_SECTION.of(navbarSection))
        );
    }

    public static NavigateIntoNavbar toSection(String navbarItem, String navbarSection) {
        return Tasks.instrumented(NavigateIntoNavbar.class, navbarItem, navbarSection);
    }
}
