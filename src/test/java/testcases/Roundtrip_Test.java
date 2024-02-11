package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.Searchflight;
import base.BaseClass;


public class Roundtrip_Test extends BaseClass{

//To search for flights by entering dummy origin and destination information for Round trip
	@Test(priority = 2)
	public void SearchFlightRoundTrip() throws InterruptedException, IOException {
		//Create an object
		Searchflight roundTripsearchflight=new Searchflight(driver);

		//Select roundTrip trip
		roundTripsearchflight.RoundTripClick();

		//Fill the details
		roundTripsearchflight.EnterOnboarding(prop.getProperty("From"));
		roundTripsearchflight.EnterDestinationTo(prop.getProperty("To"));

		//Select the departure date and return date
		roundTripsearchflight.ClickDepartureDate();
		roundTripsearchflight.selectmonth(prop.getProperty("day"),prop.getProperty("MonthValue"));

		roundTripsearchflight.ClickDepartureDate();
		roundTripsearchflight.selectmonth(prop.getProperty("day"),prop.getProperty("MonthValue"));

		roundTripsearchflight.SelectPassengers();
		roundTripsearchflight.IncreaseAdult();
		roundTripsearchflight.IncreaseChildren();
		roundTripsearchflight.SelecCurrency(prop.getProperty("currency"));
		roundTripsearchflight.FlightSearchClick();

		//Validation
		String actualValue = roundTripsearchflight.getOnewayTripValidation().getText();
		Assert.assertTrue(actualValue.contains("Round Trip : Delhi to Bengaluru"));

	}
}
