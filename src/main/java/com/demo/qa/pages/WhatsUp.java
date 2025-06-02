package com.demo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.qa.base.TestBase;

import io.qameta.allure.Step;

public class WhatsUp extends TestBase {
	// watch (product) link element
	@FindBy(linkText = "Summit Watch")
	WebElement WatchLink;

	// Quantity input field
	@FindBy(id = "qty")
	WebElement QuantityInputFld;

	// Review section button
	@FindBy(id = "tab-label-reviews-title")
	WebElement ReviewsTab;

	// 3star rating button button
	@FindBy(id = "Rating_3_label")
	WebElement ThreeStarRating;

	// NickName field
	@FindBy(id = "nickname_field")
	WebElement NickNameFld;

	// Summary field
	@FindBy(id = "summary_field")
	WebElement SummaryFld;

	// Review field
	@FindBy(id = "review_field")
	WebElement ReviewFld;

	// review submit button
	@FindBy(xpath = "//div[ contains (text(),'Submit Review')]")
	WebElement SubmitBtn;

	// Add to your Wishlist button button
	@FindBy(xpath = "/html/body/div[2]/main/div[1]/div[2]/div/div/div")
	WebElement AddToWishListBtn;

//Initializing the Page Objects:
	public WhatsUp() {
		PageFactory.initElements(driver, this);
	}

	// Actions:

	@Step("verifying Watch link is available")
	public boolean verifyWatchlink() {
		return WatchLink.isDisplayed();
	}

	@Step("click on Watch Product")
	public void ClickOnWatch() {
		WatchLink.click();
	}

	@Step("entering Quantity: {0} ")
	public void EnterQuantity(String QTY) {
		QuantityInputFld.sendKeys(QTY);
	}

	@Step("Click on review section")
	public void ClickOnReviewsTab() {
		ReviewsTab.click();
	}

	@Step("Giving 3star rating")
	public void StarRating() {
		ThreeStarRating.click();
	}

	@Step("entering NickName: {0} ")
	public void EnterNickName(String NickName) {
		NickNameFld.sendKeys(NickName);
	}

	@Step("entering Summary: {0} ")
	public void EnterSummary(String Summary) {
		SummaryFld.sendKeys(Summary);
	}

	@Step("entering Review: {0} ")
	public void EnterReview(String Review) {
		ReviewFld.sendKeys(Review);
	}

	@Step("Click on Submit review button")
	public void ClickonSubmitButton() {
		SubmitBtn.click();
	}

	@Step("Adding to wishList")
	public void AddingToWishlist() {
		AddToWishListBtn.click();
	}

}