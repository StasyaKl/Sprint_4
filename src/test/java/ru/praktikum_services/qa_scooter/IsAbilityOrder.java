package ru.praktikum_services.qa_scooter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import ru.praktikum_services.qa_scooter.pageobject.page.CreateOrderDetailsPage;
import ru.praktikum_services.qa_scooter.pageobject.page.FirstMainPage;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IsAbilityOrder extends BaseTest {
    private final String name;
    private final String secondName;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String comment;
    private final By btnOrder;
    private final String data;
    private final By pathToData;
    private final String choosePeriod;

    public IsAbilityOrder(String name, String secondName, String address, String metroStation, String phoneNumber, String comment, By btnOrder, String data, By pathToData, String choosePeriod) {
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
        this.btnOrder = btnOrder;
        this.data = data;
        this.pathToData = pathToData;
        this.choosePeriod = choosePeriod;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][]{
                {"Иван", "Ургант", "г. Москва", "Беляево", "89157777777", "❤️", By.className("Button_Button__ra12g"), "12.12.2012", By.xpath(".//div[@aria-label='Choose среда, 12-е декабря 2012 г.']"), "двое суток"},
                {"Аллочка", "Михеева", "г. Санкт-Петербург", "Трубная", "89168888888", "", By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button"), "14.07.2007", By.xpath(".//div[@aria-label='Choose суббота, 14-е июля 2007 г.']"), "четверо суток"},
        };
    }

    @Test
    public void checkAbilityOrder() {
        new FirstMainPage(driver).
                clickCreateOrder(btnOrder)
                .fillInputName(name)
                .fillInputSecondName(secondName)
                .fillInputAddress(address)
                .chooseSelect(metroStation)
                .fillInputPhone(phoneNumber)
                .nextPageOnButtonContinue()
                .chooseData(data, pathToData)
                .chooseSelectDay(choosePeriod)
                .clickChooseCheckBox()
                .stayComment(comment)
                .btnMakeOrder()
                .setBtnYes();

        boolean isDisplayed = new CreateOrderDetailsPage(driver).isModalWindowDisplayed();
        assertTrue(isDisplayed);
    }
}