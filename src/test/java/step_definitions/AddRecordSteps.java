package step_definitions;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import odevOnAlti.pages.WebTablesPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class AddRecordSteps {

    WebTablesPage webTablesPage = new WebTablesPage();

    @Given("I am on the WebTables page")
    public void i_am_on_the_WebTables_page() {
        webTablesPage.openElementsPage();
    }

    @When("I add a new record")
    public void i_add_a_new_record() {
        webTablesPage.addRecord("Elif", "Dağ", "elif@gmail.com",
                                "50", "50000", "HR");
    }

    @When("I edit the record")
    public void i_edit_the_record() {
        webTablesPage.editRecord("elif@gmail.com",
                "Duygu", "G", "duygu@c.com",
                "55", "5500", "IT"
        );
    }

    @Then("I should see updated email {string}")
    public void i_should_see_updated_email(String email) {
        SelenideElement emailCell =
                $x("//div[@role='row' and .//div[text()='" + email + "']]")
                        .shouldBe(visible);

        // Ek assertion yapmak istersen:
        emailCell.shouldHave(text(email));
    }
}
