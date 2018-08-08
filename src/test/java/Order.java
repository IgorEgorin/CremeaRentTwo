import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.crimearent.precondition.CsvDataProvider;
import ru.crimearent.precondition.Precondition;

import java.util.Map;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class Order extends Precondition {
    



    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
    public void crimeaRentPositiveOrder(Map<String, String> testData) throws Exception {

        String varCityOne = testData.get("CityTakeAcar");
        String varCityTwo = testData.get("CityReturnAcar");

        String varDataTake = testData.get("DataOne");
        String varDataReturn = testData.get("DataTwo");

        String varTimeOne = testData.get("TimeOne");
        String varTimeTwo= testData.get("TimeTwo");

        String varPromoCode= testData.get("PromoCodeNumber");


//        String varCityOne = "Симферополь";
//        String varCityTwo = "Симферополь";
//
//        String varDataTake = "10.08.2018";
//        String varDataReturn = "18.08.2018";
//
//        String varTimeOne = "03:00";
//        String varTimeTwo = "12:00";
//
//        String varPromoCode= "0";


        System.out.println("TimeOne before enter a data"+varTimeOne);
        mainPage.enterTakeAndReturnCityDataTimePromocodeSubmit(varCityOne,varCityTwo,varDataTake,varDataReturn
                ,varTimeOne, varTimeTwo, varPromoCode);


        String varPricePerDayFromSelectPage = selectCarPage
                .takePriceFromSelectPageDoesNotMatterWithDiscountOrNot();

        selectCarPage.getFirstCarCardSelectPageClick();


        offerPage.selectOneNavigatorCameraFridgeAndTwoKidSeats();

        Assert.assertTrue(varPricePerDayFromSelectPage.equals(offerPage.getPriceRentPerDayOfferPage()),
                "\nPrice per day is:\n" + varPricePerDayFromSelectPage +
                        "\nPrice per day from OfferPage is:\n" + offerPage.getPriceRentPerDayOfferPage());

        int varAmmountOfDayRentForCalculateEquipment = Integer.parseInt($(By.xpath("//div[@class=\"tbl-cell tbl-cell-value\"and contains (text(), \"сут\")]"))
                .getText().replace(" суток",""));



        int varPricePerDayNaviOfferPage =
                Integer.parseInt($("[class=\"tbl-row equipment-price-holder\"] [class=\"tbl-cell tbl-cell-value\"]",0)
                        .getText().replace(" д",""));

        int varPricePerDayCameraOfferPage =
                Integer.parseInt($("[class=\"tbl-row equipment-price-holder\"] [class=\"tbl-cell tbl-cell-value\"]",1)
                        .getText().replace(" д",""));

        int varPricePerDayFridgeOfferPage =
                Integer.parseInt($("[class=\"tbl-row equipment-price-holder\"] [class=\"tbl-cell tbl-cell-value\"]",2)
                        .getText().replace(" д",""));

        int varPricePerDayKidSeatOfferPage =
                Integer.parseInt($("[class=\"tbl-row equipment-price-holder\"] [class=\"tbl-cell tbl-cell-value\"]",3)
                        .getText().replace(" д",""));



        offerPage.getSubmitButtonOfferPageClick();




















        if ($(byText("Навигатор")).exists()){
            int varQuantityNavigator = Integer.parseInt(
                    $(By.xpath("//div[@class=\"tbl-cell\" and contains (text(), \"Навигатор\")]/span")).getText());
            System.out.println("\nNavigator price per day is:\n"+varPricePerDayNaviOfferPage);
            System.out.println("\nNavigator quantity is:\n"+varQuantityNavigator);
            System.out.println("\nNavigator total price is:\n"+varQuantityNavigator*varAmmountOfDayRentForCalculateEquipment*varPricePerDayNaviOfferPage);
            Assert.assertTrue($(byText(String.valueOf(varQuantityNavigator*varAmmountOfDayRentForCalculateEquipment*varPricePerDayNaviOfferPage)))
                            .exists(),"\nTotal navigator price doesnot found");
        }

        if ($(byText("Видеокамера GoPro")).exists()){
            int varQuantityCamera = Integer.parseInt(
                    $(By.xpath("//div[@class=\"tbl-cell\" and contains (text(), \"Видеокамера GoPro\")]/span")).getText());
            System.out.println("\nCamera price per day is:\n"+varPricePerDayCameraOfferPage);
            System.out.println("\nCamera quantity is:\n"+varQuantityCamera);
            System.out.println("\nCamera total price is:\n"+varQuantityCamera*varAmmountOfDayRentForCalculateEquipment*varPricePerDayCameraOfferPage);
            Assert.assertTrue($(byText(String.valueOf(varQuantityCamera*varAmmountOfDayRentForCalculateEquipment*varPricePerDayCameraOfferPage)))
                            .exists(),"\nTotal camera price doesnot found");
        }

        if ($(byText("Автохолодильник")).exists()){
            int varQuantityFridge = Integer.parseInt(
                    $(By.xpath("//div[@class=\"tbl-cell\" and contains (text(), \"Автохолодильник\")]/span")).getText());
            System.out.println("\nFridge price per day is:\n"+varPricePerDayFridgeOfferPage);
            System.out.println("\nFridge quantity is:\n"+varQuantityFridge);
            System.out.println("\nFridge total price is:\n"+varQuantityFridge*varAmmountOfDayRentForCalculateEquipment*varPricePerDayFridgeOfferPage);
            Assert.assertTrue($(byText(String.valueOf(varQuantityFridge*varAmmountOfDayRentForCalculateEquipment*varPricePerDayFridgeOfferPage)))
                            .exists(),"\nTotal fridge price doesnot found");
        }

        if ($(byText("Детское кресло / Бустер")).exists()){
            int varQuantityKidSeat = Integer.parseInt(
                    $(By.xpath("//div[@class=\"tbl-cell\" and contains (text(), \"Детское кресло / Бустер\")]/span")).getText());
            System.out.println("\nKid seat price per day is:\n"+varPricePerDayKidSeatOfferPage);
            System.out.println("\nKid seat quantity is:\n"+varQuantityKidSeat);
            System.out.println("\nKid seat total price is:\n"+varQuantityKidSeat*varAmmountOfDayRentForCalculateEquipment*varPricePerDayKidSeatOfferPage);
            Assert.assertTrue($(byText(String.valueOf(varQuantityKidSeat*varAmmountOfDayRentForCalculateEquipment*varPricePerDayKidSeatOfferPage)))
                            .exists(),"\nTotal kid seat price doesnot found");
        }



        Thread.sleep(4000);
//
//        Assert.assertTrue(varPricePerDayFromSelectPage.equals(entUserDataForResev.getPricePerDayInYourOrderTable())
//        ,"Price per day from offer page is:\n"+varPricePerDayFromSelectPage+
//        "\nPrice inside table YOUR ORDER is:\n"+entUserDataForResev.getPricePerDayInYourOrderTable());
//
//
//        String varTotalPriceFromEnterDataPage = entUserDataForResev.getTotalPriceInYourOrderTable();
//
//        entUserDataForResev.enterUserData();
//
//        Thread.sleep(4000);
//
////        System.out.println("varTotal price EnterDataPage"+varTotalPriceFromEnterDataPage);
////        System.out.println("price per day BeforePayPage"+offerPageBeforePay.pricePerDayOnBeforePayPageAfterIfElse());
////        System.out.println("total price BeforePage"+offerPageBeforePay.getTotalPricePageBeforePay());
//
//
//        Assert.assertTrue(varTotalPriceFromEnterDataPage.equals(offerPageBeforePay.getTotalPricePageBeforePay()),
//                "\nTotal price from order table is:\n"+varTotalPriceFromEnterDataPage+
//        "\nTotal price on BeforePayPage is:\n"+offerPageBeforePay.getTotalPricePageBeforePay());
//
//        Assert.assertTrue(varPricePerDayFromSelectPage.equals(offerPageBeforePay.getPricePerDayThatWorkBeforePayPage()),
//
//                "\nPrice per day from SelectPage is:\n"+varPricePerDayFromSelectPage+
//        "\nPrice per day on BeforePayPage is:\n"+offerPageBeforePay.getPricePerDayThatWorkBeforePayPage());
//
//
//
        Thread.sleep(54000000);



    }
}
