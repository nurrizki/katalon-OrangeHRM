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

import bsh.StringUtil
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

label_username = findTestObject('Object Repository/Login Element/label_username')
label_password = findTestObject('Object Repository/Login Element/label_password')

input_username = findTestObject('Object Repository/Login Element/input_username')
input_password = findTestObject('Object Repository/Login Element/input_password')
button_login = findTestObject('Object Repository/Login Element/button_login')

WebUI.openBrowser(GlobalVariable.url_login)
//WebUI.maximizeWindow()

WebUI.enableSmartWait()

String username = WebUI.getText(label_username)
username = username.substring(username.indexOf(": ")+2, username.length())
String password = WebUI.getText(label_password)
password = password.substring(password.indexOf(": ")+2, password.length())

WebUI.setText(input_username, username)
WebUI.setText(input_password, password)
WebUI.delay(3)
WebUI.takeScreenshot(GlobalVariable.path_screenshot + GlobalVariable.screenshot_counter +'.png')
GlobalVariable.screenshot_counter++

WebUI.click(button_login)

WebUI.enableSmartWait()
WebUI.delay(3)

//WebUI.closeBrowser()