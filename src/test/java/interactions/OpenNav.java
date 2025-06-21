package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenNav implements Interaction {

    private final String url;
    private static final Logger LOGGER = LoggerFactory.getLogger(OpenNav.class);

    public OpenNav(String url) {
        this.url = url;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info(
                "{} is navigating to the URL {}",
                actor.getName(),
                url
        );
        actor.attemptsTo(Open.url(url));
    }

    public static OpenNav withUrl(String url) {
        return Tasks.instrumented(OpenNav.class, url);
    }
}
