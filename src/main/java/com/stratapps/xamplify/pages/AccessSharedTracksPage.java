
package com.stratapps.xamplify.pages;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stratapps.xamplify.utils.ActionUtil;
import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.ScreenshotUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class AccessSharedTracksPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public AccessSharedTracksPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	private By contentMenu = By.xpath("//span[normalize-space()='Content']");
	private By sharedTracksOption = By.xpath("//span[normalize-space()='Access Shared Tracks']");
	private By refreshIcon = By.xpath("//i[@class='fa fa-refresh']");
	private By sortDropdown = By.xpath("//div/div[2]/div[1]/select");
	private By TrackSearchInput = By.xpath("//input[@placeholder='search...']");
	private By searchIcon = By.xpath("//i[@class='fa fa-search']");

	

	// View locators
	private final By hoverOnListView = By.xpath("//button[contains(@class,'fa fa-th-list btn btn-xs l-g-view mr')]");
	private final By hoverOnGridView = By.xpath("//button[contains(@class,'fa fa-th-large btn btn-xs l-g-view mr')]");
	private final By hoverOnFGV = By.xpath("(//button[contains(@class,'fa fa-folder btn-xs l-g-view')])");
	private final By hoverOnFLV = By.xpath("(//button[contains(@class,'fa fa-th btn-xs l-g-view')])");
	private final By hoverOnTrackGV = By.xpath("(//div[@class='aligntowbtns'])[1]");
	private final By clickOnTrackPreview = By.xpath("(//a[contains(@class,'custom-icon')])[1]");
	private final By clickOnTrackPreview1 = By.xpath("(//a[contains(@class,'custom-icon')])[2]");
	private final By clickOnGridView = By.xpath("//i[contains(@class,'fa fa-th-large p')]");
	private final By clickOnListView = By.xpath("//i[contains(@class,'fa fa-th-list p')]");
	private final By clickOnFolderGridView = By.xpath("//i[contains(@class,'fa fa-folder p')]");
	private final By hoverOnTrackFGV = By.xpath("(//div[contains(@class,'bg-folder')])[1]");
	private final By clickOnFolderTrackPreviewFGV = By.xpath("(//i[contains(@class,'fa fa-eye')])[1]");
	private final By clickOnFVUpArrow = By.xpath("(//i[contains(@class,'fa fa-arrow-up p')])");
	private final By clickOnFolderListView = By.xpath("(//i[contains(@class,'fa fa-th p')])");
	private final By clickOnSearchDropdownFLV = By
			.xpath("(//div[@class='inputs float-right custom-flex']//div[2]//select[1])");
	private final By clickOnSearchTrackFLV = By.xpath("(//input[@id='sort-text'])");
	private final By clickOnSearchIconTrackFLV = By.xpath("((//i[contains(@class,'fa fa-search')])[2])");
	private final By clickOnTrackDelete = By.xpath("(//i[contains(@class,'fa fa-trash')])[1]");
	private final By clickOnYesDelete = By.xpath("(//button[contains(text(),'Yes, Delete')])");
	private final By backdrop = By.id("backdrop");
	private By previewclose = By.xpath("//span[@class='glyphicon glyphicon-remove asset_cross_align']");
	private By folderUpArrow = By.xpath("//button[@title='Up']");
	private By analyticsButton = By.xpath("//*[@id=\"manage-Tracks-table\"]/tbody/tr[1]/td[5]/div/div/a[1]/i");
	private By analyticsclose = By.xpath("//a[@class='close-circle ml5']//i[@class='fa fa-times']");
	private By previewTrack = By.xpath("//*[@id=\"actions-row\"]/div/a/i[1]");
	private By viewTrack = By.xpath("//span[normalize-space()='View']");
	private By downloadTrack = By.xpath("//span[normalize-space()='Download']");
	private By ViewTrackclose = By.xpath("//a[@title='Close']//i[@class='fa fa-times']");
	private By interactedTile = By.xpath("//i[contains(@title,'Total interacted Tracks')]");
	private By nonInteractedTile = By.xpath("//i[@title='Total non interacted Tracks ']");
	private By Gotohome = By.xpath("//img[@class='cls-pointer']");
	private By disabledText = By.xpath("//div[contains(text(),'The Track expired')]");
    private By breadcrumbSharedTracks = By.xpath("//a[contains(text(),'Shared Tracks')]");
    private By firstAssetRow = By.xpath("(//table[@id='manage-assets-table']//tr[1])[2]");
    private By submitform = By.xpath("(//button[normalize-space()='Submit'])[1]");
    
    private By formMandatoryfields = By.xpath("//*[@id=\"form-div\"]/div/label/span[2]/span");
	/** Navigate to Upload Track Page */
	public void accesssharedTrackSection() {
		
	
		WaitUtil.waitForElementVisible(driver, contentMenu, 90);
		ElementUtil.hoverAndClick(driver.findElement(contentMenu), driver);
		WaitUtil.waitAndClick(driver, sharedTracksOption, 90);
		WaitUtil.waitForPageToLoad(driver, 30);
	}
	
	public void refreshTracksPage() {
		try {
			WebElement refresh = WaitUtil.waitForElementPresent(driver, refreshIcon, 5);
			if (refresh != null) {
				ElementUtil.click(refreshIcon, driver);
				System.out.println("🔄 Refresh icon found and clicked successfully.");
			} else {
				System.out.println("⏭️ Refresh icon not present. Skipping refresh step.");
			}
		} catch (Exception e) {
			System.out.println("⚠️ Could not click Refresh icon (safe skip). Cause: " + e.getMessage());
		}
		WaitUtil.waitForPageToLoad(driver, 60);
	}

	public void sortTracks(String sortOption) {
		WaitUtil.waitForElementVisible(driver, sortDropdown, 30);
		ElementUtil.selectDropdownByVisibleText(sortDropdown, sortOption, driver);
	}

	public void searchTrack(String keyword) {
		WaitUtil.waitForElementVisible(driver, TrackSearchInput, 30);
		ElementUtil.sendText(TrackSearchInput, keyword, driver);
		ElementUtil.click(searchIcon, driver);
	}
	
	
	public void viewTrackDetails() {
		try {
			WaitUtil.waitForPageToLoad(driver, 30);
			WaitUtil.waitAndClick(driver, clickOnTrackPreview, backdrop, 30);
			WaitUtil.waitAndClick(driver, previewclose, backdrop, 30);
		} catch (Exception e) {
			throw new RuntimeException("View Track Details flow failed", e);
		}
	}
	
	
	public void viewActions() {
		try {
			WaitUtil.waitForPageToLoad(driver, 30);

			// ---- Step 1: Switch to Grid View ----
			WaitUtil.waitAndClick(driver, hoverOnListView, backdrop, 30);
			WaitUtil.waitAndClick(driver, clickOnGridView, backdrop, 30);

			// ---- Step 2: Folder Grid View ----
			WaitUtil.waitAndClick(driver, hoverOnGridView, backdrop, 30);
			WaitUtil.waitAndClick(driver, clickOnFolderGridView, backdrop, 30);
			WaitUtil.waitAndClick(driver, hoverOnTrackFGV, backdrop, 30);
			WaitUtil.waitAndClick(driver, clickOnFolderTrackPreviewFGV, backdrop, 30);

			// ---- Step 3: Navigate Up ----
			WaitUtil.waitAndClick(driver, clickOnFVUpArrow, backdrop, 30);
			WaitUtil.waitAndClick(driver, hoverOnFGV, backdrop, 30);

			// ---- Step 4: Folder List View ----
			WaitUtil.waitAndClick(driver, clickOnFolderListView, backdrop, 30);
			WaitUtil.waitAndClick(driver, clickOnSearchDropdownFLV, backdrop, 30);
			ElementUtil.selectDropdownByVisibleText(clickOnSearchDropdownFLV, "Search In Folder", driver);

			WaitUtil.waitAndSendKeys(driver, clickOnSearchTrackFLV, "jpg", 20);
			WaitUtil.waitAndClick(driver, clickOnSearchIconTrackFLV, backdrop, 30);

			// ---- Step 5: Back to List View ----
			WaitUtil.waitAndClick(driver, clickOnFVUpArrow, backdrop, 30);
			WaitUtil.waitAndClick(driver, hoverOnFLV, backdrop, 30);
			WaitUtil.waitAndClick(driver, clickOnListView, backdrop, 30);

		} catch (Exception e) {
			throw new RuntimeException("View Actions flow failed", e);
		}
	}
	
	public void viewTrackAndClickAssets() throws InterruptedException {

	    try {

	        // 1️⃣ Click the View Track button
	        WaitUtil.waitAndClick(driver, clickOnTrackPreview, backdrop, 30);
	        WaitUtil.waitForPageToLoad(driver, 90);

	        // 2️⃣ If Track is Expired
	        WaitUtil.waitForElementVisible(driver, breadcrumbSharedTracks, 30);
	        ElementUtil.click(breadcrumbSharedTracks, driver);
	        System.out.println("⚠️ Track is expired. Returned to Home Page.");

	    }
	           
	                 catch (Exception e) {
	                    System.out.println("Breadcrumb click attempt failed: " + e.getMessage());

	        
	        
	    }
        WaitUtil.waitForPageToLoad(driver, 90);
Thread.sleep(2000);
	            WaitUtil.waitForElementClickable(driver, clickOnTrackPreview1, 30);
	            ElementUtil.clickWithRetry(clickOnTrackPreview1, driver, 3);
	        
	    

	        WaitUtil.waitForPageToLoad(driver, 30);

	        // 3️⃣ Click all assets + quizzes
	        By assetAndQuizElements = By.xpath("//a[contains(@class,'custom-icon')]");
	        WaitUtil.waitForVisibility(driver, assetAndQuizElements, 30);

	        List<WebElement> elements = driver.findElements(assetAndQuizElements);

	        for (int i = 1; i <= elements.size(); i++) {

	            // Build dynamic locator for each element
	            By item = By.xpath("(//a[contains(@class,'custom-icon')])[" + i + "]");

	            try {
	                ElementUtil.clickWithRetry(item, driver, 3);
	                WaitUtil.waitForPageToLoad(driver, 30);

	                if (ElementUtil.isDisplayed(previewclose, driver)) {
	                    ElementUtil.click(previewclose, driver);
	                    WaitUtil.waitForPageToLoad(driver, 30);
	                }
	            } catch (Exception ex) {
	                System.out.println("⚠️ Skipped element " + i + " — " + ex.getMessage());
	            }
	        }
	}

