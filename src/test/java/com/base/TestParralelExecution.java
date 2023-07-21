package com.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestParralelExecution {

	public String username = "YOUR_USERNAME";
	public String accesskey = "YOUR_ACCESSKEY";
	public static RemoteWebDriver driver = null;
	public String gridURL = "@hub.lambdatest.com/wd/hub";
	boolean status = false;
	
	
	@BeforeMethod
	@Parameters(value={"browser","version","platform"})
	public void setUp(String browser, String version, String platform) throws Exception {
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	     capabilities.setCapability("browserName", browser);
	     capabilities.setCapability("version", version);
	     capabilities.setCapability("platform", platform); // If this cap isn't specified, it will just get the any available one
	     capabilities.setCapability("build", "TestMethodParallelExecution");
	     capabilities.setCapability("name", "TestMethodParallelExecution");
	     capabilities.setCapability("network", true); // To enable network logs
	     capabilities.setCapability("visual", true); // To enable step by step screenshot
	     capabilities.setCapability("video", true); // To enable video recording
	     capabilities.setCapability("console", true); // To capture console logs
	     try {
	     driver = new RemoteWebDriver(new URL("http://cicd-iqcoreapp:5002/WebController.dll?Start"), capabilities);
    } catch (MalformedURLException e) {
        System.out.println("Invalid grid URL");
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
	     
	     
}
	
	
	@AfterMethod
    public void tearDown() throws Exception {
        if (driver != null) {
            System.out.println("Tearing down..");
            driver.quit();
        }}
}
