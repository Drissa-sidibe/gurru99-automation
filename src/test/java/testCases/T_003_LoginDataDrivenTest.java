package testCases;

import Utilities.DataProviders;
import Utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModels.BrokerInsuranceWebPage;
import pageObjectModels.LoginPage;
import testBase.BaseClass;

public class T_003_LoginDataDrivenTest extends BaseClass {


    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    void testLogin(
            String email,
            String password,
            String expected
    ){
        try {
        logger.info("Starting to test Login");

            LoginPage lg = new LoginPage(driver);
            lg.setLoginEmail(email);
            lg.setLoginPassword(password);
            lg.clickOnLogin();

        BrokerInsuranceWebPage insWebPage = new BrokerInsuranceWebPage(driver);

           boolean webPage = insWebPage.insuranceWebPage();
            if(expected.equals("Valid")){
                if(webPage==true){
                    lg.clickLogout();
                    Assert.assertTrue(true);
                }else{
                    Assert.assertTrue(false);
                }
            }
            if(expected.equals("Invalid")){
                if(webPage==true){
                    lg.clickLogout();
                    Assert.assertTrue(false);
                }else{
                    Assert.assertTrue(true);
                }
            }
        }catch (Exception e){
            Assert.fail();
        }
        logger.info("Login Test Finished");

    }

}
