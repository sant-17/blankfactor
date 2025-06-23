package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static userInterfaces.RetirementUI.BTN_GET_STARTED;

public class NavToContactForm implements Task {
    private final String buttonName;

    private static final Logger LOGGER = LoggerFactory.getLogger(NavToContactForm.class);

    public NavToContactForm(String buttonName) {
        this.buttonName = buttonName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info(
                "{} is clicking on the redirect button",
                actor.getName()
        );

        actor.attemptsTo(
                Click.on(BTN_GET_STARTED.of(buttonName))
        );

        LOGGER.info(
                "Text copied -> {}",
                actor.recall("copied_text").toString()
        );
    }

    public static NavToContactForm click(String buttonName) {
        return Tasks.instrumented(NavToContactForm.class, buttonName);
    }
}
