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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

LoginTestCase = findTestCase('Scenario Login/Login')

button_sidebar_close = findTestObject('Object Repository/Sidebar Element/button_sidebar_close')
button_sidebar_open = findTestObject('Object Repository/Sidebar Element/button_sidebar_open')
button_sidebar_admin = findTestObject('Object Repository/Sidebar Element/button_admin')
button_sidebar_pim = findTestObject('Object Repository/Sidebar Element/button_pim')
button_sidebar_leave = findTestObject('Object Repository/Sidebar Element/button_leave')
button_sidebar_my_info = findTestObject('Object Repository/Sidebar Element/button_my_info')

WebUI.callTestCase(LoginTestCase, null)

if (WebUI.verifyElementVisible(button_sidebar_close)) {
	WebUI.click(button_sidebar_close)
}else {
	WebUI.click(button_sidebar_open)
}

if (WebUI.verifyElementVisible(button_sidebar_open)) {
	WebUI.click(button_sidebar_open)
}else {
	WebUI.click(button_sidebar_close)
}

WebUI.delay(3)

WebUI.click(button_sidebar_my_info)
WebUI.delay(3)
WebUI.takeScreenshot()

WebUI.click(button_sidebar_admin)
WebUI.delay(3)
WebUI.takeScreenshot()

WebUI.click(button_sidebar_pim)
WebUI.delay(3)
WebUI.takeScreenshot()

WebUI.click(button_sidebar_leave)
WebUI.delay(3)
WebUI.takeScreenshot()

WebUI.closeBrowser()