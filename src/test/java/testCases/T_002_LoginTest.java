package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModels.BrokerInsuranceWebPage;
import pageObjectModels.LoginPage;
import testBase.BaseClass;

public class T_002_LoginTest extends BaseClass {

    @Test(groups = {"Sanity","Master"})
    void testLogin(){
        logger.info("Starting to test Login");
        try {
            LoginPage lg = new LoginPage(driver);
            lg.setLoginEmail(bundle.getString("email"));
            lg.setLoginPassword(bundle.getString("password"));
            lg.clickOnLogin();
            BrokerInsuranceWebPage insWebPage = new BrokerInsuranceWebPage(driver);
            boolean targetWebPage = insWebPage.insuranceWebPage();
            Assert.assertEquals(targetWebPage,true);
        }catch (Exception e){
            Assert.fail();
        }
    }

}
