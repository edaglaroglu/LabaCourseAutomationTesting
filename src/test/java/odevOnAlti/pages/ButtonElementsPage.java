package odevOnAlti.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ButtonElementsPage {

    private SelenideElement buttonsButton = $$("span.text").findBy(text("Buttons"));
    private SelenideElement clickMeButton = $$("button.btn.btn-primary")
            .filterBy(not(attribute("id", "doubleClickBtn")))
            .filterBy(not(attribute("id", "rightClickBtn")))
            .findBy(text("Click Me"));
    private SelenideElement dynamicClickMsg = $("#dynamicClickMessage");

    public void openElementsPage() {
        open("https://demoqa.com/elements");
    }

    public void ClickButtonsButton(){
        buttonsButton.shouldBe(visible).click();
    }

    public void ClickMeButton(){
        clickMeButton.shouldBe(visible).click();
    }

    public void dynamicClickMsg(String msg){
        dynamicClickMsg.shouldBe(visible).shouldHave(text(msg));
    }
}
