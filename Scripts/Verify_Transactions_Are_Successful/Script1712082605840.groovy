import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

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

WebUI.callTestCase(findTestCase('Verify_Login_RWA'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Transactions/a_New'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Transactions/span_Select Contact'), 0)

WebUI.click(findTestObject('Object Repository/Page_Transactions/span_Darrel Ortiz'))

accountBalance = WebUI.getText(findTestObject('Page_Transactions/AccountBalance'), FailureHandling.STOP_ON_FAILURE)

accountBalance_before = accountBalance.replace('$', "")

accountBalance_before = accountBalance_before.replace(",", "")

println('Amount before requesting the transaction' + accountBalance_before)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Transactions/input_Darrel Ortiz_amount'), 0)

WebUI.setText(findTestObject('Object Repository/Page_Transactions/input_Darrel Ortiz_amount'), '$100')

WebUI.mouseOver(findTestObject('Object Repository/Page_Transactions/input__description'))

WebUI.setText(findTestObject('Object Repository/Page_Transactions/input__description'), 'Test')

WebUI.click(findTestObject('Object Repository/Page_Transactions/button_Request'))

WebUI.click(findTestObject('Object Repository/Page_Transactions/div_Requested 100.00 for Test'))

transactionStatus = WebUI.getText(findTestObject('Object Repository/Page_Transactions/h2_Requested 100.00 for Test'), FailureHandling.STOP_ON_FAILURE)

if (transactionStatus.contains('Requested')) {
    println('Amount is requested successfully')
}

WebUI.click(findTestObject('Page_Transactions/span_Logout'))

WebUI.setText(findTestObject('Page_Transactions/input_Username_username'), 'Dina20')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Transactions/input_Password_password'), '20KCZmjZK/w=')

WebUI.click(findTestObject('Object Repository/Page_Transactions/span_Sign In'))

WebUI.click(findTestObject('Object Repository/Page_Transactions/p_Ted Parisian requested Darrel Ortiz'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Transactions/span_Accept Request'), 0)

WebUI.click(findTestObject('Object Repository/Page_Transactions/span_Accept Request'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Transactions/span_charged'), 'charged')

WebUI.click(findTestObject('Page_Transactions/span_Logout'))

WebUI.setText(findTestObject('Page_Transactions/input_Username_username'), 'Heath93')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Transactions/input_Password_password'), '20KCZmjZK/w=')

WebUI.click(findTestObject('Object Repository/Page_Transactions/span_Sign In'))

accountBalance = WebUI.getText(findTestObject('Object Repository/Page_Transactions/AccountBalance'), FailureHandling.STOP_ON_FAILURE)

accountBalance_after = accountBalance.replace('$', "")

accountBalance_after = accountBalance_after.replace(",", "")

println('Amount after the transaction is accepted: ' + accountBalance_after)

WebUI.verifyGreaterThan(accountBalance_after, accountBalance_before)

//WebUI.verifyElementText(findTestObject('Object Repository/Page_Transactions/AccountBalance'), '$1,609.53')
//WebUI.verifyMatch(accountBalance_before, accountBalance_after, True)

WebUI.click(findTestObject('Page_Transactions/span_Logout'))

WebUI.closeBrowser()

