package ru.crimearent.OfferPageLocators;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OfferPage {

    private SelenideElement priceRentPerDayOfferPage;
    private SelenideElement priceTotalRentPeriodOfferPage;

    private SelenideElement priceTotalNavigatorOfferPage;
    private SelenideElement priceTotalCameraOfferPage;
    private SelenideElement priceTotalFridgeOfferPage;
    private SelenideElement priceKidSeatOfferPage;

    private SelenideElement chkBoxNavigatorOfferPage;
    private SelenideElement chkBoxCameraOfferPage;
    private SelenideElement chkBoxFridgeOfferPage;
    private SelenideElement chkBoxKidSeatOfferPage;

    private SelenideElement listOfquantityEquipmntKidSeat;
    private SelenideElement selectTwoKidSeatOfferPage;

    private SelenideElement submitButtonOfferPage;

    public OfferPage() {
        this.priceRentPerDayOfferPage = $(By.xpath("//span[@style=\"font-size: 120%; font-weight: bold;\"]"));
        this.priceTotalRentPeriodOfferPage = $(By.xpath("//span[@class=\"total-cost\"] [@data-base-price]"));

        this.priceTotalNavigatorOfferPage = $("[class=\"tbl-row equipment-price-holder\"] [class=\"tbl-cell tbl-cell-value\"]",0);
        this.priceTotalCameraOfferPage = $("[class=\"tbl-row equipment-price-holder\"] [class=\"tbl-cell tbl-cell-value\"]",1);
        this.priceTotalFridgeOfferPage = $("[class=\"tbl-row equipment-price-holder\"] [class=\"tbl-cell tbl-cell-value\"]",2);
        this.priceKidSeatOfferPage = $("[class=\"tbl-row equipment-price-holder\"] [class=\"tbl-cell tbl-cell-value\"]",3);

        this.chkBoxNavigatorOfferPage = $("[class=\"caption\"]",0);
        this.chkBoxCameraOfferPage = $("[class=\"caption\"]",1);
        this.chkBoxFridgeOfferPage = $("[class=\"caption\"]",2);
        this.chkBoxKidSeatOfferPage = $("[class=\"caption\"]",3);

        this.listOfquantityEquipmntKidSeat = $("[class=\"selectBox select-styled selectBox-dropdown\"] [class=\"selectBox-arrow\"]",3);
        this.selectTwoKidSeatOfferPage = $("[rel=\"2\"]",3);

        this.submitButtonOfferPage = $("[class=\"btn-form btn-order\"]",0);
    }

    public String getPriceRentPerDayOfferPage() {
        return priceRentPerDayOfferPage.getText();
    }

    public String getPriceTotalRentPeriodOfferPage() {
        return priceTotalRentPeriodOfferPage.getText().replace(".00","");
    }

    public String getPriceTotalNavigatorOfferPage() {
        return priceTotalNavigatorOfferPage.getText().replaceAll(" д","");
    }

    public OfferPage getSubmitButtonOfferPageClick() {
        chkBoxNavigatorOfferPage.scrollTo();
        submitButtonOfferPage.click();
        return new OfferPage();
    }

    public OfferPage selectOneNavigatorCameraFridgeAndTwoKidSeats() {
        $("[class=\"font-icon-close close-card\"]").scrollTo();
        chkBoxNavigatorOfferPage.click();
        chkBoxCameraOfferPage.click();
//        chkBoxFridgeOfferPage.click();
        chkBoxKidSeatOfferPage.click();
        listOfquantityEquipmntKidSeat.click();
        selectTwoKidSeatOfferPage.click();
        return new OfferPage();

    }

}
