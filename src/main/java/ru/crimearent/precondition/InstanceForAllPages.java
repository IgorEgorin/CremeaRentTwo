package ru.crimearent.precondition;

import ru.crimearent.OfferPageLocators.EnterUserDataForReservation;
import ru.crimearent.OfferPageLocators.OfferPage;
import ru.crimearent.OfferPageLocators.OfferPageBeforePay;
import ru.crimearent.mainPageLocators.MainPage;
import ru.crimearent.selectPageLocators.SelectCarPage;

public class InstanceForAllPages {

    protected MainPage mainPage = new MainPage();
    protected SelectCarPage selectCarPage = new SelectCarPage();
    protected OfferPage offerPage = new OfferPage();
    protected EnterUserDataForReservation entUserDataForResev = new EnterUserDataForReservation();
    protected OfferPageBeforePay offerPageBeforePay = new OfferPageBeforePay();

}
