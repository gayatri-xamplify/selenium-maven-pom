package com.stratapps.xamplify.pages;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.stratapps.xamplify.utils.ActionUtil;
import com.stratapps.xamplify.utils.ElementUtil;
import com.stratapps.xamplify.utils.WaitUtil;

public class TeamVendorPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public TeamVendorPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	private By teamMenu = By.xpath("//span[normalize-space()='Team']");
	private By addButton = By
			.xpath("//section[@class='clearfix invite_team_btns d-flex']//span[normalize-space()='Add']");
	private By firstNameField = By.xpath("//input[@id='firstName']");
	private By lastNameField = By.xpath("//input[@name='lastName']");
	private By emailIdField = By.xpath("//input[@name='emailId']");
	private By groupDropdown = By.xpath(
			"//form[@class='form-horizontal form-bordered form-label-stripped ng-untouched ng-pristine ng-valid']//div[4]/div/div/select");
	private By groupDropdowncsv = By.xpath("//*[@id='add-team-member-table']/tbody/tr/td[3]/div/select");
	private By saveButton = By.xpath("//span[normalize-space()='Save']");
	private By inviteButton = By.xpath("//button[normalize-space()='Invite A Team Member']");
	private By inviteEmailField = By.xpath("(//input[@placeholder='Enter email address(es)'])[2]");
	private By inviteSendButton = By.xpath("(//span[contains(text(), 'Send')])[2]");
	private By invitecancel = By.xpath("//div[@id=\"invite_team_member_modal\"]/div/div/div[1]/a/i");
	private By uploadCSVInput = By.xpath("//input[@type='file']");
	private By saveCSVButton = By.xpath("//button[@id='right']");
	private By searchField = By.xpath("(//input[@placeholder='Search'])[1]");
	private By searchIcon = By.xpath("(//button[@class='search-box-item-click']//i[@class='fa fa-search'])[2]");
	private By deleteUploadIcon = By.xpath("//a[@data-placement='bottom']//i[@class='fa fa-trash-o trashIconCustomization']");
	private By exportExcelButton = By.xpath("//button[@class='btn btn-xs  hidden-xs l-g-view']");
	private By refreshButton = By.xpath("//i[contains(@class,'fa fa-refresh')]");
	private By filterButton = By.xpath("(//i[contains(@class,'fa fa-filter')])[2]");
	private By fromDate = By
			.xpath("//div[contains(@class,'open')]//span[@class='flatpickr-day today']/preceding-sibling::span[2]");
	private By toDate = By.xpath("//div[contains(@class,'open')]//span[@class='flatpickr-day today']");
	private By dateField = By.xpath("(//input[@id='flat-picker'])[1]");
	private By toDateField = By.xpath("(//input[@id='flat-picker'])[2]");
	private By applyButton = By.xpath("//button[normalize-space()='Apply']");
	private By filterButton1 =By.xpath("//span/div/a/i[contains(@class,'fa fa-filter')]");
	private By clearFilter = By.xpath("//a[normalize-space()='Clear Filter']");
	private By previewIcon = By.xpath("(//i[@class='fa fa-eye'])[1]");
	private By editIcon = By.xpath("(//i[@class='fa fa-pencil-square-o IconCustomization'])[2]");
	private By updateButton = By.xpath("//span[normalize-space()='Update']");
	private By resendEmailIcon = By.xpath("(//i[@class='fa fa-envelope IconCustomization'])[2]");
	private By yesSendIt = By.xpath("//button[normalize-space()='Yes, send it!']");
	private By deleteIcon = By.xpath("(//i[@class='fa fa-trash-o trashIconCustomization'])[3]");
	private By yesDelete = By.xpath("//button[normalize-space()='Yes, delete it!']");
	private By backdrop = By.cssSelector("div.backdrop");
	private By admins = By.xpath("//strong[contains(text(),'Admins :')]");
	private By closeAdminsPopup = By.xpath("//button[contains(text(),'Close')]");
	private By select_tm=By.xpath("//input[@placeholder='Select Team Members']");
	private By previewclose=By.xpath("//div[@id=\"preview-team-member-popup\"]/div/div/div[3]/button");
	public void hoverTeam() {
		
	}

	public void addTeammember() {
		ActionUtil.hoverAndClick(driver, teamMenu);
		ElementUtil.click(addButton, driver);
		WaitUtil.waitForVisibility(driver, firstNameField, 30);
		ElementUtil.sendText(firstNameField, "Mounika", driver);
		ElementUtil.sendText(lastNameField, "K", driver);
		ElementUtil.sendText(emailIdField, "Oneteam" + System.currentTimeMillis() + "@test.com", driver);
		ElementUtil.click(groupDropdown, driver);
		WaitUtil.waitForVisibility(driver, groupDropdown, 30);
		ElementUtil.selectDropdownByVisibleText(groupDropdown, "Sales Account Manager", driver);

		WaitUtil.waitForPageToLoad(driver, 70);

		// Wait for backdrop (overlay/spinner) to disappear
		WaitUtil.waitForInvisibilityOfElement(backdrop, driver, 60);

		// Wait for the tile to be visible
		WaitUtil.waitForVisibility(driver, saveButton, 60);
		ElementUtil.click(saveButton, driver);

	}

	public void inviteTeammember() {
		WaitUtil.waitForVisibility(driver, inviteButton, 60);
		ElementUtil.click(inviteButton, driver);
		WaitUtil.waitForPageToLoad(driver, 70);
		// Wait for the tile to be visible
		WaitUtil.waitForVisibility(driver, inviteEmailField, 60);
		ElementUtil.sendText(inviteEmailField, "invteam" + System.currentTimeMillis() + "@test.com", driver);
		ElementUtil.click(inviteSendButton, driver);
		// Wait for the tile to be visible
		WaitUtil.waitForVisibility(driver, invitecancel, 60);
		ElementUtil.click(invitecancel, driver);

	}

	public void generateCSV() throws Exception {

		// Define file path and data
		String filePath = "teammemberupload.csv";
		String[][] data = { { "Email Id", "First Name", "Last Name" }, { "cmrtest@gmail.com", "mouni", "ch" },};
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			for (String[] row : data) {
				writer.write(String.join(",", row));
				writer.newLine();
			}
			System.out.println("CSV file generated successfully!");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void testFileUpload() throws Exception {
		// Generate the CSV file first
		generateCSV(); // Call the method to generate the CSV
		Thread.sleep(5000);
		// Get the absolute path of the generated CSV file
		String filePath = new File("teammemberupload.csv").getAbsolutePath();
		driver.findElement(uploadCSVInput).sendKeys(filePath);
		WaitUtil.waitForPageToLoad(driver, 70);
		WaitUtil.waitForElementVisible(driver, groupDropdowncsv, 60);
		ElementUtil.click(groupDropdowncsv, driver);
		ElementUtil.selectDropdownByVisibleText(groupDropdowncsv, "Sales Account Manager", driver);
		ElementUtil.click(saveCSVButton, driver);

	}

	public void searchTeamMember() {
		
		WaitUtil.waitForElementVisible(driver, searchField, 60);
		ElementUtil.sendText(searchField, "cmrtest@gmail.com", driver);
		ElementUtil.click(searchIcon, driver);
	}

	public void deleteSearchedMember() {
		WaitUtil.waitForElementVisible(driver, deleteUploadIcon, 60);
		ElementUtil.click(deleteUploadIcon, driver);
		ElementUtil.click(yesDelete, driver);
		ElementUtil.click(refreshButton, driver);
	}

	public void exportTeamMembers() {
		
		WaitUtil.waitAndClick(driver, exportExcelButton, 60);
		
	}

	public void filterByEmailAndDate(String email) {
		WaitUtil.waitAndClick(driver, refreshButton, 60);
		ElementUtil.click(filterButton, driver);
		WaitUtil.waitAndClick(driver, select_tm, 60);
		ElementUtil.sendKey(select_tm, Keys.ENTER, driver);
		ElementUtil.click(dateField, driver);
		WaitUtil.waitAndClick(driver, fromDate,60 );
		ElementUtil.click(toDateField, driver);
		WaitUtil.waitAndClick(driver, toDate,60 );
		WaitUtil.waitAndClick(driver, applyButton, 60);
		WaitUtil.waitAndClick(driver, filterButton1, 60);
		WaitUtil.waitAndClick(driver, clearFilter, 60);
	}

	public void PreviewTeamMember() {
		
		WaitUtil.waitAndClick(driver, previewIcon, 60);
		WaitUtil.waitAndClick(driver, previewclose, 60);


	}

	public void editTeammember(String editTeammember) {
		WaitUtil.waitAndClick(driver, editIcon,60);
		WaitUtil.waitAndClick(driver, firstNameField, 60);
		ElementUtil.sendText(firstNameField, editTeammember, driver);
		ElementUtil.click(updateButton, driver);
	}

	public void resendEmailNotification() {
		WaitUtil.waitAndClick(driver, resendEmailIcon, 60);
		ElementUtil.click(yesSendIt, driver);
	}

	public void deleteTeammember() {
		WaitUtil.waitAndClick(driver, deleteIcon, 60);
		ElementUtil.click(yesDelete, driver);
	}
	
	public void handleAdminsPopup() {
		WaitUtil.waitAndClick(driver, admins, 60);
		WaitUtil.waitAndClick(driver, closeAdminsPopup, 60);
	}
}
