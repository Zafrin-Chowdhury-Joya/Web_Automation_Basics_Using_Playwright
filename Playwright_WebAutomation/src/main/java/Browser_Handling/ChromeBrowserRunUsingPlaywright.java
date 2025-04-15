package Browser_Handling;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ChromeBrowserRunUsingPlaywright {
	Playwright playwright;
	BrowserType browsertype ;
	Browser browser ;
	BrowserContext browserContext ;
	Page page; 
	
	@BeforeSuite
	public void startBrowser()
	{
		playwright = Playwright.create();
		browsertype = playwright.chromium();
		browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		browserContext = browser.newContext(new Browser.NewContextOptions());
		page =browser.newPage();
		System.out.println("Version :" +browser.version());
	}
	@Test
	public void OpenUrl() throws InterruptedException
	{
		page.navigate("https://devxhub.com/");
		Thread.sleep(500);
	}
	
	@AfterSuite
	public void closeBrowser()
	{
		page.close();
		browser.close();
		playwright.close();
	}

}