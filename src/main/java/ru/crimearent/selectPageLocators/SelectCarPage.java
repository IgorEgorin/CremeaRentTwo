package ru.crimearent.selectPageLocators;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.crimearent.OfferPageLocators.OfferPage;

import static com.codeborne.selenide.Selenide.$;

public class SelectCarPage {

    private SelenideElement fieldPriceWithOutDiscount;
    private SelenideElement fieldPriceWithDiscount;
    private SelenideElement fieldPriceWithDiscountAndMoreBigger;

    private SelenideElement firstCarCardSelectPage;

    public SelectCarPage() {
        this.fieldPriceWithOutDiscount = $(By.xpath("//div[@class=\"price\"]/div"));
        this.fieldPriceWithDiscount = $("[class=\"price\"]");
        this.fieldPriceWithDiscountAndMoreBigger =
                $("[class=\"strike color-grey\"]");
        this.firstCarCardSelectPage = $("[class=\"card-auto-content-intro\"]");
    }

    private String getFieldPriceWithOutDiscount() {
        return fieldPriceWithOutDiscount.getText().replaceAll(" д/сутки","");
    }

    private String getFieldPriceWithDiscount() {
        return fieldPriceWithDiscount.getText().replaceAll(" д/сутки","")
                .replaceAll(fieldPriceWithDiscountAndMoreBigger.getText()+" ","");
    }

    public String takePriceFromSelectPageDoesNotMatterWithDiscountOrNot() {
        if ($("[class=\"strike color-grey\"]").exists()) {
            return getFieldPriceWithDiscount();
        }
        if (!$("[class=\"strike color-grey\"]").exists()) {
            return getFieldPriceWithOutDiscount();
        }
        return null;
    }

    public OfferPage getFirstCarCardSelectPageClick() {
        firstCarCardSelectPage.click();
        return new OfferPage();
    }

}
