package pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
        //hana@gmail.com
        //123password

    }
    @FindBy(id = "email") WebElement loginEmail;

    @FindBy(id = "password") WebElement loginPassword;

    @FindBy(xpath = "//input[@name='submit']") WebElement loginBtn;

    @FindBy(xpath = "//input[@value='Log out']") WebElement logoutBtn;
    public void setLoginEmail(String email){
        loginEmail.sendKeys(email);
    }
    public void setLoginPassword(String password){
        loginPassword.sendKeys(password);
    }
    public void clickLogout(){logoutBtn.click();}

    public void clickOnLogin() {
        loginBtn.click();
    }

}
