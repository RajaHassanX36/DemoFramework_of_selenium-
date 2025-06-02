//package com.demo.qa.base;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.time.Duration;
//import java.util.Properties;
//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
////import org.openqa.selenium.devtools.v106.headlessexperimental.HeadlessExperimental;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.support.events.EventFiringDecorator;
//import com.demo.qa.utils.TestUtils;
//import com.demo.qa.utils.WebEventListener;
////import bsh.This;
//public class TestBase {
//	
//	public static WebDriver driver;
//	public static Properties prop;
//	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
//	public static WebEventListener eventListener;
//	
//	public WebDriver TestBase(){
//		// this function is to read properties from config file
//		prop = new Properties();
//		String path = "C:\\Users\\Raja\\eclipse-workspace\\Demo\\src\\main\\java\\com\\demo\\qa\\config\\exampleConfig.properties";
//		try {
//			FileInputStream ip = new FileInputStream(path);
//			prop.load(ip);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		tdriver.set(driver);
//		return getDriver();		
//	}
//	
//	public static synchronized WebDriver getDriver() {
//		return tdriver.get();
//	}
//	
//	
//	public static void initialization(){
//		String browserName = prop.getProperty("browser");
//		
//		if(browserName.equals("chrome")){
//	        ChromeOptions options = new ChromeOptions();
////	        This line is for Headless mode uncomment below line when try to headless
////			options.addArguments("--headless=chrome");
//	        driver = new ChromeDriver(options);
//		}
//		else if(browserName.equals("FF")){
//	        FirefoxOptions options = new FirefoxOptions();
//	        driver = new FirefoxDriver(options);
//		}
//		
//		
//		WebEventListener eventListener = new WebEventListener();
//		EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(eventListener);
//		
//		driver = decorator.decorate(driver);
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtils.PAGE_LOAD_TIMEOUT));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.IMPLICIT_WAIT));
//		
//		driver.get(prop.getProperty("url"));
//		
//		
//		
//	}
//}
////		// handle basic auth - only password field alert
////		driver.switchTo().alert().sendKeys(prop.getProperty("auth_password"));
////		driver.switchTo().alert().accept();
////
////	}
////}

package com.demo.qa.base;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.AfterSuite;
import org.testng.log4testng.Logger;


import com.demo.qa.utils.TestUtils;
import com.demo.qa.utils.WebEventListener;
import org.openqa.selenium.OutputType;
import jdk.javadoc.doclet.Reporter;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();
	public static WebEventListener eventListener;

	// ✅ Correct constructor
	public TestBase() {
		prop = new Properties();
		String path = System.getProperty("user.dir") + "/src/main/java/com/demo/qa/config/exampleConfig.properties";
		try (FileInputStream ip = new FileInputStream(path)) {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ✅ Getter for ThreadLocal WebDriver
	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}

	// ✅ Proper driver setup
	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			// options.addArguments("--headless=new");
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("ff")) {
			FirefoxOptions options = new FirefoxOptions();
			driver = new FirefoxDriver(options);
		}

		// Event listener
		WebEventListener eventListener = new WebEventListener();
		EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(eventListener);
		driver = decorator.decorate(driver);

		// ✅ Set ThreadLocal driver here
		tdriver.set(driver);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtils.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.IMPLICIT_WAIT));
		driver.get(prop.getProperty("url"));
	}

	@AfterSuite
	public void openHtmlReport() {
		// For Extent Report
		try {
			File htmlFile = new File("test-output/Extent.html");
			if (htmlFile.exists()) {
				Desktop.getDesktop().browse(htmlFile.toURI());
			} else {
				System.out.println("Reporter not found: " + htmlFile.getAbsolutePath());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// For ALLURE Report
		try {
			ProcessBuilder builder = new ProcessBuilder(
					"C:\\Users\\Raja\\Desktop\\allure-2.34.0\\allure-2.34.0\\bin\\allure.bat", "serve",
					"C:\\Users\\Raja\\eclipse-workspace\\Demo\\allure-results");
			builder.inheritIO();
			Process process = builder.start();
			process.waitFor();
			// Allure serve will automatically open report in browser
			System.err.println("Allure report serve successfully");
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			System.err.println("Failed to serve Allure report");

		}
	}
	
}
