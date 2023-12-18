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

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/userauthorize_page/btn_adduser_userauthorize'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/userauthorize_page/input_username_userauthorize'), 
    GlobalVariable.signapprover)

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/userauthorize_page/a_authorizecontract'))

'通过搜索添加合同'
WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/userauthorize_page/input_contract_search'), 
    'autotest_测试签署中')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/userauthorize_page/btn_contract_search'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/userauthorize_page/input__ck_selectcontract_1'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/userauthorize_page/btn_selectcontract_submit'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/userauthorize_page/btn_selectcontract_submit_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/userauthorize_page/a_authorizecontract'))

'通过高级搜索添加合同'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/userauthorize_page/btn_contract_seniorsearch'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/userauthorize_page/input_contract_seniorsearch'), 
    'autotest签署中')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/userauthorize_page/btn_contract_seniorsearch_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/userauthorize_page/input__ck_selectcontract_1'))

WebUI.click(findTestObject('Page_ABI One Process Center/SignatureBoard/userauthorize_page/btn_selectcontract_submit-2'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/userauthorize_page/btn_selectcontract_submit_confirm'))

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
'遍历找到正确的批量发起申请'
int isexist1 = 0
for (int i = 0; i < TableRows_All; i++) {
	TableColumns = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableColumns'(TableRows[i], 'td')
	var_contractname = TableColumns[7].text
	if (var_contractname == 'autotest_测试签署中') {
		isexist1++
	} 
}
assert isexist1 > 0
WebUI.switchToDefaultContent()

WebUI.clearText(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/input_contract_search'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/input_contract_search'), 'autotest签署中')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/btn_contract_search'))

WebUI.waitForPageLoad(20)

'对表格验证'
table = findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/table_contractlist')

WebUI.switchToFrame(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/iframe__ifm'), 30)

WebUI.delay(2)

TableRows = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableRows'(table, 'tbody')

TableRows_All = TableRows.size()
'遍历找到正确的批量发起申请'
int isexist2 = 0
for (int i = 0; i < TableRows_All; i++) {
	TableColumns = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableColumns'(TableRows[i], 'td')
	var_contractname = TableColumns[7].text
	if (var_contractname == 'autotest签署中') {
		isexist2++
	} 
}
assert isexist2 > 0
WebUI.switchToDefaultContent()


//WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/a_contract_autotest1'), FailureHandling.STOP_ON_FAILURE)

//WebUI.waitForPageLoad(20)

WebUI.closeBrowser()
