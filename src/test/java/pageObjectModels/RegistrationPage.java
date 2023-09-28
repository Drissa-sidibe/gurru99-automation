package pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[normalize-space()='Register']")//a[normalize-space()='Register']
    WebElement registerBtn;
    @FindBy(id = "user_title")
    WebElement txtUserTiles;

    @FindBy(id = "user_firstname")
    WebElement firstName;

    @FindBy(id = "user_surname") WebElement userSirName;

    @FindBy(id = "user_phone") WebElement userPhoneNumber;

    @FindBy(name = "year") WebElement yearSdropDown; //
    //name="" month
    //select[@id='user_dateofbirth_1i']//option
    @FindBy(name = "month") WebElement monthSdropDown;
    @FindBy(name = "date") WebElement dateSdropDown;
    @FindBy(xpath = "//input[@name='licencetype']") List<WebElement> ckbxLicenceTypes;
    @FindBy(xpath = "//Select[@Id='user_licenceperiod']")
    WebElement licencePeriodDropDown;
    @FindBy(name = "occupation") WebElement occupation;

    @FindBy(name = "street") WebElement streetNumber;
    @FindBy(name = "city") WebElement txtCity;

    @FindBy(name="county") WebElement txtCounty;
    @FindBy(name = "post_code") WebElement alphaNumPostCode;
    @FindBy(name = "email") WebElement txtEmail;
    @FindBy(xpath = "//input[@id='user_user_detail_attributes_password']") WebElement password;

    @FindBy(xpath = "//input[@id='user_user_detail_attributes_password_confirmation']") WebElement confirmPassword;

    @FindBy(name="submit")  WebElement createButton;
    @FindBy(id = "resetform") WebElement resetButton;

    @FindBy(xpath = "//h3[normalize-space()='Login']") WebElement loginPageText;

    public void clickOnRegisterButton(){
        registerBtn.click();
    }
    public void setUserFirstName(String fName) throws InterruptedException {
        Thread.sleep(5000);
        firstName.sendKeys(fName);
    }
    public void setUserSirName(String sirName) throws InterruptedException {
        Thread.sleep(5000);
        userSirName.sendKeys(sirName);
    }
    public void setUserPhoneNumber(String phoneNumber) throws InterruptedException {
        Thread.sleep(5000);
        userPhoneNumber.sendKeys(phoneNumber);
    }

    public void selectUserTitle(String visibleText) throws InterruptedException {
        Thread.sleep(5000);
        Select select = new Select(txtUserTiles);
        select.selectByVisibleText(visibleText);
    }
    public void selectBirthYear(int index) throws InterruptedException {
        Thread.sleep(5000);
    Select yrdrop = new Select(yearSdropDown);
    yrdrop.selectByIndex(index);
    }
    public void selectBirthMonth(String visibleText) throws InterruptedException {
        Thread.sleep(5000);
        Select sl = new Select(monthSdropDown);
                sl.selectByVisibleText(visibleText);
    }
    public void selectBirthDate(int index) throws InterruptedException {
        Thread.sleep(5000);
        Select sel = new Select(dateSdropDown);
        sel.selectByIndex(index);
    }
    public void selectLicenceType() throws InterruptedException {
        Thread.sleep(5000);
       List<WebElement> boxes = ckbxLicenceTypes;
       boxes.stream().filter(box->box.getText()
               .equals("Provisional"))
               .findFirst()
               .ifPresent(WebElement::click);
    }
    public void selectOcupation(int index) throws InterruptedException {
        Thread.sleep(5000);
        Select select = new Select(occupation);
        select.selectByIndex(index);

    }
    public void selectLicencePeriod(int index) throws InterruptedException {
        Thread.sleep(5000);
        Select sele = new Select(licencePeriodDropDown);
        sele.selectByIndex(index);
    }
    public void insertStreet(String streetNum) throws InterruptedException {
        Thread.sleep(5000);
        streetNumber.sendKeys(streetNum);
    }
    public void setCity(String cityName) throws InterruptedException {
        Thread.sleep(5000);
        txtCity.sendKeys(cityName);
    }
    public void setCounty(String countryName) throws InterruptedException {
        Thread.sleep(5000);
        txtCounty.sendKeys(countryName);
    }
    public void setPosteCode(String code) throws InterruptedException {
        Thread.sleep(5000);
        alphaNumPostCode.sendKeys(code);
    }
    public void setEmail(String email) throws InterruptedException {
        Thread.sleep(5000);
        txtEmail.sendKeys(email);
    }
    public void setPassword(String pass) throws InterruptedException {
        Thread.sleep(5000);
        password.sendKeys(pass);
    }
    public void setPasswordConfirmation(String pa) throws InterruptedException {
        Thread.sleep(5000);
        confirmPassword.sendKeys(pa);
    }
    public void clickCreateOnCreateButton() throws InterruptedException {
        Thread.sleep(5000);
        createButton.click();
    }
    public void clickOnResetButton() throws InterruptedException {
        Thread.sleep(5000);
        resetButton.click();
    }
    public boolean validateRegistration(){
        try {
            return loginPageText.isDisplayed();
        }catch (Exception e){
            e.getMessage();
        }

        return false;
    }


}
