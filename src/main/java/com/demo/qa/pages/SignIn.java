package com.demo.qa.pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.demo.qa.base.TestBase;

import io.qameta.allure.Step;

public class SignIn extends TestBase {

	// sign-in link element
	@FindBy(linkText = "Sign In")
	WebElement Signin_link;

	// Enter Email field
	@FindBy(id = "email")
	WebElement Emailfld;

	// Enter password field
	@FindBy(id = "pass")
	WebElement Passwordfld;

	// Signin button element
	@FindBy(id = "send2")
	WebElement Signinbtn;

	// Whats new page link element
	@FindBy(id = "ui-id-3")
	WebElement WhatsNewLink;

	public SignIn() {
		PageFactory.initElements(driver, this);
	}

	@Step("verifying app is open and signin link available")
	public boolean verifySigninlink() {
		return Signin_link.isDisplayed();
	}

	@Step("click at signin link")
	public void ClickOnSignInLink() {
		Signin_link.click();
	}

	public boolean verifyEmailfield() {
		return Emailfld.isEnabled();
	}

	@Step("entering email address: {0} ")
	public void EnterEmail(String email) {
		Emailfld.sendKeys(email);
	}

	public boolean verifyPasswordfield() {
		return Passwordfld.isEnabled();
	}

	@Step("entering password: {0}")
	public void EnterPassowrd(String password) {
		Passwordfld.sendKeys(password);
	}

	public boolean verifySignInbutton() {
		return Signinbtn.isEnabled();
	}

	@Step("signing in")
	public void ClickOnSignInbutton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(Signinbtn));
		Signinbtn.click();
	}
	
	@Step("Go to Whatsnew page")
	public WhatsUp clickOnWhatsnewPage(){
		WhatsNewLink.click();
		return new WhatsUp();
	}

}
