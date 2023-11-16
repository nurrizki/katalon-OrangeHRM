import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.helper.screenshot.WebUIScreenCaptor
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.exception.StepFailedException
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

LoginTestCase = findTestCase('Scenario Login/Login')

button_sidebar_open = findTestObject('Object Repository/Sidebar Element/button_sidebar_open')
button_sidebar_my_info = findTestObject('Object Repository/Sidebar Element/button_my_info')

inputFirstName = findTestObject('Object Repository/My Info Element/Personal Details/input_firstname')
inputMiddleName = findTestObject('Object Repository/My Info Element/Personal Details/input_middlename')
inputLastName = findTestObject('Object Repository/My Info Element/Personal Details/input_lastname')
inputNickName = findTestObject('Object Repository/My Info Element/Personal Details/input_nickname')
inputEmployeeId = findTestObject('Object Repository/My Info Element/Personal Details/input_employee_id')
inputOtherId = findTestObject('Object Repository/My Info Element/Personal Details/input_other_id')
inputDriverLicense = findTestObject('Object Repository/My Info Element/Personal Details/input_driver_license')
inputLicenseExpiry = findTestObject('Object Repository/My Info Element/Personal Details/input_license_expiry')
inputSSNNumber = findTestObject('Object Repository/My Info Element/Personal Details/input_ssn_number')
inputSINNumber = findTestObject('Object Repository/My Info Element/Personal Details/input_sin_number')
selectNationality = findTestObject('Object Repository/My Info Element/Personal Details/select_nationality')
selectMartialStatus = findTestObject('Object Repository/My Info Element/Personal Details/select_martial_status')
selectBloodType = findTestObject('Object Repository/My Info Element/Personal Details/select_blood_type')
selectOption = findTestObject('Object Repository/My Info Element/Personal Details/select_option')
inputDOB = findTestObject('Object Repository/My Info Element/Personal Details/input_DOB')
radioGenderMale = findTestObject('Object Repository/My Info Element/Personal Details/radio_gender_male')
inputMilitaryService = findTestObject('Object Repository/My Info Element/Personal Details/input_military_service')
checkBoxSmoker = findTestObject('Object Repository/My Info Element/Personal Details/check_box_smoker')
buttonSavePersonalDetail = findTestObject('Object Repository/My Info Element/Personal Details/button_save_personal_details')
buttonSaveCustomField = findTestObject('Object Repository/My Info Element/Personal Details/button_save_custom_fields')

GlobalVariable.path_screenshot = 'Screenshot/My Info/Personal Detail/Positive Scenario/'
string pathScreenshot = GlobalVariable.path_screenshot
WebUI.callTestCase(LoginTestCase, null)

//try {
//	WebUI.verifyElementPresent(button_sidebar_open, 3)
//	WebUI.click(button_sidebar_open)
//} catch (StepFailedException e) {
//	WebUI.comment("menu sudah terbuka")
//}

WebUI.click(button_sidebar_my_info)
WebUI.delay(3)
WebUI.takeScreenshot(pathScreenshot + GlobalVariable.screenshot_counter +'.png')
GlobalVariable.screenshot_counter++

WebUI.enableSmartWait()

WebUI.sendKeys(inputFirstName, Keys.chord(Keys.CONTROL, "a"))
WebUI.sendKeys(inputFirstName, 'Asep')

WebUI.sendKeys(inputMiddleName, Keys.chord(Keys.CONTROL, "a"))
WebUI.sendKeys(inputMiddleName, 'Kurnia')

WebUI.sendKeys(inputLastName, Keys.chord(Keys.CONTROL, "a"))
WebUI.sendKeys(inputLastName, 'Sanjaya')

WebUI.sendKeys(inputNickName, Keys.chord(Keys.CONTROL, "a"))
WebUI.sendKeys(inputNickName, 'AsepKurniaJaya')

WebUI.sendKeys(inputEmployeeId, Keys.chord(Keys.CONTROL, "a"))
WebUI.sendKeys(inputEmployeeId, '2514')

WebUI.sendKeys(inputOtherId, Keys.chord(Keys.CONTROL, "a"))
WebUI.sendKeys(inputOtherId, '2313')

WebUI.sendKeys(inputDriverLicense, Keys.chord(Keys.CONTROL, "a"))
WebUI.sendKeys(inputDriverLicense, '123456789')

WebUI.sendKeys(inputLicenseExpiry, Keys.chord(Keys.CONTROL, "a"))
WebUI.sendKeys(inputLicenseExpiry, '2024-04-05')

WebUI.sendKeys(inputSSNNumber, Keys.chord(Keys.CONTROL, "a"))
WebUI.sendKeys(inputSSNNumber, '1234567898654321')

WebUI.sendKeys(inputSINNumber, Keys.chord(Keys.CONTROL, "a"))
WebUI.sendKeys(inputSINNumber, '1234567898654321')

WebUI.click(selectNationality)
WebUI.delay(1)
List<WebElement> childDivs = WebUI.findWebElements(selectOption, 3)
int numberOfChildDivs = childDivs.size()

println("Jumlah div di dalam parent div: " + numberOfChildDivs)

//for (WebElement childDiv : childDivs) {
//    // Dapatkan teks dari setiap child div
//    String divText = childDiv.getText().trim()
//	
//	println(divText)
//    // Jika teksnya adalah "Indonesian", klik elemen tersebut
//    if (divText.equals("Indonesian")) {
//        
//        break // Hentikan loop setelah menemukan elemen yang sesuai
//    }
//}

for (int i = 1; i <= numberOfChildDivs; i++) {
	if(childDivs[i].getText() == 'Indonesian') {
		childDivs[i].click()
		break
	}
}

WebUI.click(selectMartialStatus)
WebUI.delay(1)
List<WebElement> childDivMartial = WebUI.findWebElements(selectOption, 3)
numberOfChildDivs = childDivMartial.size()
for (int i = 1; i <= numberOfChildDivs; i++) {
	if(childDivMartial[i].getText() == 'Single') {
		childDivMartial[i].click()
		break
	}
}

WebUI.sendKeys(inputDOB, Keys.chord(Keys.CONTROL, "a"))
WebUI.sendKeys(inputDOB, '1999-07-22')

WebUI.click(radioGenderMale)

WebUI.sendKeys(inputMilitaryService, Keys.chord(Keys.CONTROL, "a"))
WebUI.sendKeys(inputMilitaryService, '-')

if (WebUI.verifyElementChecked(checkBoxSmoker, 3)) {
	WS.comment("Perokok")
}else {
	WS.comment("Bukan Perokok")
}

WebUI.click(buttonSavePersonalDetail)
WebUI.waitForElementClickable(buttonSavePersonalDetail, 10)
WebUI.delay(3)
WebUI.takeScreenshot(pathScreenshot + GlobalVariable.screenshot_counter +'.png')
GlobalVariable.screenshot_counter++

WebUI.click(selectBloodType)
WebUI.delay(1)
List<WebElement> childDivBlood = WebUI.findWebElements(selectOption, 3)
numberOfChildDivs = childDivBlood.size()
for (int i = 1; i <= numberOfChildDivs; i++) {
	if(childDivBlood[i].getText() == 'O+') {
		childDivBlood[i].click()
		break
	}
}

WebUI.click(buttonSaveCustomField)

WebUI.delay(3)
WebUI.takeScreenshot()

WebUI.delay(3)
WebUI.closeBrowser()