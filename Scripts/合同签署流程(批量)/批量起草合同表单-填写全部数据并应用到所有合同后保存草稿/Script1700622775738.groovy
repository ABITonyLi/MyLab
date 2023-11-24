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

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input_DAG_search'), 'autotest_add_批量测试')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAG_search'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/span_datagrid-row-expand'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/span_datagrid-row-expand'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input__ck-1'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input__ck-2'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_batchcontract'))

var_confirmbtn = WebUI.waitForElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/tip_existingdraftbox'), 
    5)

if (var_confirmbtn == true) {
    '确定'
    WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_existingdraftcontract_confirm'))
}

WebUI.switchToWindowTitle('合同签署流程')

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input_batchcontractname'), 
    '测试批量发起-草稿')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_selecttemplate'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input_selecttemplate_search'), 
    10)

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input_selecttemplate_search'), 
    'autotest')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_selecttemplate_search'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/div_autotestV1.0.docx'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_selecttemplate_search_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_applyall_1'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/tip_applysuccess'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_tip_applysuccess_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_applyall_2'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/tip_applysuccess'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_tip_applysuccess_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_applyall_5'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/tip_applysuccess'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_tip_applysuccess_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_applyall_3'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/tip_othercontractwillreplace'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_tip_applysuccess_confirm'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/tip_applysuccess'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_tip_applysuccess_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_applyall_4'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/tip_checkattachment'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_tip_applysuccess_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/td_contract_row2'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/alert_savesuccess'), 
    10)

long currenttimestamp = System.currentTimeMillis() / 1000

println(currenttimestamp)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_batchcontract_save'))

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input_batchsummary'), 
    'value', 'autotest_add_批量测试', 10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/span_batchcontract_submit'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_save_confirm'))

WebUI.switchToWindowTitle('ABI One Process Center')

WebUI.click(findTestObject('Page_ABI One Process Center/span_mytask'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DraftBox/span_draft'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DraftBox/input_draft_search'), 'autotest_add_批量测试')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DraftBox/btn_draft_search'))

'对表格验证'
table = findTestObject('Object Repository/Page_ABI One Process Center/DraftBox/table_draftlist')

WebUI.switchToFrame(findTestObject('Page_ABI One Process Center/DraftBox/iframe_concat(id(, , CGXFram, , ))_CGXFram'), 30)

TableRows = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableRows'(table, 'tbody')

TableRows_All = TableRows.size()

'断言记录数据数量大于0'
assert TableRows_All > 0

TableColumns = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableColumns'(TableRows[0], 'td')

savetime = CustomKeywords.'util.TimeConversion.StringToTimestamp'(TableColumns[6].text)

println(savetime)

assert savetime >= currenttimestamp

WebUI.closeBrowser()

