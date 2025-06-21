package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidateUrlContent implements Question<Boolean> {
    protected String text;

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateUrlContent.class);

    public ValidateUrlContent(String text) {
        this.text = text;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String currentUrl = BrowseTheWeb.as(actor).getDriver().getCurrentUrl().toLowerCase();

        Boolean doesUrlContainsText = currentUrl.contains(text.toLowerCase());

        if (doesUrlContainsText) {
            LOGGER.info(
                    "{} verified the current URL({}) contains {}",
                    actor.getName(),
                    currentUrl,
                    text
            );
        } else {
            LOGGER.warn(
                    "{} find a missmatch between the current URL({}) and {}",
                    actor.getName(),
                    currentUrl,
                    text
            );
        }

        return doesUrlContainsText;
    }

    public  static Question<Boolean> value(String text) {
        return new ValidateUrlContent(text);
    }
}
