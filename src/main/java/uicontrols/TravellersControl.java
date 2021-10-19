package uicontrols;

import BaseControlls.BaseControl;
import Core.TAEDriver;
import Entities.Travellers;
import forms.HotelForm;
import forms.HotelForm.*;
import org.openqa.selenium.By;

public class TravellersControl extends BaseControl {
    public TravellersControl(String name, TAEDriver driver, By locator) {
        super(name, driver, locator);
    }

    public TravellersControl(String name, TAEDriver driver, String xpath) {
        super(name, driver, xpath);
    }


    public void setTravellers(Travellers travellers){
        HotelForm hotelForm = new HotelForm(driver);

        hotelForm.clearForm();

        hotelForm.rooms.sendKeys(String.valueOf(travellers.getRooms()));
        hotelForm.adults.sendKeys(String.valueOf(travellers.getAdults()));
        hotelForm.children.sendKeys(String.valueOf(travellers.getChild()));

    }
    public void setTravellersWithNationality(Travellers travellers){
        HotelForm hotelForm = new HotelForm(driver);

        hotelForm.clearForm();

        hotelForm.rooms.sendKeys(String.valueOf(travellers.getRooms()));
        hotelForm.adults.sendKeys(String.valueOf(travellers.getAdults()));
        hotelForm.children.sendKeys(String.valueOf(travellers.getChild()));
        hotelForm.nationality.sendKeys(travellers.getNationality());
    }

}
