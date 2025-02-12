package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups = {"Regression", "Master"})
	public void verify_account_registration() {

		logger.info("**********Starting TC001_AccountRegistrationTest ********");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount Link");
			hp.clickRegister();
			logger.info("Clicked on Register Link");

			AccountRegistrationPage repage = new AccountRegistrationPage(driver);

			logger.info("Providing Customer details");
			repage.setFirstName(randomeString().toUpperCase());
			repage.setLastName(randomeString().toUpperCase());
			repage.setEmail(randomeString() + "@gmail.com"); // randomly generated the Email
			repage.setTelephone(randomeNumber());

			String password = randomeAlphaNumeric();
			repage.setPassword(password);
			repage.setConfirmPassword(password);

			repage.setPrivatePolicy();
			repage.ClickContinue();

			logger.info("Validating expected message.....");
			
			
			String confmsg = repage.getConfirmationMsg();
//			Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Confirmation message mismatched");
//			
//			logger.info("Test passed");
//		}
//		catch(Exception e) {
//			logger.error("Test failed: "+ e.getMessage());
//			Assert.fail("Test failed: "+ e.getMessage());
//		}
		
			
			

			if (confmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test Failed........");
				logger.debug("Debug logs........");
				Assert.assertTrue(false);
			}
			//Assert.assertEquals(confmsg, "Your Account Has Been Created!!!!");
		} catch (Exception e) {

			Assert.fail();
		}

		finally {
			logger.info("**********Finished TC001_AccountRegistrationTest ********");
		}
		
	}

}
