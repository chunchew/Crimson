package test;
//Page Factory use @FindBy for elements init in page factory classes
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import PageFactory.EduLogin;

public class TestEduLoginWithPageFactory {

    WebDriver driver;
    EduLogin objLogin;
  
    @BeforeTest
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://accounts-staging.crimsoneducation.org/login?targetUrl=https://app-staging.crimsoneducation.org/&app=lms");

    }
  

    @Test(priority=0)
    public void test_Login_Page_Appear_Correct(){
        //Create Login Page object
    objLogin = new EduLogin(driver);

    //Verify login page title
    String loginPageTitle = objLogin.getLoginTitle();
    Assert.assertTrue(loginPageTitle.toLowerCase().contains("crimson accounts"));

    //login to application
    objLogin.loginToEdu("crimson.autotest@gmail.com", "password1");
    
    }

    
    @Test(priority=1)
    public void test_Login_Correct(){
        //Create Login Page object
    objLogin = new EduLogin(driver);
   
    //login to application
    objLogin.loginToEdu("crimson.autotest@gmail.com", "password1");
    }
    
    @Test(priority=2)
    public void test_Login_InCorrect(){
        //Create Login Page object
    objLogin = new EduLogin(driver);
   
    //login to application
    objLogin.loginToEdu("crimson.autotest@gmail.com", "password11111");
    
    }
    
    @Test(priority=3)
    public void test_goto_forgetPassword(){
    	objLogin.gotoForgetPassword();
    }
 }

