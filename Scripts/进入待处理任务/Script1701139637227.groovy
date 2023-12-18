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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://mobiletestbpm.ab-inbev.cn/DASPortal/Login/Page/Login.aspx')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/Page_Login/input_username'), username)

WebUI.setText(findTestObject('Object Repository/Page_Login/input_password'), password)

'提交'
WebUI.click(findTestObject('Object Repository/Page_Login/btn_submit'))

var_confirmbtn = WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Login/btn_tip_yes'), 5)

if (var_confirmbtn == true) {
    '确定'
    WebUI.click(findTestObject('Object Repository/Page_Login/btn_tip_yes'))
}

'合同管理'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/span_contractmanagement'))

'我的任务'
WebUI.click(findTestObject('Page_ABI One Process Center/span_mytask'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/span_needtodotask'))

