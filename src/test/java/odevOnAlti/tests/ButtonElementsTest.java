package odevOnAlti.tests;

import odevOnAlti.pages.ButtonElementsPage;
import org.testng.annotations.Test;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.Assertions.assertThat;

public class ButtonElementsTest {

    ButtonElementsPage buttonPage = new ButtonElementsPage();

    @Test
    public void ButtonsFlowTest(){
        buttonPage.openElementsPage();
        buttonPage.ClickButtonsButton();
        assertThat(url()).contains("/buttons");
        buttonPage.ClickMeButton();
        buttonPage.dynamicClickMsg("You have done a dynamic click");
    }
}
