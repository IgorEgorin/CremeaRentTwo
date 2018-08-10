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



        mainPage.enterTakeAndReturnCityDataTimePromocodeSubmit(varCityOne,varCityTwo,varDataTake,varDataReturn
                ,varTimeOne, varTimeTwo, varPromoCode);

        System.out.println("\nWe have chosen:\n" + "City where we take a car:" + " " + varCityOne +
                "\n\nCity where we return a car:" + " " + varCityTwo +
                "\n\nData when we take a car is:" + " " + varDataTake +
                "\n\nData when return a car is:" + " " + varDataReturn +
                "\n\nTime when take a car is:" + " " + varTimeOne +
                "\n\nTime when return a car is:" + " " + varTimeTwo
        );

        if(varPromoCode.contains("")) {
            System.out.println("\nWe do not use promocode");
        } else {
            System.out.println("\nPromocode number is:" + " " + varPromoCode);
        }




        String varPricePerDayFromSelectPage = selectCarPage
                .takePriceFromSelectPageDoesNotMatterWithDiscountOrNot();


        selectCarPage.getFirstCarCardSelectPageClick();
        System.out.println("\nSelect first car from list");

        offerPage.selectOneNavigatorCameraFridgeAndTwoKidSeats();
        System.out.println("\nSelect One Navigator, One camera, One fridge And Two Kid Seats\n");

        Assert.assertTrue(varPricePerDayFromSelectPage.equals(offerPage.getPriceRentPerDayOfferPage()),
                "\nPrice per day is:\n" + varPricePerDayFromSelectPage +
                        "\nPrice per day from OfferPage is:\n" + offerPage.getPriceRentPerDayOfferPage());

        System.out.println("\nAssertTrueEquals between price per day from SelectPageCar and price per day from OfferPage\n" +
                "\nPrice per day from SelectPage is:\n" + varPricePerDayFromSelectPage +
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
        System.out.println(("\nPush submit button on OfferPage"));




        if ($(byText("Навигатор")).exists()){
            int varQuantityNavigator = Integer.parseInt(
                    $(By.xpath("//div[@class=\"tbl-cell\" and contains (text(), \"Навигатор\")]/span")).getText());
            System.out.println("\nNavigator price per day is:\n"+varPricePerDayNaviOfferPage);
            System.out.println("\nNavigator quantity is:\n"+varQuantityNavigator);
            Assert.assertTrue($(byText(String.valueOf(varQuantityNavigator*varAmmountOfDayRentForCalculateEquipment*varPricePerDayNaviOfferPage)))
                            .exists(),"\nTotal navigator price" +  varQuantityNavigator*varAmmountOfDayRentForCalculateEquipment
                    *varPricePerDayNaviOfferPage + " руб. " + "does not found on page");

            System.out.println("\nSearch total navigator price on BeforeGoToPayPage\n" +
                    "Total navigator price on BeforeGoToPayPage is:" + " " + varQuantityNavigator*varAmmountOfDayRentForCalculateEquipment
                    *varPricePerDayNaviOfferPage);
        }

        if ($(byText("Видеокамера GoPro")).exists()){
            int varQuantityCamera = Integer.parseInt(
                    $(By.xpath("//div[@class=\"tbl-cell\" and contains (text(), \"Видеокамера GoPro\")]/span")).getText());
            System.out.println("\nCamera price per day is:\n"+varPricePerDayCameraOfferPage);
            System.out.println("\nCamera quantity is:\n"+varQuantityCamera);
            Assert.assertTrue($(byText(String.valueOf(varQuantityCamera*varAmmountOfDayRentForCalculateEquipment*varPricePerDayCameraOfferPage)))
                            .exists(),"\nTotal camera price" + varQuantityCamera*varAmmountOfDayRentForCalculateEquipment*varPricePerDayCameraOfferPage+
                    " руб. " + "does not found on page");

            System.out.println("\nSearch total camera price on BeforeGoToPayPage\n" +
                    "Total camera price on BeforeGoToPayPage is:" + " " + varQuantityCamera*varAmmountOfDayRentForCalculateEquipment
                    *varPricePerDayCameraOfferPage);

        }

        if ($(byText("Автохолодильник")).exists()){
            int varQuantityFridge = Integer.parseInt(
                    $(By.xpath("//div[@class=\"tbl-cell\" and contains (text(), \"Автохолодильник\")]/span")).getText());
            System.out.println("\nFridge price per day is:\n"+varPricePerDayFridgeOfferPage);
            System.out.println("\nFridge quantity is:\n"+varQuantityFridge);
            Assert.assertTrue($(byText(String.valueOf(varQuantityFridge*varAmmountOfDayRentForCalculateEquipment*varPricePerDayFridgeOfferPage)))
                            .exists(),"\nTotal fridge price" + varQuantityFridge*varAmmountOfDayRentForCalculateEquipment*varPricePerDayFridgeOfferPage +
                    " руб. " + "does not found on page");

            System.out.println("\nSearch total fridge price on BeforeGoToPayPage\n" +
                    "Total fridge price on BeforeGoToPayPage is:" + " " + varQuantityFridge*varAmmountOfDayRentForCalculateEquipment
                    *varPricePerDayFridgeOfferPage);
        }

        if ($(byText("Детское кресло / Бустер")).exists()){
            int varQuantityKidSeat = Integer.parseInt(
                    $(By.xpath("//div[@class=\"tbl-cell\" and contains (text(), \"Детское кресло / Бустер\")]/span")).getText());
            System.out.println("\nKid seat price per day is:\n"+varPricePerDayKidSeatOfferPage);
            System.out.println("\nKid seat quantity is:\n"+varQuantityKidSeat);
            Assert.assertTrue($(byText(String.valueOf(varQuantityKidSeat*varAmmountOfDayRentForCalculateEquipment*varPricePerDayKidSeatOfferPage)))
                            .exists(),"\nTotal kid seat price" + varQuantityKidSeat*varAmmountOfDayRentForCalculateEquipment*varPricePerDayKidSeatOfferPage +
                    " руб. " + "does not found on page");

            System.out.println("\nSearch total kid seat price on BeforeGoToPayPage\n" +
                    "Total kid seat price on BeforeGoToPayPage is:" + " " + varQuantityKidSeat
                    *varAmmountOfDayRentForCalculateEquipment*varPricePerDayKidSeatOfferPage);
        }



//        Thread.sleep(4000);

        System.out.println("\nAssertTrueEquals between price rent per day from SelectPage and  price per day from InYourOrderTable\n");
        Assert.assertTrue(varPricePerDayFromSelectPage.equals(entUserDataForResev.getPricePerDayInYourOrderTable())
        ,"Price per day from offer page is:\n"+varPricePerDayFromSelectPage+
        "\nPrice inside table YOUR ORDER is:\n"+entUserDataForResev.getPricePerDayInYourOrderTable());




        String varTotalPriceFromEnterDataPage = entUserDataForResev.getTotalPriceInYourOrderTable();

        System.out.println("Enter user data for booking\n");
        entUserDataForResev.enterUserData();


        System.out.println("\nAssertTrueEquals between total price rent from EnterYourDataPage and total price rent from BeforePayPage\n");

        Assert.assertTrue(varTotalPriceFromEnterDataPage.equals(offerPageBeforePay.getTotalPricePageBeforePay()),
                "\nTotal price from order table is:\n"+varTotalPriceFromEnterDataPage+
        "\nTotal price on BeforePayPage is:\n"+offerPageBeforePay.getTotalPricePageBeforePay());

        Assert.assertTrue(varPricePerDayFromSelectPage.equals(offerPageBeforePay.getPricePerDayThatWorkBeforePayPage()),

                "\nPrice per day from SelectPage is:\n"+varPricePerDayFromSelectPage+
        "\nPrice per day on BeforePayPage is:\n"+offerPageBeforePay.getPricePerDayThatWorkBeforePayPage());



        Thread.sleep(54000000);



    }
}
