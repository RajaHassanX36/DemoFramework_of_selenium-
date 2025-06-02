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
import com.demo.qa.pages.WhatsUp;
import com.demo.qa.utils.TestUtils;
import com.qa.ExtentReportListner.TestAllureListener;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({ com.qa.ExtentReportListner.TestAllureListener.class })

public class WhatsUpTest extends TestBase {
	
	SignIn signin;
	WhatsUp whatsup;

	public WhatsUpTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		signin = new SignIn();
		whatsup = new WhatsUp();
		
		signin.ClickOnSignInLink();
		signin.EnterEmail(prop.getProperty("email"));
		signin.EnterPassowrd(prop.getProperty("password"));
		signin.ClickOnSignInbutton();
		signin.clickOnWhatsnewPage();

	}

	
	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: add product to wishlist"))
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify user adding product to wishlist successfully")
	public void TestCase3() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		// ✅ Step 1: Verify page title
	    String expectedTitle = "What's New"; // Replace with actual expected title
	    String actualTitle = driver.getTitle();
	    Assert.assertEquals(actualTitle, expectedTitle, "❌ Page title does not match!");
	    softassert.assertTrue(whatsup.verifyWatchlink(),"Watch is available");
	    whatsup.ClickOnWatch();
		whatsup.EnterQuantity("2");
		whatsup.AddingToWishlist();
		String verify_msg = driver.findElement(By.xpath("//*[ contains (text(),'Summit Watch has been added to your Wish List. Click')]")).getText();
		softassert.assertEquals("Summit Watch has been added to your Wish List. Click", verify_msg);
		softassert.assertAll();

	}
	
	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Adding review"))
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Adding review to product")
	public void TestCase4() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		// ✅ Step 1: Verify page title
	    String expectedTitle = "What's New"; // Replace with actual expected title
	    String actualTitle = driver.getTitle();
	    Assert.assertEquals(actualTitle, expectedTitle, "❌ Page title does not match!");
	    softassert.assertTrue(whatsup.verifyWatchlink(),"Watch is available");
	    whatsup.ClickOnWatch();
		whatsup.ClickOnReviewsTab();
		whatsup.EnterNickName("Tester");
		whatsup.EnterSummary("best watch");
		whatsup.EnterReview("the best product at web");
		whatsup.ClickonSubmitButton();
		softassert.assertAll();

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
