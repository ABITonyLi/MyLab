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

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/btn_seniorsearch'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/input_contractname_search'), 
    '1条签署中')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/btn_seniorsearch_confirm'))

WebUI.waitForPageLoad(20)

'对表格验证'
table = findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/table_contractlist')

WebUI.switchToFrame(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/iframe__ifm'), 30)

WebUI.delay(2)

TableRows = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableRows'(table, 'tbody')

TableRows_All = TableRows.size()

'断言记录数据数量大于0'
assert TableRows_All > 0

for (int i = 0; i < TableRows_All; i++) {
	TableColumns = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableColumns'(TableRows[i], 'td')

	var_contractname = TableColumns[7].text

	assert var_contractname.contains('1条签署中')
}

WebUI.switchToDefaultContent()
//WebUI.verifyElementText(findTestObject('Object Repository/Page_ABI One Process Center/SignatureBoard/a_contract_autotest1'), 'autotest1条签署中')
WebUI.closeBrowser()