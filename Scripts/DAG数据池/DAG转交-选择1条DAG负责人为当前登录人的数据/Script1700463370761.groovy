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

WebUI.callTestCase(findTestCase('进入DAG数据池(批量)'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input_DAG_search'),
	10)

'DAG数据负责人本人'
WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input_DAG_search'), 'autotest_add_转交')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAG_search'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input__cb'), 10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input__cb'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAGtransfer'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAGtransfer_page/btn_DAGtransfer_user_select'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAGtransfer_page/input_DAGtransfer_user_search'),
	10)

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAGtransfer_page/input_DAGtransfer_user_search'),
	GlobalVariable.DAGusername)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAGtransfer_page/btn_DAGtransfer_user_search'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAGtransfer_page/input__chk'),
	10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAGtransfer_page/input__chk'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAGtransfer_page/btn_DAGtransfer_user_select_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAGtransfer_page/btn_DAGtransfer_submit'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAGtransfer_page/btn_DAGtransfer_confirm'))

'对表格验证'
table = findTestObject('Page_ABI One Process Center/DAGDataPool/table_DAGlist')

WebUI.switchToFrame(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/iframe__ifm'), 30)

TableRows = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableRows'(table, 'tbody')

TableRows_All = TableRows.size()

'断言记录数据数量大于0'
assert TableRows_All > 0

TableColumns = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableColumns'(TableRows[0], 'td')

DAG_user = TableColumns[7].text

assert DAG_user == '陈正华'

WebUI.callTestCase(findTestCase('进入DAG数据池(批量)'), [('password') : GlobalVariable.password, ('username') : GlobalVariable.DAGusername], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input_DAG_search'), 
    10)

'DAG数据负责人本人'
WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input_DAG_search'), 'autotest_add_转交')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAG_search'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input__cb'), 10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input__cb'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAGtransfer'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAGtransfer_page/btn_DAGtransfer_user_select'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAGtransfer_page/input_DAGtransfer_user_search'),
	10)

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAGtransfer_page/input_DAGtransfer_user_search'), 
    GlobalVariable.username)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAGtransfer_page/btn_DAGtransfer_user_search'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAGtransfer_page/input__chk'),
	10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAGtransfer_page/input__chk'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAGtransfer_page/btn_DAGtransfer_user_select_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAGtransfer_page/btn_DAGtransfer_submit'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAGtransfer_page/btn_DAGtransfer_confirm'))

WebUI.closeBrowser()