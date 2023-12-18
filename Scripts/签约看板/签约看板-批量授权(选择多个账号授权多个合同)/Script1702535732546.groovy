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

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/input_contract_search'), '签署中')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/btn_contract_search'))

WebUI.waitForPageLoad(20)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/input_checkall'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/batchauthorize_page/btn_batchauthorize'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/batchauthorize_page/btn_adduser'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/batchauthorize_page/input_useraccount'), 
    GlobalVariable.internalconsultuser)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/batchauthorize_page/div_(28070491)(wells.wang1budweiserapac.com)'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/batchauthorize_page/btn_adduser'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/batchauthorize_page/input_username_row2'), 
    GlobalVariable.legal)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/batchauthorize_page/div_(28073485)(wells.wang1budweiserapac.com)'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/batchauthorize_page/btn_batchauthorize_submit'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/batchauthorize_page/btn_batchauthorize_confirm'))

WebUI.closeBrowser()

'验证user1'
WebUI.callTestCase(findTestCase('进入签约看板'), [('username') : GlobalVariable.internalconsultuser, ('password') : GlobalVariable.password],
	FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(20)

WebUI.delay(5)

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/input_contract_search'), '签署中')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/btn_contract_search'))

WebUI.waitForPageLoad(20)

'对表格验证'
table = findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/table_contractlist')

WebUI.switchToFrame(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/iframe__ifm'), 30)

WebUI.delay(2)

TableRows = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableRows'(table, 'tbody')

TableRows_All = TableRows.size()
'遍历找到正确的批量发起申请'
int isexist = 0
for (int i = 0; i < TableRows_All; i++) {
	TableColumns = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableColumns'(TableRows[i], 'td')
	var_contractname = TableColumns[7].text
	if (var_contractname.contains('签署中')) {
		isexist++
	}
}
assert isexist >= 4
WebUI.switchToDefaultContent()
WebUI.closeBrowser()
'验证user2'
WebUI.callTestCase(findTestCase('进入签约看板'), [('username') : GlobalVariable.legal, ('password') : GlobalVariable.password],
	FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(20)

WebUI.delay(5)

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/input_contract_search'), '签署中')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/btn_contract_search'))

WebUI.waitForPageLoad(20)

'对表格验证'
table = findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/table_contractlist')

WebUI.switchToFrame(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/iframe__ifm'), 30)

WebUI.delay(2)

TableRows2 = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableRows'(table, 'tbody')

TableRows_All2 = TableRows2.size()
'遍历找到正确的批量发起申请'
int isexist2 = 0
for (int i = 0; i < TableRows_All2; i++) {
	TableColumns = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableColumns'(TableRows2[i], 'td')
	var_contractname = TableColumns[7].text
	if (var_contractname.contains('签署中')) {
		isexist2++
	}
}
assert isexist2 >= 4
WebUI.switchToDefaultContent()
WebUI.closeBrowser()

'后置处理-取消用户授权'
WebUI.callTestCase(findTestCase('签约看板/ProcessSteps/取消用户授权'), [:], FailureHandling.STOP_ON_FAILURE)