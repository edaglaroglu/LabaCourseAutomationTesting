package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import odevOnAlti.pages.ButtonElementsPage;

public class ClickButtonSteps {

    ButtonElementsPage buttonElementsPage  = new ButtonElementsPage();

    @Given("I am on the Elements Page")
    public void i_am_on_the_Elements_Page() {
        buttonElementsPage.openElementsPage();
    }

    @When("I go to the Buttons section")
    public void i_go_to_the_Buttons_section() {
        buttonElementsPage.ClickButtonsButton();
    }

    @When("I click the Click Me button")
    public void i_click_the_Click_Me_button() {
        buttonElementsPage.ClickMeButton();
   }

    @Then("I should see click message {string}")
    public void i_should_see_click_message(String expectedMsg){
        buttonElementsPage.dynamicClickMsg(expectedMsg);
    }
}
