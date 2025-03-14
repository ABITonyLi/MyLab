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

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input_DAG_search'), 'auotest_add_fortesting')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAG_search'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/span_datagrid-row-expand'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/span_datagrid-row-expand'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input__ck-1'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input__ck-2'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_batchcontract'))

WebUI.switchToWindowTitle('合同签署流程')

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input_batchcontract_search'), 
    '003')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_batchcontract_search'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_batchcontract_delele'))

WebUI.verifyElementPresent(findTestObject('Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/tip_batchcontract_delete'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_batchcontract_delete_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_batchcontract_delete_confirm'))

WebUI.closeBrowser()

