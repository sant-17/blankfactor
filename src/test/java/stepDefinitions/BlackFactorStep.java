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
    public void navigatesToTheSectionAndOpensThePage(String navSection, String navPage) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavigateIntoNavbar.toSection(navSection, navPage)
        );
    }

    @And("copy the text from the third tile in the {string} section")
    public void copyTheTextFromTheThirdTileInTheSection(String pageSection) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CopyTextSection.on(pageSection)
        );
    }

    @And("clicks on the {string} button")
    public void clicksOnTheButton(String redirectButton) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavToContactForm.click(redirectButton)
        );
    }

    @Then("the user should see that the current URL indicate the {string} page")
    public void theUserShouldSeeThatTheCurrentURLIndicateThePage(String currentPage) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(ValidateUrlContent.value(currentPage))
        );
    }

    @And("the page title indicate the {string} page")
    public void thePageTitleIndicateThePage(String currentPage) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(ValidateTitleContent.value(currentPage))
        );
    }
}
