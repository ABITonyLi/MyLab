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

WebUI.callTestCase(findTestCase('进入签约看板'), [('username') : GlobalVariable.username, ('password') : GlobalVariable.password], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(20)

WebUI.delay(5)

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/input_contract_search'), 'autotest_测试签署中')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/btn_contract_search'))

WebUI.waitForPageLoad(20)

WebUI.waitForElementClickable(findTestObject('Page_ABI One Process Center/SignatureBoard/input__ck'), 10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/input__ck'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/batchauthorize_page/btn_batchauthorize'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/batchauthorize_page/btn_adduser'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/batchauthorize_page/input_useraccount'), 
    GlobalVariable.internalconsultuser)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/batchauthorize_page/div_(28070491)(wells.wang1budweiserapac.com)'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/batchauthorize_page/btn_adduser'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/batchauthorize_page/input_username_row2'), 
    GlobalVariable.legal)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/batchauthorize_page/div_(28073485)(wells.wang1budweiserapac.com)'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/batchauthorize_page/input_checkbox_all'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/batchauthorize_page/btn_deleteuser'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/batchauthorize_page/tip_plzcheckuser'), 
    5)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/batchauthorize_page/btn_plzcheckuser_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/batchauthorize_page/input__ck-2'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/batchauthorize_page/btn_deleteuser'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/batchauthorize_page/div_content'), 
    '显示1到1,共1记录')

WebUI.closeBrowser()

