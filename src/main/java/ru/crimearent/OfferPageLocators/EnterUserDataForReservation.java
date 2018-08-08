package ru.crimearent.OfferPageLocators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class EnterUserDataForReservation {

    private SelenideElement fieldSurname;
    private SelenideElement fieldName;
    private SelenideElement fieldMiddleName;
    private SelenideElement fieldPhone;
    private SelenideElement fieldMail;
    private SelenideElement tableTypeOfDocument;
    private SelenideElement tableChoosePassport;
    private SelenideElement tableChooseTravelDocument;
    private SelenideElement fieldSeriesOfDocument;
    private SelenideElement fieldNumberOfDocument;
    private SelenideElement fieldDataOfIssue;
    private SelenideElement fieldValidPeriod;
    private SelenideElement fieldWasGivenBy;
    private SelenideElement fieldDivisionCode;
    private SelenideElement fieldDriverLicenseSeries;
    private SelenideElement fieldDriverLicenseNumber;
    private SelenideElement linkOpenHideFieldsOfAnotherData;
    private SelenideElement fieldComment;
    private SelenideElement checkBoxIagreeWith;
    private SelenideElement buttonReserveAcar;

    private SelenideElement pricePerDayInYourOrderTable;
    private SelenideElement totalPriceInYourOrderTable;




    public EnterUserDataForReservation() {
        this.fieldSurname = $("#u_surname");
        this.fieldName = $("#u_name");
        this.fieldMiddleName = $("#u_name2");
        this.fieldPhone = $("#u_phone");
        this.fieldMail = $("#u_email");
        this.tableTypeOfDocument = $("[class=\"form-col-1-3\"]",3);
        this.tableChoosePassport = $("[rel=\"1\"]");
        this.tableChooseTravelDocument = $("[rel=\"0\"]");
        this.fieldSeriesOfDocument = $("#u_pasp_serie");
        this.fieldNumberOfDocument = $("#u_pasp_number");
        this.fieldDataOfIssue = $("#u_pasp_date_at");
        this.fieldValidPeriod = $("#u_pasp_date_to");
        this.fieldWasGivenBy = $("#u_pasp_granted_by");
        this.fieldDivisionCode = $("#u_pasp_code");
        this.fieldDriverLicenseSeries = $("#u_license_serie");
        this.fieldDriverLicenseNumber = $("#u_license_number");
        this.linkOpenHideFieldsOfAnotherData = $("[class=\"caption\"]",0);
        this.fieldComment = $("#u_comment");
        this.checkBoxIagreeWith = $("[for=\"check-argeement\"]");
        this.buttonReserveAcar = $("#send-order-form");

        this.pricePerDayInYourOrderTable = $("[style=\"font-size: 120%; font-weight: bold;\"]");
        this.totalPriceInYourOrderTable = $("[class=\"tbl-params tbl-params-total\"] [class=\"tbl-cell tbl-cell-value\"]",0);
    }

    public EnterUserDataForReservation enterUserData() {
        fieldSurname.setValue("Егоров");
        fieldName.setValue("Александр");
        fieldMiddleName.setValue("Владимирович");
        fieldPhone.setValue("79999999999");
        fieldMail.setValue("99@ff.ff");
        linkOpenHideFieldsOfAnotherData.scrollTo().click();
        tableTypeOfDocument.click();
        tableChoosePassport.click();
        fieldSeriesOfDocument.setValue("4080");
        fieldNumberOfDocument.setValue("456983");
        fieldDataOfIssue.setValue("22.05.1998");
        fieldValidPeriod.setValue("22.05.2018");
        fieldWasGivenBy.setValue("Увд г.Рязани №2");
        fieldDivisionCode.setValue("569-223");
        fieldDriverLicenseSeries.setValue("5604");
        fieldDriverLicenseNumber.setValue("491144");
        fieldComment.setValue("Прошу прислать фотографии моего арендуемого автомобиля");
        fieldComment.scrollTo();
        checkBoxIagreeWith.click();
        buttonReserveAcar.click();
        return new EnterUserDataForReservation();
    }

    public String getPricePerDayInYourOrderTable() {
        return pricePerDayInYourOrderTable.getText();
    }

    public String getTotalPriceInYourOrderTable() {
        return totalPriceInYourOrderTable.getText().replaceAll(".00 д","");
    }
}
