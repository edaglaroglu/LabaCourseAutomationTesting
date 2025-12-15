package odevOnAlti.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class WebTablesPage {

    private SelenideElement addButton = $("#app").$$("button[type='button']")
            .filterBy(text("Add"))
            .first();

    // Form Fields
    private SelenideElement firstName = $("#firstName");
    private SelenideElement lastName = $("#lastName");
    private SelenideElement userEmail = $("#userEmail");
    private SelenideElement age = $("#age");
    private SelenideElement salary = $("#salary");
    private SelenideElement department = $("#department");
    private SelenideElement submitButton = $("#submit");


    public void openElementsPage() {
        open("https://demoqa.com/webtables");
    }

    public void addButtonClick () {

        addButton.shouldBe(visible, enabled)
                .scrollIntoView(true)
                .click();
    }

    public void fillForm(String fn, String ln, String email, String ageVal, String salaryVal, String dept) {
        firstName.shouldBe(visible).setValue(fn);
        lastName.setValue(ln);
        userEmail.setValue(email);
        age.setValue(ageVal);
        salary.setValue(salaryVal);
        department.setValue(dept);
    }

    public void submit() {
        submitButton.shouldBe(visible).click();
    }

    public void addRecord(String fn, String ln, String email, String ageVal, String salaryVal, String dept) {
        addButtonClick();
        fillForm(fn, ln, email, ageVal, salaryVal, dept);
        submit();
    }

    private SelenideElement rowByEmail(String email) {
        return $x("//div[@role='row' and .//div[text()='" + email + "']]");
    }

    public void editRecord(String existingEmail,
                                  String newFn, String newLn, String newEmail,
                                  String newAge, String newSalary, String newDept) {

        SelenideElement row = rowByEmail(existingEmail).shouldBe(visible);
        SelenideElement editBtn = row.$("span[id^='edit-record']");
        editBtn.scrollIntoView(true).shouldBe(visible, enabled).click();

        fillForm(newFn, newLn, newEmail, newAge, newSalary, newDept);
        submit();
    }

}
