package ru.crimearent.OfferPageLocators;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class OfferPageBeforePay {

    private SelenideElement totalPricePageBeforePay;
    private SelenideElement priceForIfElsePerDayPageBeforePay;
    private SelenideElement replaceDiscountPriceFromPricePerDay;

    private SelenideElement pricePerDayThatWorkBeforePayPage;


    public OfferPageBeforePay() {
        this.pricePerDayThatWorkBeforePayPage = $(By.xpath("//header[@class=\"header\"]/div"));
        this.totalPricePageBeforePay = $("[class=\"col-left\"] [class=\"form-field\"]",2);
        this.priceForIfElsePerDayPageBeforePay = $("[class=\"price\"]");
        this.replaceDiscountPriceFromPricePerDay = $("[class=\"strike color-grey\"]");
    }

    public String getPricePerDayThatWorkBeforePayPage() {
        return pricePerDayThatWorkBeforePayPage.getText().replace(" д/сутки","");
    }


        public String getTotalPricePageBeforePay() {
        return totalPricePageBeforePay.getAttribute("value").replace(".00","");
    }

    public String getPriceForIfElsePerDayPageBeforePay() {
        return priceForIfElsePerDayPageBeforePay.getText();
    }




    public String pricePerDayOnBeforePayPageAfterIfElse() {
        if ($("[class=\"strike color-grey\"]").exists()) {
            return getPriceForIfElsePerDayPageBeforePay().replace(" д/сутки","")
                    .replace(replaceDiscountPriceFromPricePerDay.getText()+" "
                    ,"");
        }
        if (!$("[class=\"strike color-grey\"]").exists()) {
            return getPriceForIfElsePerDayPageBeforePay().replaceAll(" д/сутки","");
        }
        return null;
    }
}

