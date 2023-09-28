package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModels.RegistrationPage;
import testBase.BaseClass;

public class T_001_RegistrationTest extends BaseClass {

    @Test(groups = {"Master", "Regression"})
    public void testRegistration() throws InterruptedException {
        logger.info("Creating an account for Registration");
        try {

            RegistrationPage rg = new RegistrationPage(driver);
            rg.clickOnRegisterButton();
            rg.selectUserTitle("Miss");
            rg.setUserFirstName(randomRegistrationUserFirstName());
            rg.setUserSirName(randomRegistrationSirName());
            rg.setUserPhoneNumber(randomRegistrationPhone());
            rg.selectBirthYear(9);
            rg.selectBirthMonth("January");
            rg.selectBirthDate(8);
            rg.selectLicenceType();
            rg.selectLicencePeriod(10);
            rg.selectOcupation(4);
            rg.insertStreet("42378");
            rg.setCity("London");
            rg.setCounty("England");
            rg.setPosteCode("lo55 5eg");
            rg.setEmail(randomRegistrationEmail()+"@gmail.com");
            String password = randomPassword();
            rg.setPassword(password);
            rg.setPasswordConfirmation(password);
            rg.clickCreateOnCreateButton();
            Assert.assertTrue(rg.validateRegistration());
        }catch (Exception e){
            Assert.fail();
        }
        logger.info("Account created for Registration");
    }

}
