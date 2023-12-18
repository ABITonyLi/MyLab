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

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/userauthorize_page/btn_userauthorize'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/userauthorize_page/a_viewauthorizedcontract'))

//WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/userauthorize_page/input_authorizedcontract_search'), 
//    'autotest_测试签署中')
//WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/userauthorize_page/btn_authorizedcontract_search'))
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/userauthorize_page/div_autotest_测试签署中'), 
    10)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/userauthorize_page/div_autotest签署中'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/userauthorize_page/input_checkall_needtocancel'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/userauthorize_page/btn_cancelauthorized'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/userauthorize_page/btn_cancelconfirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/userauthorize_page/btn_cancelconfirm'))

WebUI.closeBrowser()

'检查被添加用户是否能够查看到'
WebUI.callTestCase(findTestCase('进入签约看板'), [('username') : GlobalVariable.signapprover, ('password') : GlobalVariable.password],
	FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(20)

WebUI.delay(5)

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/input_contract_search'), 'autotest_测试签署中')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/btn_contract_search'))

WebUI.waitForPageLoad(20)

'对表格验证'
table = findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/table_contractlist')

WebUI.switchToFrame(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/iframe__ifm'), 30)

WebUI.delay(2)

TableRows = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableRows'(table, 'tbody')

TableRows_All = TableRows.size()

assert TableRows_All == 1

TableColumns = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableColumns'(TableRows[0], 'td')

assert TableColumns[7].text == ''

WebUI.switchToDefaultContent()

WebUI.clearText(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/input_contract_search'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/input_contract_search'), 'autotest签署中')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/btn_contract_search'))

WebUI.waitForPageLoad(20)

'对表格验证'
table2 = findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/table_contractlist')

WebUI.switchToFrame(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/iframe__ifm'), 30)

WebUI.delay(2)

TableRows2 = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableRows'(table2, 'tbody')

TableRows_All2 = TableRows.size()

assert TableRows_All2 == 1

TableColumns2 = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableColumns'(TableRows2[0], 'td')

assert TableColumns2[7].text == ''

WebUI.switchToDefaultContent()

WebUI.closeBrowser()