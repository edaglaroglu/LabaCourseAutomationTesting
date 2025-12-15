package odevOnAlti.tests;

import odevOnAlti.pages.WebTablesPage;
import org.testng.annotations.Test;

public class WebTablesTest {

    WebTablesPage webTablesPage =  new WebTablesPage();

    @Test
    public void webTablesFlowTest() {

        webTablesPage.openElementsPage();
        webTablesPage.addRecord(
                "Elif", "Dağ", "elif@gmail.com",
                "50", "50000", "HR"
        );
        webTablesPage.editRecord(
                "elif@gmail.com",
                "Duygu", "G", "duygu@c.com",
                "55", "5500", "IT"
        );

    }

}
