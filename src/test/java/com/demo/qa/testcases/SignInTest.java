package com.demo.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.demo.qa.base.TestBase;
import com.demo.qa.pages.SignIn;
import com.demo.qa.utils.TestUtils;
import com.qa.ExtentReportListner.TestAllureListener;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({ com.qa.ExtentReportListner.TestAllureListener.class })
public class SignInTest extends TestBase {
	

	SignIn signin;

	public SignInTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		signin = new SignIn();

	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: user signing in at app with valid credential"))
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: Verify user signing in successfully")
	public void TestCase1() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		signin.ClickOnSignInLink();
		boolean Emailfield = signin.verifyEmailfield();
		Assert.assertTrue(Emailfield);
		signin.EnterEmail(prop.getProperty("email"));
		boolean Passwordfield = signin.verifyPasswordfield();
		Assert.assertTrue(Passwordfield);
		signin.EnterPassowrd(prop.getProperty("password"));
		softassert.assertTrue(signin.verifySignInbutton(), "sign-in button is visible");
		signin.ClickOnSignInbutton();
		String verify_msg = driver.findElement(By.xpath("//*[ contains (text(),'Welcome, dafa asd!')]")).getText();
		softassert.assertEquals("Welcome, dafa asd!", verify_msg);
		softassert.assertAll();

	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: user signing in at app with Invalid credential"))
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description: Verify user should not signing in successfully with invalid credential")
	public void TestCase2() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		signin.ClickOnSignInLink();
		boolean Emailfield = signin.verifyEmailfield();
		Assert.assertTrue(Emailfield);
		signin.EnterEmail(prop.getProperty("invalidemail"));
		boolean Passwordfield = signin.verifyPasswordfield();
		Assert.assertTrue(Passwordfield);
		signin.EnterPassowrd(prop.getProperty("invalidpassword"));
		softassert.assertTrue(signin.verifySignInbutton(), "sign-in button is visible");
		signin.ClickOnSignInbutton();
		String error_msg = driver.findElement(By.xpath(
				"//*[ contains (text(),'The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.')]"))
				.getText();
		softassert.assertEquals(
				"The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.",
				error_msg);
		softassert.assertAll();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}