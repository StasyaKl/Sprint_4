package ru.praktikum_services.qa_scooter;

import org.junit.After;
import org.junit.Test;
import ru.praktikum_services.qa_scooter.pageobject.page.CreateOrderDetailsPage;
import ru.praktikum_services.qa_scooter.pageobject.page.FirstMainPage;

import static org.junit.Assert.*;

public class IsAbilityOrder extends BaseTest {

    @Test
    public void checkAbilityOrder() {
        final String name = "Иван";
        final String secondName = "Иванов";
        final String address = "г. Москва";
        final String metroStation = "Беляево";
        final String phoneNumber = "89157777777";
        final String comment = "❤️";

        new FirstMainPage(driver).
                clickCreateOrderUp()
                .logoSamokatClick()
                .clickCreateOrderDown()
                .fillInputName(name)
                .fillInputSecondName(secondName)
                .fillInputAddress(address)
                .chooseSelect(metroStation)
                .fillInputPhone(phoneNumber)
                .nextPageOnButtonContinue()
                .chooseData()
                .chooseSelectDay()
                .clickChooseCheckBox()
                .stayComment(comment)
                .btnMakeOrder()
                .setBtnYes();

        boolean isDisplayed = new CreateOrderDetailsPage(driver).isModalWindowDisplayed();
        assertTrue(isDisplayed);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}