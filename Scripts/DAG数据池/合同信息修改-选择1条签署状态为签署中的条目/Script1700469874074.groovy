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

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input_DAG_search'), 'autotest_add_签署中/已签署')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAG_search'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/span_datagrid-row-expand'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/span_datagrid-row-expand'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input__ck-2'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_contractinfomodify'))

var1 = WebUI.verifyElementVisible(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractModify_page/span_isframecontract_yes'), 
    FailureHandling.OPTIONAL)

if (var1 == true) {
    println('之前选择了是,现在修改为否')

    WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractModify_page/radio_isframecontract_no'))
} else {
    println('之前选择了否,现在修改为是')

    WebUI.click(findTestObject('Page_ABI One Process Center/DAGDataPool/ContractModify_page/radio_isframecontract_yes'))
}

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractModify_page/btn_contractmodify_submit'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractModify_page/btn_contractmodify_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/span_mytask'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/span_appliedtask'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/AppliedTask/input_appliedtask_search'), '8994')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/AppliedTask/btn_appliedtask_search'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/AppliedTask/span_searchedcontract'))

WebUI.switchToWindowTitle('合同签署流程')

if (var1 == true) {
    WebUI.verifyElementVisible(findTestObject('Object Repository/Page_ABI One Process Center/Page_ContractSignProcess/span_isframecontract_no_detailpage'))
} else {
    WebUI.verifyElementVisible(findTestObject('Object Repository/Page_ABI One Process Center/Page_ContractSignProcess/span_isframecontract_yes_deatilpage'))
}

WebUI.closeBrowser()

