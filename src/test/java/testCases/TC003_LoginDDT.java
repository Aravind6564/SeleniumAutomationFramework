package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "datadriver") 
	//"dataProviderClass" -> need to enter if Dataprovider is created in another class or package
																				// 
	public void verify_LoginDDT(String email, String password, String exp) throws InterruptedException {
		
		logger.info("*********Starting TC003_LoginDDT****************");
		try {
		// HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();

		// LoginPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();

		// MyAccountPage
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists();

		/*
		 * Data is valid -> login Success -> Test Pass -> Logout -> Login Failed -> Test
		 * Failed
		 * 
		 * Data is Invalid -> Login Success - test fail -> Logout -> Login Failed - test
		 * pass
		 */

		if(exp.equalsIgnoreCase("Valid")) 
		{
			if (targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else 
			{
				Assert.assertTrue(false);
			}
		}

		if(exp.equalsIgnoreCase("InValid"))
		{
			if (targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			} 
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		Thread.sleep(3000);
		logger.info("*********Ending TC003_LoginDDT****************");
		
	}

}
