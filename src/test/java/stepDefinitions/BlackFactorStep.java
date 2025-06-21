package stepDefinitions;

import interactions.OpenNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.ValidateTitleContent;
import questions.ValidateUrlContent;
import tasks.CopyTextSection;
import tasks.NavToContactForm;
import tasks.NavigateIntoNavbar;

import static constants.Constants.ACTOR;
import static constants.Constants.WEB_URL;

public class BlackFactorStep {

    @Given("the user is on the homepage")
    public void theUserIsOnTheHomepage() {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                OpenNav.withUrl(WEB_URL)
        );
    }

    @When("navigates to the {string} section and opens the {string} page")
    public void navigatesToTheSectionAndOpensThePage(String navItem, String navSection) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavigateIntoNavbar.toSection(navItem, navSection)
        );
    }

    @And("copy the text from the third tile in the {string} section")
    public void copyTheTextFromTheThirdTileInTheSection(String section) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CopyTextSection.on(section)
        );
    }

    @And("clicks on the {string} button")
    public void clicksOnTheButton(String buttonText) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavToContactForm.click(buttonText)
        );
    }

    @Then("the user should see that the current URL and page title indicate the {string} page")
    public void theUserShouldSeeThatTheCurrentURLAndPageTitleIndicateThePage(String contact) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(ValidateUrlContent.value(contact)),
                GivenWhenThen.seeThat(ValidateTitleContent.value(contact))
        );
    }
}
