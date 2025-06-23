package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static userInterfaces.RetirementUI.BACK_CARD_RETIREMENT_SERVICES;
import static userInterfaces.RetirementUI.CARD_SECTION_RETIREMENT_SERVICES;
import static userInterfaces.RetirementUI.LBL_SECTION;

public class CopyTextSection implements Task {
    private final String section;

    private static final Logger LOGGER = LoggerFactory.getLogger(CopyTextSection.class);

    public CopyTextSection(String section) {
        this.section = section;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info(
                "{} is trying to copy a text",
                actor.getName()
        );

        actor.attemptsTo(
                Scroll.to(LBL_SECTION.of(section)),
                Check.whether(WebElementQuestion.stateOf(CARD_SECTION_RETIREMENT_SERVICES), WebElementStateMatchers.isNotVisible())
                                .andIfSo(
                                        WaitUntil.the(CARD_SECTION_RETIREMENT_SERVICES, isVisible()).forNoMoreThan(5).seconds()
                                ),
                MoveMouse.to(CARD_SECTION_RETIREMENT_SERVICES),
                Check.whether(WebElementQuestion.stateOf(BACK_CARD_RETIREMENT_SERVICES), WebElementStateMatchers.isNotVisible())
                        .andIfSo(
                                WaitUntil.the(BACK_CARD_RETIREMENT_SERVICES, isVisible()).forNoMoreThan(5).seconds()
                        )
        );

        String backCardText = BACK_CARD_RETIREMENT_SERVICES.resolveFor(actor).getText();

        actor.remember("copied_text", backCardText);
    }

    public static CopyTextSection on(String section) {
        return Tasks.instrumented(CopyTextSection.class, section);
    }
}
