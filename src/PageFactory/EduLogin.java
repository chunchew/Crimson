package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class EduLogin {

    WebDriver driver;
    @FindBy(name="email")
    WebElement userEduName;

    @FindBy(name="password")
    WebElement passwordEdu;

    By login =By.tagName("button");
    
    By forgotPassword =By.className("forgotPassword_apy0v");
    
    public EduLogin(WebDriver driver){

        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);

    }

    //Set user name in textbox

    public void setUserName(String strUserName){
    	userEduName.sendKeys(strUserName);     
    }
    
    //Set password in password textbox
    public void setPassword(String strPassword){
    	passwordEdu.sendKeys(strPassword);
    }


    //Click on login button
    public void clickLogin(){
    	driver.findElement(login).click();
    	
    }

    

    //Get the title of Login Page

    public String getLoginTitle(){
     return    driver.getTitle();
    }

  //forget password
    public void gotoForgetPassword(){
     driver.findElement(By.linkText("Forgot your password?")).click();
    }

    public void loginToEdu(String strUserName,String strPasword){

        //Fill user name

        this.setUserName(strUserName);

        //Fill password

        this.setPassword(strPasword);

        //Click Login button

        this.clickLogin();

                

    }

}