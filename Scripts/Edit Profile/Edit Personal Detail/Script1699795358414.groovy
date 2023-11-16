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

LoginTestCase = findTestCase('Scenario Login/Login')

button_sidebar_open = findTestObject('Object Repository/Sidebar Element/button_sidebar_open')
button_sidebar_my_info = findTestObject('Object Repository/Sidebar Element/button_my_info')

inputFirstName = findTestObject('Object Repository/My Info Element/Personal Details/input_firstname')
inputMiddleName = findTestObject('Object Repository/My Info Element/Personal Details/input_middlename')
inputLastName = findTestObject('Object Repository/My Info Element/Personal Details/input_lastname')
inputNickName = findTestObject('Object Repository/My Info Element/Personal Details/input_nickname')
selectNationality = findTestObject('Object Repository/My Info Element/Personal Details/select_nationality')
selectOption = findTestObject('Object Repository/My Info Element/Personal Details/select_option')

buttonSavePersonalDetail = findTestObject('Object Repository/My Info Element/Personal Details/button_save_personal_details')

WebUI.callTestCase(LoginTestCase, null)

//try {
//	WebUI.verifyElementPresent(button_sidebar_open, 3)
//	WebUI.click(button_sidebar_open)
//} catch (StepFailedException e) {
//	WebUI.comment("menu sudah terbuka")
//}

WebUI.click(button_sidebar_my_info)
WebUI.delay(3)
WebUI.takeScreenshot()

WebUI.enableSmartWait()

WebUI.sendKeys(inputFirstName, Keys.chord(Keys.CONTROL, "a"))
WebUI.sendKeys(inputFirstName, 'Asep')

WebUI.sendKeys(inputMiddleName, Keys.chord(Keys.CONTROL, "a"))
WebUI.sendKeys(inputMiddleName, 'Kurnia')

WebUI.sendKeys(inputLastName, Keys.chord(Keys.CONTROL, "a"))
WebUI.sendKeys(inputLastName, 'Sanjaya')

WebUI.sendKeys(inputNickName, Keys.chord(Keys.CONTROL, "a"))
WebUI.sendKeys(inputNickName, 'AsepKurniaJaya')

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

// test commit

WebUI.click(buttonSavePersonalDetail)

WebUI.delay(3)
WebUI.closeBrowser()