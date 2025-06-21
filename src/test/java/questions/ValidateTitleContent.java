package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidateTitleContent implements Question<Boolean> {
    protected String text;

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateTitleContent.class);

    public ValidateTitleContent(String text) {
        this.text = text;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String currentTitle = BrowseTheWeb.as(actor).getDriver().getTitle().toLowerCase();

        Boolean doesTitleContainsText = currentTitle.contains(text.toLowerCase());

        if (doesTitleContainsText) {
            LOGGER.info(
                    "{} verified the current page title ({}) contains {}",
                    actor.getName(),
                    currentTitle,
                    text
            );
        } else {
            LOGGER.warn(
                    "{} find a missmatch between the current page title ({}) and {}",
                    actor.getName(),
                    currentTitle,
                    text
            );
        }

        return doesTitleContainsText;
    }

    public static Question<Boolean> value(String text) {
        return new ValidateTitleContent(text);
    }
}
