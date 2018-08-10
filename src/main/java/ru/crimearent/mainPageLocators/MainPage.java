package ru.crimearent.mainPageLocators;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public SelenideElement tableTakeCityMainPage;
    public SelenideElement tableReturnCityMainPage;

    public SelenideElement fieldCalendarTakeCityMainPage;
    public SelenideElement fieldCalendarReturnCityMainPage;
    public SelenideElement timeTakeCityMainPage;
    public SelenideElement timeReturnCityMainPage;

    public SelenideElement promoCodeFieldMainPage;
    public SelenideElement findCarButtonMainPage;


    public MainPage() {
        this.tableTakeCityMainPage = $("[class=\"selectBox-label\"]",0);
        this.tableReturnCityMainPage = $("[style=\"width: 148px;\"]",1);
        this.fieldCalendarTakeCityMainPage = $("#date-start");
        this.fieldCalendarReturnCityMainPage = $("#date-finish");
        this.timeTakeCityMainPage = $("[class=\"field-time\"]",0);
        this.timeReturnCityMainPage = $("[class=\"field-time\"]",1);
        this.promoCodeFieldMainPage = $(By.name("promocode"));
        this.findCarButtonMainPage = $("[class=\"btn-form btn-form-block\"]");
    }


    public MainPage enterTakeAndReturnCityDataTimePromocodeSubmit (String cityOne, String cityTwo, String dataTake, String dataReturn,
                                                                   String timeOne, String timeTwo, String promoCode) {
//        System.out.println("TimeOne inside long method is\n"+timeOne);

        tableTakeCityMainPage.click();
        selectCityTake(cityOne);
        tableReturnCityMainPage.click();
        selectCityReturn(cityTwo);
        fieldCalendarTakeCityMainPage.setValue(dataTake).pressEnter();
        fieldCalendarReturnCityMainPage.setValue(dataReturn).pressEnter();
        timeTakeCityMainPage.click();
        selectTimeTake(timeOne);
        timeReturnCityMainPage.click();
        selectTimeReturn(timeTwo);
        promoCodeFieldMainPage.setValue(promoCode);
        findCarButtonMainPage.click();
        return new MainPage();
    }






    private MainPage selectCityTake (String cityTake) {
        switch (cityTake) {
            case "Алушта":
                $("[rel=\"76149c63-44f4-11e5-aa23-bcee7b591456\"]",0).click();
                break;
            case "Бахчисарай":
                $("[rel=\"2ae17171-e43f-11e5-81f6-ac9e17b8d7a7\"]",0).click();
                break;
            case "Евпатория":
                $("[rel=\"76149c65-44f4-11e5-aa23-bcee7b591456\"]",0).click();
                break;
            case "Николаевка":
                $("[rel=\"3e1af33b-4c7a-11e5-aa23-bcee7b591456\"]",0).click();
                break;
            case "Новый свет":
                $("[rel=\"643c892c-6354-11e5-aa23-bcee7b591456\"]",0).click();
                break;
            case "Саки":
                $("[rel=\"76149c67-44f4-11e5-aa23-bcee7b591456\"]",0).click();
                break;
            case "Севастополь":
                $("[rel=\"76149c68-44f4-11e5-aa23-bcee7b591456\"]",0).click();
                break;
            case "Судак":
                $("[rel=\"76149c6c-44f4-11e5-aa23-bcee7b591456\"]",0).click();
                break;
            case "Феодосия":
                $("[rel=\"76149c6d-44f4-11e5-aa23-bcee7b591456\"]",0).click();
                break;
             case "Черноморское":
                $("[rel=\"25999e6c-644b-11e6-81c0-ac9e17b8d7a7\"]",0).click();
                break;
             case "Ялта":
                $("[rel=\"76149c6f-44f4-11e5-aa23-bcee7b591456\"]",0).click();
                break;
        }
        return new MainPage();
    }






    private MainPage selectCityReturn (String cityReturn) {
        switch (cityReturn) {
            case "Алушта":
                $("[rel=\"76149c63-44f4-11e5-aa23-bcee7b591456\"]",1).click();
                break;
            case "Бахчисарай":
                $("[rel=\"2ae17171-e43f-11e5-81f6-ac9e17b8d7a7\"]",1).click();
                break;
            case "Евпатория":
                $("[rel=\"76149c65-44f4-11e5-aa23-bcee7b591456\"]",1).click();
                break;
            case "Николаевка":
                $("[rel=\"3e1af33b-4c7a-11e5-aa23-bcee7b591456\"]",1).click();
                break;
            case "Новый свет":
                $("[rel=\"643c892c-6354-11e5-aa23-bcee7b591456\"]",1).click();
                break;
            case "Саки":
                $("[rel=\"76149c67-44f4-11e5-aa23-bcee7b591456\"]",1).click();
                break;
            case "Севастополь":
                $("[rel=\"76149c68-44f4-11e5-aa23-bcee7b591456\"]",1).click();
                break;
            case "Судак":
                $("[rel=\"76149c6c-44f4-11e5-aa23-bcee7b591456\"]",1).click();
                break;
            case "Феодосия":
                $("[rel=\"76149c6d-44f4-11e5-aa23-bcee7b591456\"]",1).click();
                break;
            case "Черноморское":
                $("[rel=\"25999e6c-644b-11e6-81c0-ac9e17b8d7a7\"]",1).click();
                break;
            case "Ялта":
                $("[rel=\"76149c6f-44f4-11e5-aa23-bcee7b591456\"]",1).click();
                break;
        }
        return new MainPage();
    }






    private MainPage selectTimeTake (String timeTake) {
        switch (timeTake) {
            case "00:00":
                $("[rel=\"0\"]",0).click();
                break;
            case "01:00":
                $("[rel=\"1\"]",0).click();
                break;
            case "02:00":
                $("[rel=\"2\"]",0).click();
                break;
            case "03:00":
                $("[rel=\"3\"]",0).click();
                break;
            case "04:00":
                $("[rel=\"4\"]",0).click();
                break;
            case "05:00":
                $("[rel=\"5\"]",0).click();
                break;
            case "06:00":
                $("[rel=\"6\"]",0).click();
                break;
            case "07:00":
                $("[rel=\"7\"]",0).click();
                break;
            case "08:00":
                $("[rel=\"8\"]",0).click();
                break;
            case "09:00":
                $("[rel=\"9\"]",0).click();
                break;
            case "10:00":
                $("[rel=\"10\"]",0).click();
                break;
            case "11:00":
                $("[rel=\"11\"]",0).click();
                break;
            case "12:00":
                $("[rel=\"12\"]",0).click();
                break;
            case "13:00":
                $("[rel=\"13\"]",0).click();
                break;
            case "14:00":
                $("[rel=\"14\"]",0).click();
                break;
            case "15:00":
                $("[rel=\"15\"]",0).click();
                break;
            case "16:00":
                $("[rel=\"16\"]",0).click();
                break;
            case "17:00":
                $("[rel=\"17\"]",0).click();
                break;
            case "18:00":
                $("[rel=\"18\"]",0).click();
                break;
            case "19:00":
                $("[rel=\"19\"]",0).click();
                break;
            case "20:00":
                $("[rel=\"20\"]",0).click();
                break;
            case "21:00":
                $("[rel=\"21\"]",0).click();
                break;
            case "22:00":
                $("[rel=\"22\"]",0).click();
                break;
            case "23:00":
                $("[rel=\"23\"]",0).click();
                break;
            case "24:00":
                $("[rel=\"24\"]",0).click();
                break;

        }
        return new MainPage();

    }



    private MainPage selectTimeReturn (String timeReturn) {
        switch (timeReturn) {
            case "00:00":
                $("[rel=\"0\"]",1).click();
                break;
            case "01:00":
                $("[rel=\"1\"]",1).click();
                break;
            case "02:00":
                $("[rel=\"2\"]",1).click();
                break;
            case "03:00":
                $("[rel=\"3\"]",1).click();
                break;
            case "04:00":
                $("[rel=\"4\"]",1).click();
                break;
            case "05:00":
                $("[rel=\"5\"]",1).click();
                break;
            case "06:00":
                $("[rel=\"6\"]",1).click();
                break;
            case "07:00":
                $("[rel=\"7\"]",1).click();
                break;
            case "08:00":
                $("[rel=\"8\"]",1).click();
                break;
            case "09:00":
                $("[rel=\"9\"]",1).click();
                break;
            case "10:00":
                $("[rel=\"10\"]",1).click();
                break;
            case "11:00":
                $("[rel=\"11\"]",1).click();
                break;
            case "12:00":
                $("[rel=\"12\"]",1).click();
                break;
            case "13:00":
                $("[rel=\"13\"]",1).click();
                break;
            case "14:00":
                $("[rel=\"14\"]",1).click();
                break;
            case "15:00":
                $("[rel=\"15\"]",1).click();
                break;
            case "16:00":
                $("[rel=\"16\"]",1).click();
                break;
            case "17:00":
                $("[rel=\"17\"]",1).click();
                break;
            case "18:00":
                $("[rel=\"18\"]",1).click();
                break;
            case "19:00":
                $("[rel=\"19\"]",1).click();
                break;
            case "20:00":
                $("[rel=\"20\"]",1).click();
                break;
            case "21:00":
                $("[rel=\"21\"]",1).click();
                break;
            case "22:00":
                $("[rel=\"22\"]",1).click();
                break;
            case "23:00":
                $("[rel=\"23\"]",1).click();
                break;
            case "24:00":
                $("[rel=\"24\"]",1).click();
                break;


        }
        return new MainPage();

    }


}
