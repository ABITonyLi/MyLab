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

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/authorizerecord_page/btn_authorizerecord'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/authorizerecord_page/btn_import'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/authorizerecord_page/input_record_search'), 
    'autotest签署中')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/authorizerecord_page/btn_record_search'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/authorizerecord_page/btn_import'))

WebUI.clearText(findTestObject('Page_ABI One Process Center/SignatureBoard/authorizerecord_page/input_record_search'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/authorizerecord_page/input_record_search'), 
    'aaaa')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/authorizerecord_page/btn_record_search'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/authorizerecord_page/btn_import'))

WebUI.closeBrowser()