//	private String getTestValueForField(String labelText) {
//
//	    if (labelText.contains("email")) {
//	        return "testautomation@gmail.com";
//	    }
//
//	    if (labelText.contains("mobile") || labelText.contains("phone")) {
//	        return "9999999999";
//	    }
//
//	    // Default test value for any other mandatory text field
//	    return "Test Value";
//	}

	
	public void fillAllMandatoryFieldsWithVerification() throws Exception {
	    final int MAX_RETRIES = 3;
	    final Duration WAIT_TIMEOUT = Duration.ofSeconds(8);
	    final Duration RETRY_SLEEP_MS = Duration.ofMillis(800);

	    WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);

	    // Outer retry loop: try fill+verify up to MAX_RETRIES times
	    for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
	        System.out.println("fillAllMandatoryFieldsWithVerification - attempt " + attempt);

	        // 1) Fill pass
	        List<WebElement> mandatoryAsterisks = driver.findElements(formMandatoryfields);

	        for (WebElement asterisk : mandatoryAsterisks) {
	            // Try to locate the nearest label (asterisk is usually inside a span within the label)
	            WebElement label;
	            try {
	                label = asterisk.findElement(By.xpath("./ancestor::label"));
	            } catch (Exception e) {
	                try {
	                    label = asterisk.findElement(By.xpath("./.."));
	                } catch (Exception ex) {
	                    System.out.println("Could not find label for asterisk — skipping this one.");
	                    continue;
	                }
	            }

	            String labelText = "";
	            try {
	                labelText = label.getText().replace("*", "").trim().toLowerCase();
	            } catch (Exception ignored) {}

	            // Skip email entirely as requested
	            if (labelText.contains("email")) {
	                System.out.println("Skipping email field (always present): " + labelText);
	                continue;
	            }

	            System.out.println("Filling (if empty) mandatory field: " + labelText);

	            // Find container that contains inputs/select/textarea near this label
	            WebElement container = findNearestContainerWithInputs(label);
	            if (container == null) {
	                System.out.println("⚠ Could not find container for label: " + labelText);
	                continue;
	            }

	            // 1A: Text inputs & textarea — fill only if empty
	            try {
	                List<WebElement> textInputs = container.findElements(By.xpath(
	                    ".//input[not(@type) or translate(@type,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')='text' or @type='tel' or @type='number' or @type='email'] | .//textarea"));

	                for (WebElement input : textInputs) {
	                    try {
	                        if (!input.isDisplayed() || !input.isEnabled()) continue;

	                        // skip actual email inputs even if matched (precaution)
	                        String t = "";
	                        try { t = input.getAttribute("type"); } catch (Exception ignored) {}
	                        if (t != null && t.equalsIgnoreCase("email")) {
	                            System.out.println("Skipping <input type='email'> found in container for: " + labelText);
	                            continue;
	                        }

	                        String existing = "";
	                        try { existing = input.getAttribute("value"); } catch (Exception ignored) {}

	                        if (existing == null || existing.trim().isEmpty()) {
	                            String value = getTestValueForField(labelText);
	                            // wait until clickable/visible
	                            wait.until(ExpectedConditions.elementToBeClickable(input));
	                            try {
	                                input.clear();
	                                input.sendKeys(value);
	                            } catch (Exception sendEx) {
	                                // fallback to JS set if sendKeys fails due to hidden overlay
	                                ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", input, value);
	                            }
	                            System.out.println("Filled text input for '" + labelText + "' -> " + value);
	                        } else {
	                            System.out.println("Text input already has value for '" + labelText + "' -> " + existing);
	                        }
	                    } catch (Exception inner) {
	                        // ignore and continue with other inputs
	                    }
	                }
	            } catch (Exception ignored) {}

	            // 1B: selects — choose first non-placeholder option
	            try {
	                List<WebElement> selects = container.findElements(By.xpath(".//select"));
	                for (WebElement select : selects) {
	                    try {
	                        if (!select.isDisplayed() || !select.isEnabled()) continue;
	                        Select s = new Select(select);
	                        String selectedText = "";
	                        try { selectedText = s.getFirstSelectedOption().getText(); } catch (Exception ignored) {}
	                        if (selectedText == null || selectedText.trim().isEmpty()) {
	                            if (s.getOptions().size() > 1) {
	                                s.selectByIndex(1);
	                                System.out.println("Selected option index 1 for select under '" + labelText + "'");
	                            }
	                        } else {
	                            System.out.println("Select already chosen for '" + labelText + "' -> " + selectedText);
	                        }
	                    } catch (Exception ex) {}
	                }
	            } catch (Exception ignored) {}

	            // 1C: radio groups — select first if none selected
	            try {
	                List<WebElement> radios = container.findElements(By.xpath(".//input[@type='radio']"));
	                if (!radios.isEmpty()) {
	                    boolean anySelected = false;
	                    for (WebElement r : radios) {
	                        try { if (r.isSelected()) { anySelected = true; break; } } catch (Exception ignored) {}
	                    }
	                    if (!anySelected) {
	                        for (WebElement r : radios) {
	                            try {
	                                if (r.isDisplayed() && r.isEnabled()) {
	                                    try { wait.until(ExpectedConditions.elementToBeClickable(r)); r.click(); }
	                                    catch (Exception clickEx) {
	                                        // fallback: maybe click the label
	                                        try { r.findElement(By.xpath("./ancestor::label")).click(); } catch (Exception ignored) {}
	                                    }
	                                    System.out.println("Selected radio for '" + labelText + "'");
	                                    break;
	                                }
	                            } catch (Exception ex) {}
	                        }
	                    } else {
	                        System.out.println("Radio already selected for '" + labelText + "'");
	                    }
	                }
	            } catch (Exception ignored) {}

	            // 1D: checkboxes — check first unchecked if none checked
	            try {
	                List<WebElement> checkboxes = container.findElements(By.xpath(".//input[@type='checkbox']"));
	                if (!checkboxes.isEmpty()) {
	                    boolean anyChecked = false;
	                    for (WebElement c : checkboxes) {
	                        try { if (c.isSelected()) { anyChecked = true; break; } } catch (Exception ignored) {}
	                    }
	                    if (!anyChecked) {
	                        for (WebElement c : checkboxes) {
	                            try {
	                                if (c.isDisplayed() && c.isEnabled()) {
	                                    try { wait.until(ExpectedConditions.elementToBeClickable(c)); c.click(); }
	                                    catch (Exception clickEx) {
	                                        try { c.findElement(By.xpath("./ancestor::label")).click(); } catch (Exception ignored) {}
	                                    }
	                                    System.out.println("Checked checkbox for '" + labelText + "'");
	                                    break;
	                                }
	                            } catch (Exception ex) {}
	                        }
	                    } else {
	                        System.out.println("Checkbox already selected for '" + labelText + "'");
	                    }
	                }
	            } catch (Exception ignored) {}
	        } // end filling loop

	        // 2) Verification pass — ensure no mandatory field remains empty/unselected
	        boolean allSatisfied = verifyAllMandatoryFieldsSatisfied(wait);
	        if (allSatisfied) {
	            System.out.println("All mandatory fields satisfied after attempt " + attempt + ". Proceeding to submit.");
	            WaitUtil.waitAndClick(driver, submitform, 40);
	            return; // success - exit method
	        }

	        // if not satisfied, wait a bit and retry (unless last attempt)
	        System.out.println("Verification failed on attempt " + attempt + ". Will retry if attempts remain.");
	        if (attempt < MAX_RETRIES) Thread.sleep(RETRY_SLEEP_MS.toMillis());
	    } // end attempts loop

	    // if we get here, all attempts exhausted and verification still failed
	    throw new RuntimeException("Unable to fill all mandatory fields after retries - aborting submit.");
	}

	// Helper: verify that each mandatory field is satisfied (text has value, or radio checked, etc.)
	private boolean verifyAllMandatoryFieldsSatisfied(WebDriverWait wait) {
	    List<WebElement> mandatoryAsterisks = driver.findElements(formMandatoryfields);

	    for (WebElement asterisk : mandatoryAsterisks) {
	        WebElement label;
	        try { label = asterisk.findElement(By.xpath("./ancestor::label")); }
	        catch (Exception e) { try { label = asterisk.findElement(By.xpath("./..")); } catch (Exception ex) { continue; } }

	        String labelText = "";
	        try { labelText = label.getText().replace("*", "").trim().toLowerCase(); } catch (Exception ignored) {}
	        if (labelText.contains("email")) {
	            // skip email verification per your instruction
	            continue;
	        }

	        WebElement container = findNearestContainerWithInputs(label);
	        if (container == null) {
	            System.out.println("verify: no container for " + labelText + " - treating as unsatisfied");
	            return false;
	        }

	        // check text inputs/textarea presence of value
	        try {
	            List<WebElement> textInputs = container.findElements(By.xpath(
	                ".//input[not(@type) or translate(@type,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')='text' or @type='tel' or @type='number' or @type='email'] | .//textarea"));

	            boolean textSatisfied = true;
	            for (WebElement input : textInputs) {
	                try {
	                    if (!input.isDisplayed()) continue; // ignore hidden inputs
	                    // don't validate email input
	                    String t = "";
	                    try { t = input.getAttribute("type"); } catch (Exception ignored) {}
	                    if (t != null && t.equalsIgnoreCase("email")) continue;

	                    String val = "";
	                    try { val = input.getAttribute("value"); } catch (Exception ignored) {}
	                    if (val == null || val.trim().isEmpty()) {
	                        textSatisfied = false;
	                        break;
	                    }
	                } catch (Exception ex) { textSatisfied = false; break; }
	            }
	            if (!textInputs.isEmpty()) {
	                if (!textSatisfied) {
	                    System.out.println("verify: text input empty in container for " + labelText);
	                    return false;
	                } else {
	                    continue; // satisfied
	                }
	            }
	        } catch (Exception ignored) {}

	        // check selects
	        try {
	            List<WebElement> selects = container.findElements(By.xpath(".//select"));
	            if (!selects.isEmpty()) {
	                for (WebElement select : selects) {
	                    try {
	                        Select s = new Select(select);
	                        String selectedText = "";
	                        try { selectedText = s.getFirstSelectedOption().getText(); } catch (Exception ignored) {}
	                        if (selectedText == null || selectedText.trim().isEmpty()) {
	                            System.out.println("verify: select empty for " + labelText);
	                            return false;
	                        }
	                    } catch (Exception ex) { return false; }
	                }
	                continue;
	            }
	        } catch (Exception ignored) {}

	        // check radio groups
	        try {
	            List<WebElement> radios = container.findElements(By.xpath(".//input[@type='radio']"));
	            if (!radios.isEmpty()) {
	                boolean anySelected = false;
	                for (WebElement r : radios) {
	                    try { if (r.isSelected()) { anySelected = true; break; } } catch (Exception ignored) {}
	                }
	                if (!anySelected) {
	                    System.out.println("verify: no radio selected for " + labelText);
	                    return false;
	                } else {
	                    continue;
	                }
	            }
	        } catch (Exception ignored) {}

	        // check checkboxes
	        try {
	            List<WebElement> checkboxes = container.findElements(By.xpath(".//input[@type='checkbox']"));
	            if (!checkboxes.isEmpty()) {
	                boolean anyChecked = false;
	                for (WebElement c : checkboxes) {
	                    try { if (c.isSelected()) { anyChecked = true; break; } } catch (Exception ignored) {}
	                }
	                if (!anyChecked) {
	                    System.out.println("verify: no checkbox checked for " + labelText);
	                    return false;
	                } else {
	                    continue;
	                }
	            }
	        } catch (Exception ignored) {}

	        // If we reached here and none of the input types matched, treat field as unsatisfied
	        System.out.println("verify: no actionable inputs found under container for " + labelText + " -> UNSATISFIED");
	        return false;
	    }

	    // all mandatory fields checked ok
	    return true;
	}
	    // ---------- Simple mapping of label text to test data ----------
	    private String getTestValueForField(String labelText) {
	        if (labelText == null) return "Test Value";
	        if (labelText.contains("email")) return "testautomation@gmail.com"; // we won't fill email, but keep mapping safe
	        if (labelText.contains("mobile") || labelText.contains("phone")) return "9999999999";
	        if (labelText.contains("name")) return "Test User";
	        if (labelText.contains("company")) return "Test Company";
	        if (labelText.contains("address")) return "123 Test St";
	        if (labelText.contains("zip") || labelText.contains("postal")) return "560001";
	        if (labelText.contains("city")) return "Bengaluru";
	        if (labelText.contains("state")) return "Karnataka";
	        // fallback value
	        return "Test Value";
	    }

	    private WebElement findNearestContainerWithInputs(WebElement start) {
	        WebElement walker = start;

	        // Try climbing up 6 levels max
	        for (int i = 0; i < 6; i++) {
	            try {
	                // If this node contains any input/select/textarea, treat it as container
	                List<WebElement> inputsHere =
	                        walker.findElements(By.xpath(".//input | .//textarea | .//select"));

	                if (inputsHere != null && !inputsHere.isEmpty()) {
	                    return walker;
	                }

	                // Move one level up
	                walker = walker.findElement(By.xpath("./.."));
	            } catch (Exception e) {
	                break;
	            }
	        }

	        // Fallback 1: try the nearest ancestor div
	        try {
	            WebElement parentDiv = start.findElement(By.xpath("./ancestor::div[1]"));
	            List<WebElement> inputsHere =
	                    parentDiv.findElements(By.xpath(".//input | .//textarea | .//select"));

	            if (inputsHere != null && !inputsHere.isEmpty()) {
	                return parentDiv;
	            }
	        } catch (Exception ignored) {}

	        // Fallback 2: try ancestor div 2
	        try {
	            WebElement parentDiv = start.findElement(By.xpath("./ancestor::div[2]"));
	            List<WebElement> inputsHere =
	                    parentDiv.findElements(By.xpath(".//input | .//textarea | .//select"));

	            if (inputsHere != null && !inputsHere.isEmpty()) {
	                return parentDiv;
	            }
	        } catch (Exception ignored) {}

	        // If still nothing found
	        return null;
	    }

	}







	
	