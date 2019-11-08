
package functionalLib;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Reporting.Report;
//import Reporting.Report;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class ATBusinessActions {
	WebDriver BDriver;
	String sTDFileName;
	String Navtextfiles;
	uiObjInfo.UILocators oUIObj = new uiObjInfo.UILocators();
	public String oParentBrw;
	String Screenshotpath;
	File scrFile;
	String appURL;
	String browser;
	String devicename;
	String platformname;
	String devc;
	String platformversion;
	Report selectReport;
	String Navigationtextfiles;
	public String[] arrMenuPag;
	public String[] arrMenuFilt;
	public String[] arrSortByFilt;
	public static int ChtestcaseNo;

//Constructor
	public ATBusinessActions(WebDriver BDriver, String strURL, String devicename, String platformname, String devc,
			String platformversion, String browser, Report report) throws IOException {
		sTDFileName = ExcelRead.exlPath();
		Navtextfiles = report.Navigationtextfiles;
		Screenshotpath = report.strScreenshotPath;
		this.BDriver = BDriver;
		this.appURL = strURL;
		this.devicename = devicename;
		this.platformname = platformname;
		this.devc = devc;
		this.platformversion = platformversion;
		this.browser = browser;
		selectReport = report;
	}

	/*
	 * TC_openApplication Created By GRK Usage: Opening Spirit app in UAT
	 * environment from Excel sheet
	 * 
	 * @Information will read form Excel sheet
	 */
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void openApplication() throws IOException, InterruptedException, BiffException, WriteException {
		System.out.println("---" + appURL + "---");

		if (browser.equalsIgnoreCase("Firefox")) {
			System.out.println("Inside firefox");
			selectReport.iSleep = 500;
			Thread.sleep(500);
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\Resources\\geckodriver.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities = DesiredCapabilities.firefox();
			capabilities.setBrowserName("firefox");
			// capabilities.setVersion("45.0.2");
			capabilities.setPlatform(Platform.WINDOWS);
			capabilities.setCapability("marionette", false);
			try {
				BDriver = new FirefoxDriver(capabilities);
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}

			BDriver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("Chrome")) {
			System.out.println("Inside Chrome");
			selectReport.iSleep = 500;
			Thread.sleep(500);
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/Resources/chromedriver.exe");
			BDriver = new ChromeDriver();
			BDriver.manage().window().maximize();
			System.out.println("Browser open in chrome but not executed");

		} else if (browser.equalsIgnoreCase("IE")) {
			selectReport.iSleep = 2000;
			Thread.sleep(2000);
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/Resources/IEDriverServer.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			// this line of code is to resolve protected mode issue
			// capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
			// true);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability("unexpectedAlertBehaviour", "accept");
			capabilities.setCapability("ignoreProtectedModeSettings", true);
			capabilities.setCapability("enablePersistentHover", false);
			capabilities.setCapability("ignoreZoomSetting", true);
			capabilities.setCapability("nativeEvents", false);
			BDriver = new InternetExplorerDriver(capabilities);
			BDriver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("Safari")) {
			selectReport.iSleep = 2000;
			Thread.sleep(2000);
			SafariOptions safariOpts = new SafariOptions();
			DesiredCapabilities cap = DesiredCapabilities.safari();

			// ((Object) safariOpts).setUseCleanSession(true);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			// cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "dismiss");
			cap.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
			cap.setCapability(SafariOptions.CAPABILITY, safariOpts);
			cap.setBrowserName("safari");
			cap.setPlatform(Platform.MAC);

			BDriver = new SafariDriver();

		}

		selectReport.gbDriver = BDriver;
		System.out.println("Before andoid");
		BDriver.get(appURL);
		System.out.println(BDriver.getTitle());
		waitforpageload();
		Thread.sleep(5000);
		if (browser.contains("iOS"))
			Thread.sleep(12000);
		selectReport.ReportStep("Pass", "Open Application", "Application should open",
				"Opened " + appURL + " application successfully");
		System.out.println("after report step");
		if (browser.equalsIgnoreCase("IE")) {
			System.out.println("inside IE");
			try {
				BDriver.findElement(By.xpath("//a[contains(@id,'overridelink')]")).click();
				Thread.sleep(4000);
			} catch (Exception ex) {
				System.out.println("");
			}
		}
		new File(Navtextfiles).mkdir();
	}

	/*
	 * waitforpageload Created By GRK Usage: Wait up to load complete page
	 * 
	 * @Information will save into database
	 */
	public void waitforpageload() {
		System.out.println("inside wait load");
		JavascriptExecutor js = (JavascriptExecutor) BDriver;
		for (int i = 0; i < 5000; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			// To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}

	// Implicit wait
	public void pImplicitWait() {
		System.out.println("applying Implict wait");
		BDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	/*
	 * TC_closeApplication Created by GRK Usage: Closing all browsers
	 * 
	 * @Information will read form Excel sheet
	 */
	public void closeApplication() throws InterruptedException {
		Thread.sleep(2000);
		BDriver.quit();
		if (selectReport.curntTestStatus.equalsIgnoreCase("pass")
				&& selectReport.curntVerifysteptStatus.equalsIgnoreCase("pass")) {
			selectReport.noTestsPassed++;
		} else {
			selectReport.noTestsFailed++;
		}
		try {
			selectReport.CloseTestReport();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/*
	 * TC_captureScreenshotall Created by GRK Usage: Capturing Screenshots of the
	 * page
	 * 
	 * @Information For the validation purpose
	 */

	public void captureScreenshotall(String img) throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MMM_yyyy_HHmmss");
		TakesScreenshot oScn = (TakesScreenshot) BDriver; // Type casting

//screenshot info will be saved in oScnshot variable (of type file)
		File oScnshot = oScn.getScreenshotAs(OutputType.FILE);

//Creating a empty image file
		File oDest = new File(Screenshotpath, img + "_" + sdf.format(new Date()) + ".png");
//Save in a Physical location
		org.apache.maven.surefire.shade.org.codehaus.plexus.util.FileUtils.copyFile(oScnshot, oDest);

	}

	/*
	 * TC_setText Created By GRK Usage: Generaic function for Entering value in
	 * textbox
	 * 
	 * @Information: Reading the value from the Excel Sheet
	 **/
	public void setText(String strLocator, String strvalue) {
		try {
			getElement(strLocator).clear();
			highLight(BDriver, strLocator);
			getElement(strLocator).click();
			getElement(strLocator).sendKeys(strvalue);
			System.out.println("After enter value");
			selectReport.ReportStep("Pass", "Input Text", "Set Text", "Value Entered as " + strvalue);
		} catch (Exception e) {
			System.out.println("Failed to find element " + strLocator); // + strLocator);
			selectReport.ReportStep("Fail", "Input Text", "Set Text", "Text not entered " + strvalue);
//sreenshotSoftLine(Global.gstrResultPath + "\\setText" + strvalue);
		}
	}

	/*
	 * Error Validation Created By GRK Usage: Generaic function for validation
	 * errors
	 **/
	public void ErrorValidation(String strLocator, String ErrorText) {
		try {
			WebElement ErrorMsg = getElement(strLocator);
			ErrorMsg.isDisplayed();
//			if (ErrorMsg.isDisplayed()) {
//				System.out.println("Error validation displayed for given value");
//				selectReport.ReportStep("Fail", "Validating Message", "Error Text", "Validation as " + ErrorText);
//				Thread.sleep(3000);
//				BDriver.close();
//			} else {
//				selectReport.ReportStep("Pass", "Validating Message", "No Validation Text",
//						"Validation Successful ");
//			}
//			
			System.out.println("Error validation displayed for given value");
			selectReport.ReportStep("Fail", "Validating Message", "Error Text", "Validation displayed as " + ErrorText);
			//BDriver.close();
			closeApplication();
			
		} catch (Exception e) {
			System.out.println("No validation displayed and provided data is valid"); // + strLocator);
			selectReport.ReportStep("Pass", "Validating Message", "Error Text", "Validation displayed as " + ErrorText);
		}
	}

	/*
	 * controlClick Created By GRK Usage: Generic function for clicking on the
	 * control
	 * 
	 * @Information:
	 **/
	public void controlClick(String strLocator, String strObjName) {
		try {
			highLight(BDriver, strLocator);
			getElement(strLocator).click();
			Thread.sleep(1000);
			System.out.println("Clicked on element " + strObjName);
			selectReport.ReportStep("Pass", "Click Control", "Click Control", "Clicked on control " + strObjName);
		} catch (Exception e) {
			System.err.println("Failed to find element " + e.getMessage());
			selectReport.ReportStep("Fail", "Click Control", "Click Control", "Unable to click(element not found) " + strObjName);
		}
	}

	/*
	 * TC_movetoElement Created By GRK
	 */
	public void MoveToElement(String strLocator, String strObjName) {
		Actions a = new Actions(BDriver);
		try {
			a.moveToElement(getElement(strLocator)).build().perform();
			System.out.println("Hover on the Element " + strObjName);
			selectReport.ReportStep("Pass", "Mouse Hover", "Mouse Hover", "Moved to Element" + strObjName);
		} catch (Exception e) {
			System.err.println("Failed to hover on element " + e.getMessage());
		}
	}

	/*
	 * selectValueforAutoSearch Created By GRK Usage: Generaic function for clicking
	 * on the desired value for autosearch dropdown
	 */
	public void selectFromAutosearch(String strLocator, String value) {
		WebDriverWait wait = new WebDriverWait(BDriver, 30);
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(strLocator)));
			List<WebElement> autoresult = BDriver.findElements(By.xpath(strLocator));
			int size = autoresult.size();
			String eleValue = null;
			for (int i = 0; i <= size; i++) {
				eleValue = autoresult.get(i).getText();
				if (eleValue.equalsIgnoreCase(value)) {
					autoresult.get(i).click();
					break;
				}
				System.out.println(eleValue);
				selectReport.ReportStep("Pass", "autosearchlist", "selected a value", value);
			}
		} catch (Exception e) {
			System.err.println("Failed to select the value from autosearchlist" + e.getMessage());
			selectReport.ReportStep("Fail", "autosearchlist", "Not found", value);
		}

	}

	/*
	 * Dropdown Created by GRK Usage: Generic function to dropdown
	 * 
	 * @Information:
	 **/
	@SuppressWarnings("unused")
	public void SelectValueFromDropdown(String drpdown_xp, String strSelectVal) {
		System.out.println(drpdown_xp);
		System.out.println(strSelectVal);
		Select xsSelectafter = null;
		int iVal = 0;
		try {
			if (BDriver.findElement(By.xpath(drpdown_xp)).isDisplayed()) {
				System.out.println("inside");
				xsSelectafter = new Select(BDriver.findElement(By.xpath(drpdown_xp)));
				List<WebElement> selectitemValues = xsSelectafter.getOptions();
				System.out.println("List of value get from the dropdown");
				System.out.println(selectitemValues);
				for (WebElement itemValues : selectitemValues) {
					if (itemValues.getText().contains(strSelectVal)) {
//xsSelectafter.selectByValue(itemValues.getText() );
						xsSelectafter.selectByIndex(iVal);
						break;
					}
					iVal = iVal + 1;
				}
				if (false) {
					System.out.println("Specified Value " + strSelectVal + " is not found in the dropdown");
				}

			}
		} catch (Exception e) {
			System.out.println("No dropdown to select " + strSelectVal + "is available");
		selectReport.ReportStep("Fail", "Dropdown selection", "Dropdown found", drpdown_xp);
		}

	}
	
	/*
	* Dropdownselection Created By GRK Usage: Generaic function for clicking
	* on the desired value for autosearch dropdown
	*/

	public void DropdownSelection(String strObject, String listvalue) {
	try {
	Select dropdown= new Select (getElement(strObject));
	System.out.println(dropdown);
	dropdown.selectByVisibleText(listvalue);
	selectReport.ReportStep("Pass", "DropdownSelection", "selected a value", listvalue);

	} catch(Exception e) {
	System.out.println("No dropdown to select " + listvalue + "is available");
	selectReport.ReportStep("Fail", "DropdownSelection", "Value not matched to list", listvalue);
	}

	}

	/*
	 * getElement Created By GRK Usage: Generaic function for finding element bases
	 * on xpath sent
	 * 
	 * @Information:Capturing element
	 **/
	private WebElement getElement(String strLocator) {
		WebElement element = null;
		if (strLocator.startsWith("//")) {
			element = BDriver.findElement(By.xpath(strLocator));
		}
		if (strLocator.startsWith("id")) {
			strLocator = strLocator.substring(strLocator.indexOf('=') + 1, strLocator.length());
			element = BDriver.findElement(By.id(strLocator));
		}
		if (strLocator.toLowerCase().startsWith("name")) {
			strLocator = strLocator.substring(strLocator.indexOf('=') + 1, strLocator.length());
			element = BDriver.findElement(By.name(strLocator));
		}

		if (strLocator.toLowerCase().startsWith("css")) {
			strLocator = strLocator.substring(strLocator.indexOf('=') + 1, strLocator.length());
			element = BDriver.findElement(By.cssSelector(strLocator));
		}

		if (strLocator.toLowerCase().startsWith("link")) {
			strLocator = strLocator.substring(strLocator.indexOf('=') + 1, strLocator.length());
			element = BDriver.findElement(By.linkText(strLocator));
		}

		return element;

	}

	/*
	 * switchchildBrowser Created By GRK Usage: Validate the Switch to another
	 * Browser
	 * 
	 * @Information will read form Excel sheet
	 */
	public void switchchildBrowser() throws Exception {
		oParentBrw = BDriver.getWindowHandle();
		// Get the All Browsers Info
		Set<String> oAllBrws = BDriver.getWindowHandles();
		for (String oEachBrw : oAllBrws) {
			if (!(oEachBrw.equals(oParentBrw))) {
				BDriver.switchTo().window(oEachBrw);
				Thread.sleep(1000);
				System.out.println(BDriver.switchTo().window(oEachBrw).getTitle());

				// BDriver.close();
			}
		}

	}
	

	/*
	 * Scrolling to element Created By GRK Usage: Generic function for an element to
	 * bring in visible screen
	 */
	public void scrollToEle(String strlocator, String strObjName) {
		JavascriptExecutor js = (JavascriptExecutor) BDriver;
		WebElement element = getElement(strlocator);
		try {
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			System.err.println("Failed to find element " + strObjName + e.getMessage());
		}
	}

	/*
	 * * closeerrorpopup Created By GRK Usage: Entering user name and password from
	 * Excel spread sheet
	 */
	public void closeerrorpopup() throws Exception {
		List<WebElement> we1 = BDriver.findElements(By.xpath("//button[@ng-show='!message.disableCloseButton']"));
		for (int i = 0; i < we1.size(); i++) {
			we1.get(i).click();
			Thread.sleep(500);
		}
	}

	/*
	 * switchToIframe Created By GRK Usage: Checking the ifames and switch to the
	 * iframe
	 */
	public void switchFrame(String strLocator) throws Exception {
		// Fetching iframes count
		int iframes = BDriver.findElements(By.tagName("iframe")).size();
		// Iterating through switching frames o find the required element
		for (int i = 0; i <= iframes; i++) {
			String ftitle = BDriver.switchTo().frame(i).getTitle();
			System.out.println(ftitle);
			BDriver.switchTo().frame(i);
			if (getElement(strLocator).isDisplayed()) {
				System.out.println("Switch to ifame " + "IfameTitle:" + ftitle);
				break;
			} else {
				continue;
			}
		}

	}

	// Highlight
	public void highLight(WebDriver driver, String StrLocator) {
		// Javascriptexecutor to highlight the focused element
		WebElement ele = getElement(StrLocator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: lightyellow; border: 1px solid red;');", ele);

	}

	/*
	 * selectCheckbox Created By GRK Usage: Generic function for selecting checkbox
	 **/
	public void selectchk(String strLocator, String strObjName) {
		try {
			if (!getElement(strLocator).isSelected()) {
				Thread.sleep(1000);
				System.out.println("Clicked on element " + strObjName);
				selectReport.ReportStep("Pass", "Click Control", "Click Control", "Clicked on control " + strObjName);
			}
			highLight(BDriver, strLocator);
			getElement(strLocator).click();
		} catch (Exception e) {
			System.err.println("Failed to find element " + strObjName + e.getMessage());
			selectReport.ReportStep("Fail", "Click Control", "Click Control", "Check box not selected " + strObjName);
		}
	}

	/*
	 * * TC_Login Created By GRK Usage: Getting user name and password from Excel
	 * spread sheet
	 */
	public void LogIn() throws Exception {
		pImplicitWait();
		ExcelRead oExcelLogin = new ExcelRead(sTDFileName, "Login");
		System.out.println("ATTestSC sheet read");
		setText(oUIObj.username_id, oExcelLogin.getCellData("UserName", 1));
		System.out.println("User name entered in username field");
		setText(oUIObj.password_id, oExcelLogin.getCellData("Password", 1));
		System.out.println("Password entered in Password field");
		System.out.println("ATTestSC sheet read");
		controlClick(oUIObj.signin_id, "Sign In");
		System.out.println("clicked Signin button");

	}

	/*
	 * * TC_Logout Created By GRK Usage: Logging out from the site and closing the
	 * driver instance spread sheet
	 */
	public void LogoutClose() throws Exception {
		pImplicitWait();
		controlClick(oUIObj.Logout_xp, "User arrow down");
		controlClick(oUIObj.Signout_xp, "Sign Out");
		System.out.println("clicked Signout button");
		controlClick(oUIObj.Confirm_xp, "Signing Out confirmation");
		System.out.println("Confirmed Signout");
		BDriver.close();
	}

	// Failed Test Case
	public void Validation() throws Exception {
		pImplicitWait();
		ExcelRead oExcelLogin = new ExcelRead(sTDFileName, "Login");
		controlClick(oUIObj.home_id, "Sign In");
		String inUser = oExcelLogin.getCellData("InstanceUser", 1);
		String actUser = getElement(oUIObj.Sudarshan_xp).getText();
		System.out.println("Logged In User Name" + actUser);
		if (actUser.equalsIgnoreCase(inUser)) {
			selectReport.ReportStep("Pass", "Username Validation", "Username Matched", inUser);
			System.out.println("Logged ion user validation passed");
		} else {
			selectReport.ReportStep("Fail", "Username Validation", "Username Not Matched",
					inUser + "Not Matched with logged in User");
			System.out.println("Logged ion user validation Failed");
		}

	}

	// Task bar
	public void Invoiceworkbench() throws Exception {
		pImplicitWait();
		controlClick(oUIObj.home_id, "Sign In");
		controlClick(oUIObj.Payables_id, "Payables");
		controlClick(oUIObj.Invoices_xp, "Invoices");
		controlClick(oUIObj.TaskBar_xp, "Taskbar");

	}

	// Tax Calculation
	public void WithTax(String strLocator, String trgLocator) {
		try {
			String taxedValue = getElement(strLocator).getText();
			getElement(trgLocator).clear();
			getElement(trgLocator).sendKeys(taxedValue);
			selectReport.ReportStep("Pass", "Updation of the taxed Value", "With tax", taxedValue);
		} catch (Exception e) {
			System.err.println("Either element not found" + e.getMessage());
			String taxedValue = getElement(strLocator).getText();
			selectReport.ReportStep("Fail", "Updation of the taxed Value", "With tax", taxedValue);

		}

	}

	// Validation and Approval part
	public void ValidationApproval() {
		pImplicitWait();
		controlClick(oUIObj.Invoiceactions_xp, "Invoice Actions");
		controlClick(oUIObj.Calculatetax_xp, "Calculate Tax");
		WithTax(oUIObj.TaxAmount_xp, oUIObj.Amount_xp);
		ErrorValidation(oUIObj.InvNoResults_xp, "Invoice number already exists");
		controlClick(oUIObj.Invoiceactions_xp, "Invoice Actions");
		controlClick(oUIObj.Validate_xp, "Validate");
		controlClick(oUIObj.Invoiceactions_xp, "Invoice Actions");
		controlClick(oUIObj.Approval_xp, "Approval");
		controlClick(oUIObj.ForceApprove_xp, "Force Approve");
		controlClick(oUIObj.Saveandclose_xp, "Save and close");
	}

	// Creation Invoice
	public void CreateInvoice() throws Exception {
		pImplicitWait();
		waitforpageload();
		ExcelRead oExcelLogin = new ExcelRead(sTDFileName, "Invoice Creation With NonPO");
		System.out.println("ATTestSC sheet read");
		controlClick(oUIObj.create_xp, "Create");
		setText(oUIObj.BU_xp, oExcelLogin.getCellData("Business Unit", 1));
		controlClick(oUIObj.SupplierSearch1_xp, "SupplierSearch");
		controlClick(oUIObj.SupplierAdvanced_xp, "SupplierAdvanced");
		controlClick(oUIObj.Suppliernameadv_xp, "Supplier Name");
		setText(oUIObj.Suppliernameadv_xp, oExcelLogin.getCellData("Supplier", 1));
		SelectValueFromDropdown(oUIObj.Suppliernoadv_xp, "Is not blank");
		SelectValueFromDropdown(oUIObj.Suppliertaxpayerdd_xp, "Is not blank");
		controlClick(oUIObj.Suppsearch_xp, "SupplierSearch");
		ErrorValidation(oUIObj.SuppNoResults_xp,"No Supplier Found");
		selectFromAutosearch(oUIObj.SuppSelect1_xp, oExcelLogin.getCellData("Supplier", 1));
		controlClick(oUIObj.Suppok_xp, "Supplierok");
		setText(oUIObj.Number_xp, oExcelLogin.getCellData("Number", 1));
		setText(oUIObj.Amount_xp, oExcelLogin.getCellData("Amount", 1));
		setText(oUIObj.Requester_xp, oExcelLogin.getCellData("Requester Name", 1));
		BDriver.findElement(By.xpath(oUIObj.Requester_xp)).sendKeys(Keys.ARROW_DOWN);
		controlClick(oUIObj.Lines_xp, "Linestilt");
		setText(oUIObj.Lineamount_xp, oExcelLogin.getCellData("Line Amount", 1));
		controlClick(oUIObj.DistributionCombination_xp, "Click Distribution Combination");
		BDriver.findElement(By.xpath(oUIObj.DistributionCombination_xp)).sendKeys(Keys.TAB);
		controlClick(oUIObj.Linedistributioncomb_xp, "Linedistribution");
		controlClick(oUIObj.Department_xp, "Department");
		Thread.sleep(1000);
		controlClick(oUIObj.Deptdpdn_xp, "Department Dropdown");
		selectFromAutosearch(oUIObj.Acclist_xp, oExcelLogin.getCellData("Department", 1));
		controlClick(oUIObj.Account_xp, "Account");
		Thread.sleep(1000);
		controlClick(oUIObj.Accountdd_xp, "Accountdd");
		selectFromAutosearch(oUIObj.Acclist_xp, oExcelLogin.getCellData("Account", 1));
		Thread.sleep(2000);
		controlClick(oUIObj.Selectok_xp, "Ok");

	}

	// Manage Invoices
	public void ManageInvoice() throws InterruptedException {
		pImplicitWait();
		ExcelRead oExcelLogin = new ExcelRead(sTDFileName, "Invoice Creation With NonPO");
		System.out.println("ATTestSC sheet read");
		controlClick(oUIObj.Manage_xp, "ManageInvoice");
		controlClick(oUIObj.Invoiceno_xp, "InvoiceNumber");
		setText(oUIObj.Invoiceno_xp, oExcelLogin.getCellData("Number", 1));
		controlClick(oUIObj.Invoicedate_xp, "InvoiceDate");
		setText(oUIObj.Invoicedate_xp, oExcelLogin.getCellData("Invoice Date", 1));
		setText(oUIObj.Invoicesupplier_xp, oExcelLogin.getCellData("Supplier", 1));
		BDriver.findElement(By.xpath(oUIObj.Invoicesupplier_xp)).sendKeys(Keys.ARROW_DOWN);
		setText(oUIObj.Invsupplierno_xp, oExcelLogin.getCellData("Supplier Number", 1));
		//controlClick(oUIObj.Invgroup_xp, "Invoicegroup");
		controlClick(oUIObj.Search_xp, "Search");

	}

	// Cancel Invoice
	public void CancelInvoice() throws Exception {
		pImplicitWait();
		controlClick(oUIObj.InvoiceSearch_xp, "Invoice search");
		controlClick(oUIObj.InvoiceEdit_xp, "Invoice Edit");
		controlClick(oUIObj.Invoiceactions1_xp, "Invoice Actions");
		controlClick(oUIObj.CancelInv_xp, "Cancel Invoice line");
		controlClick(oUIObj.CancelInvOk_xp, "Cancel Invoice");
		controlClick(oUIObj.Invoiceactions1_xp, "Invoice Actions");
		controlClick(oUIObj.PL_xp, "Post to Ledger");
		controlClick(oUIObj.viewAccount_xp, "View Accounting");
		controlClick(oUIObj.viewAccountdone_xp, "View Accounting Done");
		//controlClick(oUIObj.Saveandclose_xp, "Save and close");
		
	}

	// Invoice creation - With No PO Matching (Distribution set)
	public void DistributionSet() throws InterruptedException {
		pImplicitWait();
		ExcelRead oExcelLogin = new ExcelRead(sTDFileName, "Invoice with Distribution Set");
		System.out.println("ATTestSC sheet read");
		controlClick(oUIObj.create_xp, "Create");
		setText(oUIObj.BU_xp, oExcelLogin.getCellData("Business Unit", 1));
		controlClick(oUIObj.SupplierSearch1_xp, "SupplierSearch");
		controlClick(oUIObj.SupplierAdvanced_xp, "SupplierAdvanced");
		controlClick(oUIObj.Suppliernameadv_xp, "Supplier Name");
		setText(oUIObj.Suppliernameadv_xp, oExcelLogin.getCellData("Supplier", 1));
		SelectValueFromDropdown(oUIObj.Suppliernoadv_xp, "Is not blank");
		SelectValueFromDropdown(oUIObj.Suppliertaxpayerdd_xp, "Is not blank");
		controlClick(oUIObj.Suppsearch_xp, "SupplierSearch");
		ErrorValidation(oUIObj.SuppNoResults_xp,"No Supplier Found");
		selectFromAutosearch(oUIObj.SuppSelect1_xp, oExcelLogin.getCellData("Supplier", 1));
		controlClick(oUIObj.Suppok_xp, "Supplierok");
		setText(oUIObj.Number_xp, oExcelLogin.getCellData("Number", 1));
		setText(oUIObj.Amount_xp, oExcelLogin.getCellData("Amount", 1));
		setText(oUIObj.Requester_xp, oExcelLogin.getCellData("Requester Name", 1));
		BDriver.findElement(By.xpath(oUIObj.Requester_xp)).sendKeys(Keys.ARROW_DOWN);
		controlClick(oUIObj.Lines_xp, "Linestilt");
		setText(oUIObj.Lineamount_xp, oExcelLogin.getCellData("Line Amount", 1));
		controlClick(oUIObj.Linedistribution1_xp, "DistributionSet");
		controlClick(oUIObj.Linedistributiondd_xp, "DistributionSet");
		controlClick(oUIObj.DistributionSet_xp, "Click DistributionSet Search");
		controlClick(oUIObj.DistributionSetAdv_xp, "Click DistributionSet Advanced");
		controlClick(oUIObj.DistributionSet1_xp, "Click DistributionSet Search");
		setText(oUIObj.DistributionSet1_xp, oExcelLogin.getCellData("Distribution Set", 1));
		controlClick(oUIObj.DistributionSetSearch_xp, "Click DistributionSet Search");
		controlClick(oUIObj.DistributionSet2_xp, "Click DistributionSet Search Select");
		controlClick(oUIObj.DistributionSetOk_xp, "Click DistributionSet Search Ok");
		
	}

	// Delete the Invoice
	public void DeleteInvoice() throws InterruptedException {
		pImplicitWait();
		ExcelRead oExcelLogin = new ExcelRead(sTDFileName, "Delete Invoice");
		System.out.println("ATTestSC sheet read");
		controlClick(oUIObj.create_xp, "Create");
		setText(oUIObj.BU_xp, oExcelLogin.getCellData("Business Unit", 1));
		controlClick(oUIObj.SupplierSearch1_xp, "SupplierSearch");
		controlClick(oUIObj.SupplierAdvanced_xp, "SupplierAdvanced");
		controlClick(oUIObj.Suppliernameadv_xp, "Supplier Name");
		setText(oUIObj.Suppliernameadv_xp, oExcelLogin.getCellData("Supplier", 1));
		SelectValueFromDropdown(oUIObj.Suppliernoadv_xp, "Is not blank");
		SelectValueFromDropdown(oUIObj.Suppliertaxpayerdd_xp, "Is not blank");
		controlClick(oUIObj.Suppsearch_xp, "SupplierSearch");
		ErrorValidation(oUIObj.SuppNoResults_xp,"No Supplier Found");
		selectFromAutosearch(oUIObj.SuppSelect1_xp, oExcelLogin.getCellData("Supplier", 1));
		controlClick(oUIObj.Suppok_xp, "Supplierok");
		setText(oUIObj.Number_xp, oExcelLogin.getCellData("Number", 1));
		setText(oUIObj.Amount_xp, oExcelLogin.getCellData("Amount", 1));
		setText(oUIObj.Requester_xp, oExcelLogin.getCellData("Requester Name", 1));
		BDriver.findElement(By.xpath(oUIObj.Requester_xp)).sendKeys(Keys.ARROW_DOWN);
		controlClick(oUIObj.Lines_xp, "Linestilt");
		setText(oUIObj.Lineamount_xp, oExcelLogin.getCellData("Line Amount", 1));
		controlClick(oUIObj.DistributionCombination_xp, "Click Distribution Combination");
		BDriver.findElement(By.xpath(oUIObj.DistributionCombination_xp)).sendKeys(Keys.TAB);
		controlClick(oUIObj.Linedistributioncomb_xp, "Linedistribution");
		controlClick(oUIObj.Department_xp, "Department");
		Thread.sleep(1000);
		controlClick(oUIObj.Deptdpdn_xp, "Department Dropdown");
		selectFromAutosearch(oUIObj.Acclist_xp, oExcelLogin.getCellData("Department", 1));
		controlClick(oUIObj.Account_xp, "Account");
		Thread.sleep(1000);
		controlClick(oUIObj.Accountdd_xp, "Accountdd");
		selectFromAutosearch(oUIObj.Acclist_xp, oExcelLogin.getCellData("Account", 1));
		Thread.sleep(2000);
		controlClick(oUIObj.Selectok_xp, "Ok");
		controlClick(oUIObj.Save_xp, "Save");
		controlClick(oUIObj.Invoiceactions_xp, "Invoice Actions");
		controlClick(oUIObj.Deleteinvoice_xp, "Delete");
		controlClick(oUIObj.Deleteinvoiceyes_xp, "Click Yes");
	}

	// Invoice Creation with PO(Services)
	public void POinvoiceservices() {
		pImplicitWait();
		ExcelRead oExcelLogin = new ExcelRead(sTDFileName, "Invoice with PO(Services)");
		System.out.println("ATTestSC sheet read");
		controlClick(oUIObj.create_xp, "Create");
		controlClick(oUIObj.PO_xp, "PO number");
		setText(oUIObj.PO_xp, oExcelLogin.getCellData("PO Number", 1));
		setText(oUIObj.Number_xp, oExcelLogin.getCellData("Number", 1));
		setText(oUIObj.Amount_xp, oExcelLogin.getCellData("Amount", 1));
		setText(oUIObj.Requester_xp, oExcelLogin.getCellData("Requester Name", 1));
		BDriver.findElement(By.xpath(oUIObj.Requester_xp)).sendKeys(Keys.ARROW_DOWN);
		controlClick(oUIObj.Goodsline_xp, "Goods Line");
		controlClick(oUIObj.Goodsclick_xp, "Goods Click");
		controlClick(oUIObj.ServicesAmount_xp, "Services Amount");
		setText(oUIObj.ServicesAmount_xp, oExcelLogin.getCellData("Services Amount", 1));
		controlClick(oUIObj.GoodsOk_xp, "Goods ok");

	}

	// Invoice Creation with PO(Goods)
	public void POinvoicegoods() {
		pImplicitWait();
		ExcelRead oExcelLogin = new ExcelRead(sTDFileName, "Invoice with PO(Goods)");
		System.out.println("ATTestSC sheet read");
		controlClick(oUIObj.create_xp, "Create");
		controlClick(oUIObj.PO_xp, "PO number");
		setText(oUIObj.PO_xp, oExcelLogin.getCellData("PO Number", 1));
		setText(oUIObj.Number_xp, oExcelLogin.getCellData("Number", 1));
		setText(oUIObj.Amount_xp, oExcelLogin.getCellData("Amount", 1));
		setText(oUIObj.Requester_xp, oExcelLogin.getCellData("Requester Name", 1));
		BDriver.findElement(By.xpath(oUIObj.Requester_xp)).sendKeys(Keys.ARROW_DOWN);
		controlClick(oUIObj.Goodsline_xp, "Goods Line");
		controlClick(oUIObj.Goodsclick_xp, "Goods Click");
		controlClick(oUIObj.Goodsquantity_xp, "Goods Quantity");
		setText(oUIObj.Goodsquantity_xp, oExcelLogin.getCellData("Quantity", 1));
		controlClick(oUIObj.GoodsUnitPrice_xp, "Goods UP");
		setText(oUIObj.GoodsUnitPrice_xp, oExcelLogin.getCellData("Unit Price", 1));
		controlClick(oUIObj.GoodsOk_xp, "Goods ok");

	}

	// Create Debit Memo
	public void DebitMemo() throws InterruptedException {
		pImplicitWait();
		ExcelRead oExcelLogin = new ExcelRead(sTDFileName, "Invoice Debit and Credit");
		System.out.println("ATTestSC sheet read");
		controlClick(oUIObj.create_xp, "Create");
		setText(oUIObj.BU_xp, oExcelLogin.getCellData("Business Unit", 1));
		controlClick(oUIObj.SupplierSearch1_xp, "SupplierSearch");
		controlClick(oUIObj.SupplierAdvanced_xp, "SupplierAdvanced");
		controlClick(oUIObj.Suppliernameadv_xp, "Supplier Name");
		setText(oUIObj.Suppliernameadv_xp, oExcelLogin.getCellData("Supplier", 1));
		SelectValueFromDropdown(oUIObj.Suppliernoadv_xp, "Is not blank");
		SelectValueFromDropdown(oUIObj.Suppliertaxpayerdd_xp, "Is not blank");
		controlClick(oUIObj.Suppsearch_xp, "SupplierSearch");
		ErrorValidation(oUIObj.SuppNoResults_xp,"No Supplier Found");
		selectFromAutosearch(oUIObj.SuppSelect1_xp, oExcelLogin.getCellData("Supplier", 1));
		controlClick(oUIObj.Suppok_xp, "Supplierok");
		setText(oUIObj.Number_xp, oExcelLogin.getCellData("Number1", 1));
		setText(oUIObj.Amount_xp, oExcelLogin.getCellData("Amount", 1));
		//controlClick(oUIObj.Type_xp, "Type");
		//SelectValueFromDropdown(oUIObj.Type_xp, "Debit Memo");
		controlClick(oUIObj.Debit_xp, "Debit Memo");
		setText(oUIObj.Requester_xp, oExcelLogin.getCellData("Requester Name", 1));
		BDriver.findElement(By.xpath(oUIObj.Requester_xp)).sendKeys(Keys.ARROW_DOWN);
		controlClick(oUIObj.Lines_xp, "Linestilt");
		setText(oUIObj.Lineamount_xp, oExcelLogin.getCellData("Line Amount", 1));
		controlClick(oUIObj.DistributionCombination_xp, "Click Distribution Combination");
		BDriver.findElement(By.xpath(oUIObj.DistributionCombination_xp)).sendKeys(Keys.TAB);
		controlClick(oUIObj.Linedistributioncomb_xp, "Linedistribution");
		controlClick(oUIObj.Department_xp, "Department");
		Thread.sleep(1000);
		controlClick(oUIObj.Deptdpdn_xp, "Department Dropdown");
		selectFromAutosearch(oUIObj.Acclist_xp, oExcelLogin.getCellData("Department", 1));
		controlClick(oUIObj.Account_xp, "Account");
		Thread.sleep(1000);
		controlClick(oUIObj.Accountdd_xp, "Accountdd");
		selectFromAutosearch(oUIObj.Acclist_xp, oExcelLogin.getCellData("Account", 1));
		Thread.sleep(2000);
		controlClick(oUIObj.Selectok_xp, "Ok");

	}

	// Create Credit Memo
	public void CreditMemo() throws InterruptedException {
		pImplicitWait();
		ExcelRead oExcelLogin = new ExcelRead(sTDFileName, "Invoice Debit and Credit");
		System.out.println("ATTestSC sheet read");
		controlClick(oUIObj.create_xp, "Create");
		setText(oUIObj.BU_xp, oExcelLogin.getCellData("Business Unit", 1));
		controlClick(oUIObj.SupplierSearch1_xp, "SupplierSearch");
		controlClick(oUIObj.SupplierAdvanced_xp, "SupplierAdvanced");
		controlClick(oUIObj.Suppliernameadv_xp, "Supplier Name");
		setText(oUIObj.Suppliernameadv_xp, oExcelLogin.getCellData("Supplier", 1));
		SelectValueFromDropdown(oUIObj.Suppliernoadv_xp, "Is not blank");
		SelectValueFromDropdown(oUIObj.Suppliertaxpayerdd_xp, "Is not blank");
		controlClick(oUIObj.Suppsearch_xp, "SupplierSearch");
		ErrorValidation(oUIObj.SuppNoResults_xp,"No Supplier Found");
		selectFromAutosearch(oUIObj.SuppSelect1_xp, oExcelLogin.getCellData("Supplier", 1));
		controlClick(oUIObj.Suppok_xp, "Supplierok");
		setText(oUIObj.Number_xp, oExcelLogin.getCellData("Number2", 1));
		setText(oUIObj.Amount_xp, oExcelLogin.getCellData("Amount", 1));
		//controlClick(oUIObj.Type_xp, "Type");
		//SelectValueFromDropdown(oUIObj.Type_xp, "Credit Memo");
		controlClick(oUIObj.Credit_xp, "Credit Memo");
		setText(oUIObj.Requester_xp, oExcelLogin.getCellData("Requester Name", 1));
		BDriver.findElement(By.xpath(oUIObj.Requester_xp)).sendKeys(Keys.ARROW_DOWN);
		controlClick(oUIObj.Lines_xp, "Linestilt");
		setText(oUIObj.Lineamount_xp, oExcelLogin.getCellData("Line Amount", 1));
		controlClick(oUIObj.DistributionCombination_xp, "Click Distribution Combination");
		BDriver.findElement(By.xpath(oUIObj.DistributionCombination_xp)).sendKeys(Keys.TAB);
		controlClick(oUIObj.Linedistributioncomb_xp, "Linedistribution");
		controlClick(oUIObj.Department_xp, "Department");
		Thread.sleep(1000);
		controlClick(oUIObj.Deptdpdn_xp, "Department Dropdown");
		selectFromAutosearch(oUIObj.Acclist_xp, oExcelLogin.getCellData("Department", 1));
		controlClick(oUIObj.Account_xp, "Account");
		Thread.sleep(1000);
		controlClick(oUIObj.Accountdd_xp, "Accountdd");
		selectFromAutosearch(oUIObj.Acclist_xp, oExcelLogin.getCellData("Account", 1));
		Thread.sleep(2000);
		controlClick(oUIObj.Selectok_xp, "Ok");

	}

	// Releasing Holds - System Holds
	public void ReleasingHolds() throws InterruptedException {
		pImplicitWait();
		ExcelRead oExcelLogin = new ExcelRead(sTDFileName, "Releasing Holds");
		System.out.println("ATTestSC sheet read");
		controlClick(oUIObj.create_xp, "Create");
		setText(oUIObj.BU_xp, oExcelLogin.getCellData("Business Unit", 1));
		controlClick(oUIObj.SupplierSearch1_xp, "SupplierSearch");
		controlClick(oUIObj.SupplierAdvanced_xp, "SupplierAdvanced");
		controlClick(oUIObj.Suppliernameadv_xp, "Supplier Name");
		setText(oUIObj.Suppliernameadv_xp, oExcelLogin.getCellData("Supplier", 1));
		SelectValueFromDropdown(oUIObj.Suppliernoadv_xp, "Is not blank");
		SelectValueFromDropdown(oUIObj.Suppliertaxpayerdd_xp, "Is not blank");
		controlClick(oUIObj.Suppsearch_xp, "SupplierSearch");
		ErrorValidation(oUIObj.SuppNoResults_xp,"No Supplier Found");
		selectFromAutosearch(oUIObj.SuppSelect1_xp, oExcelLogin.getCellData("Supplier", 1));
		controlClick(oUIObj.Suppok_xp, "Supplierok");
		setText(oUIObj.Number_xp, oExcelLogin.getCellData("Number", 1));
		setText(oUIObj.Amount_xp, oExcelLogin.getCellData("Amount", 1));
		setText(oUIObj.Requester_xp, oExcelLogin.getCellData("Requester Name", 1));
		BDriver.findElement(By.xpath(oUIObj.Requester_xp)).sendKeys(Keys.ARROW_DOWN);
		controlClick(oUIObj.Lines_xp, "Linestilt");
		setText(oUIObj.Lineamount_xp, oExcelLogin.getCellData("Line Amount", 1));
		controlClick(oUIObj.DistributionCombination_xp, "Click Distribution Combination");
		BDriver.findElement(By.xpath(oUIObj.DistributionCombination_xp)).sendKeys(Keys.TAB);
		controlClick(oUIObj.Linedistributioncomb_xp, "Linedistribution");
		controlClick(oUIObj.Department_xp, "Department");
		Thread.sleep(1000);
		controlClick(oUIObj.Deptdpdn_xp, "Department Dropdown");
		selectFromAutosearch(oUIObj.Acclist_xp, oExcelLogin.getCellData("Department", 1));
		controlClick(oUIObj.Account_xp, "Account");
		Thread.sleep(1000);
		controlClick(oUIObj.Accountdd_xp, "Accountdd");
		selectFromAutosearch(oUIObj.Acclist_xp, oExcelLogin.getCellData("Account", 1));
		Thread.sleep(2000);
		controlClick(oUIObj.Selectok_xp, "Ok");
		controlClick(oUIObj.Invoiceactions_xp, "Invoice Actions");
		controlClick(oUIObj.Validate_xp, "Validate");
		controlClick(oUIObj.Needsrevalidation_xp, "Needs Revalidation");
		controlClick(oUIObj.SystemHolds_xp, "System Holds");
		controlClick(oUIObj.SystemHoldsSaveandclose_xp, "System Holds");
		controlClick(oUIObj.Invoiceactions_xp, "Invoice Actions");
		controlClick(oUIObj.Calculatetax_xp, "Calculate Tax");
		WithTax(oUIObj.TaxAmount_xp, oUIObj.Amount_xp);
		ErrorValidation(oUIObj.InvNoResults_xp,"Invoice number already exists");
		controlClick(oUIObj.Invoiceactions_xp, "Invoice Actions");
		controlClick(oUIObj.Validate_xp, "Validate");
		controlClick(oUIObj.Invoiceactions_xp, "Invoice Actions");
		controlClick(oUIObj.Approval_xp, "Approval");
		controlClick(oUIObj.ForceApprove_xp, "Force Approve");
		controlClick(oUIObj.Saveandclose_xp, "Save and close");

	}

	// Create FA Invoice without matching PO details
	public void FAInvoice() throws InterruptedException {
		pImplicitWait();
		ExcelRead oExcelLogin = new ExcelRead(sTDFileName, "FA Invoice without PO");
		System.out.println("ATTestSC sheet read");
		controlClick(oUIObj.create_xp, "Create");
		setText(oUIObj.BU_xp, oExcelLogin.getCellData("Business Unit", 1));
		controlClick(oUIObj.SupplierSearch1_xp, "SupplierSearch");
		controlClick(oUIObj.SupplierAdvanced_xp, "SupplierAdvanced");
		controlClick(oUIObj.Suppliernameadv_xp, "Supplier Name");
		setText(oUIObj.Suppliernameadv_xp, oExcelLogin.getCellData("Supplier", 1));
		SelectValueFromDropdown(oUIObj.Suppliernoadv_xp, "Is not blank");
		SelectValueFromDropdown(oUIObj.Suppliertaxpayerdd_xp, "Is not blank");
		controlClick(oUIObj.Suppsearch_xp, "SupplierSearch");
		ErrorValidation(oUIObj.SuppNoResults_xp,"No Supplier Found");
		selectFromAutosearch(oUIObj.SuppSelect1_xp, oExcelLogin.getCellData("Supplier", 1));
		controlClick(oUIObj.Suppok_xp, "Supplierok");
		setText(oUIObj.Number_xp, oExcelLogin.getCellData("Number", 1));
		setText(oUIObj.Amount_xp, oExcelLogin.getCellData("Amount", 1));
		setText(oUIObj.Requester_xp, oExcelLogin.getCellData("Requester Name", 1));
		BDriver.findElement(By.xpath(oUIObj.Requester_xp)).sendKeys(Keys.ARROW_DOWN);
		controlClick(oUIObj.Lines_xp, "Linestilt");
		setText(oUIObj.Lineamount_xp, oExcelLogin.getCellData("Line Amount", 1));
		controlClick(oUIObj.DistributionCombination_xp, "Click Distribution Combination");
		BDriver.findElement(By.xpath(oUIObj.DistributionCombination_xp)).sendKeys(Keys.TAB);
		controlClick(oUIObj.Linedistributioncomb_xp, "Linedistribution");
		controlClick(oUIObj.Department_xp, "Department");
		controlClick(oUIObj.Deptdpdn_xp, "Department Dropdown");
		selectFromAutosearch(oUIObj.Acclist_xp, oExcelLogin.getCellData("Department", 1));
		controlClick(oUIObj.Account_xp, "Account");
		Thread.sleep(1000);
		setText(oUIObj.Account_xp, oExcelLogin.getCellData("Account", 1));
		//controlClick(oUIObj.Accountdd_xp, "Accountdd");
		//selectFromAutosearch(oUIObj.Acclist_xp, oExcelLogin.getCellData("Account", 1));
		Thread.sleep(2000);
		controlClick(oUIObj.Selectok_xp, "Ok");
		JavascriptExecutor js = (JavascriptExecutor) BDriver;
		WebElement check = getElement(oUIObj.Trackasset_xp);
		js.executeScript("arguments[0].scrollIntoView();", check);
		controlClick(oUIObj.Trackasset_xp, "TrackAsset");
		controlClick(oUIObj.Invoiceactions_xp, "Invoice Actions");
		controlClick(oUIObj.Calculatetax_xp, "Calculate Tax");
		WithTax(oUIObj.TaxAmount_xp, oUIObj.Amount_xp);
		//ErrorValidation(oUIObj.InvNoResults_xp, "Invoice number already exists");S
		controlClick(oUIObj.Invoiceactions_xp, "Invoice Actions");
		controlClick(oUIObj.Validate_xp, "Validate");
		controlClick(oUIObj.Invoiceactions_xp, "Invoice Actions");
		controlClick(oUIObj.Approval_xp, "Approval");
		Thread.sleep(1000);
		controlClick(oUIObj.ForceApprove_xp, "Force Approve");
		controlClick(oUIObj.Invoiceactions_xp, "Invoice Actions");
		controlClick(oUIObj.PosttoLedger_xp, "PosttoLedger");
		controlClick(oUIObj.ViewAccounting_xp, "View Accounting");
		controlClick(oUIObj.ViewAccountingDone_xp, "View Accounting Done");
		controlClick(oUIObj.home_id, "Sign In");
		controlClick(oUIObj.Payables_id, "Payables");
		controlClick(oUIObj.Invoices_xp, "Invoices");
		controlClick(oUIObj.TaskBar_xp, "Taskbar");
		controlClick(oUIObj.CreateMassAdditions_xp, "Create Mass Additions");		
		controlClick(oUIObj.AccountingDate_xp, "Accounting date");
		setText(oUIObj.AccountingDate_xp, oExcelLogin.getCellData("Accounting Date", 1));
		controlClick(oUIObj.AssetBook1_xp, "Asset Book");
		DropdownSelection(oUIObj.AssetBook1_xp,"CYTK US CORP BOOK");
		controlClick(oUIObj.Submit_xp, "Submit");
		controlClick(oUIObj.SubmitOk_xp, "Submit Ok");
		controlClick(oUIObj.home_id, "Sign In");
		controlClick(oUIObj.Tools_xp, "Tools");
		controlClick(oUIObj.Scheduleprocess_xp, "Schedule Process");
		controlClick(oUIObj.Scheduleprocess2_xp, "Schedule Process Refresh");
		controlClick(oUIObj.Scheduleprocess2_xp, "Schedule Process Refresh");
		controlClick(oUIObj.Scheduleprocess2_xp, "Schedule Process Refresh");
		Thread.sleep(5000);
		controlClick(oUIObj.Scheduleprocess2_xp, "Schedule Process Refresh");
		controlClick(oUIObj.Scheduleprocess2_xp, "Schedule Process Refresh");
		controlClick(oUIObj.Scheduleprocess2_xp, "Schedule Process Refresh");
		controlClick(oUIObj.Scheduleprocess2_xp, "Schedule Process Refresh");
		controlClick(oUIObj.Scheduleprocess3_xp, "Schedule Process Succeeded");
		controlClick(oUIObj.JobStatus_xp, "Job Status");
		controlClick(oUIObj.home_id, "Sign In");
		controlClick(oUIObj.FixedAssets_xp, "Click Fixed Assets");
		controlClick(oUIObj.Assets_xp, "Click Assets");
		
		
		
	}

	// FA Invoice with matching PO details(2 way matching)
	public void POinvoiceTwoway() throws InterruptedException {
		pImplicitWait();
		ExcelRead oExcelLogin = new ExcelRead(sTDFileName, "FA Invoice with PO(2-way)");
		System.out.println("ATTestSC sheet read");
		controlClick(oUIObj.create_xp, "Create");
		controlClick(oUIObj.PO_xp, "PO number");
		setText(oUIObj.PO_xp, oExcelLogin.getCellData("PO Number", 1));
		setText(oUIObj.Number_xp, oExcelLogin.getCellData("Number", 1));
		setText(oUIObj.Amount_xp, oExcelLogin.getCellData("Amount", 1));
		setText(oUIObj.Requester_xp, oExcelLogin.getCellData("Requester Name", 1));
		BDriver.findElement(By.xpath(oUIObj.Requester_xp)).sendKeys(Keys.ARROW_DOWN);
		controlClick(oUIObj.Goodsline_xp, "Goods Line");
		controlClick(oUIObj.Goodsclick_xp, "Goods Click");
		controlClick(oUIObj.ServicesAmount_xp, "Services Amount");
		setText(oUIObj.ServicesAmount_xp, oExcelLogin.getCellData("Services Amount", 1));
		controlClick(oUIObj.GoodsOk_xp, "Goods ok");
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) BDriver;
		WebElement check = getElement(oUIObj.Trackasset_xp);
		js.executeScript("arguments[0].scrollIntoView();", check);
		controlClick(oUIObj.Trackasset_xp, "TrackAsset");
		controlClick(oUIObj.Save_xp, "Save invoice");
		controlClick(oUIObj.Invoiceactions_xp, "Invoice Actions");
		controlClick(oUIObj.Manageinstallments_xp, "Manage installments");
		controlClick(oUIObj.InstallmentsSave_xp, "Installments Close");
		controlClick(oUIObj.Invoiceactions_xp, "Invoice Actions");
		controlClick(oUIObj.Calculatetax_xp, "Calculate Tax");
		WithTax(oUIObj.TaxAmount_xp, oUIObj.Amount_xp);
		controlClick(oUIObj.Invoiceactions_xp, "Invoice Actions");
		controlClick(oUIObj.Validate_xp, "Validate");
		controlClick(oUIObj.Invoiceactions_xp, "Invoice Actions");
		controlClick(oUIObj.Approval_xp, "Approval");
		controlClick(oUIObj.ForceApprove_xp, "Force Approve");
		controlClick(oUIObj.Invoiceactions_xp, "Invoice Actions");
		controlClick(oUIObj.PosttoLedger_xp, "PosttoLedger");
		controlClick(oUIObj.ViewAccounting_xp, "View Accounting");
		controlClick(oUIObj.ViewAccountingDone_xp, "View Accounting Done");
		controlClick(oUIObj.home_id, "Sign In");
		controlClick(oUIObj.Payables_id, "Payables");
		controlClick(oUIObj.Invoices_xp, "Invoices");
		controlClick(oUIObj.TaskBar_xp, "Taskbar");
		controlClick(oUIObj.CreateMassAdditions_xp, "Create Mass Additions");		
		controlClick(oUIObj.AccountingDate_xp, "Accounting date");
		setText(oUIObj.AccountingDate_xp, oExcelLogin.getCellData("Accounting Date", 1));
		controlClick(oUIObj.AssetBook1_xp, "Asset Book");
		DropdownSelection(oUIObj.AssetBook1_xp,"CYTK US CORP BOOK");
		controlClick(oUIObj.Submit_xp, "Submit");
		controlClick(oUIObj.SubmitOk_xp, "Submit Ok");
		controlClick(oUIObj.home_id, "Sign In");
		controlClick(oUIObj.Tools_xp, "Tools");
		controlClick(oUIObj.Scheduleprocess_xp, "Schedule Process");
		controlClick(oUIObj.Scheduleprocess2_xp, "Schedule Process Refresh");
		controlClick(oUIObj.Scheduleprocess2_xp, "Schedule Process Refresh");
		controlClick(oUIObj.Scheduleprocess2_xp, "Schedule Process Refresh");
		Thread.sleep(5000);
		controlClick(oUIObj.Scheduleprocess2_xp, "Schedule Process Refresh");
		controlClick(oUIObj.Scheduleprocess2_xp, "Schedule Process Refresh");
		controlClick(oUIObj.Scheduleprocess2_xp, "Schedule Process Refresh");
		controlClick(oUIObj.Scheduleprocess2_xp, "Schedule Process Refresh");
		controlClick(oUIObj.Scheduleprocess3_xp, "Schedule Process Succeeded");
		controlClick(oUIObj.JobStatus_xp, "Job Status");
		controlClick(oUIObj.home_id, "Sign In");
		controlClick(oUIObj.FixedAssets_xp, "Click Fixed Assets");
		controlClick(oUIObj.Assets_xp, "Click Assets");
		//controlClick(oUIObj.Saveandclose_xp, "Save and close");
		
	}

	// Reports Navigation
	public void Reports() throws Exception {
		pImplicitWait();
		controlClick(oUIObj.home_id, "Sign In");
		controlClick(oUIObj.Tools_xp, "Tools");
		controlClick(oUIObj.Reports_xp, "Reports and analytics");
		controlClick(oUIObj.Browse_xp, "Browse Catalog");
		switchchildBrowser();
		controlClick(oUIObj.Sharedfolder_xp, "Shared folder");
		controlClick(oUIObj.Expand_xp, "Expand");
		controlClick(oUIObj.Custom_xp, "Custom folder");
		controlClick(oUIObj.Financials_xp, "Financial folder");
		controlClick(oUIObj.Payables_xp, "Payables folder");
		controlClick(oUIObj.ReportsExpand_xp, "Reports Expand");
		controlClick(oUIObj.ReportClick_xp, "Reports Click");
		controlClick(oUIObj.Open_xp, "OpenReport");
		waitforpageload();
		BDriver.switchTo().frame(0);
		controlClick(oUIObj.Apply_xp, "ApplyReport");
		
	}

	// AIM Suppliers Listing Report
	public void Reports2() throws Exception {
		pImplicitWait();
		controlClick(oUIObj.home_id, "Sign In");
		controlClick(oUIObj.Tools_xp, "Tools");
		controlClick(oUIObj.Reports_xp, "Reports and analytics");
		controlClick(oUIObj.Browse_xp, "Browse Catalog");
		switchchildBrowser();
		controlClick(oUIObj.Sharedfolder_xp, "Shared folder");
		controlClick(oUIObj.Expand_xp, "Expand");
		controlClick(oUIObj.Custom_xp, "Custom folder");
		controlClick(oUIObj.Procurement_xp, "Procurement folder");
		controlClick(oUIObj.Procurementexp_xp, "Procurement expand");
		controlClick(oUIObj.ReportClick1_xp, "Reports Click");
		controlClick(oUIObj.Open_xp, "OpenReport");
		
	}

	// AIM AP Invoice Aging Report by Monthly and Weekly Basis Report
	public void Reports3() throws Exception {
		pImplicitWait();
		controlClick(oUIObj.home_id, "Sign In");
		controlClick(oUIObj.Tools_xp, "Tools");
		controlClick(oUIObj.Reports_xp, "Reports and analytics");
		controlClick(oUIObj.Browse_xp, "Browse Catalog");
		switchchildBrowser();
		controlClick(oUIObj.Sharedfolder_xp, "Shared folder");
		controlClick(oUIObj.Expand_xp, "Expand");
		controlClick(oUIObj.Custom_xp, "Custom folder");
		controlClick(oUIObj.Financials_xp, "Financial folder");
		controlClick(oUIObj.Payables_xp, "Payables folder");
		controlClick(oUIObj.ReportsExpand_xp, "Reports Expand");
		controlClick(oUIObj.ReportClick_xp, "Reports Click");
		controlClick(oUIObj.Open_xp, "OpenReport");
		waitforpageload();
		BDriver.switchTo().frame(0);
		controlClick(oUIObj.Apply_xp, "ApplyReport");
	}

	// Payments- Record a quick, full payment
	public void FullPayment() throws InterruptedException {
		pImplicitWait();
		ExcelRead oExcelLogin = new ExcelRead(sTDFileName, "Full Payment");
		System.out.println("ATTestSC sheet read");
		controlClick(oUIObj.create_xp, "Create");
		setText(oUIObj.BU_xp, oExcelLogin.getCellData("Business Unit", 1));
		controlClick(oUIObj.SupplierSearch1_xp, "SupplierSearch");
		controlClick(oUIObj.SupplierAdvanced_xp, "SupplierAdvanced");
		controlClick(oUIObj.Suppliernameadv_xp, "Supplier Name");
		setText(oUIObj.Suppliernameadv_xp, oExcelLogin.getCellData("Supplier", 1));
		SelectValueFromDropdown(oUIObj.Suppliernoadv_xp, "Is not blank");
		SelectValueFromDropdown(oUIObj.Suppliertaxpayerdd_xp, "Is not blank");
		controlClick(oUIObj.Suppsearch_xp, "SupplierSearch");
		ErrorValidation(oUIObj.SuppNoResults_xp,"No Supplier Found");
		selectFromAutosearch(oUIObj.SuppSelect1_xp, oExcelLogin.getCellData("Supplier", 1));
		controlClick(oUIObj.Suppok_xp, "Supplierok");
		setText(oUIObj.Number_xp, oExcelLogin.getCellData("Number", 1));
		setText(oUIObj.Amount_xp, oExcelLogin.getCellData("Amount", 1));
		setText(oUIObj.Requester_xp, oExcelLogin.getCellData("Requester Name", 1));
		BDriver.findElement(By.xpath(oUIObj.Requester_xp)).sendKeys(Keys.ARROW_DOWN);
		controlClick(oUIObj.Lines_xp, "Linestilt");
		setText(oUIObj.Lineamount_xp, oExcelLogin.getCellData("Line Amount", 1));
		controlClick(oUIObj.DistributionCombination_xp, "Click Distribution Combination");
		BDriver.findElement(By.xpath(oUIObj.DistributionCombination_xp)).sendKeys(Keys.TAB);
		controlClick(oUIObj.Linedistributioncomb_xp, "Linedistribution");
		controlClick(oUIObj.Department_xp, "Department");
		controlClick(oUIObj.Deptdpdn_xp, "Department Dropdown");
		selectFromAutosearch(oUIObj.Acclist_xp, oExcelLogin.getCellData("Department", 1));
		controlClick(oUIObj.Account_xp, "Account");
		Thread.sleep(1000);
		controlClick(oUIObj.Accountdd_xp, "Accountdd");
		selectFromAutosearch(oUIObj.Acclist_xp, oExcelLogin.getCellData("Account", 1));
		Thread.sleep(2000);
		controlClick(oUIObj.Selectok_xp, "Ok");
		controlClick(oUIObj.Invoiceactions_xp, "Invoice Actions");
		controlClick(oUIObj.Calculatetax_xp, "Calculate Tax");
		WithTax(oUIObj.TaxAmount_xp, oUIObj.Amount_xp);
		controlClick(oUIObj.Invoiceactions_xp, "Invoice Actions");
		controlClick(oUIObj.Validate_xp, "Validate");
		controlClick(oUIObj.Invoiceactions_xp, "Invoice Actions");
		controlClick(oUIObj.Approval_xp, "Approval");
		controlClick(oUIObj.ForceApprove_xp, "Force Approve");
		controlClick(oUIObj.Invoiceactions_xp, "Invoice Actions");
		controlClick(oUIObj.PayFull_xp, "Pay in Full");
		controlClick(oUIObj.PPR_xp, "PPR");
		controlClick(oUIObj.PPRDD_xp, "PPR Select");
		controlClick(oUIObj.PPRSearch_xp, "PPR Search");
		controlClick(oUIObj.PPRname_xp, "PPR name");
		setText(oUIObj.PPRname_xp, oExcelLogin.getCellData("Payment Process", 1));
		controlClick(oUIObj.PPRnameSearch_xp, "PPR name search");
		controlClick(oUIObj.PPRnameSelect_xp, "PPR name select");
		controlClick(oUIObj.PPRNameok_xp, "PPR name ok");
		controlClick(oUIObj.PPRSubmit_xp, "Submit");
		controlClick(oUIObj.PPRSubmitOk_xp, "Submit");
		controlClick(oUIObj.Saveandclose_xp, "Save and close");
		
	}

	// Void a Payment
	public void VoidPayment() throws InterruptedException {
		pImplicitWait();
		ExcelRead oExcelLogin = new ExcelRead(sTDFileName, "ManagePayment");
		System.out.println("ATTestSC sheet read");
		controlClick(oUIObj.home_id, "Sign In");
		controlClick(oUIObj.Payables_id, "Payables");
		controlClick(oUIObj.Invoices_xp, "Invoices");
		controlClick(oUIObj.TaskBar_xp, "Taskbar");
		controlClick(oUIObj.Manage_xp, "ManageInvoice");
		controlClick(oUIObj.Invoiceno_xp, "InvoiceNumber");
		setText(oUIObj.Invoiceno_xp, oExcelLogin.getCellData("Number", 1));
		controlClick(oUIObj.Search_xp, "Search");
		controlClick(oUIObj.InvoiceSearch_xp, "Invoice search");
		controlClick(oUIObj.InvoiceSelect_xp, "Invoice select");
		controlClick(oUIObj.PaymentsCol_xp, "Payments");
		controlClick(oUIObj.PaymentLine_xp, "Payment Line");
		String paymentnumber = getElement(oUIObj.Paymentnumber_xp).getText();
		System.out.println("Payment number"+paymentnumber);
		controlClick(oUIObj.home_id, "Sign In");
		controlClick(oUIObj.Payables_id, "Payables");
		controlClick(oUIObj.Payments_xp, "Payments");
		controlClick(oUIObj.PaymentTaskbar_xp, "Payments Task Bar");
		controlClick(oUIObj.ManagePayment_xp, "Manage Payment");
		controlClick(oUIObj.ManagePaymentNumber_xp, "Payment Number");
		getElement(oUIObj.ManagePaymentNumber_xp).sendKeys(paymentnumber);
		controlClick(oUIObj.SearchPayment_xp, "Search Payment");
		controlClick(oUIObj.PaymentNumSelect_xp, "Payment Number Select");
		controlClick(oUIObj.PaymentNumActions_xp, "Payment Number Actions");
		controlClick(oUIObj.PaymentVoid_xp, "Void Payment");
		controlClick(oUIObj.SubmitVoid_xp, "Submit Void Payment");
		controlClick(oUIObj.VoidDone_xp, "Void Done");

	}

	// 1099 Report
	public void USReport() throws Exception {
		pImplicitWait();
		ExcelRead oExcelLogin = new ExcelRead(sTDFileName, "1099 Report");
		System.out.println("ATTestSC sheet read");
		controlClick(oUIObj.home_id, "Sign In");
		controlClick(oUIObj.Tools_xp, "Tools");
		controlClick(oUIObj.Scheduleprocess_xp, "Schedule Process");
		controlClick(oUIObj.Schedulenewprocess_xp, "Schedule New Process");
		controlClick(oUIObj.ScheduleName_xp, "Schedule Name");
		controlClick(oUIObj.Scheduledd_xp, "Schedule Dropdown");
		controlClick(oUIObj.Schedulesearch_xp, "Schedule search");
		controlClick(oUIObj.ScheduleName1_xp, "Schedule Name1");
		setText(oUIObj.ScheduleName1_xp, "US 1099 Report");
		controlClick(oUIObj.Schedulesearch1_xp, "Schedule Search");
		controlClick(oUIObj.Scheduleselect_xp, "Schedule Select");
		controlClick(oUIObj.ScheduleOk_xp, "Schedule Ok");
		controlClick(oUIObj.ScheduleOk1_xp, "Schedule Ok1");
		controlClick(oUIObj.Businessunit_xp, "Business Unit");
		setText(oUIObj.Businessunit_xp, oExcelLogin.getCellData("Business Unit", 1));
		controlClick(oUIObj.Fromaccounting1_xp, "From Accounting Date");
		setText(oUIObj.Fromaccounting1_xp, oExcelLogin.getCellData("From Accounting Date", 1));
		controlClick(oUIObj.Toaccounting_xp, "To Accounting Date");
		setText(oUIObj.Toaccounting_xp, oExcelLogin.getCellData("To Accounting Date", 1));
		controlClick(oUIObj.Taxreporting1_xp, "Tax Reporting");
		setText(oUIObj.Taxreporting1_xp, oExcelLogin.getCellData("Tax Reporting Entity", 1));
		controlClick(oUIObj.Schedulesubmit_xp, "Schedule Submit");
		controlClick(oUIObj.Scheduleprocess1_xp, "Schedule Ok");
		controlClick(oUIObj.Scheduleprocess2_xp, "Schedule Process Refresh");
		controlClick(oUIObj.Scheduleprocess2_xp, "Schedule Process Refresh");
		controlClick(oUIObj.Scheduleprocess2_xp, "Schedule Process Refresh");
		Thread.sleep(5000);
		controlClick(oUIObj.Scheduleprocess2_xp, "Schedule Process Refresh");
		controlClick(oUIObj.Scheduleprocess2_xp, "Schedule Process Refresh");
		controlClick(oUIObj.Scheduleprocess2_xp, "Schedule Process Refresh");
		controlClick(oUIObj.Scheduleprocess3_xp, "Schedule Process Succeeded");
		controlClick(oUIObj.JobStatus_xp, "Job Status");
		scrollToEle(oUIObj.ClickParameters_xp,"Expand Parameters");
		
		//BDriver.switchTo().frame(oUIObj.Scheduleprocess4iframe_xp);
	    //switchFrame(oUIObj.Scheduleprocess4iframe1_xp);
        //System.out.println("switched to parent frame");
        //BDriver.switchTo().frame(oUIObj.Scheduleprocess4iframe_xp);
        //System.out.println("Switched to target frame");
		//controlClick(oUIObj.Scheduleprocess4_xp, "Republish Appeared");
		
		
//		switchFrame(oUIObj.Scheduleprocess4_xp);
//		System.out.println("Switched to iFrame");
//		controlClick(oUIObj.Scheduleprocess4_xp,"Republish appeared");
//		switchchildBrowser();
//		controlClick(oUIObj.Scheduleprocess5_xp, "Schedule Process Actions");
//		controlClick(oUIObj.Scheduleprocess6_xp, "Schedule Process Export");
//		controlClick(oUIObj.Scheduleprocess7_xp, "Schedule Process Download");
		
		/*controlClick(oUIObj.ClickOutput_xp, "Click Output");
		controlClick(oUIObj.ScheduleprocessRepublish_xp, "Republish");
		BDriver.findElement(By.xpath(oUIObj.ClickOutput_xp)).sendKeys(Keys.TAB);
		BDriver.findElement(By.xpath(oUIObj.ClickDownloadIcon_xp)).sendKeys(Keys.TAB);
		controlClick(oUIObj.Scheduleprocess4_xp,"Republish appeared");*/

	}

	// Manual Debit/Credit Memo with PO matching
	public void ManualMemo() throws Exception {
		pImplicitWait();
		ExcelRead oExcelLogin = new ExcelRead(sTDFileName, "Manual DC Memo with PO");
		System.out.println("ATTestSC sheet read");
		controlClick(oUIObj.create_xp, "Create");
		controlClick(oUIObj.PO_xp, "PO number");
		setText(oUIObj.PO_xp, oExcelLogin.getCellData("PO Number", 1));
		setText(oUIObj.Number_xp, oExcelLogin.getCellData("Number", 1));
		setText(oUIObj.Amount_xp, oExcelLogin.getCellData("Amount", 1));
		// controlClick(oUIObj.Type_xp, "Type");
		// SelectValueFromDropdown(oUIObj.Type_xp, "Debit Memo");
		controlClick(oUIObj.Debit_xp, "Debit Memo");
		setText(oUIObj.Requester_xp, oExcelLogin.getCellData("Requester Name", 1));
		BDriver.findElement(By.xpath(oUIObj.Requester_xp)).sendKeys(Keys.ARROW_DOWN);
		controlClick(oUIObj.Goodsline_xp, "Goods Line");
		controlClick(oUIObj.Goodsclick_xp, "Goods Click");
		controlClick(oUIObj.ServicesAmount_xp, "Services Amount");
		setText(oUIObj.ServicesAmount_xp, oExcelLogin.getCellData("Services Amount", 1));
		controlClick(oUIObj.GoodsOk_xp, "Goods ok");
		controlClick(oUIObj.Invoiceactions_xp, "Invoice Actions");
		controlClick(oUIObj.Calculatetax_xp, "Calculate Tax");
		WithTax(oUIObj.TaxAmount_xp, oUIObj.Amount_xp);
		// ErrorValidation(oUIObj.InvNoResults_xp, "Invoice number already exists");
		controlClick(oUIObj.Invoiceactions_xp, "Invoice Actions");
		controlClick(oUIObj.Validate_xp, "Validate");
		controlClick(oUIObj.Invoiceactions_xp, "Invoice Actions");
		controlClick(oUIObj.Approval_xp, "Approval");
		controlClick(oUIObj.ForceApprove_xp, "Force Approve");
		controlClick(oUIObj.Invoiceactions_xp, "Invoice Actions");
		controlClick(oUIObj.PosttoLedger_xp, "Post To Ledger");

	}

	// Invoice with Supplier 1099
	public void Invoicewith1099() throws Exception {
		pImplicitWait();
		ExcelRead oExcelLogin = new ExcelRead(sTDFileName, "Invoice with 1099 Supplier");
		System.out.println("ATTestSC sheet read");
		controlClick(oUIObj.create_xp, "Create");
		setText(oUIObj.BU_xp, oExcelLogin.getCellData("Business Unit", 1));
		controlClick(oUIObj.SupplierSearch1_xp, "SupplierSearch");
		controlClick(oUIObj.SupplierAdvanced_xp, "SupplierAdvanced");
		controlClick(oUIObj.Suppliernameadv_xp, "Supplier Name");
		setText(oUIObj.Suppliernameadv_xp, oExcelLogin.getCellData("Supplier", 1));
		SelectValueFromDropdown(oUIObj.Suppliernoadv_xp, "Is not blank");
		SelectValueFromDropdown(oUIObj.Suppliertaxpayerdd_xp, "Is not blank");
		controlClick(oUIObj.Suppsearch_xp, "SupplierSearch");
		ErrorValidation(oUIObj.SuppNoResults_xp, "No Supplier Found");
		selectFromAutosearch(oUIObj.SuppSelect1_xp, oExcelLogin.getCellData("Supplier", 1));
		controlClick(oUIObj.Suppok_xp, "Supplierok");
		setText(oUIObj.Number_xp, oExcelLogin.getCellData("Number", 1));
		setText(oUIObj.Amount_xp, oExcelLogin.getCellData("Amount", 1));
		setText(oUIObj.Requester_xp, oExcelLogin.getCellData("Requester Name", 1));
		BDriver.findElement(By.xpath(oUIObj.Requester_xp)).sendKeys(Keys.ARROW_DOWN);
		controlClick(oUIObj.Lines_xp, "Linestilt");
		setText(oUIObj.Lineamount_xp, oExcelLogin.getCellData("Line Amount", 1));
		controlClick(oUIObj.DistributionCombination_xp, "Click Distribution Combination");
		BDriver.findElement(By.xpath(oUIObj.DistributionCombination_xp)).sendKeys(Keys.TAB);
		controlClick(oUIObj.Linedistributioncomb_xp, "Linedistribution");
		controlClick(oUIObj.Department_xp, "Department");
		controlClick(oUIObj.Deptdpdn_xp, "Department Dropdown");
		selectFromAutosearch(oUIObj.Acclist_xp, oExcelLogin.getCellData("Department", 1));
		controlClick(oUIObj.Account_xp, "Account");
		Thread.sleep(1000);
		controlClick(oUIObj.Accountdd_xp, "Accountdd");
		selectFromAutosearch(oUIObj.Acclist_xp, oExcelLogin.getCellData("Account", 1));
		Thread.sleep(2000);
		controlClick(oUIObj.Selectok_xp, "Ok");

	}

	// Multi Period Accounting Invoice
	public void MultiPeriodAccounting() throws Exception {
		pImplicitWait();
		ExcelRead oExcelLogin = new ExcelRead(sTDFileName, "Multi Period Accounting inv");
		System.out.println("ATTestSC sheet read");
		controlClick(oUIObj.create_xp, "Create");
		setText(oUIObj.BU_xp, oExcelLogin.getCellData("Business Unit", 1));
		controlClick(oUIObj.SupplierSearch1_xp, "SupplierSearch");
		controlClick(oUIObj.SupplierAdvanced_xp, "SupplierAdvanced");
		controlClick(oUIObj.Suppliernameadv_xp, "Supplier Name");
		setText(oUIObj.Suppliernameadv_xp, oExcelLogin.getCellData("Supplier", 1));
		SelectValueFromDropdown(oUIObj.Suppliernoadv_xp, "Is not blank");
		SelectValueFromDropdown(oUIObj.Suppliertaxpayerdd_xp, "Is not blank");
		controlClick(oUIObj.Suppsearch_xp, "SupplierSearch");
		ErrorValidation(oUIObj.SuppNoResults_xp, "No Supplier Found");
		selectFromAutosearch(oUIObj.SuppSelect1_xp, oExcelLogin.getCellData("Supplier", 1));
		controlClick(oUIObj.Suppok_xp, "Supplierok");
		setText(oUIObj.Number_xp, oExcelLogin.getCellData("Number", 1));
		setText(oUIObj.Amount_xp, oExcelLogin.getCellData("Amount", 1));
		setText(oUIObj.Requester_xp, oExcelLogin.getCellData("Requester Name", 1));
		BDriver.findElement(By.xpath(oUIObj.Requester_xp)).sendKeys(Keys.ARROW_DOWN);
		controlClick(oUIObj.Lines_xp, "Linestilt");
		setText(oUIObj.Lineamount_xp, oExcelLogin.getCellData("Line Amount", 1));
		controlClick(oUIObj.DistributionCombination_xp, "Click Distribution Combination");
		BDriver.findElement(By.xpath(oUIObj.DistributionCombination_xp)).sendKeys(Keys.TAB);
		controlClick(oUIObj.Linedistributioncomb_xp, "Linedistribution");
		controlClick(oUIObj.Department_xp, "Department");
		Thread.sleep(1000);
		controlClick(oUIObj.Deptdpdn_xp, "Department Dropdown");
		selectFromAutosearch(oUIObj.Acclist_xp, oExcelLogin.getCellData("Department", 1));
		controlClick(oUIObj.Account_xp, "Account");
		Thread.sleep(1000);
		controlClick(oUIObj.Accountdd_xp, "Accountdd");
		selectFromAutosearch(oUIObj.Acclist_xp, oExcelLogin.getCellData("Account", 1));
		Thread.sleep(2000);
		controlClick(oUIObj.Selectok_xp, "Ok");
		controlClick(oUIObj.MultiperiodAccounting_xp, "Click Multiperiod Accounting Invoice");
		controlClick(oUIObj.AccrualStartDate_xp, "Click Start Date");
		setText(oUIObj.AccrualStartDate_xp, oExcelLogin.getCellData("Start Date", 1));
		//controlClick(oUIObj.AccrualEndDate_xp, "Click End Date");
		BDriver.findElement(By.xpath(oUIObj.AccrualEndDate_xp)).sendKeys(Keys.ARROW_DOWN);
		setText(oUIObj.AccrualEndDate_xp, oExcelLogin.getCellData("End Date", 1));
		controlClick(oUIObj.AccrualAccount_xp, "Click Accrual Account Set");
		controlClick(oUIObj.AccrualDepartment_xp, "Department");
		Thread.sleep(1000);
		controlClick(oUIObj.AccrualDepartmentDD_xp, "Department Dropdown");
		selectFromAutosearch(oUIObj.Acclist_xp, oExcelLogin.getCellData("Department", 1));
		controlClick(oUIObj.AccrualAccount1_xp, "Account");
		Thread.sleep(1000);
		controlClick(oUIObj.AccrualAccountDD_xp, "Accountdd");
		selectFromAutosearch(oUIObj.Acclist_xp, oExcelLogin.getCellData("Account", 1));
		Thread.sleep(2000);
		controlClick(oUIObj.AccrualOk_xp, "Ok");

	}

	// Supplier Creation 1099
	public void SupplierCreation1099() throws Exception {
		pImplicitWait();
		ExcelRead oExcelLogin = new ExcelRead(sTDFileName, "Supplier Creation 1099");
		System.out.println("ATTestSC sheet read");
		controlClick(oUIObj.home_id, "Sign In");
		controlClick(oUIObj.Procurement_id, "Click Procurement Icon");
		controlClick(oUIObj.SuppliersIcon_xp, "Click Suppliers Icon");
		controlClick(oUIObj.SuppliersTaskbar_xp, "Click Suppliers Taskbar");
//			controlClick(oUIObj.CreateSupplier_xp, "Click Create Supplier");
//			controlClick(oUIObj.SupplierName_xp, "Supplier Name");
//			setText(oUIObj.SupplierName_xp, oExcelLogin.getCellData("Supplier", 1));
//			controlClick(oUIObj.TaxOrganization_xp, "Tax Organization Type");
//			controlClick(oUIObj.TaxOrganizationType_xp, "Tax Organization Type");
//			controlClick(oUIObj.Create_xp, "Create");
//			waitforpageload();
		controlClick(oUIObj.ManageSupp_xp, "Click Manage Supplier");
		controlClick(oUIObj.Keywords_xp, "ClickKeywords");
		setText(oUIObj.Keywords_xp, oExcelLogin.getCellData("Keywords", 1));
		controlClick(oUIObj.SearchKeywords_xp, "Search Keywords");
		scrollToEle(oUIObj.SelectSupplier_xp, "Supplier Click");

		controlClick(oUIObj.SelectSupplier1_xp, "Select Supplier");
		controlClick(oUIObj.SupplierEdit_xp, "Supplier Edit");
		controlClick(oUIObj.IncomeTax_xp, "Click on Income Tax");

		controlClick(oUIObj.TaxPayerCountrydd_xp, "Tax Payer Country");
		controlClick(oUIObj.TaxPayerCountrySearch_xp, "Tax Payer Country Search");
		controlClick(oUIObj.TaxPayerCountryAdvanced_xp, "Tax Payer Country Advanced");
		controlClick(oUIObj.TaxPayerCountryName_xp, "Tax Payer Country Name");
		setText(oUIObj.TaxPayerCountryName_xp, oExcelLogin.getCellData("Tax Payer Country", 1));
		controlClick(oUIObj.TaxPayerSearch_xp, "Tax Payer Country Advanced Search");
		controlClick(oUIObj.TaxPayerSelect_xp, "Tax Payer Country Advanced Select");
		controlClick(oUIObj.TaxPayerSearchOk_xp, "Tax Payer Country Advanced Select Ok");
		controlClick(oUIObj.TaxPayerId_xp, "Tax Payer Id");
		setText(oUIObj.TaxPayerId_xp, oExcelLogin.getCellData("Tax Payer Id", 1));
		selectchk(oUIObj.FederalReportable_xp, "Selected");
		controlClick(oUIObj.FederalIncomeTaxDD_xp, "Click Checkbox Federal Incometax");
		setText(oUIObj.FederalIncomeTaxDD_xp, oExcelLogin.getCellData("Income Tax Type", 1));
		controlClick(oUIObj.Payments1_xp, "Click Payments Tab");
		controlClick(oUIObj.PaymentsMethods_xp, "Click Payments Methods");
		scrollToEle(oUIObj.PaymentType_xp, "Supplier Type");
		controlClick(oUIObj.PaymentType_xp, "Click Payments Type");
		controlClick(oUIObj.SelectPaymentLine_xp, "Select Payment Line");
		controlClick(oUIObj.SelectEnable_xp, "Select Enable");
		controlClick(oUIObj.BankAccounts_xp, "Click on Bank Accounts");
		controlClick(oUIObj.AddBankAccount_xp, "Click on Add Bank Account");

	}


	/*
	 * * TC_LogOut Created By GRK Usage: Getting user name and password from Excel
	 * spread sheet
	 * 
	 * @Information will save into database
	 */
	public void LogOut() throws Exception {
		pImplicitWait();
		controlClick(oUIObj.Logout_xp, "Logout");
		controlClick(oUIObj.Signout_xp, "Signout");
		controlClick(oUIObj.Confirm_xp, "Confirm");

	}

}