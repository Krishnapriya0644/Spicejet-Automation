package testcases;

import java.io.IOException;
import org.testng.annotations.Test;

import PageObjects.Signuppage;
import base.BaseClass;

public class Signup_Test extends BaseClass{
	
	//to do Sign-Up functionality
	@Test(priority = 1)
	public void Signup() throws InterruptedException, IOException {
		//create an object of SignUpPage class
		Signuppage spsignup=new Signuppage(driver);
		
		//Click SignupLink
		spsignup.SignupClick();
		
		//Fill the details
		spsignup.EnterTitle(prop.getProperty("Title"));
		spsignup.EnterFirstName(prop.getProperty("FirstName"));
		spsignup.EnterLastName(prop.getProperty("LastName"));	
		spsignup.EnterCountry(prop.getProperty("Country"));		
		Thread.sleep(1500);
		spsignup.EnterDOB(prop.getProperty("dobMonth"),prop.getProperty("dobYear"),prop.getProperty("dobDay"));
		Thread.sleep(1500);
		spsignup.EnterTelephoneNumber(prop.getProperty("MobileNumber"));
		Thread.sleep(1500);
		spsignup.EnterEmail(prop.getProperty("EMail"));
		spsignup.EnterPassword(prop.getProperty("Password"));
		spsignup.EnterConfirmPassword(prop.getProperty("ConfirmPassword"));
		spsignup.SelectTermsConditions();
	}
}